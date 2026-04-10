package com.umeng.analytics.pro;

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

/* JADX INFO: compiled from: HuaweiDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes4.dex */
class ae implements aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2166a = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
    private static final int b = 1;
    private static final int c = 2;

    ae() {
    }

    @Override // com.umeng.analytics.pro.aa
    public String a(Context context) {
        a aVar = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        if (context.bindService(intent, aVar, 1)) {
            try {
                return new b(aVar.a()).a();
            } catch (Exception unused) {
            } finally {
                context.unbindService(aVar);
            }
        }
        return null;
    }

    /* JADX INFO: compiled from: HuaweiDeviceIdSupplier.java */
    private static final class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f2167a;
        private final LinkedBlockingQueue<IBinder> b;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        private a() {
            this.f2167a = false;
            this.b = new LinkedBlockingQueue<>();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public IBinder a() throws InterruptedException {
            if (this.f2167a) {
                throw new IllegalStateException();
            }
            this.f2167a = true;
            return this.b.poll(5L, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: compiled from: HuaweiDeviceIdSupplier.java */
    private static final class b implements IInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IBinder f2168a;

        public b(IBinder iBinder) {
            this.f2168a = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f2168a;
        }

        public String a() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(ae.f2166a);
                this.f2168a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        public boolean b() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(ae.f2166a);
                this.f2168a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }
}
