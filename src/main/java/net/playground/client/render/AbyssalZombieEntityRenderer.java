package net.playground.client.render;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.ZombieEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.util.Identifier;
import net.playground.Playground;

public class AbyssalZombieEntityRenderer extends ZombieEntityRenderer {
	private static final Identifier SKIN = Playground.id("textures/entity/abyssal_zombie.png");
	
	public AbyssalZombieEntityRenderer(EntityRenderDispatcher erd) {
		super(erd);
	}
    
    @Override
	protected void scale(ZombieEntity entity, MatrixStack matrixStack, float f1) {
		super.scale(entity, matrixStack, f1 * 1.2f);
    }
    
	@Override
	public Identifier getTexture(ZombieEntity entity) {
		return SKIN;
	}
}