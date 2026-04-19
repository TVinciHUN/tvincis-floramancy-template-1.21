package net.tvinci.floramancy.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tvinci.floramancy.TVincisFloramancy;
import net.tvinci.floramancy.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup FLORAMANCY_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TVincisFloramancy.MOD_ID, "floramancy"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.SOUL_CRYSTAL))
                    .displayName(Text.translatable("itemgroup.floramancy.floramancy"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SOUL_CRYSTAL);
                        entries.add(ModItems.INFUSED_BONEMEAL);
                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        TVincisFloramancy.LOGGER.info("Registering Item Groups for " + TVincisFloramancy.MOD_ID);
    }
}
