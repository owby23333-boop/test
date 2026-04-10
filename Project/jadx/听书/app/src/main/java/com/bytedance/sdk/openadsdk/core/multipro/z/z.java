package com.bytedance.sdk.openadsdk.core.multipro.z;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.multipro.gc;
import com.bytedance.sdk.openadsdk.core.zw;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static ContentResolver z(Context context) {
        if (context == null) {
            try {
                context = zw.getContext();
            } catch (Throwable unused) {
                return null;
            }
        }
        return context.getContentResolver();
    }

    private static String z() {
        return gc.g + "/t_db/ttopensdk.db/";
    }

    public static void insert(Context context, String str, ContentValues contentValues) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver contentResolverZ = z(context);
            if (contentResolverZ != null) {
                contentResolverZ.insert(Uri.parse(z() + str), contentValues);
            }
        } catch (Throwable unused) {
        }
    }

    public static int delete(Context context, String str, String str2, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            ContentResolver contentResolverZ = z(context);
            if (contentResolverZ != null) {
                return contentResolverZ.delete(Uri.parse(z() + str), str2, strArr);
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    public static int update(Context context, String str, ContentValues contentValues, String str2, String[] strArr) {
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            try {
                ContentResolver contentResolverZ = z(context);
                if (contentResolverZ != null) {
                    return contentResolverZ.update(Uri.parse(z() + str), contentValues, str2, strArr);
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static Cursor query(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ContentResolver contentResolverZ = z(context);
            if (contentResolverZ != null) {
                return contentResolverZ.query(Uri.parse(z() + str), strArr, str2, strArr2, str5);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static void z(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver contentResolverZ = z(context);
            if (contentResolverZ != null) {
                contentResolverZ.getType(Uri.parse(z() + "unknown/execSQL?sql=" + Uri.encode(str)));
            }
        } catch (Throwable unused) {
        }
    }
}
