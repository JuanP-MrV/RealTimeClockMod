package net.mrvozka.realtimeclock.event;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.mrvozka.realtimeclock.RealTimeClockMod;
import net.mrvozka.realtimeclock.client.RealTimeOverlay;

@EventBusSubscriber(modid = RealTimeClockMod.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ClientEvents {

    @SubscribeEvent
    public static void registerGuiLayers(RegisterGuiLayersEvent event) {
        // Register the time overlay above all other layers.
        event.registerAboveAll(RealTimeOverlay.ID, RealTimeOverlay.HUD_TIME);
    }
}
