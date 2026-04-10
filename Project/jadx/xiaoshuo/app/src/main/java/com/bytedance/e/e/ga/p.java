package com.bytedance.e.e.ga;

import com.yuewen.ir1;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class p {
    private static final AtomicReference<Long> e = new AtomicReference<>(0L);

    public static void e(long j) {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i >= 5) {
                return;
            }
            AtomicReference<Long> atomicReference = e;
            long jLongValue = atomicReference.get().longValue();
            if (ir1.a(atomicReference, Long.valueOf(jLongValue), Long.valueOf(jLongValue | j))) {
                return;
            } else {
                i = i2;
            }
        }
    }
}
