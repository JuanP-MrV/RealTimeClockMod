package net.mrvozka.realtimeclock.client;

import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import org.lwjgl.glfw.GLFW;

@EventBusSubscriber(modid = "realtimeclockmod", bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClockPreviewKeyMappings {
    public static KeyMapping togglePreviewKey;

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        // Assign the "P" key to open the preview screen in the custom category.
        togglePreviewKey = new KeyMapping("key.realtimeclockmod.toggle_preview", GLFW.GLFW_KEY_P, "key.categories.realtimeclock");
        event.register(togglePreviewKey);
    }
}
