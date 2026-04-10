package com.bytedance.sdk.openadsdk.core.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.component.utils.wu;
import com.bytedance.sdk.openadsdk.ITTProvider;

/* JADX INFO: loaded from: classes10.dex */
public class e implements ITTProvider {
    private com.bytedance.sdk.component.p.e.bf.bf.e e;

    public e(com.bytedance.sdk.component.p.e.bf.bf.e eVar) {
        this.e = eVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int delete(Uri uri, String str, String[] strArr) {
        com.bytedance.sdk.component.p.e.bf.bf.e eVar = this.e;
        if (eVar != null) {
            return eVar.delete(uri, str, strArr);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getTableName() {
        com.bytedance.sdk.component.p.e.bf.bf.e eVar = this.e;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getType(Uri uri) {
        wu.e("wrapper getType1");
        com.bytedance.sdk.component.p.e.bf.bf.e eVar = this.e;
        if (eVar != null) {
            return eVar.getType(uri);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void init() {
        com.bytedance.sdk.component.p.e.bf.bf.e eVar = this.e;
        if (eVar != null) {
            eVar.tg();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void injectContext(Context context) {
        com.bytedance.sdk.component.p.e.bf.bf.e eVar = this.e;
        if (eVar != null) {
            eVar.e(context);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        com.bytedance.sdk.component.p.e.bf.bf.e eVar = this.e;
        if (eVar != null) {
            return eVar.insert(uri, contentValues);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        com.bytedance.sdk.component.p.e.bf.bf.e eVar = this.e;
        if (eVar != null) {
            return eVar.query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        com.bytedance.sdk.component.p.e.bf.bf.e eVar = this.e;
        if (eVar != null) {
            return eVar.update(uri, contentValues, str, strArr);
        }
        return 0;
    }
}
