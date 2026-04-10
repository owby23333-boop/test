package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class v {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static JSONObject f16837h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f16838i = "1";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f16839j = "2";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f16840k = "3";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f16841l = "4";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f16842m = "5";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f16843n = "6";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f16844o = "7";
    public int a;
    public long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f16845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f16846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f16847e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f16848f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f16849g;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private PackageInfo f16850p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ApplicationInfo f16851q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Context f16852r;

    public v(ApplicationInfo applicationInfo, Context context) {
        this.f16851q = applicationInfo;
        this.f16852r = context;
    }

    public v(PackageInfo packageInfo, Context context) {
        this.f16850p = packageInfo;
        this.f16852r = context;
    }

    public int a() {
        return this.a;
    }

    public void a(int i2) {
        this.a = i2;
    }

    public void a(long j2) {
        this.b = j2;
    }

    public void a(String str) {
        this.f16847e = str;
    }

    public String b() {
        return this.f16847e;
    }

    public void b(int i2) {
        this.f16849g = i2;
    }

    public void b(long j2) {
        this.f16845c = j2;
    }

    public void b(String str) {
        this.f16848f = str;
    }

    public String c() {
        return this.f16848f;
    }

    public void c(String str) {
        this.f16846d = str;
    }

    public long d() {
        return this.b;
    }

    public String e() {
        return this.f16846d;
    }

    public long f() {
        return this.f16845c;
    }

    public int g() {
        return this.f16849g;
    }

    public void h() {
        if (this.f16850p == null && this.f16851q == null) {
            return;
        }
        try {
            if (this.f16850p == null && this.f16851q != null) {
                this.f16850p = this.f16852r.getPackageManager().getPackageInfo(this.f16851q.packageName, 0);
            }
        } catch (Exception unused) {
        }
        PackageInfo packageInfo = this.f16850p;
        a(packageInfo == null ? this.f16851q.packageName : packageInfo.packageName);
        PackageInfo packageInfo2 = this.f16850p;
        a((packageInfo2 == null ? this.f16851q : packageInfo2.applicationInfo).flags & 1);
        b(j());
        PackageInfo packageInfo3 = this.f16850p;
        if (packageInfo3 != null) {
            a(packageInfo3.firstInstallTime);
            b(this.f16850p.lastUpdateTime);
            c(this.f16850p.versionName);
            b(this.f16850p.versionCode);
        }
    }

    public void i() {
        if (this.f16850p == null && this.f16851q == null) {
            return;
        }
        try {
            if (this.f16850p == null && this.f16851q != null) {
                this.f16850p = this.f16852r.getPackageManager().getPackageInfo(this.f16851q.packageName, 0);
            }
        } catch (Exception unused) {
        }
        PackageInfo packageInfo = this.f16850p;
        a(packageInfo == null ? this.f16851q.packageName : packageInfo.packageName);
        PackageInfo packageInfo2 = this.f16850p;
        a((packageInfo2 == null ? this.f16851q : packageInfo2.applicationInfo).flags & 1);
        PackageInfo packageInfo3 = this.f16850p;
        if (packageInfo3 != null) {
            a(packageInfo3.firstInstallTime);
            b(this.f16850p.lastUpdateTime);
            c(this.f16850p.versionName);
            b(this.f16850p.versionCode);
        }
    }

    public String j() {
        try {
            if (this.f16850p != null && this.f16850p.applicationInfo != null) {
                String string = this.f16850p.applicationInfo.loadLabel(this.f16852r.getPackageManager()).toString();
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
            } else if (this.f16851q != null) {
                String string2 = this.f16851q.loadLabel(this.f16852r.getPackageManager()).toString();
                if (!TextUtils.isEmpty(string2)) {
                    return string2;
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public JSONObject k() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("1", c());
            jSONObject.put("2", b());
            jSONObject.put("3", e());
            jSONObject.put("4", g());
            jSONObject.put("5", a());
            jSONObject.put("6", d());
            jSONObject.put("7", f());
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}
