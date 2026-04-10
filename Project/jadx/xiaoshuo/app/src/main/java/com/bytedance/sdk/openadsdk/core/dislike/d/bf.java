package com.bytedance.sdk.openadsdk.core.dislike.d;

import com.bytedance.sdk.openadsdk.FilterWord;
import com.yuewen.qe0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class bf {
    private final List<FilterWord> bf = new ArrayList();
    private String d;
    private final int e;
    private final String ga;
    private String p;
    private final boolean tg;
    private final String vn;

    public bf(JSONObject jSONObject) {
        this.e = jSONObject.optInt("dislike_control", 0);
        this.tg = jSONObject.optBoolean("close_on_dislike", false);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("filter_words");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                d dVarE = d.e(jSONArrayOptJSONArray.optJSONObject(i));
                if (dVarE != null && dVarE.isValid()) {
                    this.bf.add(dVarE);
                }
            }
        }
        this.ga = jSONObject.optString(qe0.b.g);
        this.vn = jSONObject.optString("ext");
    }

    public String bf() {
        return this.d;
    }

    public String d() {
        return this.ga;
    }

    public void e(JSONObject jSONObject) throws JSONException {
        jSONObject.put("dislike_control", this.e);
        jSONObject.put("filter_words", vn());
        jSONObject.put("close_on_dislike", v());
    }

    public boolean ga() {
        return this.e == 1;
    }

    public String p() {
        return this.p;
    }

    public String tg() {
        return this.vn;
    }

    public boolean v() {
        return this.tg;
    }

    public JSONArray vn() {
        JSONObject jSONObjectE;
        JSONArray jSONArray = new JSONArray();
        List<FilterWord> list = this.bf;
        if (list != null) {
            for (FilterWord filterWord : list) {
                if ((filterWord instanceof d) && (jSONObjectE = ((d) filterWord).e()) != null) {
                    jSONArray.put(jSONObjectE);
                }
            }
        }
        return jSONArray;
    }

    public void bf(String str) {
        this.p = str;
    }

    public List<FilterWord> e() {
        return this.bf;
    }

    public void e(String str) {
        this.d = str;
    }
}
