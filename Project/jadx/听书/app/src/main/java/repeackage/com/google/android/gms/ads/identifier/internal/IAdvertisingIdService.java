package repeackage.com.google.android.gms.ads.identifier.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface IAdvertisingIdService extends IInterface {

    public static class Default implements IAdvertisingIdService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // repeackage.com.google.android.gms.ads.identifier.internal.IAdvertisingIdService
        public String getId() throws RemoteException {
            return null;
        }

        @Override // repeackage.com.google.android.gms.ads.identifier.internal.IAdvertisingIdService
        public boolean isLimitAdTrackingEnabled(boolean boo) throws RemoteException {
            return false;
        }
    }

    String getId() throws RemoteException;

    boolean isLimitAdTrackingEnabled(boolean boo) throws RemoteException;

    public static abstract class Stub extends Binder implements IAdvertisingIdService {
        private static final String DESCRIPTOR = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";
        static final int TRANSACTION_getId = 1;
        static final int TRANSACTION_isLimitAdTrackingEnabled = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAdvertisingIdService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = obj.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IAdvertisingIdService)) {
                return (IAdvertisingIdService) iInterfaceQueryLocalInterface;
            }
            return new Proxy(obj);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                String id = getId();
                parcel2.writeNoException();
                parcel2.writeString(id);
                return true;
            }
            if (i != 2) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            boolean zIsLimitAdTrackingEnabled = isLimitAdTrackingEnabled(parcel.readInt() != 0);
            parcel2.writeNoException();
            parcel2.writeInt(zIsLimitAdTrackingEnabled ? 1 : 0);
            return true;
        }

        private static class Proxy implements IAdvertisingIdService {
            public static IAdvertisingIdService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // repeackage.com.google.android.gms.ads.identifier.internal.IAdvertisingIdService
            public String getId() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getId();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // repeackage.com.google.android.gms.ads.identifier.internal.IAdvertisingIdService
            public boolean isLimitAdTrackingEnabled(boolean boo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(boo ? 1 : 0);
                    if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isLimitAdTrackingEnabled(boo);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IAdvertisingIdService impl) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (impl == null) {
                return false;
            }
            Proxy.sDefaultImpl = impl;
            return true;
        }

        public static IAdvertisingIdService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
