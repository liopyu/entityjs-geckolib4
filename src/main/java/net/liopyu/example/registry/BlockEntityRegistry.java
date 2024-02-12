package net.liopyu.example.registry;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.liopyu.example.block.entity.GeckoHabitatBlockEntity;
import net.liopyu.example.block.entity.FertilizerBlockEntity;
import net.liopyu.liolib.LioLib;

public final class BlockEntityRegistry {
	public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister
			.create(ForgeRegistries.BLOCK_ENTITY_TYPES, LioLib.MOD_ID);

	public static final RegistryObject<BlockEntityType<GeckoHabitatBlockEntity>> GECKO_HABITAT = TILES
			.register("habitat", () -> BlockEntityType.Builder
					.of(GeckoHabitatBlockEntity::new, BlockRegistry.GECKO_HABITAT.get()).build(null));
	public static final RegistryObject<BlockEntityType<FertilizerBlockEntity>> FERTILIZER_BLOCK = TILES
			.register("fertilizer", () -> BlockEntityType.Builder
					.of(FertilizerBlockEntity::new, BlockRegistry.FERTILIZER.get()).build(null));
}
