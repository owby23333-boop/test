package com.kwad.components.ad.e;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.n.kwai.a;
import com.kwad.components.core.r.n;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bh;
import com.kwai.adclient.logger.model.BusinessType;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static void loadNativeAd(KsScene ksScene, @NonNull final KsLoadManager.NativeAdListener nativeAdListener) {
        final SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        boolean zA = n.qi().a(sceneImplCovert, "loadNativeAd");
        sceneImplCovert.setAdStyle(10000);
        KsAdLoadManager.ac();
        KsAdLoadManager.a(new a.C0403a().e(new com.kwad.components.core.n.kwai.b(sceneImplCovert)).aE(zA).a(new com.kwad.components.core.n.c() { // from class: com.kwad.components.ad.e.c.1
            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.h
            public final void a(@NonNull AdResultData adResultData) {
                final ArrayList arrayList = new ArrayList();
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_NATIVE, "dataReady").report();
                for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                    if (adTemplate != null) {
                        adTemplate.mAdScene = sceneImplCovert;
                        arrayList.add(new d(adTemplate));
                    }
                }
                bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.e.c.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        KsAdLoadManager.ac().b(arrayList);
                        nativeAdListener.onNativeAdLoad(arrayList);
                    }
                });
            }

            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.h
            public final void onError(final int i2, final String str) {
                bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.e.c.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.d("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        nativeAdListener.onError(i2, str);
                    }
                });
            }
        }).pz());
    }

    public static void loadNativeAd(String str, @NonNull final KsLoadManager.NativeAdListener nativeAdListener) {
        if (n.qi().a((SceneImpl) null, "loadNativeAdByJson") && n.qi().qj() == 1) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.e.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.b.e("KsAdNativeLoadManager", "method parseJson params jsonResult is empty");
                    KsLoadManager.NativeAdListener nativeAdListener2 = nativeAdListener;
                    com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.afS;
                    nativeAdListener2.onError(fVar.errorCode, fVar.msg);
                }
            });
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            final AdResultData adResultData = new AdResultData();
            adResultData.parseJson(jSONObject);
            if (adResultData.result != 1) {
                bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.e.c.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.e("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("%s__%s", Integer.valueOf(adResultData.result), adResultData.errorMsg));
                        KsLoadManager.NativeAdListener nativeAdListener2 = nativeAdListener;
                        AdResultData adResultData2 = adResultData;
                        nativeAdListener2.onError(adResultData2.result, adResultData2.errorMsg);
                    }
                });
                return;
            }
            if (adResultData.isAdResultDataEmpty()) {
                bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.e.c.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        KsLoadManager.NativeAdListener nativeAdListener2 = nativeAdListener;
                        com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.afS;
                        nativeAdListener2.onError(fVar.errorCode, fVar.msg);
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
            bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.e.c.5
                @Override // java.lang.Runnable
                public final void run() {
                    nativeAdListener.onNativeAdLoad(arrayList);
                }
            });
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.afR;
            nativeAdListener.onError(fVar.errorCode, fVar.msg);
        }
    }
}
