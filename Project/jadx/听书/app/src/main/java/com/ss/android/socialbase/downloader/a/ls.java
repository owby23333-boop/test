package com.ss.android.socialbase.downloader.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface ls extends IInterface {
    void z() throws RemoteException;

    public static abstract class z extends Binder implements ls {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public z() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
        }

        public static ls z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ls)) {
                return (ls) iInterfaceQueryLocalInterface;
            }
            return new C0464z(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
            z();
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.a.ls$z$z, reason: collision with other inner class name */
        private static class C0464z implements ls {
            public static ls z;
            private IBinder g;

            C0464z(IBinder iBinder) {
                this.g = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.g;
            }

            @Override // com.ss.android.socialbase.downloader.a.ls
            public void z() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
                    if (!this.g.transact(1, parcelObtain, parcelObtain2, 0) && z.g() != null) {
                        z.g().z();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static ls g() {
            return C0464z.z;
        }
    }
}
