package com.repack.bun.miitmdid.supplier.msa;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Keep;
import v.a;
import v.c;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class MsaClient {
    private static String TAG = "MSA Client library";
    private static String TARGET_PACKAGE = "com.mdid.msa";
    private e.a _BindService;
    private ServiceConnection mConnection;
    private Context mContext;
    private v.a mDeviceidInterface;

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final e.a f17843s;

        public a(e.a aVar) {
            this.f17843s = aVar;
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            v.a c0601a;
            MsaClient msaClient = MsaClient.this;
            int i2 = a.AbstractBinderC0600a.f21719s;
            if (iBinder == null) {
                c0601a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
                c0601a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof v.a)) ? new a.AbstractBinderC0600a.C0601a(iBinder) : (v.a) iInterfaceQueryLocalInterface;
            }
            msaClient.mDeviceidInterface = c0601a;
            new m0.a(MsaClient.this.mDeviceidInterface, this.f17843s).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            c.a(MsaClient.TAG, "Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            MsaClient.this.mDeviceidInterface = null;
            c.a(MsaClient.TAG, "Service onServiceDisconnected");
            MsaClient.this.mDeviceidInterface = null;
        }
    }

    public MsaClient(Context context, e.a aVar) {
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.mContext = context;
        this._BindService = aVar;
        this.mConnection = new a(aVar);
    }

    public static boolean CheckService(Context context) {
        try {
            context.getPackageManager().getPackageInfo(TARGET_PACKAGE, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void StartMsaKlService(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName(TARGET_PACKAGE, "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            if (context.startService(intent) == null) {
                c.b(TAG, "start msa kl service error");
            }
        } catch (Exception e2) {
            c.b(TAG, "start msa kl service exception", e2);
        }
    }

    public void BindService(String str) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        if (this.mContext.bindService(intent, this.mConnection, 1)) {
            c.a(TAG, "bindService Successful!");
            return;
        }
        e.a aVar = this._BindService;
        if (aVar != null) {
            aVar.d();
        }
        c.a(TAG, "bindService Failed!");
    }

    public String getAAID() {
        try {
            v.a aVar = this.mDeviceidInterface;
            return aVar != null ? aVar.getAAID() : "";
        } catch (RemoteException unused) {
            c.a(TAG, "getAAID error, RemoteException!");
            return "";
        }
    }

    public String getOAID() {
        try {
            v.a aVar = this.mDeviceidInterface;
            return aVar != null ? aVar.getOAID() : "";
        } catch (RemoteException e2) {
            c.b(TAG, "getOAID error, RemoteException!");
            e2.printStackTrace();
            return "";
        }
    }

    public String getUDID() {
        return "";
    }

    public String getVAID() {
        try {
            v.a aVar = this.mDeviceidInterface;
            return aVar != null ? aVar.getVAID() : "";
        } catch (RemoteException unused) {
            c.a(TAG, "getVAID error, RemoteException!");
            return "";
        }
    }

    public boolean isSupported() {
        try {
            if (this.mDeviceidInterface == null) {
                return false;
            }
            c.a(TAG, "Device support opendeviceid");
            return this.mDeviceidInterface.isSupported();
        } catch (Exception unused) {
            c.a(TAG, "isSupport error, RemoteException!");
            return false;
        }
    }

    public void shutdown() {
        v.a aVar = this.mDeviceidInterface;
        if (aVar != null) {
            try {
                aVar.shutDown();
                ServiceConnection serviceConnection = this.mConnection;
                if (serviceConnection != null) {
                    this.mContext.unbindService(serviceConnection);
                }
                c.a(TAG, "unBind Service successful");
            } catch (Exception unused) {
                c.a(TAG, "unBind Service exception");
            } catch (Throwable th) {
                this.mConnection = null;
                this.mDeviceidInterface = null;
                throw th;
            }
            this.mConnection = null;
            this.mDeviceidInterface = null;
        }
    }
}
