package net.liopyu.example.entity;

import net.liopyu.example.client.model.entity.BatModel;
import net.liopyu.example.client.renderer.entity.BatRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.liopyu.liolib.animatable.GeoEntity;
import net.liopyu.liolib.constant.DefaultAnimations;
import net.liopyu.liolib.core.animatable.GeoAnimatable;
import net.liopyu.liolib.core.animatable.instance.AnimatableInstanceCache;
import net.liopyu.liolib.core.animation.AnimatableManager;
import net.liopyu.liolib.core.animation.AnimationController;
import net.liopyu.liolib.util.ClientUtils;
import net.liopyu.liolib.util.GeckoLibUtil;

/**
 * Example {@link GeoAnimatable} implementation of an entity
 * @see BatRenderer
 * @see BatModel
 */
public class BatEntity extends PathfinderMob implements GeoEntity {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

	private boolean isFlying = false;

	public BatEntity(EntityType<? extends PathfinderMob> type, Level worldIn) {
		super(type, worldIn);
	}

	// Have the bat look at the player
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 12.0F));
		super.registerGoals();
	}

	// Adds a right-click toggle that turns on/off its animating pose
	@Override
	public InteractionResult interactAt(Player player, Vec3 hitPos, InteractionHand hand) {
		if (hand == InteractionHand.MAIN_HAND)
			this.isFlying = !this.isFlying;

		return super.interactAt(player, hitPos, hand);
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(
				// Add our flying animation controller
				new AnimationController<>(this, 10, state -> state.setAndContinue(this.isFlying ? DefaultAnimations.FLY : DefaultAnimations.IDLE))
						// Handle the custom instruction keyframe that is part of our animation json
						.setCustomInstructionKeyframeHandler(state -> {
							Player player = ClientUtils.getClientPlayer();

							if (player != null)
								player.displayClientMessage(Component.literal("KeyFraming"), true);
						}),
				// Add our generic living animation controller
				DefaultAnimations.genericLivingController(this)
		);
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}
