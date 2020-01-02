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
import net.playground.entity.*;
import net.playground.mixin.SpawnRestrictor;

public class PlaygroundEntities {
	public static final EntityType<AbyssalZombieEntity> ABYSSAL_ZOMBIE = register("abyssal_zombie", FabricEntityTypeBuilder.create(EntityCategory.MONSTER, AbyssalZombieEntity::new).size(EntityDimensions.fixed(0.6F, 1.96F)).build());
	public static final EntityType<ShadowBeastEntity> SHADOW_BEAST = register("shadow_beast", FabricEntityTypeBuilder.create(EntityCategory.MONSTER, ShadowBeastEntity::new).size(EntityDimensions.fixed(1.8F, 2.96F)).build());
	public static final EntityType<ShadowCreatureEntity> SHADOW_CREATURE = register("shadow_creature", FabricEntityTypeBuilder.create(EntityCategory.MONSTER, ShadowCreatureEntity::new).size(EntityDimensions.fixed(0.8F, 0.96F)).build());
	public static final EntityType<ShadowMonsterEntity> SHADOW_MONSTER = register("shadow_monster", FabricEntityTypeBuilder.create(EntityCategory.MONSTER, ShadowMonsterEntity::new).size(EntityDimensions.fixed(0.8F, 1.96F)).build());

    private PlaygroundEntities() {
		
	}
	
	public static void init() {
		@SuppressWarnings("unused") Object classloading = SpawnRestriction.class;
		SpawnRestrictor.invokeRegister(PlaygroundEntities.ABYSSAL_ZOMBIE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
		SpawnRestrictor.invokeRegister(PlaygroundEntities.SHADOW_BEAST, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
		SpawnRestrictor.invokeRegister(PlaygroundEntities.SHADOW_CREATURE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
		SpawnRestrictor.invokeRegister(PlaygroundEntities.SHADOW_MONSTER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);

		addRegistryProcessor(Registry.BIOME, biome -> {
			List<Biome.SpawnEntry> spawnList = biome.getEntitySpawnList(EntityCategory.MONSTER);
			int abyssal_zombie = 0;
			int shadow = 0;
			for (Biome.SpawnEntry spawnEntry : spawnList) {
				if (spawnEntry.type == EntityType.ZOMBIE) {
					abyssal_zombie = 4;
				}
				if (spawnEntry.type == EntityType.SKELETON || spawnEntry.type == EntityType.WITHER_SKELETON) {
					shadow = 4;
				}
			}
			spawnList.add(new Biome.SpawnEntry(PlaygroundEntities.ABYSSAL_ZOMBIE, abyssal_zombie, 1, 1));
			spawnList.add(new Biome.SpawnEntry(PlaygroundEntities.SHADOW_BEAST, shadow, 1, 1));
			spawnList.add(new Biome.SpawnEntry(PlaygroundEntities.SHADOW_CREATURE, shadow, 1, 4));
			spawnList.add(new Biome.SpawnEntry(PlaygroundEntities.SHADOW_MONSTER, shadow, 1, 4));
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