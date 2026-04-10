package com.github.gzuliyujiang.oaid.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.github.gzuliyujiang.oaid.IGetter;
import com.github.gzuliyujiang.oaid.IOAID;
import com.github.gzuliyujiang.oaid.OAIDException;
import com.github.gzuliyujiang.oaid.OAIDLog;
import com.github.gzuliyujiang.oaid.OAIDRom;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
class VivoImpl implements IOAID {
    private final Context context;

    public VivoImpl(Context context) {
        this.context = context;
    }

    @Override // com.github.gzuliyujiang.oaid.IOAID
    public boolean supported() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return OAIDRom.sysProperty("persist.sys.identifierid.supported", "0").equals("1");
    }

    @Override // com.github.gzuliyujiang.oaid.IOAID
    public void doGet(final IGetter getter) {
        if (this.context == null || getter == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.context.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            try {
                ((Cursor) Objects.requireNonNull(cursorQuery)).moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                if (string == null || string.length() == 0) {
                    throw new OAIDException("OAID query failed");
                }
                OAIDLog.print("OAID query success: " + string);
                getter.onOAIDGetComplete(string);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } finally {
            }
        } catch (Exception e) {
            OAIDLog.print(e);
            getter.onOAIDGetError(e);
        }
    }
}
