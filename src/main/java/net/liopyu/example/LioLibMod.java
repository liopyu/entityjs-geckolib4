package net.liopyu.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.liopyu.example.registry.BlockEntityRegistry;
import net.liopyu.example.registry.BlockRegistry;
import net.liopyu.example.registry.EntityRegistry;
import net.liopyu.example.registry.SoundRegistry;
import net.liopyu.liolib.LioLib;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.liopyu.example.registry.ItemRegistry;

public final class LioLibMod implements ModInitializer {

	public static final String DISABLE_EXAMPLES_PROPERTY_KEY = "geckolib.disable_examples";
	private static final boolean isDevelopmentEnvironment = FabricLoader.getInstance().isDevelopmentEnvironment();

	@Override
	public void onInitialize() {
		LioLib.initialize();
		if (!shouldRegisterExamples()) {
			return;
		}

		new EntityRegistry();
		registerEntityAttributes();

		new ItemRegistry();
		new BlockEntityRegistry();

		new BlockRegistry();
		new SoundRegistry();
	}

	private void registerEntityAttributes() {
		FabricDefaultAttributeRegistry.register(EntityRegistry.BIKE, createGenericEntityAttributes());
		FabricDefaultAttributeRegistry.register(EntityRegistry.RACE_CAR, createGenericEntityAttributes());

		FabricDefaultAttributeRegistry.register(EntityRegistry.BAT, createGenericEntityAttributes());
		FabricDefaultAttributeRegistry.register(EntityRegistry.MUTANT_ZOMBIE, createGenericEntityAttributes());
		FabricDefaultAttributeRegistry.register(EntityRegistry.GREMLIN, createGenericEntityAttributes());

		FabricDefaultAttributeRegistry.register(EntityRegistry.COOL_KID, createGenericEntityAttributes());
		FabricDefaultAttributeRegistry.register(EntityRegistry.FAKE_GLASS, createGenericEntityAttributes());

		FabricDefaultAttributeRegistry.register(EntityRegistry.PARASITE, createGenericEntityAttributes());
	}

	private static AttributeSupplier.Builder createGenericEntityAttributes() {
		return PathfinderMob.createLivingAttributes().add(Attributes.MOVEMENT_SPEED, 0.80000000298023224D)
				.add(Attributes.FOLLOW_RANGE, 16.0D).add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.ATTACK_DAMAGE, 5)
				.add(Attributes.ATTACK_KNOCKBACK, 0.1);
	}

	/**
	 * By default, LioLib will register and activate several example entities,
	 * items, and blocks when in dev.<br>
	 * These examples are <u>not</u> present when in a production environment
	 * (normal players).<br>
	 * This can be disabled by setting the
	 * {@link LioLibMod#DISABLE_EXAMPLES_PROPERTY_KEY} to false in your run args
	 */
	static boolean shouldRegisterExamples() {
		return isDevelopmentEnvironment && !Boolean.getBoolean(DISABLE_EXAMPLES_PROPERTY_KEY);
	}
}
