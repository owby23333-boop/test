package com.bytedance.pangle;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bytedance.pangle.gz;

/* JADX INFO: loaded from: classes2.dex */
public interface gc extends IInterface {
    boolean bindService(Intent intent, gz gzVar, int i, String str) throws RemoteException;

    ComponentName startService(Intent intent, String str) throws RemoteException;

    boolean stopService(Intent intent, String str) throws RemoteException;

    void unbindService(gz gzVar) throws RemoteException;

    public static abstract class z extends Binder implements gc {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public z() {
            attachInterface(this, "com.bytedance.pangle.IServiceManager");
        }

        public static gc z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IServiceManager");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof gc)) {
                return (gc) iInterfaceQueryLocalInterface;
            }
            return new C0107z(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                ComponentName componentNameStartService = startService(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                parcel2.writeNoException();
                if (componentNameStartService != null) {
                    parcel2.writeInt(1);
                    componentNameStartService.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                boolean zStopService = stopService(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zStopService ? 1 : 0);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                boolean zBindService = bindService(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, gz.z.z(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zBindService ? 1 : 0);
                return true;
            }
            if (i != 4) {
                if (i == 1598968902) {
                    parcel2.writeString("com.bytedance.pangle.IServiceManager");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
            unbindService(gz.z.z(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.bytedance.pangle.gc$z$z, reason: collision with other inner class name */
        private static class C0107z implements gc {
            public static gc z;
            private IBinder g;

            C0107z(IBinder iBinder) {
                this.g = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.g;
            }

            @Override // com.bytedance.pangle.gc
            public ComponentName startService(Intent intent, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    if (intent != null) {
                        parcelObtain.writeInt(1);
                        intent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    if (!this.g.transact(1, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        return z.z().startService(intent, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.gc
            public boolean stopService(Intent intent, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    if (intent != null) {
                        parcelObtain.writeInt(1);
                        intent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    if (!this.g.transact(2, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        return z.z().stopService(intent, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.gc
            public boolean bindService(Intent intent, gz gzVar, int i, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    if (intent != null) {
                        parcelObtain.writeInt(1);
                        intent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(gzVar != null ? gzVar.asBinder() : null);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    if (!this.g.transact(3, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        return z.z().bindService(intent, gzVar, i, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.gc
            public void unbindService(gz gzVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    parcelObtain.writeStrongBinder(gzVar != null ? gzVar.asBinder() : null);
                    if (!this.g.transact(4, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        z.z().unbindService(gzVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static gc z() {
            return C0107z.z;
        }
    }
}
