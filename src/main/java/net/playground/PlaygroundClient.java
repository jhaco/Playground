package net.playground;

import net.fabricmc.api.ClientModInitializer;
import net.playground.client.PlaygroundColors;
import net.playground.client.PlaygroundContainers;
import net.playground.client.PlaygroundEntityRenderer;
import net.playground.client.PlaygroundRenderLayer;

public class PlaygroundClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		PlaygroundRenderLayer.init();
		PlaygroundColors.init();
		PlaygroundContainers.init();

		PlaygroundEntityRenderer.init();
	}
}