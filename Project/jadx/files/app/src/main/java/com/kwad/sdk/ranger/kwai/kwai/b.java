package com.kwad.sdk.ranger.kwai.kwai;

import com.kwad.sdk.utils.s;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b extends com.kwad.sdk.core.response.kwai.a {
    public int alY;
    public List<a> axE;

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        for (a aVar : this.axE) {
            s.putValue(jSONObject, aVar.key, aVar.value);
        }
        s.putValue(jSONObject, "func_ratio_count", this.alY);
        JSONObject jSONObject2 = new JSONObject();
        s.putValue(jSONObject2, "ranger", jSONObject);
        return jSONObject2;
    }
}
