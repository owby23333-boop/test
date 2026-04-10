package com.anythink.china.a.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public final class k {
    private Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6337c = false;
    String a = null;

    public k(Context context) {
        this.b = context;
    }

    public final String a() {
        try {
            Cursor cursorQuery = this.b.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (cursorQuery != null) {
                string = cursorQuery.moveToNext() ? cursorQuery.getString(cursorQuery.getColumnIndex("value")) : null;
                cursorQuery.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return string;
    }
}
