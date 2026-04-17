package net.tvinci.floramancy.component;

import net.minecraft.component.ComponentType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tvinci.floramancy.TVincisFloramancy;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {

    public static final ComponentType<NbtComponent> SOULS = register("Souls", builder -> builder.codec(NbtComponent.CODEC));

    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(TVincisFloramancy.MOD_ID, name),
                builderOperator.apply(ComponentType.builder()).build());
    }

    public static void registerDataComponentTypes() {
        TVincisFloramancy.LOGGER.info("Registering Data Component Types for " + TVincisFloramancy.MOD_ID);
    }



    public static void initialize() {}

}
