package com.kwad.sdk.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ad {
    private static String ayP;
    private static boolean ayQ;

    public static String cn(Context context) {
        if (!TextUtils.isEmpty(ayP) || ayQ || !ar.DN()) {
            return ayP;
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = context.getContentResolver().query(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider"), null, null, null, null);
            ayP = i(cursorQuery);
        } catch (Throwable unused) {
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
        ayQ = TextUtils.isEmpty(ayP);
        return ayP;
    }

    private static String i(Cursor cursor) {
        int columnIndex;
        if (cursor == null || cursor.isClosed()) {
            com.kwad.sdk.core.d.b.i("MiMarketHelper", "cursor is null");
            return "";
        }
        cursor.moveToFirst();
        int columnIndex2 = cursor.getColumnIndex("support");
        return ((columnIndex2 <= 0 || cursor.getInt(columnIndex2) != 0) && (columnIndex = cursor.getColumnIndex("detailStyle")) > 0) ? cursor.getString(columnIndex) : "";
    }
}
