package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface p extends IInterface {
    boolean a();

    String dl();

    String g();

    boolean gc();

    void m();

    String z();

    public static abstract class z extends Binder implements p {
        public static p z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof p)) {
                return (p) iInterfaceQueryLocalInterface;
            }
            return new C0061z(iBinder);
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
                    String strZ = z();
                    parcel2.writeNoException();
                    parcel2.writeString(strZ);
                    return true;
                case 2:
                    parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                    String strG = g();
                    parcel2.writeNoException();
                    parcel2.writeString(strG);
                    return true;
                case 3:
                    parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                    String strDl = dl();
                    parcel2.writeNoException();
                    parcel2.writeString(strDl);
                    return true;
                case 4:
                    parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                    boolean zA = a();
                    parcel2.writeNoException();
                    parcel2.writeInt(zA ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                    boolean zGc = gc();
                    parcel2.writeNoException();
                    parcel2.writeInt(zGc ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                    m();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.embedapplog.p$z$z, reason: collision with other inner class name */
        static class C0061z implements p {
            public static p z;
            private IBinder g;

            C0061z(IBinder iBinder) {
                this.g = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.g;
            }

            @Override // com.bytedance.embedapplog.p
            public String z() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.g.transact(1, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().z();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.p
            public String g() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.g.transact(2, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().g();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.p
            public String dl() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.g.transact(3, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().dl();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.p
            public boolean a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.g.transact(4, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().a();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.p
            public boolean gc() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.g.transact(5, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().gc();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.p
            public void m() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.g.transact(6, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().m();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static p e() {
            return C0061z.z;
        }
    }
}
