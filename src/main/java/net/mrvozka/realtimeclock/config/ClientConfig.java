package net.mrvozka.realtimeclock.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ClientConfig {
    public static final ForgeConfigSpec CLIENT_SPEC;
    public static final Client CLIENT;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        CLIENT = new Client(builder);
        CLIENT_SPEC = builder.build();
    }

    public static class Client {
        // Absolute X position for the clock (in pixels)
        public final ForgeConfigSpec.IntValue clockX;
        // Absolute Y position for the clock (in pixels)
        public final ForgeConfigSpec.IntValue clockY;

        public Client(ForgeConfigSpec.Builder builder) {
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
