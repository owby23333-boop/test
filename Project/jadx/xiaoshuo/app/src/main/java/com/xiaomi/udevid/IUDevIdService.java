package com.xiaomi.udevid;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes8.dex */
public interface IUDevIdService extends IInterface {
    public static final String DESCRIPTOR = "com.xiaomi.udevid.IUDevIdService";

    public static class Default implements IUDevIdService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.xiaomi.udevid.IUDevIdService
        public Bundle getUDevIdFromSystemAccount(Bundle bundle) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IUDevIdService {
        static final int TRANSACTION_getUDevIdFromSystemAccount = 1;

        public static class Proxy implements IUDevIdService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IUDevIdService.DESCRIPTOR;
            }

            @Override // com.xiaomi.udevid.IUDevIdService
            public Bundle getUDevIdFromSystemAccount(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IUDevIdService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) _Parcel.readTypedObject(parcelObtain2, Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IUDevIdService.DESCRIPTOR);
        }

        public static IUDevIdService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IUDevIdService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IUDevIdService)) ? new Proxy(iBinder) : (IUDevIdService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IUDevIdService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IUDevIdService.DESCRIPTOR);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            Bundle uDevIdFromSystemAccount = getUDevIdFromSystemAccount((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
            parcel2.writeNoException();
            _Parcel.writeTypedObject(parcel2, uDevIdFromSystemAccount, 1);
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

    Bundle getUDevIdFromSystemAccount(Bundle bundle) throws RemoteException;
}
