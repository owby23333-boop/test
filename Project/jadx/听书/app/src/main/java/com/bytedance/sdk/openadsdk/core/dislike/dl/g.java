package com.bytedance.sdk.openadsdk.core.dislike.dl;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.ls.dl.g.m;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f1024a;
    private String dl;
    private String e;
    private final List<m> g = new ArrayList();
    private final String gc;
    private final String m;
    private final int z;

    public g(JSONObject jSONObject, dl dlVar) {
        boolean z = false;
        this.z = jSONObject.optInt("dislike_control", 0);
        this.f1024a = jSONObject.optBoolean("close_on_dislike", false);
        String strZ = dlVar != null ? dlVar.z() : "";
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("filter_words");
        if (jSONArrayOptJSONArray != null) {
            boolean zEquals = false;
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                dl dlVarZ = dl.z(jSONArrayOptJSONArray.optJSONObject(i));
                if (dlVarZ != null && dlVarZ.gc()) {
                    this.g.add(dlVarZ);
                    if (!zEquals) {
                        zEquals = TextUtils.equals(dlVarZ.z(), strZ);
                    }
                }
            }
            z = zEquals;
        }
        if (dlVar != null && !z) {
            this.g.add(dlVar);
        }
        this.gc = jSONObject.optString(MediationConstant.EXTRA_ADID);
        this.m = jSONObject.optString("ext");
    }

    public void z(JSONObject jSONObject) throws JSONException {
        jSONObject.put("dislike_control", this.z);
        jSONObject.put("filter_words", m());
        jSONObject.put("close_on_dislike", gz());
    }

    public List<m> z() {
        return this.g;
    }

    public void z(String str) {
        this.dl = str;
    }

    public String g() {
        return this.dl;
    }

    public String dl() {
        return this.gc;
    }

    public String a() {
        return this.m;
    }

    public boolean gc() {
        return this.z == 1;
    }

    public JSONArray m() {
        JSONObject jSONObjectE;
        JSONArray jSONArray = new JSONArray();
        List<m> list = this.g;
        if (list != null) {
            for (m mVar : list) {
                if ((mVar instanceof dl) && (jSONObjectE = ((dl) mVar).e()) != null) {
                    jSONArray.put(jSONObjectE);
                }
            }
        }
        return jSONArray;
    }

    public void g(String str) {
        this.e = str;
    }

    public String e() {
        return this.e;
    }

    public boolean gz() {
        return this.f1024a;
    }
}
