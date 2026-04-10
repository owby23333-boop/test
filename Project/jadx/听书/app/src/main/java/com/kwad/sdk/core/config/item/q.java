package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class q extends b<a> {
    private String aCr;

    public q() {
        super("sdkPackInfo", null);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("sdkPackInfo");
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        this.aCr = jSONObjectOptJSONObject.toString();
        a aVar = new a();
        aVar.parseJson(jSONObjectOptJSONObject);
        setValue(aVar);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        editor.putString("sdkPackInfo", dz(this.aCr));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        String decodeString = getDecodeString(sharedPreferences.getString("sdkPackInfo", null));
        this.aCr = decodeString;
        try {
            if (TextUtils.isEmpty(decodeString)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(this.aCr);
            a aVar = new a();
            aVar.parseJson(jSONObject);
            setValue(aVar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static final class a implements com.kwad.sdk.core.b {
        public Map<Integer, String> aCs = new HashMap();
        public List<String> aCt = new ArrayList();
        public List<String> aCu = new ArrayList();
        public List<String> aCv = new ArrayList();
        public int aCw;
        private JSONObject aCx;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.aCx = jSONObject;
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("platformInfo");
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    this.aCs.put(Integer.valueOf(next), jSONObjectOptJSONObject.optString(next));
                }
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("keyStacks");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    this.aCt.add(jSONArrayOptJSONArray.optString(i));
                }
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("extendClassNames");
            if (jSONArrayOptJSONArray2 != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    this.aCu.add(jSONArrayOptJSONArray2.optString(i2));
                }
            }
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("keyNames");
            if (jSONArrayOptJSONArray3 != null) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                    this.aCv.add(jSONArrayOptJSONArray3.optString(i3));
                }
            }
            this.aCw = jSONObject.optInt("handleType");
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            return this.aCx;
        }
    }
}
