package com.bytedance.sdk.openadsdk.core.multipro.e;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.lc;
import com.bytedance.sdk.openadsdk.core.multipro.ga;

/* JADX INFO: loaded from: classes10.dex */
public class e {
    public static int delete(Context context, String str, String str2, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            ContentResolver contentResolverE = e(context);
            if (contentResolverE != null) {
                return contentResolverE.delete(Uri.parse(e() + str), str2, strArr);
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    private static ContentResolver e(Context context) {
        if (context == null) {
            try {
                context = lc.getContext();
            } catch (Throwable unused) {
                return null;
            }
        }
        return context.getContentResolver();
    }

    public static void insert(Context context, String str, ContentValues contentValues) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver contentResolverE = e(context);
            if (contentResolverE != null) {
                contentResolverE.insert(Uri.parse(e() + str), contentValues);
            }
        } catch (Throwable unused) {
        }
    }

    public static Cursor query(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ContentResolver contentResolverE = e(context);
            if (contentResolverE != null) {
                return contentResolverE.query(Uri.parse(e() + str), strArr, str2, strArr2, str5);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static int update(Context context, String str, ContentValues contentValues, String str2, String[] strArr) {
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            try {
                ContentResolver contentResolverE = e(context);
                if (contentResolverE != null) {
                    return contentResolverE.update(Uri.parse(e() + str), contentValues, str2, strArr);
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    private static String e() {
        return ga.bf + "/t_db/ttopensdk.db/";
    }
}
