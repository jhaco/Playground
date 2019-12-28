package net.playground.block;

import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.EntityContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.playground.Playground;
import net.playground.block.entity.BackpackEntity;

public class Backpack extends HorizontalFacingBlock implements BlockEntityProvider {

	public Backpack(Settings settings) {
		super(settings);
		setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
		stateManager.add(Properties.HORIZONTAL_FACING);
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext ctx) {
		Direction dir = state.get(FACING);
		switch(dir) {
			case NORTH:
				return VoxelShapes.cuboid(0.2f, 0.0f, 0.3f, 0.8f, 0.7f, 0.6f);
			case SOUTH:
				return VoxelShapes.cuboid(0.2f, 0.0f, 0.4f, 0.8f, 0.7f, 0.7f);
			case EAST:
				return VoxelShapes.cuboid(0.4f, 0.0f, 0.2f, 0.7f, 0.7f, 0.8f);
			case WEST:
				return VoxelShapes.cuboid(0.3f, 0.0f, 0.2f, 0.6f, 0.7f, 0.8f);
			default:
				return VoxelShapes.fullCube();
		}
	}

	@Override
	public BlockEntity createBlockEntity(BlockView view) {
		return new BackpackEntity();
	}
 
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		return (BlockState)this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }
    
	public void onBlockRemoved(BlockState state, World world, BlockPos pos, BlockState newState, boolean bool) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof Inventory) {
                ItemScatterer.spawn(world, pos, (Inventory) blockEntity);
                world.updateHorizontalAdjacent(pos, this);
            }
            super.onBlockRemoved(state, world, pos, newState, bool);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult blockHitResult) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            if(!player.isSneaking()){
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity instanceof BackpackEntity) {
					ContainerProviderRegistry.INSTANCE.openContainer(Playground.id("backpack"), player, (buf)->{buf.writeBlockPos(pos);});
                }
            }
            return ActionResult.SUCCESS;
        }
    }
    

}