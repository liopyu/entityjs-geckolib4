// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with LioLibMod
// Paste this class into your mod and follow the documentation for LioLibMod to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package net.liopyu.example.client.model.block;

import net.liopyu.example.block.entity.GeckoHabitatBlockEntity;
import net.liopyu.example.client.renderer.block.GeckoHabitatBlockRenderer;
import net.liopyu.liolib.LioLib;
import net.liopyu.liolib.model.DefaultedBlockGeoModel;
import net.liopyu.liolib.model.GeoModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

/**
 * Example {@link GeoModel} for the {@link GeckoHabitatBlockEntity}
 * @see GeckoHabitatBlockEntity
 * @see GeckoHabitatBlockRenderer
 */
public class GeckoHabitatModel extends DefaultedBlockGeoModel<GeckoHabitatBlockEntity> {
	public GeckoHabitatModel() {
		super(new ResourceLocation(LioLib.MOD_ID, "gecko_habitat"));
	}

	@Override
	public RenderType getRenderType(GeckoHabitatBlockEntity animatable, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureResource(animatable));
	}
}