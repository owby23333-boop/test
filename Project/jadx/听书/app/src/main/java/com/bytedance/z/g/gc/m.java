package com.bytedance.z.g.gc;

import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private static final AtomicReference<Long> z = new AtomicReference<>(0L);

    public static void z(long j) {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i >= 5) {
                return;
            }
            AtomicReference<Long> atomicReference = z;
            long jLongValue = atomicReference.get().longValue();
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, Long.valueOf(jLongValue), Long.valueOf(jLongValue | j))) {
                return;
            } else {
                i = i2;
            }
        }
    }
}
