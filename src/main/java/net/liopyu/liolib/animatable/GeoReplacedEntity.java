package net.liopyu.liolib.animatable;

import net.liopyu.example.entity.ReplacedCreeperEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.liopyu.liolib.core.animatable.GeoAnimatable;
import net.liopyu.liolib.core.animation.AnimatableManager;
import net.liopyu.liolib.network.GeckoLibNetwork;
import net.liopyu.liolib.network.SerializableDataTicket;
import net.liopyu.liolib.network.packet.EntityAnimDataSyncPacket;
import net.liopyu.liolib.network.packet.EntityAnimTriggerPacket;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * The {@link GeoAnimatable} interface specific to {@link Entity Entities}.
 * This interface is <u>specifically</u> for entities replacing the rendering of other, existing entities.
 * @see ReplacedCreeperEntity
 * @see <a href="https://github.com/bernie-g/geckolib/wiki/Entity-Animations">LioLib Wiki - Entity Animations</a>
 */
public interface GeoReplacedEntity extends SingletonGeoAnimatable {
	/**
	 * Returns the {@link EntityType} this entity is intending to replace.<br>
	 * This is used for rendering an animation purposes.
	 */
	EntityType<?> getReplacingEntityType();

	/**
	 * Get server-synced animation data via its relevant {@link SerializableDataTicket}.<br>
	 * Should only be used on the <u>client-side</u>.<br>
	 * <b><u>DO NOT OVERRIDE</u></b>
	 * @param entity The entity instance relevant to the data being set
	 * @param dataTicket The data ticket for the data to retrieve
	 * @return The synced data, or null if no data of that type has been synced
	 */
	@Nullable
	default <D> D getAnimData(Entity entity, SerializableDataTicket<D> dataTicket) {
		return getAnimatableInstanceCache().getManagerForId(entity.getId()).getData(dataTicket);
	}

	/**
	 * Saves an arbitrary syncable piece of data to this animatable's {@link AnimatableManager}.<br>
	 * <b><u>DO NOT OVERRIDE</u></b>
	 * @param relatedEntity An entity related to the state of the data for syncing
	 * @param dataTicket The DataTicket to sync the data for
	 * @param data The data to sync
	 */
	default <D> void setAnimData(Entity relatedEntity, SerializableDataTicket<D> dataTicket, D data) {
		if (relatedEntity.getLevel().isClientSide()) {
			getAnimatableInstanceCache().getManagerForId(relatedEntity.getId()).setData(dataTicket, data);
		}
		else {
			EntityAnimDataSyncPacket<D> entityAnimDataSyncPacket = new EntityAnimDataSyncPacket<>(relatedEntity.getId(), dataTicket, data);
			GeckoLibNetwork.sendToTrackingEntityAndSelf(entityAnimDataSyncPacket, relatedEntity);
		}
	}

	/**
	 * Trigger an animation for this Entity, based on the controller name and animation name.<br>
	 * <b><u>DO NOT OVERRIDE</u></b>
	 * @param relatedEntity An entity related to the state of the data for syncing
	 * @param controllerName The name of the controller name the animation belongs to, or null to do an inefficient lazy search
	 * @param animName The name of animation to trigger. This needs to have been registered with the controller via {@link net.liopyu.liolib.core.animation.AnimationController#triggerableAnim AnimationController.triggerableAnim}
	 */
	default void triggerAnim(Entity relatedEntity, @Nullable String controllerName, String animName) {
		if (relatedEntity.getLevel().isClientSide()) {
			getAnimatableInstanceCache().getManagerForId(relatedEntity.getId()).tryTriggerAnimation(controllerName, animName);
		}
		else {
			EntityAnimTriggerPacket entityAnimTriggerPacket = new EntityAnimTriggerPacket(relatedEntity.getId(), controllerName, animName);
			GeckoLibNetwork.sendToTrackingEntityAndSelf(entityAnimTriggerPacket, relatedEntity);
		}
	}
	
	/**
	 * Returns the current age/tick of the animatable instance.<br>
	 * By default this is just the animatable's age in ticks, but this method allows for non-ticking custom animatables to provide their own values
	 * @param entity The Entity representing this animatable
	 * @return The current tick/age of the animatable, for animation purposes
	 */
	@Override
	default double getTick(Object entity) {
		return ((Entity)entity).tickCount;
	}

	// These methods aren't used for GeoReplacedEntity
	@Override
	default void createRenderer(Consumer<Object> consumer) {}

	// These methods aren't used for GeoReplacedEntity
	@Override
	default Supplier<Object> getRenderProvider() {
		return null;
	}
}
