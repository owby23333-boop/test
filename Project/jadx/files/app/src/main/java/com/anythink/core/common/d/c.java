package com.anythink.core.common.d;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class c extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile c f7079c;

    private c(Context context) {
        super(context);
        this.b = 1;
    }

    public static c a(Context context) {
        if (f7079c == null) {
            synchronized (c.class) {
                if (f7079c == null) {
                    f7079c = new c(context);
                }
            }
        }
        return f7079c;
    }
}
