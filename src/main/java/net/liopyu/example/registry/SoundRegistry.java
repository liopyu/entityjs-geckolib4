package net.liopyu.example.registry;

import net.liopyu.liolib.LioLib;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public final class SoundRegistry {

	public static SoundEvent JACK_MUSIC = Registry.register(Registry.SOUND_EVENT, "jack_in_the_box_music",
		new	SoundEvent(new ResourceLocation(LioLib.MOD_ID, "jack_in_the_box_music"), 0));

}
