package com.yuewen;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20662b;
    public final String c;
    public float d;

    public z0(int i, int i2, String str, float f) {
        this.f20661a = i;
        this.f20662b = i2;
        this.c = str;
        this.d = Math.max(0.0f, Math.min(f, 100.0f));
    }

    public static boolean a(z0 z0Var, z0 z0Var2) {
        if (z0Var == z0Var2) {
            return true;
        }
        if (z0Var == null || z0Var2 == null) {
            return false;
        }
        return TextUtils.equals(z0Var.c, z0Var2.c) && z0Var.f20661a == z0Var2.f20661a && z0Var.f20662b == z0Var2.f20662b;
    }

    public static z0 b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new z0(jSONObject.getInt("index"), jSONObject.getInt("position"), jSONObject.getString("chapter_id"), (float) jSONObject.optDouble("percent", w51.l));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static z0 c(gh0 gh0Var) {
        if (gh0Var == null) {
            return null;
        }
        return new z0((int) gh0Var.d(), (int) gh0Var.b(), gh0Var.c(), 0.0f);
    }

    public static gh0 d(z0 z0Var) {
        if (z0Var == null) {
            return null;
        }
        return new gh0(z0Var.f20661a, 0L, 0L, z0Var.c, z0Var.f20662b);
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("index", this.f20661a);
            jSONObject.put("position", this.f20662b);
            jSONObject.put("chapter_id", this.c);
            jSONObject.put("percent", this.d);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }
}
