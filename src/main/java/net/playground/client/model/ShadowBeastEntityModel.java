package net.playground.client.model;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.ModelWithHead;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.playground.entity.ShadowBeastEntity;

@Environment(EnvType.CLIENT)
public class ShadowBeastEntityModel extends EntityModel<ShadowBeastEntity> implements ModelWithHead {
    private final ModelPart head;
	private final ModelPart btooth1;
	private final ModelPart btooth2;
	private final ModelPart btooth3;
	private final ModelPart btooth4;
	private final ModelPart btooth5;
	private final ModelPart jaw;
	private final ModelPart stooth1;
	private final ModelPart stooth2;
	private final ModelPart stooth3;
	private final ModelPart stooth4;
	private final ModelPart spine;
	private final ModelPart leftshoulder;
	private final ModelPart lsspike;
    private final ModelPart larm1;
    private final ModelPart larm2;
	private final ModelPart laspike1;
	private final ModelPart laspike2;
	private final ModelPart lfinger1;
	private final ModelPart lfinger3;
	private final ModelPart lfinger2;
	private final ModelPart lfinger4;
	private final ModelPart rightshoulder;
	private final ModelPart rsspike;
    private final ModelPart rarm1;
    private final ModelPart rarm2;
	private final ModelPart raspike1;
	private final ModelPart raspike2;
	private final ModelPart rfinger1;
	private final ModelPart rfinger2;
	private final ModelPart rfinger3;
	private final ModelPart rfinger4;
	private final ModelPart pelvis;
	private final ModelPart leftleg;
    private final ModelPart rightleg;
    
