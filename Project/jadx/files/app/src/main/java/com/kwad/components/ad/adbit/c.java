package com.kwad.components.ad.adbit;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.n.kwai.a;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    private static <T extends com.kwad.components.core.n.a> T a(com.kwad.sdk.d.c<T> cVar) {
        return cVar.get();
    }

    @Nullable
    private static AdTemplate a(AdBitResultData adBitResultData, long j2) {
        for (AdTemplate adTemplate : adBitResultData.getAdTemplateList()) {
            if (adTemplate != null && j2 == d.ck(adTemplate)) {
                return adTemplate;
            }
        }
        return null;
    }

    public static String a(SceneImpl sceneImpl) {
        SceneImpl.covert(sceneImpl);
        final com.kwad.components.core.n.kwai.a aVarPz = new a.C0403a().e(new com.kwad.components.core.n.kwai.b(sceneImpl)).a(new com.kwad.components.core.n.c()).pz();
        b bVar = (b) a(new com.kwad.sdk.d.c<b>() { // from class: com.kwad.components.ad.adbit.c.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.c
            /* JADX INFO: renamed from: ae, reason: merged with bridge method [inline-methods] */
            public b get() {
                return new b(aVarPz);
            }
        });
        return new a(bVar.getBody(), bVar.getHeader()).ad();
    }

    private static List<String> a(AdBitResultData adBitResultData) {
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0 && adBid.creativeId > 0) {
                arrayList.add(adBid.materialId);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<AdTemplate> a(AdBitResultData adBitResultData, AdBitResultData adBitResultData2) {
        AdTemplate adTemplateA;
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0) {
                long j2 = adBid.creativeId;
                if (j2 > 0 && (adTemplateA = a(adBitResultData2, j2)) != null) {
                    adTemplateA.mBidEcpm = adBid.bidEcpm;
                    arrayList.add(adTemplateA);
                }
            }
        }
        return arrayList;
    }

    private static void a(String str, @NonNull com.kwad.components.core.n.kwai.a aVar) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            AdBitResultData adBitResultData = new AdBitResultData(aVar.Kj.Ot);
            adBitResultData.parseJson(jSONObject);
            List<String> listA = a(adBitResultData);
            if (listA.isEmpty()) {
                com.kwad.components.core.n.kwai.a.a(aVar, f.afS.errorCode, f.afS.msg, false);
            } else {
                a(listA, adBitResultData, aVar);
            }
        } catch (Exception e2) {
            f fVar = f.afR;
            com.kwad.components.core.n.kwai.a.a(aVar, fVar.errorCode, fVar.msg, false);
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }

    private static void a(final List<String> list, final AdBitResultData adBitResultData, final com.kwad.components.core.n.kwai.a aVar) {
        new m<com.kwad.components.ad.kwai.b, AdBitResultData>() { // from class: com.kwad.components.ad.adbit.c.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* JADX INFO: renamed from: ag, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.ad.kwai.b createRequest() {
                return new com.kwad.components.ad.kwai.b(adBitResultData.adxId, list);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.m
            @NonNull
            /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
            public AdBitResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdBitResultData adBitResultData2 = new AdBitResultData(aVar.Kj.Ot);
                adBitResultData2.parseJson(jSONObject);
                return adBitResultData2;
            }
        }.request(new p<com.kwad.components.ad.kwai.b, AdBitResultData>() { // from class: com.kwad.components.ad.adbit.c.5
            private void b(int i2, String str) {
                com.kwad.components.core.n.kwai.a.a(aVar, i2, str, false);
            }

            private void c(@NonNull AdBitResultData adBitResultData2) {
                adBitResultData2.setAdTemplateList(c.a(adBitResultData, adBitResultData2));
                if (adBitResultData2.isAdResultDataEmpty()) {
                    com.kwad.components.core.n.kwai.a aVar2 = aVar;
                    f fVar = f.afS;
                    com.kwad.components.core.n.kwai.a.a(aVar2, fVar.errorCode, fVar.msg, false);
                    return;
                }
                AdTemplate adTemplate = adBitResultData2.getAdTemplateList().get(0);
                int i2 = aVar.Kj.Ot.adStyle;
                if (i2 == 10000 || i2 == d.bV(adTemplate)) {
                    com.kwad.components.core.n.kwai.a.a(aVar, adBitResultData2, false);
                    return;
                }
                com.kwad.components.core.n.kwai.a aVar3 = aVar;
                f fVar2 = f.afW;
                com.kwad.components.core.n.kwai.a.a(aVar3, fVar2.errorCode, fVar2.msg, false);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onError(@NonNull g gVar, int i2, String str) {
                b(i2, str);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(@NonNull g gVar, @NonNull BaseResultData baseResultData) {
                c((AdBitResultData) baseResultData);
            }
        });
    }

    public static List<AdTemplate> b(AdBitResultData adBitResultData) {
        AdTemplate adTemplateA;
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0) {
                long j2 = adBid.creativeId;
                if (j2 > 0 && (adTemplateA = a(adBitResultData, j2)) != null) {
                    adTemplateA.mBidEcpm = adBid.bidEcpm;
                    arrayList.add(adTemplateA);
                }
            }
        }
        return arrayList;
    }

    public static boolean b(@NonNull final com.kwad.components.core.n.kwai.a aVar) {
        String bidResponseV2 = aVar.Kj.Ot.getBidResponseV2();
        if (!TextUtils.isEmpty(bidResponseV2)) {
            a(bidResponseV2, aVar);
            return true;
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        final String bidResponse = aVar.Kj.Ot.getBidResponse();
        if (TextUtils.isEmpty(bidResponse)) {
            return false;
        }
        com.kwad.sdk.core.threads.b.yc().submit(new Runnable() { // from class: com.kwad.components.ad.adbit.c.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    JSONObject jSONObject = new JSONObject(bidResponse);
                    AdBitResultData adBitResultData = new AdBitResultData(aVar.Kj.Ot);
                    adBitResultData.parseJson(jSONObject);
                    adBitResultData.setAdTemplateList(c.b(adBitResultData));
                    if (adBitResultData.isAdResultDataEmpty()) {
                        com.kwad.components.core.n.kwai.a.a(aVar, f.afS.errorCode, f.afS.msg, true);
                        return;
                    }
                    AdTemplate adTemplate = adBitResultData.getAdTemplateList().get(0);
                    int adStyle = aVar.Kj.Ot.getAdStyle();
                    if (adStyle == 10000 || adStyle == d.bV(adTemplate)) {
                        com.kwad.components.core.n.kwai.a.a(aVar, adBitResultData, true);
                    } else {
                        com.kwad.components.core.n.kwai.a.a(aVar, f.afW.errorCode, f.afW.msg, true);
                    }
                } catch (Exception e2) {
                    com.kwad.components.core.n.kwai.a aVar2 = aVar;
                    f fVar = f.afR;
                    com.kwad.components.core.n.kwai.a.a(aVar2, fVar.errorCode, fVar.msg, true);
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                }
            }
        });
        return true;
    }

    public static String getBidRequestTokenV2(KsScene ksScene) {
        final com.kwad.components.core.n.kwai.a aVarPz = new a.C0403a().e(new com.kwad.components.core.n.kwai.b(SceneImpl.covert(ksScene))).a(new com.kwad.components.core.n.c()).pz();
        com.kwad.components.ad.kwai.a aVar = (com.kwad.components.ad.kwai.a) a(new com.kwad.sdk.d.c<com.kwad.components.ad.kwai.a>() { // from class: com.kwad.components.ad.adbit.c.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.c
            /* JADX INFO: renamed from: af, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.ad.kwai.a get() {
                return new com.kwad.components.ad.kwai.a(aVarPz);
            }
        });
        return new a(aVar.getBody(), aVar.getHeader()).ad();
    }
}
