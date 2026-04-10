package com.xiaomi.onetrack.f;

import android.content.Context;
import com.xiaomi.onetrack.util.i;

/* JADX INFO: loaded from: classes8.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7680a = "OneTrackApp";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static g f7681b;

    private g(Context context) {
        i.a(new h(this, context.getApplicationContext()));
    }

    public static void a(Context context) {
        if (f7681b == null) {
            f7681b = new g(context);
        }
    }
}
