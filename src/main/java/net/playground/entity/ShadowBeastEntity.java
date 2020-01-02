package net.playground.entity;

import java.util.EnumSet;
import java.util.UUID;

import blue.endless.jankson.annotation.Nullable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.playground.registry.PlaygroundSounds;

public class ShadowBeastEntity extends HostileEntity {
    private static final UUID ATTACKING_SPEED_BOOST_UUID = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
    private static final EntityAttributeModifier ATTACKING_SPEED_BOOST;

    public ShadowBeastEntity(EntityType<? extends HostileEntity> type, World world) {
        super(type, world);
        this.setPathfindingPenalty(PathNodeType.LAVA, -1.0F);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.15D);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
        this.getAttributeInstance(EntityAttributes.FOLLOW_RANGE).setBaseValue(64.0D);
        this.getAttributeInstance(EntityAttributes.ATTACK_KNOCKBACK).setBaseValue(5.0D);
        this.isFireImmune();
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new ShadowBeastEntity.ChasePlayerGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0D, 0.0F));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new ShadowBeastEntity.TargetPlayerGoal(this));
        this.targetSelector.add(2, new RevengeGoal(this, new Class[0]));
    }

    @Override
    public void tickMovement() {
        if (this.world.isClient) {
           for(int i = 0; i < 2; ++i) {
              this.world.addParticle(ParticleTypes.LARGE_SMOKE, this.getParticleX(0.3D), this.getRandomBodyY(), this.getParticleZ(0.3D), 0.0D, 0.0D, 0.0D);
           }
        }
        super.tickMovement();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return PlaygroundSounds.SHADOW_CREATURE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return PlaygroundSounds.SHADOW_CREATURE_DEATH;
    }

    @Override
    public void setTarget(@Nullable LivingEntity target) {
        super.setTarget(target);
        EntityAttributeInstance entityAttributeInstance = this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED);
        if (target == null) {
            entityAttributeInstance.removeModifier(ATTACKING_SPEED_BOOST);
        } else if (!entityAttributeInstance.hasModifier(ATTACKING_SPEED_BOOST)) {
            entityAttributeInstance.addModifier(ATTACKING_SPEED_BOOST);
        }
    }

    private boolean isPlayerStaring(PlayerEntity player) {
        Vec3d vec3d = player.getRotationVec(1.0F).normalize();
        Vec3d vec3d2 = new Vec3d(this.getX() - player.getX(), this.getEyeY() - player.getEyeY(), this.getZ() - player.getZ());
        double d = vec3d2.length();
        vec3d2 = vec3d2.normalize();
        double e = vec3d.dotProduct(vec3d2);
        return e > 1.0D - 0.025D / d ? player.canSee(this) : false;
    }

    static class ChasePlayerGoal extends Goal {
        private final ShadowBeastEntity shadow;
        private LivingEntity entity;
  
        public ChasePlayerGoal(ShadowBeastEntity shadow) {
           this.shadow = shadow;
           this.setControls(EnumSet.of(Goal.Control.JUMP, Goal.Control.MOVE));
        }
  
        public boolean canStart() {
            this.entity = this.shadow.getTarget();
            if (!(this.entity instanceof PlayerEntity)) {
                return false;
            } else {
                double d = this.entity.squaredDistanceTo(this.shadow);
                return d > 256.0D ? false : this.shadow.isPlayerStaring((PlayerEntity)this.entity);
            }
        }

        public void start() {
            this.shadow.getNavigation().stop();
        }
   
        public void tick() {
            this.shadow.getLookControl().lookAt(this.entity.getX(), this.entity.getEyeY(), this.entity.getZ());
        }
    }

    static {
        ATTACKING_SPEED_BOOST = (new EntityAttributeModifier(ATTACKING_SPEED_BOOST_UUID, "Attacking speed boost", 0.10D, EntityAttributeModifier.Operation.ADDITION)).setSerialize(false);
    }

    static class TargetPlayerGoal extends FollowTargetGoal<PlayerEntity> {
        private final ShadowBeastEntity shadow;
        private PlayerEntity targetPlayer;
        private int lookAtPlayerWarmup;
        private final TargetPredicate staringPlayerPredicate;
        private final TargetPredicate validTargetPredicate = (new TargetPredicate()).includeHidden();
  
        public TargetPlayerGoal(ShadowBeastEntity shadow) {
            super(shadow, PlayerEntity.class, false);
            this.shadow = shadow;
            this.staringPlayerPredicate = (new TargetPredicate()).setBaseMaxDistance(this.getFollowRange()).setPredicate((playerEntity) -> {
                return shadow.isPlayerStaring((PlayerEntity)playerEntity);
            });
        }
  
        public boolean canStart() {
            this.targetPlayer = this.shadow.world.getClosestPlayer(this.staringPlayerPredicate, this.shadow);
            return this.targetPlayer != null;
        }
  
        public void start() {
            this.lookAtPlayerWarmup = 5;
        }
  
        public void stop() {
            this.targetPlayer = null;
            super.stop();
        }
  
        public boolean shouldContinue() { 
            if (this.targetPlayer != null) {
                if (!this.shadow.isPlayerStaring(this.targetPlayer)) {
                    return true;
                } else {
                    this.shadow.lookAtEntity(this.targetPlayer, 10.0F, 10.0F);
                    return true;
                }
            } else {
                return this.targetEntity != null && this.validTargetPredicate.test(this.shadow, this.targetEntity) ? true : super.shouldContinue();
            }
        }
  
        public void tick() {
            if (this.targetPlayer != null) {
                if (--this.lookAtPlayerWarmup <= 0) {
                    this.targetEntity = this.targetPlayer;
                    this.targetPlayer = null;
                    super.start();
                }
            } else {
                super.tick();
            }
        }
    }
}