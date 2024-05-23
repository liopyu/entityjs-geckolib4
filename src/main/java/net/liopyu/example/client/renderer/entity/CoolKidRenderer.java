package net.liopyu.example.client.renderer.entity;

import net.liopyu.liolib.LioLib;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.liopyu.example.client.renderer.entity.layer.CoolKidGlassesLayer;
import net.liopyu.example.entity.CoolKidEntity;
import net.liopyu.liolib.model.DefaultedEntityGeoModel;
import net.liopyu.liolib.renderer.GeoEntityRenderer;

/**
 * Example {@link net.liopyu.liolib.renderer.GeoRenderer} implementation of an entity that uses a {@link net.liopyu.liolib.renderer.layer.GeoRenderLayer render layer}
 * @see CoolKidGlassesLayer
 * @see CoolKidEntity
 */
public class CoolKidRenderer extends GeoEntityRenderer<CoolKidEntity> {
	public CoolKidRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultedEntityGeoModel<>(new ResourceLocation(LioLib.MOD_ID, "cool_kid")));

		this.shadowRadius = 0.25f;

		// Add our render layer
		addRenderLayer(new CoolKidGlassesLayer(this));
    }
}
