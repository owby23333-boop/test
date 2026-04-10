package com.yuewen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class z30 implements Cloneable {
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f20679b;
    public long c;
    public boolean d;
    public boolean e;
    public int f;
    public long g;

    public z30(int i2, String str) {
        this.f20678a = i2;
        this.f20679b = str;
        this.c = 0L;
        this.d = false;
        this.e = false;
        this.f = 0;
        this.g = 0L;
    }

    public static JSONArray b(List<z30> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<z30> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().f());
        }
        return jSONArray;
    }

    public static ArrayList<z30> c(int i2, JSONArray jSONArray) {
        ArrayList<z30> arrayList = new ArrayList<>(jSONArray.length());
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                arrayList.add(new z30(i2, jSONArray.getJSONObject(i3)));
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }

    public static ArrayList<z30> d(JSONArray jSONArray) {
        ArrayList<z30> arrayList = new ArrayList<>(jSONArray.length());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                arrayList.add(new z30(jSONArray.getJSONObject(i2)));
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public z30 clone() {
        try {
            return (z30) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public final void e(JSONObject jSONObject) {
        this.f20679b = jSONObject.optString("book_id");
        this.c = jSONObject.optLong("client_read_time");
        this.d = jSONObject.optBoolean("is_deleted", false);
        this.e = jSONObject.optBoolean("is_local_dirty", this.e);
        this.f = jSONObject.optInt("local_operation_type", 0);
        this.g = jSONObject.optLong("local_operation_time");
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("book_source", this.f20678a);
            jSONObject.put("book_id", this.f20679b);
            jSONObject.put("client_read_time", this.c);
            jSONObject.put("is_deleted", this.d);
            jSONObject.put("is_local_dirty", this.e);
            jSONObject.put("local_operation_type", this.f);
            jSONObject.put("local_operation_time", this.g);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public z30(JSONObject jSONObject) {
        this.f20678a = jSONObject.optInt("book_source");
        e(jSONObject);
    }

    public z30(int i2, JSONObject jSONObject) {
        this.f20678a = i2;
        e(jSONObject);
    }
}
