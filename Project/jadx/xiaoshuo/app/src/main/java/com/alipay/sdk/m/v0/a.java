package com.alipay.sdk.m.v0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {
    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    String b() throws RemoteException;

    String b(String str) throws RemoteException;

    boolean c() throws RemoteException;

    boolean c(String str) throws RemoteException;

    /* JADX INFO: renamed from: com.alipay.sdk.m.v0.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0041a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f1962a = "com.zui.deviceidservice.IDeviceidInterface";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f1963b = 1;
        public static final int c = 2;
        public static final int d = 3;
        public static final int e = 4;
        public static final int f = 5;
        public static final int g = 6;

        public AbstractBinderC0041a() {
            attachInterface(this, f1962a);
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f1962a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0042a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(f1962a);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(f1962a);
                    String strA = a();
                    parcel2.writeNoException();
                    parcel2.writeString(strA);
                    return true;
                case 2:
                    parcel.enforceInterface(f1962a);
                    String strB = b();
                    parcel2.writeNoException();
                    parcel2.writeString(strB);
                    return true;
                case 3:
                    parcel.enforceInterface(f1962a);
                    boolean zC = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(zC ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(f1962a);
                    String strB2 = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strB2);
                    return true;
                case 5:
                    parcel.enforceInterface(f1962a);
                    String strA2 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strA2);
                    return true;
                case 6:
                    parcel.enforceInterface(f1962a);
                    boolean zC2 = c(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zC2 ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.alipay.sdk.m.v0.a$a$a, reason: collision with other inner class name */
        public static class C0042a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f1964a;

            public C0042a(IBinder iBinder) {
                this.f1964a = iBinder;
            }

            @Override // com.alipay.sdk.m.v0.a
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0041a.f1962a);
                    this.f1964a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1964a;
            }

            @Override // com.alipay.sdk.m.v0.a
            public String b() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0041a.f1962a);
                    this.f1964a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alipay.sdk.m.v0.a
            public boolean c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0041a.f1962a);
                    this.f1964a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String d() {
                return AbstractBinderC0041a.f1962a;
            }

            @Override // com.alipay.sdk.m.v0.a
            public String a(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0041a.f1962a);
                    parcelObtain.writeString(str);
                    this.f1964a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alipay.sdk.m.v0.a
            public String b(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0041a.f1962a);
                    parcelObtain.writeString(str);
                    this.f1964a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alipay.sdk.m.v0.a
            public boolean c(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0041a.f1962a);
                    parcelObtain.writeString(str);
                    this.f1964a.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
