package com.umeng.commonsdk.vchannel;

import android.content.Context;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Event.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    private String b;
    private String a = "_$unknown";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f20247c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f20248d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f20249e = a.f20246j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, Object> f20250f = null;

    public b(Context context) {
        this.b = UMGlobalContext.getInstance(context).getProcessName(context);
    }

    public String a() {
        return this.a;
    }

    public long b() {
        return this.f20247c;
    }

    public Map<String, Object> c() {
        return this.f20250f;
    }

    public JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.a);
            jSONObject.put("pn", this.b);
            jSONObject.put("ds", this.f20248d);
            jSONObject.put("ts", this.f20247c);
            if (this.f20250f != null && this.f20250f.size() > 0) {
                for (String str : this.f20250f.keySet()) {
                    jSONObject.put(str, this.f20250f.get(str));
                }
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(this.f20249e, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ekv", jSONArray2);
            return jSONObject3;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append("id:" + this.a + ",");
        sb.append("pn:" + this.b + ",");
        sb.append("ts:" + this.f20247c + ",");
        Map<String, Object> map = this.f20250f;
        if (map != null && map.size() > 0) {
            for (String str : this.f20250f.keySet()) {
                Object obj = this.f20250f.get(str);
                sb.append(obj == null ? str + ": null," : str + ": " + obj.toString() + ",");
            }
        }
        sb.append("ds:" + this.f20248d + "]");
        return sb.toString();
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(long j2) {
        this.f20247c = j2;
    }

    public void a(Map<String, Object> map) {
        this.f20250f = map;
    }
}
