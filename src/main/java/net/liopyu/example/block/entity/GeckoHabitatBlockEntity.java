package net.liopyu.example.block.entity;

import net.liopyu.example.client.model.block.GeckoHabitatModel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.liopyu.example.client.renderer.block.GeckoHabitatBlockRenderer;
import net.liopyu.example.registry.BlockEntityRegistry;
import net.liopyu.liolib.animatable.GeoBlockEntity;
import net.liopyu.liolib.constant.DefaultAnimations;
import net.liopyu.liolib.core.animatable.instance.AnimatableInstanceCache;
import net.liopyu.liolib.core.animation.AnimatableManager;
import net.liopyu.liolib.core.animation.AnimationController;
import net.liopyu.liolib.util.GeckoLibUtil;

/**
 * Example {@link BlockEntity} implementation using a LioLib model.
 * @see GeckoHabitatModel
 * @see GeckoHabitatBlockRenderer
 */
public class GeckoHabitatBlockEntity extends BlockEntity implements GeoBlockEntity {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

	public GeckoHabitatBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntityRegistry.GECKO_HABITAT, pos, state);
	}

	// We just want a permanent idle animation happening here
	// But if it's day time we want him to take a nap
	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(new AnimationController<>(this, state -> {
			if (getLevel().getDayTime() > 23000 || getLevel().getDayTime() < 13000) {
				return state.setAndContinue(DefaultAnimations.REST);
			}
			else {
				return state.setAndContinue(DefaultAnimations.IDLE);
			}
		}));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}
