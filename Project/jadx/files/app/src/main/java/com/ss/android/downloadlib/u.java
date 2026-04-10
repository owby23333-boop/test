package com.ss.android.downloadlib;

/* JADX INFO: loaded from: classes3.dex */
public class u {
    private static volatile u mb;
    private com.ss.android.download.api.config.u ox = null;

    private u() {
    }

    public static u mb() {
        if (mb == null) {
            synchronized (u.class) {
                if (mb == null) {
                    mb = new u();
                }
            }
        }
        return mb;
    }

    public com.ss.android.download.api.config.u ox() {
        return this.ox;
    }
}
