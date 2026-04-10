package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import anetwork.channel.aidl.g;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public interface h extends IInterface {

    /* JADX INFO: compiled from: Taobao */
    public static abstract class a extends Binder implements h {
        public a() {
            attachInterface(this, "anetwork.channel.aidl.RemoteNetwork");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("anetwork.channel.aidl.RemoteNetwork");
                NetworkResponse networkResponseB = b(parcel.readInt() != 0 ? ParcelableRequest.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (networkResponseB != null) {
                    parcel2.writeInt(1);
                    networkResponseB.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface("anetwork.channel.aidl.RemoteNetwork");
                e eVarA = a(parcel.readInt() != 0 ? ParcelableRequest.CREATOR.createFromParcel(parcel) : null, g.a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeStrongBinder(eVarA != null ? eVarA.asBinder() : null);
                return true;
            }
            if (i2 != 3) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("anetwork.channel.aidl.RemoteNetwork");
                return true;
            }
            parcel.enforceInterface("anetwork.channel.aidl.RemoteNetwork");
            anetwork.channel.aidl.a aVarA = a(parcel.readInt() != 0 ? ParcelableRequest.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            parcel2.writeStrongBinder(aVarA != null ? aVarA.asBinder() : null);
            return true;
        }
    }

    anetwork.channel.aidl.a a(ParcelableRequest parcelableRequest) throws RemoteException;

    e a(ParcelableRequest parcelableRequest, g gVar) throws RemoteException;

    NetworkResponse b(ParcelableRequest parcelableRequest) throws RemoteException;
}
