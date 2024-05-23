package net.liopyu.example.client.model.entity;

import net.liopyu.liolib.LioLib;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.liopyu.example.client.renderer.entity.FakeGlassRenderer;
import net.liopyu.example.entity.FakeGlassEntity;
import net.liopyu.liolib.model.DefaultedEntityGeoModel;
import net.liopyu.liolib.model.GeoModel;

/**
 * Example {@link GeoModel} for the {@link FakeGlassEntity}
 * @see FakeGlassRenderer
 */
public class FakeGlassModel extends DefaultedEntityGeoModel<FakeGlassEntity> {
	private static final ResourceLocation REDSTONE_BLOCK_TEXTURE =
			new ResourceLocation("minecraft", "textures/block/redstone_block.png");

	public FakeGlassModel() {
		super(new ResourceLocation(LioLib.MOD_ID, "fake_glass"));
	}

	// We just want our texture to be the Redstone Block texture
	@Override
	public ResourceLocation getTextureResource(FakeGlassEntity animatable) {
		return REDSTONE_BLOCK_TEXTURE;
	}

	// We want our entity to be translucent
	@Override
	public RenderType getRenderType(FakeGlassEntity animatable, ResourceLocation texture) {
		return RenderType.entityTranslucent(texture);
	}
}
