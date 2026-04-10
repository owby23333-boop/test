package com.bytedance.sdk.openadsdk.core.dislike.dl;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.ls.dl.g.m;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<m> f1023a;
    private boolean dl;
    private String g;
    private String z;

    public dl(String str, String str2) {
        super(null);
        this.z = str;
        this.g = str2;
    }

    public dl() {
        super(null);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.m
    public String z() {
        return this.z;
    }

    public void z(String str) {
        this.z = str;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.m
    public String g() {
        return this.g;
    }

    public void g(String str) {
        this.g = str;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.m
    public boolean dl() {
        return this.dl;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.m
    public void z(boolean z) {
        this.dl = z;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.m
    public List<m> a() {
        return this.f1023a;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.m
    public void z(m mVar) {
        if (mVar == null) {
            return;
        }
        if (this.f1023a == null) {
            this.f1023a = new ArrayList();
        }
        this.f1023a.add(mVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.m
    public boolean gc() {
        return (TextUtils.isEmpty(this.z) || TextUtils.isEmpty(this.g)) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.m
    public boolean m() {
        List<m> list = this.f1023a;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public static dl z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            dl dlVar = new dl();
            dlVar.z(jSONObject.optString("id"));
            dlVar.g(jSONObject.optString("name"));
            dlVar.z(jSONObject.optBoolean("is_selected"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("options");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    dl dlVarZ = z(jSONArrayOptJSONArray.optJSONObject(i));
                    if (dlVarZ != null && dlVarZ.gc()) {
                        dlVar.z(dlVarZ);
                    }
                }
            }
            return dlVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONObject e() {
        try {
            if (!gc()) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", z());
            jSONObject.put("name", g());
            jSONObject.put("is_selected", dl());
            if (m()) {
                JSONArray jSONArray = new JSONArray();
                for (m mVar : a()) {
                    if (mVar instanceof dl) {
                        jSONArray.put(((dl) mVar).e());
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
