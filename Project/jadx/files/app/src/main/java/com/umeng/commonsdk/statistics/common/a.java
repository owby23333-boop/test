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
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.common.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdvertisingId.java */
    private static final class C0553a {
        private final String a;
        private final boolean b;

        C0553a(String str, boolean z2) {
            this.a = str;
            this.b = z2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String b() {
            return this.a;
        }

        public boolean a() {
            return this.b;
        }
    }

    /* JADX INFO: compiled from: AdvertisingId.java */
    private static final class b implements ServiceConnection {
        boolean a;
        private final LinkedBlockingQueue<IBinder> b;

        private b() {
            this.a = false;
            this.b = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() throws InterruptedException {
            if (this.a) {
                throw new IllegalStateException();
            }
            this.a = true;
            return this.b.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static String a(Context context) {
        try {
            C0553a c0553aC = c(context);
            if (c0553aC != null && !c0553aC.a()) {
                return c0553aC.b();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String b(Context context) {
        try {
            C0553a c0553aC = c(context);
            if (c0553aC == null) {
                return null;
            }
            return c0553aC.b();
        } catch (Exception unused) {
            return null;
        }
    }

    private static C0553a c(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        try {
            if (com.umeng.commonsdk.utils.b.a().a(context, "com.android.vending", 0) == null) {
                return null;
            }
            b bVar = new b();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (!context.bindService(intent, bVar, 1)) {
                    throw new IOException("Google Play connection failed");
                }
                try {
                    c cVar = new c(bVar.a());
                    boolean zA = cVar.a(true);
                    return new C0553a(zA ? "" : cVar.a(), zA);
                } catch (Exception e2) {
                    throw e2;
                }
            } finally {
                context.unbindService(bVar);
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    /* JADX INFO: compiled from: AdvertisingId.java */
    private static final class c implements IInterface {
        private IBinder a;

        public c(IBinder iBinder) {
            this.a = iBinder;
        }

        public String a() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.a;
        }

        public boolean a(boolean z2) throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain.writeInt(z2 ? 1 : 0);
                this.a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }
}
