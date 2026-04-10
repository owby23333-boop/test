package com.bytedance.msdk.core.gz;

import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e extends a {
    private String e;
    private final String fo;
    private final String gz;
    private List<gc> m;
    private z uy;

    private static class z {
        public String dl;
        public String g;
        public String z;

        public z(String str, String str2, String str3) {
            this.z = str;
            this.g = str2;
            this.dl = str3;
        }
    }

    public e(String str, String str2, String str3, String str4, int i, String str5) {
        super(str, str2, str3, str4, i);
        this.gz = "count";
        this.fo = "effective_time";
        this.e = str5;
        if (!TextUtils.isEmpty(str2)) {
            this.uy = new z("freq", TtmlNode.TAG_SPAN, "rule_id");
        } else {
            this.uy = new z("waterfall_show_freq", "waterfall_show_span", "waterfall_show_rule_id");
        }
    }

    public String fo() {
        try {
            JSONArray jSONArray = new JSONArray(this.e);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                jSONObject.put("count", 0);
                jSONObject.put("effective_time", m.z(jSONObject.getLong(this.uy.g)));
            }
            this.e = jSONArray.toString();
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        return this.e;
    }

    public String uy() {
        try {
            JSONArray jSONArray = new JSONArray();
            for (gc gcVar : kb()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(this.uy.z, gcVar.z());
                jSONObject.put(this.uy.g, gcVar.g());
                jSONObject.put(this.uy.dl, gcVar.dl());
                jSONObject.put("count", gcVar.gc());
                jSONObject.put("effective_time", gcVar.a());
                jSONArray.put(jSONObject);
            }
            this.e = jSONArray.toString();
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        return this.e;
    }

    public synchronized List<gc> kb() {
        e eVarUy;
        List<gc> list = this.m;
        if (list != null && list.size() != 0) {
            return this.m;
        }
        this.m = new ArrayList();
        if (this.e == null && (eVarUy = i.z().uy(this.z)) != null) {
            this.e = eVarUy.e;
        }
        if (TextUtils.isEmpty(this.e)) {
            return this.m;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.e);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                gc gcVar = new gc();
                String string = jSONObject.getString(this.uy.dl);
                if (jSONObject != null && !TextUtils.isEmpty(string)) {
                    gcVar.z(jSONObject.optInt(this.uy.z));
                    gcVar.z(jSONObject.optLong(this.uy.g));
                    gcVar.z(string);
                    if (jSONObject.has("count")) {
                        gcVar.g(jSONObject.optInt("count"));
                    }
                    if (jSONObject.has("effective_time")) {
                        gcVar.g(jSONObject.optLong("effective_time"));
                    }
                    this.m.add(gcVar);
                }
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        if (this.m.size() > 0) {
            Collections.sort(this.m, new Comparator<gc>() { // from class: com.bytedance.msdk.core.gz.e.1
                @Override // java.util.Comparator
                /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
                public int compare(gc gcVar2, gc gcVar3) {
                    long jG = gcVar2.g() - gcVar3.g();
                    if (jG == 0) {
                        return 0;
                    }
                    return jG > 0 ? 1 : -1;
                }
            });
        }
        return this.m;
    }

    public void z(String str, int i) {
        for (gc gcVar : kb()) {
            if (TextUtils.equals(gcVar.dl(), str)) {
                gcVar.g(i);
                return;
            }
        }
    }

    public void z(String str, long j) {
        for (gc gcVar : kb()) {
            if (TextUtils.equals(gcVar.dl(), str)) {
                gcVar.g(j);
                return;
            }
        }
    }

    @Override // com.bytedance.msdk.core.gz.a
    public String toString() {
        return "BaseIntervalBean{waterfallId='" + this.z + "', showRulesVersion='" + this.dl + "', timingMode=" + this.gc + "}IntervalFreqctlBean{freqctlRules=" + this.m + ", freqctlRulesJson='" + this.e + "'}";
    }
}
