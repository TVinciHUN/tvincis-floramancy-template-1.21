package net.tvinci.floramancy.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.tvinci.floramancy.TVincisFloramancy;
import net.tvinci.floramancy.entity.custom.VesselEntity;

public class VesselModel<T extends VesselEntity> extends SinglePartEntityModel<T> {
        public static final EntityModelLayer VESSEL = new EntityModelLayer(Identifier.of(TVincisFloramancy.MOD_ID, "vessel"), "main");

        private final ModelPart root;
        private final ModelPart rightleg;
        private final ModelPart rightlegedge;
        private final ModelPart leftleg;
        private final ModelPart leftlegedge;
        private final ModelPart rightarm;
        private final ModelPart rightarmedge;
        private final ModelPart leftarm;
        private final ModelPart leftarmedge;
        private final ModelPart head;
        private final ModelPart headedge;
        private final ModelPart torso;
        private final ModelPart torsoedge;
        public VesselModel(ModelPart root) {
            this.root = root.getChild("root");
            this.rightleg = this.root.getChild("right leg");
            this.rightlegedge = this.rightleg.getChild("right leg edge");
            this.leftleg = this.root.getChild("left leg");
            this.leftlegedge = this.leftleg.getChild("left leg edge");
            this.rightarm = this.root.getChild("right arm");
            this.rightarmedge = this.rightarm.getChild("right arm edge");
            this.leftarm = this.root.getChild("left arm");
            this.leftarmedge = this.leftarm.getChild("left arm edge");
            this.head = this.root.getChild("head");
            this.headedge = this.head.getChild("head edge");
            this.torso = this.root.getChild("torso");
            this.torsoedge = this.torso.getChild("torso edge");
        }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData rightleg = root.addChild("right leg", ModelPartBuilder.create().uv(20, 21).cuboid(-3.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData rightlegedge = rightleg.addChild("right leg edge", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r1 = rightlegedge.addChild("cube_r1", ModelPartBuilder.create().uv(28, 20).cuboid(-6.0F, -1.0F, -3.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -3.0F, 5.0F, 0.0F, -1.5708F, 1.5708F));

        ModelPartData cube_r2 = rightlegedge.addChild("cube_r2", ModelPartBuilder.create().uv(28, 20).cuboid(-6.0F, -1.0F, -3.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -3.0F, 4.0F, 0.0F, -1.5708F, 1.5708F));

        ModelPartData cube_r3 = rightlegedge.addChild("cube_r3", ModelPartBuilder.create().uv(28, 20).cuboid(-6.0F, -1.0F, -3.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -3.0F, 8.0F, 0.0F, -1.5708F, 1.5708F));

        ModelPartData cube_r4 = rightlegedge.addChild("cube_r4", ModelPartBuilder.create().uv(28, 20).cuboid(-6.0F, -1.0F, -3.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -3.0F, 8.0F, 0.0F, -1.5708F, 1.5708F));

        ModelPartData leftleg = root.addChild("left leg", ModelPartBuilder.create().uv(22, 0).cuboid(0.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leftlegedge = leftleg.addChild("left leg edge", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r5 = leftlegedge.addChild("cube_r5", ModelPartBuilder.create().uv(28, 20).cuboid(-6.0F, -1.0F, -3.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -3.0F, 8.0F, 0.0F, -1.5708F, 1.5708F));

        ModelPartData cube_r6 = leftlegedge.addChild("cube_r6", ModelPartBuilder.create().uv(28, 20).cuboid(-6.0F, -1.0F, -3.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -3.0F, 5.0F, 0.0F, -1.5708F, 1.5708F));

        ModelPartData cube_r7 = leftlegedge.addChild("cube_r7", ModelPartBuilder.create().uv(28, 20).cuboid(-6.0F, -1.0F, -3.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -3.0F, 4.0F, 0.0F, -1.5708F, 1.5708F));

        ModelPartData rightarm = root.addChild("right arm", ModelPartBuilder.create().uv(10, 21).cuboid(-5.0F, -10.0F, -1.0F, 2.0F, 7.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData rightarmedge = rightarm.addChild("right arm edge", ModelPartBuilder.create().uv(2, 2).cuboid(-6.0F, -10.0F, 1.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(2, 2).cuboid(-5.0F, -11.0F, 1.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leftarm = root.addChild("left arm", ModelPartBuilder.create().uv(0, 21).cuboid(3.0F, -10.0F, -1.0F, 2.0F, 7.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leftarmedge = leftarm.addChild("left arm edge", ModelPartBuilder.create().uv(26, 20).cuboid(4.0F, -11.0F, -1.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(26, 20).cuboid(4.0F, -11.0F, 2.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(2, 2).cuboid(5.0F, -9.0F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r8 = leftarmedge.addChild("cube_r8", ModelPartBuilder.create().uv(28, 20).cuboid(-6.0F, -1.0F, -3.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -10.0F, 5.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData head = root.addChild("head", ModelPartBuilder.create().uv(0, 12).cuboid(-3.0F, -14.0F, -2.0F, 6.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData headedge = head.addChild("head edge", ModelPartBuilder.create().uv(22, 6).cuboid(3.0F, -15.0F, -2.0F, 0.0F, 1.0F, 5.0F, new Dilation(0.0F))
                .uv(22, 12).cuboid(-3.0F, -15.0F, -2.0F, 0.0F, 1.0F, 5.0F, new Dilation(0.0F))
                .uv(22, 18).cuboid(-3.0F, -15.0F, -2.0F, 6.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(22, 19).cuboid(-3.0F, -15.0F, 3.0F, 6.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(26, 20).cuboid(-2.0F, -16.0F, -2.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(22, 20).cuboid(1.0F, -16.0F, -2.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(20, 27).cuboid(1.0F, -16.0F, 3.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(22, 27).cuboid(-3.0F, -16.0F, 3.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r9 = headedge.addChild("cube_r9", ModelPartBuilder.create().uv(28, 20).cuboid(-6.0F, -1.0F, -3.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -15.0F, 4.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData cube_r10 = headedge.addChild("cube_r10", ModelPartBuilder.create().uv(20, 28).cuboid(-6.0F, -1.0F, -3.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -15.0F, 8.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData cube_r11 = headedge.addChild("cube_r11", ModelPartBuilder.create().uv(26, 27).cuboid(-6.0F, -1.0F, -3.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-6.0F, -15.0F, 7.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData cube_r12 = headedge.addChild("cube_r12", ModelPartBuilder.create().uv(24, 27).cuboid(-6.0F, -1.0F, -3.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-6.0F, -15.0F, 4.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData torso = root.addChild("torso", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -10.0F, -2.0F, 6.0F, 7.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData torsoedge = torso.addChild("torso edge", ModelPartBuilder.create().uv(2, 2).cuboid(-4.0F, -6.0F, -2.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r13 = torsoedge.addChild("cube_r13", ModelPartBuilder.create().uv(2, 2).cuboid(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -9.0F, 3.0F, 0.0F, 1.5708F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }
        @Override
        public void setAngles(VesselEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            this.getPart().traverse().forEach(ModelPart::resetTransform);
            this.setHeadAngles(netHeadYaw, headPitch);

            this.animateMovement(VesselAnimations.ANIM_VESSEL_WALKING, limbSwing, limbSwingAmount, 1f, 1.5f);
            this.updateAnimation(entity.idleAnimationState, VesselAnimations.ANIM_VESSEL_IDLE, ageInTicks, 1f);
        }

        private void setHeadAngles(float headYaw, float headPitch) {
            headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
            headPitch = MathHelper.clamp(headPitch, 0.0F, 0.0F);

            this.head.yaw = headYaw * 0.017453292F;
            this.head.pitch = headPitch *0.017453292F;
        }

        @Override
        public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
            root.render(matrices, vertexConsumer, light, overlay, color);
        }

    @Override
    public ModelPart getPart() {
        return root;
    }
}
