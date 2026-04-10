package com.umeng.commonsdk.internal;

import android.content.Context;

/* JADX INFO: compiled from: UMInternalData.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    private static b b;
    private Context a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f19995c;

    private b(Context context) {
        this.a = context;
        this.f19995c = new c(context);
    }

    public static synchronized b a(Context context) {
        if (b == null) {
            b = new b(context.getApplicationContext());
        }
        return b;
    }

    public c a() {
        return this.f19995c;
    }
}
