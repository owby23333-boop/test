package com.anythink.core.common.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    public final class a {
        private final String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f6773c;

        a(String str, boolean z2) {
            this.b = str;
            this.f6773c = z2;
        }

        private boolean b() {
            return this.f6773c;
        }

        public final String a() {
            return this.b;
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.b.c$c, reason: collision with other inner class name */
    private final class C0160c implements IInterface {
        private IBinder b;

        public C0160c(IBinder iBinder) {
            this.b = iBinder;
        }

        public final String a() {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.b.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.b;
        }

        public final boolean b() {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain.writeInt(1);
                this.b.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    public final a a(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        try {
            byte b2 = 0;
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            b bVar = new b(this, b2);
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            if (listQueryIntentServices == null || listQueryIntentServices.size() <= 0 || !context.bindService(intent, bVar, 1)) {
                throw new IOException("Google Play connection failed");
            }
            try {
                C0160c c0160c = new C0160c(bVar.a());
                return new a(c0160c.a(), c0160c.b());
            } finally {
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final class b implements ServiceConnection {
        boolean a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f6774c;

        private b() {
            this.a = false;
            this.f6774c = new LinkedBlockingQueue<>(1);
        }

        public final IBinder a() {
            if (this.a) {
                throw new IllegalStateException();
            }
            this.a = true;
            return this.f6774c.take();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f6774c.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }

        /* synthetic */ b(c cVar, byte b) {
            this();
        }
    }
}
