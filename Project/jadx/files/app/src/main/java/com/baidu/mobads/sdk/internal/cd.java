package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.an;

/* JADX INFO: loaded from: classes2.dex */
class cd implements an.a {
    final /* synthetic */ bw a;

    cd(bw bwVar) {
        this.a = bwVar;
    }

    @Override // com.baidu.mobads.sdk.internal.an.a
    public void a() {
        if (this.a.A) {
            this.a.A = false;
            this.a.a(false, "remote update Network access failed");
        }
    }
}
