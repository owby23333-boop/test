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
import com.yuewen.km4;
import repeackage.com.google.android.gms.ads.identifier.internal.IAdvertisingIdService;

/* JADX INFO: loaded from: classes5.dex */
public class GmsImpl implements IOAID {
    private final Context context;

    public GmsImpl(Context context) {
        this.context = context;
    }

    @Override // com.xiaomi.account.privacy_data.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.xiaomi.account.privacy_data.oaid.impl.GmsImpl.1
            @Override // com.xiaomi.account.privacy_data.oaid.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException {
                IAdvertisingIdService iAdvertisingIdServiceAsInterface = IAdvertisingIdService.Stub.asInterface(iBinder);
                if (iAdvertisingIdServiceAsInterface.isLimitAdTrackingEnabled(true)) {
                    OAIDLog.print("User has disabled advertising identifier");
                }
                return iAdvertisingIdServiceAsInterface.getId();
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
            return context.getPackageManager().getPackageInfo(km4.v, 0) != null;
        } catch (Exception e) {
            OAIDLog.print(e);
            return false;
        }
    }
}
