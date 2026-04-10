package com.xiaomi.accounts;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.xiaomi.accounts.IAccountManagerResponse;

/* JADX INFO: loaded from: classes5.dex */
public interface IAccountManagerService extends IInterface {
    public static final String DESCRIPTOR = "com.xiaomi.accounts.IAccountManagerService";

    public static class Default implements IAccountManagerService {
        @Override // com.xiaomi.accounts.IAccountManagerService
        public boolean addAccount(Account account, String str, Bundle bundle) throws RemoteException {
            return false;
        }

        @Override // com.xiaomi.accounts.IAccountManagerService
        public void addAcount(IAccountManagerResponse iAccountManagerResponse, String str, String str2, String[] strArr, boolean z, Bundle bundle) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.xiaomi.accounts.IAccountManagerService
        public void clearPassword(Account account) throws RemoteException {
        }

        @Override // com.xiaomi.accounts.IAccountManagerService
        public void confirmCredentials(IAccountManagerResponse iAccountManagerResponse, Account account, Bundle bundle, boolean z) throws RemoteException {
        }

        @Override // com.xiaomi.accounts.IAccountManagerService
        public void editProperties(IAccountManagerResponse iAccountManagerResponse, String str, boolean z) throws RemoteException {
        }

        @Override // com.xiaomi.accounts.IAccountManagerService
        public Account[] getAccounts(String str) throws RemoteException {
            return null;
        }

        @Override // com.xiaomi.accounts.IAccountManagerService
        public void getAccountsByFeatures(IAccountManagerResponse iAccountManagerResponse, String str, String[] strArr) throws RemoteException {
        }

        @Override // com.xiaomi.accounts.IAccountManagerService
        public void getAuthToken(IAccountManagerResponse iAccountManagerResponse, Account account, String str, boolean z, boolean z2, Bundle bundle) throws RemoteException {
        }

        @Override // com.xiaomi.accounts.IAccountManagerService
        public void getAuthTokenLabel(IAccountManagerResponse iAccountManagerResponse, String str, String str2) throws RemoteException {
        }

        @Override // com.xiaomi.accounts.IAccountManagerService
        public String getPassword(Account account) throws RemoteException {
            return null;
        }

        @Override // com.xiaomi.accounts.IAccountManagerService
        public String getUserData(Account account, String str) throws RemoteException {
            return null;
        }

        @Override // com.xiaomi.accounts.IAccountManagerService
        public void hasFeatures(IAccountManagerResponse iAccountManagerResponse, Account account, String[] strArr) throws RemoteException {
        }

        @Override // com.xiaomi.accounts.IAccountManagerService
        public void invalidateAuthToken(String str, String str2) throws RemoteException {
        }

        @Override // com.xiaomi.accounts.IAccountManagerService
        public String peekAuthToken(Account account, String str) throws RemoteException {
            return null;
        }

        @Override // com.xiaomi.accounts.IAccountManagerService
        public void removeAccount(IAccountManagerResponse iAccountManagerResponse, Account account) throws RemoteException {
        }

        @Override // com.xiaomi.accounts.IAccountManagerService
        public void setAuthToken(Account account, String str, String str2) throws RemoteException {
        }

        @Override // com.xiaomi.accounts.IAccountManagerService
        public void setPassword(Account account, String str) throws RemoteException {
        }

        @Override // com.xiaomi.accounts.IAccountManagerService
        public void setUserData(Account account, String str, String str2) throws RemoteException {
        }

        @Override // com.xiaomi.accounts.IAccountManagerService
        public void updateAppPermission(Account account, String str, int i, boolean z) throws RemoteException {
        }

