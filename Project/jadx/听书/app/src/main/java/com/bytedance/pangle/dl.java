package com.bytedance.pangle;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bytedance.pangle.a;

/* JADX INFO: loaded from: classes2.dex */
public interface dl extends IInterface {
    int g(String str) throws RemoteException;

    void z(int i) throws RemoteException;

    void z(int i, a aVar) throws RemoteException;

    boolean z(String str) throws RemoteException;

    boolean z(String str, String str2) throws RemoteException;

    public static abstract class z extends Binder implements dl {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public z() {
            attachInterface(this, "com.bytedance.pangle.IPackageManager");
        }

        public static dl z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IPackageManager");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof dl)) {
                return (dl) iInterfaceQueryLocalInterface;
            }
            return new C0106z(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                boolean z = z(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(z ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                int iG = g(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(iG);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                boolean z2 = z(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(z2 ? 1 : 0);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                z(parcel.readInt(), a.z.z(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i != 5) {
                if (i == 1598968902) {
                    parcel2.writeString("com.bytedance.pangle.IPackageManager");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
            z(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.bytedance.pangle.dl$z$z, reason: collision with other inner class name */
        private static class C0106z implements dl {
            public static dl z;
            private IBinder g;

            C0106z(IBinder iBinder) {
                this.g = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.g;
            }

            @Override // com.bytedance.pangle.dl
            public boolean z(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    parcelObtain.writeString(str);
                    if (!this.g.transact(1, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        return z.z().z(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.dl
            public int g(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    parcelObtain.writeString(str);
                    if (!this.g.transact(2, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        return z.z().g(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.dl
            public boolean z(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.g.transact(3, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        return z.z().z(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.dl
            public void z(int i, a aVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (!this.g.transact(4, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        z.z().z(i, aVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.dl
            public void z(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(5, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        z.z().z(i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static dl z() {
            return C0106z.z;
        }
    }
}
