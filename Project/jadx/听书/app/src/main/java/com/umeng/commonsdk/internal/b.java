package com.umeng.commonsdk.internal;

import android.content.Context;

/* JADX INFO: compiled from: UMInternalData.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {
    private static b b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2300a;
    private c c;

    private b(Context context) {
        this.f2300a = context;
        this.c = new c(context);
    }

    public static synchronized b a(Context context) {
        if (b == null) {
            b = new b(context.getApplicationContext());
        }
        return b;
    }

    public c a() {
        return this.c;
    }
}
