package com.baidu.mobads.sdk.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class bj {
    public static final String a = "mobads_builds";
    public static final String b = "brand_period";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f12905c = "version_period";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f12906d = 604800000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f12907e = 172800000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f12908f = "sdk_int";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f12909g = "sdk";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f12910h = "release";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f12911i = "model";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f12912j = "brand";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f12913k = "netopera";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f12914l = "tags";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f12915m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f12916n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f12917o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f12918p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f12919q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f12920r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f12921s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Context f12922t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private SharedPreferences f12923u;

    private static class a {
        private static final bj a = new bj();

        private a() {
        }
    }

    public static bj a(Context context) {
        a.a.b(context);
        return a.a;
    }

    private void h() {
        i();
        j();
    }

    private void i() {
        try {
            if (System.currentTimeMillis() > b(b).longValue()) {
                this.f12918p = Build.MODEL;
                this.f12919q = Build.BRAND;
                this.f12920r = ((TelephonyManager) this.f12922t.getSystemService("phone")).getNetworkOperator();
                this.f12921s = Build.TAGS;
                a("model", this.f12918p);
                a("brand", this.f12919q);
                a(f12913k, this.f12920r);
                a("tags", this.f12921s);
                a(b, Long.valueOf(System.currentTimeMillis() + f12906d));
            } else {
                this.f12918p = a("model");
                this.f12919q = a("brand");
                this.f12920r = a(f12913k);
                this.f12921s = a("tags");
            }
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
        }
    }

    private void j() {
        try {
            if (System.currentTimeMillis() > b(f12905c).longValue()) {
                this.f12915m = Build.VERSION.SDK_INT;
                this.f12916n = Build.VERSION.SDK;
                this.f12917o = Build.VERSION.RELEASE;
                a(f12908f, this.f12915m);
                a(f12909g, this.f12916n);
                a("release", this.f12917o);
                a(f12905c, Long.valueOf(System.currentTimeMillis() + f12907e));
            } else {
                this.f12915m = c(f12908f);
                this.f12916n = a(f12909g);
                this.f12917o = a("release");
            }
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
        }
    }

    private SharedPreferences.Editor k() {
        return this.f12923u.edit();
    }

    public void b(Context context) {
        if (this.f12922t != null || context == null) {
            if (a.a == null) {
                ay.a(context);
                return;
            }
            return;
        }
        this.f12922t = context.getApplicationContext();
        try {
            if (this.f12923u == null) {
                this.f12923u = this.f12922t.getSharedPreferences(a, 0);
                h();
            }
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
        }
    }

    public String c() {
        return this.f12917o;
    }

    public String d() {
        return this.f12918p;
    }

    public String e() {
        return this.f12919q;
    }

    public String f() {
        return this.f12920r;
    }

    public String g() {
        return this.f12921s;
    }

    private bj() {
        this.f12915m = 0;
        this.f12916n = "";
        this.f12917o = "";
        this.f12918p = "";
        this.f12919q = "";
        this.f12920r = "";
        this.f12921s = "";
    }

    private int c(String str) {
        try {
            return this.f12923u.getInt(str, 0);
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
            return 0;
        }
    }

    public int a() {
        if (this.f12915m == 0) {
            this.f12915m = Build.VERSION.SDK_INT;
        }
        return this.f12915m;
    }

    private String a(String str) {
        try {
            return this.f12923u.getString(str, "");
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
            return "";
        }
    }

    @TargetApi(9)
    private void a(String str, String str2) {
        try {
            SharedPreferences.Editor editorK = k();
            editorK.putString(str, str2);
            editorK.apply();
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
        }
    }

    public String b() {
        if (TextUtils.isEmpty(this.f12916n)) {
            this.f12916n = Build.VERSION.SDK;
        }
        return this.f12916n;
    }

    @TargetApi(9)
    private void a(String str, Long l2) {
        try {
            SharedPreferences.Editor editorK = k();
            editorK.putLong(str, l2.longValue());
            editorK.apply();
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
        }
    }

    private Long b(String str) {
        try {
            return Long.valueOf(this.f12923u.getLong(str, 0L));
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
            return 0L;
        }
    }

    @TargetApi(9)
    private void a(String str, int i2) {
        try {
            SharedPreferences.Editor editorK = k();
            editorK.putInt(str, i2);
            editorK.apply();
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
        }
    }
}
