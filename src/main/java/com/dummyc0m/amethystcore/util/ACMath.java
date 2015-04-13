package com.dummyc0m.amethystcore.util;

/**
 * Created by Dummyc0m on 3/3/15.
 */
public class ACMath {
    private static final float[] SIN_TABLE = new float[65536];

    static {
        for (int var0 = 0; var0 < 65536; ++var0) {
            SIN_TABLE[var0] = (float) Math.sin((double) var0 * Math.PI * 2.0D / 65536.0D);
        }
    }

    public static float sin(float theta) {
        return SIN_TABLE[(int)(theta * 10430.378F) & 65535];
    }

    public static float cos(float theta) {
        return SIN_TABLE[(int)(theta * 10430.378F + 16384.0F) & 65535];
    }

    public static float abs(float value) {
        return value >= 0.0F ? value : -value;
    }

    public static int abs_int(int value) {
        return value >= 0 ? value : -value;
    }
}
