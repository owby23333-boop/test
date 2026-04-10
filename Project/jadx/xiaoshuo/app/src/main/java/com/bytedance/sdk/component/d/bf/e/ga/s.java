package com.bytedance.sdk.component.d.bf.e.ga;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class s extends IOException {
    public final bf e;

    public s(bf bfVar) {
        super("stream was reset: " + bfVar);
        this.e = bfVar;
    }
}
