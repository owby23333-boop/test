package com.anythink.expressad.foundation.d;

import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements com.anythink.expressad.e.b, Serializable {
    public static final String a = "amount_max";
    public static final String b = "callback_rule";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10340c = "virtual_currency";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f10341d = "amount";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f10342e = "icon";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f10343f = "currency_id";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f10344g = "name";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f10345h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f10346i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f10347j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f10348k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f10349l = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f10350m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f10351n = "Virtual Item";

    private void c(int i2) {
        this.f10348k = i2;
    }

    private int d() {
        return this.f10345h;
    }

    private int e() {
        return this.f10346i;
    }

    private String f() {
        return this.f10347j;
    }

    private String g() {
        return this.f10349l;
    }

    private int h() {
        return this.f10350m;
    }

    public final int a() {
        return this.f10348k;
    }

    public final String b() {
        return this.f10351n;
    }

    private void a(int i2) {
        this.f10345h = i2;
    }

    private void b(int i2) {
        this.f10346i = i2;
    }

    private void c(String str) {
        this.f10349l = str;
    }

    private void d(int i2) {
        this.f10350m = i2;
    }

    public static p a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            p pVar = new p();
            pVar.f10345h = jSONObject.optInt("amount_max", 0);
            pVar.f10346i = jSONObject.optInt("callback_rule", 1);
            pVar.f10347j = jSONObject.optString("virtual_currency", "");
            pVar.f10349l = jSONObject.optString("icon", "");
            pVar.f10350m = jSONObject.optInt("currency_id", 1);
            if (jSONObject.has("amount")) {
                pVar.f10348k = jSONObject.optInt("amount", 1);
            }
            if (jSONObject.has("name")) {
                pVar.f10351n = jSONObject.optString("name", "Virtual Item");
            }
            return pVar;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private void b(String str) {
        this.f10347j = str;
    }

    private void d(String str) {
        this.f10351n = str;
    }

    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("amount_max", this.f10345h);
            jSONObject.put("callback_rule", this.f10346i);
            jSONObject.put("virtual_currency", this.f10347j);
            jSONObject.put("amount", this.f10348k);
            jSONObject.put("icon", this.f10349l);
            jSONObject.put("currency_id", this.f10350m);
            jSONObject.put("name", this.f10351n);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private static p a(JSONObject jSONObject) {
        p pVar = new p();
        pVar.f10345h = jSONObject.optInt("amount_max", 0);
        pVar.f10346i = jSONObject.optInt("callback_rule", 1);
        pVar.f10347j = jSONObject.optString("virtual_currency", "");
        pVar.f10349l = jSONObject.optString("icon", "");
        pVar.f10350m = jSONObject.optInt("currency_id", 1);
        if (jSONObject.has("amount")) {
            pVar.f10348k = jSONObject.optInt("amount", 1);
        }
        if (jSONObject.has("name")) {
            pVar.f10351n = jSONObject.optString("name", "Virtual Item");
        }
        return pVar;
    }
}
