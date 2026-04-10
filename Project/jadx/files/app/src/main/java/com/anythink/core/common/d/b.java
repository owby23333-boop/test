package com.anythink.core.common.d;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static volatile a f7078c;

    private b(Context context) {
        super(context);
        this.b = 2;
    }

    public static a a(Context context) {
        if (f7078c == null) {
            synchronized (a.class) {
                if (f7078c == null) {
                    f7078c = new b(context);
                }
            }
        }
        return f7078c;
    }
}
