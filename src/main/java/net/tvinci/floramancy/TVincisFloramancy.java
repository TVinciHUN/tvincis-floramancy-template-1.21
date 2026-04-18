package net.tvinci.floramancy;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tvinci.floramancy.component.ModDataComponentTypes;
import net.tvinci.floramancy.item.ModItems;
import net.tvinci.floramancy.item.custom.SoulCrystalItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TVincisFloramancy implements ModInitializer {
	public static final String MOD_ID = "floramancy";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.registerModItems();

        ModDataComponentTypes.registerDataComponentTypes();

        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                ItemStack mainHand = player.getMainHandStack();

                if (mainHand.getItem() instanceof SoulCrystalItem) {
                    int souls = mainHand.getOrDefault(ModDataComponentTypes.SOULS, 0);
                    int maxSouls = 10;

                    String bar = "§b" + "▐".repeat(souls) + "§8" + "▐".repeat(maxSouls - souls);
                    player.sendMessage(Text.literal("§8[" + bar + " §8]§r"), true);
                }
                else {
                    player.sendMessage(Text.literal(""), true);
                }
            }
        });


        //ModelPredicateProviderRegistry.register(ModItems.SOUL_CRYSTAL, Identifier.of("souls"), (stack, world, entity, seed) -> 10.0f);
            //int souls = stack.getOrDefault(ModDataComponentTypes.SOULS, 0);
            //return (float) souls;

        ModelPredicateProviderRegistry.register(ModItems.SOUL_CRYSTAL, Identifier.of("floramancy", "souls"), (stack, world, entity, seed) -> {
            System.out.println("Game is checking value of souls!");
            return 10.0f;
        });
    }
}