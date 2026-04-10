package com.kwad.sdk.f;

import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.report.o;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.r;
import com.kwai.adclient.logger.model.BusinessType;
import com.kwai.adclient.logger.model.SubBusinessType;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int atE;
        public String atF;
        public String sdkVersion;
    }

    /* JADX INFO: renamed from: com.kwad.sdk.f.b$b, reason: collision with other inner class name */
    public static class C0454b extends com.kwad.sdk.core.response.kwai.a {
        public int atG;
        public String atH;
        public String atI;
        public String atJ;
        public String atK;
        public String atL;
    }

    public static void Bo() {
        g.execute(new av() { // from class: com.kwad.sdk.f.b.1
            @Override // com.kwad.sdk.utils.av
            public final void doTask() {
                b.Bp();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Bp() {
        a aVarA;
        JSONObject jSONObject = (JSONObject) d.uG().getAppConfigData(null, new com.kwad.sdk.d.b<JSONObject, JSONObject>() { // from class: com.kwad.sdk.f.b.2
            private static JSONObject C(JSONObject jSONObject2) {
                return jSONObject2.optJSONObject("sdkTTPerfMonitor");
            }

            @Override // com.kwad.sdk.d.b
            public final /* synthetic */ JSONObject apply(JSONObject jSONObject2) {
                return C(jSONObject2);
            }
        });
        if (jSONObject == null) {
            return;
        }
        C0454b c0454b = new C0454b();
        try {
            c0454b.parseJson(jSONObject);
            if (c0454b.atG == 1 && (aVarA = a(ServiceProvider.getContext().getClassLoader(), c0454b)) != null) {
                KSLoggerReporter.a(new o.a().cl(ILoggerReporter.Category.APM_LOG).a(BusinessType.OTHER).a(SubBusinessType.OTHER).cm("ad_sdk_tt_sdk_info").z(aVarA.toJson()).xm());
            }
        } catch (Throwable unused) {
        }
    }

    @Nullable
    private static a a(ClassLoader classLoader, C0454b c0454b) {
        Class<?> clsA = r.a(c0454b.atH, classLoader);
        if (clsA == null) {
            return null;
        }
        a aVar = new a();
        aVar.atE = r.eh(c0454b.atI) ? 1 : 0;
        Object objB = r.b(clsA, c0454b.atJ, new Object[0]);
        aVar.sdkVersion = (String) r.a(objB, c0454b.atK, new Object[0]);
        aVar.atF = (String) r.a(objB, c0454b.atL, new Object[0]);
        return aVar;
    }
}
