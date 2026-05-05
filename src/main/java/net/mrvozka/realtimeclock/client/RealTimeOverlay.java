package net.mrvozka.realtimeclock.client;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.resources.ResourceLocation;
import net.mrvozka.realtimeclock.RealTimeClockMod;
import net.mrvozka.realtimeclock.config.ClientConfig;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RealTimeOverlay {
    // Defines the formatter as constant
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    // Unique ResourceLocation identifier for this layer
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(RealTimeClockMod.MODID, "time");

    // Defines the overlay layer that draws the time on the screen.
    public static final LayeredDraw.Layer HUD_TIME = (GuiGraphics guiGraphics, DeltaTracker deltaTracker) -> {
        String timeString = LocalTime.now().format(TIME_FORMATTER);

        int x, y;
        if (ClockPreviewHandler.previewMode) {
            x = ClockPreviewHandler.previewX;
            y = ClockPreviewHandler.previewY;
        } else {
            x = ClientConfig.CLIENT.clockX.get();
            y = ClientConfig.CLIENT.clockY.get();
        }

        // Uses red color (0xFF0000) in preview mode and white (0xFFFFFF) in normal mode
        int color = ClockPreviewHandler.previewMode ? 0xFF0000 : 0xFFFFFF;

        try {
            // drawString(font, text, x, y, color, shadow)
            guiGraphics.drawString(Minecraft.getInstance().font, timeString, x, y, color, true);
        } catch (Exception e) {
            RealTimeClockMod.LOGGER.error("Error rendering the time", e);
        }
    };
}