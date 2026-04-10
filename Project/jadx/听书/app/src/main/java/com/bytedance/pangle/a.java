package com.bytedance.pangle;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {
    void z(String str, int i, String str2) throws RemoteException;

    public static abstract class z extends Binder implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public z() {
            attachInterface(this, "com.bytedance.pangle.IPluginInstallListener");
        }

        public static a z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IPluginInstallListener");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof a)) {
                return (a) iInterfaceQueryLocalInterface;
            }
            return new C0105z(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.bytedance.pangle.IPluginInstallListener");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.bytedance.pangle.IPluginInstallListener");
            z(parcel.readString(), parcel.readInt(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.bytedance.pangle.a$z$z, reason: collision with other inner class name */
        private static class C0105z implements a {
            public static a z;
            private IBinder g;

            C0105z(IBinder iBinder) {
                this.g = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.g;
            }

            @Override // com.bytedance.pangle.a
            public void z(String str, int i, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPluginInstallListener");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str2);
                    if (!this.g.transact(1, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        z.z().z(str, i, str2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static a z() {
            return C0105z.z;
        }
    }
}
