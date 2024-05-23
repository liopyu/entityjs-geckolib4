package net.liopyu.example.client.model.entity;

import net.liopyu.liolib.LioLib;
import net.minecraft.resources.ResourceLocation;
import net.liopyu.example.client.renderer.entity.BatRenderer;
import net.liopyu.example.entity.BatEntity;
import net.liopyu.liolib.model.DefaultedEntityGeoModel;
import net.liopyu.liolib.model.GeoModel;

/**
 * Example {@link GeoModel} for the {@link BatEntity}
 * @see BatRenderer
 */
public class BatModel extends DefaultedEntityGeoModel<BatEntity> {
	// We use the alternate super-constructor here to tell the model it should handle head-turning for us
	public BatModel() {
		super(new ResourceLocation(LioLib.MOD_ID, "bat"), true);
	}
}
