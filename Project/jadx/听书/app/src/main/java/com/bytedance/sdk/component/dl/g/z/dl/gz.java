package com.bytedance.sdk.component.dl.g.z.dl;

import com.bytedance.sdk.component.dl.g.gk;
import com.bytedance.sdk.component.dl.g.q;

/* JADX INFO: loaded from: classes2.dex */
public final class gz extends gk {
    private final com.bytedance.sdk.component.dl.z.gc dl;
    private final long g;
    private final String z;

    public gz(String str, long j, com.bytedance.sdk.component.dl.z.gc gcVar) {
        this.z = str;
        this.g = j;
        this.dl = gcVar;
    }

    @Override // com.bytedance.sdk.component.dl.g.gk
    public q z() {
        String str = this.z;
        if (str != null) {
            return q.z(str);
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.dl.g.gk
    public long g() {
        return this.g;
    }

    @Override // com.bytedance.sdk.component.dl.g.gk
    public com.bytedance.sdk.component.dl.z.gc dl() {
        return this.dl;
    }
}
