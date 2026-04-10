package com.bytedance.sdk.component.g.z.z.g;

import android.text.TextUtils;
import com.bytedance.sdk.component.g.z.v;
import com.bytedance.sdk.component.g.z.wp;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends wp {
    public a wp;

    public dl(wp.z zVar) {
        super(zVar);
        this.wp = new a();
    }

    @Override // com.bytedance.sdk.component.g.z.wp
    public com.bytedance.sdk.component.g.z.a z() {
        return this.wp;
    }

    @Override // com.bytedance.sdk.component.g.z.wp
    public com.bytedance.sdk.component.g.z.g z(v vVar) {
        vVar.z(this);
        if (vVar == null || vVar.g() == null || vVar.g().z() == null || TextUtils.isEmpty(vVar.g().z().toString())) {
            return null;
        }
        return new z(vVar, this.wp);
    }
}
