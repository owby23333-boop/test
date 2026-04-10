package com.kwad.components.core.d.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.bh;
import com.kwai.adclient.logger.model.BusinessType;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends com.kwad.sdk.core.download.kwai.b {
    private static boolean Jv = false;
    private static final b Jw = new b() { // from class: com.kwad.components.core.d.b.d.2
        long Jz;

        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            this.Jz = System.currentTimeMillis();
        }

        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            if (this.Jz != 0) {
                com.kwad.sdk.core.report.a.k(getAdTemplate(), System.currentTimeMillis() - this.Jz);
            }
            com.kwad.sdk.core.b.b.we();
            com.kwad.sdk.core.b.b.b(d.Jw);
            setAdTemplate(null);
            this.Jz = 0L;
        }
    };

    public static String a(Context context, AdInfo adInfo, SceneImpl sceneImpl) {
        if (sceneImpl == null) {
            return "";
        }
        int i2 = 0;
        if (!aj.ah(context, "com.smile.gifmaker") && aj.ah(context, "com.kuaishou.nebula")) {
            i2 = 3;
        }
        String backUrl = sceneImpl.getBackUrl();
        String strCq = com.kwad.sdk.core.response.a.a.cq(adInfo);
        if (TextUtils.isEmpty(backUrl)) {
            backUrl = "";
        }
        return a(strCq, i2, backUrl);
    }

    private static String a(a.C0395a c0395a, AdInfo adInfo, String str) {
        String strValueOf;
        if (!com.kwad.sdk.core.response.a.a.bb(adInfo)) {
            return str;
        }
        String strNh = (c0395a.jZ() == null || c0395a.jZ().getCurrentShowShopItemInfo() == null) ? c0395a.nh() : c0395a.jZ().getCurrentShowShopItemInfo().itemId;
        if (TextUtils.isEmpty(strNh)) {
            return (str.contains("__itemId__") || str.contains("__simpleItemId__")) ? com.kwad.sdk.core.response.a.a.cq(adInfo) : str;
        }
        try {
            strValueOf = String.valueOf(com.kwad.components.core.d.kwai.a.aj(strNh));
        } catch (Throwable unused) {
            strValueOf = strNh;
        }
        return str.replaceAll("__itemId__", strNh).replaceAll("__simpleItemId__", strValueOf);
    }

    private static String a(a.C0395a c0395a, AdTemplate adTemplate) {
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        for (AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo : adInfoCb.adConversionInfo.deeplinkConf) {
            boolean zContains = deeplinkItemInfo.areaConf.contains(Integer.valueOf(c0395a.de()));
            boolean zContains2 = deeplinkItemInfo.sceneConf.contains(Integer.valueOf(c0395a.nj()));
            if ((zContains && zContains2) || ((zContains && deeplinkItemInfo.sceneConf.size() == 0) || (zContains2 && deeplinkItemInfo.areaConf.size() == 0))) {
                if (!TextUtils.isEmpty(deeplinkItemInfo.url)) {
                    if ((com.kwad.sdk.core.response.a.a.cg(adInfoCb) || com.kwad.sdk.core.response.a.a.cm(adInfoCb)) && adTemplate.mAdScene != null) {
                        return a(deeplinkItemInfo.url + adInfoCb.adConversionInfo.deeplinkExtra, c0395a.getContext(), adTemplate.mAdScene);
                    }
                    if (com.kwad.sdk.core.response.a.a.co(adInfoCb)) {
                        return a(c0395a, adInfoCb, deeplinkItemInfo.url) + adInfoCb.adConversionInfo.deeplinkExtra;
                    }
                    return deeplinkItemInfo.url + adInfoCb.adConversionInfo.deeplinkExtra;
                }
            }
        }
        return com.kwad.sdk.core.response.a.a.co(adInfoCb) ? a(c0395a, adInfoCb, com.kwad.sdk.core.response.a.a.cq(adInfoCb)) : com.kwad.sdk.core.response.a.a.cq(adInfoCb);
    }

    private static String a(String str, int i2, String str2) {
        return TextUtils.isEmpty(str2) ? str : (i2 == 0 || i2 == 3) ? g(str, str2) : str;
    }

    private static String a(String str, Context context, SceneImpl sceneImpl) {
        if (sceneImpl == null) {
            return "";
        }
        int i2 = 0;
        if (!aj.ah(context, "com.smile.gifmaker") && aj.ah(context, "com.kuaishou.nebula")) {
            i2 = 3;
        }
        String backUrl = sceneImpl.getBackUrl();
        if (TextUtils.isEmpty(backUrl)) {
            backUrl = "";
        }
        return a(str, i2, backUrl);
    }

    private static JSONObject ao(String str) {
        try {
            return new JSONObject(Uri.parse(str).getQueryParameter("universeClientInfo"));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void at(boolean z2) {
        com.kwad.sdk.core.report.a.ahv = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void au(boolean z2) {
        Jv = z2;
    }

    public static int b(a.C0395a c0395a, int i2) {
        Context context = c0395a.getContext();
        AdTemplate adTemplate = c0395a.getAdTemplate();
        if (adTemplate == null || context == null) {
            return 0;
        }
        Jw.setAdTemplate(adTemplate);
        com.kwad.sdk.core.b.b.we();
        com.kwad.sdk.core.b.b.a(Jw);
        com.kwad.sdk.core.response.a.d.cb(adTemplate);
        String strA = a(c0395a, adTemplate);
        com.kwad.sdk.core.report.a.ahu = ao(strA);
        int iG = com.kwad.sdk.core.download.kwai.b.g(context, strA);
        BusinessType businessTypeBs = null;
        if (iG == 1) {
            if (c0395a.getAdTemplate() != null && c0395a.getAdTemplate().mAdScene != null) {
                businessTypeBs = KSLoggerReporter.bs(c0395a.getAdTemplate().mAdScene.getAdStyle());
            }
            KSLoggerReporter.ReportClient.CONVERT_DPLINK.buildMethodCheck(businessTypeBs, "dplinkSuccess");
            com.kwad.sdk.core.report.a.a(adTemplate, "", i2, c0395a.getClientParams());
            d(adTemplate, i2);
        } else if (iG == -1) {
            com.kwad.sdk.core.report.a.b(adTemplate, "", i2, (y.b) null);
        }
        return iG;
    }

    private static void d(final AdTemplate adTemplate, final int i2) {
        if (nM()) {
            return;
        }
        au(true);
        int iUz = com.kwad.sdk.core.config.d.uz();
        com.kwad.sdk.core.config.d.uA();
        if (Math.abs(iUz) > 0) {
            bh.a(new Runnable() { // from class: com.kwad.components.core.d.b.d.1
                @Override // java.lang.Runnable
                public final void run() {
                    SceneImpl sceneImpl;
                    d.au(false);
                    com.kwad.sdk.core.b.b.we();
                    if (com.kwad.sdk.core.b.b.isAppOnForeground()) {
                        return;
                    }
                    com.kwad.sdk.core.report.a.a(adTemplate, "", i2);
                    BusinessType businessTypeBs = null;
                    AdTemplate adTemplate2 = adTemplate;
                    if (adTemplate2 != null && (sceneImpl = adTemplate2.mAdScene) != null) {
                        businessTypeBs = KSLoggerReporter.bs(sceneImpl.getAdStyle());
                    }
                    KSLoggerReporter.ReportClient.CONVERT_DPLINK.buildMethodCheck(businessTypeBs, "trueDplinkSuccess");
                }
            }, null, r0 * 1000);
        } else {
            au(false);
        }
    }

    private static String g(String str, String str2) {
        Uri.Builder builderAppendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter("returnBack", "liveunion_" + KsAdSDKImpl.get().getAppId());
        if (TextUtils.isEmpty(str2)) {
            str2 = "0";
        }
        return builderAppendQueryParameter.appendQueryParameter("back_url", str2).toString();
    }

    private static boolean nM() {
        return Jv;
    }
}
