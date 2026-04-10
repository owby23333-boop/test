package com.ta.utdid2.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.ta.utdid2.a.a.f;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private SharedPreferences.Editor a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private SharedPreferences f150a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f151a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f18103e;
    private Context mContext;

    public a(Context context, String str, String str2, boolean z2, boolean z3) {
        this.f151a = "";
        this.f150a = null;
        this.mContext = null;
        this.f18103e = false;
        this.f18103e = z3;
        this.f151a = str2;
        this.mContext = context;
        if (context != null) {
            this.f150a = context.getSharedPreferences(str2, 0);
        }
    }

    private void a() {
        SharedPreferences sharedPreferences;
        if (this.a != null || (sharedPreferences = this.f150a) == null) {
            return;
        }
        this.a = sharedPreferences.edit();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean commit() {
        /*
            r5 = this;
            long r0 = java.lang.System.currentTimeMillis()
            android.content.SharedPreferences$Editor r2 = r5.a
            r3 = 0
            if (r2 == 0) goto L20
            boolean r4 = r5.f18103e
            if (r4 != 0) goto L16
            android.content.SharedPreferences r4 = r5.f150a
            if (r4 == 0) goto L16
            java.lang.String r4 = "t"
            r2.putLong(r4, r0)
        L16:
            android.content.SharedPreferences$Editor r0 = r5.a
            boolean r0 = r0.commit()
            if (r0 != 0) goto L20
            r0 = 0
            goto L21
        L20:
            r0 = 1
        L21:
            android.content.SharedPreferences r1 = r5.f150a
            if (r1 == 0) goto L31
            android.content.Context r1 = r5.mContext
            if (r1 == 0) goto L31
            java.lang.String r2 = r5.f151a
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r3)
            r5.f150a = r1
        L31:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.b.a.a.commit():boolean");
    }

    public String getString(String str) {
        SharedPreferences sharedPreferences = this.f150a;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            if (!f.m175a(string)) {
                return string;
            }
        }
        return "";
    }

    public void putString(String str, String str2) {
        if (f.m175a(str) || str.equals("t")) {
            return;
        }
        a();
        SharedPreferences.Editor editor = this.a;
        if (editor != null) {
            editor.putString(str, str2);
        }
    }

    public void remove(String str) {
        if (f.m175a(str) || str.equals("t")) {
            return;
        }
        a();
        SharedPreferences.Editor editor = this.a;
        if (editor != null) {
            editor.remove(str);
        }
    }
}
