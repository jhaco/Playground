package net.playground.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import net.playground.registry.PlaygroundSounds;

public class AbyssalZombieEntity extends ZombieEntity {
    public AbyssalZombieEntity(EntityType<? extends AbyssalZombieEntity> type, World world) {
		super(type, world);
	}
    
    @Override
	protected void initAttributes() {
		super.initAttributes();
		this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
		this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
		this.getAttributeInstance(EntityAttributes.ARMOR).setBaseValue(3.0D);
		this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(48.0D);
    }

    @Override
	protected boolean canConvertInWater() {
		return false;
	}

	@Override
    protected SoundEvent getAmbientSound() {
        return PlaygroundSounds.ABYSSAL_ZOMBIE_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return PlaygroundSounds.ABYSSAL_ZOMBIE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return PlaygroundSounds.ABYSSAL_ZOMBIE_DEATH;
    }
}