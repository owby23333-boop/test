package com.kwad.sdk.j;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX INFO: renamed from: com.kwad.sdk.j.a$a, reason: collision with other inner class name */
    public static class C0419a extends com.kwad.sdk.commercial.c.a {
        public String aOu;
        public int aTs;
        public String sdkVersion;
    }

    public static class b extends com.kwad.sdk.commercial.c.a {
        public int aTt;
        public String aTu;
        public String aTv;
        public String aTw;
        public String aTx;
        public String aTy;
    }

    public static void NJ() {
        h.execute(new bg() { // from class: com.kwad.sdk.j.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.NK();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void NK() {
        C0419a c0419aA;
        JSONObject jSONObject = (JSONObject) e.Fw().getAppConfigData(null, new com.kwad.sdk.g.b<JSONObject, JSONObject>() { // from class: com.kwad.sdk.j.a.2
            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ JSONObject apply(JSONObject jSONObject2) {
                return o(jSONObject2);
            }

            private static JSONObject o(JSONObject jSONObject2) {
                return jSONObject2.optJSONObject("sdkTTPerfMonitor");
            }
        });
        if (jSONObject == null) {
            return;
        }
        b bVar = new b();
        try {
            bVar.parseJson(jSONObject);
            if (bVar.aTt == 1 && (c0419aA = a(ServiceProvider.getContext().getClassLoader(), bVar)) != null) {
                com.kwad.sdk.commercial.b.d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_tt_sdk_info", "sv").z(c0419aA).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
            }
        } catch (Throwable unused) {
        }
    }

    private static C0419a a(ClassLoader classLoader, b bVar) {
        Class<?> clsA = z.a(bVar.aTu, classLoader);
        if (clsA == null) {
            return null;
        }
        C0419a c0419a = new C0419a();
        c0419a.aTs = z.classExists(bVar.aTv) ? 1 : 0;
        Object objCallStaticMethod = z.callStaticMethod(clsA, bVar.aTw, new Object[0]);
        c0419a.sdkVersion = (String) z.callMethod(objCallStaticMethod, bVar.aTx, new Object[0]);
        c0419a.aOu = (String) z.callMethod(objCallStaticMethod, bVar.aTy, new Object[0]);
        return c0419a;
    }
}
