package net.liopyu.example.client.renderer.item;

import net.liopyu.example.item.JackInTheBoxItem;
import net.minecraft.resources.ResourceLocation;
import net.liopyu.liolib.LioLib;
import net.liopyu.liolib.model.DefaultedItemGeoModel;
import net.liopyu.liolib.renderer.GeoItemRenderer;

/**
 * Example {@link GeoItemRenderer} for {@link JackInTheBoxItem}
 */
public class JackInTheBoxRenderer extends GeoItemRenderer<JackInTheBoxItem> {
	public JackInTheBoxRenderer() {
		super(new DefaultedItemGeoModel<>(new ResourceLocation(LioLib.MOD_ID, "jack_in_the_box")));
	}
}
