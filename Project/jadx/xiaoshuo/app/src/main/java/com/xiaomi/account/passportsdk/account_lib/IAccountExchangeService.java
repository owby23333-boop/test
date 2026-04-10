package com.xiaomi.account.passportsdk.account_lib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.xiaomi.accountsdk.account.data.AccountInfo;

/* JADX INFO: loaded from: classes5.dex */
public interface IAccountExchangeService extends IInterface {
    public static final String DESCRIPTOR = "com.xiaomi.account.passportsdk.account_lib.IAccountExchangeService";

    public static class Default implements IAccountExchangeService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.xiaomi.account.passportsdk.account_lib.IAccountExchangeService
        public AccountInfo getNullableAccount(String str) throws RemoteException {
            return null;
        }

        @Override // com.xiaomi.account.passportsdk.account_lib.IAccountExchangeService
        public void tryAddAccount(AccountInfo accountInfo, String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAccountExchangeService {
        static final int TRANSACTION_getNullableAccount = 2;
        static final int TRANSACTION_tryAddAccount = 1;

        public static class Proxy implements IAccountExchangeService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IAccountExchangeService.DESCRIPTOR;
            }

            @Override // com.xiaomi.account.passportsdk.account_lib.IAccountExchangeService
            public AccountInfo getNullableAccount(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAccountExchangeService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (AccountInfo) _Parcel.readTypedObject(parcelObtain2, AccountInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.account.passportsdk.account_lib.IAccountExchangeService
            public void tryAddAccount(AccountInfo accountInfo, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAccountExchangeService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, accountInfo, 0);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IAccountExchangeService.DESCRIPTOR);
        }

        public static IAccountExchangeService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IAccountExchangeService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAccountExchangeService)) ? new Proxy(iBinder) : (IAccountExchangeService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IAccountExchangeService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IAccountExchangeService.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                tryAddAccount((AccountInfo) _Parcel.readTypedObject(parcel, AccountInfo.CREATOR), parcel.readString());
            } else {
                if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                AccountInfo nullableAccount = getNullableAccount(parcel.readString());
                parcel2.writeNoException();
                _Parcel.writeTypedObject(parcel2, nullableAccount, 1);
            }
            return true;
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t, int i) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            }
        }
    }

    AccountInfo getNullableAccount(String str) throws RemoteException;

    void tryAddAccount(AccountInfo accountInfo, String str) throws RemoteException;
}
