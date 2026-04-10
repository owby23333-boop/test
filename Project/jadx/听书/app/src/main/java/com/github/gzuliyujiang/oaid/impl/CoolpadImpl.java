package com.github.gzuliyujiang.oaid.impl;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.github.gzuliyujiang.oaid.IGetter;
import com.github.gzuliyujiang.oaid.IOAID;
import com.github.gzuliyujiang.oaid.OAIDException;
import com.github.gzuliyujiang.oaid.OAIDLog;
import com.github.gzuliyujiang.oaid.impl.OAIDService;
import repeackage.com.coolpad.deviceidsupport.IDeviceIdManager;

/* JADX INFO: loaded from: classes3.dex */
public class CoolpadImpl implements IOAID {
    private final Context context;

    public CoolpadImpl(Context context) {
        if (context instanceof Application) {
            this.context = context;
        } else {
            this.context = context.getApplicationContext();
        }
    }

    @Override // com.github.gzuliyujiang.oaid.IOAID
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

    @Override // com.github.gzuliyujiang.oaid.IOAID
    public void doGet(final IGetter getter) {
        if (this.context == null || getter == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        OAIDService.bind(this.context, intent, getter, new OAIDService.RemoteCaller() { // from class: com.github.gzuliyujiang.oaid.impl.CoolpadImpl.1
            @Override // com.github.gzuliyujiang.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder service) throws OAIDException, RemoteException {
                IDeviceIdManager iDeviceIdManagerAsInterface = IDeviceIdManager.Stub.asInterface(service);
                if (iDeviceIdManagerAsInterface != null) {
                    return iDeviceIdManagerAsInterface.getOAID(CoolpadImpl.this.context.getPackageName());
                }
                throw new OAIDException("IDeviceIdManager is null");
            }
        });
    }
}
