package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class au {
    private static au a;
    private ac b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private aa f18609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private as f18610d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f18611e;

    private au(Context context) {
        at atVarA = at.a();
        if (atVarA == null) {
            return;
        }
        this.b = ac.a();
        this.f18609c = aa.a(context);
        this.f18610d = atVarA.f18594r;
        this.f18611e = context;
        ak.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.au.1
            @Override // java.lang.Runnable
            public final void run() {
                au.a(au.this);
            }
        });
    }

    public static au a(Context context) {
        if (a == null) {
            a = new au(context);
        }
        return a;
    }

    public static void a(final Thread thread, final int i2, final String str, final String str2, final String str3, final Map<String, String> map) {
        ak.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.au.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (au.a == null) {
                        al.e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
                    } else {
                        au.a(au.a, thread, i2, str, str2, str3, map);
                    }
                } catch (Throwable th) {
                    if (!al.b(th)) {
                        th.printStackTrace();
                    }
                    al.e("[ExtraCrashManager] Crash error %s %s %s", str, str2, str3);
                }
            }
        });
    }

    static /* synthetic */ void a(au auVar) {
        al.c("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            Class<?> cls = Class.forName("com.tencent.bugly.agent.GameAgent");
            auVar.f18609c.getClass();
            ap.a(cls, "sdkPackageName", "com.tencent.bugly");
            al.c("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            al.a("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }

    static /* synthetic */ void a(au auVar, Thread thread, int i2, String str, String str2, String str3, Map map) {
        String str4;
        String str5;
        String str6;
        Thread threadCurrentThread = thread == null ? Thread.currentThread() : thread;
        if (i2 == 4) {
            str4 = "Unity";
        } else if (i2 == 5 || i2 == 6) {
            str4 = "Cocos";
        } else {
            if (i2 != 8) {
                al.d("[ExtraCrashManager] Unknown extra crash type: %d", Integer.valueOf(i2));
                return;
            }
            str4 = "H5";
        }
        al.e("[ExtraCrashManager] %s Crash Happen", str4);
        try {
            if (!auVar.b.b()) {
                al.d("[ExtraCrashManager] There is no remote strategy, but still store it.", new Object[0]);
            }
            StrategyBean strategyBeanC = auVar.b.c();
            if (!strategyBeanC.f18411f && auVar.b.b()) {
                al.e("[ExtraCrashManager] Crash report was closed by remote. Will not upload to Bugly , print local for helpful!", new Object[0]);
                as.a(str4, ap.a(), auVar.f18609c.f18472d, threadCurrentThread.getName(), str + "\n" + str2 + "\n" + str3, null);
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            if (i2 != 5 && i2 != 6) {
                if (i2 == 8 && !strategyBeanC.f18417l) {
                    al.e("[ExtraCrashManager] %s report is disabled.", str4);
                    al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                    return;
                }
            } else if (!strategyBeanC.f18416k) {
                al.e("[ExtraCrashManager] %s report is disabled.", str4);
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            boolean z2 = true;
            int i3 = i2 != 8 ? i2 : 5;
            CrashDetailBean crashDetailBean = new CrashDetailBean();
            crashDetailBean.C = ab.j();
            crashDetailBean.D = ab.f();
            crashDetailBean.E = ab.l();
            crashDetailBean.F = auVar.f18609c.k();
            crashDetailBean.G = auVar.f18609c.j();
            crashDetailBean.H = auVar.f18609c.l();
            crashDetailBean.I = ab.b(auVar.f18611e);
            crashDetailBean.J = ab.g();
            crashDetailBean.K = ab.h();
            crashDetailBean.b = i3;
            crashDetailBean.f18431e = auVar.f18609c.g();
            crashDetailBean.f18432f = auVar.f18609c.f18483o;
            crashDetailBean.f18433g = auVar.f18609c.q();
            crashDetailBean.f18439m = auVar.f18609c.f();
            crashDetailBean.f18440n = String.valueOf(str);
            crashDetailBean.f18441o = String.valueOf(str2);
            str5 = "";
            if (str3 != null) {
                String[] strArrSplit = str3.split("\n");
                str5 = strArrSplit.length > 0 ? strArrSplit[0] : "";
                str6 = str3;
            } else {
                str6 = "";
            }
            crashDetailBean.f18442p = str5;
            crashDetailBean.f18443q = str6;
            crashDetailBean.f18444r = System.currentTimeMillis();
            crashDetailBean.f18447u = ap.c(crashDetailBean.f18443q.getBytes());
            crashDetailBean.f18452z = ap.a(auVar.f18609c.Q, at.f18583h);
            crashDetailBean.A = auVar.f18609c.f18472d;
            crashDetailBean.B = threadCurrentThread.getName() + com.umeng.message.proguard.ad.f20405r + threadCurrentThread.getId() + com.umeng.message.proguard.ad.f20406s;
            crashDetailBean.L = auVar.f18609c.s();
            crashDetailBean.f18434h = auVar.f18609c.p();
            crashDetailBean.Q = auVar.f18609c.a;
            crashDetailBean.R = auVar.f18609c.a();
            crashDetailBean.U = auVar.f18609c.z();
            crashDetailBean.V = auVar.f18609c.f18492x;
            crashDetailBean.W = auVar.f18609c.t();
            crashDetailBean.X = auVar.f18609c.y();
            crashDetailBean.f18451y = ao.a();
            if (crashDetailBean.S == null) {
                crashDetailBean.S = new LinkedHashMap();
            }
            if (map != null) {
                crashDetailBean.S.putAll(map);
            }
            as.a(str4, ap.a(), auVar.f18609c.f18472d, threadCurrentThread.getName(), str + "\n" + str2 + "\n" + str3, crashDetailBean);
            as asVar = auVar.f18610d;
            if (at.a().B) {
                z2 = false;
            }
            if (!asVar.a(crashDetailBean, z2)) {
                auVar.f18610d.b(crashDetailBean, false);
            }
            al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
        } catch (Throwable th) {
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
            } catch (Throwable th2) {
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                throw th2;
            }
        }
    }
}
