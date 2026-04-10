package com.bytedance.sdk.openadsdk.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface wp extends IInterface {
    IBinder z(int i) throws RemoteException;

    public static abstract class z extends Binder implements wp {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public z() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.IBinderPool");
        }

        public static wp z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.IBinderPool");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof wp)) {
                return (wp) iInterfaceQueryLocalInterface;
            }
            return new C0214z(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.bytedance.sdk.openadsdk.core.IBinderPool");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IBinderPool");
            IBinder iBinderZ = z(parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeStrongBinder(iBinderZ);
            return true;
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.wp$z$z, reason: collision with other inner class name */
        private static class C0214z implements wp {
            public static wp z;
            private IBinder g;

            C0214z(IBinder iBinder) {
                this.g = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.g;
            }

            @Override // com.bytedance.sdk.openadsdk.core.wp
            public IBinder z(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IBinderPool");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(1, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        return z.z().z(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readStrongBinder();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static wp z() {
            return C0214z.z;
        }
    }
}
