package t0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: AdvertisingIdClient.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: compiled from: AdvertisingIdClient.java */
    public static final class a {
        public final String a;

        public a(String str, boolean z2) {
            this.a = str;
        }
    }

    /* JADX INFO: renamed from: t0.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdvertisingIdClient.java */
    public static final class ServiceConnectionC0599b implements ServiceConnection {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f21702s = false;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final LinkedBlockingQueue<IBinder> f21703t = new LinkedBlockingQueue<>(1);

        public IBinder a() throws InterruptedException {
            if (this.f21702s) {
                throw new IllegalStateException();
            }
            this.f21702s = true;
            return this.f21703t.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f21703t.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static a a(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            ServiceConnectionC0599b serviceConnectionC0599b = new ServiceConnectionC0599b();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (!context.bindService(intent, serviceConnectionC0599b, 1)) {
                    throw new IOException("Google Play connection failed");
                }
                try {
                    IBinder iBinderA = serviceConnectionC0599b.a();
                    Parcel parcelObtain = Parcel.obtain();
                    Parcel parcelObtain2 = Parcel.obtain();
                    try {
                        parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                        iBinderA.transact(1, parcelObtain, parcelObtain2, 0);
                        parcelObtain2.readException();
                        String string = parcelObtain2.readString();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        parcelObtain = Parcel.obtain();
                        parcelObtain2 = Parcel.obtain();
                        try {
                            parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                            parcelObtain.writeInt(1);
                            iBinderA.transact(2, parcelObtain, parcelObtain2, 0);
                            parcelObtain2.readException();
                            boolean z2 = parcelObtain2.readInt() != 0;
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return new a(string, z2);
                        } finally {
                        }
                    } finally {
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            } finally {
                context.unbindService(serviceConnectionC0599b);
            }
        } catch (Exception e3) {
            throw e3;
        }
    }
}
