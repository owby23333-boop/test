package com.ss.android.socialbase.downloader.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.a.ls;

/* JADX INFO: loaded from: classes4.dex */
public interface p extends IInterface {
    boolean z(long j, long j2, ls lsVar) throws RemoteException;

    public static abstract class z extends Binder implements p {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public z() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
        }

        public static p z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof p)) {
                return (p) iInterfaceQueryLocalInterface;
            }
            return new C0467z(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            boolean z = z(parcel.readLong(), parcel.readLong(), ls.z.z(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeInt(z ? 1 : 0);
            return true;
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.a.p$z$z, reason: collision with other inner class name */
        private static class C0467z implements p {
            public static p z;
            private IBinder g;

            C0467z(IBinder iBinder) {
                this.g = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.g;
            }

            @Override // com.ss.android.socialbase.downloader.a.p
            public boolean z(long j, long j2, ls lsVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
                    parcelObtain.writeLong(j);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeStrongBinder(lsVar != null ? lsVar.asBinder() : null);
                    if (!this.g.transact(1, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        return z.z().z(j, j2, lsVar);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static p z() {
            return C0467z.z;
        }
    }
}
