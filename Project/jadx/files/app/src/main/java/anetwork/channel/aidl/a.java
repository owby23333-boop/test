package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import anetwork.channel.statist.StatisticData;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: anetwork.channel.aidl.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Taobao */
    public static abstract class AbstractBinderC0010a extends Binder implements a {
        public AbstractBinderC0010a() {
            attachInterface(this, "anetwork.channel.aidl.Connection");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString("anetwork.channel.aidl.Connection");
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface("anetwork.channel.aidl.Connection");
                    f inputStream = getInputStream();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(inputStream != null ? inputStream.asBinder() : null);
                    return true;
                case 2:
                    parcel.enforceInterface("anetwork.channel.aidl.Connection");
                    int iJ = j();
                    parcel2.writeNoException();
                    parcel2.writeInt(iJ);
                    return true;
                case 3:
                    parcel.enforceInterface("anetwork.channel.aidl.Connection");
                    String desc = getDesc();
                    parcel2.writeNoException();
                    parcel2.writeString(desc);
                    return true;
                case 4:
                    parcel.enforceInterface("anetwork.channel.aidl.Connection");
                    Map mapK = k();
                    parcel2.writeNoException();
                    parcel2.writeMap(mapK);
                    return true;
                case 5:
                    parcel.enforceInterface("anetwork.channel.aidl.Connection");
                    StatisticData statisticDataE = e();
                    parcel2.writeNoException();
                    if (statisticDataE != null) {
                        parcel2.writeInt(1);
                        parcel2.writeSerializable(statisticDataE);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 6:
                    parcel.enforceInterface("anetwork.channel.aidl.Connection");
                    cancel();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }
    }

    void cancel() throws RemoteException;

    StatisticData e() throws RemoteException;

    String getDesc() throws RemoteException;

    f getInputStream() throws RemoteException;

    int j() throws RemoteException;

    Map k() throws RemoteException;
}
