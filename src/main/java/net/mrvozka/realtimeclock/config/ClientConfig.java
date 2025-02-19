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
        // Posición X en píxeles (valor absoluto)
        public final ForgeConfigSpec.IntValue clockX;
        // Posición Y en píxeles (valor absoluto)
        public final ForgeConfigSpec.IntValue clockY;

        public Client(ForgeConfigSpec.Builder builder) {
            builder.push("general");
            clockX = builder
                    .comment("Posición X absoluta para el reloj (en píxeles)")
                    .defineInRange("clockX", 10, 0, 10000);
            clockY = builder
                    .comment("Posición Y absoluta para el reloj (en píxeles)")
                    .defineInRange("clockY", 50, 0, 10000);
            builder.pop();
        }
    }
}
