package com.bytedance.pangle;

import android.content.ComponentName;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface gz extends IInterface {
    int z() throws RemoteException;

    void z(ComponentName componentName, IBinder iBinder) throws RemoteException;

    public static abstract class z extends Binder implements gz {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public z() {
            attachInterface(this, "com.bytedance.pangle.ServiceConnection");
        }

        public static gz z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.ServiceConnection");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof gz)) {
                return (gz) iInterfaceQueryLocalInterface;
            }
            return new C0108z(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.bytedance.pangle.ServiceConnection");
                z(parcel.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(parcel) : null, parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                if (i == 1598968902) {
                    parcel2.writeString("com.bytedance.pangle.ServiceConnection");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.bytedance.pangle.ServiceConnection");
            int iZ = z();
            parcel2.writeNoException();
            parcel2.writeInt(iZ);
            return true;
        }

        /* JADX INFO: renamed from: com.bytedance.pangle.gz$z$z, reason: collision with other inner class name */
        private static class C0108z implements gz {
            public static gz z;
            private IBinder g;

            C0108z(IBinder iBinder) {
                this.g = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.g;
            }

            @Override // com.bytedance.pangle.gz
            public void z(ComponentName componentName, IBinder iBinder) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.ServiceConnection");
                    if (componentName != null) {
                        parcelObtain.writeInt(1);
                        componentName.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iBinder);
                    if (!this.g.transact(1, parcelObtain, parcelObtain2, 0) && z.g() != null) {
                        z.g().z(componentName, iBinder);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.gz
            public int z() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.ServiceConnection");
                    if (!this.g.transact(2, parcelObtain, parcelObtain2, 0) && z.g() != null) {
                        return z.g().z();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static gz g() {
            return C0108z.z;
        }
    }
}
