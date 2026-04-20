package net.tvinci.floramancy;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.util.ActionResult;
import net.tvinci.floramancy.block.ModBlocks;
import net.tvinci.floramancy.component.ModDataComponentTypes;
import net.tvinci.floramancy.effect.ModEffects;
import net.tvinci.floramancy.entity.ModEntities;
import net.tvinci.floramancy.entity.custom.VesselEntity;
import net.tvinci.floramancy.item.ModItemGroups;
import net.tvinci.floramancy.item.ModItems;
import net.tvinci.floramancy.util.DisplayingMeters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TVincisFloramancy implements ModInitializer {
	public static final String MOD_ID = "floramancy";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.registerModItems();
        ModItemGroups.registerItemGroups();
        ModBlocks.registerModBlocks();
        ModEffects.registerEffects();
        ModEntities.registerModEntities();

        ModDataComponentTypes.registerDataComponentTypes();

        DisplayingMeters.DisplaySoulMeter();

        FabricDefaultAttributeRegistry.register(ModEntities.VESSEL, VesselEntity.createAttributes());
    }
}