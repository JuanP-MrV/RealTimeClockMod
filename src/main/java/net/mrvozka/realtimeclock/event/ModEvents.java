package net.mrvozka.realtimeclock.event;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.mrvozka.realtimeclock.RealTimeClockMod;

@EventBusSubscriber(modid = RealTimeClockMod.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
        // Make sure that the code is executed on the server side
        if (!event.getLevel().isClientSide()) {
            if (event.getEntity() instanceof ServerPlayer player) {
                try {
                    // Sends the message to the player; false prevents it from being added to the chat history
                    player.displayClientMessage(Component.literal("Real time clock mod: successfully loaded"), false);
                } catch (Exception e) {
                    // The error is caught and logged to prevent it from spreading.
                    RealTimeClockMod.LOGGER.error("Error sending message to player", e);
                }
            }
        }
    }
}
