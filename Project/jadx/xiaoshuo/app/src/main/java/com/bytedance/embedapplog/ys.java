package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface ys extends IInterface {

    public static abstract class e extends Binder implements ys {

        /* JADX INFO: renamed from: com.bytedance.embedapplog.ys$e$e, reason: collision with other inner class name */
        public static class C0081e implements ys {
            private IBinder e;

            public C0081e(IBinder iBinder) {
                this.e = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.e;
            }

            @Override // com.bytedance.embedapplog.ys
            public boolean bf() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.alipay.sdk.m.d.b.f1793a);
                    this.e.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.ys
            public String e() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.alipay.sdk.m.d.b.f1793a);
                    this.e.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static ys e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(com.alipay.sdk.m.d.b.f1793a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ys)) ? new C0081e(iBinder) : (ys) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(com.alipay.sdk.m.d.b.f1793a);
                String strE = e();
                parcel2.writeNoException();
                parcel2.writeString(strE);
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(com.alipay.sdk.m.d.b.f1793a);
                return true;
            }
            parcel.enforceInterface(com.alipay.sdk.m.d.b.f1793a);
            boolean zBf = bf();
            parcel2.writeNoException();
            parcel2.writeInt(zBf ? 1 : 0);
            return true;
        }
    }

    boolean bf();

    String e();
}
