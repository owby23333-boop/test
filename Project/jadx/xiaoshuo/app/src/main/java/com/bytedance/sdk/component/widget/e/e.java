package com.bytedance.sdk.component.widget.e;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private static volatile e bf;
    private volatile bf e;

    private e() {
    }

    public static e e() {
        if (bf == null) {
            synchronized (e.class) {
                if (bf == null) {
                    bf = new e();
                }
            }
        }
        return bf;
    }

    public bf bf() {
        return this.e;
    }
}
