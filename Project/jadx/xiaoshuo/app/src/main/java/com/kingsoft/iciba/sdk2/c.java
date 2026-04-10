package com.kingsoft.iciba.sdk2;

import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: classes7.dex */
final class c implements Runnable {
    private b r;

    public c(b bVar) {
        this.r = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            b.a(this.r);
            if (b.b(this.r) == null || b.c(this.r) == null || b.d(this.r) == null) {
                return;
            }
            b.c(this.r).getMethod("init", Context.class, Long.TYPE).invoke(b.d(this.r), b.b(this.r), Long.valueOf(b.e(this.r)));
        } catch (Exception e) {
            Log.e(b.d(), "Init help class failed", e);
        }
    }
}
