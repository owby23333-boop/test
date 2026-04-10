package com.xiaomi.account.privacy_data.oaid.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.account.privacy_data.oaid.IGetter;
import com.xiaomi.account.privacy_data.oaid.IOAID;
import com.xiaomi.account.privacy_data.oaid.OAIDException;
import com.xiaomi.account.privacy_data.oaid.OAIDLog;
import com.xiaomi.account.privacy_data.oaid.OAIDService;
import repeackage.com.asus.msa.SupplementaryDID.IDidAidlInterface;

/* JADX INFO: loaded from: classes5.dex */
public class AsusImpl implements IOAID {
    private final Context context;

    public AsusImpl(Context context) {
        this.context = context;
    }

    @Override // com.xiaomi.account.privacy_data.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.xiaomi.account.privacy_data.oaid.impl.AsusImpl.1
            @Override // com.xiaomi.account.privacy_data.oaid.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException {
                IDidAidlInterface iDidAidlInterfaceAsInterface = IDidAidlInterface.Stub.asInterface(iBinder);
                if (iDidAidlInterfaceAsInterface == null) {
                    throw new OAIDException("IDidAidlInterface is null");
                }
                if (iDidAidlInterfaceAsInterface.isSupport()) {
                    return iDidAidlInterfaceAsInterface.getOAID();
                }
                throw new OAIDException("IDidAidlInterface#isSupport return false");
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
            return context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
        } catch (Exception e) {
            OAIDLog.print(e);
            return false;
        }
    }
}
