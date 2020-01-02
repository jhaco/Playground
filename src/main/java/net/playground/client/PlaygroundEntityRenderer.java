package net.playground.client;

import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.playground.client.render.*;
import net.playground.registry.PlaygroundEntities;

public class PlaygroundEntityRenderer {
    public static void init() {
        EntityRendererRegistry.INSTANCE.register(PlaygroundEntities.ABYSSAL_ZOMBIE, (dispatcher, context) -> new AbyssalZombieEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(PlaygroundEntities.SHADOW_BEAST, (dispatcher, context) -> new ShadowBeastEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(PlaygroundEntities.SHADOW_CREATURE, (dispatcher, context) -> new ShadowCreatureEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(PlaygroundEntities.SHADOW_MONSTER, (dispatcher, context) -> new ShadowMonsterEntityRenderer(dispatcher));
    }
}