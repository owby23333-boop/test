package com.ss.android.socialbase.downloader.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface eo extends IInterface {
    long z(int i, int i2) throws RemoteException;

    public static abstract class z extends Binder implements eo {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public z() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
        }

        public static eo z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof eo)) {
                return (eo) iInterfaceQueryLocalInterface;
            }
            return new C0457z(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
            long jZ = z(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeLong(jZ);
            return true;
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.a.eo$z$z, reason: collision with other inner class name */
        private static class C0457z implements eo {
            public static eo z;
            private IBinder g;

            C0457z(IBinder iBinder) {
                this.g = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.g;
            }

            @Override // com.ss.android.socialbase.downloader.a.eo
            public long z(int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    if (!this.g.transact(1, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        return z.z().z(i, i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static eo z() {
            return C0457z.z;
        }
    }
}
