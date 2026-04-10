package com.miui.systemAdSolution.landingPage;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.miui.systemAdSolution.landingPage.ILandingPageListener;

/* JADX INFO: loaded from: classes17.dex */
public interface ILandingPageService extends IInterface {

    public static class Default implements ILandingPageService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageService
        public boolean cancleDownload(String str) throws RemoteException {
            return false;
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageService
        public void deeplinkStartApp(String str, Bundle bundle) throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageService
        public long getDownloadId(String str) throws RemoteException {
            return 0L;
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageService
        public int getPackageInstallationStatus(String str) throws RemoteException {
            return 0;
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageService
        public int getServiceVersion() throws RemoteException {
            return 0;
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageService
        public void pauseDownload(String str) throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageService
        public void registerListener(String str, ILandingPageListener iLandingPageListener) throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageService
        public void resumeDownload(String str) throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageService
        public void showAppDetailCard(String str, Bundle bundle) throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageService
        public void startDownload(String str, Bundle bundle) throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPage.ILandingPageService
        public void unregisterListener(String str, ILandingPageListener iLandingPageListener) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ILandingPageService {
        private static final String DESCRIPTOR = "com.miui.systemAdSolution.landingPage.ILandingPageService";
        static final int TRANSACTION_cancleDownload = 5;
        static final int TRANSACTION_deeplinkStartApp = 1;
        static final int TRANSACTION_getDownloadId = 8;
        static final int TRANSACTION_getPackageInstallationStatus = 2;
        static final int TRANSACTION_getServiceVersion = 7;
        static final int TRANSACTION_pauseDownload = 10;
        static final int TRANSACTION_registerListener = 6;
        static final int TRANSACTION_resumeDownload = 11;
        static final int TRANSACTION_showAppDetailCard = 3;
        static final int TRANSACTION_startDownload = 4;
        static final int TRANSACTION_unregisterListener = 9;

        public static class Proxy implements ILandingPageService {
            public static ILandingPageService sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageService
            public boolean cancleDownload(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().cancleDownload(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageService
            public void deeplinkStartApp(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().deeplinkStartApp(str, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageService
            public long getDownloadId(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(8, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadId(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageService
            public int getPackageInstallationStatus(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPackageInstallationStatus(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageService
            public int getServiceVersion() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getServiceVersion();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageService
            public void pauseDownload(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(10, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().pauseDownload(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageService
            public void registerListener(String str, ILandingPageListener iLandingPageListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iLandingPageListener != null ? iLandingPageListener.asBinder() : null);
                    if (this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().registerListener(str, iLandingPageListener);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageService
            public void resumeDownload(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(11, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().resumeDownload(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageService
            public void showAppDetailCard(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().showAppDetailCard(str, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageService
            public void startDownload(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().startDownload(str, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPage.ILandingPageService
            public void unregisterListener(String str, ILandingPageListener iLandingPageListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iLandingPageListener != null ? iLandingPageListener.asBinder() : null);
                    if (this.mRemote.transact(9, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().unregisterListener(str, iLandingPageListener);
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

        public static ILandingPageService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ILandingPageService)) ? new Proxy(iBinder) : (ILandingPageService) iInterfaceQueryLocalInterface;
        }

        public static ILandingPageService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ILandingPageService iLandingPageService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iLandingPageService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iLandingPageService;
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
                    deeplinkStartApp(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    int packageInstallationStatus = getPackageInstallationStatus(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(packageInstallationStatus);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    showAppDetailCard(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    startDownload(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zCancleDownload = cancleDownload(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zCancleDownload ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerListener(parcel.readString(), ILandingPageListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    int serviceVersion = getServiceVersion();
                    parcel2.writeNoException();
                    parcel2.writeInt(serviceVersion);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    long downloadId = getDownloadId(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeLong(downloadId);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterListener(parcel.readString(), ILandingPageListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    pauseDownload(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    resumeDownload(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    boolean cancleDownload(String str) throws RemoteException;

    void deeplinkStartApp(String str, Bundle bundle) throws RemoteException;

    long getDownloadId(String str) throws RemoteException;

    int getPackageInstallationStatus(String str) throws RemoteException;

    int getServiceVersion() throws RemoteException;

    void pauseDownload(String str) throws RemoteException;

    void registerListener(String str, ILandingPageListener iLandingPageListener) throws RemoteException;

    void resumeDownload(String str) throws RemoteException;

    void showAppDetailCard(String str, Bundle bundle) throws RemoteException;

    void startDownload(String str, Bundle bundle) throws RemoteException;

    void unregisterListener(String str, ILandingPageListener iLandingPageListener) throws RemoteException;
}
