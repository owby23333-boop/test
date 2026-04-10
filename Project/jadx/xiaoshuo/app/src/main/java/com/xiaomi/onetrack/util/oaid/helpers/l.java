package com.xiaomi.onetrack.util.oaid.helpers;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.xiaomi.onetrack.util.p;

/* JADX INFO: loaded from: classes8.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7761a = "VivoDeviceIDHelper";

    public String a(Context context) {
        String string;
        string = "";
        try {
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (cursorQuery != null) {
                string = cursorQuery.moveToNext() ? cursorQuery.getString(cursorQuery.getColumnIndex("value")) : "";
                cursorQuery.close();
            }
        } catch (Exception e) {
            p.a(f7761a, e.getMessage());
        }
        return string;
    }
}
