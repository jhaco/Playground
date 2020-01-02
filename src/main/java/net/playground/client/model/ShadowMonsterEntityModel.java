package net.playground.client.model;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.ModelWithHead;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.playground.entity.ShadowMonsterEntity;

@Environment(EnvType.CLIENT)
public class ShadowMonsterEntityModel extends EntityModel<ShadowMonsterEntity> implements ModelWithHead {
    private final ModelPart Head;
	private final ModelPart Body1;
	private final ModelPart Body2;
	private final ModelPart Body3;
	private final ModelPart Lshoulder1;
	private final ModelPart Rshoulder1;
	private final ModelPart Lshoulder2;
	private final ModelPart Rshoulder2;
	private final ModelPart Larm1;
	private final ModelPart Larm2;
	private final ModelPart Rarm1;
	private final ModelPart Rarm2;
	private final ModelPart Back1;
	private final ModelPart Back2;
	private final ModelPart Back3;
	private final ModelPart Back4;
	private final ModelPart Back5;
	private final ModelPart Back6;
	private final ModelPart Back7;
	private final ModelPart Back8;
	private final ModelPart Back9;

    public ShadowMonsterEntityModel() {
        textureWidth = 64;
		textureHeight = 32;

		Head = new ModelPart(this, 0, 0);
		Head.addCuboid(-3.5F, -7F, -3.5F, 7, 7, 7, 0.0F, true);
		Head.setPivot(0F, 0F, 0F);
		Head.setTextureSize(64, 32);
		Head.mirror = true;
        setRotationAngle(Head, 0F, 0F, 0F);
        
		Body1 = new ModelPart(this, 20, 14);
		Body1.addCuboid(-1.5F, -1F, -1.5F, 3, 10, 3, 0.0F, true);
		Body1.setPivot(0F, 0F, 0F);
		Body1.setTextureSize(64, 32);
		Body1.mirror = true;
        setRotationAngle(Body1, 0.4461433F, 0F, 0F);
        
		Body2 = new ModelPart(this, 28, 0);
		Body2.addCuboid(0F, 0F, 0F, 3, 6, 3, 0.0F, true);
		Body2.setPivot(-1.5F, 7F, 2F);
		Body2.setTextureSize(64, 32);
		Body2.mirror = true;
        setRotationAngle(Body2, 0F, 0F, 0F);
        
		Body3 = new ModelPart(this, 28, 0);
		Body3.addCuboid(0F, 0F, 0F, 3, 6, 3, 0.0F, true);
		Body3.setPivot(-1.5F, 11F, 2.5F);
		Body3.setTextureSize(64, 32);
		Body3.mirror = true;
        setRotationAngle(Body3, -0.5948578F, 0F, 0F);
        
		Lshoulder1 = new ModelPart(this, 40, 0);
		Lshoulder1.addCuboid(0F, 0F, 0F, 3, 2, 2, 0.0F, true);
		Lshoulder1.setPivot(1.5F, 0F, 0F);
		Lshoulder1.setTextureSize(64, 32);
		Lshoulder1.mirror = true;
        setRotationAngle(Lshoulder1, 0F, 0F, 0F);
        
		Rshoulder1 = new ModelPart(this, 40, 0);
		Rshoulder1.addCuboid(0F, 0F, 0F, 3, 2, 2, 0.0F, true);
		Rshoulder1.setPivot(-4.5F, 0F, 0F);
		Rshoulder1.setTextureSize(64, 32);
		Rshoulder1.mirror = true;
        setRotationAngle(Rshoulder1, 0F, 0F, 0F);
        
		Lshoulder2 = new ModelPart(this, 40, 0);
		Lshoulder2.addCuboid(0F, 0F, 0F, 3, 2, 2, 0.0F, true);
		Lshoulder2.setPivot(1.5F, 5F, 2F);
		Lshoulder2.setTextureSize(64, 32);
		Lshoulder2.mirror = true;
        setRotationAngle(Lshoulder2, 0F, 0F, 0F);
        
		Rshoulder2 = new ModelPart(this, 40, 0);
		Rshoulder2.addCuboid(0F, 0F, 0F, 3, 2, 2, 0.0F, true);
		Rshoulder2.setPivot(-4.5F, 5F, 2F);
		Rshoulder2.setTextureSize(64, 32);
		Rshoulder2.mirror = true;
        setRotationAngle(Rshoulder2, 0F, 0F, 0F);
        
		Larm1 = new ModelPart(this, 0, 14);
		Larm1.addCuboid(0F, -1F, -7F, 2, 2, 8, 0.0F, true);
		Larm1.setPivot(4.5F, 1F, 1F);
		Larm1.setTextureSize(64, 32);
		Larm1.mirror = true;
        setRotationAngle(Larm1, 0F, 0F, 0F);
        
		Larm2 = new ModelPart(this, 0, 14);
		Larm2.addCuboid(0F, -1F, -7F, 2, 2, 8, 0.0F, true);
		Larm2.setPivot(4.5F, 6F, 3F);
		Larm2.setTextureSize(64, 32);
		Larm2.mirror = true;
        setRotationAngle(Larm2, 0F, 0F, 0F);
        
		Rarm1 = new ModelPart(this, 0, 14);
		Rarm1.addCuboid(-2F, -1F, -7F, 2, 2, 8, 0.0F, true);
		Rarm1.setPivot(-4.5F, 1F, 1F);
		Rarm1.setTextureSize(64, 32);
		Rarm1.mirror = true;
        setRotationAngle(Rarm1, 0F, 0F, 0F);
        
		Rarm2 = new ModelPart(this, 0, 14);
		Rarm2.addCuboid(-2F, -1F, -7F, 2, 2, 8, 0.0F, true);
		Rarm2.setPivot(-4.5F, 6F, 3F);
		Rarm2.setTextureSize(64, 32);
		Rarm2.mirror = true;
        setRotationAngle(Rarm2, 0F, 0F, 0F);
        
		Back1 = new ModelPart(this, 50, 0);
		Back1.addCuboid(0F, 0F, 0F, 1, 2, 1, 0.0F, true);
		Back1.setPivot(-0.5F, 2F, 4F);
		Back1.setTextureSize(64, 32);
		Back1.mirror = true;
        setRotationAngle(Back1, -1.041002F, 0F, 0F);
        
		Back2 = new ModelPart(this, 50, 0);
		Back2.addCuboid(0F, 0F, 0F, 1, 2, 1, 0.0F, true);
		Back2.setPivot(-0.5F, 4F, 5F);
		Back2.setTextureSize(64, 32);
		Back2.mirror = true;
        setRotationAngle(Back2, -1.041002F, 0F, 0F);
        
		Back3 = new ModelPart(this, 50, 0);
		Back3.addCuboid(0F, 0F, 0F, 1, 2, 1, 0.0F, true);
		Back3.setPivot(-0.5F, 0F, 3F);
		Back3.setTextureSize(64, 32);
		Back3.mirror = true;
        setRotationAngle(Back3, -1.041002F, 0F, 0F);
        
		Back4 = new ModelPart(this, 50, 0);
		Back4.addCuboid(0F, 0F, 0F, 1, 1, 2, 0.0F, true);
		Back4.setPivot(-0.5F, 8F, 4.5F);
		Back4.setTextureSize(64, 32);
		Back4.mirror = true;
        setRotationAngle(Back4, 0F, 0F, 0F);
        
		Back5 = new ModelPart(this, 50, 0);
		Back5.addCuboid(0F, 0F, 0F, 1, 1, 2, 0.0F, true);
		Back5.setPivot(-0.5F, 10F, 4.5F);
		Back5.setTextureSize(64, 32);
		Back5.mirror = true;
        setRotationAngle(Back5, 0F, 0F, 0F);
        
		Back6 = new ModelPart(this, 50, 0);
		Back6.addCuboid(0F, 0F, 0F, 1, 1, 2, 0.0F, true);
		Back6.setPivot(-0.5F, 12F, 4.5F);
		Back6.setTextureSize(64, 32);
		Back6.mirror = true;
        setRotationAngle(Back6, 0F, 0F, 0F);
        
		Back7 = new ModelPart(this, 50, 0);
		Back7.addCuboid(0F, 0F, 0F, 1, 2, 1, 0.0F, true);
		Back7.setPivot(-0.5F, 14F, 3.5F);
		Back7.setTextureSize(64, 32);
		Back7.mirror = true;
        setRotationAngle(Back7, 1.00382F, 0F, 0F);
        
		Back8 = new ModelPart(this, 50, 0);
		Back8.addCuboid(0F, 0F, 0F, 1, 2, 1, 0.0F, true);
		Back8.setPivot(-0.5F, 15.5F, 2.5F);
		Back8.setTextureSize(64, 32);
		Back8.mirror = true;
        setRotationAngle(Back8, 1.00382F, 0F, 0F);
        
		Back9 = new ModelPart(this, 50, 0);
		Back9.addCuboid(0F, 0F, 0F, 1, 2, 1, 0.0F, true);
		Back9.setPivot(-0.5F, 17F, 1.5F);
		Back9.setTextureSize(64, 32);
		Back9.mirror = true;
		setRotationAngle(Back9, 1.00382F, 0F, 0F);
    }

