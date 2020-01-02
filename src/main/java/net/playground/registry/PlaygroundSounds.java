package net.playground.registry;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.registry.Registry;
import net.playground.Playground;

public class PlaygroundSounds {
    public static final SoundEvent ABYSSAL_ZOMBIE_AMBIENT = register("entity.abyssal_zombie.ambient");
	public static final SoundEvent ABYSSAL_ZOMBIE_HURT = register("entity.abyssal_zombie.hurt");
	public static final SoundEvent ABYSSAL_ZOMBIE_DEATH = register("entity.abyssal_zombie.death");

	public static final SoundEvent SHADOW_CREATURE_HURT = register("entity.shadow_creature.hurt");
	public static final SoundEvent SHADOW_CREATURE_DEATH = register("entity.shadow_creature.death");
	
	private PlaygroundSounds() {
		
	}
	
	public static void init() {
		
	}
	
	private static SoundEvent register(String name) {
		return Registry.register(Registry.SOUND_EVENT, Playground.id(name), new SoundEvent(Playground.id(name)));
	}
}