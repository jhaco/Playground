package net.playground.client;

import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.playground.client.render.AbyssalZombieEntityRenderer;
import net.playground.registry.PlaygroundEntities;

public class PlaygroundEntityRenderer {
    public static void init() {
        EntityRendererRegistry.INSTANCE.register(PlaygroundEntities.ABYSSAL_ZOMBIE, (dispatcher, context) -> new AbyssalZombieEntityRenderer(dispatcher));
    }
}