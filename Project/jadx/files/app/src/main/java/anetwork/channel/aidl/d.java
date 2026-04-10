package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public interface d extends IInterface {

    /* JADX INFO: compiled from: Taobao */
    public static abstract class a extends Binder implements d {

        /* JADX INFO: renamed from: anetwork.channel.aidl.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Taobao */
        private static class C0011a implements d {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            private IBinder f532s;

            C0011a(IBinder iBinder) {
                this.f532s = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f532s;
            }

            @Override // anetwork.channel.aidl.d
            public boolean isCompleted() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableBodyHandler");
                    this.f532s.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.d
            public int read(byte[] bArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableBodyHandler");
                    parcelObtain.writeByteArray(bArr);
                    this.f532s.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    int i2 = parcelObtain2.readInt();
                    parcelObtain2.readByteArray(bArr);
                    return i2;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("anetwork.channel.aidl.ParcelableBodyHandler");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof d)) ? new C0011a(iBinder) : (d) iInterfaceQueryLocalInterface;
        }
    }

    boolean isCompleted() throws RemoteException;

    int read(byte[] bArr) throws RemoteException;
}
