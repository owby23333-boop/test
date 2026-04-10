package miuix.appcompat.app.floatingactivity.multiapp;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes7.dex */
public interface IServiceNotify extends IInterface {

    public static abstract class Stub extends Binder implements IServiceNotify {
        private static final String DESCRIPTOR = "miuix.appcompat.app.floatingactivity.multiapp.IServiceNotify";
        static final int TRANSACTION_notifyFromService = 1;

        public static class Proxy implements IServiceNotify {
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

            @Override // miuix.appcompat.app.floatingactivity.multiapp.IServiceNotify
            public Bundle notifyFromService(int i, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeBundle(bundle);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    Bundle bundle2 = parcelObtain2.readBundle();
                    parcelObtain2.readException();
                    return bundle2;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IServiceNotify asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IServiceNotify)) ? new Proxy(iBinder) : (IServiceNotify) iInterfaceQueryLocalInterface;
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
            parcel2.writeBundle(notifyFromService(parcel.readInt(), parcel.readBundle()));
            parcel2.writeNoException();
            return true;
        }
    }

    Bundle notifyFromService(int i, Bundle bundle) throws RemoteException;
}
