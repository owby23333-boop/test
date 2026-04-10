package com.bytedance.sdk.openadsdk.core.multipro.dl;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.multipro.gc;
import com.bytedance.sdk.openadsdk.core.ti.z.a;
import com.bytedance.sdk.openadsdk.core.zw;

/* JADX INFO: loaded from: classes2.dex */
public class z implements a.z {
    private Context z;

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public String getTableName() {
        return "t_frequent";
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public void init() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private static ContentResolver gc() {
        try {
            if (zw.getContext() != null) {
                return zw.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean z(String str) {
        return z(str, "checkFrequency");
    }

    public static boolean g(String str) {
        return z(str, "checkAggFrequency");
    }

    public static boolean z(String str, String str2) {
        if (zw.getContext() == null) {
            return false;
        }
        try {
            ContentResolver contentResolverGc = gc();
            if (contentResolverGc != null) {
                return "true".equals(contentResolverGc.getType(Uri.parse(m() + str2 + "?rit=" + String.valueOf(str))));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean z() {
        return dl("isSilent");
    }

    public static boolean g() {
        return dl("isAggSilent");
    }

    public static boolean dl(String str) {
        if (zw.getContext() == null) {
            return false;
        }
        try {
            ContentResolver contentResolverGc = gc();
            if (contentResolverGc != null) {
                return "true".equals(contentResolverGc.getType(Uri.parse(m() + str)));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String dl() {
        return a("maxRit");
    }

    public static String a() {
        return a("maxAggRit");
    }

    public static String a(String str) {
        if (zw.getContext() == null) {
            return null;
        }
        try {
            ContentResolver contentResolverGc = gc();
            if (contentResolverGc != null) {
                return contentResolverGc.getType(Uri.parse(m() + str));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static String m() {
        return gc.g + "/t_frequent/";
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public void injectContext(Context context) {
        this.z = context;
    }

    private Context getContext() {
        Context context = this.z;
        return context == null ? zw.getContext() : context;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public String getType(Uri uri) {
        String str = uri.getPath().split("/")[2];
        if ("checkFrequency".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.pf.gc.z().z(uri.getQueryParameter("rit")) ? "true" : "false";
        }
        if ("isSilent".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.pf.gc.z().a() ? "true" : "false";
        }
        if ("maxRit".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.pf.gc.z().gc();
        }
        if ("checkAggFrequency".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.pf.z.z().z(uri.getQueryParameter("rit")) ? "true" : "false";
        }
        if ("isAggSilent".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.pf.z.z().a() ? "true" : "false";
        }
        if ("maxAggRit".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.pf.z.z().gc();
        }
        return null;
    }
}
