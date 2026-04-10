package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface s extends IInterface {

    public static abstract class e extends Binder implements s {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.s$e$e, reason: collision with other inner class name */
        public static class C0508e implements s {
            public static s e;
            private IBinder bf;

            public C0508e(IBinder iBinder) {
                this.bf = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.bf;
            }

            @Override // com.ss.android.socialbase.downloader.depend.s
            public void e() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
                    if (this.bf.transact(1, parcelObtain, parcelObtain2, 0) || e.bf() == null) {
                        parcelObtain2.readException();
                    } else {
                        e.bf().e();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public e() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
        }

        public static s bf() {
            return C0508e.e;
        }

        public static s e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof s)) ? new C0508e(iBinder) : (s) iInterfaceQueryLocalInterface;
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
            e();
            parcel2.writeNoException();
            return true;
        }
    }

    void e() throws RemoteException;
}
