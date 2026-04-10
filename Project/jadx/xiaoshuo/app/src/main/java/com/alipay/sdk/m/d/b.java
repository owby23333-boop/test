package com.alipay.sdk.m.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.alipay.sdk.m.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1793a = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f1794b = 1;
    public static final int c = 2;

    /* JADX INFO: renamed from: com.alipay.sdk.m.d.b$b, reason: collision with other inner class name */
    public static final class ServiceConnectionC0028b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinkedBlockingQueue<IBinder> f1796b;

        public ServiceConnectionC0028b() {
            this.f1795a = false;
            this.f1796b = new LinkedBlockingQueue<>();
        }

        public IBinder a() throws InterruptedException {
            if (this.f1795a) {
                throw new IllegalStateException();
            }
            this.f1795a = true;
            return this.f1796b.poll(5L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f1796b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static final class c implements IInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public IBinder f1797a;

        public c(IBinder iBinder) {
            this.f1797a = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f1797a;
        }

        public String d() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(b.f1793a);
                this.f1797a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        public boolean e() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(b.f1793a);
                this.f1797a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    @Override // com.alipay.sdk.m.c.b
    public String a(Context context) {
        ServiceConnectionC0028b serviceConnectionC0028b = new ServiceConnectionC0028b();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        if (context.bindService(intent, serviceConnectionC0028b, 1)) {
            try {
                return new c(serviceConnectionC0028b.a()).d();
            } catch (Exception unused) {
            } finally {
                context.unbindService(serviceConnectionC0028b);
            }
        }
        return null;
    }
}
