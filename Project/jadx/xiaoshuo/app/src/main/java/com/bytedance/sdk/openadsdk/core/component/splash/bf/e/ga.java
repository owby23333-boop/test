package com.bytedance.sdk.openadsdk.core.component.splash.bf.e;

import com.bytedance.sdk.openadsdk.TTAdSlot;
import com.bytedance.sdk.openadsdk.core.dt.x;

/* JADX INFO: loaded from: classes10.dex */
public class ga extends e {
    public static int bf = 1;
    public static int d = 2;
    private x ga;
    private TTAdSlot tg;
    private String vn;

    public ga(TTAdSlot tTAdSlot, x xVar) {
        this.tg = tTAdSlot;
        this.ga = xVar;
        if (tTAdSlot != null) {
            this.vn = tTAdSlot.getCodeId();
        }
    }

    public TTAdSlot bf() {
        return this.tg;
    }

    public x d() {
        return this.ga;
    }

    public String tg() {
        return this.vn;
    }
}
