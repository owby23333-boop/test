package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.alipay.sdk.m.v0.a;

/* JADX INFO: loaded from: classes.dex */
public interface tg extends IInterface {
    String bf();

    String bf(String str);

    boolean d();

    String e();

    String e(String str);

    public static abstract class e extends Binder implements tg {
        public static tg e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a.AbstractBinderC0041a.f1962a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof tg)) ? new C0078e(iBinder) : (tg) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(a.AbstractBinderC0041a.f1962a);
                String strE = e();
                parcel2.writeNoException();
                parcel2.writeString(strE);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(a.AbstractBinderC0041a.f1962a);
                String strBf = bf();
                parcel2.writeNoException();
                parcel2.writeString(strBf);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(a.AbstractBinderC0041a.f1962a);
                boolean zD = d();
                parcel2.writeNoException();
                parcel2.writeInt(zD ? 1 : 0);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface(a.AbstractBinderC0041a.f1962a);
                String strE2 = e(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strE2);
                return true;
            }
            if (i != 5) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(a.AbstractBinderC0041a.f1962a);
                return true;
            }
            parcel.enforceInterface(a.AbstractBinderC0041a.f1962a);
            String strBf2 = bf(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(strBf2);
            return true;
        }

        /* JADX INFO: renamed from: com.bytedance.embedapplog.tg$e$e, reason: collision with other inner class name */
        public static class C0078e implements tg {
            private IBinder e;

            public C0078e(IBinder iBinder) {
                this.e = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.e;
            }

            @Override // com.bytedance.embedapplog.tg
            public String bf() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.AbstractBinderC0041a.f1962a);
                    this.e.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.tg
            public boolean d() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.AbstractBinderC0041a.f1962a);
                    this.e.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.tg
            public String e() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.AbstractBinderC0041a.f1962a);
                    this.e.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.tg
            public String bf(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.AbstractBinderC0041a.f1962a);
                    parcelObtain.writeString(str);
                    this.e.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.tg
            public String e(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.AbstractBinderC0041a.f1962a);
                    parcelObtain.writeString(str);
                    this.e.transact(4, parcelObtain, parcelObtain2, 0);
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
