package com.miui.systemAdSolution.splashAd;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.miui.systemAdSolution.splashAd.IExtMessageListener;

/* JADX INFO: loaded from: classes17.dex */
public interface ISystemExtMessageService extends IInterface {

    public static class Default implements ISystemExtMessageService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.miui.systemAdSolution.splashAd.ISystemExtMessageService
        public void sendExtMessage(String str, String str2, IExtMessageListener iExtMessageListener) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ISystemExtMessageService {
        private static final String DESCRIPTOR = "com.miui.systemAdSolution.splashAd.ISystemExtMessageService";
        static final int TRANSACTION_sendExtMessage = 1;

        public static class Proxy implements ISystemExtMessageService {
            public static ISystemExtMessageService sDefaultImpl;
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

            @Override // com.miui.systemAdSolution.splashAd.ISystemExtMessageService
            public void sendExtMessage(String str, String str2, IExtMessageListener iExtMessageListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iExtMessageListener != null ? iExtMessageListener.asBinder() : null);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().sendExtMessage(str, str2, iExtMessageListener);
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

        public static ISystemExtMessageService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ISystemExtMessageService)) ? new Proxy(iBinder) : (ISystemExtMessageService) iInterfaceQueryLocalInterface;
        }

        public static ISystemExtMessageService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ISystemExtMessageService iSystemExtMessageService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iSystemExtMessageService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iSystemExtMessageService;
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
            sendExtMessage(parcel.readString(), parcel.readString(), IExtMessageListener.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
    }

    void sendExtMessage(String str, String str2, IExtMessageListener iExtMessageListener) throws RemoteException;
}
