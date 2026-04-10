package com.kwad.components.ad.adbit;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.s;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    @NonNull
    public JSONObject bL;

    @NonNull
    public Map<String, String> bM;

    public a(@NonNull JSONObject jSONObject, @NonNull Map<String, String> map) {
        this.bL = jSONObject;
        this.bM = map;
    }

    public final String ad() {
        for (String str : this.bM.keySet()) {
            s.putValue(this.bL, str, this.bM.get(str));
        }
        return this.bL.toString();
    }
}