    public ShadowBeastEntityModel() {
        textureWidth = 128;
		textureHeight = 64;

		head = new ModelPart(this, 0, 0);
		head.addCuboid(-4.5F, -9F, -4.5F, 9, 9, 9, 0.0F, true);
		head.setPivot(0F, -13F, -1F);
		head.setTextureSize(128, 64);
		head.mirror = true;
        setRotationAngle(head, 0F, 0F, 0F);
        
		btooth1 = new ModelPart(this, 37, 4);
		btooth1.addCuboid(0F, 0F, 0F, 1, 2, 1, 0.0F, true);
		btooth1.setPivot(-4.5F, 0F, -4.5F);
		btooth1.setTextureSize(128, 64);
		btooth1.mirror = true;
        setRotationAngle(btooth1, 0F, 0F, 0F);
        head.addChild(btooth1);

		btooth2 = new ModelPart(this, 37, 4);
		btooth2.addCuboid(0F, 0F, 0F, 1, 2, 1, 0.0F, true);
		btooth2.setPivot(-2.5F, 0F, -4.5F);
		btooth2.setTextureSize(128, 64);
		btooth2.mirror = true;
		setRotationAngle(btooth2, 0F, 0F, 0F);
        head.addChild(btooth2);
        
		btooth3 = new ModelPart(this, 37, 4);
		btooth3.addCuboid(0F, 0F, 0F, 1, 2, 1, 0.0F, true);
		btooth3.setPivot(-0.5F, 0F, -4.5F);
		btooth3.setTextureSize(128, 64);
		btooth3.mirror = true;
		setRotationAngle(btooth3, 0F, 0F, 0F);
        head.addChild(btooth3);
        
		btooth4 = new ModelPart(this, 37, 4);
		btooth4.addCuboid(0F, 0F, 0F, 1, 2, 1, 0.0F, true);
		btooth4.setPivot(1.5F, 0F, -4.5F);
		btooth4.setTextureSize(128, 64);
		btooth4.mirror = true;
		setRotationAngle(btooth4, 0F, 0F, 0F);
        head.addChild(btooth4);
        
		btooth5 = new ModelPart(this, 37, 4);
		btooth5.addCuboid(0F, 0F, 0F, 1, 2, 1, 0.0F, true);
		btooth5.setPivot(3.5F, 0F, -4.5F);
		btooth5.setTextureSize(128, 64);
		btooth5.mirror = true;
		setRotationAngle(btooth5, 0F, 0F, 0F);
        head.addChild(btooth5);
        
		jaw = new ModelPart(this, 36, 0);
		jaw.addCuboid(-4.5F, 1.9F, -5F, 9, 1, 9, 0.0F, true);
		jaw.setPivot(0,0,0);
		jaw.setTextureSize(128, 64);
		jaw.mirror = true;
		setRotationAngle(jaw, 0.4461433F, 0F, 0F);
        head.addChild(jaw);
        
		stooth1 = new ModelPart(this, 37, 4);
		stooth1.addCuboid(0F, 0F, 0F, 1, 1, 1, 0.0F, true);
		stooth1.setPivot(-3.5F, 0.9F, -5F);
		stooth1.setTextureSize(128, 64);
		stooth1.mirror = true;
		setRotationAngle(stooth1, 0, 0F, 0F);
        jaw.addChild(stooth1);
        
		stooth2 = new ModelPart(this, 37, 4);
		stooth2.addCuboid(0F, 0F, 0F, 1, 1, 1, 0.0F, true);
		stooth2.setPivot(-1.5F, 0.9F, -5F);
		stooth2.setTextureSize(128, 64);
		stooth2.mirror = true;
		setRotationAngle(stooth2, 0, 0F, 0F);
        jaw.addChild(stooth2);
        
		stooth3 = new ModelPart(this, 37, 4);
		stooth3.addCuboid(0F, 0F, 0F, 1, 1, 1, 0.0F, true);
		stooth3.setPivot(0.5F, 0.9F, -5F);
		stooth3.setTextureSize(128, 64);
		stooth3.mirror = true;
		setRotationAngle(stooth3, 0, 0F, 0F);
        jaw.addChild(stooth3);
        
		stooth4 = new ModelPart(this, 37, 4);
		stooth4.addCuboid(0F, 0F, 0F, 1, 1, 1, 0.0F, true);
		stooth4.setPivot(2.5F, 0.9F, -5F);
		stooth4.setTextureSize(128, 64);
		stooth4.mirror = true;
		setRotationAngle(stooth4, 0, 0F, 0F);
        jaw.addChild(stooth4);
        
		spine = new ModelPart(this, 72, 0);
		spine.addCuboid(-2.5F, 0F, -2.5F, 5, 20, 5, 0.0F, true);
		spine.setPivot(0F, -12F, -1F);
		spine.setTextureSize(128, 64);
		spine.mirror = true;
        setRotationAngle(spine, 0.2974289F, 0F, 0F);
        
		leftshoulder = new ModelPart(this, 41, 11);
		leftshoulder.addCuboid(-8F, 0F, 0F, 8, 5, 7, 0.0F, true);
		leftshoulder.setPivot(9.5F, -8F, -3F);
		leftshoulder.setTextureSize(128, 64);
        leftshoulder.mirror = true;
        setRotationAngle(leftshoulder, 0F, 0F, 0.111544F);
        
		lsspike = new ModelPart(this, 0, 0);
		lsspike.addCuboid(0F, -4F, 0F, 1, 5, 1, 0.0F, true);
		lsspike.setPivot(7F, -9F, 0F);
		lsspike.setTextureSize(128, 64);
		lsspike.mirror = true;
        setRotationAngle(lsspike, 0F, 0F, 0.111544F);
        
		larm1 = new ModelPart(this, 0, 19);
		larm1.addCuboid(0F, -1F, -1.5F, 3, 11, 3, 0.0F, true);
		larm1.setPivot(5F, -6.5F, 0.5F);
		larm1.setTextureSize(128, 64);
		larm1.mirror = true;
        setRotationAngle(larm1, 0F, 0F, 0F);
        
        larm2 = new ModelPart(this, 0, 19);
		larm2.addCuboid(0F, 6F, 5F, 3, 7, 3, 0.0F, true);
		larm2.setPivot(0,0,0);
		larm2.setTextureSize(128, 64);
		larm2.mirror = true;
        setRotationAngle(larm2, -0.7807508F, 0F, 0F);
        larm1.addChild(larm2);

		laspike1 = new ModelPart(this, 0, 0);
		laspike1.addCuboid(6F, -1F, -0.5F, 1, 4, 1, 0.0F, true);
		laspike1.setPivot(0,0,0);
		laspike1.setTextureSize(128, 64);
		laspike1.mirror = true;
		setRotationAngle(laspike1, 0F, 0F, 0.8179311F);
        larm1.addChild(laspike1);
        
		laspike2 = new ModelPart(this, 34, 0);
		laspike2.addCuboid(-1F, 10F, 5.5F, 4, 1, 1, 0.0F, true);
		laspike2.setPivot(0,0,0);
		laspike2.setTextureSize(128, 64);
		laspike2.mirror = true;
		setRotationAngle(laspike2, -0.7744724F, -0.2617994F, -0.2617994F);
        larm1.addChild(laspike2);
        
		lfinger1 = new ModelPart(this, 30, 0);
		lfinger1.addCuboid(3F, 11F, 6F, 1, 5, 1, 0.0F, true);
		lfinger1.setPivot(0,0,0);
		lfinger1.setTextureSize(128, 64);
		lfinger1.mirror = true;
		setRotationAngle(lfinger1, -0.7807556F, 0F, 0F);
        larm1.addChild(lfinger1);
        
		lfinger3 = new ModelPart(this, 30, 0);
		lfinger3.addCuboid(1F, 11F, 4F, 1, 5, 1, 0.0F, true);
		lfinger3.setPivot(0,0,0);
		lfinger3.setTextureSize(128, 64);
		lfinger3.mirror = true;
		setRotationAngle(lfinger3, -0.7807556F, 0F, 0F);
        larm1.addChild(lfinger3);
        
		lfinger2 = new ModelPart(this, 30, 0);
		lfinger2.addCuboid(-1F, 11F, 6F, 1, 5, 1, 0.0F, true);
		lfinger2.setPivot(0,0,0);
		lfinger2.setTextureSize(128, 64);
		lfinger2.mirror = true;
		setRotationAngle(lfinger2, -0.7807556F, 0F, 0F);
        larm1.addChild(lfinger2);
        
		lfinger4 = new ModelPart(this, 30, 0);
		lfinger4.addCuboid(1F, 11F, 8F, 1, 5, 1, 0.0F, true);
		lfinger4.setPivot(0,0,0);
		lfinger4.setTextureSize(128, 64);
		lfinger4.mirror = true;
		setRotationAngle(lfinger4, -0.7807556F, 0F, 0F);
        larm1.addChild(lfinger4);
        
		rightshoulder = new ModelPart(this, 41, 11);
		rightshoulder.addCuboid(0F, 0F, 0F, 8, 5, 7, 0.0F, true);
		rightshoulder.setPivot(-9.5F, -8F, -3F);
		rightshoulder.setTextureSize(128, 64);
		rightshoulder.mirror = true;
        setRotationAngle(rightshoulder, 0F, 0F, -0.1115358F);
        
		rsspike = new ModelPart(this, 0, 0);
		rsspike.addCuboid(0F, -4F, 0F, 1, 5, 1, 0.0F, true);
		rsspike.setPivot(-8F, -9F, 0F);
		rsspike.setTextureSize(128, 64);
		rsspike.mirror = true;
        setRotationAngle(rsspike, 0F, 0F, -0.111544F);
        
		rarm1 = new ModelPart(this, 0, 19);
		rarm1.addCuboid(-3F, -1F, -1.5F, 3, 11, 3, 0.0F, true);
		rarm1.setPivot(-5F, -6.5F, 0.5F);
		rarm1.setTextureSize(128, 64);
		rarm1.mirror = true;
        setRotationAngle(rarm1, 0F, 0F, 0F);
        
		rarm2 = new ModelPart(this, 0, 19);
		rarm2.addCuboid(-3F, 6F, 5F, 3, 7, 3, 0.0F, true);
		rarm2.setPivot(0,0,0);
		rarm2.setTextureSize(128, 64);
		rarm2.mirror = true;
		setRotationAngle(rarm2, -0.7807508F, 0F, 0F);
        rarm1.addChild(rarm2);
        
		raspike1 = new ModelPart(this, 0, 0);
		raspike1.addCuboid(-7F, -1F, -0.5F, 1, 4, 1, 0.0F, true);
		raspike1.setPivot(0,0,0);
		raspike1.setTextureSize(128, 64);
		raspike1.mirror = true;
		setRotationAngle(raspike1, 0F, 0F, -0.8179294F);
        rarm1.addChild(raspike1);
        
		raspike2 = new ModelPart(this, 34, 0);
		raspike2.addCuboid(-3F, 10F, 5.5F, 4, 1, 1, 0.0F, true);
		raspike2.setPivot(0,0,0);
		raspike2.setTextureSize(128, 64);
		raspike2.mirror = true;
		setRotationAngle(raspike2, -0.7807556F, 0.2617994F, 0.2617994F);
        rarm1.addChild(raspike2);
        
		rfinger1 = new ModelPart(this, 30, 0);
		rfinger1.addCuboid(0F, 11F, 6F, 1, 5, 1, 0.0F, true);
		rfinger1.setPivot(0,0,0);
		rfinger1.setTextureSize(128, 64);
		rfinger1.mirror = true;
		setRotationAngle(rfinger1, -0.7807556F, 0F, 0F);
        rarm1.addChild(rfinger1);
        
		rfinger2 = new ModelPart(this, 30, 0);
		rfinger2.addCuboid(-4F, 11F, 6F, 1, 5, 1, 0.0F, true);
		rfinger2.setPivot(0,0,0);
		rfinger2.setTextureSize(128, 64);
		rfinger2.mirror = true;
		setRotationAngle(rfinger2, -0.7807556F, 0F, 0F);
        rarm1.addChild(rfinger2);
        
		rfinger3 = new ModelPart(this, 30, 0);
		rfinger3.addCuboid(-2F, 11F, 4F, 1, 5, 1, 0.0F, true);
		rfinger3.setPivot(0,0,0);
		rfinger3.setTextureSize(128, 64);
		rfinger3.mirror = true;
		setRotationAngle(rfinger3, -0.7807556F, 0F, 0F);
        rarm1.addChild(rfinger3);
        
		rfinger4 = new ModelPart(this, 30, 0);
		rfinger4.addCuboid(-2F, 11F, 8F, 1, 5, 1, 0.0F, true);
		rfinger4.setPivot(0,0,0);
		rfinger4.setTextureSize(128, 64);
		rfinger4.mirror = true;
		setRotationAngle(rfinger4, -0.7807556F, 0F, 0F);
        rarm1.addChild(rfinger4);
        
		pelvis = new ModelPart(this, 37, 24);
		pelvis.addCuboid(0F, 0F, -1F, 12, 5, 5, 0.0F, true);
		pelvis.setPivot(-6F, 7F, 3F);
		pelvis.setTextureSize(128, 64);
		pelvis.mirror = true;
        setRotationAngle(pelvis, 0.2974216F, 0F, 0F);
        
		leftleg = new ModelPart(this, 16, 18);
		leftleg.addCuboid(-2.5F, 0F, -2.5F, 5, 8, 5, 0.0F, true);
		leftleg.setPivot(3.5F, 11F, 6F);
		leftleg.setTextureSize(128, 64);
		leftleg.mirror = true;
        setRotationAngle(leftleg, 0.2974216F, 0F, 0F);
        
		rightleg = new ModelPart(this, 16, 18);
		rightleg.addCuboid(-2.5F, 0F, -2.5F, 5, 8, 5, 0.0F, true);
		rightleg.setPivot(-3.5F, 11F, 6F);
		rightleg.setTextureSize(128, 64);
		rightleg.mirror = true;
		setRotationAngle(rightleg, 0.2974216F, 0F, 0F);
    }

