package com.bytedance.msdk.gz.dl.z.z;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.ti.z.a;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements a.z {
    private com.bytedance.msdk.gz.z.z z;

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public String getTableName() {
        return "gromore_prime_rit_adn_perform";
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public String getType(Uri uri) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public void injectContext(Context context) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public void init() {
        if (com.bytedance.msdk.core.g.getContext() != null) {
            this.z = new com.bytedance.msdk.gz.z.z(com.bytedance.msdk.core.g.getContext());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        com.bytedance.msdk.gz.z.z zVar = this.z;
        if (zVar != null) {
            return zVar.z(str, strArr2);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public Uri insert(Uri uri, ContentValues contentValues) {
        com.bytedance.msdk.gz.z.z zVar = this.z;
        if (zVar == null) {
            return null;
        }
        zVar.z(contentValues);
        return uri;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public int delete(Uri uri, String str, String[] strArr) {
        com.bytedance.msdk.gz.z.z zVar = this.z;
        if (zVar == null) {
            return 0;
        }
        zVar.g(str, strArr);
        return 1;
    }
}
