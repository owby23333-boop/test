package com.kingsoft.iciba.sdk2;

import android.content.Context;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public class b {
    private static final String g = "b";
    private Context h;
    private long i;
    private Context o;
    private Class p;
    private Object q;

    public b(Context context) {
        this.h = context;
    }

    private void c() {
        try {
            if (this.o == null) {
                Context contextCreatePackageContext = this.h.createPackageContext("com.kingsoft", 3);
                this.o = contextCreatePackageContext;
                Class<?> cls = Class.forName("com.kingsoft.util.SDKSimpleMean", true, contextCreatePackageContext.getClassLoader());
                this.p = cls;
                if (cls != null) {
                    this.q = cls.newInstance();
                } else {
                    this.o = null;
                }
            }
        } catch (Exception e) {
            this.o = null;
            Log.e(g, "init ciba context failed", e);
        }
    }

    public static long e(b bVar) {
        return bVar.i;
    }

    public final void a(long j) {
        this.i = j;
        if (b()) {
            new Thread(new c(this)).start();
        }
    }

    public final boolean b() {
        if (a()) {
            c();
            Context context = this.o;
            if (context != null) {
                if (d.d(context) >= 84) {
                    return true;
                }
                this.o = null;
            }
        }
        return false;
    }

    public final ArrayList d(String str) {
        Class cls;
        try {
            c();
            if (this.o == null || (cls = this.p) == null || this.q == null) {
                return null;
            }
            return (ArrayList) cls.getMethod("getSimpleMean", String.class, Context.class).invoke(this.q, str, this.o);
        } catch (Exception e) {
            Log.e(g, "Get simple mean failed", e);
            return null;
        }
    }

    public final boolean a() {
        return d.a(this.h, "com.kingsoft");
    }

    public static void a(b bVar) {
        bVar.c();
    }

    public static Object d(b bVar) {
        return bVar.q;
    }

    public static Context b(b bVar) {
        return bVar.o;
    }

    public static String d() {
        return g;
    }

    public static Class c(b bVar) {
        return bVar.p;
    }
}
