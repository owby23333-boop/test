package com.kwad.components.ad.reward;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    /* synthetic */ e(byte b2) {
        this();
    }

    private e() {
    }

    static class a {
        private static e rA = new e(0);
    }

    public static e gy() {
        return a.rA;
    }

    public final void L(AdTemplate adTemplate) {
        com.kwad.sdk.core.d.c.d("RewardCallbackVerifyHelper", "handleRewardVerify");
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (!TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.bS(adInfoEl))) {
            M(adTemplate);
        } else {
            p.b(adTemplate, adInfoEl);
        }
    }

    private static void M(AdTemplate adTemplate) {
        new b(adTemplate).gA();
    }

    static class b extends com.kwad.sdk.core.network.l<f, BaseResultData> {
        private AdTemplate adTemplate;
        private com.kwad.sdk.core.network.o<f, BaseResultData> rB = new com.kwad.sdk.core.network.o<f, BaseResultData>() { // from class: com.kwad.components.ad.reward.e.b.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(f fVar, BaseResultData baseResultData) {
                super.onSuccess(fVar, baseResultData);
                com.kwad.components.core.p.a.se().g(b.this.adTemplate, 0, "success");
                com.kwad.sdk.core.d.c.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify success");
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(f fVar, int i, String str) {
                super.onError(fVar, i, str);
                com.kwad.components.core.p.a.se().g(b.this.adTemplate, 1, str);
                com.kwad.sdk.core.d.c.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify failed");
            }
        };

        public b(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
        }

        public final void gA() {
            request(this.rB);
        }

        @Override // com.kwad.sdk.core.network.l
        public final BaseResultData parseData(String str) {
            BaseResultData baseResultData = new BaseResultData() { // from class: com.kwad.components.ad.reward.RewardCallbackVerifyHelper$ServerCallbackNetworking$2
            };
            if (!TextUtils.isEmpty(str)) {
                try {
                    baseResultData.parseJson(new JSONObject(str));
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
            return baseResultData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.core.network.a
        /* JADX INFO: renamed from: gB, reason: merged with bridge method [inline-methods] */
        public f createRequest() {
            return new f(this.adTemplate);
        }
    }
}
