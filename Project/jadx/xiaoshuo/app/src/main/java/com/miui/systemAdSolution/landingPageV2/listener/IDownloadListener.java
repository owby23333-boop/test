package com.miui.systemAdSolution.landingPageV2.listener;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes17.dex */
public interface IDownloadListener extends IInterface {

    public static class Default implements IDownloadListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
        public void onDownloadCancel() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
        public void onDownloadFail() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
        public void onDownloadProgress(int i) throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
        public void onDownloadStart() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
        public void onDownloadSuccess() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
        public void onInstallFail() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
        public void onInstallStart() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
        public void onInstallSuccess() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
        public void onMarketDownloadDenied() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IDownloadListener {
        private static final String DESCRIPTOR = "com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener";
        static final int TRANSACTION_onDownloadCancel = 5;
        static final int TRANSACTION_onDownloadFail = 4;
        static final int TRANSACTION_onDownloadProgress = 3;
        static final int TRANSACTION_onDownloadStart = 1;
        static final int TRANSACTION_onDownloadSuccess = 2;
        static final int TRANSACTION_onInstallFail = 7;
        static final int TRANSACTION_onInstallStart = 8;
        static final int TRANSACTION_onInstallSuccess = 6;
        static final int TRANSACTION_onMarketDownloadDenied = 9;

        public static class Proxy implements IDownloadListener {
            public static IDownloadListener sDefaultImpl;
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

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
            public void onDownloadCancel() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDownloadCancel();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
            public void onDownloadFail() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDownloadFail();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
            public void onDownloadProgress(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDownloadProgress(i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
            public void onDownloadStart() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDownloadStart();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
            public void onDownloadSuccess() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDownloadSuccess();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
            public void onInstallFail() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onInstallFail();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
            public void onInstallStart() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(8, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onInstallStart();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
            public void onInstallSuccess() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onInstallSuccess();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
            public void onMarketDownloadDenied() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(9, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onMarketDownloadDenied();
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

        public static IDownloadListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDownloadListener)) ? new Proxy(iBinder) : (IDownloadListener) iInterfaceQueryLocalInterface;
        }

        public static IDownloadListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDownloadListener iDownloadListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iDownloadListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDownloadListener;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownloadStart();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownloadSuccess();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownloadProgress(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownloadFail();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownloadCancel();
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    onInstallSuccess();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    onInstallFail();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    onInstallStart();
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    onMarketDownloadDenied();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onDownloadCancel() throws RemoteException;

    void onDownloadFail() throws RemoteException;

    void onDownloadProgress(int i) throws RemoteException;

    void onDownloadStart() throws RemoteException;

    void onDownloadSuccess() throws RemoteException;

    void onInstallFail() throws RemoteException;

    void onInstallStart() throws RemoteException;

    void onInstallSuccess() throws RemoteException;

    void onMarketDownloadDenied() throws RemoteException;
}
