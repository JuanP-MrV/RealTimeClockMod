package net.mrvozka.realtimeclock;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.mrvozka.realtimeclock.config.ClientConfig;
import org.slf4j.Logger;

@Mod(RealTimeClockMod.MODID)
public class RealTimeClockMod {
    public static final String MODID = "realtimeclockmod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public RealTimeClockMod(IEventBus modEventBus, ModContainer modContainer) {
        // Register the client configuration so NeoForge creates and loads the config file.
        modContainer.registerConfig(ModConfig.Type.CLIENT, ClientConfig.CLIENT_SPEC);
    }
}