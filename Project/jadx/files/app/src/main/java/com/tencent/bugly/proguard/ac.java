package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class ac {
    public static int a = 1000;
    public static long b = 259200000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ac f18496d;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f18497i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ak f18498c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<o> f18499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final StrategyBean f18500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private StrategyBean f18501g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Context f18502h;

    private ac(Context context, List<o> list) {
        this.f18502h = context;
        if (aa.a(context) != null) {
            String str = aa.a(context).H;
            if ("oversea".equals(str)) {
                StrategyBean.a = "https://astat.bugly.qcloud.com/rqd/async";
                StrategyBean.b = "https://astat.bugly.qcloud.com/rqd/async";
            } else if ("na_https".equals(str)) {
                StrategyBean.a = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
                StrategyBean.b = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
            }
        }
        this.f18500f = new StrategyBean();
        this.f18499e = list;
        this.f18498c = ak.a();
    }

    public static StrategyBean d() {
        byte[] bArr;
        List<y> listA = w.a().a(2);
        if (listA == null || listA.size() <= 0 || (bArr = listA.get(0).f18825g) == null) {
            return null;
        }
        return (StrategyBean) ap.a(bArr, StrategyBean.CREATOR);
    }

    public final StrategyBean c() {
        StrategyBean strategyBean = this.f18501g;
        if (strategyBean != null) {
            if (!ap.c(strategyBean.f18422q)) {
                this.f18501g.f18422q = StrategyBean.a;
            }
            if (!ap.c(this.f18501g.f18423r)) {
                this.f18501g.f18423r = StrategyBean.b;
            }
            return this.f18501g;
        }
        if (!ap.a(f18497i) && ap.c(f18497i)) {
            StrategyBean strategyBean2 = this.f18500f;
            String str = f18497i;
            strategyBean2.f18422q = str;
            strategyBean2.f18423r = str;
        }
        return this.f18500f;
    }

    public final synchronized boolean b() {
        return this.f18501g != null;
    }

    public static synchronized ac a(Context context, List<o> list) {
        if (f18496d == null) {
            f18496d = new ac(context, list);
        }
        return f18496d;
    }

    public static synchronized ac a() {
        return f18496d;
    }

    protected final void a(StrategyBean strategyBean, boolean z2) {
        al.c("[Strategy] Notify %s", s.class.getName());
        s.a(strategyBean, z2);
        for (o oVar : this.f18499e) {
            try {
                al.c("[Strategy] Notify %s", oVar.getClass().getName());
                oVar.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void a(String str) {
        if (!ap.a(str) && ap.c(str)) {
            f18497i = str;
        } else {
            al.d("URL user set is invalid.", new Object[0]);
        }
    }

    public final void a(bt btVar) {
        Map<String, String> map;
        if (btVar == null) {
            return;
        }
        StrategyBean strategyBean = this.f18501g;
        if (strategyBean == null || btVar.f18736h != strategyBean.f18420o) {
            StrategyBean strategyBean2 = new StrategyBean();
            strategyBean2.f18411f = btVar.a;
            strategyBean2.f18413h = btVar.f18731c;
            strategyBean2.f18412g = btVar.b;
            if (ap.a(f18497i) || !ap.c(f18497i)) {
                if (ap.c(btVar.f18732d)) {
                    al.c("[Strategy] Upload url changes to %s", btVar.f18732d);
                    strategyBean2.f18422q = btVar.f18732d;
                }
                if (ap.c(btVar.f18733e)) {
                    al.c("[Strategy] Exception upload url changes to %s", btVar.f18733e);
                    strategyBean2.f18423r = btVar.f18733e;
                }
            }
            bs bsVar = btVar.f18734f;
            if (bsVar != null && !ap.a(bsVar.a)) {
                strategyBean2.f18424s = btVar.f18734f.a;
            }
            long j2 = btVar.f18736h;
            if (j2 != 0) {
                strategyBean2.f18420o = j2;
            }
            if (btVar != null && (map = btVar.f18735g) != null && map.size() > 0) {
                Map<String, String> map2 = btVar.f18735g;
                strategyBean2.f18425t = map2;
                String str = map2.get("B11");
                strategyBean2.f18414i = str != null && str.equals("1");
                String str2 = btVar.f18735g.get("B3");
                if (str2 != null) {
                    strategyBean2.f18428w = Long.parseLong(str2);
                }
                int i2 = btVar.f18740l;
                strategyBean2.f18421p = i2;
                strategyBean2.f18427v = i2;
                String str3 = btVar.f18735g.get("B27");
                if (str3 != null && str3.length() > 0) {
                    try {
                        int i3 = Integer.parseInt(str3);
                        if (i3 > 0) {
                            strategyBean2.f18426u = i3;
                        }
                    } catch (Exception e2) {
                        if (!al.a(e2)) {
                            e2.printStackTrace();
                        }
                    }
                }
                String str4 = btVar.f18735g.get("B25");
                strategyBean2.f18416k = str4 != null && str4.equals("1");
            }
            al.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean2.f18411f), Boolean.valueOf(strategyBean2.f18413h), Boolean.valueOf(strategyBean2.f18412g), Boolean.valueOf(strategyBean2.f18414i), Boolean.valueOf(strategyBean2.f18415j), Boolean.valueOf(strategyBean2.f18418m), Boolean.valueOf(strategyBean2.f18419n), Long.valueOf(strategyBean2.f18421p), Boolean.valueOf(strategyBean2.f18416k), Long.valueOf(strategyBean2.f18420o));
            this.f18501g = strategyBean2;
            if (!ap.c(btVar.f18732d)) {
                al.c("[Strategy] download url is null", new Object[0]);
                this.f18501g.f18422q = "";
            }
            if (!ap.c(btVar.f18733e)) {
                al.c("[Strategy] download crashurl is null", new Object[0]);
                this.f18501g.f18423r = "";
            }
            w.a().b(2);
            y yVar = new y();
            yVar.b = 2;
            yVar.a = strategyBean2.f18409d;
            yVar.f18823e = strategyBean2.f18410e;
            yVar.f18825g = ap.a(strategyBean2);
            w.a().a(yVar);
            a(strategyBean2, true);
        }
    }
}
