package com.bytedance.msdk.gz.dl.z.z;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.ti.z.a;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private a.z g;
    private final com.bytedance.sdk.openadsdk.core.multipro.z z = new com.bytedance.sdk.openadsdk.core.multipro.z(new com.bytedance.sdk.component.gz.g.g.g.z("csj_mediation"));

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        a.z zVarZ = z(uri);
        if (zVarZ != null) {
            return zVarZ.query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    public String getType(Uri uri) {
        a.z zVarZ = z(uri);
        if (zVarZ != null) {
            return zVarZ.getType(uri);
        }
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        a.z zVarZ = z(uri);
        if (zVarZ != null) {
            return zVarZ.insert(uri, contentValues);
        }
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        a.z zVarZ = z(uri);
        if (zVarZ != null) {
            return zVarZ.delete(uri, str, strArr);
        }
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        a.z zVarZ = z(uri);
        if (zVarZ != null) {
            return zVarZ.update(uri, contentValues, str, strArr);
        }
        return 0;
    }

    private a.z z(Uri uri) {
        if (uri == null) {
            return null;
        }
        String[] strArrSplit = uri.getPath().split("/");
        if (strArrSplit.length < 2) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "uri is error2");
            return null;
        }
        String str = strArrSplit[1];
        if (TextUtils.isEmpty(str)) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "uri is error3");
            return null;
        }
        if (this.g == null) {
            dl dlVar = new dl();
            this.g = dlVar;
            dlVar.init();
        }
        if (str.equals(this.g.getTableName())) {
            return this.g;
        }
        if (str.equals(this.z.getTableName())) {
            return this.z;
        }
        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "uri is error4");
        return null;
    }
}
