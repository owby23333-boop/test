package com.bytedance.sdk.component.gz.g.z.z;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.gz.z.gc;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static void insert(Context context, String str, ContentValues contentValues, gc gcVar) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            z.z(context).z().insert(gcVar, str, (String) null, contentValues);
        } catch (Throwable unused) {
        }
    }

    public static void insert(Context context, String str, List<com.bytedance.sdk.component.gz.z.g> list, gc gcVar) {
        if (list == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            z.z(context).z().insert(gcVar, str, (String) null, list);
        } catch (Throwable unused) {
        }
    }

    public static int delete(Context context, String str, String str2, String[] strArr, gc gcVar) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return z.z(context).z().delete(gcVar, str, str2, strArr);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static int update(Context context, String str, ContentValues contentValues, String str2, String[] strArr, gc gcVar) {
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            try {
                return z.z(context).z().update(gcVar, str, contentValues, str2, strArr);
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static Cursor query(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, gc gcVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return z.z(context).z().query(gcVar, str, strArr, str2, strArr2, null, null, str5);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String z(Context context, String str, gc gcVar) {
        if (TextUtils.isEmpty(str)) {
            return "sql is null";
        }
        try {
            z.z(context).z().z(gcVar, Uri.decode(str));
            return "execSql ok";
        } catch (Throwable th) {
            return "exec sql exception:" + th.getMessage();
        }
    }
}
