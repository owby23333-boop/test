package com.kwad.sdk.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class am {
    private static String aZP;
    private static boolean aZQ;

    public static String dc(Context context) {
        Cursor cursorQuery;
        if (!TextUtils.isEmpty(aZP) || aZQ || !bb.Rl()) {
            return aZP;
        }
        try {
            cursorQuery = context.getContentResolver().query(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider"), null, null, null, null);
            try {
                aZP = j(cursorQuery);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
        aZQ = TextUtils.isEmpty(aZP);
        return aZP;
    }

    private static String j(Cursor cursor) {
        int columnIndex;
        if (cursor == null || cursor.isClosed()) {
            com.kwad.sdk.core.d.c.i("MiMarketHelper", "cursor is null");
            return "";
        }
        cursor.moveToFirst();
        int columnIndex2 = cursor.getColumnIndex("support");
        return ((columnIndex2 <= 0 || cursor.getInt(columnIndex2) != 0) && (columnIndex = cursor.getColumnIndex("detailStyle")) > 0) ? cursor.getString(columnIndex) : "";
    }

    public static boolean dd(Context context) {
        Cursor cursorQuery;
        boolean zK = false;
        if (!bb.Rl()) {
            return false;
        }
        try {
            cursorQuery = context.getContentResolver().query(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider"), null, null, null, null);
            try {
                zK = k(cursorQuery);
            } catch (Throwable unused) {
                try {
                    com.kwad.sdk.core.d.c.e("MiMarketHelper", "isSupportMiMarket2 failed");
                } finally {
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
                }
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        if (!zK && bb.Rl()) {
            com.kwad.sdk.core.d.c.i("MiMarketHelper", "is Miui but not support MiMarket2.0");
        }
        return zK;
    }

    private static boolean k(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            com.kwad.sdk.core.d.c.i("MiMarketHelper", "isSupportMiMarket2: cursor is null");
            return false;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("support");
        if (columnIndex >= 0) {
            return cursor.getString(columnIndex).equals("true");
        }
        return false;
    }

    public static boolean gY(String str) {
        return str.startsWith("market://details") || str.startsWith("mimarket://details");
    }
}
