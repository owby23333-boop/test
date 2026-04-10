package com.anythink.expressad.foundation.d;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements com.anythink.expressad.e.b, Serializable {
    private static final String a = "https://img.toponad.com/sdk/app-permissions.html?key=";
    private static String b = "app_name";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f10134c = "perm_desc";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f10135d = "ori_perm_desc";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f10136e = "ori_perm_all";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f10137f = "pri_url";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f10138g = "upd_time";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f10139h = "app_ver";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f10140i = "dev_name";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f10141j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f10142k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ArrayList<String> f10143l = new ArrayList<>(3);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ArrayList<String> f10144m = new ArrayList<>(3);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ArrayList<String> f10145n = new ArrayList<>(3);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f10146o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f10147p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f10148q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f10149r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f10150s;

    private void b(String str) {
        this.f10141j = str;
    }

    private void c(String str) {
        this.f10146o = str;
    }

    private void d(String str) {
        this.f10142k = str;
    }

    private void e(String str) {
        this.f10147p = str;
    }

    private void f(String str) {
        this.f10148q = str;
    }

    private void g(String str) {
        this.f10149r = str;
    }

    private String h() {
        return this.f10141j;
    }

    private ArrayList<String> i() {
        return this.f10143l;
    }

    private ArrayList<String> j() {
        return this.f10144m;
    }

    private ArrayList<String> k() {
        return this.f10145n;
    }

    public final String a() {
        return this.f10146o;
    }

    public final String toString() {
        return "ApkDisplayInfo{appName='" + this.f10142k + "', permDescJArray=" + this.f10143l + ", permDescOriJArray=" + this.f10144m + ", permDescAll=" + this.f10145n + ", priUrl='" + this.f10147p + "', updateTime='" + this.f10148q + "', appVersion='" + this.f10149r + "', devName='" + this.f10150s + "'}";
    }

    private void a(ArrayList<String> arrayList) {
        this.f10143l = arrayList;
    }

    private void c(ArrayList<String> arrayList) {
        this.f10145n = arrayList;
    }

    private void h(String str) {
        this.f10150s = str;
    }

    public final String b() {
        return this.f10142k;
    }

    public final String d() {
        return this.f10148q;
    }

    public final String e() {
        return this.f10149r;
    }

    public final String f() {
        return this.f10150s;
    }

    public final JSONObject g() {
        try {
            JSONObject jSONObject = new JSONObject(this.f10141j);
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static a a(a aVar) {
        return aVar == null ? new a() : aVar;
    }

    private void b(ArrayList<String> arrayList) {
        this.f10144m = arrayList;
    }

    private static JSONArray d(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            jSONArray.put(arrayList.get(i2));
        }
        return jSONArray;
    }

    public final String c() {
        return this.f10147p;
    }

    public static a a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return a(new JSONObject(str));
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static ArrayList<String> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(jSONArray.optString(i2));
        }
        return arrayList;
    }

    private static a a(JSONObject jSONObject) {
        a aVarA = null;
        if (jSONObject.has(b)) {
            aVarA = a((a) null);
            aVarA.f10142k = jSONObject.optString(b);
        }
        if (jSONObject.has(f10134c)) {
            aVarA = a(aVarA);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(f10134c);
            if (jSONArrayOptJSONArray != null) {
                aVarA.f10143l = a(jSONArrayOptJSONArray);
                ArrayList<String> arrayList = aVarA.f10145n;
                String str = a;
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    try {
                        if (jSONArrayOptJSONArray.get(i2) instanceof String) {
                            str = i2 == 0 ? str + jSONArrayOptJSONArray.optString(i2) : str + "," + jSONArrayOptJSONArray.optString(i2);
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                aVarA.f10146o = str;
                aVarA.f10145n = arrayList;
            }
        }
        if (jSONObject.has(f10135d)) {
            aVarA = a(aVarA);
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(f10135d);
            if (jSONArrayOptJSONArray2 != null) {
                aVarA.f10144m = a(jSONArrayOptJSONArray2);
                ArrayList<String> arrayList2 = aVarA.f10145n;
                for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                    try {
                        Object obj = jSONArrayOptJSONArray2.get(i3);
                        if (obj instanceof String) {
                            arrayList2.add((String) obj);
                        }
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
                aVarA.f10145n = arrayList2;
            }
        }
        if (jSONObject.has(f10137f)) {
            aVarA = a(aVarA);
            aVarA.f10147p = jSONObject.optString(f10137f);
        }
        if (jSONObject.has(f10138g)) {
            aVarA = a(aVarA);
            aVarA.f10148q = jSONObject.optString(f10138g);
        }
        if (jSONObject.has(f10139h)) {
            aVarA = a(aVarA);
            aVarA.f10149r = jSONObject.optString(f10139h);
        }
        if (jSONObject.has(f10140i)) {
            aVarA = a(aVarA);
            aVarA.f10150s = jSONObject.optString(f10140i);
        }
        if (aVarA != null) {
            aVarA.f10141j = jSONObject.toString();
        }
        return aVarA;
    }
}
