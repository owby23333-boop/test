package com.miui.systemAdSolution.landingPageV2.listener;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes17.dex */
public interface IH5Listener extends IInterface {

    public static class Default implements IH5Listener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IH5Listener
        public void onH5Fail() throws RemoteException {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IH5Listener
        public void onH5Success() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IH5Listener {
        private static final String DESCRIPTOR = "com.miui.systemAdSolution.landingPageV2.listener.IH5Listener";
        static final int TRANSACTION_onH5Fail = 2;
        static final int TRANSACTION_onH5Success = 1;

        public static class Proxy implements IH5Listener {
            public static IH5Listener sDefaultImpl;
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

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IH5Listener
            public void onH5Fail() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onH5Fail();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IH5Listener
            public void onH5Success() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onH5Success();
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

        public static IH5Listener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IH5Listener)) ? new Proxy(iBinder) : (IH5Listener) iInterfaceQueryLocalInterface;
        }

        public static IH5Listener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IH5Listener iH5Listener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iH5Listener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iH5Listener;
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
                onH5Success();
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
            onH5Fail();
            parcel2.writeNoException();
            return true;
        }
    }

    void onH5Fail() throws RemoteException;

    void onH5Success() throws RemoteException;
}
