package k0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: IDeviceIdService.java */
/* JADX INFO: loaded from: classes3.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: k0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IDeviceIdService.java */
    public static abstract class AbstractBinderC0571a extends Binder implements a {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final /* synthetic */ int f20928s = 0;

        /* JADX INFO: renamed from: k0.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IDeviceIdService.java */
        public static class C0572a implements a {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            public IBinder f20929s;

            public C0572a(IBinder iBinder) {
                this.f20929s = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f20929s;
            }

            @Override // k0.a
            public String getAAID(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    parcelObtain.writeString(str);
                    this.f20929s.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // k0.a
            public String getOAID() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    this.f20929s.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // k0.a
            public String getVAID(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    parcelObtain.writeString(str);
                    this.f20929s.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    String getAAID(String str) throws RemoteException;

    String getOAID() throws RemoteException;

    String getVAID(String str) throws RemoteException;
}
