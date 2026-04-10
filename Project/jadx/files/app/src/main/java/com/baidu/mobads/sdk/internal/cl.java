package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
class cl extends h {
    final /* synthetic */ ck b;

    cl(ck ckVar) {
        this.b = ckVar;
    }

    @Override // com.baidu.mobads.sdk.internal.h
    protected Object i() {
        try {
            String strA = this.b.a("key_crash_trace");
            String strA2 = this.b.a("key_crash_ad");
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            ch chVarA = ch.a();
            chVarA.a(this.b.f13032h);
            chVarA.a(this.b.a("key_crash_source"), strA, strA2);
            this.b.g();
            return null;
        } catch (Exception e2) {
            bq.a().a(e2);
            return null;
        }
    }
}
