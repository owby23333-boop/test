package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface ga extends IInterface {
    int e(long j) throws RemoteException;

    public static abstract class e extends Binder implements ga {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.ga$e$e, reason: collision with other inner class name */
        public static class C0503e implements ga {
            public static ga e;
            private IBinder bf;

            public C0503e(IBinder iBinder) {
                this.bf = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.bf;
            }

            @Override // com.ss.android.socialbase.downloader.depend.ga
            public int e(long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
                    parcelObtain.writeLong(j);
                    if (!this.bf.transact(1, parcelObtain, parcelObtain2, 0) && e.e() != null) {
                        return e.e().e(j);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public e() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
        }

        public static ga e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ga)) ? new C0503e(iBinder) : (ga) iInterfaceQueryLocalInterface;
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
            int iE = e(parcel.readLong());
            parcel2.writeNoException();
            parcel2.writeInt(iE);
            return true;
        }

        public static ga e() {
            return C0503e.e;
        }
    }
}
