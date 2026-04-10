package com.ss.android.socialbase.downloader.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface wj extends IInterface {
    void z(int i, int i2) throws RemoteException;

    public static abstract class z extends Binder implements wj {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public z() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
        }

        public static wj z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof wj)) {
                return (wj) iInterfaceQueryLocalInterface;
            }
            return new C0469z(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            z(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.a.wj$z$z, reason: collision with other inner class name */
        private static class C0469z implements wj {
            public static wj z;
            private IBinder g;

            C0469z(IBinder iBinder) {
                this.g = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.g;
            }

            @Override // com.ss.android.socialbase.downloader.a.wj
            public void z(int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    if (!this.g.transact(1, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        z.z().z(i, i2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static wj z() {
            return C0469z.z;
        }
    }
}
