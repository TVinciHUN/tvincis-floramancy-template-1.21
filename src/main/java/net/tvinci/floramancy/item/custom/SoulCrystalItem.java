package net.tvinci.floramancy.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import net.tvinci.floramancy.component.ModDataComponentTypes;

import java.util.List;
import java.util.Map;

public class SoulCrystalItem extends Item {
    private static final Map<Block, Block> CRYSTAL_MAP =
            Map.of(
                    Blocks.SOUL_SAND, Blocks.AIR,
                    Blocks.SOUL_SOIL, Blocks.AIR
            );

    public SoulCrystalItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(CRYSTAL_MAP.containsKey(clickedBlock)) {
            if(!world.isClient()) {
                world.setBlockState(context.getBlockPos(), CRYSTAL_MAP.get(clickedBlock).getDefaultState());

            world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_SOUL_SAND_PLACE, SoundCategory.BLOCKS);

                getDefaultStack().apply(ModDataComponentTypes.SOULS, 0, val -> val + 1);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.floramancy.soul_crystal.tooltip"));
        tooltip.add(Text.translatable("tooltip.floramancy.soul_crystal.tooltip.2"));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
