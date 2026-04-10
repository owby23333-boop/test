package com.kwad.sdk.i;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
final class e implements com.kwad.sdk.i.b {
    public int aSC;
    public b aSD;
    public a aSE;
    public double avY;

    @Override // com.kwad.sdk.i.b
    public final JSONObject toJson() {
        return null;
    }

    e() {
    }

    public final void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.avY = jSONObject.optDouble("ratio");
        this.aSC = jSONObject.optInt("kcType", 1);
        b bVar = new b();
        this.aSD = bVar;
        bVar.parseJson(jSONObject.optJSONObject("scopeConfig"));
        a aVar = new a();
        this.aSE = aVar;
        aVar.parseJson(jSONObject.optJSONObject("logConfig"));
    }

    public static class b implements com.kwad.sdk.i.b {
        public static int OK = 1;
        public static int aSI = -1;
        public static int aSJ;
        public List<String> aOb;
        public List<String> aOc;
        public List<String> aSK;
        public int aSL = aSI;

        @Override // com.kwad.sdk.i.b
        public final JSONObject toJson() {
            return null;
        }

        public final void bK(boolean z) {
            this.aSL = z ? OK : aSJ;
        }

        public final boolean MX() {
            return this.aSL == OK;
        }

        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.aOb = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("appIdList");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    this.aOb.add(jSONArrayOptJSONArray.optString(i));
                }
            }
            this.aOc = new ArrayList();
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("sdkVersionList");
            if (jSONArrayOptJSONArray2 != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    this.aOc.add(jSONArrayOptJSONArray2.optString(i2));
                }
            }
            this.aSK = new ArrayList();
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("deviceIdList");
            if (jSONArrayOptJSONArray3 != null) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                    this.aSK.add(jSONArrayOptJSONArray3.optString(i3));
                }
            }
        }
    }

    public static class a implements com.kwad.sdk.i.b {
        public List<String> aSF;
        public List<String> aSG;
        public List<String> aSH;

        @Override // com.kwad.sdk.i.b
        public final JSONObject toJson() {
            return null;
        }

        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.aSF = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("levelList");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    this.aSF.add(jSONArrayOptJSONArray.optString(i));
                }
            }
            this.aSG = new ArrayList();
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("tagList");
            if (jSONArrayOptJSONArray2 != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    this.aSG.add(jSONArrayOptJSONArray2.optString(i2));
                }
            }
            this.aSH = new ArrayList();
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("keywordList");
            if (jSONArrayOptJSONArray3 != null) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                    this.aSH.add(jSONArrayOptJSONArray3.optString(i3));
                }
            }
        }
    }
}
