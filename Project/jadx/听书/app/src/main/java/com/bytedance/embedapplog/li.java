package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface li extends IInterface {
    boolean g();

    String z();

    public static abstract class z extends Binder implements li {
        public static li z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof li)) {
                return (li) iInterfaceQueryLocalInterface;
            }
            return new C0059z(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                String strZ = z();
                parcel2.writeNoException();
                parcel2.writeString(strZ);
                return true;
            }
            if (i != 2) {
                if (i == 1598968902) {
                    parcel2.writeString("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            boolean zG = g();
            parcel2.writeNoException();
            parcel2.writeInt(zG ? 1 : 0);
            return true;
        }

        /* JADX INFO: renamed from: com.bytedance.embedapplog.li$z$z, reason: collision with other inner class name */
        static class C0059z implements li {
            private IBinder z;

            C0059z(IBinder iBinder) {
                this.z = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.z;
            }

            @Override // com.bytedance.embedapplog.li
            public String z() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.z.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.li
            public boolean g() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.z.transact(2, parcelObtain, parcelObtain2, 0);
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
