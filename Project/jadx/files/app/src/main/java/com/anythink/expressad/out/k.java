package com.anythink.expressad.out;

import android.net.Uri;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class k implements com.anythink.expressad.e.b {
    public static final int a = 6;
    public static final int b = 7;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f10915c = 8;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f10916d = "CustomInfoManager";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile k f10917e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f10918f = new ConcurrentHashMap<>();

    private k() {
    }

    public static k a() {
        if (f10917e == null) {
            synchronized (k.class) {
                if (f10917e == null) {
                    f10917e = new k();
                }
            }
        }
        return f10917e;
    }

    private void a(String str, int i2, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        String strA = com.anythink.expressad.foundation.h.j.a(str2);
        if (i2 == 6) {
            this.f10918f.put(str + "_bid", strA);
            return;
        }
        if (i2 != 7) {
            if (i2 != 8) {
                return;
            }
            this.f10918f.put(str, strA);
        } else {
            this.f10918f.put(str + "_bidload", strA);
        }
    }

    private String a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (i2 == 6) {
            return this.f10918f.get(str + "_bid");
        }
        if (i2 != 7) {
            return i2 != 8 ? "" : this.f10918f.get(str);
        }
        return this.f10918f.get(str + "_bidload");
    }

    public final String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            Uri uri = Uri.parse(str2);
            if (uri != null) {
                String host = uri.getHost();
                String path = uri.getPath();
                if (!TextUtils.isEmpty(host) && host.contains("hb") && !TextUtils.isEmpty(path) && path.contains("bid")) {
                    return a(str, 6);
                }
                if (!TextUtils.isEmpty(host) && host.contains("hb") && !TextUtils.isEmpty(path) && path.contains("load")) {
                    return a(str, 7);
                }
                if (!TextUtils.isEmpty(path) && path.contains(com.anythink.expressad.foundation.g.a.f10413j)) {
                    return a(str, 8);
                }
            }
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.b(f10916d, "Exception", th);
        }
        return "";
    }
}
