package com.xiaomi.account.privacy_data.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.account.privacy_data.oaid.IGetter;
import com.xiaomi.account.privacy_data.oaid.IOAID;
import com.xiaomi.account.privacy_data.oaid.OAIDException;
import com.xiaomi.account.privacy_data.oaid.OAIDLog;
import com.xiaomi.account.privacy_data.oaid.OAIDService;
import repeackage.com.android.creator.IdsSupplier;

/* JADX INFO: loaded from: classes5.dex */
public class FreemeImpl implements IOAID {
    private final Context context;

    public FreemeImpl(Context context) {
        this.context = context;
    }

    @Override // com.xiaomi.account.privacy_data.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent("android.service.action.msa");
        intent.setPackage("com.android.creator");
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.xiaomi.account.privacy_data.oaid.impl.FreemeImpl.1
            @Override // com.xiaomi.account.privacy_data.oaid.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException {
                IdsSupplier idsSupplierAsInterface = IdsSupplier.Stub.asInterface(iBinder);
                if (idsSupplierAsInterface != null) {
                    return idsSupplierAsInterface.getOAID();
                }
                throw new OAIDException("IdsSupplier is null");
            }
        });
    }

    @Override // com.xiaomi.account.privacy_data.oaid.IOAID
    public boolean supported() {
        Context context = this.context;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
        } catch (Exception e) {
            OAIDLog.print(e);
            return false;
        }
    }
}
