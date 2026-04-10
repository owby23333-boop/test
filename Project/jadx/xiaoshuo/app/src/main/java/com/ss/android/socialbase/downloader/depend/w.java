package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.s;

/* JADX INFO: loaded from: classes4.dex */
public interface w extends IInterface {
    boolean e(long j, long j2, s sVar) throws RemoteException;

    public static abstract class e extends Binder implements w {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.w$e$e, reason: collision with other inner class name */
        public static class C0511e implements w {
            public static w e;
            private IBinder bf;

            public C0511e(IBinder iBinder) {
                this.bf = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.bf;
            }

            @Override // com.ss.android.socialbase.downloader.depend.w
            public boolean e(long j, long j2, s sVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
                    parcelObtain.writeLong(j);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeStrongBinder(sVar != null ? sVar.asBinder() : null);
                    if (!this.bf.transact(1, parcelObtain, parcelObtain2, 0) && e.e() != null) {
                        return e.e().e(j, j2, sVar);
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
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
        }

        public static w e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof w)) ? new C0511e(iBinder) : (w) iInterfaceQueryLocalInterface;
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            boolean zE = e(parcel.readLong(), parcel.readLong(), s.e.e(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeInt(zE ? 1 : 0);
            return true;
        }

        public static w e() {
            return C0511e.e;
        }
    }
}
