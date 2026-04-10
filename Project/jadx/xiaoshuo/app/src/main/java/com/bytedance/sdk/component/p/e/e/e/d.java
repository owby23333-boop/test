package com.bytedance.sdk.component.p.e.e.e;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static synchronized int delete(Context context, String str, String str2, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            com.bytedance.sdk.component.p.e.d.d.e("DBMultiUtils  delete start");
            return e.e(context).e().delete(str, str2, strArr);
        } catch (Throwable unused) {
            com.bytedance.sdk.component.p.e.d.d.e("delete ignore");
            return 0;
        }
    }

    public static synchronized void e(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            e.e(context).e().e(Uri.decode(str));
        } catch (Throwable unused) {
            com.bytedance.sdk.component.p.e.d.d.e("execSQL ignore");
        }
    }

    public static synchronized void insert(Context context, String str, ContentValues contentValues) {
        if (contentValues != null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    e.e(context).e().insert(str, (String) null, contentValues);
                } catch (Throwable unused) {
                    com.bytedance.sdk.component.p.e.d.d.e("insert ignore");
                }
            }
        }
    }

    public static synchronized Cursor query(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return e.e(context).e().query(str, strArr, str2, strArr2, null, null, str5);
        } catch (Throwable unused) {
            com.bytedance.sdk.component.p.e.d.d.e("query ignore");
            return null;
        }
    }

    public static synchronized int update(Context context, String str, ContentValues contentValues, String str2, String[] strArr) {
        if (contentValues != null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return e.e(context).e().update(str, contentValues, str2, strArr);
                } catch (Throwable unused) {
                    com.bytedance.sdk.component.p.e.d.d.e("update ignore");
                    return 0;
                }
            }
        }
        return 0;
    }

    public static synchronized void insert(Context context, String str, List<com.bytedance.sdk.component.p.e.tg.e> list) {
        if (list != null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    e.e(context).e().insert(str, (String) null, list);
                } catch (Throwable unused) {
                    com.bytedance.sdk.component.p.e.d.d.e("insert ignore");
                }
            }
        }
    }
}
