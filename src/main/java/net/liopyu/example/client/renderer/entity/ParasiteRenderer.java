package net.liopyu.example.client.renderer.entity;

import net.liopyu.example.client.model.entity.ParasiteModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.liopyu.example.entity.ParasiteEntity;
import net.liopyu.liolib.renderer.GeoEntityRenderer;

/**
 * Example {@link net.liopyu.liolib.renderer.GeoRenderer} implementation of an entity
 * @see ParasiteModel
 * @see ParasiteEntity
 */
public class ParasiteRenderer extends GeoEntityRenderer<ParasiteEntity> {
	public ParasiteRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new ParasiteModel());
	}
}
