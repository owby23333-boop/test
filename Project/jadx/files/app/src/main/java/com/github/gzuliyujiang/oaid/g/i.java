package com.github.gzuliyujiang.oaid.g;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.github.gzuliyujiang.oaid.OAIDException;
import java.util.Objects;

/* JADX INFO: compiled from: MeizuImpl.java */
/* JADX INFO: loaded from: classes2.dex */
class i implements com.github.gzuliyujiang.oaid.d {
    private final Context a;

    public i(Context context) {
        this.a = context;
    }

    @Override // com.github.gzuliyujiang.oaid.d
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
        } catch (Exception e2) {
            com.github.gzuliyujiang.oaid.e.a(e2);
            return false;
        }
    }

    @Override // com.github.gzuliyujiang.oaid.d
    public void a(com.github.gzuliyujiang.oaid.c cVar) {
        if (this.a == null || cVar == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            try {
                ((Cursor) Objects.requireNonNull(cursorQuery)).moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                if (string != null && string.length() != 0) {
                    com.github.gzuliyujiang.oaid.e.a("OAID query success: " + string);
                    cVar.a(string);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                        return;
                    }
                    return;
                }
                throw new OAIDException("OAID query failed");
            } finally {
            }
        } catch (Exception e2) {
            com.github.gzuliyujiang.oaid.e.a(e2);
            cVar.a(e2);
        }
    }
}
