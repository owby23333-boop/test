package com.xiaomi.onetrack.util.oaid.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.alipay.sdk.m.v0.a;

/* JADX INFO: loaded from: classes8.dex */
public interface c extends IInterface {
    String a();

    String a(String str);

    boolean b();

    public static abstract class a extends Binder implements c {
        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a.AbstractBinderC0041a.f1962a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new C0549a(iBinder) : (c) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(a.AbstractBinderC0041a.f1962a);
                String strA = a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(a.AbstractBinderC0041a.f1962a);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(a.AbstractBinderC0041a.f1962a);
                boolean zB = b();
                parcel2.writeNoException();
                parcel2.writeInt(zB ? 1 : 0);
                return true;
            }
            if (i != 4) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(a.AbstractBinderC0041a.f1962a);
            String strA2 = a(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(strA2);
            return true;
        }

        /* JADX INFO: renamed from: com.xiaomi.onetrack.util.oaid.a.c$a$a, reason: collision with other inner class name */
        public static class C0549a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f7727a;

            public C0549a(IBinder iBinder) {
                this.f7727a = iBinder;
            }

            @Override // com.xiaomi.onetrack.util.oaid.a.c
            public String a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    try {
                        parcelObtain.writeInterfaceToken(a.AbstractBinderC0041a.f1962a);
                        this.f7727a.transact(1, parcelObtain, parcelObtain2, 0);
                        parcelObtain2.readException();
                        return parcelObtain2.readString();
                    } catch (Exception e) {
                        e.printStackTrace();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return null;
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return null;
            }

            @Override // com.xiaomi.onetrack.util.oaid.a.c
            public boolean b() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.AbstractBinderC0041a.f1962a);
                    this.f7727a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    z = parcelObtain2.readInt() != 0;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable unused) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
                return z;
            }

            @Override // com.xiaomi.onetrack.util.oaid.a.c
            public String a(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    try {
                        parcelObtain.writeInterfaceToken(a.AbstractBinderC0041a.f1962a);
                        this.f7727a.transact(4, parcelObtain, parcelObtain2, 0);
                        parcelObtain2.readException();
                        return parcelObtain2.readString();
                    } catch (Exception e) {
                        e.printStackTrace();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return null;
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
