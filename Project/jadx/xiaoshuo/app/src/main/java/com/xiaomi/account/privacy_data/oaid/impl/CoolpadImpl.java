package com.xiaomi.account.privacy_data.oaid.impl;

import android.app.Application;
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
import repeackage.com.coolpad.deviceidsupport.IDeviceIdManager;

/* JADX INFO: loaded from: classes5.dex */
public class CoolpadImpl implements IOAID {
    private final Context context;

    public CoolpadImpl(Context context) {
        if (context instanceof Application) {
            this.context = context;
        } else {
            this.context = context.getApplicationContext();
        }
    }

    @Override // com.xiaomi.account.privacy_data.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.xiaomi.account.privacy_data.oaid.impl.CoolpadImpl.1
            @Override // com.xiaomi.account.privacy_data.oaid.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException {
                IDeviceIdManager iDeviceIdManagerAsInterface = IDeviceIdManager.Stub.asInterface(iBinder);
                if (iDeviceIdManagerAsInterface != null) {
                    return iDeviceIdManagerAsInterface.getOAID(CoolpadImpl.this.context.getPackageName());
                }
                throw new OAIDException("IDeviceIdManager is null");
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
            return context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null;
        } catch (Exception e) {
            OAIDLog.print(e);
            return false;
        }
    }
}
