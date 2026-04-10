package com.bytedance.sdk.component.d.bf.e.d;

import com.bytedance.sdk.component.d.bf.fy;
import com.bytedance.sdk.component.d.bf.pe;

/* JADX INFO: loaded from: classes.dex */
public final class v extends fy {
    private final long bf;
    private final com.bytedance.sdk.component.d.e.ga d;
    private final String e;

    public v(String str, long j, com.bytedance.sdk.component.d.e.ga gaVar) {
        this.e = str;
        this.bf = j;
        this.d = gaVar;
    }

    @Override // com.bytedance.sdk.component.d.bf.fy
    public long bf() {
        return this.bf;
    }

    @Override // com.bytedance.sdk.component.d.bf.fy
    public com.bytedance.sdk.component.d.e.ga d() {
        return this.d;
    }

    @Override // com.bytedance.sdk.component.d.bf.fy
    public pe e() {
        String str = this.e;
        if (str != null) {
            return pe.e(str);
        }
        return null;
    }
}
