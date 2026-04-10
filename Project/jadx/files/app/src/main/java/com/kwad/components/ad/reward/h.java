package com.kwad.components.ad.reward;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    private volatile boolean il;
    private com.kwad.sdk.core.network.m<i, BaseResultData> im;

    static class a {
        private static h pu = new h(0);
    }

    private h() {
        this.il = false;
    }

    /* synthetic */ h(byte b) {
        this();
    }

    static /* synthetic */ boolean a(h hVar, boolean z2) {
        hVar.il = false;
        return false;
    }

    public static h fQ() {
        return a.pu;
    }

    private void o(final AdTemplate adTemplate) {
        if (this.il) {
            return;
        }
        this.il = true;
        this.im = new com.kwad.sdk.core.network.m<i, BaseResultData>() { // from class: com.kwad.components.ad.reward.h.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* JADX INFO: renamed from: fR, reason: merged with bridge method [inline-methods] */
            public i createRequest() {
                return new i(adTemplate);
            }

            @Override // com.kwad.sdk.core.network.m
            @NonNull
            public final BaseResultData parseData(String str) {
                BaseResultData baseResultData = new BaseResultData() { // from class: com.kwad.components.ad.reward.RewardCallbackVerifyHelper$1$1
                };
                if (!TextUtils.isEmpty(str)) {
                    try {
                        baseResultData.parseJson(new JSONObject(str));
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.printStackTrace(th);
                    }
                }
                return baseResultData;
            }
        };
        this.im.request(new com.kwad.sdk.core.network.p<i, BaseResultData>() { // from class: com.kwad.components.ad.reward.h.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull i iVar, int i2, String str) {
                super.onError(iVar, i2, str);
                h.a(h.this, false);
                com.kwad.components.core.m.a.pr().c(adTemplate, 1, str);
                com.kwad.sdk.core.d.b.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify failed");
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NonNull i iVar, @NonNull BaseResultData baseResultData) {
                super.onSuccess(iVar, baseResultData);
                h.a(h.this, false);
                com.kwad.components.core.m.a.pr().c(adTemplate, 0, "success");
                com.kwad.sdk.core.d.b.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify success");
            }
        });
    }

    public final void n(AdTemplate adTemplate) {
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.bC(adInfoCb))) {
            p.b(adTemplate, adInfoCb);
        } else {
            o(adTemplate);
        }
    }

    public final void release() {
        com.kwad.sdk.core.network.m<i, BaseResultData> mVar = this.im;
        if (mVar != null) {
            mVar.cancel();
        }
    }
}
