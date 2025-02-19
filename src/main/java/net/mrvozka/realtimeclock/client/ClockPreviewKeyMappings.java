package net.mrvozka.realtimeclock.client;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = "realtimeclockmod", bus = Mod.EventBusSubscriber.Bus.MOD, value = net.minecraftforge.api.distmarker.Dist.CLIENT)
public class ClockPreviewKeyMappings {
    public static KeyMapping togglePreviewKey;

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        // Asigna la tecla "P" para abrir la pantalla de preview en la categoría personalizada
        togglePreviewKey = new KeyMapping("key.realtimeclockmod.toggle_preview", GLFW.GLFW_KEY_P, "key.categories.realtimeclock");
        event.register(togglePreviewKey);
    }
}
