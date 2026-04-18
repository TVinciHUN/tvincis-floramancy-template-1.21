package net.tvinci.floramancy;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import net.tvinci.floramancy.component.ModDataComponentTypes;
import net.tvinci.floramancy.item.ModItems;

public class TVincisFloramancyClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("FLORAMANCY CLIENT LOADED");
        ModelPredicateProviderRegistry.register(ModItems.SOUL_CRYSTAL, Identifier.of("floramancy", "souls"), (stack, world, entity, seed) -> {
            return 10.0f;
        });
    }
}
