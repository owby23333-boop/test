package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.embedapplog.rk;

/* JADX INFO: loaded from: classes.dex */
final class lg implements rk {
    private ev<Boolean> e = new ev<Boolean>() { // from class: com.bytedance.embedapplog.lg.1
        @Override // com.bytedance.embedapplog.ev
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Boolean e(Object... objArr) {
            try {
                PackageManager packageManager = ((Context) objArr[0]).getPackageManager();
                if (packageManager != null) {
                    return Boolean.valueOf(packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null);
                }
            } catch (Exception unused) {
            }
            return Boolean.FALSE;
        }
    };

    private String e(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("value");
        if (columnIndex >= 0) {
            return cursor.getString(columnIndex);
        }
        return null;
    }

    @Override // com.bytedance.embedapplog.rk
    public boolean bf(Context context) {
        if (context == null) {
            return false;
        }
        return this.e.bf(context).booleanValue();
    }

    @Override // com.bytedance.embedapplog.rk
    public rk.e d(Context context) {
        Cursor cursorQuery;
        try {
            cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            if (cursorQuery == null) {
                return null;
            }
            try {
                rk.e eVar = new rk.e();
                eVar.bf = e(cursorQuery);
                return eVar;
            } catch (Throwable th) {
                th = th;
                try {
                    tx.e(th);
                    return null;
                } finally {
                    pl.e(cursorQuery);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }
}
