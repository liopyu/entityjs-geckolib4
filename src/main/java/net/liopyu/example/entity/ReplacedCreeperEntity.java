package net.liopyu.example.entity;

import net.minecraft.world.entity.EntityType;
import net.liopyu.geckojs.animatable.GeoEntity;
import net.liopyu.geckojs.animatable.GeoReplacedEntity;
import net.liopyu.geckojs.constant.DefaultAnimations;
import net.liopyu.geckojs.core.animation.AnimatableManager;
import net.liopyu.geckojs.core.animatable.instance.AnimatableInstanceCache;
import net.liopyu.geckojs.util.GeckoLibUtil;

/**
 * Replacement {@link net.minecraft.world.entity.monster.Creeper} {@link GeoEntity} to showcase
 * replacing the model and animations of an existing entity
 * @see net.liopyu.geckojs.renderer.GeoReplacedEntityRenderer
 * @see net.liopyu.example.client.renderer.entity.ReplacedCreeperRenderer
 * @see net.liopyu.example.client.model.entity.ReplacedCreeperModel
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
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return cache;
	}

	@Override
	public EntityType<?> getReplacingEntityType() {
		return EntityType.CREEPER;
	}
}
