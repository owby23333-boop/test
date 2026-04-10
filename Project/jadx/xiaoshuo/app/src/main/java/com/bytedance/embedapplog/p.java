package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface p extends IInterface {

    public static abstract class e extends Binder implements p {

        /* JADX INFO: renamed from: com.bytedance.embedapplog.p$e$e, reason: collision with other inner class name */
        public static class C0077e implements p {
            public static p e;
            private IBinder bf;

            public C0077e(IBinder iBinder) {
                this.bf = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.bf;
            }

            @Override // com.bytedance.embedapplog.p
            public String bf() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.bf.transact(2, parcelObtain, parcelObtain2, 0) && e.p() != null) {
                        return e.p().bf();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.p
            public String d() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.bf.transact(3, parcelObtain, parcelObtain2, 0) && e.p() != null) {
                        return e.p().d();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.p
            public String e() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.bf.transact(1, parcelObtain, parcelObtain2, 0) && e.p() != null) {
                        return e.p().e();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.p
            public boolean ga() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.bf.transact(5, parcelObtain, parcelObtain2, 0) && e.p() != null) {
                        return e.p().ga();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.p
            public boolean tg() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.bf.transact(4, parcelObtain, parcelObtain2, 0) && e.p() != null) {
                        return e.p().tg();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.p
            public void vn() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (this.bf.transact(6, parcelObtain, parcelObtain2, 0) || e.p() == null) {
                        parcelObtain2.readException();
                    } else {
                        e.p().vn();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static p e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof p)) ? new C0077e(iBinder) : (p) iInterfaceQueryLocalInterface;
        }

        public static p p() {
            return C0077e.e;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString("com.bun.lib.MsaIdInterface");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                    String strE = e();
                    parcel2.writeNoException();
                    parcel2.writeString(strE);
                    return true;
                case 2:
                    parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                    String strBf = bf();
                    parcel2.writeNoException();
                    parcel2.writeString(strBf);
                    return true;
                case 3:
                    parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                    String strD = d();
                    parcel2.writeNoException();
                    parcel2.writeString(strD);
                    return true;
                case 4:
                    parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                    boolean zTg = tg();
                    parcel2.writeNoException();
                    parcel2.writeInt(zTg ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                    boolean zGa = ga();
                    parcel2.writeNoException();
                    parcel2.writeInt(zGa ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                    vn();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String bf();

    String d();

    String e();

    boolean ga();

    boolean tg();

    void vn();
}
