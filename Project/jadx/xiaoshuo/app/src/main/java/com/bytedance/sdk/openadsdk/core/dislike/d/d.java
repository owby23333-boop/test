package com.bytedance.sdk.openadsdk.core.dislike.d;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.FilterWord;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class d implements FilterWord {
    private String bf;
    private boolean d;
    private String e;
    private List<FilterWord> tg;

    public d(String str, String str2) {
        this.e = str;
        this.bf = str2;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public void addOption(FilterWord filterWord) {
        if (filterWord == null) {
            return;
        }
        if (this.tg == null) {
            this.tg = new ArrayList();
        }
        this.tg.add(filterWord);
    }

    public void bf(String str) {
        this.bf = str;
    }

    public void e(String str) {
        this.e = str;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public String getId() {
        return this.e;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean getIsSelected() {
        return this.d;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public String getName() {
        return this.bf;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public List<FilterWord> getOptions() {
        return this.tg;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean hasSecondOptions() {
        List<FilterWord> list = this.tg;
        return (list == null || list.isEmpty()) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean isValid() {
        return (TextUtils.isEmpty(this.e) || TextUtils.isEmpty(this.bf)) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public void setIsSelected(boolean z) {
        this.d = z;
    }

    public static d e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            d dVar = new d();
            dVar.e(jSONObject.optString("id"));
            dVar.bf(jSONObject.optString("name"));
            dVar.setIsSelected(jSONObject.optBoolean("is_selected"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("options");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    d dVarE = e(jSONArrayOptJSONArray.optJSONObject(i));
                    if (dVarE != null && dVarE.isValid()) {
                        dVar.addOption(dVarE);
                    }
                }
            }
            return dVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public d() {
    }

    public JSONObject e() {
        try {
            if (!isValid()) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", getId());
            jSONObject.put("name", getName());
            jSONObject.put("is_selected", getIsSelected());
            if (hasSecondOptions()) {
                JSONArray jSONArray = new JSONArray();
                for (FilterWord filterWord : getOptions()) {
                    if (filterWord instanceof d) {
                        jSONArray.put(((d) filterWord).e());
                    }
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("options", jSONArray);
                }
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}
