package net.tvinci.floramancy.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.tvinci.floramancy.TVincisFloramancy;
import net.tvinci.floramancy.item.custom.SoulCrystalItem;

public class ModItems {
    public static final Item SOUL_CRYSTAL = registerItem("soul_crystal", new SoulCrystalItem(new Item.Settings().rarity(Rarity.RARE).maxCount(1)));
    public static final Item INFUSED_BONEMEAL = registerItem("infused_bonemeal", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TVincisFloramancy.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TVincisFloramancy.LOGGER.info("Registering Mod Items for "+TVincisFloramancy.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(INFUSED_BONEMEAL);
        });
    }
}
