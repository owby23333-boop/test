package com.tramini.plugin.a.k;

import android.text.TextUtils;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustAttribution;
import com.anythink.expressad.foundation.d.r;
import com.appsflyer.AppsFlyerLib;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static b a;

    final class a implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ l.c.a.a.a f19376s;

        a(l.c.a.a.a aVar) {
            this.f19376s = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (b.this) {
                try {
                    if (this.f19376s.a() != 1) {
                        return;
                    }
                    String strA = g.a(this.f19376s);
                    l.c.a.a.a aVar = this.f19376s;
                    try {
                        com.tramini.plugin.a.g.b bVar = new com.tramini.plugin.a.g.b();
                        bVar.a = AppsFlyerLib.getInstance().getSdkVersion();
                        bVar.b = 1;
                        String strB = i.b(com.tramini.plugin.a.a.c.c().a(), "appsflyer-data", "attributionId", "");
                        if (!TextUtils.isEmpty(strB)) {
                            bVar.f19336c = strB;
                            JSONObject jSONObjectA = bVar.a();
                            String strB2 = i.b(com.tramini.plugin.a.a.c.c().a(), "tramini", "S_ASF_ATT", "");
                            if (jSONObjectA != null && !TextUtils.equals(strB2, strB)) {
                                i.a(com.tramini.plugin.a.a.c.c().a(), "tramini", "S_ASF_ATT", strB);
                                com.tramini.plugin.a.j.b.a().a(strA, aVar.b(), d.a, jSONObjectA);
                            }
                        }
                    } catch (Throwable unused) {
                    }
                    l.c.a.a.a aVar2 = this.f19376s;
                    com.tramini.plugin.a.g.b bVar2 = new com.tramini.plugin.a.g.b();
                    bVar2.a = Adjust.getSdkVersion();
                    bVar2.b = 2;
                    AdjustAttribution attribution = Adjust.getAttribution();
                    if (attribution != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("adgroup", attribution.adgroup);
                        jSONObject.put("adid", attribution.adid);
                        jSONObject.put("campaign", attribution.campaign);
                        jSONObject.put("clickLabel", attribution.clickLabel);
                        jSONObject.put(r.aD, attribution.creative);
                        jSONObject.put("network", attribution.network);
                        jSONObject.put("trackerName", attribution.trackerName);
                        jSONObject.put("trackerToken", attribution.trackerToken);
                        jSONObject.put("attr", attribution.toString());
                        bVar2.f19336c = jSONObject.toString();
                        JSONObject jSONObjectA2 = bVar2.a();
                        if (!TextUtils.equals(i.b(com.tramini.plugin.a.a.c.c().a(), "tramini", "S_AJS_ATT", ""), jSONObject.toString())) {
                            i.a(com.tramini.plugin.a.a.c.c().a(), "tramini", "S_AJS_ATT", jSONObject.toString());
                            com.tramini.plugin.a.j.b.a().a(strA, aVar2.b(), d.a, jSONObjectA2);
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public abstract class c implements Runnable {
        public abstract void a();

        final void a(int i2) {
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    private b() {
    }

    public static b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    /* JADX INFO: renamed from: com.tramini.plugin.a.k.b$b, reason: collision with other inner class name */
    public final class C0543b {
        private static C0543b b;
        private ExecutorService a;

        /* JADX INFO: renamed from: com.tramini.plugin.a.k.b$b$a */
        final class a extends c {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            final /* synthetic */ long f19378s;

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            final /* synthetic */ Runnable f19379t;

            a(C0543b c0543b, long j2, Runnable runnable) {
                this.f19378s = j2;
                this.f19379t = runnable;
            }

            @Override // com.tramini.plugin.a.k.b.c
            public final void a() {
                try {
                    Thread.sleep(this.f19378s);
                } catch (InterruptedException unused) {
                }
                this.f19379t.run();
            }
        }

        protected C0543b() {
            this.a = null;
            this.a = new ThreadPoolExecutor(0, 50, 60L, TimeUnit.SECONDS, new SynchronousQueue());
        }

        public static C0543b a() {
            if (b == null) {
                b = new C0543b();
            }
            return b;
        }

        public final void a(c cVar) {
            this.a.execute(cVar);
        }

        public final void a(Runnable runnable) {
            a(runnable, 0L);
        }

        public final void a(Runnable runnable, long j2) {
            if (runnable != null) {
                a aVar = new a(this, j2, runnable);
                aVar.a(Long.valueOf(System.currentTimeMillis() / 1000).intValue());
                a((c) aVar);
            }
        }
    }

    public final void a(l.c.a.a.a aVar) {
        C0543b.a().a(new a(aVar));
    }
}
