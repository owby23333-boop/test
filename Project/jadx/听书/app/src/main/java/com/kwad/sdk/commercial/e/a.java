package com.kwad.sdk.commercial.e;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bw;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static void c(AdTemplate adTemplate, String str, String str2) {
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(0.01d).b(d.be(adTemplate)).O("ad_sdk_ad_data_performance", "error_name").z(b.DW().cM(str).cN(str2).setAdTemplate(adTemplate)));
    }

    public static void a(SceneImpl sceneImpl, long j, String str) {
        if (sceneImpl == null) {
            return;
        }
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(0.01d).b(d.ct(sceneImpl.getAdStyle())).O("ad_sdk_ad_parse_performance", "default").z(c.DX().cO(str).setPosId(sceneImpl.posId).setLlsid(j)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(SceneImpl sceneImpl, long j, String str, String str2) {
        if (sceneImpl == null) {
            return;
        }
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(0.01d).b(d.ct(sceneImpl.getAdStyle())).O("ad_sdk_ad_parse_performance", "default").z(c.DX().cO(str).cP(str2).setErrorCode(100013).setPosId(sceneImpl.posId).setLlsid(j)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bM(AdTemplate adTemplate) {
        try {
            if (adTemplate.llsid == 0) {
                c(adTemplate, "llsid", "");
            }
            if (e.ev(adTemplate) == 0) {
                c(adTemplate, "create_id", "");
            }
            AdInfo adInfoEl = e.el(adTemplate);
            int i = adInfoEl.adBaseInfo.adOperationType;
            if (i == 1) {
                String strCU = com.kwad.sdk.core.response.b.a.cU(adInfoEl);
                if (bw.hA(strCU)) {
                    c(adTemplate, "download_url", strCU);
                }
            } else if (i == 2) {
                String strAS = com.kwad.sdk.core.response.b.a.aS(adInfoEl);
                if (bw.hA(strAS)) {
                    c(adTemplate, "h5_url", strAS);
                }
            }
            AdInfo.AdMaterialInfo.MaterialFeature materialFeatureN = com.kwad.sdk.core.response.b.a.N(adInfoEl);
            int i2 = materialFeatureN.featureType;
            String str = materialFeatureN.materialUrl;
            if (i2 == 1) {
                if (bw.hA(str)) {
                    c(adTemplate, "video_url", str);
                    return;
                }
                return;
            }
            if (i2 == 2) {
                if (bw.hA(str)) {
                    c(adTemplate, "image_url", str);
                }
            } else if (i2 == 3) {
                long jCp = com.kwad.sdk.core.response.b.a.cp(adInfoEl);
                String strBh = com.kwad.sdk.core.response.b.a.bh(adInfoEl);
                if (jCp == 0) {
                    c(adTemplate, "live_author_id", "");
                } else if (TextUtils.isEmpty(strBh)) {
                    c(adTemplate, "live_stream_id", strBh);
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void e(AdTemplate adTemplate, String str) {
        c(adTemplate, "tk_template_id", str);
    }
}
