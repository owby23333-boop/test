package com.kwad.components.ad.reward;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bp;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class p {
    public static void b(final AdTemplate adTemplate, AdInfo adInfo) {
        final String strBR = com.kwad.sdk.core.response.b.a.bR(adInfo);
        com.kwad.sdk.core.d.c.d("ServerCallbackHandle", "handleRewardVerify callbackUrl: " + strBR);
        if (bp.isNullString(strBR)) {
            return;
        }
        com.kwad.sdk.utils.h.execute(new Runnable() { // from class: com.kwad.components.ad.reward.p.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.kwad.sdk.core.network.c cVarDoGet = com.kwad.sdk.g.AI().doGet(strBR, null);
                    if (cVarDoGet == null) {
                        K("Network Error: url invalid");
                        return;
                    }
                    if (cVarDoGet.code == 200) {
                        a aVar = new a(cVarDoGet.aEk);
                        if (aVar.isValid()) {
                            hy();
                            return;
                        } else {
                            K(aVar.errorMsg);
                            return;
                        }
                    }
                    K("Network Error: " + cVarDoGet.aEk);
                } catch (Throwable th) {
                    K("Request Error: " + th.getMessage());
                }
            }

            private void hy() {
                com.kwad.components.core.p.a.se().g(adTemplate, 0, "success");
            }

            private void K(String str) {
                com.kwad.components.core.p.a.se().g(adTemplate, 1, str);
            }
        });
    }

    static class a {
        private String errorMsg;
        private boolean tq;

        public a(String str) {
            JSONObject jSONObject;
            this.errorMsg = "-";
            try {
                jSONObject = new JSONObject(str);
            } catch (Throwable th) {
                th.printStackTrace();
                this.tq = false;
                this.errorMsg = "数据解析失败";
                jSONObject = null;
            }
            parseJson(jSONObject);
        }

        public final boolean isValid() {
            return this.tq;
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.tq = jSONObject.optBoolean("isValid");
                this.errorMsg = jSONObject.toString();
            }
        }
    }
}
