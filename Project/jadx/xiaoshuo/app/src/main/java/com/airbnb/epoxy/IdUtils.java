package com.airbnb.epoxy;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class IdUtils {
    private IdUtils() {
    }

    public static long hashLong64Bit(long j) {
        long j2 = j ^ (j << 21);
        long j3 = j2 ^ (j2 >>> 35);
        return j3 ^ (j3 << 4);
    }

    public static long hashString64Bit(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            return 0L;
        }
        int length = charSequence.length();
        long jCharAt = -3750763034362895579L;
        for (int i = 0; i < length; i++) {
            jCharAt = (jCharAt ^ ((long) charSequence.charAt(i))) * 1099511628211L;
        }
        return jCharAt;
    }
}
