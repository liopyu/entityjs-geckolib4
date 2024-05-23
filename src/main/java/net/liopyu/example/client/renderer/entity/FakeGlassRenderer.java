package net.liopyu.example.client.renderer.entity;

import net.liopyu.example.client.model.entity.FakeGlassModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import net.liopyu.example.entity.FakeGlassEntity;
import net.liopyu.liolib.cache.object.GeoBone;
import net.liopyu.liolib.renderer.DynamicGeoEntityRenderer;

/**
 * Example {@link DynamicGeoEntityRenderer} implementation that makes use of the per-bone texture overrides feature
 * @see FakeGlassEntity
 * @see FakeGlassModel
 */
public class FakeGlassRenderer extends DynamicGeoEntityRenderer<FakeGlassEntity> {
	private static final ResourceLocation WHITE_STAINED_GLASS_TEXTURE =
			new ResourceLocation("textures/block/white_stained_glass.png");

	public FakeGlassRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new FakeGlassModel());
	}

	// If the bone named "outer_glass" is being rendered, render it using white stained-glass texture
	@Nullable
	@Override
	protected ResourceLocation getTextureOverrideForBone(GeoBone bone, FakeGlassEntity animatable, float partialTick) {
		return bone.getName().equals("outer_glass") ? WHITE_STAINED_GLASS_TEXTURE : null;
	}
}