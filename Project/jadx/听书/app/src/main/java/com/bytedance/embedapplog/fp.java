package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.embedapplog.gm;

/* JADX INFO: loaded from: classes2.dex */
final class fp implements gm {
    private bm<Boolean> z = new bm<Boolean>() { // from class: com.bytedance.embedapplog.fp.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.bm
        /* JADX INFO: renamed from: dl, reason: merged with bridge method [inline-methods] */
        public Boolean z(Object... objArr) {
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

    fp() {
    }

    @Override // com.bytedance.embedapplog.gm
    public boolean z(Context context) {
        if (context == null) {
            return false;
        }
        return this.z.g(context).booleanValue();
    }

    @Override // com.bytedance.embedapplog.gm
    public gm.z g(Context context) {
        Cursor cursorQuery;
        try {
            cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            if (cursorQuery == null) {
                return null;
            }
            try {
                gm.z zVar = new gm.z();
                zVar.g = z(cursorQuery);
                return zVar;
            } catch (Throwable th) {
                th = th;
                try {
                    cb.z(th);
                    return null;
                } finally {
                    o.z(cursorQuery);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    private String z(Cursor cursor) {
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
}
