package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.dt;

/* JADX INFO: loaded from: classes4.dex */
public interface pe extends IInterface {
    boolean e(dt dtVar) throws RemoteException;

    public static abstract class e extends Binder implements pe {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.pe$e$e, reason: collision with other inner class name */
        public static class C0506e implements pe {
            public static pe e;
            private IBinder bf;

            public C0506e(IBinder iBinder) {
                this.bf = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.bf;
            }

            @Override // com.ss.android.socialbase.downloader.depend.pe
            public boolean e(dt dtVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
                    parcelObtain.writeStrongBinder(dtVar != null ? dtVar.asBinder() : null);
                    if (!this.bf.transact(1, parcelObtain, parcelObtain2, 0) && e.e() != null) {
                        return e.e().e(dtVar);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public e() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
        }

        public static pe e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof pe)) ? new C0506e(iBinder) : (pe) iInterfaceQueryLocalInterface;
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            boolean zE = e(dt.e.e(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeInt(zE ? 1 : 0);
            return true;
        }

        public static pe e() {
            return C0506e.e;
        }
    }
}
