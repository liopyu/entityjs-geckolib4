package net.liopyu.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.liopyu.example.client.renderer.block.FertilizerBlockRenderer;
import net.liopyu.example.client.renderer.block.GeckoHabitatBlockRenderer;
import net.liopyu.example.registry.BlockEntityRegistry;
import net.liopyu.example.registry.BlockRegistry;
import net.liopyu.example.registry.EntityRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.EntityType;
import net.liopyu.example.client.renderer.entity.BatRenderer;
import net.liopyu.example.client.renderer.entity.BikeRenderer;
import net.liopyu.example.client.renderer.entity.CoolKidRenderer;
import net.liopyu.example.client.renderer.entity.FakeGlassRenderer;
import net.liopyu.example.client.renderer.entity.GremlinRenderer;
import net.liopyu.example.client.renderer.entity.MutantZombieRenderer;
import net.liopyu.example.client.renderer.entity.ParasiteRenderer;
import net.liopyu.example.client.renderer.entity.RaceCarRenderer;
import net.liopyu.example.client.renderer.entity.ReplacedCreeperRenderer;
import net.liopyu.liolib.network.GeckoLibNetwork;

public final class ClientListener implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		if (LioLibMod.shouldRegisterExamples())
			registerRenderers();
		registerNetwork();
	}

	private static void registerRenderers() {
		EntityRendererRegistry.register(EntityRegistry.BAT, BatRenderer::new);
		EntityRendererRegistry.register(EntityRegistry.BIKE, BikeRenderer::new);
		EntityRendererRegistry.register(EntityRegistry.RACE_CAR, RaceCarRenderer::new);

		EntityRendererRegistry.register(EntityRegistry.PARASITE, ParasiteRenderer::new);
		EntityRendererRegistry.register(EntityRegistry.COOL_KID, CoolKidRenderer::new);
		EntityRendererRegistry.register(EntityRegistry.MUTANT_ZOMBIE, MutantZombieRenderer::new);
		EntityRendererRegistry.register(EntityRegistry.GREMLIN, GremlinRenderer::new);

		EntityRendererRegistry.register(EntityRegistry.FAKE_GLASS, FakeGlassRenderer::new);
		EntityRendererRegistry.register(EntityType.CREEPER, ReplacedCreeperRenderer::new);

		BlockEntityRendererRegistry.register(BlockEntityRegistry.GECKO_HABITAT,
				context -> new GeckoHabitatBlockRenderer());
		BlockEntityRendererRegistry.register(BlockEntityRegistry.FERTILIZER_BLOCK,
				context -> new FertilizerBlockRenderer());

		BlockRenderLayerMapImpl.INSTANCE.putBlock(BlockRegistry.GECKO_HABITAT_BLOCK, RenderType.translucent());
	}

	private static void registerNetwork() {
		GeckoLibNetwork.registerClientReceiverPackets();
	}
}
