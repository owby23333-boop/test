package com.alipay.sdk.m.w;

import android.content.Context;
import com.alipay.sdk.m.o.c;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f1969b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1970a;

    public static b c() {
        if (f1969b == null) {
            f1969b = new b();
        }
        return f1969b;
    }

    public static boolean e() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i = 0; i < 10; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    public void a(Context context) {
        c.a();
        this.f1970a = context.getApplicationContext();
    }

    public Context b() {
        return this.f1970a;
    }

    public String d() {
        return com.alipay.sdk.m.a0.b.c(null, this.f1970a);
    }

    public c a() {
        return c.a();
    }
}
