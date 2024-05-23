package net.liopyu.example.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.liopyu.example.block.entity.FertilizerBlockEntity;
import net.liopyu.example.block.entity.GeckoHabitatBlockEntity;
import net.liopyu.liolib.LioLib;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.liopyu.liolib.LioLib;

public final class BlockEntityRegistry {

	public static final BlockEntityType<GeckoHabitatBlockEntity> GECKO_HABITAT = Registry.register(Registry.BLOCK_ENTITY_TYPE,
			LioLib.MOD_ID + ":habitat",
			FabricBlockEntityTypeBuilder.create(GeckoHabitatBlockEntity::new, BlockRegistry.GECKO_HABITAT_BLOCK).build(null));

	public static final BlockEntityType<FertilizerBlockEntity> FERTILIZER_BLOCK = Registry.register(Registry.BLOCK_ENTITY_TYPE,
			LioLib.MOD_ID + ":fertilizer",
			FabricBlockEntityTypeBuilder.create(FertilizerBlockEntity::new, BlockRegistry.FERTILIZER_BLOCK).build(null));
}
