package net.liopyu.example.client.model.entity;

import net.liopyu.liolib.LioLib;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.liopyu.example.client.renderer.entity.BikeRenderer;
import net.liopyu.example.entity.BikeEntity;
import net.liopyu.liolib.model.DefaultedEntityGeoModel;
import net.liopyu.liolib.model.GeoModel;

/**
 * Example {@link GeoModel} for the {@link BikeEntity}
 * @see BikeRenderer
 */
public class BikeModel extends DefaultedEntityGeoModel<BikeEntity> {
	public BikeModel() {
		super(new ResourceLocation(LioLib.MOD_ID, "bike"));
	}

	// We want this entity to have a translucent render
	@Override
	public RenderType getRenderType(BikeEntity animatable, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureResource(animatable));
	}
}
