package net.playground.registry;

import java.util.ArrayList;
import java.util.List;

import net.fabricmc.fabric.api.event.server.ServerTickCallback;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.dimension.DimensionType;

public class PlaygroundEventHandler {
    public static List<DimensionType> dimensions = new ArrayList<>();
    
    public static void init() {
        dimensions.add(DimensionType.OVERWORLD);
		ServerTickCallback.EVENT.register(server -> {
            dimensions.forEach(type -> {
                ServerWorld world = server.getWorld(type);
				
                if(!world.isRaining()) {
                    world.getLevelProperties().setRaining(true);
                }
            });
        });
    }
}