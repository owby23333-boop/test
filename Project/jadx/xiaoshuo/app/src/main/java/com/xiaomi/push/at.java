package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes8.dex */
class at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f7802a = false;

    private static void a(Class<?> cls, Context context) {
        if (f7802a) {
            return;
        }
        try {
            f7802a = true;
            cls.getDeclaredMethod("InitEntry", Context.class).invoke(cls, context);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m106a("mdid:load lib error " + th);
        }
    }

    public static boolean a(Context context) {
        try {
            Class<?> clsA = C0855r.a(context, "com.bun.miitmdid.core.JLibrary");
            if (clsA == null) {
                return false;
            }
            a(clsA, context);
            return true;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m106a("mdid:check error " + th);
            return false;
        }
    }
}
