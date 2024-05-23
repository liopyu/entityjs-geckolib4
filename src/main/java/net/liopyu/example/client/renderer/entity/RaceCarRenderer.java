package net.liopyu.example.client.renderer.entity;

import net.liopyu.example.client.model.entity.RaceCarModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.liopyu.example.entity.RaceCarEntity;
import net.liopyu.liolib.renderer.GeoEntityRenderer;

/**
 * Example {@link net.liopyu.liolib.renderer.GeoRenderer} implementation of an entity
 * @see RaceCarModel
 * @see RaceCarEntity
 */
public class RaceCarRenderer extends GeoEntityRenderer<RaceCarEntity> {
	public RaceCarRenderer(EntityRendererProvider.Context context) {
		super(context, new RaceCarModel());
	}
}