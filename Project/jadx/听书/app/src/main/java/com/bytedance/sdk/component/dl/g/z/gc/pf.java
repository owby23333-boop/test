package com.bytedance.sdk.component.dl.g.z.gc;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class pf extends IOException {
    public final g z;

    public pf(g gVar) {
        super("stream was reset: ".concat(String.valueOf(gVar)));
        this.z = gVar;
    }
}
