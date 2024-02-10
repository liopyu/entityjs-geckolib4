package net.liopyu.example.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.Level;
import net.liopyu.example.client.model.entity.FakeGlassModel;
import net.liopyu.example.client.renderer.entity.FakeGlassRenderer;
import net.liopyu.geckojs.animatable.GeoEntity;
import net.liopyu.geckojs.core.animatable.GeoAnimatable;
import net.liopyu.geckojs.core.animation.AnimatableManager;
import net.liopyu.geckojs.core.animatable.instance.AnimatableInstanceCache;
import net.liopyu.geckojs.renderer.DynamicGeoEntityRenderer;
import net.liopyu.geckojs.util.GeckoLibUtil;

/**
 * Example {@link GeoAnimatable} implementation of an entity that uses the texture-per-bone feature of
 * {@link DynamicGeoEntityRenderer}
 * @see FakeGlassModel
 * @see FakeGlassRenderer
 */
public class FakeGlassEntity extends PathfinderMob implements GeoEntity {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

	public FakeGlassEntity(EntityType<? extends PathfinderMob> entityType, Level level) {
		super(entityType, level);
	}

	// We don't care about animations for this one
	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}
