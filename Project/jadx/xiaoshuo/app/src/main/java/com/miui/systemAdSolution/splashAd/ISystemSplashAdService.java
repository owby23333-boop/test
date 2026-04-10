package com.miui.systemAdSolution.splashAd;

import android.graphics.Rect;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.miui.systemAdSolution.splashAd.IAdListener;

/* JADX INFO: loaded from: classes17.dex */
public interface ISystemSplashAdService extends IInterface {

    public static class Default implements ISystemSplashAdService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.miui.systemAdSolution.splashAd.ISystemSplashAdService
        public void cancelSplashAd(String str) throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.splashAd.ISystemSplashAdService
        public long getLastSystemSplashShowTime(String str) throws RemoteException {
            return 0L;
        }

        @Override // com.miui.systemAdSolution.splashAd.ISystemSplashAdService
        public boolean isSupportPassiveSplashAd(String str) throws RemoteException {
            return false;
        }

        @Override // com.miui.systemAdSolution.splashAd.ISystemSplashAdService
        public boolean requestSplashAd(String str, IAdListener iAdListener) throws RemoteException {
            return false;
        }

        @Override // com.miui.systemAdSolution.splashAd.ISystemSplashAdService
        public void setSplashAdConfig(String str, String str2) throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.splashAd.ISystemSplashAdService
        public void setSplashAdListener(String str, IAdListener iAdListener) throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.splashAd.ISystemSplashAdService
        public void setTransitionAnimation(String str, Rect rect) throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.splashAd.ISystemSplashAdService
        public void showSplashAd(String str, Bundle bundle) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ISystemSplashAdService {
        private static final String DESCRIPTOR = "com.miui.systemAdSolution.splashAd.ISystemSplashAdService";
        static final int TRANSACTION_cancelSplashAd = 2;
        static final int TRANSACTION_getLastSystemSplashShowTime = 7;
        static final int TRANSACTION_isSupportPassiveSplashAd = 6;
        static final int TRANSACTION_requestSplashAd = 1;
        static final int TRANSACTION_setSplashAdConfig = 4;
        static final int TRANSACTION_setSplashAdListener = 5;
        static final int TRANSACTION_setTransitionAnimation = 3;
        static final int TRANSACTION_showSplashAd = 8;

        public static class Proxy implements ISystemSplashAdService {
            public static ISystemSplashAdService sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.miui.systemAdSolution.splashAd.ISystemSplashAdService
            public void cancelSplashAd(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().cancelSplashAd(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.miui.systemAdSolution.splashAd.ISystemSplashAdService
            public long getLastSystemSplashShowTime(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLastSystemSplashShowTime(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.splashAd.ISystemSplashAdService
            public boolean isSupportPassiveSplashAd(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isSupportPassiveSplashAd(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.splashAd.ISystemSplashAdService
            public boolean requestSplashAd(String str, IAdListener iAdListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iAdListener != null ? iAdListener.asBinder() : null);
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().requestSplashAd(str, iAdListener);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.splashAd.ISystemSplashAdService
            public void setSplashAdConfig(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setSplashAdConfig(str, str2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.splashAd.ISystemSplashAdService
            public void setSplashAdListener(String str, IAdListener iAdListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iAdListener != null ? iAdListener.asBinder() : null);
                    if (this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setSplashAdListener(str, iAdListener);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.splashAd.ISystemSplashAdService
            public void setTransitionAnimation(String str, Rect rect) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (rect != null) {
                        parcelObtain.writeInt(1);
                        rect.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setTransitionAnimation(str, rect);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.splashAd.ISystemSplashAdService
            public void showSplashAd(String str, Bundle bundle) throws RemoteException {
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
                    if (this.mRemote.transact(8, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().showSplashAd(str, bundle);
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

        public static ISystemSplashAdService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ISystemSplashAdService)) ? new Proxy(iBinder) : (ISystemSplashAdService) iInterfaceQueryLocalInterface;
        }

        public static ISystemSplashAdService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ISystemSplashAdService iSystemSplashAdService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iSystemSplashAdService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iSystemSplashAdService;
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
                    boolean zRequestSplashAd = requestSplashAd(parcel.readString(), IAdListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zRequestSplashAd ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    cancelSplashAd(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    setTransitionAnimation(parcel.readString(), parcel.readInt() != 0 ? (Rect) Rect.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    setSplashAdConfig(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    setSplashAdListener(parcel.readString(), IAdListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zIsSupportPassiveSplashAd = isSupportPassiveSplashAd(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsSupportPassiveSplashAd ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    long lastSystemSplashShowTime = getLastSystemSplashShowTime(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeLong(lastSystemSplashShowTime);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    showSplashAd(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void cancelSplashAd(String str) throws RemoteException;

    long getLastSystemSplashShowTime(String str) throws RemoteException;

    boolean isSupportPassiveSplashAd(String str) throws RemoteException;

    boolean requestSplashAd(String str, IAdListener iAdListener) throws RemoteException;

    void setSplashAdConfig(String str, String str2) throws RemoteException;

    void setSplashAdListener(String str, IAdListener iAdListener) throws RemoteException;

    void setTransitionAnimation(String str, Rect rect) throws RemoteException;

    void showSplashAd(String str, Bundle bundle) throws RemoteException;
}
