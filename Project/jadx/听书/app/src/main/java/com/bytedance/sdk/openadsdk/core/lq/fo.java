package com.bytedance.sdk.openadsdk.core.lq;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class fo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1253a;
    private final JSONObject dl;
    private final String g;
    private String gc;
    private String m;
    private final Map<String, List<String>> z;

    public fo(String str, String str2, Map<String, List<String>> map, JSONObject jSONObject) {
        this.g = str;
        this.f1253a = str2;
        this.z = map;
        this.dl = jSONObject;
    }

    public void z(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        List<String> list = this.z.get(str);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            this.z.put(str, arrayList);
            return;
        }
        list.add(str2);
    }

    public Map<String, List<String>> z() {
        return this.z;
    }

    public String g() {
        return this.g;
    }

    public void z(String str) {
        this.gc = str;
    }

    public void g(String str) {
        this.m = str;
    }

    public String dl() {
        try {
            String strOptString = this.dl.optString("expandParams");
            String str = "apppackage=" + this.gc + "|appsign=" + this.m;
            if (!TextUtils.isEmpty(strOptString)) {
                str = strOptString + "|" + str;
            }
            this.dl.put("expandParams", str);
        } catch (Exception e) {
            wp.z(e);
        }
        JSONObject jSONObject = this.dl;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public String a() {
        return this.f1253a;
    }
}
