package net.tvinci.floramancy.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.tvinci.floramancy.TVincisFloramancy;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> ITCHING = registerStatusEffect("itching",
            new ItchingEffect(StatusEffectCategory.HARMFUL, 0xc93a1e));




    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(TVincisFloramancy.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        TVincisFloramancy.LOGGER.info("Registering Mod Effects for " + TVincisFloramancy.MOD_ID);
    }
}
