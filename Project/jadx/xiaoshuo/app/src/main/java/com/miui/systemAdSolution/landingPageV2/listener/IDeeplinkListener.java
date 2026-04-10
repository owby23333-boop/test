package com.miui.systemAdSolution.landingPageV2.listener;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes17.dex */
public interface IDeeplinkListener extends IInterface {

    public static class Default implements IDeeplinkListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IDeeplinkListener
        public void onDeeplinkFail() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IDeeplinkListener
        public void onDeeplinkSuccess() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IDeeplinkListener {
        private static final String DESCRIPTOR = "com.miui.systemAdSolution.landingPageV2.listener.IDeeplinkListener";
        static final int TRANSACTION_onDeeplinkFail = 2;
        static final int TRANSACTION_onDeeplinkSuccess = 1;

        public static class Proxy implements IDeeplinkListener {
            public static IDeeplinkListener sDefaultImpl;
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

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IDeeplinkListener
            public void onDeeplinkFail() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDeeplinkFail();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IDeeplinkListener
            public void onDeeplinkSuccess() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDeeplinkSuccess();
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

        public static IDeeplinkListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDeeplinkListener)) ? new Proxy(iBinder) : (IDeeplinkListener) iInterfaceQueryLocalInterface;
        }

        public static IDeeplinkListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDeeplinkListener iDeeplinkListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iDeeplinkListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDeeplinkListener;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onDeeplinkSuccess();
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            onDeeplinkFail();
            parcel2.writeNoException();
            return true;
        }
    }

    void onDeeplinkFail() throws RemoteException;

    void onDeeplinkSuccess() throws RemoteException;
}
