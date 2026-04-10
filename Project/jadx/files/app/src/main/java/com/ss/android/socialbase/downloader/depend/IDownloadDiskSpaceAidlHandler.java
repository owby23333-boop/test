package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadDiskSpaceAidlHandler extends IInterface {

    public static class Default implements IDownloadDiskSpaceAidlHandler {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler
        public boolean cleanUpDisk(long j2, long j3, IDownloadDiskSpaceAidlCallback iDownloadDiskSpaceAidlCallback) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IDownloadDiskSpaceAidlHandler {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler";
        static final int TRANSACTION_cleanUpDisk = 1;

        private static class Proxy implements IDownloadDiskSpaceAidlHandler {
            public static IDownloadDiskSpaceAidlHandler sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler
            public boolean cleanUpDisk(long j2, long j3, IDownloadDiskSpaceAidlCallback iDownloadDiskSpaceAidlCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeLong(j3);
                    parcelObtain.writeStrongBinder(iDownloadDiskSpaceAidlCallback != null ? iDownloadDiskSpaceAidlCallback.asBinder() : null);
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().cleanUpDisk(j2, j3, iDownloadDiskSpaceAidlCallback);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDownloadDiskSpaceAidlHandler asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDownloadDiskSpaceAidlHandler)) ? new Proxy(iBinder) : (IDownloadDiskSpaceAidlHandler) iInterfaceQueryLocalInterface;
        }

        public static IDownloadDiskSpaceAidlHandler getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDownloadDiskSpaceAidlHandler iDownloadDiskSpaceAidlHandler) {
            if (Proxy.sDefaultImpl != null || iDownloadDiskSpaceAidlHandler == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDownloadDiskSpaceAidlHandler;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 != 1) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            boolean zCleanUpDisk = cleanUpDisk(parcel.readLong(), parcel.readLong(), IDownloadDiskSpaceAidlCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeInt(zCleanUpDisk ? 1 : 0);
            return true;
        }
    }

    boolean cleanUpDisk(long j2, long j3, IDownloadDiskSpaceAidlCallback iDownloadDiskSpaceAidlCallback) throws RemoteException;
}
