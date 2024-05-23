package net.liopyu.example.client.renderer.entity;

import net.liopyu.example.client.model.entity.BikeModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.liopyu.example.entity.BikeEntity;
import net.liopyu.liolib.renderer.GeoEntityRenderer;

/**
 * Example {@link net.liopyu.liolib.renderer.GeoRenderer} for {@link BikeEntity}
 * @see BikeModel
 */
public class BikeRenderer extends GeoEntityRenderer<BikeEntity> {
	public BikeRenderer(EntityRendererProvider.Context context) {
		super(context, new BikeModel());
	}
}
