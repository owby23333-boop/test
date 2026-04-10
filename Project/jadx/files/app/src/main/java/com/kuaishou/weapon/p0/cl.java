package com.kuaishou.weapon.p0;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class cl {
    private String a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f16653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f16654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f16655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f16656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f16657g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f16658h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f16659i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f16660j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f16661k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f16662l;

    public cl(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        this.f16659i = sb.toString();
        this.f16653c = str;
        this.f16657g = str2;
    }

    public static String b(Context context) {
        try {
            String str = WeaponHI.sKDeviceId;
            if (!TextUtils.isEmpty(str)) {
                bh.f16583v = 1;
                return str;
            }
        } catch (Exception unused) {
        }
        try {
            h hVarA = h.a(context, "re_po_rt");
            boolean zE = hVarA.e("a1_p_s_p_s");
            boolean zE2 = hVarA.e("a1_p_s_p_s_c_b");
            if (zE || zE2) {
                String str2 = "ANDROID_" + Settings.Secure.getString(context.getContentResolver(), "android_id");
                if (!TextUtils.isEmpty(str2)) {
                    bh.f16583v = 3;
                    return str2;
                }
            }
        } catch (Exception unused2) {
        }
        bh.f16583v = 4;
        return "";
    }

    public static String m() {
        try {
            return !TextUtils.isEmpty(WeaponHI.skProductName) ? WeaponHI.skProductName : "UNKNOWN_PRODUCT";
        } catch (Exception unused) {
            return "UNKNOWN_PRODUCT";
        }
    }

    private JSONObject n() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("1", this.a);
            jSONObject.put("2", this.b);
            jSONObject.put("3", this.f16653c);
            jSONObject.put("4", this.f16654d);
            jSONObject.put("5", this.f16655e);
            jSONObject.put("6", this.f16656f);
            jSONObject.put("7", this.f16657g);
            jSONObject.put("8", this.f16658h);
            jSONObject.put("9", this.f16659i);
            jSONObject.put(AgooConstants.ACK_BODY_NULL, this.f16660j);
            jSONObject.put(AgooConstants.ACK_PACK_NULL, this.f16662l);
            jSONObject.put(AgooConstants.ACK_FLAG_NULL, "com.kuaishou.weapon");
            jSONObject.put(AgooConstants.ACK_PACK_NOBIND, WeaponHI.sKSSdkver);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String a() {
        return this.a;
    }

    public JSONObject a(Context context) {
        try {
            a(b(context));
            b(m());
            d(bg.q(context));
            e(bg.r(context));
            f(bg.s(context));
            h("5.0.7");
            j(bs.a(context));
            l(WeaponHI.sKSAppkey);
            return n();
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(String str) {
        this.a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.f16653c;
    }

    public void c(String str) {
        this.f16653c = str;
    }

    public String d() {
        return this.f16654d;
    }

    public void d(String str) {
        this.f16654d = str;
    }

    public String e() {
        return this.f16655e;
    }

    public void e(String str) {
        this.f16655e = str;
    }

    public String f() {
        return this.f16656f;
    }

    public void f(String str) {
        this.f16656f = str;
    }

    public String g() {
        return this.f16657g;
    }

    public void g(String str) {
        this.f16657g = str;
    }

    public String h() {
        return this.f16658h;
    }

    public void h(String str) {
        this.f16658h = str;
    }

    public String i() {
        return this.f16659i;
    }

    public void i(String str) {
        this.f16659i = str;
    }

    public String j() {
        return this.f16660j;
    }

    public void j(String str) {
        this.f16660j = str;
    }

    public String k() {
        return this.f16661k;
    }

    public void k(String str) {
        this.f16661k = str;
    }

    public String l() {
        return this.f16662l;
    }

    public void l(String str) {
        this.f16662l = str;
    }
}
