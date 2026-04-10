package com.bytedance.sdk.component.adexpress.e.e;

import com.bytedance.sdk.component.ga.t;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private static volatile e ga;
    private volatile tg bf;
    private volatile d d;
    private volatile bf e;
    private volatile t tg;

    private e() {
    }

    public static e e() {
        if (ga == null) {
            synchronized (e.class) {
                if (ga == null) {
                    ga = new e();
                }
            }
        }
        return ga;
    }

    public bf bf() {
        return this.e;
    }

    public d d() {
        return this.d;
    }

    public t ga() {
        return this.tg;
    }

    public tg tg() {
        return this.bf;
    }

    public void e(bf bfVar) {
        this.e = bfVar;
    }

    public void e(d dVar) {
        this.d = dVar;
    }

    public void e(tg tgVar) {
        this.bf = tgVar;
    }

    public void e(t tVar) {
        this.tg = tVar;
    }
}
