package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends b<a> {
    private String adH;

    public static final class a implements com.kwad.sdk.core.b {

        @NonNull
        public Map<Integer, String> adI = new HashMap();

        @NonNull
        public List<String> adJ = new ArrayList();

        @NonNull
        public List<String> adK = new ArrayList();
        public List<String> adL = new ArrayList();
        public int adM;
        private JSONObject adN;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.adN = jSONObject;
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("platformInfo");
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    this.adI.put(Integer.valueOf(next), jSONObjectOptJSONObject.optString(next));
                }
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("keyStacks");
            if (jSONArrayOptJSONArray != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    this.adJ.add(jSONArrayOptJSONArray.optString(i2));
                }
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("extendClassNames");
            if (jSONArrayOptJSONArray2 != null) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                    this.adK.add(jSONArrayOptJSONArray2.optString(i3));
                }
            }
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("keyNames");
            if (jSONArrayOptJSONArray3 != null) {
                for (int i4 = 0; i4 < jSONArrayOptJSONArray3.length(); i4++) {
                    this.adL.add(jSONArrayOptJSONArray3.optString(i4));
                }
            }
            this.adM = jSONObject.optInt("handleType");
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            return this.adN;
        }
    }

    public o() {
        super("sdkPackInfo", null);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        this.adH = b.bn(sharedPreferences.getString("sdkPackInfo", null));
        try {
            if (TextUtils.isEmpty(this.adH)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(this.adH);
            a aVar = new a();
            aVar.parseJson(jSONObject);
            setValue(aVar);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        editor.putString("sdkPackInfo", b.bm(this.adH));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void f(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("sdkPackInfo");
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        this.adH = jSONObjectOptJSONObject.toString();
        a aVar = new a();
        aVar.parseJson(jSONObjectOptJSONObject);
        setValue(aVar);
    }
}
