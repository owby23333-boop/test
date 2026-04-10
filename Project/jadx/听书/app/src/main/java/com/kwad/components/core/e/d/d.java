package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bw;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private static boolean PE;
    private static final b PF = new b() { // from class: com.kwad.components.core.e.d.d.3
        long PL;

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            if (this.PL != 0) {
                com.kwad.sdk.core.adlog.c.n(getAdTemplate(), System.currentTimeMillis() - this.PL);
            }
            com.kwad.sdk.core.c.b.Ho();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) d.PF);
            setAdTemplate(null);
            this.PL = 0L;
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            this.PL = System.currentTimeMillis();
        }
    };

    public static void az(boolean z) {
        com.kwad.sdk.core.adlog.c.axo = z;
    }

    public static int a(final a.C0333a c0333a, int i) {
        Context context = c0333a.getContext();
        final AdTemplate adTemplate = c0333a.getAdTemplate();
        String strA = a(c0333a, adTemplate);
        if (TextUtils.isEmpty(strA)) {
            return 0;
        }
        final AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        Activity activityEj = m.ej(context);
        if (activityEj != null && com.kwad.sdk.core.response.b.a.T(adInfoEl) && !c0333a.pf()) {
            c0333a.ay(1);
            com.kwad.components.core.e.e.e.a(activityEj, c0333a);
            return 2;
        }
        final String strA2 = a(strA, c0333a, adInfoEl);
        final int i2 = 1;
        return com.kwad.sdk.core.download.a.b.a(context, strA2, new b.a() { // from class: com.kwad.components.core.e.d.d.1
            @Override // com.kwad.sdk.core.download.a.b.a
            public final void onPreStart() {
                com.kwad.sdk.commercial.f.a.f(adTemplate, strA2);
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void onStart() {
                com.kwad.components.core.proxy.launchdialog.e.sc().aF(adTemplate);
                d.PF.setAdTemplate(adTemplate);
                com.kwad.sdk.core.c.b.Ho();
                com.kwad.sdk.core.c.b.a(d.PF);
                com.kwad.sdk.core.adlog.c.axn = d.an(strA2);
                com.kwad.sdk.commercial.f.a.h(adTemplate, strA2);
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void onSuccess() {
                com.kwad.sdk.core.adlog.c.a aVarPq = c0333a.pq();
                if (pV()) {
                    if (aVarPq.Pk == null) {
                        aVarPq.Pk = new a.C0392a();
                    }
                    aVarPq.Pk.axe = true;
                }
                com.kwad.sdk.commercial.f.a.i(adTemplate, strA2);
                com.kwad.sdk.core.adlog.c.a(adTemplate, "", i2, aVarPq);
                d.a(adTemplate, strA2, i2);
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void pU() {
                com.kwad.sdk.commercial.f.a.g(adTemplate, strA2);
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void onError(Throwable th) {
                com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
                if (pV()) {
                    aVar.Pk = new a.C0392a();
                    aVar.Pk.axe = true;
                }
                com.kwad.sdk.core.adlog.c.b(adTemplate, "", i2, aVar);
                com.kwad.sdk.commercial.f.a.d(adTemplate, strA2, bw.s(th));
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final boolean pV() {
                return com.kwad.sdk.core.response.b.a.ck(adInfoEl);
            }
        });
    }

    private static String a(String str, a.C0333a c0333a, AdInfo adInfo) {
        AdTemplate adTemplate = c0333a.getAdTemplate();
        if (com.kwad.sdk.core.response.b.a.bm(adInfo)) {
            str = b(c0333a, adInfo, str);
        }
        if (com.kwad.sdk.core.response.b.a.cR(adInfo)) {
            str = a(c0333a, adInfo, str);
        }
        return ((com.kwad.sdk.core.response.b.a.cJ(adInfo) || com.kwad.sdk.core.response.b.a.cP(adInfo)) && adTemplate.mAdScene != null) ? a(str, c0333a.getContext(), adTemplate.mAdScene) : str;
    }

    private static String a(a.C0333a c0333a, AdTemplate adTemplate) {
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        for (AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo : adInfoEl.adConversionInfo.deeplinkConf) {
            boolean zContains = deeplinkItemInfo.areaConf.contains(Integer.valueOf(c0333a.dZ()));
            boolean zContains2 = deeplinkItemInfo.sceneConf.contains(Integer.valueOf(c0333a.pj()));
            if ((zContains && zContains2) || ((zContains && deeplinkItemInfo.sceneConf.size() == 0) || (zContains2 && deeplinkItemInfo.areaConf.size() == 0))) {
                if (!TextUtils.isEmpty(deeplinkItemInfo.url)) {
                    return deeplinkItemInfo.url + adInfoEl.adConversionInfo.deeplinkExtra;
                }
            }
        }
        return com.kwad.sdk.core.response.b.a.cT(adInfoEl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject an(String str) {
        try {
            return new JSONObject(Uri.parse(str).getQueryParameter("universeClientInfo"));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final AdTemplate adTemplate, final String str, final int i) {
        if (pS()) {
            return;
        }
        aA(true);
        int iFo = com.kwad.sdk.core.config.e.Fo();
        com.kwad.sdk.core.config.e.Fp();
        int iAbs = Math.abs(iFo);
        if (iAbs > 0) {
            bw.a(new Runnable() { // from class: com.kwad.components.core.e.d.d.2
                @Override // java.lang.Runnable
                public final void run() {
                    d.aA(false);
                    com.kwad.sdk.core.c.b.Ho();
                    if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                        return;
                    }
                    com.kwad.sdk.core.adlog.c.c(adTemplate, "", i);
                    com.kwad.sdk.commercial.f.a.j(adTemplate, str);
                }
            }, null, ((long) iAbs) * 1000);
        } else {
            aA(false);
        }
    }

    private static String a(a.C0333a c0333a, AdInfo adInfo, String str) {
        String strCall;
        String strValueOf;
        if (!com.kwad.sdk.core.response.b.a.bj(adInfo)) {
            return str;
        }
        Callable<String> callablePe = c0333a.pe();
        if (callablePe != null) {
            try {
                strCall = callablePe.call();
            } catch (Exception unused) {
                strCall = null;
            }
        } else {
            strCall = null;
        }
        if (TextUtils.isEmpty(strCall)) {
            strCall = c0333a.pd();
        }
        if (TextUtils.isEmpty(strCall)) {
            return (str.contains("__itemId__") || str.contains("__simpleItemId__")) ? com.kwad.sdk.core.response.b.a.cT(adInfo) : str;
        }
        try {
            strValueOf = String.valueOf(com.kwad.components.core.e.b.a.ai(strCall));
        } catch (Throwable unused2) {
            strValueOf = strCall;
        }
        return str.replaceAll("__itemId__", strCall).replaceAll("__simpleItemId__", strValueOf);
    }

    private static boolean pS() {
        return PE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aA(boolean z) {
        PE = z;
    }

    private static String a(String str, Context context, SceneImpl sceneImpl) {
        if (sceneImpl == null) {
            return "";
        }
        int i = 0;
        if (!as.ap(context, "com.smile.gifmaker") && as.ap(context, "com.kuaishou.nebula")) {
            i = 3;
        }
        String backUrl = sceneImpl.getBackUrl();
        return a(str, i, TextUtils.isEmpty(backUrl) ? "" : backUrl);
    }

    private static String a(String str, int i, String str2) {
        return TextUtils.isEmpty(str2) ? str : (i == 0 || i == 3) ? l(str, str2) : str;
    }

    private static String b(a.C0333a c0333a, AdInfo adInfo, String str) {
        long jMax = c0333a.getAdTemplate().getmCurPlayTime();
        if (jMax > 0) {
            jMax = Math.max(jMax - com.kwad.sdk.core.response.b.a.bn(adInfo), 0L);
        }
        return Uri.parse(str).buildUpon().appendQueryParameter("playStartTime", String.valueOf(jMax)).toString();
    }

    private static String l(String str, String str2) {
        Uri.Builder builderAppendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter("returnBack", "liveunion_" + ServiceProvider.getAppId());
        if (TextUtils.isEmpty(str2)) {
            str2 = "0";
        }
        return builderAppendQueryParameter.appendQueryParameter("back_url", str2).toString();
    }
}
