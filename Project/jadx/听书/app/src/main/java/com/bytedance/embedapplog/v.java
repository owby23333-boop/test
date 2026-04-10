package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface v extends IInterface {
    boolean dl();

    String g();

    String g(String str);

    String z();

    String z(String str);

    public static abstract class z extends Binder implements v {
        public static v z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof v)) {
                return (v) iInterfaceQueryLocalInterface;
            }
            return new C0064z(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String strZ = z();
                parcel2.writeNoException();
                parcel2.writeString(strZ);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String strG = g();
                parcel2.writeNoException();
                parcel2.writeString(strG);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                boolean zDl = dl();
                parcel2.writeNoException();
                parcel2.writeInt(zDl ? 1 : 0);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String strZ2 = z(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strZ2);
                return true;
            }
            if (i != 5) {
                if (i == 1598968902) {
                    parcel2.writeString("com.zui.deviceidservice.IDeviceidInterface");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
            String strG2 = g(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(strG2);
            return true;
        }

        /* JADX INFO: renamed from: com.bytedance.embedapplog.v$z$z, reason: collision with other inner class name */
        static class C0064z implements v {
            private IBinder z;

            C0064z(IBinder iBinder) {
                this.z = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.z;
            }

            @Override // com.bytedance.embedapplog.v
            public String z() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.z.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.v
            public String g() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.z.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.v
            public boolean dl() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.z.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.v
            public String z(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    parcelObtain.writeString(str);
                    this.z.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.v
            public String g(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    parcelObtain.writeString(str);
                    this.z.transact(5, parcelObtain, parcelObtain2, 0);
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
