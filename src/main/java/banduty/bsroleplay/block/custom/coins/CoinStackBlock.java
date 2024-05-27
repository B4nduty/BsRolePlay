
package banduty.bsroleplay.block.custom.coins;

import banduty.bsroleplay.block.ModBlocks;
import banduty.bsroleplay.block.entity.coins.stack.AmethystCoinStackBlockEntity;
import banduty.bsroleplay.block.entity.coins.stack.CopperCoinStackBlockEntity;
import banduty.bsroleplay.block.entity.coins.stack.GoldCoinStackBlockEntity;
import banduty.bsroleplay.block.entity.coins.stack.NetheriteCoinStackBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class CoinStackBlock extends BlockWithEntity {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    public static final MapCodec<CoinStackBlock> CODEC = createCodec(CoinStackBlock::new);
    protected static final VoxelShape SHAPE = createCuboidShape(0.0, 0.0, 0.0, 16.0, 7.0, 16.0);

    public CoinStackBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<? extends CoinStackBlock> getCodec() {
        return CODEC;
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    @SuppressWarnings("deprecation")
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    @SuppressWarnings("deprecation")
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        if (state.getBlock() == ModBlocks.COPPER_COIN_STACK) return new CopperCoinStackBlockEntity(pos, state);
        if (state.getBlock() == ModBlocks.GOLD_COIN_STACK) return new GoldCoinStackBlockEntity(pos, state);
        if (state.getBlock() == ModBlocks.AMETHYST_COIN_STACK) return new AmethystCoinStackBlockEntity(pos, state);
        if (state.getBlock() == ModBlocks.NETHERITE_COIN_STACK) return new NetheriteCoinStackBlockEntity(pos, state);
        return new CopperCoinStackBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}