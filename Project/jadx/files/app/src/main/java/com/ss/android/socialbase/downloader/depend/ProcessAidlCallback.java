package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ProcessAidlCallback extends IInterface {

    public static class Default implements ProcessAidlCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.ProcessAidlCallback
        public void callback(int i2, int i3) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ProcessAidlCallback {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.ProcessAidlCallback";
        static final int TRANSACTION_callback = 1;

        private static class Proxy implements ProcessAidlCallback {
            public static ProcessAidlCallback sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.ss.android.socialbase.downloader.depend.ProcessAidlCallback
            public void callback(int i2, int i3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().callback(i2, i3);
                    }
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

        public static ProcessAidlCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ProcessAidlCallback)) ? new Proxy(iBinder) : (ProcessAidlCallback) iInterfaceQueryLocalInterface;
        }

        public static ProcessAidlCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ProcessAidlCallback processAidlCallback) {
            if (Proxy.sDefaultImpl != null || processAidlCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = processAidlCallback;
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
            callback(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    void callback(int i2, int i3) throws RemoteException;
}
