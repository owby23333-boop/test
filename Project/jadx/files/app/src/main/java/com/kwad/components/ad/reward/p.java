package com.kwad.components.ad.reward;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ba;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class p {

    static class a {
        private String errorMsg;
        private boolean qX;

        public a(String str) {
            JSONObject jSONObject;
            this.errorMsg = "-";
            try {
                jSONObject = new JSONObject(str);
            } catch (Throwable th) {
                th.printStackTrace();
                this.qX = false;
                this.errorMsg = "数据解析失败";
                jSONObject = null;
            }
            parseJson(jSONObject);
        }

        private void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject != null) {
                this.qX = jSONObject.optBoolean("isValid");
                this.errorMsg = jSONObject.toString();
            }
        }

        public final boolean isValid() {
            return this.qX;
        }
    }

    public static void b(final AdTemplate adTemplate, AdInfo adInfo) {
        final String strBB = com.kwad.sdk.core.response.a.a.bB(adInfo);
        com.kwad.sdk.core.d.b.d("ServerCallbackHandle", "handleRewardVerify callbackUrl: " + strBB);
        if (ba.isNullString(strBB)) {
            return;
        }
        com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.ad.reward.p.1
            private void R(String str) {
                com.kwad.components.core.m.a.pr().c(adTemplate, 1, str);
            }

            private void gM() {
                com.kwad.components.core.m.a.pr().c(adTemplate, 0, "success");
            }

            @Override // java.lang.Runnable
            public final void run() {
                String str;
                try {
                    com.kwad.sdk.core.network.c cVarDoGet = com.kwad.sdk.b.sq().doGet(strBB, null);
                    if (cVarDoGet == null) {
                        str = "Network Error: url invalid";
                    } else if (cVarDoGet.code != 200) {
                        R("Network Error: " + cVarDoGet.afK);
                        return;
                    } else {
                        a aVar = new a(cVarDoGet.afK);
                        if (aVar.isValid()) {
                            gM();
                            return;
                        }
                        str = aVar.errorMsg;
                    }
                    R(str);
                } catch (Throwable th) {
                    R("Request Error: " + th.getMessage());
                }
            }
        });
    }
}
