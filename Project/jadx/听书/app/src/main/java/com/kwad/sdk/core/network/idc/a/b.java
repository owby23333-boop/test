package com.kwad.sdk.core.network.idc.a;

import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.aa;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements com.kwad.sdk.core.b {
    private final Map<String, List<String>> aFF = new ConcurrentHashMap();

    private Map<String, List<String>> HL() {
        return this.aFF;
    }

    public final void a(b bVar) {
        this.aFF.clear();
        if (bVar != null) {
            this.aFF.putAll(bVar.HL());
        }
    }

    public final boolean isEmpty() {
        return this.aFF.isEmpty();
    }

    public final Set<String> HM() {
        return this.aFF.keySet();
    }

    public final List<String> eg(String str) {
        Map<String, List<String>> map = this.aFF;
        if (map == null) {
            return Collections.emptyList();
        }
        List<String> list = map.get(str);
        return list == null ? Collections.emptyList() : list;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                map.put(next, aa.h(jSONObject.optJSONArray(next)));
            }
        }
        this.aFF.clear();
        this.aFF.putAll(map);
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        Map<String, List<String>> map = this.aFF;
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            aa.putValue(jSONObject, str, aa.S(map.get(str)));
        }
        return jSONObject;
    }

    public static b eh(String str) {
        b bVar = new b();
        if (str != null && !str.isEmpty()) {
            try {
                bVar.parseJson(new JSONObject(str));
            } catch (JSONException e) {
                c.printStackTraceOnly(e);
            }
        }
        return bVar;
    }
}
