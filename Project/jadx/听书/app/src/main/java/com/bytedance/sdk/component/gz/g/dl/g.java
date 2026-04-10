package com.bytedance.sdk.component.gz.g.dl;

import com.bytedance.sdk.component.gz.z.a;
import com.bytedance.sdk.component.gz.z.gc;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static void z(AtomicLong atomicLong, int i, gc gcVar) {
        a aVarA = gcVar.a();
        if (aVarA == null || !aVarA.dl() || atomicLong == null) {
            return;
        }
        atomicLong.getAndAdd(i);
    }
}
