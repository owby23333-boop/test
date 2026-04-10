package com.xiaomi.accountsdk.account;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
public interface IFindDeviceRemoveAccountService extends IInterface {
    public static final String DESCRIPTOR = "com.xiaomi.accountsdk.account.IFindDeviceRemoveAccountService";

    public static class Default implements IFindDeviceRemoveAccountService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.xiaomi.accountsdk.account.IFindDeviceRemoveAccountService
        public boolean removeAccount() throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IFindDeviceRemoveAccountService {
        static final int TRANSACTION_removeAccount = 1;

        public static class Proxy implements IFindDeviceRemoveAccountService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IFindDeviceRemoveAccountService.DESCRIPTOR;
            }

            @Override // com.xiaomi.accountsdk.account.IFindDeviceRemoveAccountService
            public boolean removeAccount() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFindDeviceRemoveAccountService.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IFindDeviceRemoveAccountService.DESCRIPTOR);
        }

        public static IFindDeviceRemoveAccountService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IFindDeviceRemoveAccountService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IFindDeviceRemoveAccountService)) ? new Proxy(iBinder) : (IFindDeviceRemoveAccountService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IFindDeviceRemoveAccountService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IFindDeviceRemoveAccountService.DESCRIPTOR);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            boolean zRemoveAccount = removeAccount();
            parcel2.writeNoException();
            parcel2.writeInt(zRemoveAccount ? 1 : 0);
            return true;
        }
    }

    boolean removeAccount() throws RemoteException;
}
