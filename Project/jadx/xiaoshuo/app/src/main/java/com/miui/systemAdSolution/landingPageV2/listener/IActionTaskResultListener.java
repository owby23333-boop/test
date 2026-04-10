package com.miui.systemAdSolution.landingPageV2.listener;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes17.dex */
public interface IActionTaskResultListener extends IInterface {

    public static class Default implements IActionTaskResultListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IActionTaskResultListener
        public void onActionTaskCreate(String str) throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IActionTaskResultListener
        public void onResultFail() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IActionTaskResultListener
        public void onResultSuccess() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IActionTaskResultListener {
        private static final String DESCRIPTOR = "com.miui.systemAdSolution.landingPageV2.listener.IActionTaskResultListener";
        static final int TRANSACTION_onActionTaskCreate = 1;
        static final int TRANSACTION_onResultFail = 3;
        static final int TRANSACTION_onResultSuccess = 2;

        public static class Proxy implements IActionTaskResultListener {
            public static IActionTaskResultListener sDefaultImpl;
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

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IActionTaskResultListener
            public void onActionTaskCreate(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onActionTaskCreate(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IActionTaskResultListener
            public void onResultFail() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onResultFail();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IActionTaskResultListener
            public void onResultSuccess() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onResultSuccess();
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

        public static IActionTaskResultListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IActionTaskResultListener)) ? new Proxy(iBinder) : (IActionTaskResultListener) iInterfaceQueryLocalInterface;
        }

        public static IActionTaskResultListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IActionTaskResultListener iActionTaskResultListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iActionTaskResultListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iActionTaskResultListener;
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
                onActionTaskCreate(parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onResultSuccess();
                parcel2.writeNoException();
                return true;
            }
            if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            onResultFail();
            parcel2.writeNoException();
            return true;
        }
    }

    void onActionTaskCreate(String str) throws RemoteException;

    void onResultFail() throws RemoteException;

    void onResultSuccess() throws RemoteException;
}
