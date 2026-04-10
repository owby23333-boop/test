package com.kwad.sdk.collector.kwai;

import com.kwad.sdk.c;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.utils.s;
import com.taobao.accs.common.Constants;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends d {
    private C0430a aaS;

    /* JADX INFO: renamed from: com.kwad.sdk.collector.kwai.a$a, reason: collision with other inner class name */
    static class C0430a {
        private List<String> aaT;

        public C0430a(List<String> list) {
            this.aaT = list;
        }

        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            s.putValue(jSONObject, "packageName", this.aaT);
            return jSONObject;
        }
    }

    public a(List<String> list) {
        this.aaS = new C0430a(list);
        putBody("targetAppInfo", this.aaS.toJson());
        putBody(Constants.KEY_SDK_VERSION, "3.3.38");
        putBody("sdkVersionCode", 3033800);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return c.sB();
    }
}
