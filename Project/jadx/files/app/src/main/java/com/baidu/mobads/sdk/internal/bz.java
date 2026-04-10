package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.ck;

/* JADX INFO: loaded from: classes2.dex */
class bz implements ck.a {
    final /* synthetic */ bw a;

    bz(bw bwVar) {
        this.a = bwVar;
    }

    @Override // com.baidu.mobads.sdk.internal.ck.a
    public void a(String str) {
        try {
            this.a.b();
            this.a.a(str);
        } catch (Throwable th) {
            bq.a().a(th);
        }
    }
}
