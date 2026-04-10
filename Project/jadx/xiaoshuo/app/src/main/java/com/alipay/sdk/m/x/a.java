package com.alipay.sdk.m.x;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alipay.sdk.app.OpenAuthTask;
import com.alipay.sdk.m.p.e;
import com.alipay.sdk.m.y.g;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final String g = "alipay_tid_storage";
    public static final String h = "tidinfo";
    public static final String i = "tid";
    public static final String j = "client_key";
    public static final String k = "timestamp";
    public static final String l = "vimei";
    public static final String m = "vimsi";
    public static Context n;
    public static a o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1977b;
    public long c;
    public String d;
    public String e;
    public boolean f = false;

    public final void b(Context context) {
        if (context != null) {
            n = context.getApplicationContext();
        }
        if (this.f) {
            return;
        }
        this.f = true;
        l();
    }

    public String c() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        return hexString.length() > 10 ? hexString.substring(hexString.length() - 10) : hexString;
    }

    public final String d() {
        return Long.toHexString(System.currentTimeMillis()) + (new Random().nextInt(OpenAuthTask.OK) + 1000);
    }

    public String e() {
        return this.f1977b;
    }

    public String f() {
        return this.f1976a;
    }

    public Long g() {
        return Long.valueOf(this.c);
    }

    public String h() {
        return this.d;
    }

    public String i() {
        return this.e;
    }

    public boolean j() {
        return k();
    }

    public boolean k() {
        return TextUtils.isEmpty(this.f1976a) || TextUtils.isEmpty(this.f1977b) || TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.e);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void l() {
        /*
            r9 = this;
            java.lang.String r0 = ""
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r2 = 0
            java.lang.String r3 = "alipay_tid_storage"
            java.lang.String r4 = "tidinfo"
            r5 = 1
            java.lang.String r3 = com.alipay.sdk.m.x.a.C0045a.a(r3, r4, r5)     // Catch: java.lang.Exception -> L57
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L57
            if (r4 != 0) goto L53
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Exception -> L57
            r4.<init>(r3)     // Catch: java.lang.Exception -> L57
            java.lang.String r3 = "tid"
            java.lang.String r3 = r4.optString(r3, r0)     // Catch: java.lang.Exception -> L57
            java.lang.String r5 = "client_key"
            java.lang.String r5 = r4.optString(r5, r0)     // Catch: java.lang.Exception -> L50
            java.lang.String r6 = "timestamp"
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L4d
            long r6 = r4.optLong(r6, r7)     // Catch: java.lang.Exception -> L4d
            java.lang.Long r1 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Exception -> L4d
            java.lang.String r6 = "vimei"
            java.lang.String r6 = r4.optString(r6, r0)     // Catch: java.lang.Exception -> L4d
            java.lang.String r7 = "vimsi"
            java.lang.String r2 = r4.optString(r7, r0)     // Catch: java.lang.Exception -> L4b
            goto L5e
        L4b:
            r0 = move-exception
            goto L5b
        L4d:
            r0 = move-exception
            r6 = r2
            goto L5b
        L50:
            r0 = move-exception
            r5 = r2
            goto L5a
        L53:
            r0 = r2
            r5 = r0
            r6 = r5
            goto L60
        L57:
            r0 = move-exception
            r3 = r2
            r5 = r3
        L5a:
            r6 = r5
        L5b:
            com.alipay.sdk.m.y.g.a(r0)
        L5e:
            r0 = r2
            r2 = r3
        L60:
            java.lang.String r3 = "mspl"
            java.lang.String r4 = "tid_str: load"
            com.alipay.sdk.m.y.g.b(r3, r4)
            boolean r3 = r9.a(r2, r5, r6, r0)
            if (r3 == 0) goto L72
            r9.m()
            goto L80
        L72:
            r9.f1976a = r2
            r9.f1977b = r5
            long r1 = r1.longValue()
            r9.c = r1
            r9.d = r6
            r9.e = r0
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.x.a.l():void");
    }

    public final void m() {
        this.f1976a = "";
        this.f1977b = c();
        this.c = System.currentTimeMillis();
        this.d = d();
        this.e = d();
        C0045a.b(g, h);
    }

    public final void n() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tid", this.f1976a);
            jSONObject.put(j, this.f1977b);
            jSONObject.put("timestamp", this.c);
            jSONObject.put(l, this.d);
            jSONObject.put(m, this.e);
            C0045a.a(g, h, jSONObject.toString(), true);
        } catch (Exception e) {
            g.a(e);
        }
    }

    public final void o() {
    }

    public static synchronized a a(Context context) {
        if (o == null) {
            o = new a();
        }
        if (n == null) {
            o.b(context);
        }
        return o;
    }

    /* JADX INFO: renamed from: com.alipay.sdk.m.x.a$a, reason: collision with other inner class name */
    public static class C0045a {
        public static boolean a(String str, String str2) {
            if (a.n == null) {
                return false;
            }
            return a.n.getSharedPreferences(str, 0).contains(str2);
        }

        public static void b(String str, String str2) {
            if (a.n == null) {
                return;
            }
            a.n.getSharedPreferences(str, 0).edit().remove(str2).apply();
        }

        public static boolean c(String str, String str2) {
            if (a.n == null) {
                return false;
            }
            return a.n.getSharedPreferences(str, 0).contains(str2);
        }

        public static String d(String str, String str2) {
            return a(str, str2, true);
        }

        public static String a(String str, String str2, boolean z) {
            if (a.n == null) {
                return null;
            }
            String string = a.n.getSharedPreferences(str, 0).getString(str2, null);
            if (!TextUtils.isEmpty(string) && z) {
                string = e.a(a(), string, string);
                if (TextUtils.isEmpty(string)) {
                    g.b(com.alipay.sdk.m.n.a.B, "tid_str: pref failed");
                }
            }
            g.b(com.alipay.sdk.m.n.a.B, "tid_str: from local");
            return string;
        }

        public static void a(String str, String str2, String str3) {
            a(str, str2, str3, true);
        }

        public static void a(String str, String str2, String str3, boolean z) {
            if (a.n == null) {
                return;
            }
            SharedPreferences sharedPreferences = a.n.getSharedPreferences(str, 0);
            if (z) {
                String strA = a();
                String strB = e.b(strA, str3, str3);
                if (TextUtils.isEmpty(strB)) {
                    String.format("LocalPreference::putLocalPreferences failed %s，%s", str3, strA);
                }
                str3 = strB;
            }
            sharedPreferences.edit().putString(str2, str3).apply();
        }

        public static String a() {
            String packageName;
            try {
                packageName = a.n.getApplicationContext().getPackageName();
            } catch (Throwable th) {
                g.a(th);
                packageName = "";
            }
            return (packageName + "0000000000000000000000000000").substring(0, 24);
        }
    }

    public void b() {
        g.b(com.alipay.sdk.m.n.a.B, "tid_str: del");
        m();
    }

    public final boolean a(String str, String str2, String str3, String str4) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4);
    }

    public void a(String str, String str2) {
        g.b(com.alipay.sdk.m.n.a.B, "tid_str: save");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f1976a = str;
        this.f1977b = str2;
        this.c = System.currentTimeMillis();
        n();
        o();
    }

    public final void a(String str, String str2, String str3, String str4, Long l2) {
        if (a(str, str2, str3, str4)) {
            return;
        }
        this.f1976a = str;
        this.f1977b = str2;
        this.d = str3;
        this.e = str4;
        if (l2 == null) {
            this.c = System.currentTimeMillis();
        } else {
            this.c = l2.longValue();
        }
        n();
    }
}
