package com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u;

import android.content.Context;
import android.util.SparseArray;
import com.bytedance.msdk.adapter.ks.KsDrawLoader;
import com.bytedance.msdk.adapter.ks.base.config.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes4.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KsDrawLoader f2437a;
    private boolean b;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private KsLoadManager.DrawAdListener f2439a;
        private KsDrawLoader b;

        public a(final Context context, KsDrawLoader ksDrawLoader, final MediationAdSlotValueSet mediationAdSlotValueSet, final boolean z) {
            this.b = ksDrawLoader;
            this.f2439a = new KsLoadManager.DrawAdListener() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.g.a.1
                @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
                public void onDrawAdLoad(List<KsDrawAd> list) {
                    if (list != null && list.size() != 0) {
                        ArrayList arrayList = new ArrayList();
                        for (KsDrawAd ksDrawAd : list) {
                            if (ksDrawAd != null) {
                                Function<SparseArray<Object>, Object> gMBridge = a.this.b.getGMBridge();
                                new b(context, a.this.b, gMBridge, ksDrawAd, mediationAdSlotValueSet, z);
                                arrayList.add(gMBridge);
                            }
                        }
                        if (arrayList.size() > 0) {
                            a.this.b.notifyAdSuccess(arrayList);
                            return;
                        }
                    } else if (a.this.b == null) {
                        return;
                    }
                    a.this.b.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "请求成功，但无广告可用");
                }

                @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
                public void onError(int i, String str) {
                    if (a.this.b != null) {
                        a.this.b.notifyAdFailed(i, str);
                    }
                }
            };
        }

        public void a(KsScene ksScene) {
            KsLoadManager loadManager = KsAdSDK.getLoadManager();
            if (loadManager != null) {
                loadManager.loadDrawAd(ksScene, this.f2439a);
                return;
            }
            KsDrawLoader ksDrawLoader = this.b;
            if (ksDrawLoader != null) {
                ksDrawLoader.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "loadManager is null can not load ads");
            }
        }
    }

    public g(KsDrawLoader ksDrawLoader) {
        this.f2437a = ksDrawLoader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        try {
            KsScene.Builder builder = new KsScene.Builder(Long.valueOf(mediationAdSlotValueSet.getADNId()).longValue());
            builder.height(mediationAdSlotValueSet.getHeight());
            builder.width(mediationAdSlotValueSet.getWidth());
            builder.adNum(mediationAdSlotValueSet.getAdCount());
            new a(context, this.f2437a, mediationAdSlotValueSet, this.b).a(builder.build());
        } catch (Exception unused) {
            this.f2437a.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "代码位ID不合法");
        }
    }

    public void a(final Context context, final MediationAdSlotValueSet mediationAdSlotValueSet) {
        boolean zA = o.a(this.f2437a, mediationAdSlotValueSet);
        this.b = zA;
        if (zA) {
            n.a(new Runnable() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.g.1
                @Override // java.lang.Runnable
                public void run() {
                    g.this.b(context.getApplicationContext(), mediationAdSlotValueSet);
                    n.a(getClass().getName(), context.getApplicationContext());
                }
            });
        } else {
            b(context.getApplicationContext(), mediationAdSlotValueSet);
        }
    }
}
