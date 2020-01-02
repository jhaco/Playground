package net.playground.block.entity;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.container.GenericContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.DoubleInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.playground.block.BackpackBlock;
import net.playground.registry.PlaygroundBlockEntities;
import net.playground.api.ImplementedInventory;

public class BackpackEntity extends BlockEntity implements ImplementedInventory {
    private final DefaultedList<ItemStack> inv = DefaultedList.ofSize(27, ItemStack.EMPTY);
    protected int viewerCount;
    protected boolean isOpen;

    public BackpackEntity() {
        super(PlaygroundBlockEntities.BACKPACK); 
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inv;
    }

    @Override
    public void fromTag(CompoundTag tag) {
        super.fromTag(tag);
        Inventories.fromTag(tag, inv);
    }
 
    @Override
    public CompoundTag toTag(CompoundTag tag) {
        Inventories.toTag(tag, inv);
        return super.toTag(tag);
    }

    public static int countViewers(World world, BackpackEntity backpackEntity, BlockPos pos) {
        int viewerCount = 0;
        List<PlayerEntity> players = world.getEntities(PlayerEntity.class,
                new Box((double) ((float) pos.getX() - 5.0F), (double) ((float) pos.getY() - 5.0F),
                        (double) ((float) pos.getZ() - 5.0F), (double) ((float) (pos.getX() + 1) + 5.0F),
                        (double) ((float) (pos.getY() + 1) + 5.0F), (double) ((float) (pos.getZ() + 1) + 5.0F)), null);
        Iterator<PlayerEntity> itr = players.iterator();

        while (true) {
            Inventory inv;
            do {
                PlayerEntity player;
                do {
                    if (!itr.hasNext()) {
                        return viewerCount;
                    }

                    player = itr.next();
                } while (!(player.container instanceof GenericContainer));

                inv = ((GenericContainer) player.container).getInventory();
            } while (inv != backpackEntity && (!(inv instanceof DoubleInventory)
                    || !((DoubleInventory) inv).isPart(backpackEntity)));

            ++viewerCount;
        }
    }

    public void onInvOpen(PlayerEntity playerEntity_1) {
        if (!playerEntity_1.isSpectator()) {
            if (this.viewerCount < 0) {
                this.viewerCount = 0;
            }

            ++this.viewerCount;

            isOpen = true;
            
            this.scheduleUpdate();
        }

    }

    public void onInvClose(PlayerEntity player) {
        if (!player.isSpectator()) {
            --this.viewerCount;
        }

        if(this.viewerCount <= 0){
            this.viewerCount = 0;
            isOpen = false;
        }
        this.scheduleUpdate();
    }

    public void update() {
        this.viewerCount = countViewers(world, this, pos);
        if (this.viewerCount > 0) {
            this.scheduleUpdate();
        } else {
            BlockState state = this.getCachedState();
            if (!(state.getBlock() instanceof BackpackBlock)) {
                this.markInvalid();
                return;
            }
        }
    }

    private void scheduleUpdate() {
        this.world.getBlockTickScheduler().schedule(this.getPos(), this.getCachedState().getBlock(), 5);
    }

    public boolean isOpen(){
        return isOpen;
    }

}