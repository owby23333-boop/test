package com.bytedance.sdk.openadsdk.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface pf extends IInterface {
    void a() throws RemoteException;

    void dl() throws RemoteException;

    void g() throws RemoteException;

    void gc() throws RemoteException;

    void m() throws RemoteException;

    void z() throws RemoteException;

    public static abstract class z extends Binder implements pf {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public z() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
        }

        public static pf z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof pf)) {
                return (pf) iInterfaceQueryLocalInterface;
            }
            return new C0194z(iBinder);
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
                    z();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    g();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    dl();
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    a();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    gc();
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    m();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.pf$z$z, reason: collision with other inner class name */
        private static class C0194z implements pf {
            public static pf z;
            private IBinder g;

            C0194z(IBinder iBinder) {
                this.g = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.g;
            }

            @Override // com.bytedance.sdk.openadsdk.core.pf
            public void z() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (!this.g.transact(1, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().z();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.pf
            public void g() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (!this.g.transact(2, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().g();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.pf
            public void dl() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (!this.g.transact(3, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().dl();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.pf
            public void a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (!this.g.transact(4, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().a();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.pf
            public void gc() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (!this.g.transact(5, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().gc();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.pf
            public void m() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (!this.g.transact(6, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().m();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static pf e() {
            return C0194z.z;
        }
    }
}
