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
        // Si se pulsa la tecla P y no hay otra pantalla abierta, se abre la pantalla de preview
        if (ClockPreviewKeyMappings.togglePreviewKey.consumeClick() && Minecraft.getInstance().screen == null) {
            Minecraft.getInstance().setScreen(new ClockPreviewScreen());
            return;
        }

        // Aquí, la lógica para el modo preview se gestionará desde la pantalla de preview.
        // Si decides seguir utilizando el handler sin pantalla, podrías comprobar:
        /*
        if (ClockPreviewKeyMappings.togglePreviewKey.consumeClick()) {
            // Alterna el modo preview, etc.
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
