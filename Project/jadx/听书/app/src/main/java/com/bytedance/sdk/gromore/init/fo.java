package com.bytedance.sdk.gromore.init;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.ti.z.a;

/* JADX INFO: loaded from: classes2.dex */
public class fo implements a.z {
    private a.z g = com.bytedance.msdk.gz.dl.z.z.g.z();
    private a.z z;

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public String getTableName() {
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public void init() {
    }

    public fo(a.z zVar) {
        this.z = zVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public void injectContext(Context context) {
        a.z zVar = this.z;
        if (zVar != null) {
            zVar.injectContext(context);
        }
        a.z zVar2 = this.g;
        if (zVar2 != null) {
            zVar2.injectContext(context);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public String getType(Uri uri) {
        return (z(uri) ? this.g : this.z).getType(uri);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (z(uri)) {
            return this.g.query(uri, strArr, str, strArr2, str2);
        }
        return this.z.query(uri, strArr, str, strArr2, str2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (z(uri)) {
            return this.g.insert(uri, contentValues);
        }
        return this.z.insert(uri, contentValues);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public int delete(Uri uri, String str, String[] strArr) {
        if (z(uri)) {
            return this.g.delete(uri, str, strArr);
        }
        return this.z.delete(uri, str, strArr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (z(uri)) {
            return this.g.update(uri, contentValues, str, strArr);
        }
        return this.z.update(uri, contentValues, str, strArr);
    }

    private boolean z(Uri uri) {
        if (uri == null) {
            return false;
        }
        String[] strArrSplit = uri.getPath().split("/");
        if (strArrSplit.length < 2) {
            return false;
        }
        String str = strArrSplit[1];
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("gromore");
    }
}
