package net.tvinci.floramancy;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tvinci.floramancy.component.ModDataComponentTypes;
import net.tvinci.floramancy.effect.ModEffects;
import net.tvinci.floramancy.item.ModItems;
import net.tvinci.floramancy.item.custom.SoulCrystalItem;
import net.tvinci.floramancy.util.DisplayingMeters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TVincisFloramancy implements ModInitializer {
	public static final String MOD_ID = "floramancy";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.registerModItems();
        ModEffects.registerEffects();

        ModDataComponentTypes.registerDataComponentTypes();

        DisplayingMeters.DisplaySoulMeter();
    }
}