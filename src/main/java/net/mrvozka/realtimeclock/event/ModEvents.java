package net.mrvozka.realtimeclock.event;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mrvozka.realtimeclock.RealTimeClockMod;

@Mod.EventBusSubscriber(modid = RealTimeClockMod.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
        // Asegúrate de que el código se ejecute en el servidor
        if (!event.getLevel().isClientSide()) {
            if (event.getEntity() instanceof ServerPlayer player) {
                try {
                    // Envía el mensaje al jugador; el false evita que se añada al historial de chat
                    player.displayClientMessage(Component.literal("Real time clock mod: Se ha cargado correctamente"), false);
                } catch (Exception e) {
                    // Se captura el error y se loguea para evitar que se propague
                    RealTimeClockMod.LOGGER.error("Error enviando mensaje al jugador", e);
                }
            }
        }
    }
}