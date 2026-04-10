package com.bytedance.sdk.openadsdk.core;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes10.dex */
public interface k extends IInterface {
    Bundle e(int i) throws RemoteException;

    public static abstract class e extends Binder implements k {

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.k$e$e, reason: collision with other inner class name */
        public static class C0141e implements k {
            public static k e;
            private IBinder bf;

            public C0141e(IBinder iBinder) {
                this.bf = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.bf;
            }

            @Override // com.bytedance.sdk.openadsdk.core.k
            public Bundle e(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IRewardAdCustomPlayAgainListener");
                    parcelObtain.writeInt(i);
                    if (!this.bf.transact(1, parcelObtain, parcelObtain2, 0) && e.e() != null) {
                        return e.e().e(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public e() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.IRewardAdCustomPlayAgainListener");
        }

        public static k e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.IRewardAdCustomPlayAgainListener");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof k)) ? new C0141e(iBinder) : (k) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.bytedance.sdk.openadsdk.core.IRewardAdCustomPlayAgainListener");
                return true;
            }
            parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IRewardAdCustomPlayAgainListener");
            Bundle bundleE = e(parcel.readInt());
            parcel2.writeNoException();
            if (bundleE != null) {
                parcel2.writeInt(1);
                bundleE.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }

        public static k e() {
            return C0141e.e;
        }
    }
}
