package ms.bz.bd.c.Pgl;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.google.common.base.Ascii;
import kotlin.io.encoding.Base64;
import ms.bz.bd.c.Pgl.u0;
import okio.Utf8;

/* JADX INFO: loaded from: classes9.dex */
public class x0 {
    private final Context e;

    public x0(Context context) {
        this.e = context;
    }

    private String e(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex((String) pblk.a(16777217, 0, 0L, "52f68c", new byte[]{50, 49, Ascii.EM, 87, 2}));
        String string = columnIndex > 0 ? cursor.getString(columnIndex) : null;
        int columnIndex2 = cursor.getColumnIndex((String) pblk.a(16777217, 0, 0L, "5260ca", new byte[]{39, Utf8.REPLACEMENT_BYTE, 65, 65}));
        if (columnIndex2 > 0) {
            cursor.getInt(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex((String) pblk.a(16777217, 0, 0L, "e4286c", new byte[]{113, 46, 81, 69, Ascii.ESC, 113, 98}));
        if (columnIndex3 > 0) {
            cursor.getLong(columnIndex3);
        }
        return string;
    }

    public void e(u0.pblb pblbVar) {
        Cursor cursorQuery;
        try {
            this.e.getPackageManager().getPackageInfo((String) pblk.a(16777217, 0, 0L, "485490", new byte[]{38, 53, 75, Ascii.SO, Ascii.VT, 34, 62, 3, 113, 42, 35, 54, 95, 77, 3, 105, 56, 9, 97, 106, 44, 62, 85, 68, Ascii.CR}), 0);
        } catch (Exception unused) {
        }
        Uri uri = Uri.parse((String) pblk.a(16777217, 0, 0L, "d0cccd", new byte[]{118, Base64.padSymbol, Ascii.RS, 3, 89, 125, 115, 75, 125, 124, 118, Base64.padSymbol, Ascii.GS, 89, 81, 118, 110, Ascii.VT, 39, 125, 115, 62, 9, Ascii.SUB, 89, Base64.padSymbol, 104, 1, 55, Base64.padSymbol, 124, 54, 3, 19, 87, 60}));
        ContentResolver contentResolver = this.e.getContentResolver();
        try {
            String[] strArr = new String[1];
            strArr[0] = (String) pblk.a(16777217, 0, 0L, "6120a0", new byte[]{40, 50, 72, 64});
            cursorQuery = contentResolver.query(uri, null, null, strArr, null);
            try {
                String strE = e(cursorQuery);
                if (pblbVar != null) {
                    pblbVar.e(strE);
                }
                if (cursorQuery == null) {
                    return;
                }
            } catch (Throwable unused2) {
                if (cursorQuery == null) {
                    return;
                }
            }
        } catch (Throwable unused3) {
            cursorQuery = null;
        }
        cursorQuery.close();
    }
}
