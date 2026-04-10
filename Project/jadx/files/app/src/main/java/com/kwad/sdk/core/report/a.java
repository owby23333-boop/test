package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.aj;
import com.tencent.smtt.sdk.TbsListener;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static ExecutorService aht = com.kwad.sdk.core.threads.b.yb();
    public static JSONObject ahu;
    public static boolean ahv;

    /* JADX INFO: renamed from: com.kwad.sdk.core.report.a$a, reason: collision with other inner class name */
    public static class C0443a extends com.kwad.sdk.core.response.kwai.a {
        public int code;
        public String msg;

        public C0443a(int i2, String str) {
            this.code = i2;
            this.msg = str;
        }
    }

    private static boolean C(AdInfo adInfo) {
        com.kwad.sdk.service.kwai.e eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class);
        if (eVar == null) {
            return false;
        }
        String strAr = com.kwad.sdk.core.response.a.a.ar(adInfo);
        if (TextUtils.isEmpty(strAr)) {
            return false;
        }
        return aj.ah(eVar.getContext(), strAr);
    }

    public static void a(AdTemplate adTemplate, int i2, long j2, int i3, long j3, @Nullable JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.vy = j2;
        bVar.akj = i3;
        bVar.ajJ = i2;
        y.a aVar = new y.a();
        aVar.duration = j3;
        bVar.akh = aVar;
        b(adTemplate, 3, bVar, (JSONObject) null);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i2, long j2, @Nullable JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.ajJ = i2;
        y.a aVar = new y.a();
        aVar.duration = j2;
        bVar.akh = aVar;
        b(adTemplate, 3, bVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i2, AdExposureFailedReason adExposureFailedReason) {
        if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
            y.b bVar = new y.b();
            bVar.ajN = i2;
            if (adExposureFailedReason != null && i2 == 2) {
                bVar.ajO = adExposureFailedReason.winEcpm;
                try {
                    bVar.adnType = adExposureFailedReason.adnType;
                    if (adExposureFailedReason.adnType == 2) {
                        bVar.adnName = adExposureFailedReason.adnName;
                    }
                } catch (Throwable unused) {
                }
            }
            b(adTemplate, 809, bVar, (JSONObject) null);
        }
    }

    public static void a(AdTemplate adTemplate, int i2, @NonNull y.b bVar, @Nullable JSONObject jSONObject) {
        bVar.ajK = i2;
        b(adTemplate, 140, bVar, (JSONObject) null);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i2, @Nullable ab.a aVar) {
        y.b bVar = new y.b();
        bVar.jS = i2;
        if (aVar != null) {
            bVar.jU = aVar;
        }
        a(adTemplate, bVar, (JSONObject) null);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i2, ab.a aVar, @Nullable JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.jS = i2;
        bVar.jU = aVar;
        a(adTemplate, bVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i2, @Nullable JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.ajH = i2;
        b(adTemplate, 402, bVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i2, JSONObject jSONObject, String str) {
        y.b bVar = new y.b();
        bVar.To = str;
        b(adTemplate, i2, bVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, long j2, @Nullable JSONObject jSONObject) {
        y.b bVar = new y.b();
        y.a aVar = new y.a();
        if (j2 != -1) {
            aVar.duration = j2;
            bVar.akh = aVar;
        }
        b(adTemplate, 934, bVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, C0443a c0443a) {
        y.b bVar = new y.b();
        bVar.ajW = c0443a.toJson().toString();
        b(adTemplate, 40, bVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, @Nullable i iVar) {
        b(adTemplate, 141, iVar != null ? iVar.xk() : null, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, i iVar, JSONObject jSONObject) {
        a(adTemplate, iVar != null ? iVar.xk() : null, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AdTemplate adTemplate, y.b bVar) {
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        String str = adInfoCb.downloadFilePath;
        if (str == null) {
            return;
        }
        String strAr = com.kwad.sdk.core.response.a.a.ar(adInfoCb);
        String strEr = aj.er(str);
        if (strEr == null || TextUtils.isEmpty(strEr) || strEr.equals(strAr)) {
            return;
        }
        bVar.ajZ = strEr;
        bVar.ajY = strAr;
        adInfoCb.adBaseInfo.appPackageName = strEr;
    }

    public static void a(AdTemplate adTemplate, y.b bVar, @Nullable JSONObject jSONObject) {
        if (bVar != null && adTemplate.fromCache) {
            bVar.a(j.aG(adTemplate));
        }
        b(adTemplate, 2, bVar, jSONObject);
    }

    public static void a(@Nullable AdTemplate adTemplate, String str, int i2) {
        y.b bVar = new y.b();
        bVar.ajR = i2;
        if (!str.equals("")) {
            bVar.ajS = str;
        }
        b(adTemplate, 803, bVar, (JSONObject) null);
    }

    public static void a(@Nullable AdTemplate adTemplate, String str, int i2, y.b bVar) {
        if (bVar == null) {
            bVar = new y.b();
        }
        bVar.ajR = i2;
        if (!str.equals("")) {
            bVar.ajS = str;
        }
        b(adTemplate, TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE, bVar, (JSONObject) null);
    }

    public static void aA(AdTemplate adTemplate) {
        y.b bVar = new y.b();
        bVar.oz = com.kwad.sdk.core.response.a.a.bn(com.kwad.sdk.core.response.a.d.cb(adTemplate));
        com.kwad.sdk.core.d.b.d("AdReportManager", "reportDownloadCardClose downloadStatus=" + bVar.oz);
        b(adTemplate, 713, bVar, (JSONObject) null);
    }

    public static void aB(AdTemplate adTemplate) {
        q(adTemplate, 722);
    }

    public static void aC(AdTemplate adTemplate) {
        q(adTemplate, 721);
    }

    public static void aD(AdTemplate adTemplate) {
        i iVar = new i();
        y.a aVar = new y.a();
        aVar.ajD = 1;
        iVar.a(aVar);
        b(adTemplate, 804, iVar.xk(), (JSONObject) null);
    }

    public static void aE(AdTemplate adTemplate) {
        i iVar = new i();
        y.a aVar = new y.a();
        aVar.ajD = 2;
        iVar.a(aVar);
        b(adTemplate, 804, iVar.xk(), (JSONObject) null);
    }

    private static boolean aF(AdTemplate adTemplate) {
        if (com.kwad.sdk.core.response.a.d.bT(adTemplate)) {
            return true;
        }
        com.kwad.sdk.service.kwai.e eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class);
        return eVar != null && eVar.Z(adTemplate);
    }

    public static void aq(AdTemplate adTemplate) {
        q(adTemplate, 4);
    }

    public static void ar(AdTemplate adTemplate) {
        y.b bVar = new y.b();
        bVar.downloadSource = adTemplate.downloadSource;
        b(adTemplate, 30, bVar, (JSONObject) null);
    }

    public static void as(final AdTemplate adTemplate) {
        aht.submit(new Runnable() { // from class: com.kwad.sdk.core.report.a.2
            @Override // java.lang.Runnable
            public final void run() {
                AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
                int iAd = aj.ad(adInfoCb.downloadId, com.kwad.sdk.core.response.a.a.ar(adInfoCb));
                y.b bVar = new y.b();
                AdTemplate adTemplate2 = adTemplate;
                bVar.downloadSource = adTemplate2.downloadSource;
                bVar.ajU = iAd;
                bVar.ajV = adTemplate2.installFrom;
                a.b(adTemplate2, 32, bVar, (JSONObject) null);
            }
        });
    }

    public static void at(AdTemplate adTemplate) {
        q(adTemplate, 36);
    }

    public static void au(AdTemplate adTemplate) {
        q(adTemplate, 38);
    }

    public static void av(AdTemplate adTemplate) {
        q(adTemplate, 41);
    }

    public static void aw(AdTemplate adTemplate) {
        y.b bVar = new y.b();
        bVar.ajY = com.kwad.sdk.core.response.a.a.ar(com.kwad.sdk.core.response.a.d.cb(adTemplate));
        b(adTemplate, 768, bVar, new JSONObject());
    }

    public static void ax(@Nullable AdTemplate adTemplate) {
        i(adTemplate, (JSONObject) null);
    }

    public static void ay(@Nullable AdTemplate adTemplate) {
        q(adTemplate, 58);
    }

    public static void az(AdTemplate adTemplate) {
        q(adTemplate, 914);
    }

    public static void b(@Nullable final AdTemplate adTemplate, final int i2, @Nullable final y.b bVar, @Nullable final JSONObject jSONObject) {
        if (adTemplate == null || !aF(adTemplate)) {
            return;
        }
        if (bVar == null) {
            bVar = new y.b();
        }
        bVar.akg = com.kwad.sdk.core.response.a.a.aM(com.kwad.sdk.core.response.a.d.cb(adTemplate));
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        com.kwad.sdk.core.d.b.d("AdReportManager", sb.toString());
        bVar.adxResult = adTemplate.adxResult;
        if (i2 == 2 && ahv) {
            if (bVar.akh == null) {
                bVar.akh = new y.a();
            }
            bVar.akh.ajG = ahu;
        }
        new x() { // from class: com.kwad.sdk.core.report.a.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* JADX INFO: renamed from: wZ, reason: merged with bridge method [inline-methods] */
            public y createRequest() {
                return new y(adTemplate, i2, bVar, jSONObject);
            }
        }.fetch();
    }

    public static void b(AdTemplate adTemplate, int i2, @Nullable JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.ajK = i2;
        b(adTemplate, 140, bVar, jSONObject);
    }

    public static void b(AdTemplate adTemplate, i iVar, @Nullable JSONObject jSONObject) {
        b(adTemplate, 3, iVar != null ? iVar.xk() : null, jSONObject);
    }

    public static void b(@Nullable AdTemplate adTemplate, y.b bVar) {
        b(adTemplate, 50, bVar, (JSONObject) null);
    }

    public static void b(@Nullable AdTemplate adTemplate, String str, int i2, y.b bVar) {
        if (bVar == null) {
            bVar = new y.b();
        }
        bVar.ajR = i2;
        if (!str.equals("")) {
            bVar.ajS = str;
        }
        b(adTemplate, TbsListener.ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT, bVar, (JSONObject) null);
    }

    public static void b(@NonNull AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable i iVar) {
        if (adTemplate.mPvReported) {
            return;
        }
        adTemplate.mPvReported = true;
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if (iVar == null) {
            iVar = new i();
        }
        iVar.br(wY());
        y.b bVarXk = iVar.xk();
        if (adTemplate.fromCache) {
            bVarXk.a(j.aG(adTemplate));
        }
        bVarXk.akf = C(adInfoCb) ? 1 : 0;
        b(adTemplate, 1, bVarXk, jSONObject);
    }

    public static void c(@Nullable AdTemplate adTemplate, int i2, int i3) {
        y.b bVar = new y.b();
        bVar.ake = i2;
        bVar.aks = i3;
        b(adTemplate, TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, bVar, (JSONObject) null);
    }

    public static void c(AdTemplate adTemplate, int i2, @Nullable JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.ajY = com.kwad.sdk.core.response.a.a.ar(com.kwad.sdk.core.response.a.d.cb(adTemplate));
        bVar.ajK = 93;
        b(adTemplate, 140, bVar, (JSONObject) null);
    }

    public static void c(@Nullable AdTemplate adTemplate, y.b bVar) {
        b(adTemplate, 51, bVar, (JSONObject) null);
    }

    public static void c(AdTemplate adTemplate, JSONObject jSONObject) {
        d(adTemplate, 601, jSONObject);
    }

    public static void c(AdTemplate adTemplate, @Nullable JSONObject jSONObject, i iVar) {
        b(adTemplate, 451, iVar != null ? iVar.xk() : null, (JSONObject) null);
    }

    public static void d(AdTemplate adTemplate, int i2, int i3) {
        y.b bVar = new y.b();
        bVar.ajK = 69;
        bVar.aka = i2;
        bVar.akb = i3;
        b(adTemplate, 501, bVar, (JSONObject) null);
    }

    private static void d(AdTemplate adTemplate, int i2, JSONObject jSONObject) {
        b(adTemplate, i2, (y.b) null, jSONObject);
    }

    public static void d(@Nullable AdTemplate adTemplate, y.b bVar) {
        b(adTemplate, 52, bVar, (JSONObject) null);
    }

    public static void d(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.downloadSource = adTemplate.downloadSource;
        b(adTemplate, 33, bVar, jSONObject);
    }

    public static void d(AdTemplate adTemplate, @Nullable JSONObject jSONObject, i iVar) {
        b(adTemplate, 140, iVar != null ? iVar.xk() : null, jSONObject);
    }

    public static void e(@Nullable AdTemplate adTemplate, y.b bVar) {
        b(adTemplate, 59, bVar, (JSONObject) null);
    }

    public static void e(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.downloadSource = adTemplate.downloadSource;
        b(adTemplate, 34, bVar, jSONObject);
    }

    public static void f(final AdTemplate adTemplate, final JSONObject jSONObject) {
        aht.submit(new Runnable() { // from class: com.kwad.sdk.core.report.a.1
            @Override // java.lang.Runnable
            public final void run() {
                y.b bVar = new y.b();
                AdTemplate adTemplate2 = adTemplate;
                bVar.downloadSource = adTemplate2.downloadSource;
                a.a(adTemplate2, bVar);
                a.b(adTemplate, 31, bVar, jSONObject);
                AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
                aj.ac(adInfoCb.downloadFilePath, adInfoCb.downloadId);
            }
        });
    }

    public static void g(AdTemplate adTemplate, JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.downloadSource = adTemplate.downloadSource;
        b(adTemplate, 35, bVar, jSONObject);
    }

    public static void h(@Nullable AdTemplate adTemplate) {
        h(adTemplate, (JSONObject) null);
    }

    public static void h(AdTemplate adTemplate, int i2) {
        y.b bVar = new y.b();
        bVar.ako = i2;
        b(adTemplate, 37, bVar, (JSONObject) null);
    }

    public static void h(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 399, jSONObject);
    }

    public static void i(AdTemplate adTemplate, int i2) {
        y.b bVar = new y.b();
        bVar.ajQ = i2;
        b(adTemplate, 923, bVar, (JSONObject) null);
    }

    public static void i(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, TbsListener.ErrorCode.INFO_CODE_BASE, jSONObject);
    }

    public static void j(@Nullable AdTemplate adTemplate, int i2) {
        y.b bVar = new y.b();
        bVar.ajT = i2;
        b(adTemplate, "wxsmallapp", 1, bVar);
    }

    public static void j(AdTemplate adTemplate, long j2) {
        y.b bVar = new y.b();
        bVar.ajM = j2;
        b(adTemplate, 600, bVar, (JSONObject) null);
    }

    public static void j(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 501, jSONObject);
    }

    public static void k(@Nullable AdTemplate adTemplate, int i2) {
        c(adTemplate, i2, 0);
    }

    public static void k(AdTemplate adTemplate, long j2) {
        y.b bVar = new y.b();
        bVar.akd = j2;
        b(adTemplate, 401, bVar, (JSONObject) null);
    }

    public static void k(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 450, jSONObject);
    }

    public static void l(AdTemplate adTemplate, int i2) {
        y.b bVar = new y.b();
        bVar.ajI = i2;
        b(adTemplate, 759, bVar, (JSONObject) null);
    }

    public static void l(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 451, jSONObject);
    }

    public static void m(AdTemplate adTemplate, int i2) {
        y.b bVar = new y.b();
        bVar.ajH = i2;
        b(adTemplate, 28, bVar, (JSONObject) null);
    }

    public static void n(AdTemplate adTemplate, int i2) {
        if (adTemplate == null) {
            return;
        }
        y.b bVar = new y.b();
        bVar.ajY = com.kwad.sdk.core.response.a.a.ar(com.kwad.sdk.core.response.a.d.cb(adTemplate));
        b(adTemplate, i2, bVar, new JSONObject());
    }

    public static void o(AdTemplate adTemplate, int i2) {
        b(adTemplate, i2, new y.b(), new JSONObject());
    }

    @Deprecated
    public static void p(AdTemplate adTemplate, int i2) {
        a(adTemplate, new i().bh(i2));
    }

    private static void q(AdTemplate adTemplate, int i2) {
        b(adTemplate, i2, (y.b) null, new JSONObject());
    }

    private static int wY() {
        return ah.cu(ServiceProvider.getContext()) ? 2 : 1;
    }
}
