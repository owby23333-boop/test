package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.alipay.sdk.m.p0.a;

/* JADX INFO: loaded from: classes.dex */
public interface d extends IInterface {
    String bf(String str);

    String e();

    String e(String str);

    public static abstract class e extends Binder implements d {
        public static d e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a.AbstractBinderC0033a.f1903a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof d)) ? new C0075e(iBinder) : (d) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(a.AbstractBinderC0033a.f1903a);
                String strE = e();
                parcel2.writeNoException();
                parcel2.writeString(strE);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(a.AbstractBinderC0033a.f1903a);
                String strE2 = e(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strE2);
                return true;
            }
            if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(a.AbstractBinderC0033a.f1903a);
                return true;
            }
            parcel.enforceInterface(a.AbstractBinderC0033a.f1903a);
            String strBf = bf(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(strBf);
            return true;
        }

        /* JADX INFO: renamed from: com.bytedance.embedapplog.d$e$e, reason: collision with other inner class name */
        public static class C0075e implements d {
            private IBinder e;

            public C0075e(IBinder iBinder) {
                this.e = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.e;
            }

            @Override // com.bytedance.embedapplog.d
            public String bf(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.AbstractBinderC0033a.f1903a);
                    parcelObtain.writeString(str);
                    this.e.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.d
            public String e() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.AbstractBinderC0033a.f1903a);
                    this.e.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.d
            public String e(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.AbstractBinderC0033a.f1903a);
                    parcelObtain.writeString(str);
                    this.e.transact(2, parcelObtain, parcelObtain2, 0);
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
