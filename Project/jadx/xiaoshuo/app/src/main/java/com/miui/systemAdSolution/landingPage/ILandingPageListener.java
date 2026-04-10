package com.miui.systemAdSolution.landingPage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes17.dex */
public interface ILandingPageListener extends IInterface {

    public static class Default implements ILandingPageListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
        public void onDeeplinkFail() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
        public void onDeeplinkSuccess() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
        public void onDownloadCancel() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
        public void onDownloadFail(String str) throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
        public void onDownloadPause(String str) throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
        public void onDownloadPaused() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
        public void onDownloadProgress(int i) throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
        public void onDownloadResume() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
        public void onDownloadStart() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
        public void onDownloadSuccess() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
        public void onH5Fail() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
        public void onH5Success() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
        public void onInstallFail(String str) throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
        public void onInstallStart() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
        public void onInstallSuccess() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
        public void onLanuchAppFail() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
        public void onLanuchAppSuccess() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
        public void onMarketDownloadDenied() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
        public void onStartDownloadFail() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ILandingPageListener {
        private static final String DESCRIPTOR = "com.miui.systemAdSolution.landingPage.ILandingPageListener";
        static final int TRANSACTION_onDeeplinkFail = 10;
        static final int TRANSACTION_onDeeplinkSuccess = 9;
        static final int TRANSACTION_onDownloadCancel = 6;
        static final int TRANSACTION_onDownloadFail = 3;
        static final int TRANSACTION_onDownloadPause = 4;
        static final int TRANSACTION_onDownloadPaused = 18;
        static final int TRANSACTION_onDownloadProgress = 5;
        static final int TRANSACTION_onDownloadResume = 19;
        static final int TRANSACTION_onDownloadStart = 1;
        static final int TRANSACTION_onDownloadSuccess = 2;
        static final int TRANSACTION_onH5Fail = 12;
        static final int TRANSACTION_onH5Success = 11;
        static final int TRANSACTION_onInstallFail = 8;
        static final int TRANSACTION_onInstallStart = 15;
        static final int TRANSACTION_onInstallSuccess = 7;
        static final int TRANSACTION_onLanuchAppFail = 14;
        static final int TRANSACTION_onLanuchAppSuccess = 13;
        static final int TRANSACTION_onMarketDownloadDenied = 16;
        static final int TRANSACTION_onStartDownloadFail = 17;

        public static class Proxy implements ILandingPageListener {
            public static ILandingPageListener sDefaultImpl;
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

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
            public void onDeeplinkFail() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(10, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDeeplinkFail();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
            public void onDeeplinkSuccess() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(9, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDeeplinkSuccess();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
            public void onDownloadCancel() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDownloadCancel();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
            public void onDownloadFail(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDownloadFail(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
            public void onDownloadPause(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDownloadPause(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
            public void onDownloadPaused() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(18, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDownloadPaused();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
            public void onDownloadProgress(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDownloadProgress(i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
            public void onDownloadResume() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(19, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDownloadResume();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
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

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
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

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
            public void onH5Fail() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(12, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onH5Fail();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
            public void onH5Success() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(11, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onH5Success();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
            public void onInstallFail(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(8, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onInstallFail(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
            public void onInstallStart() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(15, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onInstallStart();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
            public void onInstallSuccess() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onInstallSuccess();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
            public void onLanuchAppFail() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(14, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onLanuchAppFail();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
            public void onLanuchAppSuccess() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(13, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onLanuchAppSuccess();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
            public void onMarketDownloadDenied() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(16, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onMarketDownloadDenied();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageListener
            public void onStartDownloadFail() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(17, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onStartDownloadFail();
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

        public static ILandingPageListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ILandingPageListener)) ? new Proxy(iBinder) : (ILandingPageListener) iInterfaceQueryLocalInterface;
        }

        public static ILandingPageListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ILandingPageListener iLandingPageListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iLandingPageListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iLandingPageListener;
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
                    onDownloadFail(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownloadPause(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownloadProgress(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownloadCancel();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    onInstallSuccess();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    onInstallFail(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDeeplinkSuccess();
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDeeplinkFail();
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    onH5Success();
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    onH5Fail();
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    onLanuchAppSuccess();
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    onLanuchAppFail();
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    onInstallStart();
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    onMarketDownloadDenied();
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    onStartDownloadFail();
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownloadPaused();
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownloadResume();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onDeeplinkFail() throws RemoteException;

    void onDeeplinkSuccess() throws RemoteException;

    void onDownloadCancel() throws RemoteException;

    void onDownloadFail(String str) throws RemoteException;

    void onDownloadPause(String str) throws RemoteException;

    void onDownloadPaused() throws RemoteException;

    void onDownloadProgress(int i) throws RemoteException;

    void onDownloadResume() throws RemoteException;

    void onDownloadStart() throws RemoteException;

    void onDownloadSuccess() throws RemoteException;

    void onH5Fail() throws RemoteException;

    void onH5Success() throws RemoteException;

    void onInstallFail(String str) throws RemoteException;

    void onInstallStart() throws RemoteException;

    void onInstallSuccess() throws RemoteException;

    void onLanuchAppFail() throws RemoteException;

    void onLanuchAppSuccess() throws RemoteException;

    void onMarketDownloadDenied() throws RemoteException;

    void onStartDownloadFail() throws RemoteException;
}
