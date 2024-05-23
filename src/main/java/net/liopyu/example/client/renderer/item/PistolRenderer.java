package net.liopyu.example.client.renderer.item;

import net.liopyu.example.item.PistolItem;
import net.minecraft.resources.ResourceLocation;
import net.liopyu.liolib.LioLib;
import net.liopyu.liolib.model.DefaultedItemGeoModel;
import net.liopyu.liolib.renderer.GeoItemRenderer;

/**
 * Example {@link GeoItemRenderer} for {@link PistolItem}
 */
public class PistolRenderer extends GeoItemRenderer<PistolItem> {
	public PistolRenderer() {
		super(new DefaultedItemGeoModel<>(new ResourceLocation(LioLib.MOD_ID, "pistol")));
	}
}