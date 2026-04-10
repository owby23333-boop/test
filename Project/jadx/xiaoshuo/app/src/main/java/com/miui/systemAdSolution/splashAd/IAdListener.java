package com.miui.systemAdSolution.splashAd;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes17.dex */
public interface IAdListener extends IInterface {

    public static class Default implements IAdListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.miui.systemAdSolution.splashAd.IAdListener
        public void onAdClick() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.splashAd.IAdListener
        public void onAdDismissed() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.splashAd.IAdListener
        public void onAdError() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.splashAd.IAdListener
        public void onAdLoaded() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.splashAd.IAdListener
        public void onAdShowError(int i) throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.splashAd.IAdListener
        public void onAdSkip() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.splashAd.IAdListener
        public boolean onClickJumpToMiniProgram(long j, String str, String str2) throws RemoteException {
            return false;
        }

        @Override // com.miui.systemAdSolution.splashAd.IAdListener
        public void onTransitionAdLoaded(String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAdListener {
        private static final String DESCRIPTOR = "com.miui.systemAdSolution.splashAd.IAdListener";
        static final int TRANSACTION_onAdClick = 4;
        static final int TRANSACTION_onAdDismissed = 6;
        static final int TRANSACTION_onAdError = 1;
        static final int TRANSACTION_onAdLoaded = 2;
        static final int TRANSACTION_onAdShowError = 7;
        static final int TRANSACTION_onAdSkip = 5;
        static final int TRANSACTION_onClickJumpToMiniProgram = 8;
        static final int TRANSACTION_onTransitionAdLoaded = 3;

        public static class Proxy implements IAdListener {
            public static IAdListener sDefaultImpl;
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

            @Override // com.miui.systemAdSolution.splashAd.IAdListener
            public void onAdClick() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onAdClick();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.splashAd.IAdListener
            public void onAdDismissed() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onAdDismissed();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.splashAd.IAdListener
            public void onAdError() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onAdError();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.splashAd.IAdListener
            public void onAdLoaded() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onAdLoaded();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.splashAd.IAdListener
            public void onAdShowError(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onAdShowError(i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.splashAd.IAdListener
            public void onAdSkip() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onAdSkip();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.splashAd.IAdListener
            public boolean onClickJumpToMiniProgram(long j, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.mRemote.transact(8, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().onClickJumpToMiniProgram(j, str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.splashAd.IAdListener
            public void onTransitionAdLoaded(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onTransitionAdLoaded(str);
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

        public static IAdListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAdListener)) ? new Proxy(iBinder) : (IAdListener) iInterfaceQueryLocalInterface;
        }

        public static IAdListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IAdListener iAdListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iAdListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iAdListener;
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
                    onAdError();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    onAdLoaded();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    onTransitionAdLoaded(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    onAdClick();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    onAdSkip();
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    onAdDismissed();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    onAdShowError(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zOnClickJumpToMiniProgram = onClickJumpToMiniProgram(parcel.readLong(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zOnClickJumpToMiniProgram ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onAdClick() throws RemoteException;

    void onAdDismissed() throws RemoteException;

    void onAdError() throws RemoteException;

    void onAdLoaded() throws RemoteException;

    void onAdShowError(int i) throws RemoteException;

    void onAdSkip() throws RemoteException;

    boolean onClickJumpToMiniProgram(long j, String str, String str2) throws RemoteException;

    void onTransitionAdLoaded(String str) throws RemoteException;
}
