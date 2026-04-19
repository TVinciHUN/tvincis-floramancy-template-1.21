package net.tvinci.floramancy.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.tvinci.floramancy.TVincisFloramancy;
import net.tvinci.floramancy.entity.custom.VesselEntity;

public class VesselRenderer extends MobEntityRenderer<VesselEntity, VesselModel<VesselEntity>> {
    public VesselRenderer(EntityRendererFactory.Context context) {
        super(context, new VesselModel<>(context.getPart(VesselModel.VESSEL)), 0.2f);
    }

    @Override
    public Identifier getTexture(VesselEntity entity) {
        return Identifier.of(TVincisFloramancy.MOD_ID, "textures/entity/vessel/vessel.png");
    }

    @Override
    public void render(VesselEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }


}
