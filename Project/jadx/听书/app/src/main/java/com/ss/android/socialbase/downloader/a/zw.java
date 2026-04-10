package com.ss.android.socialbase.downloader.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.a.iq;

/* JADX INFO: loaded from: classes4.dex */
public interface zw extends IInterface {
    boolean z(iq iqVar) throws RemoteException;

    public static abstract class z extends Binder implements zw {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public z() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
        }

        public static zw z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof zw)) {
                return (zw) iInterfaceQueryLocalInterface;
            }
            return new C0470z(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            boolean z = z(iq.z.z(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeInt(z ? 1 : 0);
            return true;
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.a.zw$z$z, reason: collision with other inner class name */
        private static class C0470z implements zw {
            public static zw z;
            private IBinder g;

            C0470z(IBinder iBinder) {
                this.g = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.g;
            }

            @Override // com.ss.android.socialbase.downloader.a.zw
            public boolean z(iq iqVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
                    parcelObtain.writeStrongBinder(iqVar != null ? iqVar.asBinder() : null);
                    if (!this.g.transact(1, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        return z.z().z(iqVar);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static zw z() {
            return C0470z.z;
        }
    }
}
