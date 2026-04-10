package com.bytedance.msdk.gz.dl.z.z;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.ti.z.a;

/* JADX INFO: loaded from: classes2.dex */
public class g implements a.z {
    private static volatile g z;
    private z g = new z();

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public String getTableName() {
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public void init() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public void injectContext(Context context) {
    }

    private g() {
    }

    public static g z() {
        if (z == null) {
            synchronized (g.class) {
                if (z == null) {
                    z = new g();
                }
            }
        }
        return z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public String getType(Uri uri) {
        return this.g.getType(uri);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.g.query(uri, strArr, str, strArr2, str2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public Uri insert(Uri uri, ContentValues contentValues) {
        return this.g.insert(uri, contentValues);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public int delete(Uri uri, String str, String[] strArr) {
        return this.g.delete(uri, str, strArr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.g.update(uri, contentValues, str, strArr);
    }
}
