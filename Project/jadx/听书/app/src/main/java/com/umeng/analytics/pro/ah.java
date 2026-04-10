package com.umeng.analytics.pro;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: compiled from: NubiaDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes4.dex */
class ah implements aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2170a = "content://cn.nubia.provider.deviceid.dataid/oaid";

    ah() {
    }

    @Override // com.umeng.analytics.pro.aa
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse(f2170a), null, null, null, null);
        if (cursorQuery != null) {
            string = cursorQuery.moveToNext() ? cursorQuery.getString(cursorQuery.getColumnIndex("device_ids_grndid")) : null;
            cursorQuery.close();
        }
        return string;
    }
}
