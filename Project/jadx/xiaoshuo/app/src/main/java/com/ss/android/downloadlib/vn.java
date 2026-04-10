package com.ss.android.downloadlib;

/* JADX INFO: loaded from: classes4.dex */
public class vn {
    private static volatile vn e;
    private com.ss.android.download.api.config.vn bf = null;

    private vn() {
    }

    public static vn e() {
        if (e == null) {
            synchronized (vn.class) {
                if (e == null) {
                    e = new vn();
                }
            }
        }
        return e;
    }

    public com.ss.android.download.api.config.vn bf() {
        return this.bf;
    }
}
