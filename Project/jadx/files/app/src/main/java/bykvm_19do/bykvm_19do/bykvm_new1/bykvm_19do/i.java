package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do;

import android.annotation.SuppressLint;
import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.j;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class i {
    private static Context a = null;
    private static long b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f2019c = "default";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f2020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.a f2021e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile ConcurrentHashMap<Integer, String> f2024h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile int f2026j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile String f2027k;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.b f2022f = new bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static b f2023g = new b();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static j f2025i = null;

    public static long a() {
        return b;
    }

    static void a(Context context, e eVar) {
        b = System.currentTimeMillis();
        a = context;
        f2021e = new bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.a(a, eVar);
    }

    public static Context b() {
        return a;
    }

    public static String c() {
        return f2019c;
    }

    public static b d() {
        return f2023g;
    }

    public static bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.a e() {
        return f2021e;
    }

    public static bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.b f() {
        return f2022f;
    }

    public static int g() {
        return f2026j;
    }

    public static String h() {
        return f2027k;
    }

    public static ConcurrentHashMap<Integer, String> i() {
        return f2024h;
    }

    public static j j() {
        if (f2025i == null) {
            synchronized (i.class) {
                f2025i = new j(a);
            }
        }
        return f2025i;
    }

    public static boolean k() {
        return f2020d;
    }
}
