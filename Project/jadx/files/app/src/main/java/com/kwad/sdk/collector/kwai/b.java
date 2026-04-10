package com.kwad.sdk.collector.kwai;

import com.kwad.sdk.c;
import com.kwad.sdk.collector.model.e;
import com.kwad.sdk.core.network.d;
import com.taobao.accs.common.Constants;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends d {
    public b(Collection<e> collection) {
        putBody("collectData", a(collection));
        putBody("collectType", 1);
        putBody(Constants.KEY_SDK_VERSION, "3.3.38");
        putBody("sdkVersionCode", 3033800);
    }

    private static JSONArray a(Collection<e> collection) {
        JSONArray jSONArray = new JSONArray();
        Iterator<e> it = collection.iterator();
        while (it.hasNext()) {
            JSONObject jSONObjectTV = it.next().tV();
            if (jSONObjectTV != null) {
                jSONArray.put(jSONObjectTV);
            }
        }
        return jSONArray;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return c.sC();
    }
}
