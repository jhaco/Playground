package net.playground.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class ShadowMonsterEntity extends ShadowCreatureEntity {

    public ShadowMonsterEntity(EntityType<? extends HostileEntity> type, World world) {
        super(type, world);
        this.setPathfindingPenalty(PathNodeType.LAVA, -1.0F);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
    }
    
    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
        this.getAttributeInstance(EntityAttributes.FOLLOW_RANGE).setBaseValue(64.0D);
        this.isFireImmune();
    }
}