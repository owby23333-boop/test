package com.kwad.sdk.core.e.kwai;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    private Context mContext;

    public h(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        String string = "";
        Cursor cursorQuery = null;
        try {
            cursorQuery = this.mContext.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToNext()) {
                string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                new StringBuilder("getOAID oaid:").append(string);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
            throw th;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
        return string;
    }
}
