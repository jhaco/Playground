package net.playground.client;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.fabricmc.fabric.api.client.screen.ScreenProviderRegistry;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.minecraft.container.BlockContext;
import net.playground.Playground;
import net.playground.client.gui.BackpackController;

public class PlaygroundContainers {
    public static void init() {
        ScreenProviderRegistry.INSTANCE.registerFactory(Playground.id("backpack"), (syncId, id, player, buf) -> {
            return new CottonInventoryScreen<BackpackController>(new BackpackController(syncId, player.inventory, BlockContext.create(player.world, buf.readBlockPos())), player);
        });
        ContainerProviderRegistry.INSTANCE.registerFactory(Playground.id("backpack"), (syncId, id, player, buf) -> {
            return new BackpackController(syncId, player.inventory, BlockContext.create(player.world, buf.readBlockPos()));
        });
    }

    
}