package net.liopyu.example.client.model.entity;

import net.liopyu.liolib.LioLib;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.liopyu.example.client.renderer.entity.RaceCarRenderer;
import net.liopyu.example.entity.RaceCarEntity;
import net.liopyu.liolib.model.DefaultedEntityGeoModel;
import net.liopyu.liolib.model.GeoModel;

/**
 * Example {@link GeoModel} for the {@link RaceCarEntity}
 * @see RaceCarRenderer
 */
public class RaceCarModel extends DefaultedEntityGeoModel<RaceCarEntity> {
	public RaceCarModel() {
		super(new ResourceLocation(LioLib.MOD_ID, "race_car"));
	}

	// We want our model to render using the translucent render type
	@Override
	public RenderType getRenderType(RaceCarEntity animatable, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureResource(animatable));
	}
}