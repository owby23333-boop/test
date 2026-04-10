package com.yuewen;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f8918a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f8919b = false;

    public static b g() {
        if (!f8919b) {
            throw new n("YWReportAPI::Init::invoke init(Application context,YWReportConfig config)first!");
        }
        if (f8918a == null) {
            synchronized (b.class) {
                if (f8918a == null) {
                    f8918a = new b();
                }
            }
        }
        return f8918a;
    }

    public static boolean h() {
        return false;
    }

    public a a() {
        return c.h().b();
    }

    public int b() {
        return c.h().c();
    }

    public int c() {
        return c.h().d();
    }

    public long d() {
        return c.h().e();
    }

    public long e() {
        return c.h().f();
    }

    public String f() {
        return c.h().g();
    }

    public static void a(Context context, g gVar) {
        if (f8919b) {
            return;
        }
        f8919b = c.a(context, gVar);
    }

    public void a(a aVar) {
        c.h().a(aVar);
    }

    public void a(JSONObject jSONObject, int i) {
        c.h().a(jSONObject, i);
    }
}
