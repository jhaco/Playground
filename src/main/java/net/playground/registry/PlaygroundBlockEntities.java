package net.playground.registry;

import java.util.function.Supplier;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;
import net.playground.Playground;
import net.playground.block.entity.BackpackEntity;

public class PlaygroundBlockEntities {

    public static final BlockEntityType<BackpackEntity> BACKPACK = register(
		"backpack",
		BackpackEntity::new,
		PlaygroundBlocks.BACKPACK
	);
    
    private PlaygroundBlockEntities() {
		
	}
	
	public static void init() {
		
	}
	
	private static <B extends BlockEntity> BlockEntityType<B> register(String name, Supplier<B> supplier, Block... supportedBlocks) {
		return Registry.register(Registry.BLOCK_ENTITY, Playground.id(name), BlockEntityType.Builder.create(supplier, supportedBlocks).build(null));
	}
}