    @Override
    public ModelPart getHead() {
        return Head;
    }

    public void setRotationAngle(ModelPart ModelPart, float x, float y, float z) {
		ModelPart.pitch = x;
		ModelPart.yaw = y;
		ModelPart.roll = z;
    }

    @Override
    public void setAngles(ShadowMonsterEntity entity, float limbAngle, float limbDistance, float customAngle, float headYaw, float headPitch) {
        Head.yaw = headYaw / (180F / (float)Math.PI);
		Head.pitch = headPitch / (180F / (float)Math.PI);

		Rarm1.pitch = MathHelper.cos(limbAngle * 0.6662F + (float)Math.PI) * 2.0F * limbDistance * 0.5F;
		Larm1.pitch = MathHelper.cos(limbAngle * 0.6662F) * 2.0F * limbDistance * 0.5F;
		Rarm2.pitch = MathHelper.cos(limbAngle * 0.6662F + (float)Math.PI) * 2.0F * limbDistance * 0.5F * 0.1F;
		Larm2.pitch = MathHelper.cos(limbAngle * 0.6662F) * 2.0F * limbDistance * 0.5F * 0.1F;

		Rarm1.roll = 0.0F;
		Larm1.roll = 0.0F;
		Rarm2.roll = 0.0F;
		Larm2.roll = 0.0F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        Head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		Body1.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		Body2.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		Body3.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		Lshoulder1.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		Rshoulder1.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		Lshoulder2.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		Rshoulder2.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		Larm1.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		Larm2.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		Rarm1.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		Rarm2.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		Back1.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		Back2.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		Back3.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		Back4.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		Back5.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		Back6.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		Back7.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		Back8.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		Back9.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}