package u;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: OpenDeviceIdentifierService.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements IInterface {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public IBinder f21717s;

    public a(IBinder iBinder) {
        this.f21717s = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f21717s;
    }

    public String getOaid() throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            this.f21717s.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    public boolean isOaidTrackLimited() throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            this.f21717s.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
