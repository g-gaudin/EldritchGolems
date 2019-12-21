package fadiese.eldritchgolems.blocks;

import fadiese.eldritchgolems.EldritchGolemsItems;
import fadiese.eldritchgolems.entities.WoodenGolemEntity;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.pattern.BlockMaterialMatcher;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.CachedBlockInfo;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class GolemHead extends Block {
    @Nullable
    private BlockPattern golemPattern;
    private static final Predicate<BlockState> IS_GOLEMHEAD = (blockState) -> blockState != null && blockState.getBlock() == EldritchGolemsItems.GOLEMHEAD;

    public GolemHead() {
        super(Properties.create(Material.ROCK)
        .sound(SoundType.STONE)
        .hardnessAndResistance(1.0f)
        .lightValue(10));
        setRegistryName("golemhead");
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer,
                                ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        trySpawnGolem(worldIn, pos,placer);
    }
    private void trySpawnGolem(World world, BlockPos pos,@Nullable LivingEntity placer) {
        BlockPattern.PatternHelper blockpattern$patternhelper = this.getGolemPattern().match(world, pos);
        if (blockpattern$patternhelper != null) {
            for (int j = 0; j < this.getGolemPattern().getPalmLength(); ++j) {
                for (int k = 0; k < this.getGolemPattern().getThumbLength(); ++k) {
                    CachedBlockInfo cachedblockinfo2 = blockpattern$patternhelper.translateOffset(j, k, 0);
                    world.setBlockState(cachedblockinfo2.getPos(), Blocks.AIR.getDefaultState(), 2);
                    world.playEvent(2001, cachedblockinfo2.getPos(), Block.getStateId(cachedblockinfo2.getBlockState()));
                }
            }

            BlockPos blockpos = blockpattern$patternhelper.translateOffset(1, 2, 0).getPos();
            WoodenGolemEntity woodenGolemEntity = EldritchGolemsItems.WOODENGOLEM.create(world);
            woodenGolemEntity.setCreatedBy(placer);
            woodenGolemEntity.setLocationAndAngles((double) blockpos.getX() + 0.5D, (double) blockpos.getY() + 0.05D, (double) blockpos.getZ() + 0.5D, 0.0F, 0.0F);
            world.addEntity(woodenGolemEntity);

            for (ServerPlayerEntity serverplayerentity1 : world.getEntitiesWithinAABB(ServerPlayerEntity.class, woodenGolemEntity.getBoundingBox().grow(5.0D))) {
                CriteriaTriggers.SUMMONED_ENTITY.trigger(serverplayerentity1, woodenGolemEntity);
            }

            for (int i1 = 0; i1 < this.getGolemPattern().getPalmLength(); ++i1) {
                for (int j1 = 0; j1 < this.getGolemPattern().getThumbLength(); ++j1) {
                    CachedBlockInfo cachedblockinfo1 = blockpattern$patternhelper.translateOffset(i1, j1, 0);
                    world.notifyNeighbors(cachedblockinfo1.getPos(), Blocks.AIR);
                }
            }
        }
    }

    private BlockPattern getGolemPattern() {
        if (this.golemPattern == null) {
            this.golemPattern = BlockPatternBuilder.start().aisle("~^~", "###", "~#~").where('^', CachedBlockInfo.hasState(IS_GOLEMHEAD)).where('#', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(Blocks.SPRUCE_LOG))).where('~', CachedBlockInfo.hasState(BlockMaterialMatcher.forMaterial(Material.AIR))).build();
        }

        return this.golemPattern;
    }
}
