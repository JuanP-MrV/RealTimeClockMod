package net.mrvozka.realtimeclock.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ClientConfig {
    public static final ModConfigSpec CLIENT_SPEC;
    public static final Client CLIENT;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        CLIENT = new Client(builder);
        CLIENT_SPEC = builder.build();
    }

    public static class Client {
        // Absolute X position for the clock (in pixels)
        public final ModConfigSpec.IntValue clockX;
        // Absolute Y position for the clock (in pixels)
        public final ModConfigSpec.IntValue clockY;

        public Client(ModConfigSpec.Builder builder) {
            builder.push("general");
            clockX = builder
                    .comment("Absolute X position for the clock (in pixels)")
                    .defineInRange("clockX", 10, 0, 10000);
            clockY = builder
                    .comment("Absolute Y position for the clock (in pixels)")
                    .defineInRange("clockY", 50, 0, 10000);
            builder.pop();
        }
    }
}
