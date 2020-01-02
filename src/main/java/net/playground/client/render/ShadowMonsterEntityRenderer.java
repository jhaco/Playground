package net.playground.client.render;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.playground.Playground;
import net.playground.client.model.ShadowMonsterEntityModel;
import net.playground.entity.ShadowMonsterEntity;

public class ShadowMonsterEntityRenderer extends MobEntityRenderer<ShadowMonsterEntity, ShadowMonsterEntityModel> {
	private static final Identifier SKIN = Playground.id("textures/entity/shadow_monster.png");
	
	public ShadowMonsterEntityRenderer(EntityRenderDispatcher dispatcher) {
		super(dispatcher, new ShadowMonsterEntityModel(), 0.0F);
	}
	
	@Override
	public Identifier getTexture(ShadowMonsterEntity shadow) {
		return SKIN;
	}
}