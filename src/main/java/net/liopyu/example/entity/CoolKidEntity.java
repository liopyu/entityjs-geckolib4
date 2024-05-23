package net.liopyu.example.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.liopyu.liolib.animatable.GeoEntity;
import net.liopyu.liolib.constant.DefaultAnimations;
import net.liopyu.liolib.core.animatable.GeoAnimatable;
import net.liopyu.liolib.core.animatable.instance.AnimatableInstanceCache;
import net.liopyu.liolib.core.animation.AnimatableManager;
import net.liopyu.liolib.core.animation.AnimationController;
import net.liopyu.liolib.util.GeckoLibUtil;

/**
 * Example {@link GeoAnimatable} implementation of an entity that uses a render layer
 */
public class CoolKidEntity extends PathfinderMob implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public CoolKidEntity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }

    // Add a goal to have the entity look at the player
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        super.registerGoals();
    }

    // Add a generic idle controller, with a 5-tick transition time
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "idle", 5, state -> state.setAndContinue(DefaultAnimations.IDLE)));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
