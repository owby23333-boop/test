package com.yuewen;

import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class f01 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11011b;
    public String c;
    public int d;

    public f01(int i, int i2, String str, int i3) {
        this.f11010a = i;
        this.f11011b = i2;
        this.c = str;
        this.d = i3;
    }

    public static f01 b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new f01(jSONObject.getInt("delay"), jSONObject.getInt("countdown"), jSONObject.getString("expire"), jSONObject.getInt("coin"));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static List<f01> c(JSONArray jSONArray) {
        LinkedList linkedList = new LinkedList();
        if (jSONArray == null) {
            return linkedList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            linkedList.add(b(jSONArray.optJSONObject(i)));
        }
        return linkedList;
    }

    public int a() {
        return this.f11011b;
    }
}
