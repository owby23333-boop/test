package com.kwad.sdk.core.network.idc.kwai;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.utils.s;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements b {
    private final Map<String, List<String>> agV = new ConcurrentHashMap();

    public static a bT(String str) {
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
        return aVar;
    }

    @NonNull
    private Map<String, List<String>> wB() {
        return this.agV;
    }

    public final void b(a aVar) {
        this.agV.clear();
        if (aVar != null) {
            this.agV.putAll(aVar.wB());
        }
    }

    @NonNull
    public final List<String> bS(String str) {
        List<String> list = this.agV.get(str);
        return list == null ? Collections.emptyList() : list;
    }

    public final boolean isEmpty() {
        return this.agV.isEmpty();
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                map.put(next, s.f(jSONObject.optJSONArray(next)));
            }
        }
        this.agV.clear();
        this.agV.putAll(map);
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        Map<String, List<String>> map = this.agV;
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            s.putValue(jSONObject, str, s.E(map.get(str)));
        }
        return jSONObject;
    }

    @NonNull
    public final Set<String> wC() {
        return this.agV.keySet();
    }
}
