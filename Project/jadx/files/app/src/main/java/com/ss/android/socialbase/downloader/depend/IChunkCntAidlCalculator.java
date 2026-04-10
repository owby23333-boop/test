package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IChunkCntAidlCalculator extends IInterface {

    public static class Default implements IChunkCntAidlCalculator {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator
        public int calculateChunkCount(long j2) throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IChunkCntAidlCalculator {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator";
        static final int TRANSACTION_calculateChunkCount = 1;

        private static class Proxy implements IChunkCntAidlCalculator {
            public static IChunkCntAidlCalculator sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator
            public int calculateChunkCount(long j2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeLong(j2);
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().calculateChunkCount(j2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
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

        public static IChunkCntAidlCalculator asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IChunkCntAidlCalculator)) ? new Proxy(iBinder) : (IChunkCntAidlCalculator) iInterfaceQueryLocalInterface;
        }

        public static IChunkCntAidlCalculator getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IChunkCntAidlCalculator iChunkCntAidlCalculator) {
            if (Proxy.sDefaultImpl != null || iChunkCntAidlCalculator == null) {
                return false;
            }
            Proxy.sDefaultImpl = iChunkCntAidlCalculator;
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
            int iCalculateChunkCount = calculateChunkCount(parcel.readLong());
            parcel2.writeNoException();
            parcel2.writeInt(iCalculateChunkCount);
            return true;
        }
    }

    int calculateChunkCount(long j2) throws RemoteException;
}
