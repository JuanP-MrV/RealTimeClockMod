package net.mrvozka.realtimeclock.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.mrvozka.realtimeclock.config.ClientConfig;
import org.lwjgl.glfw.GLFW;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ClockPreviewScreen extends Screen {

    private int previewX;
    private int previewY;
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public ClockPreviewScreen() {
        super(Component.literal("Preview mode for Real Time Clock"));
        // Initialize position from current configuration values
        this.previewX = ClientConfig.CLIENT.clockX.get();
        this.previewY = ClientConfig.CLIENT.clockY.get();
    }

    @Override
    protected void init() {
        // You can add buttons or elements if you wish
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        int moveAmount = 5;
        // Movement with arrows or WASD:
        if (keyCode == GLFW.GLFW_KEY_UP || keyCode == GLFW.GLFW_KEY_W) {
            previewY -= moveAmount;
            return true;
        }
        if (keyCode == GLFW.GLFW_KEY_DOWN || keyCode == GLFW.GLFW_KEY_S) {
            previewY += moveAmount;
            return true;
        }
        if (keyCode == GLFW.GLFW_KEY_LEFT || keyCode == GLFW.GLFW_KEY_A) {
            previewX -= moveAmount;
            return true;
        }
        if (keyCode == GLFW.GLFW_KEY_RIGHT || keyCode == GLFW.GLFW_KEY_D) {
            previewX += moveAmount;
            return true;
        }
        // Pressing P or Enter confirms the position.
        if (keyCode == GLFW.GLFW_KEY_P || keyCode == GLFW.GLFW_KEY_ENTER) {
            ClientConfig.CLIENT.clockX.set(previewX);
            ClientConfig.CLIENT.clockY.set(previewY);
            if (Minecraft.getInstance().player != null) {
                Minecraft.getInstance().player.displayClientMessage(
                        Component.literal("Position confirmed."), false);
            }
            Minecraft.getInstance().setScreen(null);
            return true;
        }
        // Esc cancels the operation without saving changes
        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
            Minecraft.getInstance().setScreen(null);
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        // Renders a semi-transparent background
        renderBackground(guiGraphics, mouseX, mouseY, partialTick);
        // Displays instructions centered at the top of the screen
        guiGraphics.drawCenteredString(this.font, "Preview mode: Use arrows or AWSD to move, P or Enter to confirm, Esc to cancel.", this.width / 2, 20, 0xFFFFFF);
        // Renders the clock in preview mode (in red), with shadow
        String timeString = LocalTime.now().format(TIME_FORMATTER);
        guiGraphics.drawString(this.font, timeString, previewX, previewY, 0xFF0000, true);
        super.render(guiGraphics, mouseX, mouseY, partialTick);
    }
}
