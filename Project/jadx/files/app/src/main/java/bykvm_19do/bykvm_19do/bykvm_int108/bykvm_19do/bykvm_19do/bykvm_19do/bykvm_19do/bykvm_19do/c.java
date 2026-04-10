package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static Cursor a(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        Cursor cursorA;
        synchronized (c.class) {
            cursorA = null;
            if (!TextUtils.isEmpty(str)) {
                try {
                    cursorA = a.a(context).a().a(str, strArr, str2, strArr2, null, null, str5);
                } catch (Throwable unused) {
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("query ignore");
                }
            }
        }
        return cursorA;
    }

    public static void a(Context context, String str) {
        synchronized (c.class) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    a.a(context).a().a(Uri.decode(str));
                } catch (Throwable unused) {
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("execSQL ignore");
                }
            }
        }
    }

    public static void a(Context context, String str, ContentValues contentValues) {
        synchronized (c.class) {
            if (contentValues != null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        a.a(context).a().a(str, null, contentValues);
                    } catch (Throwable unused) {
                        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("insert ignore");
                    }
                }
            }
        }
    }
}
