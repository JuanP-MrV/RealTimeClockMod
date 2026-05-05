package net.mrvozka.realtimeclock.client;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;

@EventBusSubscriber(modid = "realtimeclockmod", bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class ClockPreviewInputHandler {

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        // If the P key is pressed and no other screen is open, the preview screen opens.
        if (ClockPreviewKeyMappings.togglePreviewKey.consumeClick() && Minecraft.getInstance().screen == null) {
            Minecraft.getInstance().setScreen(new ClockPreviewScreen());
        }
    }
}
