package com.ss.android.socialbase.downloader.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface i extends IInterface {
    boolean g(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException;

    void z(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException;

    public static abstract class z extends Binder implements i {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public z() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
        }

        public static i z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof i)) {
                return (i) iInterfaceQueryLocalInterface;
            }
            return new C0461z(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
                z(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                if (i == 1598968902) {
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
            boolean zG = g(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            parcel2.writeInt(zG ? 1 : 0);
            return true;
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.a.i$z$z, reason: collision with other inner class name */
        private static class C0461z implements i {
            public static i z;
            private IBinder g;

            C0461z(IBinder iBinder) {
                this.g = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.g;
            }

            @Override // com.ss.android.socialbase.downloader.a.i
            public void z(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
                    if (dlVar != null) {
                        parcelObtain.writeInt(1);
                        dlVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.g.transact(1, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        z.z().z(dlVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.i
            public boolean g(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
                    if (dlVar != null) {
                        parcelObtain.writeInt(1);
                        dlVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.g.transact(2, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        return z.z().g(dlVar);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static i z() {
            return C0461z.z;
        }
    }
}
