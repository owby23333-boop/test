package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import bykvm_19do.bykvm_19do.bykvm_19do.a1;

/* JADX INFO: loaded from: classes.dex */
final class x0 implements a1 {
    private o0<Boolean> a = new a(this);

    class a extends o0<Boolean> {
        a(x0 x0Var) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // bykvm_19do.bykvm_19do.bykvm_19do.o0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean a(Object... objArr) {
            boolean z2 = false;
            try {
                PackageManager packageManager = ((Context) objArr[0]).getPackageManager();
                if (packageManager != null) {
                    if (packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null) {
                        z2 = true;
                    }
                }
            } catch (Exception unused) {
            }
            return Boolean.valueOf(z2);
        }
    }

    x0() {
    }

    private String a(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("value");
            if (columnIndex >= 0) {
                return cursor.getString(columnIndex);
            }
        }
        return null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.a1
    public boolean a(Context context) {
        if (context == null) {
            return false;
        }
        return this.a.b(context).booleanValue();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.a1
    public a1.a b(Context context) {
        Throwable th;
        Cursor cursorQuery;
        try {
            cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
        if (cursorQuery == null) {
            if (cursorQuery == null) {
                return null;
            }
            return null;
        }
        try {
            a1.a aVar = new a1.a();
            aVar.a = a(cursorQuery);
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return aVar;
        } catch (Throwable th3) {
            th = th3;
            try {
                th.printStackTrace();
                if (cursorQuery == null) {
                    return null;
                }
                return null;
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
    }
}
