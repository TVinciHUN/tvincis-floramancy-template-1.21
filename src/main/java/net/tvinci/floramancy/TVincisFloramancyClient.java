package net.tvinci.floramancy;

import net.fabricmc.api.ClientModInitializer;
import net.tvinci.floramancy.util.ModModelPredicates;

public class TVincisFloramancyClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("FLORAMANCY CLIENT LOADED");

        ModModelPredicates.registerModelPredicates();
    }
}
