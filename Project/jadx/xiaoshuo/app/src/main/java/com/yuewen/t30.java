package com.yuewen;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class t30 implements Cloneable {
    public static final int o = 0;
    public static final int p = 1;
    public static final int q = 0;
    public static final int r = 1;
    public static final int s = 2;
    public static final int t = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f17849b;
    public String c;
    public String d;
    public long e;
    public long f;
    public int g;
    public boolean h;
    public int i;
    public long j;
    public String k;
    public String l;
    public String m;
    public int n;

    public t30(int i, String str, String str2) {
        this(i, str, str2, null);
    }

    public static JSONArray b(List<t30> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<t30> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().g());
        }
        return jSONArray;
    }

    public static ArrayList<t30> c(int i, JSONArray jSONArray) {
        ArrayList<t30> arrayList = new ArrayList<>(jSONArray.length());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                arrayList.add(new t30(i, jSONArray.getJSONObject(i2)));
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }

    public static ArrayList<t30> d(JSONArray jSONArray) {
        ArrayList<t30> arrayList = new ArrayList<>(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(new t30(jSONArray.getJSONObject(i)));
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public t30 clone() {
        try {
            return (t30) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public final void e(JSONObject jSONObject) {
        this.f17849b = jSONObject.optString("book_id");
        this.c = jSONObject.optString(en2.d);
        this.d = jSONObject.optString(com.xiaomi.onetrack.api.g.F);
        this.e = jSONObject.optLong("server_change_time");
        this.f = jSONObject.optLong("client_change_time");
        this.g = jSONObject.optInt("status");
        this.h = jSONObject.optBoolean("is_local_dirty", false);
        this.i = jSONObject.optInt("local_operation_type", 0);
        this.j = jSONObject.optLong("local_operation_time");
        if (jSONObject.isNull("cover")) {
            this.k = "";
        } else {
            this.k = jSONObject.optString("cover");
        }
        if (jSONObject.isNull("title")) {
            this.l = "";
        } else {
            this.l = jSONObject.optString("title");
        }
        if (jSONObject.isNull("revision")) {
            this.m = "";
        } else {
            this.m = jSONObject.optString("revision");
        }
        this.n = jSONObject.optInt("book_level");
    }

    public boolean f() {
        return this.g == 1;
    }

    public JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("book_source", this.f17848a);
            jSONObject.put("book_id", this.f17849b);
            jSONObject.put(en2.d, this.c);
            if (!TextUtils.isEmpty(this.d)) {
                jSONObject.put(com.xiaomi.onetrack.api.g.F, this.d);
            }
            jSONObject.put("server_change_time", this.e);
            jSONObject.put("client_change_time", this.f);
            jSONObject.put("status", this.g);
            jSONObject.put("is_local_dirty", this.h);
            jSONObject.put("local_operation_type", this.i);
            jSONObject.put("local_operation_time", this.j);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @NotNull
    public String toString() {
        return "id:" + this.f17849b + ",status:" + this.g + ",cloudTime:" + this.f;
    }

    public t30(int i, String str, String str2, String str3) {
        this.k = "";
        this.l = "";
        this.m = "";
        this.f17848a = i;
        this.f17849b = str;
        this.c = str2;
        this.e = 0L;
        this.f = 0L;
        this.g = 0;
        this.h = false;
        this.i = 0;
        this.j = 0L;
        this.d = str3;
    }

    public t30(int i, JSONObject jSONObject) {
        this.k = "";
        this.l = "";
        this.m = "";
        this.f17848a = i;
        e(jSONObject);
    }

    public t30(JSONObject jSONObject) {
        this.k = "";
        this.l = "";
        this.m = "";
        this.f17848a = jSONObject.optInt("book_source");
        e(jSONObject);
    }
}
