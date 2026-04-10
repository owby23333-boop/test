package com.kwad.sdk.core.adlog;

import androidx.media3.extractor.AacUtil;
import com.kwad.components.ad.reward.monitor.FraudVerifyCode;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    public static void a(final com.kwad.sdk.core.adlog.c.a aVar) {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.sdk.core.adlog.b.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a aVar2 = new a(aVar);
                b.a(aVar2.getUrl(), aVar2.getBody(), aVar, null);
            }
        });
    }

    public static void Ex() {
        GlobalThreadPools.Jy().execute(new bg() { // from class: com.kwad.sdk.core.adlog.b.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.core.adlog.a.a aVarED = com.kwad.sdk.core.adlog.a.b.EA().ED();
                if (aVarED != null) {
                    JSONObject jSONObject = aVarED.axq;
                    aa.putValue(jSONObject, "retryCount", aVarED.retryCount);
                    aa.putValue(jSONObject, "cacheType", 1);
                    b.a(aVarED.url, jSONObject, aVarED.axr, aVarED);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.a aVar, com.kwad.sdk.core.adlog.a.a aVar2) {
        AdTemplate adTemplate = aVar.adTemplate;
        int i = aVar.awx;
        try {
            com.kwad.sdk.core.adlog.b.c.a(adTemplate, i, aVar2);
            if (!ao.isNetworkConnected(ServiceProvider.getContext())) {
                com.kwad.sdk.core.d.c.w("AdLogRequestManager", "no network while report log");
                com.kwad.sdk.core.adlog.b.c.a(adTemplate, i, str, 100004, "no network", aVar2);
                com.kwad.sdk.core.adlog.a.b.EA().a(aVar2, str, jSONObject, aVar, 100004, "no network");
                return;
            }
            if (bw.hA(str)) {
                com.kwad.sdk.core.adlog.b.c.b(adTemplate, i, str, FraudVerifyCode.RerwardFraudUnknown, "", aVar2);
                return;
            }
            com.kwad.sdk.core.network.c cVarDoPost = g.AI().doPost(str, (Map<String, String>) null, jSONObject);
            AdLogRequestResult adLogRequestResult = new AdLogRequestResult();
            adLogRequestResult.parseResult(cVarDoPost.aEk);
            if (cVarDoPost.code != 200) {
                int iCu = d.cu(cVarDoPost.code);
                String str2 = cVarDoPost.aEk;
                com.kwad.sdk.core.adlog.b.c.d(adTemplate, i, str, iCu, str2, aVar2);
                com.kwad.sdk.core.adlog.a.b.EA().a(aVar2, str, jSONObject, aVar, iCu, str2);
                return;
            }
            if (adLogRequestResult.isResultOk()) {
                com.kwad.sdk.core.adlog.b.c.b(adTemplate, i, aVar2);
                b(aVar);
                com.kwad.sdk.core.adlog.a.b.EA().EB();
            } else {
                if (adLogRequestResult.isCheatingFlow()) {
                    adTemplate.setCheatingFlow(adLogRequestResult.isCheatingFlow());
                    com.kwad.sdk.core.adlog.b.c.c(adTemplate, i, str, adLogRequestResult.result, adLogRequestResult.errorMsg, aVar2);
                    return;
                }
                int i2 = adLogRequestResult.result;
                String str3 = adLogRequestResult.errorMsg;
                com.kwad.sdk.core.d.c.w("AdLogRequestManager", "request fail code:" + i2 + ", errorMsg:" + str3 + ", url=" + str);
                com.kwad.sdk.core.adlog.b.c.c(adTemplate, i, str, i2, str3, aVar2);
                com.kwad.sdk.core.adlog.a.b.EA().a(aVar2, str, jSONObject, aVar, i2, str3);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.adlog.b.c.b(adTemplate, i, "", AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND, bw.s(th), aVar2);
            com.kwad.sdk.core.d.c.printStackTrace(th);
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void b(com.kwad.sdk.core.adlog.c.a aVar) {
        try {
            com.kwad.sdk.core.track.a.e(aVar);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
