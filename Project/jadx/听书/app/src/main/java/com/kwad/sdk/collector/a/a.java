package com.kwad.sdk.collector.a;

import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.h;
import com.kwad.sdk.utils.aa;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends d {
    private C0387a avj;

    public a(List<String> list) {
        C0387a c0387a = new C0387a(list);
        this.avj = c0387a;
        putBody("targetAppInfo", c0387a.toJson());
        putBody("sdkVersion", BuildConfig.VERSION_NAME);
        putBody("sdkVersionCode", BuildConfig.VERSION_CODE);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.AT();
    }

    /* JADX INFO: renamed from: com.kwad.sdk.collector.a.a$a, reason: collision with other inner class name */
    static class C0387a {
        private List<String> avk;

        public C0387a(List<String> list) {
            this.avk = list;
        }

        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "packageName", this.avk);
            return jSONObject;
        }
    }
}
