package com.miui.systemAdSolution.landingPageV2.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.miui.systemAdSolution.landingPageV2.listener.IActionTaskResultListener;
import com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener;
import com.miui.systemAdSolution.landingPageV2.listener.IInstallListener;
import com.miui.systemAdSolution.landingPageV2.task.action.Action;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public interface ILandingPageServiceV2 extends IInterface {

    public static class Default implements ILandingPageServiceV2 {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
        public boolean cancelDownload(String str) throws RemoteException {
            return false;
        }

        @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
        public void cancelTask(String str) throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
        public boolean downloadViaMarket(IDownloadListener iDownloadListener, String str, String str2) throws RemoteException {
            return false;
        }

        @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
        public boolean downloadViaMsa(IDownloadListener iDownloadListener, String str, String str2, String str3, int i, String str4) throws RemoteException {
            return false;
        }

        @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
        public void executeTask(List<Action> list, IActionTaskResultListener iActionTaskResultListener) throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
        public long getNativeDownloadId(String str) throws RemoteException {
            return 0L;
        }

        @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
        public int getPackageDownloadStatus(String str) throws RemoteException {
            return 0;
        }

        @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
        public int getServiceVersion() throws RemoteException {
            return 0;
        }

        @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
        public boolean handleDeeplinkViaMsa(String str, String str2, String str3) throws RemoteException {
            return false;
        }

        @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
        public boolean installSilently(String str, String str2, IInstallListener iInstallListener) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements ILandingPageServiceV2 {
        private static final String DESCRIPTOR = "com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2";
        static final int TRANSACTION_cancelDownload = 9;
        static final int TRANSACTION_cancelTask = 3;
        static final int TRANSACTION_downloadViaMarket = 10;
        static final int TRANSACTION_downloadViaMsa = 8;
        static final int TRANSACTION_executeTask = 2;
        static final int TRANSACTION_getNativeDownloadId = 5;
        static final int TRANSACTION_getPackageDownloadStatus = 4;
        static final int TRANSACTION_getServiceVersion = 1;
        static final int TRANSACTION_handleDeeplinkViaMsa = 7;
        static final int TRANSACTION_installSilently = 6;

        public static class Proxy implements ILandingPageServiceV2 {
            public static ILandingPageServiceV2 sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
            public boolean cancelDownload(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(9, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().cancelDownload(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
            public void cancelTask(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().cancelTask(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
            public boolean downloadViaMarket(IDownloadListener iDownloadListener, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iDownloadListener != null ? iDownloadListener.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.mRemote.transact(10, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().downloadViaMarket(iDownloadListener, str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
            public boolean downloadViaMsa(IDownloadListener iDownloadListener, String str, String str2, String str3, int i, String str4) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iDownloadListener != null ? iDownloadListener.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str4);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (!this.mRemote.transact(8, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        boolean zDownloadViaMsa = Stub.getDefaultImpl().downloadViaMsa(iDownloadListener, str, str2, str3, i, str4);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return zDownloadViaMsa;
                    }
                    parcelObtain2.readException();
                    boolean z = parcelObtain2.readInt() != 0;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
            public void executeTask(List<Action> list, IActionTaskResultListener iActionTaskResultListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeTypedList(list);
                    parcelObtain.writeStrongBinder(iActionTaskResultListener != null ? iActionTaskResultListener.asBinder() : null);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().executeTask(list, iActionTaskResultListener);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
            public long getNativeDownloadId(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getNativeDownloadId(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
            public int getPackageDownloadStatus(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPackageDownloadStatus(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
            public int getServiceVersion() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getServiceVersion();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
            public boolean handleDeeplinkViaMsa(String str, String str2, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    if (!this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().handleDeeplinkViaMsa(str, str2, str3);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2
            public boolean installSilently(String str, String str2, IInstallListener iInstallListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iInstallListener != null ? iInstallListener.asBinder() : null);
                    if (!this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().installSilently(str, str2, iInstallListener);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ILandingPageServiceV2 asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ILandingPageServiceV2)) ? new Proxy(iBinder) : (ILandingPageServiceV2) iInterfaceQueryLocalInterface;
        }

        public static ILandingPageServiceV2 getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ILandingPageServiceV2 iLandingPageServiceV2) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iLandingPageServiceV2 == null) {
                return false;
            }
            Proxy.sDefaultImpl = iLandingPageServiceV2;
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
                    int serviceVersion = getServiceVersion();
                    parcel2.writeNoException();
                    parcel2.writeInt(serviceVersion);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    executeTask(parcel.createTypedArrayList(Action.CREATOR), IActionTaskResultListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    cancelTask(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    int packageDownloadStatus = getPackageDownloadStatus(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(packageDownloadStatus);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    long nativeDownloadId = getNativeDownloadId(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeLong(nativeDownloadId);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zInstallSilently = installSilently(parcel.readString(), parcel.readString(), IInstallListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zInstallSilently ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zHandleDeeplinkViaMsa = handleDeeplinkViaMsa(parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zHandleDeeplinkViaMsa ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zDownloadViaMsa = downloadViaMsa(IDownloadListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zDownloadViaMsa ? 1 : 0);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zCancelDownload = cancelDownload(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zCancelDownload ? 1 : 0);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zDownloadViaMarket = downloadViaMarket(IDownloadListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zDownloadViaMarket ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    boolean cancelDownload(String str) throws RemoteException;

    void cancelTask(String str) throws RemoteException;

    boolean downloadViaMarket(IDownloadListener iDownloadListener, String str, String str2) throws RemoteException;

    boolean downloadViaMsa(IDownloadListener iDownloadListener, String str, String str2, String str3, int i, String str4) throws RemoteException;

    void executeTask(List<Action> list, IActionTaskResultListener iActionTaskResultListener) throws RemoteException;

    long getNativeDownloadId(String str) throws RemoteException;

    int getPackageDownloadStatus(String str) throws RemoteException;

    int getServiceVersion() throws RemoteException;

    boolean handleDeeplinkViaMsa(String str, String str2, String str3) throws RemoteException;

    boolean installSilently(String str, String str2, IInstallListener iInstallListener) throws RemoteException;
}
