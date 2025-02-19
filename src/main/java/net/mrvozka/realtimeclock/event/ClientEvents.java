package net.mrvozka.realtimeclock.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mrvozka.realtimeclock.RealTimeClockMod;
import net.mrvozka.realtimeclock.client.RealTimeOverlay;
import org.jetbrains.annotations.NotNull;

public class ClientEvents {

    @Mod.EventBusSubscriber(modid = RealTimeClockMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {

        @SubscribeEvent
        public static void registerGuiOverlays(@NotNull RegisterGuiOverlaysEvent event) {
            // Registra el overlay de la hora por encima del chat.
            // El primer parámetro es el ID de nuestro overlay ("time"), el segundo es el ID del overlay de referencia ("chat").
            event.registerAboveAll("time", RealTimeOverlay.HUD_TIME);
        }
    }
}