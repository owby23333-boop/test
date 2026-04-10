package com.bytedance.sdk.openadsdk.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes10.dex */
public interface l extends IInterface {

    public static abstract class e extends Binder implements l {

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.l$e$e, reason: collision with other inner class name */
        public static class C0142e implements l {
            public static l e;
            private IBinder bf;

            public C0142e(IBinder iBinder) {
                this.bf = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.bf;
            }

            @Override // com.bytedance.sdk.openadsdk.core.l
            public void bf() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (this.bf.transact(2, parcelObtain, parcelObtain2, 0) || e.p() == null) {
                        parcelObtain2.readException();
                    } else {
                        e.p().bf();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.l
            public void d() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (this.bf.transact(3, parcelObtain, parcelObtain2, 0) || e.p() == null) {
                        parcelObtain2.readException();
                    } else {
                        e.p().d();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.l
            public void e() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (this.bf.transact(1, parcelObtain, parcelObtain2, 0) || e.p() == null) {
                        parcelObtain2.readException();
                    } else {
                        e.p().e();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.l
            public void ga() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (this.bf.transact(5, parcelObtain, parcelObtain2, 0) || e.p() == null) {
                        parcelObtain2.readException();
                    } else {
                        e.p().ga();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.l
            public void tg() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (this.bf.transact(4, parcelObtain, parcelObtain2, 0) || e.p() == null) {
                        parcelObtain2.readException();
                    } else {
                        e.p().tg();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.l
            public void vn() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (this.bf.transact(6, parcelObtain, parcelObtain2, 0) || e.p() == null) {
                        parcelObtain2.readException();
                    } else {
                        e.p().vn();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public e() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
        }

        public static l e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof l)) ? new C0142e(iBinder) : (l) iInterfaceQueryLocalInterface;
        }

        public static l p() {
            return C0142e.e;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    e();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    bf();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    d();
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    tg();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    ga();
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    vn();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void bf() throws RemoteException;

    void d() throws RemoteException;

    void e() throws RemoteException;

    void ga() throws RemoteException;

    void tg() throws RemoteException;

    void vn() throws RemoteException;
}
