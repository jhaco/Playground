package net.playground.client.model;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.ModelWithHead;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.playground.entity.ShadowCreatureEntity;

@Environment(EnvType.CLIENT)
public class ShadowCreatureEntityModel extends EntityModel<ShadowCreatureEntity> implements ModelWithHead {
    private final ModelPart Body;
	private final ModelPart Head1;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart Tail3;
	private final ModelPart Tail4;
	private final ModelPart Tail5;
	private final ModelPart Tail6;
	private final ModelPart Tail7;
	private final ModelPart LeftArm1;
	private final ModelPart RightArm1;
	private final ModelPart LeftArm2;
    private final ModelPart RightArm2;
    
    public ShadowCreatureEntityModel() {
        textureWidth = 32;
        textureHeight = 32;
        
        Body = new ModelPart(this, 12, 22);
		Body.setPivot(-3F, 12F, -1F);
		setRotationAngle(Body, 0F, 0F, 0F);
        Body.addCuboid(0F, 0F, 0F, 3, 3, 7, 0.0F, true);
        Body.mirror = true;
        
        Head1 = new ModelPart(this, 0, 0);
		Head1.setPivot(-1F, 12F, 0F);
		setRotationAngle(Head1, 0F, 0F, 0F);
        Head1.addCuboid(-3F, -5F, -3F, 5, 5, 5, 0.0F, true);
        Head1.mirror = true;
        
        Tail1 = new ModelPart(this, 18, 15);
        Tail1.setPivot(-2.466667F, 12.5F, 6F);
        setRotationAngle(Tail1, -0.3717861F, 0F, 0F);
        Tail1.addCuboid(0F, 0F, 0F, 2, 2, 5, 0.0F, true);
        Tail1.mirror = true;

        Tail2 = new ModelPart(this, 26, 12);
        Tail2.setPivot(-2F, 14F, 9F);
        setRotationAngle(Tail2, 1.115358F, 0F, 0F);
        Tail2.addCuboid(0F, 0F, 0F, 1, 1, 2, 0.0F, true);
        Tail2.mirror = true;

        Tail3 = new ModelPart(this, 23, 7);
        Tail3.setPivot(-1F, 14.5F, 9F);
        setRotationAngle(Tail3, -0.4089647F, 0F, 0F);
        Tail3.addCuboid(0F, 0F, 0F, 3, 1, 1, 0.0F, true);
        Tail3.mirror = true;

        Tail4 = new ModelPart(this, 23, 7);
        Tail4.setPivot(-1F, 13.5F, 7F);
        setRotationAngle(Tail4, -0.4089647F, 0F, 0F);
        Tail4.addCuboid(0F, 0F, 0F, 3, 1, 1, 0.0F, true);
        Tail4.mirror = true;

        Tail5 = new ModelPart(this, 23, 7);
        Tail5.setPivot(-5F, 14.5F, 9F);
        setRotationAngle(Tail5, -0.4089647F, 0F, 0F);
        Tail5.addCuboid(0F, 0F, 0F, 3, 1, 1);
        Tail5.mirror = true;

        Tail6 = new ModelPart(this, 23, 7);
        Tail6.setPivot(-5F, 13.5F, 7F);
        setRotationAngle(Tail6, -0.4089647F, 0F, 0F);
        Tail6.addCuboid(0F, 0F, 0F, 3, 1, 1, 0.0F, true);
        Tail6.mirror = true;

        Tail7 = new ModelPart(this, 26, 12);
        Tail7.setPivot(-2F, 13F, 7F);
        setRotationAngle(Tail7, 1.115358F, 0F, 0F);
        Tail7.addCuboid(0F, 0F, 0F, 1, 1, 2, 0.0F, true);
        Tail7.mirror = true;

		LeftArm1 = new ModelPart(this, 11, 19);
		LeftArm1.addCuboid(0F, 0F, 0F, 2, 1, 1, 0.0F, true);
		LeftArm1.setPivot(0F, 13F, 0F);
        setRotationAngle(LeftArm1, 0F, 0F, 0F);
        LeftArm1.mirror = true;
        
		RightArm1 = new ModelPart(this, 11, 19);
		RightArm1.addCuboid(0F, 0F, 0F, 2, 1, 1, 0.0F, true);
        RightArm1.setPivot(-5F, 13F, 0F);
        setRotationAngle(RightArm1, 0F, 0F, 0F);
        RightArm1.mirror = true;

		LeftArm2 = new ModelPart(this, 0, 22);
		LeftArm2.addCuboid(0F, 0F, -5F, 1, 1, 5, 0.0F, true);
		LeftArm2.setPivot(1F, 13F, 0F);
        setRotationAngle(LeftArm2, 0F, 0F, 0F);
        LeftArm2.mirror = true;
        
		RightArm2 = new ModelPart(this, 0, 22);
		RightArm2.addCuboid(0F, 0F, -5F, 1, 1, 5, 0.0F, true);
		RightArm2.setPivot(-5F, 13F, 0F);
        setRotationAngle(RightArm2, 0F, 0F, 0F);
        RightArm2.mirror = true;
    }

    @Override
    public ModelPart getHead() {
        return Head1;
    }

    public void setRotationAngle(ModelPart ModelPart, float x, float y, float z) {
		ModelPart.pitch = x;
		ModelPart.yaw = y;
		ModelPart.roll = z;
	}

    @Override
    public void setAngles(ShadowCreatureEntity entity, float limbAngle, float limbDistance, float customAngle, float headYaw, float headPitch) {
        Head1.pitch = headPitch / (180F / (float)Math.PI);
        Head1.yaw = headYaw / (180F / (float)Math.PI);
        
        RightArm2.pitch = MathHelper.cos(limbAngle * 0.6662F + (float)Math.PI) * 2.0F * limbDistance * 0.5F;
		LeftArm2.pitch = MathHelper.cos(limbAngle * 0.6662F) * 2.0F * limbDistance * 0.5F;

		RightArm2.roll = 0.0F;
		LeftArm2.roll = 0.0F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        Body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        Head1.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        Tail1.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        Tail2.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        Tail3.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        Tail4.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        Tail5.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        Tail6.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        Tail7.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        LeftArm1.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        LeftArm2.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        RightArm1.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        RightArm2.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}