package com.alipay.sdk.m.p0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {
    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    String b(String str) throws RemoteException;

    /* JADX INFO: renamed from: com.alipay.sdk.m.p0.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0033a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f1903a = "com.samsung.android.deviceidservice.IDeviceIdService";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f1904b = 1;
        public static final int c = 2;
        public static final int d = 3;

        public AbstractBinderC0033a() {
            attachInterface(this, f1903a);
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f1903a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0034a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(f1903a);
                String strA = a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(f1903a);
                String strB = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strB);
                return true;
            }
            if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(f1903a);
                return true;
            }
            parcel.enforceInterface(f1903a);
            String strA2 = a(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(strA2);
            return true;
        }

        /* JADX INFO: renamed from: com.alipay.sdk.m.p0.a$a$a, reason: collision with other inner class name */
        public static class C0034a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f1905a;

            public C0034a(IBinder iBinder) {
                this.f1905a = iBinder;
            }

            @Override // com.alipay.sdk.m.p0.a
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0033a.f1903a);
                    this.f1905a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1905a;
            }

            @Override // com.alipay.sdk.m.p0.a
            public String b(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0033a.f1903a);
                    parcelObtain.writeString(str);
                    this.f1905a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String d() {
                return AbstractBinderC0033a.f1903a;
            }

            @Override // com.alipay.sdk.m.p0.a
            public String a(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0033a.f1903a);
                    parcelObtain.writeString(str);
                    this.f1905a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
