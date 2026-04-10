package com.repack.bun.miitmdid.supplier.sumsung;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Keep;
import k0.a;
import v.c;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class SumsungCore {
    private static boolean DBG = false;
    private static String SAMSUNGTAG = "Samsung_DeviceIdService";
    private static String TAG = "SumsungCore library";
    private e.a mCallerCallBack;
    private ServiceConnection mConnection;
    private Context mContext;
    private k0.a mDeviceidInterface;

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            k0.a c0572a;
            SumsungCore sumsungCore = SumsungCore.this;
            int i2 = a.AbstractBinderC0571a.f20928s;
            if (iBinder == null) {
                c0572a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                c0572a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof k0.a)) ? new a.AbstractBinderC0571a.C0572a(iBinder) : (k0.a) iInterfaceQueryLocalInterface;
            }
            sumsungCore.mDeviceidInterface = c0572a;
            if (SumsungCore.this.mCallerCallBack != null) {
                SumsungCore.this.mCallerCallBack.a(true);
            }
            c.a(SumsungCore.TAG, "Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            SumsungCore.this.mDeviceidInterface = null;
            c.a(SumsungCore.TAG, "Service onServiceDisconnected");
        }
    }

    public SumsungCore(Context context, e.a aVar) {
        this.mCallerCallBack = null;
        this.mContext = null;
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.mContext = context;
        this.mCallerCallBack = aVar;
        this.mConnection = new a();
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (this.mContext.bindService(intent, this.mConnection, 1)) {
            c.a(TAG, "bindService Successful!");
            return;
        }
        this.mContext.unbindService(this.mConnection);
        c.a(TAG, "bindService Failed!");
        e.a aVar2 = this.mCallerCallBack;
        if (aVar2 != null) {
            aVar2.d();
        }
    }

    public String getAAID() {
        Context context = this.mContext;
        if (context == null) {
            c.a(TAG, "Context is null.");
            throw new IllegalArgumentException("Context is null, must be new SumsungCore first");
        }
        String packageName = context.getPackageName();
        c.a(TAG, "liufeng, getAAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            c.a(TAG, "input package is null!");
            return null;
        }
        try {
            if (this.mDeviceidInterface == null) {
                return null;
            }
            String str = "getAAID Package: " + packageName;
            return this.mDeviceidInterface.getAAID(packageName);
        } catch (RemoteException unused) {
            c.a(TAG, "getAAID error, RemoteException!");
            return null;
        }
    }

    public String getOAID() {
        if (this.mContext == null) {
            c.b(TAG, "Context is null.");
            throw new IllegalArgumentException("Context is null, must be new SumsungCore first");
        }
        try {
            if (this.mDeviceidInterface != null) {
                return this.mDeviceidInterface.getOAID();
            }
            return null;
        } catch (RemoteException e2) {
            c.b(TAG, "getOAID error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
    }

    public String getUDID() {
        return "";
    }

    public String getVAID() {
        Context context = this.mContext;
        if (context == null) {
            c.a(TAG, "Context is null.");
            throw new IllegalArgumentException("Context is null, must be new SumsungCore first");
        }
        String packageName = context.getPackageName();
        c.a(TAG, "liufeng, getVAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            c.a(TAG, "input package is null!");
            return null;
        }
        try {
            if (this.mDeviceidInterface == null) {
                return null;
            }
            String str = "getVAID Package: " + packageName;
            return this.mDeviceidInterface.getVAID(packageName);
        } catch (RemoteException e2) {
            c.a(TAG, "getVAID error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
    }

    public boolean isSupported() {
        try {
            if (this.mDeviceidInterface == null) {
                return false;
            }
            c.a(TAG, "Device support opendeviceid");
            return true;
        } catch (Exception unused) {
            c.a(TAG, "isSupport error, RemoteException!");
            return false;
        }
    }

    public void shutdown() {
        try {
            this.mContext.unbindService(this.mConnection);
            c.a(TAG, "unBind Service successful");
        } catch (IllegalArgumentException unused) {
            c.a(TAG, "unBind Service exception");
        }
        this.mDeviceidInterface = null;
    }
}
