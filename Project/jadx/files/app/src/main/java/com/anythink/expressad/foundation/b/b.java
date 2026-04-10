package com.anythink.expressad.foundation.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.g.f.m;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.r;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f10122g = "SDKController";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile b f10123h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Context f10128i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f10132m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f10133n;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f10129j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f10130k = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f10131l = false;
    public final int a = 1;
    public final int b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f10124c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f10125d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10126e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f10127f = 6;

    private b() {
    }

    public static b a() {
        if (f10123h == null) {
            synchronized (b.class) {
                if (f10123h == null) {
                    f10123h = new b();
                }
            }
        }
        return f10123h;
    }

    private static String b() {
        return com.anythink.expressad.out.b.a;
    }

    private void c() {
        a.b().a(this.f10129j);
        a.b().b(this.f10130k);
        a.b().c();
        a(this.f10128i.getApplicationContext());
        r.a(this.f10128i);
        this.f10131l = true;
    }

    private static void d() {
    }

    private void e() {
        a.b().a(this.f10129j);
        a.b().b(this.f10130k);
        a.b().c();
    }

    public final void a(Map map, final Context context) {
        if (context != null) {
            this.f10128i = context.getApplicationContext();
            a.b().a(this.f10128i);
            try {
                m.a(this.f10128i);
            } catch (Exception unused) {
            }
            n.a().a(new Runnable() { // from class: com.anythink.expressad.foundation.b.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    k.i(context);
                }
            }, 300L);
            if (map != null) {
                if (map.containsKey(com.anythink.expressad.a.f7960d)) {
                    this.f10129j = (String) map.get(com.anythink.expressad.a.f7960d);
                }
                if (map.containsKey(com.anythink.expressad.a.f7961e)) {
                    this.f10130k = (String) map.get(com.anythink.expressad.a.f7961e);
                }
                a.b().a(this.f10129j);
                a.b().b(this.f10130k);
                a.b().c();
                a(this.f10128i.getApplicationContext());
                r.a(this.f10128i);
                this.f10131l = true;
            }
        }
    }

    private static void a(Context context) {
        String string;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(g.f6807w, 0);
            String str = "";
            if (sharedPreferences != null) {
                String string2 = sharedPreferences.getString(g.o.f6920l, "");
                string = sharedPreferences.getString(g.o.f6921m, "");
                str = string2;
            } else {
                string = "";
            }
            if (TextUtils.isEmpty(com.anythink.expressad.foundation.g.a.co) && TextUtils.isEmpty(com.anythink.expressad.foundation.g.a.cp)) {
                com.anythink.expressad.foundation.g.a.co = str;
                com.anythink.expressad.foundation.g.a.cp = string;
            }
        } catch (Throwable th) {
            o.b(f10122g, th.getMessage(), th);
        }
    }
}
