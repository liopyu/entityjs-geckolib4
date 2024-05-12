/*
 * Copyright (c) 2020.
 * Author: Bernie G. (Gecko)
 */

package net.liopyu.example;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.liopyu.example.client.renderer.block.FertilizerBlockRenderer;
import net.liopyu.example.client.renderer.block.GeckoHabitatBlockRenderer;
import net.liopyu.example.client.renderer.entity.*;
import net.liopyu.example.registry.BlockEntityRegistry;
import net.liopyu.example.registry.BlockRegistry;
import net.liopyu.example.registry.EntityRegistry;
import net.liopyu.liolib.LioLib;

@Mod.EventBusSubscriber(modid = LioLib.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientListener {
	@SubscribeEvent
	public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
		if (LioLibMod.shouldRegisterExamples()) {
			event.registerEntityRenderer(EntityRegistry.BAT.get(), BatRenderer::new);
			event.registerEntityRenderer(EntityRegistry.BIKE.get(), BikeRenderer::new);
			event.registerEntityRenderer(EntityRegistry.RACE_CAR.get(), RaceCarRenderer::new);
			event.registerEntityRenderer(EntityRegistry.PARASITE.get(), ParasiteRenderer::new);
			event.registerEntityRenderer(EntityRegistry.COOL_KID.get(), CoolKidRenderer::new);
			event.registerEntityRenderer(EntityRegistry.MUTANT_ZOMBIE.get(), MutantZombieRenderer::new);
			event.registerEntityRenderer(EntityRegistry.GREMLIN.get(), GremlinRenderer::new);
			event.registerEntityRenderer(EntityRegistry.FAKE_GLASS.get(), FakeGlassRenderer::new);

			event.registerEntityRenderer(EntityType.CREEPER, ReplacedCreeperRenderer::new);

			event.registerBlockEntityRenderer(BlockEntityRegistry.GECKO_HABITAT.get(), context -> new GeckoHabitatBlockRenderer());
			event.registerBlockEntityRenderer(BlockEntityRegistry.FERTILIZER_BLOCK.get(), context -> new FertilizerBlockRenderer());
		}
	}

	@SubscribeEvent
	public static void registerRenderers(final FMLClientSetupEvent event) {
		if (LioLibMod.shouldRegisterExamples())
			ItemBlockRenderTypes.setRenderLayer(BlockRegistry.GECKO_HABITAT.get(), RenderType.translucent());
	}
}
