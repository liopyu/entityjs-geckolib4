package net.liopyu.example.client.renderer.armor;

import net.liopyu.liolib.LioLib;
import net.minecraft.resources.ResourceLocation;
import net.liopyu.example.item.GeckoArmorItem;
import net.liopyu.example.item.WolfArmorItem;
import net.liopyu.liolib.LioLib;
import net.liopyu.liolib.model.DefaultedItemGeoModel;
import net.liopyu.liolib.renderer.GeoArmorRenderer;
import net.liopyu.liolib.renderer.GeoRenderer;
import net.liopyu.liolib.renderer.layer.AutoGlowingGeoLayer;

/**
 * Example {@link GeoRenderer} for the {@link WolfArmorItem} example item
 */
public final class GeckoArmorRenderer extends GeoArmorRenderer<GeckoArmorItem> {
	public GeckoArmorRenderer() {
		super(new DefaultedItemGeoModel<>(new ResourceLocation(LioLib.MOD_ID, "armor/gecko_armor")));

		addRenderLayer(new AutoGlowingGeoLayer<>(this));
	}
}
