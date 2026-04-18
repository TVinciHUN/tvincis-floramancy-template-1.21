package net.tvinci.floramancy.util;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import net.tvinci.floramancy.component.ModDataComponentTypes;
import net.tvinci.floramancy.item.ModItems;

public class ModModelPredicates {
    public static void  registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.SOUL_CRYSTAL, Identifier.of("floramancy", "souls"), (stack, world, entity, seed) -> {
            float souls = (float) stack.getOrDefault(ModDataComponentTypes.SOULS, 0) / 10;
            return (float) souls;
        });
    }
}
