package com.xiaomi.account.privacy_data.oaid.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.alipay.sdk.m.u0.c;
import com.xiaomi.account.privacy_data.oaid.IGetter;
import com.xiaomi.account.privacy_data.oaid.IOAID;
import com.xiaomi.account.privacy_data.oaid.OAIDException;
import com.xiaomi.account.privacy_data.oaid.OAIDLog;
import com.xiaomi.account.privacy_data.oaid.OAIDRom;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class VivoImpl implements IOAID {
    private final Context context;

    public VivoImpl(Context context) {
        this.context = context;
    }

    @Override // com.xiaomi.account.privacy_data.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.context.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            try {
                Objects.requireNonNull(cursorQuery);
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                if (string == null || string.length() == 0) {
                    throw new OAIDException("OAID query failed");
                }
                OAIDLog.print("OAID query success: " + string);
                iGetter.onOAIDGetComplete(string);
                cursorQuery.close();
            } finally {
            }
        } catch (Exception e) {
            OAIDLog.print(e);
            iGetter.onOAIDGetError(e);
        }
    }

    @Override // com.xiaomi.account.privacy_data.oaid.IOAID
    public boolean supported() {
        return OAIDRom.sysProperty(c.c, "0").equals("1");
    }
}
