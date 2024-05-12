package net.liopyu.liolib;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.liopyu.liolib.cache.GeckoLibCache;
import net.liopyu.liolib.network.GeckoLibNetwork;

/**
 * Base class for LioLib!<br>
 * Hello World!<br>
 * There's not much to really see here, but feel free to stay a while and have a snack or something.
 * @see net.liopyu.liolib.util.GeckoLibUtil
 * @see <a href="https://github.com/bernie-g/geckolib/wiki/Getting-Started">GeckoLib Wiki - Getting Started</a>
 */
public class LioLib {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "liolib";
	public static volatile boolean hasInitialized;

	/**
	 * This method <u><b>MUST</b></u> be called in your mod's constructor or during {@code onInitializeClient} in Fabric/Quilt.<br>
	 * If shadowing {@code LioLib}, you should instead call {@link LioLib#shadowInit}
	 * Note that doing so will prevent {@link net.liopyu.liolib.renderer.GeoItemRenderer Items} from animating properly
	 */
	synchronized public static void initialize() {
		if (!hasInitialized) {
			DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> GeckoLibCache::registerReloadListener);
			GeckoLibNetwork.init();
		}

		hasInitialized = true;
	}

	/**
	 * Call this method instead of {@link LioLib#initialize} if you are shadowing the mod.
	 */
	synchronized public static void shadowInit() {
		if (!hasInitialized)
			DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> GeckoLibCache::registerReloadListener);

		hasInitialized = true;
	}
}
