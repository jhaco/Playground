package net.playground.client.render;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.playground.Playground;
import net.playground.client.model.ShadowBeastEntityModel;
import net.playground.entity.ShadowBeastEntity;

public class ShadowBeastEntityRenderer extends MobEntityRenderer<ShadowBeastEntity, ShadowBeastEntityModel> {
    private static final Identifier SKIN = Playground.id("textures/entity/shadow_beast.png");
	
	public ShadowBeastEntityRenderer(EntityRenderDispatcher dispatcher) {
		super(dispatcher, new ShadowBeastEntityModel(), 0.0F);
	}
	
	@Override
	public Identifier getTexture(ShadowBeastEntity shadow) {
		return SKIN;
	}
}