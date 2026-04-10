package com.bytedance.sdk.openadsdk.core.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.ITTProvider;

/* JADX INFO: loaded from: classes10.dex */
public class d implements ITTProvider {
    private com.bytedance.sdk.component.vn.d.e.tg e = new com.bytedance.sdk.component.vn.d.e.tg();

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return this.e.delete(uri, str, strArr);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getTableName() {
        return this.e.e();
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getType(Uri uri) {
        return this.e.getType(uri);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void init() {
        this.e.bf();
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void injectContext(Context context) {
        this.e.e(context);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return this.e.insert(uri, contentValues);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.e.query(uri, strArr, str, strArr2, str2);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.e.update(uri, contentValues, str, strArr);
    }
}
