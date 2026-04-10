package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.bw;

/* JADX INFO: loaded from: classes2.dex */
class ab implements bw.c {
    final /* synthetic */ z a;

    ab(z zVar) {
        this.a = zVar;
    }

    @Override // com.baidu.mobads.sdk.internal.bw.c
    public void a(boolean z2) {
        if (z2) {
            try {
                if (f.a != null) {
                    this.a.b = f.a.i();
                    if (this.a.b != null) {
                        this.a.k();
                        return;
                    }
                }
            } catch (Exception unused) {
                this.a.a("加载dex异常");
                return;
            }
        }
        f.a = null;
        this.a.a("加载dex失败");
    }
}
