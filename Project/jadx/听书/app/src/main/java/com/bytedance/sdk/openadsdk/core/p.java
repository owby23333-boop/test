package com.bytedance.sdk.openadsdk.core;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface p extends IInterface {
    Bundle z(int i) throws RemoteException;

    public static abstract class z extends Binder implements p {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public z() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.IRewardAdCustomPlayAgainListener");
        }

        public static p z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.IRewardAdCustomPlayAgainListener");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof p)) {
                return (p) iInterfaceQueryLocalInterface;
            }
            return new C0192z(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.bytedance.sdk.openadsdk.core.IRewardAdCustomPlayAgainListener");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IRewardAdCustomPlayAgainListener");
            Bundle bundleZ = z(parcel.readInt());
            parcel2.writeNoException();
            if (bundleZ != null) {
                parcel2.writeInt(1);
                bundleZ.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.p$z$z, reason: collision with other inner class name */
        private static class C0192z implements p {
            public static p z;
            private IBinder g;

            C0192z(IBinder iBinder) {
                this.g = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.g;
            }

            @Override // com.bytedance.sdk.openadsdk.core.p
            public Bundle z(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IRewardAdCustomPlayAgainListener");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(1, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        return z.z().z(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static p z() {
            return C0192z.z;
        }
    }
}
