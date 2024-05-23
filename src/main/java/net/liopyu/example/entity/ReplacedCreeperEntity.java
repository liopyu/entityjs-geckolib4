package net.liopyu.example.entity;

import net.liopyu.example.client.model.entity.ReplacedCreeperModel;
import net.liopyu.example.client.renderer.entity.ReplacedCreeperRenderer;
import net.minecraft.world.entity.EntityType;
import net.liopyu.liolib.animatable.GeoEntity;
import net.liopyu.liolib.animatable.GeoReplacedEntity;
import net.liopyu.liolib.constant.DefaultAnimations;
import net.liopyu.liolib.core.animatable.instance.AnimatableInstanceCache;
import net.liopyu.liolib.core.animation.AnimatableManager;
import net.liopyu.liolib.util.GeckoLibUtil;

/**
 * Replacement {@link net.minecraft.world.entity.monster.Creeper} {@link GeoEntity} to showcase
 * replacing the model and animations of an existing entity
 * @see net.liopyu.liolib.renderer.GeoReplacedEntityRenderer
 * @see ReplacedCreeperRenderer
 * @see ReplacedCreeperModel
 */
public class ReplacedCreeperEntity implements GeoReplacedEntity {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

	// Register the idle + walk animations for the entity.<br>
	// In this situation we're going to use a generic controller that is already built for us
	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(DefaultAnimations.genericWalkIdleController(this));
	}

	@Override
	public EntityType<?> getReplacingEntityType() {
		return EntityType.CREEPER;
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return cache;
	}
}
