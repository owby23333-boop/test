package com.ss.android.socialbase.downloader.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface e extends IInterface {
    void z(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar, int i) throws RemoteException;

    public static abstract class z extends Binder implements e {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public z() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
        }

        public static e z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof e)) {
                return (e) iInterfaceQueryLocalInterface;
            }
            return new C0456z(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
            z(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.gc.z.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.a.e$z$z, reason: collision with other inner class name */
        private static class C0456z implements e {
            public static e z;
            private IBinder g;

            C0456z(IBinder iBinder) {
                this.g = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.g;
            }

            @Override // com.ss.android.socialbase.downloader.a.e
            public void z(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
                    if (dlVar != null) {
                        parcelObtain.writeInt(1);
                        dlVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (zVar != null) {
                        parcelObtain.writeInt(1);
                        zVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(1, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        z.z().z(dlVar, zVar, i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static e z() {
            return C0456z.z;
        }
    }
}
