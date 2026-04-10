package com.alipay.sdk.m.r0;

import android.content.Context;
import android.content.SharedPreferences;
import com.alipay.sdk.m.q0.f;
import com.xiaomi.verificationsdk.internal.Constants;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedPreferences f1927b;
    public SharedPreferences.Editor c = null;
    public Context d;
    public boolean e;

    public a(Context context, String str, String str2, boolean z, boolean z2) {
        this.f1927b = null;
        this.e = z2;
        this.f1926a = str2;
        this.d = context;
        if (context != null) {
            this.f1927b = context.getSharedPreferences(str2, 0);
        }
    }

    public final void a() {
        SharedPreferences sharedPreferences;
        if (this.c != null || (sharedPreferences = this.f1927b) == null) {
            return;
        }
        this.c = sharedPreferences.edit();
    }

    public void b(String str) {
        if (f.b(str) || str.equals(Constants.TIMESTAMP)) {
            return;
        }
        a();
        SharedPreferences.Editor editor = this.c;
        if (editor != null) {
            editor.remove(str);
        }
    }

    public void a(String str, String str2) {
        if (f.b(str) || str.equals(Constants.TIMESTAMP)) {
            return;
        }
        a();
        SharedPreferences.Editor editor = this.c;
        if (editor != null) {
            editor.putString(str, str2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b() {
        /*
            r5 = this;
            long r0 = java.lang.System.currentTimeMillis()
            android.content.SharedPreferences$Editor r2 = r5.c
            r3 = 0
            if (r2 == 0) goto L21
            boolean r4 = r5.e
            if (r4 != 0) goto L17
            android.content.SharedPreferences r4 = r5.f1927b
            if (r4 == 0) goto L17
            java.lang.String r4 = "t"
            r2.putLong(r4, r0)
        L17:
            android.content.SharedPreferences$Editor r0 = r5.c
            boolean r0 = r0.commit()
            if (r0 != 0) goto L21
            r0 = r3
            goto L22
        L21:
            r0 = 1
        L22:
            android.content.SharedPreferences r1 = r5.f1927b
            if (r1 == 0) goto L32
            android.content.Context r1 = r5.d
            if (r1 == 0) goto L32
            java.lang.String r2 = r5.f1926a
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r3)
            r5.f1927b = r1
        L32:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.r0.a.b():boolean");
    }

    public String a(String str) {
        SharedPreferences sharedPreferences = this.f1927b;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            if (!f.b(string)) {
                return string;
            }
        }
        return "";
    }
}
