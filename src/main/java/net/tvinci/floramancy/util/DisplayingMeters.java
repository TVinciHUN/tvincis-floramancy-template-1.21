package net.tvinci.floramancy.util;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.tvinci.floramancy.component.ModDataComponentTypes;
import net.tvinci.floramancy.item.custom.SoulCrystalItem;

public class DisplayingMeters {
    public static void DisplaySoulMeter() {
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
    }
}
