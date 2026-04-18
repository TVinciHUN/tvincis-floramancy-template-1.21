package net.tvinci.floramancy.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
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
    public ItemStack getDefaultStack() {
        ItemStack stack = super.getDefaultStack();
        stack.set(ModDataComponentTypes.SOULS, 0);
        return stack;
    }


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();
        PlayerEntity player = context.getPlayer();

        if(CRYSTAL_MAP.containsKey(clickedBlock)) {
            int souls = context.getStack().getOrDefault(ModDataComponentTypes.SOULS, 0);

            if (souls >= 10) {
                if (!world.isClient() && player != null) {
                    world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_SOUL_SAND_HIT, SoundCategory.BLOCKS);


                    player.sendMessage(Text.literal("§1[▐▐▐▐▐▐▐▐▐▐ ]§r"), true);
                    //String bar = "§1" + "▐".repeat(souls) + "§8" + "▐".repeat(10 - souls);
                    //player.sendMessage(Text.literal("§8[" + bar + "§8]§r"), true);
                }

                return ActionResult.PASS;
            }

            if(!world.isClient()) {
                world.setBlockState(context.getBlockPos(), CRYSTAL_MAP.get(clickedBlock).getDefaultState());

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_SOUL_SAND_PLACE, SoundCategory.BLOCKS);

                context.getStack().apply(ModDataComponentTypes.SOULS, 0, (Integer val) -> val + 1);
            }

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        int souls = stack.getOrDefault(ModDataComponentTypes.SOULS, 0);

        tooltip.add(Text.literal("§8Souls collected §b" + souls + "§8/10§r"));

        int maxSouls = 10;
        String bar = "§b" + "▐".repeat(souls) + "§8" + "▐".repeat(maxSouls - souls);
        tooltip.add(Text.literal("§8[" + bar + "§8]§r"));

        super.appendTooltip(stack, context, tooltip, type);
    }
}
