package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface wp extends IInterface {
    String a(String str);

    String dl(String str);

    String g();

    String g(String str);

    String gc(String str);

    String z(String str);

    boolean z();

    public static abstract class z extends Binder implements wp {
        public static wp z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof wp)) {
                return (wp) iInterfaceQueryLocalInterface;
            }
            return new C0065z(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString("com.coolpad.deviceidsupport.IDeviceIdManager");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strZ = z(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strZ);
                    return true;
                case 2:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strG = g(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strG);
                    return true;
                case 3:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strDl = dl(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strDl);
                    return true;
                case 4:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strA = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strA);
                    return true;
                case 5:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strGc = gc(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strGc);
                    return true;
                case 6:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    boolean z = z();
                    parcel2.writeNoException();
                    parcel2.writeInt(z ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strG2 = g();
                    parcel2.writeNoException();
                    parcel2.writeString(strG2);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.embedapplog.wp$z$z, reason: collision with other inner class name */
        static class C0065z implements wp {
            public static wp z;
            private IBinder g;

            C0065z(IBinder iBinder) {
                this.g = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.g;
            }

            @Override // com.bytedance.embedapplog.wp
            public String z(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.g.transact(1, parcelObtain, parcelObtain2, 0) && z.dl() != null) {
                        return z.dl().z(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.wp
            public String g(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.g.transact(2, parcelObtain, parcelObtain2, 0) && z.dl() != null) {
                        return z.dl().g(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.wp
            public String dl(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.g.transact(3, parcelObtain, parcelObtain2, 0) && z.dl() != null) {
                        return z.dl().dl(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.wp
            public String a(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.g.transact(4, parcelObtain, parcelObtain2, 0) && z.dl() != null) {
                        return z.dl().a(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.wp
            public String gc(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.g.transact(5, parcelObtain, parcelObtain2, 0) && z.dl() != null) {
                        return z.dl().gc(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.wp
            public boolean z() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    if (!this.g.transact(6, parcelObtain, parcelObtain2, 0) && z.dl() != null) {
                        return z.dl().z();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.wp
            public String g() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    if (!this.g.transact(7, parcelObtain, parcelObtain2, 0) && z.dl() != null) {
                        return z.dl().g();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static wp dl() {
            return C0065z.z;
        }
    }
}
