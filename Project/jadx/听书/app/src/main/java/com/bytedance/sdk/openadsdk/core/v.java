package com.bytedance.sdk.openadsdk.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface v extends IInterface {
    void z() throws RemoteException;

    void z(String str) throws RemoteException;

    public static abstract class z extends Binder implements v {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public z() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
        }

        public static v z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof v)) {
                return (v) iInterfaceQueryLocalInterface;
            }
            return new C0208z(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
                z();
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                if (i == 1598968902) {
                    parcel2.writeString("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
            z(parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.v$z$z, reason: collision with other inner class name */
        private static class C0208z implements v {
            public static v z;
            private IBinder g;

            C0208z(IBinder iBinder) {
                this.g = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.g;
            }

            @Override // com.bytedance.sdk.openadsdk.core.v
            public void z() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
                    if (!this.g.transact(1, parcelObtain, parcelObtain2, 0) && z.g() != null) {
                        z.g().z();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.v
            public void z(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
                    parcelObtain.writeString(str);
                    if (!this.g.transact(2, parcelObtain, parcelObtain2, 0) && z.g() != null) {
                        z.g().z(str);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static v g() {
            return C0208z.z;
        }
    }
}
