package com.bytedance.sdk.gromore.z.z.a;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class z implements com.bytedance.sdk.gromore.z.z.a {
    private com.bytedance.msdk.api.g z;

    public z(com.bytedance.msdk.api.g gVar) {
        this.z = gVar;
    }

    @Override // com.bytedance.sdk.gromore.z.z.a
    public String z() {
        com.bytedance.msdk.api.g gVar = this.z;
        if (gVar != null) {
            return gVar.g();
        }
        return null;
    }

    @Override // com.bytedance.sdk.gromore.z.z.a
    public String g() {
        com.bytedance.msdk.api.g gVar = this.z;
        if (gVar == null) {
            return null;
        }
        if (TextUtils.isEmpty(gVar.dl())) {
            return this.z.a();
        }
        return this.z.dl();
    }

    @Override // com.bytedance.sdk.gromore.z.z.a
    public String dl() {
        com.bytedance.msdk.api.g gVar = this.z;
        if (gVar != null) {
            return gVar.z();
        }
        return null;
    }

    @Override // com.bytedance.sdk.gromore.z.z.a
    public int a() {
        com.bytedance.msdk.api.g gVar = this.z;
        if (gVar != null) {
            return gVar.gc();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.gromore.z.z.a
    public String gc() {
        com.bytedance.msdk.api.g gVar = this.z;
        if (gVar != null) {
            return gVar.m();
        }
        return null;
    }
}
