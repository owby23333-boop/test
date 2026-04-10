package com.xiaomi.ad.common.util;

import java.util.Random;
import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
public final class MathUtils {
    public static long random(long j) {
        return random(0L, j);
    }

    public static String randomString() {
        return HashUtils.getMd5(UUID.randomUUID().toString());
    }

    public static int range(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    public static long random(long j, long j2) {
        if (j == j2) {
            return j;
        }
        if (j <= j2) {
            j = j2;
            j2 = j;
        }
        return (Math.abs(new Random(System.currentTimeMillis()).nextLong()) % (j - j2)) + j2;
    }

    public static long range(long j, long j2, long j3) {
        return Math.min(Math.max(j, j2), j3);
    }
}
