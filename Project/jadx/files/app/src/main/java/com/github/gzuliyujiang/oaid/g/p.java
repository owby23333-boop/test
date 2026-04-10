package com.github.gzuliyujiang.oaid.g;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.github.gzuliyujiang.oaid.OAIDException;
import java.util.Objects;

/* JADX INFO: compiled from: VivoImpl.java */
/* JADX INFO: loaded from: classes2.dex */
class p implements com.github.gzuliyujiang.oaid.d {
    private final Context a;

    public p(Context context) {
        this.a = context;
    }

    @Override // com.github.gzuliyujiang.oaid.d
    public boolean a() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return com.github.gzuliyujiang.oaid.f.a("persist.sys.identifierid.supported", "0").equals("1");
    }

    @Override // com.github.gzuliyujiang.oaid.d
    public void a(com.github.gzuliyujiang.oaid.c cVar) {
        if (this.a == null || cVar == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
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
