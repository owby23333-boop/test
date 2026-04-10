package com.kwad.components.ad.nativead;

import android.text.TextUtils;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.t.n;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static void loadNativeAd(KsScene ksScene, final KsLoadManager.NativeAdListener nativeAdListener) {
        final SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.c(sceneImplCovert);
        boolean zB = n.tn().b(sceneImplCovert, "loadNativeAd");
        sceneImplCovert.setAdStyle(10000);
        KsAdLoadManager.M().a(new a.C0351a().e(new ImpInfo(sceneImplCovert)).aM(zB).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.nativead.c.1
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void onError(final int i, final String str) {
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.nativead.c.1.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.d("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        nativeAdListener.onError(i, str);
                    }
                });
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void b(AdResultData adResultData) {
                final ArrayList arrayList = new ArrayList();
                List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
                com.kwad.sdk.commercial.d.d.a(sceneImplCovert, adTemplateList.size());
                for (AdTemplate adTemplate : adTemplateList) {
                    if (adTemplate != null) {
                        adTemplate.mAdScene = sceneImplCovert;
                        arrayList.add(new d(adTemplate));
                    }
                }
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.nativead.c.1.2
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        KsAdLoadManager.M().b(arrayList);
                        nativeAdListener.onNativeAdLoad(arrayList);
                    }
                });
                try {
                    for (AdTemplate adTemplate2 : adResultData.getAdTemplateList()) {
                        if (adTemplate2 != null) {
                            com.kwad.sdk.core.response.b.e.el(adTemplate2);
                            try {
                                if (com.kwad.sdk.components.d.f(com.kwad.components.core.o.a.c.a.class) != null) {
                                    com.kwad.sdk.components.d.f(com.kwad.components.core.o.a.c.a.class);
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
            }
        }).sw());
    }

    public static void loadNativeAd(String str, final KsLoadManager.NativeAdListener nativeAdListener) {
        if (n.tn().b(null, "loadNativeAdByJson") && n.tn().to() == 1) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.nativead.c.2
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    com.kwad.sdk.core.d.c.e("KsAdNativeLoadManager", "method parseJson params jsonResult is empty");
                    nativeAdListener.onError(com.kwad.sdk.core.network.e.aEq.errorCode, com.kwad.sdk.core.network.e.aEq.msg);
                }
            });
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            final AdResultData adResultData = new AdResultData();
            adResultData.parseJson(jSONObject);
            if (adResultData.result != 1) {
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.nativead.c.3
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.e("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("%s__%s", Integer.valueOf(adResultData.result), adResultData.errorMsg));
                        nativeAdListener.onError(adResultData.result, adResultData.errorMsg);
                    }
                });
                return;
            }
            if (adResultData.isAdResultDataEmpty()) {
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.nativead.c.4
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        nativeAdListener.onError(com.kwad.sdk.core.network.e.aEq.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aEq.msg : adResultData.testErrorMsg);
                    }
                });
                return;
            }
            final ArrayList arrayList = new ArrayList();
            for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                if (adTemplate != null) {
                    arrayList.add(new d(adTemplate));
                }
            }
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.nativead.c.5
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    nativeAdListener.onNativeAdLoad(arrayList);
                }
            });
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            nativeAdListener.onError(com.kwad.sdk.core.network.e.aEp.errorCode, com.kwad.sdk.core.network.e.aEp.msg);
        }
    }
}
