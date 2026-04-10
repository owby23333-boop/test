package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.ag;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class at {
    private static at C = null;
    public static int a = 0;
    public static boolean b = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f18579d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f18580e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f18581f = 20480;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f18582g = 3000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f18583h = 20480;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f18584i = 604800000;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f18585j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f18586k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f18587l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f18588m = 5000;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f18589n = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static boolean f18590o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static String f18591p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static String f18592q;
    public int A = 31;
    public boolean B = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f18593c;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final as f18594r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final av f18595s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final NativeCrashHandler f18596t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ac f18597u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ak f18598v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ay f18599w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public BuglyStrategy.a f18600x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public aw f18601y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Boolean f18602z;

    private at(Context context, ak akVar, boolean z2, BuglyStrategy.a aVar) {
        a = 1004;
        Context contextA = ap.a(context);
        this.f18593c = contextA;
        this.f18597u = ac.a();
        this.f18598v = akVar;
        this.f18600x = aVar;
        this.f18601y = null;
        this.f18594r = new as(contextA, ai.a(), w.a(), this.f18597u, aVar);
        aa aaVarA = aa.a(contextA);
        this.f18595s = new av(contextA, this.f18594r, this.f18597u, aaVarA);
        this.f18596t = NativeCrashHandler.getInstance(contextA, aaVarA, this.f18594r, this.f18597u, akVar, z2, null);
        aaVarA.N = this.f18596t;
        ac acVar = this.f18597u;
        as asVar = this.f18594r;
        if (ay.f18629f == null) {
            ay.f18629f = new ay(contextA, acVar, aaVarA, akVar, asVar);
        }
        this.f18599w = ay.f18629f;
    }

    public final synchronized void c() {
        this.f18595s.b();
        d();
        g();
    }

    public final void d() {
        this.f18596t.setUserOpened(false);
    }

    public final void e() {
        this.f18596t.setUserOpened(true);
    }

    public final void f() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.bugly.proguard.at.1
            @Override // java.lang.Runnable
            public final void run() {
                NativeCrashHandler.getInstance().unBlockSigquit(true);
            }
        });
        this.f18599w.b(true);
    }

    public final void g() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.bugly.proguard.at.2
            @Override // java.lang.Runnable
            public final void run() {
                NativeCrashHandler.getInstance().unBlockSigquit(false);
            }
        });
        this.f18599w.b(false);
    }

    public final synchronized void h() {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 < 30) {
                try {
                    al.a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i3));
                    ap.b(5000L);
                    i2 = i3;
                } catch (Throwable th) {
                    if (al.a(th)) {
                        return;
                    }
                    th.printStackTrace();
                    return;
                }
            }
        }
    }

    public final boolean i() {
        return this.f18599w.a.get();
    }

    public final boolean j() {
        return (this.A & 16) > 0;
    }

    public final boolean k() {
        return (this.A & 8) > 0;
    }

    public static synchronized at a(Context context, boolean z2, BuglyStrategy.a aVar) {
        if (C == null) {
            C = new at(context, ak.a(), z2, aVar);
        }
        return C;
    }

    public final synchronized void b() {
        this.f18595s.a();
        e();
        f();
    }

    public static synchronized at a() {
        return C;
    }

    public final synchronized void a(boolean z2, boolean z3, boolean z4) {
        this.f18596t.testNativeCrash(z2, z3, z4);
    }

    public final void a(CrashDetailBean crashDetailBean) {
        this.f18594r.b(crashDetailBean);
    }

    public final void a(long j2) {
        ak.a().a(new Thread() { // from class: com.tencent.bugly.proguard.at.4
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                List<CrashDetailBean> list;
                if (!ap.b(at.this.f18593c, "local_crash_lock")) {
                    al.c("Failed to lock file for uploading local crash.", new Object[0]);
                    return;
                }
                ag agVar = ag.a.a;
                List<ag.b> listA = ag.a();
                if (listA == null || listA.isEmpty()) {
                    al.c("sla local data is null", new Object[0]);
                } else {
                    al.c("sla load local data list size:%s", Integer.valueOf(listA.size()));
                    Iterator<ag.b> it = listA.iterator();
                    ArrayList arrayList = new ArrayList();
                    while (it.hasNext()) {
                        ag.b next = it.next();
                        if (next.b < ap.b() - com.baidu.mobads.sdk.internal.bj.f12906d) {
                            al.c("sla local data is expired:%s", next.f18504c);
                            arrayList.add(next);
                            it.remove();
                        }
                    }
                    ag.d(arrayList);
                    agVar.b(listA);
                }
                List<CrashDetailBean> listA2 = as.a();
                if (listA2 == null || listA2.size() <= 0) {
                    al.c("no crash need to be uploaded at this start", new Object[0]);
                } else {
                    al.c("Size of crash list: %s", Integer.valueOf(listA2.size()));
                    int size = listA2.size();
                    if (size > 20) {
                        ArrayList arrayList2 = new ArrayList();
                        Collections.sort(listA2);
                        for (int i2 = 0; i2 < 20; i2++) {
                            arrayList2.add(listA2.get((size - 1) - i2));
                        }
                        list = arrayList2;
                    } else {
                        list = listA2;
                    }
                    at.this.f18594r.a(list, 0L, false, false, false);
                }
                ap.c(at.this.f18593c, "local_crash_lock");
            }
        }, j2);
    }
}
