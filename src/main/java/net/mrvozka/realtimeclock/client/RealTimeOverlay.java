package net.mrvozka.realtimeclock.client;

import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import net.mrvozka.realtimeclock.RealTimeClockMod;
import net.mrvozka.realtimeclock.config.ClientConfig;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RealTimeOverlay {
    // Defines the formatter as constant
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    // Defines the overlay that will draw the time on the screen.
    public static final IGuiOverlay HUD_TIME = (gui, poseStack, partialTick, width, height) -> {
        String timeString = LocalTime.now().format(TIME_FORMATTER);

        int x, y;
        if (ClockPreviewHandler.previewMode) {
            x = ClockPreviewHandler.previewX;
            y = ClockPreviewHandler.previewY;
        } else {
            x = ClientConfig.CLIENT.clockX.get();
            y = ClientConfig.CLIENT.clockY.get();
        }

        // Uses red color (0xFF0000) in preview mode and white (0xFFFFFFFF) in normal mode
        int color = ClockPreviewHandler.previewMode ? 0xFF0000 : 0xFFFFFF;

        try {
            gui.getFont().drawShadow(poseStack, timeString, x, y, color);
        } catch (Exception e) {
            RealTimeClockMod.LOGGER.error("Error al renderizar la hora", e);
        }
    };
}