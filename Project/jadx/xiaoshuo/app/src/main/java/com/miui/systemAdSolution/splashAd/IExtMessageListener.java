package com.miui.systemAdSolution.splashAd;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes17.dex */
public interface IExtMessageListener extends IInterface {

    public static class Default implements IExtMessageListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.miui.systemAdSolution.splashAd.IExtMessageListener
        public void onReceive(int i, String str, String str2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IExtMessageListener {
        private static final String DESCRIPTOR = "com.miui.systemAdSolution.splashAd.IExtMessageListener";
        static final int TRANSACTION_onReceive = 1;

        public static class Proxy implements IExtMessageListener {
            public static IExtMessageListener sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.miui.systemAdSolution.splashAd.IExtMessageListener
            public void onReceive(int i, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onReceive(i, str, str2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IExtMessageListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IExtMessageListener)) ? new Proxy(iBinder) : (IExtMessageListener) iInterfaceQueryLocalInterface;
        }

        public static IExtMessageListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IExtMessageListener iExtMessageListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iExtMessageListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iExtMessageListener;
            return true;
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
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            onReceive(parcel.readInt(), parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    void onReceive(int i, String str, String str2) throws RemoteException;
}