        @Override // com.xiaomi.accounts.IAccountManagerService
        public void updateCredentials(IAccountManagerResponse iAccountManagerResponse, Account account, String str, boolean z, Bundle bundle) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAccountManagerService {
        static final int TRANSACTION_addAccount = 6;
        static final int TRANSACTION_addAcount = 16;
        static final int TRANSACTION_clearPassword = 12;
        static final int TRANSACTION_confirmCredentials = 19;
        static final int TRANSACTION_editProperties = 18;
        static final int TRANSACTION_getAccounts = 3;
        static final int TRANSACTION_getAccountsByFeatures = 5;
        static final int TRANSACTION_getAuthToken = 15;
        static final int TRANSACTION_getAuthTokenLabel = 20;
        static final int TRANSACTION_getPassword = 1;
        static final int TRANSACTION_getUserData = 2;
        static final int TRANSACTION_hasFeatures = 4;
        static final int TRANSACTION_invalidateAuthToken = 8;
        static final int TRANSACTION_peekAuthToken = 9;
        static final int TRANSACTION_removeAccount = 7;
        static final int TRANSACTION_setAuthToken = 10;
        static final int TRANSACTION_setPassword = 11;
        static final int TRANSACTION_setUserData = 13;
        static final int TRANSACTION_updateAppPermission = 14;
        static final int TRANSACTION_updateCredentials = 17;

        public static class Proxy implements IAccountManagerService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.xiaomi.accounts.IAccountManagerService
            public boolean addAccount(Account account, String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAccountManagerService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, account, 0);
                    parcelObtain.writeString(str);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.accounts.IAccountManagerService
            public void addAcount(IAccountManagerResponse iAccountManagerResponse, String str, String str2, String[] strArr, boolean z, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAccountManagerService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iAccountManagerResponse);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStringArray(strArr);
                    parcelObtain.writeInt(z ? 1 : 0);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.xiaomi.accounts.IAccountManagerService
            public void clearPassword(Account account) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAccountManagerService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, account, 0);
                    this.mRemote.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.accounts.IAccountManagerService
            public void confirmCredentials(IAccountManagerResponse iAccountManagerResponse, Account account, Bundle bundle, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAccountManagerService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iAccountManagerResponse);
                    _Parcel.writeTypedObject(parcelObtain, account, 0);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(19, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.accounts.IAccountManagerService
            public void editProperties(IAccountManagerResponse iAccountManagerResponse, String str, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAccountManagerService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iAccountManagerResponse);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.accounts.IAccountManagerService
            public Account[] getAccounts(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAccountManagerService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Account[]) parcelObtain2.createTypedArray(Account.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.accounts.IAccountManagerService
            public void getAccountsByFeatures(IAccountManagerResponse iAccountManagerResponse, String str, String[] strArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAccountManagerService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iAccountManagerResponse);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStringArray(strArr);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.accounts.IAccountManagerService
            public void getAuthToken(IAccountManagerResponse iAccountManagerResponse, Account account, String str, boolean z, boolean z2, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAccountManagerService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iAccountManagerResponse);
                    _Parcel.writeTypedObject(parcelObtain, account, 0);
                    parcelObtain.writeString(str);
                    int i = 1;
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i = 0;
                    }
                    parcelObtain.writeInt(i);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.accounts.IAccountManagerService
            public void getAuthTokenLabel(IAccountManagerResponse iAccountManagerResponse, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAccountManagerService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iAccountManagerResponse);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(20, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IAccountManagerService.DESCRIPTOR;
            }

            @Override // com.xiaomi.accounts.IAccountManagerService
            public String getPassword(Account account) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAccountManagerService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, account, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.accounts.IAccountManagerService
            public String getUserData(Account account, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAccountManagerService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, account, 0);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.accounts.IAccountManagerService
            public void hasFeatures(IAccountManagerResponse iAccountManagerResponse, Account account, String[] strArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAccountManagerService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iAccountManagerResponse);
                    _Parcel.writeTypedObject(parcelObtain, account, 0);
                    parcelObtain.writeStringArray(strArr);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.accounts.IAccountManagerService
            public void invalidateAuthToken(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAccountManagerService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.accounts.IAccountManagerService
            public String peekAuthToken(Account account, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAccountManagerService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, account, 0);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.accounts.IAccountManagerService
            public void removeAccount(IAccountManagerResponse iAccountManagerResponse, Account account) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAccountManagerService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iAccountManagerResponse);
                    _Parcel.writeTypedObject(parcelObtain, account, 0);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.accounts.IAccountManagerService
            public void setAuthToken(Account account, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAccountManagerService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, account, 0);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.accounts.IAccountManagerService
            public void setPassword(Account account, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAccountManagerService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, account, 0);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.accounts.IAccountManagerService
            public void setUserData(Account account, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAccountManagerService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, account, 0);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.accounts.IAccountManagerService
            public void updateAppPermission(Account account, String str, int i, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAccountManagerService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, account, 0);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.accounts.IAccountManagerService
            public void updateCredentials(IAccountManagerResponse iAccountManagerResponse, Account account, String str, boolean z, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAccountManagerService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iAccountManagerResponse);
                    _Parcel.writeTypedObject(parcelObtain, account, 0);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z ? 1 : 0);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IAccountManagerService.DESCRIPTOR);
        }

        public static IAccountManagerService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IAccountManagerService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAccountManagerService)) ? new Proxy(iBinder) : (IAccountManagerService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IAccountManagerService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IAccountManagerService.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    String password = getPassword((Account) _Parcel.readTypedObject(parcel, Account.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeString(password);
                    return true;
                case 2:
                    String userData = getUserData((Account) _Parcel.readTypedObject(parcel, Account.CREATOR), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(userData);
                    return true;
                case 3:
                    Account[] accounts = getAccounts(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(accounts, 1);
                    return true;
                case 4:
                    hasFeatures(IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder()), (Account) _Parcel.readTypedObject(parcel, Account.CREATOR), parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    getAccountsByFeatures(IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    boolean zAddAccount = addAccount((Account) _Parcel.readTypedObject(parcel, Account.CREATOR), parcel.readString(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zAddAccount ? 1 : 0);
                    return true;
                case 7:
                    removeAccount(IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder()), (Account) _Parcel.readTypedObject(parcel, Account.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    invalidateAuthToken(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    String strPeekAuthToken = peekAuthToken((Account) _Parcel.readTypedObject(parcel, Account.CREATOR), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strPeekAuthToken);
                    return true;
                case 10:
                    setAuthToken((Account) _Parcel.readTypedObject(parcel, Account.CREATOR), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    setPassword((Account) _Parcel.readTypedObject(parcel, Account.CREATOR), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    clearPassword((Account) _Parcel.readTypedObject(parcel, Account.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 13:
                    setUserData((Account) _Parcel.readTypedObject(parcel, Account.CREATOR), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    updateAppPermission((Account) _Parcel.readTypedObject(parcel, Account.CREATOR), parcel.readString(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 15:
                    getAuthToken(IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder()), (Account) _Parcel.readTypedObject(parcel, Account.CREATOR), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 16:
                    addAcount(IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.createStringArray(), parcel.readInt() != 0, (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 17:
                    updateCredentials(IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder()), (Account) _Parcel.readTypedObject(parcel, Account.CREATOR), parcel.readString(), parcel.readInt() != 0, (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 18:
                    editProperties(IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 19:
                    confirmCredentials(IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder()), (Account) _Parcel.readTypedObject(parcel, Account.CREATOR), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 20:
                    getAuthTokenLabel(IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
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

    boolean addAccount(Account account, String str, Bundle bundle) throws RemoteException;

    void addAcount(IAccountManagerResponse iAccountManagerResponse, String str, String str2, String[] strArr, boolean z, Bundle bundle) throws RemoteException;

    void clearPassword(Account account) throws RemoteException;

    void confirmCredentials(IAccountManagerResponse iAccountManagerResponse, Account account, Bundle bundle, boolean z) throws RemoteException;

    void editProperties(IAccountManagerResponse iAccountManagerResponse, String str, boolean z) throws RemoteException;

    Account[] getAccounts(String str) throws RemoteException;

    void getAccountsByFeatures(IAccountManagerResponse iAccountManagerResponse, String str, String[] strArr) throws RemoteException;

    void getAuthToken(IAccountManagerResponse iAccountManagerResponse, Account account, String str, boolean z, boolean z2, Bundle bundle) throws RemoteException;

    void getAuthTokenLabel(IAccountManagerResponse iAccountManagerResponse, String str, String str2) throws RemoteException;

    String getPassword(Account account) throws RemoteException;

    String getUserData(Account account, String str) throws RemoteException;

    void hasFeatures(IAccountManagerResponse iAccountManagerResponse, Account account, String[] strArr) throws RemoteException;

    void invalidateAuthToken(String str, String str2) throws RemoteException;

    String peekAuthToken(Account account, String str) throws RemoteException;

    void removeAccount(IAccountManagerResponse iAccountManagerResponse, Account account) throws RemoteException;

    void setAuthToken(Account account, String str, String str2) throws RemoteException;

    void setPassword(Account account, String str) throws RemoteException;

    void setUserData(Account account, String str, String str2) throws RemoteException;

    void updateAppPermission(Account account, String str, int i, boolean z) throws RemoteException;

    void updateCredentials(IAccountManagerResponse iAccountManagerResponse, Account account, String str, boolean z, Bundle bundle) throws RemoteException;
}
