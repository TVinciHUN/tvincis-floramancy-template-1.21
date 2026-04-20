package net.tvinci.floramancy;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.tvinci.floramancy.entity.ModEntities;
import net.tvinci.floramancy.entity.client.VesselModel;
import net.tvinci.floramancy.entity.client.VesselRenderer;
import net.tvinci.floramancy.util.ModModelPredicates;

public class TVincisFloramancyClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("FLORAMANCY CLIENT LOADED");

        ModModelPredicates.registerModelPredicates();

        EntityModelLayerRegistry.registerModelLayer(VesselModel.VESSEL, VesselModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.VESSEL, VesselRenderer::new);
    }
}
