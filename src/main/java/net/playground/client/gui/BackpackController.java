package net.playground.client.gui;

import io.github.cottonmc.cotton.gui.CottonCraftingController;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.container.BlockContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.playground.block.entity.BackpackEntity;

public class BackpackController extends CottonCraftingController {
    BackpackEntity backpackEntity;

    public BackpackController(int syncId, PlayerInventory playerInv, BlockContext ctx) {
        super(null, syncId, playerInv, getBlockInventory(ctx), getBlockPropertyDelegate(ctx));

        backpackEntity = ctx.run((world, pos)->{
            BlockEntity blockEntity = world.getBlockEntity(pos);
    
            if(blockEntity instanceof BackpackEntity){
                return (BackpackEntity) blockEntity;
            }
    
            else return null;
        }).orElse(null);

        backpackEntity.onInvOpen(playerInv.player);
        
        WGridPanel root = (WGridPanel) getRootPanel();

        root.add(new WLabel("Backpack", WLabel.DEFAULT_TEXT_COLOR), 0, 0);
        
        WItemSlot invSlots = WItemSlot.of(blockInventory, 0, 9, 3);
        root.add(invSlots, 0, 1);
        root.add(this.createPlayerInventoryPanel(), 0, 5);
        root.validate(this);
    }

    @Override
    public int getCraftingResultSlotIndex() {return -1;}

    @Override
    public void close(PlayerEntity player) {
        backpackEntity.onInvClose(player);
        super.close(player);
    }
    
}
