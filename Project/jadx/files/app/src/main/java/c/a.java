package c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: IDeviceidInterface.java */
/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IDeviceidInterface.java */
    public static abstract class AbstractBinderC0074a extends Binder implements a {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final /* synthetic */ int f2160s = 0;

        /* JADX INFO: renamed from: c.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IDeviceidInterface.java */
        public static class C0075a implements a {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            public IBinder f2161s;

            public C0075a(IBinder iBinder) {
                this.f2161s = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2161s;
            }

            @Override // c.a
            public String getAAID(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    parcelObtain.writeString(str);
                    this.f2161s.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // c.a
            public String getOAID() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f2161s.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // c.a
            public String getUDID() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f2161s.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // c.a
            public String getVAID(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    parcelObtain.writeString(str);
                    this.f2161s.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // c.a
            public boolean i() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f2161s.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    String getAAID(String str) throws RemoteException;

    String getOAID() throws RemoteException;

    String getUDID() throws RemoteException;

    String getVAID(String str) throws RemoteException;

    boolean i() throws RemoteException;
}
