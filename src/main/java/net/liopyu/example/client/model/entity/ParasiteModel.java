package net.liopyu.example.client.model.entity;

import net.liopyu.liolib.LioLib;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.liopyu.example.client.renderer.entity.ParasiteRenderer;
import net.liopyu.example.entity.ParasiteEntity;
import net.liopyu.liolib.model.DefaultedEntityGeoModel;
import net.liopyu.liolib.model.GeoModel;

/**
 * Example {@link GeoModel} for the {@link ParasiteEntity}
 * @see ParasiteRenderer
 */
public class ParasiteModel extends DefaultedEntityGeoModel<ParasiteEntity> {
	public ParasiteModel() {
		super(new ResourceLocation(LioLib.MOD_ID, "parasite"));
	}

	// We want our model to render using the translucent render type
	@Override
	public RenderType getRenderType(ParasiteEntity animatable, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureResource(animatable));
	}
}