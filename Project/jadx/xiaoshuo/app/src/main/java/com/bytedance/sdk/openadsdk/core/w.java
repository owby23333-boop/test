package com.bytedance.sdk.openadsdk.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes10.dex */
public interface w extends IInterface {
    void e() throws RemoteException;

    void e(String str) throws RemoteException;

    public static abstract class e extends Binder implements w {
        public e() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
        }

        public static w bf() {
            return C0164e.e;
        }

        public static w e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof w)) ? new C0164e(iBinder) : (w) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
                e();
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
                return true;
            }
            parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
            e(parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.w$e$e, reason: collision with other inner class name */
        public static class C0164e implements w {
            public static w e;
            private IBinder bf;

            public C0164e(IBinder iBinder) {
                this.bf = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.bf;
            }

            @Override // com.bytedance.sdk.openadsdk.core.w
            public void e() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
                    if (this.bf.transact(1, parcelObtain, parcelObtain2, 0) || e.bf() == null) {
                        parcelObtain2.readException();
                    } else {
                        e.bf().e();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.w
            public void e(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
                    parcelObtain.writeString(str);
                    if (!this.bf.transact(2, parcelObtain, parcelObtain2, 0) && e.bf() != null) {
                        e.bf().e(str);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
