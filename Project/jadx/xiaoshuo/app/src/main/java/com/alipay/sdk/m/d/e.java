package com.alipay.sdk.m.d;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public class e implements com.alipay.sdk.m.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1800a = "content://cn.nubia.provider.deviceid.dataid/oaid";

    @Override // com.alipay.sdk.m.c.b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse(f1800a), null, null, null, null);
        if (cursorQuery != null) {
            string = cursorQuery.moveToNext() ? cursorQuery.getString(cursorQuery.getColumnIndex("device_ids_grndid")) : null;
            cursorQuery.close();
        }
        return string;
    }
}
