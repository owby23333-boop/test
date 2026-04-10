package com.kwad.sdk.core.track;

import com.kwad.components.ad.reward.monitor.FraudVerifyCode;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static boolean dK(int i) {
        return i >= 200 && i < 300;
    }

    public static void e(com.kwad.sdk.core.adlog.c.a aVar) {
        AdTemplate adTemplate = aVar.adTemplate;
        AdInfo adInfoEl = e.el(adTemplate);
        int i = aVar.awx;
        List<String> listA = a(adTemplate, i, aVar);
        if (ap.L(listA)) {
            return;
        }
        boolean zDw = com.kwad.sdk.core.response.b.a.dw(adInfoEl);
        boolean zDx = com.kwad.sdk.core.response.b.a.dx(adInfoEl);
        for (String str : listA) {
            com.kwad.sdk.commercial.j.a.o(adTemplate, i, str);
            if (adTemplate.isCheatingFlow()) {
                com.kwad.sdk.commercial.j.a.n(adTemplate, i, str);
                return;
            }
            if (bw.hA(str)) {
                com.kwad.sdk.commercial.j.a.a(adTemplate, i, str, "", FraudVerifyCode.RerwardFraudUnknown, "", 0);
                return;
            }
            HashMap map = null;
            String strA = ai.a(ServiceProvider.getContext(), str, i == 2 ? aVar.mK : null, com.kwad.sdk.core.response.b.a.aB(e.el(adTemplate)));
            ai.f(adTemplate, str, strA);
            AdHttpProxy adHttpProxyAI = g.AI();
            int i2 = adHttpProxyAI instanceof com.kwad.sdk.core.network.c.a ? 2 : 1;
            c.d("AdTrackUtil", "handleTrackUrl useKwaiUA: " + zDw);
            if (zDw) {
                com.kwad.sdk.core.i.c cVarJ = com.kwad.sdk.core.i.a.j(zDw, zDx);
                c.d("AdTrackUtil", "handleTrackUrl uaGetter: " + cVarJ);
                if (cVarJ != null) {
                    map = new HashMap();
                    map.put("User-Agent", cVarJ.JS());
                }
            }
            com.kwad.sdk.core.network.c cVarDoGetWithoutResponse = adHttpProxyAI.doGetWithoutResponse(strA, map, !zDw);
            if (dK(cVarDoGetWithoutResponse.code)) {
                c.d("AdTrackUtil", "trackUrl request success actionType: " + i);
                com.kwad.sdk.commercial.j.a.a(adTemplate, i, str, cVarDoGetWithoutResponse.code, i2);
            } else {
                com.kwad.sdk.commercial.j.a.a(adTemplate, i, str, strA, d.cu(cVarDoGetWithoutResponse.code), cVarDoGetWithoutResponse.aEk, i2);
            }
        }
    }

    private static List<String> a(AdTemplate adTemplate, int i, com.kwad.sdk.core.adlog.c.a aVar) {
        ArrayList arrayList = new ArrayList();
        AdInfo adInfoEl = e.el(adTemplate);
        List<AdInfo.AdTrackInfo> list = adInfoEl.adTrackInfoList;
        if (ap.L(list)) {
            return arrayList;
        }
        List<String> listA = a(i, aVar, arrayList, adInfoEl, list);
        if (listA != null) {
            return listA;
        }
        Iterator<AdInfo.AdTrackInfo> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdInfo.AdTrackInfo next = it.next();
            if (next.type == i && next.urls != null) {
                arrayList.addAll(next.urls);
                break;
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
    
        r4.addAll(r6.urls);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<java.lang.String> a(int r2, com.kwad.sdk.core.adlog.c.a r3, java.util.List<java.lang.String> r4, com.kwad.sdk.core.response.model.AdInfo r5, java.util.List<com.kwad.sdk.core.response.model.AdInfo.AdTrackInfo> r6) {
        /*
            r0 = 402(0x192, float:5.63E-43)
            if (r2 != r0) goto L51
            boolean r2 = com.kwad.sdk.core.response.b.a.bo(r5)
            if (r2 == 0) goto L51
            java.lang.String r2 = r3.Pj     // Catch: java.lang.Throwable -> L50
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L50
            if (r2 != 0) goto L20
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L50
            java.lang.String r3 = r3.Pj     // Catch: java.lang.Throwable -> L50
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L50
            java.lang.String r3 = "photoPlaySecond"
            int r2 = r2.optInt(r3)     // Catch: java.lang.Throwable -> L50
            goto L22
        L20:
            int r2 = r3.axJ     // Catch: java.lang.Throwable -> L50
        L22:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L50
            com.kwad.sdk.core.response.model.AdInfo$AdBaseInfo r5 = r5.adBaseInfo     // Catch: java.lang.Throwable -> L50
            java.lang.String r5 = r5.videoPlayedNSConfig     // Catch: java.lang.Throwable -> L50
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L50
            java.util.Iterator r5 = r6.iterator()     // Catch: java.lang.Throwable -> L50
        L2f:
            boolean r6 = r5.hasNext()     // Catch: java.lang.Throwable -> L50
            if (r6 == 0) goto L50
            java.lang.Object r6 = r5.next()     // Catch: java.lang.Throwable -> L50
            com.kwad.sdk.core.response.model.AdInfo$AdTrackInfo r6 = (com.kwad.sdk.core.response.model.AdInfo.AdTrackInfo) r6     // Catch: java.lang.Throwable -> L50
            int r0 = r6.type     // Catch: java.lang.Throwable -> L50
            java.lang.String r1 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L50
            int r1 = r3.optInt(r1)     // Catch: java.lang.Throwable -> L50
            if (r0 != r1) goto L2f
            java.util.List<java.lang.String> r0 = r6.urls     // Catch: java.lang.Throwable -> L50
            if (r0 == 0) goto L2f
            java.util.List<java.lang.String> r2 = r6.urls     // Catch: java.lang.Throwable -> L50
            r4.addAll(r2)     // Catch: java.lang.Throwable -> L50
        L50:
            return r4
        L51:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.track.a.a(int, com.kwad.sdk.core.adlog.c.a, java.util.List, com.kwad.sdk.core.response.model.AdInfo, java.util.List):java.util.List");
    }
}
