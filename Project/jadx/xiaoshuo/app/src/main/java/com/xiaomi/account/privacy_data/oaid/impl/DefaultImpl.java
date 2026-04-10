package com.xiaomi.account.privacy_data.oaid.impl;

import com.xiaomi.account.privacy_data.oaid.IGetter;
import com.xiaomi.account.privacy_data.oaid.IOAID;
import com.xiaomi.account.privacy_data.oaid.OAIDException;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultImpl implements IOAID {
    @Override // com.xiaomi.account.privacy_data.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (iGetter == null) {
            return;
        }
        iGetter.onOAIDGetError(new OAIDException("Unsupported"));
    }

    @Override // com.xiaomi.account.privacy_data.oaid.IOAID
    public boolean supported() {
        return false;
    }
}
