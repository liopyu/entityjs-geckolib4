package net.liopyu.example.client.model.entity;

import net.liopyu.example.client.renderer.entity.GremlinRenderer;
import net.liopyu.liolib.LioLib;
import net.minecraft.resources.ResourceLocation;
import net.liopyu.example.entity.DynamicExampleEntity;
import net.liopyu.liolib.model.DefaultedEntityGeoModel;
import net.liopyu.liolib.model.GeoModel;

/**
 * Example {@link GeoModel} for the {@link DynamicExampleEntity}
 * @see GremlinRenderer
 */
public class GremlinModel extends DefaultedEntityGeoModel<DynamicExampleEntity> {
	public GremlinModel() {
		super(new ResourceLocation(LioLib.MOD_ID, "gremlin"));
	}
}