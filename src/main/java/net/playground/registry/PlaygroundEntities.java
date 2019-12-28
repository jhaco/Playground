package net.playground.registry;

import java.util.List;
import java.util.function.Consumer;

import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.Heightmap;
import net.playground.Playground;
import net.playground.entity.AbyssalZombieEntity;
import net.playground.mixin.SpawnRestrictor;

public class PlaygroundEntities {
    public static final EntityType<AbyssalZombieEntity> ABYSSAL_ZOMBIE = register("abyssal_zombie", FabricEntityTypeBuilder.create(EntityCategory.MONSTER, AbyssalZombieEntity::new).size(EntityDimensions.fixed(0.7F, 2F)).build());

    private PlaygroundEntities() {
		
	}
	
	public static void init() {
		@SuppressWarnings("unused") Object classloading = SpawnRestriction.class;
		SpawnRestrictor.invokeRegister(PlaygroundEntities.ABYSSAL_ZOMBIE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);

		addRegistryProcessor(Registry.BIOME, biome -> {
			List<Biome.SpawnEntry> spawnList = biome.getEntitySpawnList(EntityCategory.MONSTER);
				spawnList.add(new Biome.SpawnEntry(PlaygroundEntities.ABYSSAL_ZOMBIE, 4, 1, 1));
		});
	}
	
	private static <T extends Entity> EntityType<T> register(String name, EntityType<T> entity) {
		return Registry.register(Registry.ENTITY_TYPE, Playground.id(name), entity);
	}

	private static <T> void addRegistryProcessor(Registry<T> registry, Consumer<T> visitor) {
		registry.forEach(visitor);
		RegistryEntryAddedCallback.event(registry).register((rawId, id, object) -> visitor.accept(object));
	}

}