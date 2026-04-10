package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public interface e extends IInterface {

    /* JADX INFO: compiled from: Taobao */
    public static abstract class a extends Binder implements e {
        public a() {
            attachInterface(this, "anetwork.channel.aidl.ParcelableFuture");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("anetwork.channel.aidl.ParcelableFuture");
                boolean zCancel = cancel(parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeInt(zCancel ? 1 : 0);
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface("anetwork.channel.aidl.ParcelableFuture");
                boolean zIsCancelled = isCancelled();
                parcel2.writeNoException();
                parcel2.writeInt(zIsCancelled ? 1 : 0);
                return true;
            }
            if (i2 == 3) {
                parcel.enforceInterface("anetwork.channel.aidl.ParcelableFuture");
                boolean zIsDone = isDone();
                parcel2.writeNoException();
                parcel2.writeInt(zIsDone ? 1 : 0);
                return true;
            }
            if (i2 != 4) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("anetwork.channel.aidl.ParcelableFuture");
                return true;
            }
            parcel.enforceInterface("anetwork.channel.aidl.ParcelableFuture");
            NetworkResponse networkResponseA = a(parcel.readLong());
            parcel2.writeNoException();
            if (networkResponseA != null) {
                parcel2.writeInt(1);
                networkResponseA.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }
    }

    NetworkResponse a(long j2) throws RemoteException;

    boolean cancel(boolean z2) throws RemoteException;

    boolean isCancelled() throws RemoteException;

    boolean isDone() throws RemoteException;
}