    @Override
    public ModelPart getHead() {
        return head;
    }

    public void setRotationAngle(ModelPart ModelPart, float x, float y, float z) {
		ModelPart.pitch = x;
		ModelPart.yaw = y;
		ModelPart.roll = z;
    }
    
    @Override
    public void setAngles(ShadowBeastEntity entity, float limbAngle, float limbDistance, float customAngle, float headYaw, float headPitch) {
        head.pitch = headPitch / (180F / (float)Math.PI);
		head.yaw = headYaw / (180F / (float)Math.PI);

		rightleg.pitch = MathHelper.cos(limbAngle * 0.3331F) * 0.07F * limbDistance;
		rightleg.yaw = 0.0F;

		leftleg.pitch = MathHelper.cos(limbAngle * 0.3331F + (float)Math.PI) * 0.07F * limbDistance;
		leftleg.yaw = 0.0F;

		float f6 = MathHelper.sin(handSwingProgress * (float)Math.PI);
		float f7 = MathHelper.sin((1.0F - (1.0F - handSwingProgress) * (1.0F - handSwingProgress)) * (float)Math.PI);
		rarm1.roll = 0.0F;
		larm1.roll = 0.0F;
		rarm1.yaw = -(0.1F - f6 * 0.6F);
		larm1.yaw = 0.1F - f6 * 0.6F;
		rarm1.pitch = -((float)Math.PI / 7.2F);
		larm1.pitch = -((float)Math.PI / 7.2F);
		rarm1.pitch -= f6 * 1.2F - f7 * 0.4F;
		larm1.pitch -= f6 * 1.2F - f7 * 0.4F;
		rarm1.roll += MathHelper.cos(customAngle * 0.09F) * 0.05F + 0.05F;
		larm1.roll -= MathHelper.cos(customAngle * 0.09F) * 0.05F + 0.05F;
		rarm1.pitch += MathHelper.sin(customAngle * 0.067F) * 0.05F;
		larm1.pitch -= MathHelper.sin(customAngle * 0.067F) * 0.05F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		spine.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		leftshoulder.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		lsspike.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		larm1.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		rightshoulder.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		rsspike.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		rarm1.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		pelvis.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		leftleg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		rightleg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}