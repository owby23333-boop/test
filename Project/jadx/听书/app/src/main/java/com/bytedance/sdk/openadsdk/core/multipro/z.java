package com.bytedance.sdk.openadsdk.core.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.ti.z.a;

/* JADX INFO: loaded from: classes2.dex */
public class z implements a.z {
    private com.bytedance.sdk.component.gz.g.g.g.z z;

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public void init() {
    }

    public z(com.bytedance.sdk.component.gz.g.g.g.z zVar) {
        this.z = zVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public void injectContext(Context context) {
        com.bytedance.sdk.component.gz.g.g.g.z zVar = this.z;
        if (zVar != null) {
            zVar.z(context);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public String getTableName() {
        com.bytedance.sdk.component.gz.g.g.g.z zVar = this.z;
        if (zVar != null) {
            return zVar.z();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public String getType(Uri uri) {
        com.bytedance.sdk.component.gz.g.g.g.z zVar = this.z;
        if (zVar != null) {
            return zVar.getType(uri);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        com.bytedance.sdk.component.gz.g.g.g.z zVar = this.z;
        if (zVar != null) {
            return zVar.query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public Uri insert(Uri uri, ContentValues contentValues) {
        com.bytedance.sdk.component.gz.g.g.g.z zVar = this.z;
        if (zVar != null) {
            return zVar.insert(uri, contentValues);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public int delete(Uri uri, String str, String[] strArr) {
        com.bytedance.sdk.component.gz.g.g.g.z zVar = this.z;
        if (zVar != null) {
            return zVar.delete(uri, str, strArr);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        com.bytedance.sdk.component.gz.g.g.g.z zVar = this.z;
        if (zVar != null) {
            return zVar.update(uri, contentValues, str, strArr);
        }
        return 0;
    }
}
