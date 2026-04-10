package com.kwad.components.core.g;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static int Qe;
    public static AtomicInteger Qf = new AtomicInteger(0);

    public static void a(final BusinessType businessType) {
        GlobalThreadPools.Jy().execute(new Runnable() { // from class: com.kwad.components.core.g.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    String strGr = e.Gr();
                    if (strGr == null) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(strGr);
                    boolean zOptBoolean = jSONObject.optBoolean("isCheatUser", false);
                    boolean zOptBoolean2 = jSONObject.optBoolean("enableAdClientCheaterReport", false);
                    a.Qe = jSONObject.optInt("maxCollectCount", 0);
                    if (zOptBoolean2 && a.Qf.incrementAndGet() <= a.Qe) {
                        com.kwad.sdk.commercial.b.d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(1.0d).b(businessType).O("ad_sdk_feature_info_collect", "default_type").h(b.qi().aE(zOptBoolean).aH(a.Qe).toJson()));
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }
}
