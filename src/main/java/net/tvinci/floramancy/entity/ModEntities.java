package net.tvinci.floramancy.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tvinci.floramancy.TVincisFloramancy;
import net.tvinci.floramancy.entity.custom.VesselEntity;

public class ModEntities {
    public static final EntityType<VesselEntity> VESSEL = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(TVincisFloramancy.MOD_ID, "vessel"),
            EntityType.Builder.create(VesselEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.5f, 1f).build());


   public static void registerModEntities() {
       TVincisFloramancy.LOGGER.info("Registering Mod Entities for " + TVincisFloramancy.MOD_ID);
   }
}
