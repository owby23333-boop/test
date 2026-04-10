package com.umeng.analytics.pro;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: compiled from: NubiaDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes3.dex */
class ag implements z {
    private static final String a = "content://cn.nubia.provider.deviceid.dataid/oaid";

    ag() {
    }

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse(a), null, null, null, null);
        if (cursorQuery != null) {
            string = cursorQuery.moveToNext() ? cursorQuery.getString(cursorQuery.getColumnIndex("device_ids_grndid")) : null;
            cursorQuery.close();
        }
        return string;
    }
}
