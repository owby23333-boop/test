package com.xiaomi.account.privacy_data.oaid.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import com.xiaomi.account.privacy_data.oaid.IGetter;
import com.xiaomi.account.privacy_data.oaid.IOAID;
import com.xiaomi.account.privacy_data.oaid.OAIDException;
import com.xiaomi.account.privacy_data.oaid.OAIDLog;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes5.dex */
public class XiaomiImpl implements IOAID {
    private final Context context;
    private Class<?> idProviderClass;
    private Object idProviderImpl;

    @SuppressLint({"PrivateApi"})
    public XiaomiImpl(Context context) {
        this.context = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.idProviderClass = cls;
            this.idProviderImpl = cls.newInstance();
        } catch (Exception e) {
            OAIDLog.print(e);
        }
    }

    private String getOAID() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return (String) this.idProviderClass.getMethod("getOAID", Context.class).invoke(this.idProviderImpl, this.context);
    }

    @Override // com.xiaomi.account.privacy_data.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        if (this.idProviderClass == null || this.idProviderImpl == null) {
            iGetter.onOAIDGetError(new OAIDException("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            String oaid = getOAID();
            if (oaid == null || oaid.length() == 0) {
                throw new OAIDException("OAID query failed");
            }
            OAIDLog.print("OAID query success: " + oaid);
            iGetter.onOAIDGetComplete(oaid);
        } catch (Exception e) {
            OAIDLog.print(e);
            iGetter.onOAIDGetError(e);
        }
    }

    @Override // com.xiaomi.account.privacy_data.oaid.IOAID
    public boolean supported() {
        return this.idProviderImpl != null;
    }
}
