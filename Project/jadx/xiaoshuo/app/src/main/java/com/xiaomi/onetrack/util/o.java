package com.xiaomi.onetrack.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.util.UUID;

/* JADX INFO: loaded from: classes8.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7721a = "o";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f7722b = "content://com.miui.analytics.OneTrackProvider/insId";
    private static final String c = "insId";
    private static final String d = "pkg";
    private static final String e = "sign";
    private static volatile o f;
    private static String g;
    private static String j;
    private boolean k = false;
    private final Context h = com.xiaomi.onetrack.f.a.a();
    private final Context i = com.xiaomi.onetrack.f.a.b();

    private o() {
        j = com.xiaomi.onetrack.f.a.e();
    }

    public static o a() {
        if (f == null) {
            synchronized (o.class) {
                if (f == null) {
                    f = new o();
                }
            }
        }
        return f;
    }

    private String c() {
        String string = null;
        try {
            Uri.Builder builderBuildUpon = Uri.parse(f7722b).buildUpon();
            builderBuildUpon.appendQueryParameter(d, j);
            builderBuildUpon.appendQueryParameter("sign", com.xiaomi.onetrack.d.a.a(c + j));
            Cursor cursorQuery = this.i.getContentResolver().query(builderBuildUpon.build(), null, null, null, null);
            if (cursorQuery != null) {
                while (cursorQuery.moveToNext()) {
                    string = cursorQuery.getString(0);
                }
                cursorQuery.close();
            }
        } catch (Exception e2) {
            p.a(f7721a, "getRemoteCacheInstanceId e", e2);
        }
        return string;
    }

    private String d() {
        String strA = aa.a(this.h);
        if (TextUtils.isEmpty(strA)) {
            return aa.m();
        }
        aa.e(strA);
        return strA;
    }

    public String b() {
        String strD;
        if (!TextUtils.isEmpty(g)) {
            return g;
        }
        if (this.k) {
            strD = c();
            String strD2 = d();
            if (TextUtils.isEmpty(strD) && !TextUtils.isEmpty(strD2)) {
                b(strD2);
                strD = strD2;
            } else if (!TextUtils.isEmpty(strD) && TextUtils.isEmpty(strD2)) {
                aa.e(strD);
            }
        } else {
            strD = d();
        }
        if (TextUtils.isEmpty(strD)) {
            String string = UUID.randomUUID().toString();
            g = string;
            if (this.k) {
                b(string);
            }
            aa.e(g);
        } else {
            g = strD;
        }
        return g;
    }

    public void a(Boolean bool) {
        this.k = bool.booleanValue();
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        g = str;
        if (this.k) {
            b(str);
        }
        aa.e(g);
    }

    private void b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Uri uri = Uri.parse(f7722b);
            ContentValues contentValues = new ContentValues();
            contentValues.put(j, str);
            this.i.getContentResolver().insert(uri, contentValues);
        } catch (Exception e2) {
            aa.e(str);
            p.a(f7721a, "setRemoteCacheInstanceId e", e2);
        }
    }
}
