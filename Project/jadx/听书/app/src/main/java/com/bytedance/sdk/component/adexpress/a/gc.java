package com.bytedance.sdk.component.adexpress.a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    public static void z(com.bytedance.sdk.component.uy.fo foVar, int i) {
        if (foVar == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.z.z.dl dlVarDl = com.bytedance.sdk.component.adexpress.z.z.z.z().dl();
        ExecutorService executorServiceV = dlVarDl != null ? dlVarDl.v() : null;
        if (executorServiceV != null) {
            foVar.setPriority(i);
            executorServiceV.execute(foVar);
        } else {
            com.bytedance.sdk.component.uy.e.z(foVar, i);
        }
    }

    public static void g(com.bytedance.sdk.component.uy.fo foVar, int i) {
        if (foVar == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.z.z.dl dlVarDl = com.bytedance.sdk.component.adexpress.z.z.z.z().dl();
        ExecutorService executorServiceI = dlVarDl != null ? dlVarDl.i() : null;
        if (executorServiceI != null) {
            foVar.setPriority(i);
            executorServiceI.execute(foVar);
        } else {
            com.bytedance.sdk.component.uy.e.z(foVar);
        }
    }

    public static ScheduledFuture z(Runnable runnable, long j, TimeUnit timeUnit) {
        return com.bytedance.sdk.component.uy.e.a().schedule(runnable, j, timeUnit);
    }
}
