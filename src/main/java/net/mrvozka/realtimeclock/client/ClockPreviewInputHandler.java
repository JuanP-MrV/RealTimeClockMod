package net.mrvozka.realtimeclock.client;

import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mrvozka.realtimeclock.config.ClientConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

@Mod.EventBusSubscriber(modid = "realtimeclockmod", bus = Mod.EventBusSubscriber.Bus.FORGE, value = net.minecraftforge.api.distmarker.Dist.CLIENT)
public class ClockPreviewInputHandler {

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        // If the P key is pressed and no other screen is open, the preview screen opens.
        if (ClockPreviewKeyMappings.togglePreviewKey.consumeClick() && Minecraft.getInstance().screen == null) {
            Minecraft.getInstance().setScreen(new ClockPreviewScreen());
            return;
        }

        // Here, the logic for the preview mode will be handled from the preview screen.
        // If you decide to continue using the handler without a screen, you could check:
        /*
        if (ClockPreviewKeyMappings.togglePreviewKey.consumeClick()) {
            // Toggles preview mode, etc.
        }
        if (ClockPreviewHandler.previewMode) {
            int moveAmount = 5;
            if (ClockPreviewKeyMappings.previewUpKey.consumeClick() || ClockPreviewKeyMappings.previewUpKey2.consumeClick()) {
                ClockPreviewHandler.previewY -= moveAmount;
            }
            if (ClockPreviewKeyMappings.previewDownKey.consumeClick() || ClockPreviewKeyMappings.previewDownKey2.consumeClick()) {
                ClockPreviewHandler.previewY += moveAmount;
            }
            if (ClockPreviewKeyMappings.previewLeftKey.consumeClick() || ClockPreviewKeyMappings.previewLeftKey2.consumeClick()) {
                ClockPreviewHandler.previewX -= moveAmount;
            }
            if (ClockPreviewKeyMappings.previewRightKey.consumeClick() || ClockPreviewKeyMappings.previewRightKey2.consumeClick()) {
                ClockPreviewHandler.previewX += moveAmount;
            }
        }
        */
    }
}
