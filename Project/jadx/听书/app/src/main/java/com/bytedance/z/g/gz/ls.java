package com.bytedance.z.g.gz;

/* JADX INFO: loaded from: classes2.dex */
public final class ls {
    public static Thread z(Runnable runnable, String str) {
        com.bytedance.sdk.component.uy.a.dl dlVar;
        if (runnable == null) {
            return null;
        }
        if (str == null) {
            dlVar = new com.bytedance.sdk.component.uy.a.dl(runnable, "hreadExecutor");
        } else {
            dlVar = new com.bytedance.sdk.component.uy.a.dl(runnable, str);
        }
        dlVar.start();
        return dlVar;
    }

    public static Thread z(Runnable runnable) {
        return z(runnable, null);
    }
}
