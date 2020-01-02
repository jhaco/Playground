package net.playground.client.render;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.playground.Playground;
import net.playground.client.model.ShadowCreatureEntityModel;
import net.playground.entity.ShadowCreatureEntity;

public class ShadowCreatureEntityRenderer extends MobEntityRenderer<ShadowCreatureEntity, ShadowCreatureEntityModel> {
	private static final Identifier SKIN = Playground.id("textures/entity/shadow_creature.png");
	
	public ShadowCreatureEntityRenderer(EntityRenderDispatcher dispatcher) {
		super(dispatcher, new ShadowCreatureEntityModel(), 0.0F);
	}
	
	@Override
	public Identifier getTexture(ShadowCreatureEntity shadow) {
		return SKIN;
	}
}