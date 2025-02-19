package net.mrvozka.realtimeclock.client;

import net.mrvozka.realtimeclock.config.ClientConfig;

public class ClockPreviewHandler {
    public static boolean previewMode = false;
    public static int previewX = ClientConfig.CLIENT.clockX.get();
    public static int previewY = ClientConfig.CLIENT.clockY.get();
}