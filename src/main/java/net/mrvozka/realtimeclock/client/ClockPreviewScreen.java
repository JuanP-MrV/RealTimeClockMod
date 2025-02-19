package net.mrvozka.realtimeclock.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.mrvozka.realtimeclock.config.ClientConfig;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.lwjgl.glfw.GLFW;

public class ClockPreviewScreen extends Screen {

    private int previewX;
    private int previewY;
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public ClockPreviewScreen() {
        super(Component.literal("Modo Preview del Reloj"));
        // Inicializa la posición con los valores actuales de la configuración
        this.previewX = ClientConfig.CLIENT.clockX.get();
        this.previewY = ClientConfig.CLIENT.clockY.get();
    }

    @Override
    protected void init() {
        // Puedes agregar botones o elementos si lo deseas
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        int moveAmount = 5;
        // Movimiento con flechas o WASD:
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
        // Pulsar P o Entern confirma la posición
        if (keyCode == GLFW.GLFW_KEY_P || keyCode == GLFW.GLFW_KEY_ENTER) {
            ClientConfig.CLIENT.clockX.set(previewX);
            ClientConfig.CLIENT.clockY.set(previewY);
            if (Minecraft.getInstance().player != null) {
                Minecraft.getInstance().player.displayClientMessage(
                        Component.literal("Posición confirmada."), false);
            }
            Minecraft.getInstance().setScreen(null);
            return true;
        }
        // Esc cancela la operación sin guardar cambios
        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
            Minecraft.getInstance().setScreen(null);
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        // Renderiza un fondo semi-transparente para bloquear el resto de entradas
        this.renderBackground(poseStack);
        // Muestra las instrucciones centradas en la parte superior
        drawCenteredString(poseStack, this.font, "Modo Preview: Usa flechas o AWSD para mover, P o Enter para confirmar, Esc para cancelar", this.width / 2, 20, 0xFFFFFF);
        // Renderiza el reloj en modo preview (en rojo)
        String timeString = LocalTime.now().format(TIME_FORMATTER);
        this.font.drawShadow(poseStack, timeString, previewX, previewY, 0xFF0000);
        super.render(poseStack, mouseX, mouseY, partialTick);
    }
}
