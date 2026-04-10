package com.github.gzuliyujiang.oaid.impl;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.github.gzuliyujiang.oaid.IGetter;
import com.github.gzuliyujiang.oaid.OAIDException;
import com.github.gzuliyujiang.oaid.OAIDLog;

/* JADX INFO: loaded from: classes3.dex */
class OAIDService implements ServiceConnection {
    private final RemoteCaller caller;
    private final Context context;
    private final IGetter getter;

    @FunctionalInterface
    public interface RemoteCaller {
        String callRemoteInterface(IBinder binder) throws OAIDException, RemoteException;
    }

    public static void bind(Context context, Intent intent, IGetter getter, RemoteCaller caller) {
        new OAIDService(context, getter, caller).bind(intent);
    }

    private OAIDService(Context context, IGetter getter, RemoteCaller caller) {
        if (context instanceof Application) {
            this.context = context;
        } else {
            this.context = context.getApplicationContext();
        }
        this.getter = getter;
        this.caller = caller;
    }

    private void bind(Intent intent) {
        try {
            if (!this.context.bindService(intent, this, 1)) {
                throw new OAIDException("Service binding failed");
            }
            OAIDLog.print("Service has been bound: " + intent);
        } catch (Exception e) {
            this.getter.onOAIDGetError(e);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName name, IBinder service) {
        OAIDLog.print("Service has been connected: " + name.getClassName());
        try {
            try {
                try {
                    String strCallRemoteInterface = this.caller.callRemoteInterface(service);
                    if (strCallRemoteInterface == null || strCallRemoteInterface.length() == 0) {
                        throw new OAIDException("OAID/AAID acquire failed");
                    }
                    OAIDLog.print("OAID/AAID acquire success: " + strCallRemoteInterface);
                    this.getter.onOAIDGetComplete(strCallRemoteInterface);
                    this.context.unbindService(this);
                    OAIDLog.print("Service has been unbound: " + name.getClassName());
                } catch (Exception e) {
                    OAIDLog.print(e);
                    this.getter.onOAIDGetError(e);
                    this.context.unbindService(this);
                    OAIDLog.print("Service has been unbound: " + name.getClassName());
                }
            } catch (Exception e2) {
                OAIDLog.print(e2);
            }
        } catch (Throwable th) {
            try {
                this.context.unbindService(this);
                OAIDLog.print("Service has been unbound: " + name.getClassName());
            } catch (Exception e3) {
                OAIDLog.print(e3);
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName name) {
        OAIDLog.print("Service has been disconnected: " + name.getClassName());
    }
}
