package com.bytedance.sdk.openadsdk.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes10.dex */
public interface s extends IInterface {

    public static abstract class e extends Binder implements s {

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.s$e$e, reason: collision with other inner class name */
        public static class C0150e implements s {
            public static s e;
            private IBinder bf;

            public C0150e(IBinder iBinder) {
                this.bf = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.bf;
            }

            @Override // com.bytedance.sdk.openadsdk.core.s
            public void bf() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
                    if (this.bf.transact(2, parcelObtain, parcelObtain2, 0) || e.tg() == null) {
                        parcelObtain2.readException();
                    } else {
                        e.tg().bf();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.s
            public void d() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
                    if (this.bf.transact(3, parcelObtain, parcelObtain2, 0) || e.tg() == null) {
                        parcelObtain2.readException();
                    } else {
                        e.tg().d();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.s
            public void e() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
                    if (this.bf.transact(1, parcelObtain, parcelObtain2, 0) || e.tg() == null) {
                        parcelObtain2.readException();
                    } else {
                        e.tg().e();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public e() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
        }

        public static s e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof s)) ? new C0150e(iBinder) : (s) iInterfaceQueryLocalInterface;
        }

        public static s tg() {
            return C0150e.e;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
                e();
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
                bf();
                parcel2.writeNoException();
                return true;
            }
            if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
                return true;
            }
            parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
            d();
            parcel2.writeNoException();
            return true;
        }
    }

    void bf() throws RemoteException;

    void d() throws RemoteException;

    void e() throws RemoteException;
}
