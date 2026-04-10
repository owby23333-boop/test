package com.bytedance.sdk.openadsdk.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes10.dex */
public interface t extends IInterface {
    IBinder e(int i) throws RemoteException;

    public static abstract class e extends Binder implements t {

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.t$e$e, reason: collision with other inner class name */
        public static class C0152e implements t {
            public static t e;
            private IBinder bf;

            public C0152e(IBinder iBinder) {
                this.bf = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.bf;
            }

            @Override // com.bytedance.sdk.openadsdk.core.t
            public IBinder e(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IBinderPool");
                    parcelObtain.writeInt(i);
                    if (!this.bf.transact(1, parcelObtain, parcelObtain2, 0) && e.e() != null) {
                        return e.e().e(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readStrongBinder();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public e() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.IBinderPool");
        }

        public static t e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.IBinderPool");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof t)) ? new C0152e(iBinder) : (t) iInterfaceQueryLocalInterface;
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
                parcel2.writeString("com.bytedance.sdk.openadsdk.core.IBinderPool");
                return true;
            }
            parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IBinderPool");
            IBinder iBinderE = e(parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeStrongBinder(iBinderE);
            return true;
        }

        public static t e() {
            return C0152e.e;
        }
    }
}
