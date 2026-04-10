package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface vm extends IInterface {
    String bf();

    String bf(String str);

    String d(String str);

    String e(String str);

    boolean e();

    String ga(String str);

    String tg(String str);

    public static abstract class e extends Binder implements vm {
        public static vm d() {
            return C0079e.e;
        }

        public static vm e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof vm)) ? new C0079e(iBinder) : (vm) iInterfaceQueryLocalInterface;
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
                    String strE = e(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strE);
                    return true;
                case 2:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strBf = bf(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strBf);
                    return true;
                case 3:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strD = d(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strD);
                    return true;
                case 4:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strTg = tg(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strTg);
                    return true;
                case 5:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strGa = ga(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strGa);
                    return true;
                case 6:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    boolean zE = e();
                    parcel2.writeNoException();
                    parcel2.writeInt(zE ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strBf2 = bf();
                    parcel2.writeNoException();
                    parcel2.writeString(strBf2);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.embedapplog.vm$e$e, reason: collision with other inner class name */
        public static class C0079e implements vm {
            public static vm e;
            private IBinder bf;

            public C0079e(IBinder iBinder) {
                this.bf = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.bf;
            }

            @Override // com.bytedance.embedapplog.vm
            public String bf(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.bf.transact(2, parcelObtain, parcelObtain2, 0) && e.d() != null) {
                        return e.d().bf(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.vm
            public String d(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.bf.transact(3, parcelObtain, parcelObtain2, 0) && e.d() != null) {
                        return e.d().d(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.vm
            public String e(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.bf.transact(1, parcelObtain, parcelObtain2, 0) && e.d() != null) {
                        return e.d().e(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.vm
            public String ga(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.bf.transact(5, parcelObtain, parcelObtain2, 0) && e.d() != null) {
                        return e.d().ga(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.vm
            public String tg(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.bf.transact(4, parcelObtain, parcelObtain2, 0) && e.d() != null) {
                        return e.d().tg(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.vm
            public String bf() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    if (!this.bf.transact(7, parcelObtain, parcelObtain2, 0) && e.d() != null) {
                        return e.d().bf();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.vm
            public boolean e() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    if (!this.bf.transact(6, parcelObtain, parcelObtain2, 0) && e.d() != null) {
                        return e.d().e();
                    }
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
