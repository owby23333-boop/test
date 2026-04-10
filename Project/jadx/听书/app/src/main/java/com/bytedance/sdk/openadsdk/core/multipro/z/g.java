package com.bytedance.sdk.openadsdk.core.multipro.z;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.e;
import com.bytedance.sdk.openadsdk.core.ti.z.a;
import com.bytedance.sdk.openadsdk.core.zw;

/* JADX INFO: loaded from: classes2.dex */
public class g implements a.z {
    private Context z;

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public String getTableName() {
        return "t_db";
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public void init() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public void injectContext(Context context) {
        this.z = context;
    }

    private boolean z(Uri uri) {
        return uri == null || TextUtils.isEmpty(uri.getPath());
    }

    private Context getContext() {
        Context context = this.z;
        return context == null ? zw.getContext() : context;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String[] strArrSplit;
        if (!z(uri) && (strArrSplit = uri.getPath().split("/")) != null && strArrSplit.length >= 4) {
            String str3 = strArrSplit[2];
            String str4 = strArrSplit[3];
            if ("ttopensdk.db".equals(str3)) {
                return e.z(getContext()).z().query(str4, strArr, str, strArr2, null, null, str2);
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public String getType(Uri uri) {
        String[] strArrSplit;
        if (!z(uri) && (strArrSplit = uri.getPath().split("/")) != null && strArrSplit.length >= 5) {
            String str = strArrSplit[2];
            String str2 = strArrSplit[4];
            if ("ttopensdk.db".equals(str)) {
                if ("execSQL".equals(str2)) {
                    String queryParameter = uri.getQueryParameter("sql");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        e.z(getContext()).z().z(Uri.decode(queryParameter));
                    }
                } else if ("transactionBegin".equals(str2)) {
                    e.z(getContext()).z().dl();
                } else if ("transactionSetSuccess".equals(str2)) {
                    e.z(getContext()).z().a();
                } else if ("transactionEnd".equals(str2)) {
                    e.z(getContext()).z().gc();
                }
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public Uri insert(Uri uri, ContentValues contentValues) throws Exception {
        String[] strArrSplit;
        if (!z(uri) && (strArrSplit = uri.getPath().split("/")) != null && strArrSplit.length >= 4) {
            String str = strArrSplit[2];
            String str2 = strArrSplit[3];
            if ("ttopensdk.db".equals(str)) {
                e.z(getContext()).z().insert(str2, null, contentValues);
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public int delete(Uri uri, String str, String[] strArr) {
        String[] strArrSplit;
        if (!z(uri) && (strArrSplit = uri.getPath().split("/")) != null && strArrSplit.length >= 4) {
            String str2 = strArrSplit[2];
            String str3 = strArrSplit[3];
            if ("ttopensdk.db".equals(str2)) {
                return e.z(getContext()).z().delete(str3, str, strArr);
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        String[] strArrSplit;
        if (!z(uri) && (strArrSplit = uri.getPath().split("/")) != null && strArrSplit.length >= 4) {
            String str2 = strArrSplit[2];
            String str3 = strArrSplit[3];
            if ("ttopensdk.db".equals(str2)) {
                return e.z(getContext()).z().update(str3, contentValues, str, strArr);
            }
        }
        return 0;
    }
}
