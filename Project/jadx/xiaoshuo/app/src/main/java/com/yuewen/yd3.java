package com.yuewen;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class yd3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f20324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f20325b;
    public int c;

    public yd3() {
    }

    public static yd3 a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        yd3 yd3Var = new yd3();
        try {
            yd3Var.f20324a = jSONObject.optString("title");
            yd3Var.f20325b = jSONObject.optString("source_id");
            yd3Var.c = jSONObject.optInt("source");
            return yd3Var;
        } catch (Exception unused) {
            return null;
        }
    }

    public static List<yd3> b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(a(jSONArray.getJSONObject(i)));
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    public int c() {
        return this.c;
    }

    public String d() {
        return this.f20325b;
    }

    public String e() {
        return this.f20324a;
    }

    public yd3(String str, String str2, int i) {
        this.f20324a = str;
        this.f20325b = str2;
        this.c = i;
    }
}
