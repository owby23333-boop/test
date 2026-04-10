package com.tencent.smtt.sdk.a;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    private String a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Integer f18991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f18992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f18993e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Integer f18994f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Integer f18995g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<Integer> f18996h;

    public String a() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.a)) {
                jSONObject2.put("PP", this.a);
            }
            if (!TextUtils.isEmpty(this.b)) {
                jSONObject2.put("PPVN", this.b);
            }
            if (this.f18991c != null) {
                jSONObject2.put("ADRV", this.f18991c);
            }
            if (!TextUtils.isEmpty(this.f18992d)) {
                jSONObject2.put("MODEL", this.f18992d);
            }
            if (!TextUtils.isEmpty(this.f18993e)) {
                jSONObject2.put("NAME", this.f18993e);
            }
            if (this.f18994f != null) {
                jSONObject2.put("SDKVC", this.f18994f);
            }
            if (this.f18995g != null) {
                jSONObject2.put("COMPVC", this.f18995g);
            }
            jSONObject.put("terminal_params", jSONObject2);
            if (this.f18996h != null) {
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < this.f18996h.size(); i2++) {
                    jSONArray.put(this.f18996h.get(i2));
                }
                jSONObject.put("ids", jSONArray);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public void a(Integer num) {
        this.f18991c = num;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(List<Integer> list) {
        this.f18996h = list;
    }

    public void b(Integer num) {
        this.f18994f = num;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(Integer num) {
        this.f18995g = num;
    }

    public void c(String str) {
        this.f18992d = str;
    }

    public void d(String str) {
        this.f18993e = str;
    }
}
