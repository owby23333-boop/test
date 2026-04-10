package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public interface b extends IInterface {

    /* JADX INFO: compiled from: Taobao */
    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, "anetwork.channel.aidl.IRemoteNetworkGetter");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 != 1) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("anetwork.channel.aidl.IRemoteNetworkGetter");
                return true;
            }
            parcel.enforceInterface("anetwork.channel.aidl.IRemoteNetworkGetter");
            h hVar = get(parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeStrongBinder(hVar != null ? hVar.asBinder() : null);
            return true;
        }
    }

    h get(int i2) throws RemoteException;
}
