package com.umeng.commonsdk.statistics.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: AdvertisingId.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.common.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdvertisingId.java */
    private static final class C0496a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f2330a;
        private final boolean b;

        C0496a(String str, boolean z) {
            this.f2330a = str;
            this.b = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String b() {
            return this.f2330a;
        }

        public boolean a() {
            return this.b;
        }
    }

    public static String a(Context context) {
        try {
            C0496a c0496aC = c(context);
            if (c0496aC != null && !c0496aC.a()) {
                return c0496aC.b();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String b(Context context) {
        try {
            C0496a c0496aC = c(context);
            if (c0496aC == null) {
                return null;
            }
            return c0496aC.b();
        } catch (Exception unused) {
            return null;
        }
    }

    private static C0496a c(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper() || com.umeng.commonsdk.utils.b.a().a(context, "com.android.vending", 0) == null) {
            return null;
        }
        b bVar = new b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        try {
            if (context.bindService(intent, bVar, 1)) {
                try {
                    c cVar = new c(bVar.a());
                    boolean zA = cVar.a(true);
                    return new C0496a(zA ? "" : cVar.a(), zA);
                } catch (Exception e) {
                    throw e;
                }
            }
            throw new IOException("Google Play connection failed");
        } finally {
            context.unbindService(bVar);
        }
    }

    /* JADX INFO: compiled from: AdvertisingId.java */
    private static final class b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f2331a;
        private final LinkedBlockingQueue<IBinder> b;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        private b() {
            this.f2331a = false;
            this.b = new LinkedBlockingQueue<>(1);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public IBinder a() throws InterruptedException {
            if (this.f2331a) {
                throw new IllegalStateException();
            }
            this.f2331a = true;
            return this.b.take();
        }
    }

    /* JADX INFO: compiled from: AdvertisingId.java */
    private static final class c implements IInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IBinder f2332a;

        public c(IBinder iBinder) {
            this.f2332a = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f2332a;
        }

        public String a() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f2332a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        public boolean a(boolean z) throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain.writeInt(z ? 1 : 0);
                this.f2332a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }
}
