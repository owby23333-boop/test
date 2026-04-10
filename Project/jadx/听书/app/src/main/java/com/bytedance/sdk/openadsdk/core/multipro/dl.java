package com.bytedance.sdk.openadsdk.core.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.ti.z.a;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements a.z {
    private com.bytedance.sdk.component.e.dl.z.a z = new com.bytedance.sdk.component.e.dl.z.a();

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public void init() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public void injectContext(Context context) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public String getTableName() {
        return this.z.z();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public String getType(Uri uri) {
        return this.z.getType(uri);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.z.query(uri, strArr, str, strArr2, str2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public Uri insert(Uri uri, ContentValues contentValues) {
        return this.z.insert(uri, contentValues);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public int delete(Uri uri, String str, String[] strArr) {
        return this.z.delete(uri, str, strArr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.z.update(uri, contentValues, str, strArr);
    }
}
