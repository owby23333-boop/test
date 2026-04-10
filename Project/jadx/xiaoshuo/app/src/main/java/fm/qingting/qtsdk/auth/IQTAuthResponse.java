package fm.qingting.qtsdk.auth;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes8.dex */
public interface IQTAuthResponse extends IInterface {

    public static class Default implements IQTAuthResponse {
        @Override // fm.qingting.qtsdk.auth.IQTAuthResponse
        public void a(Bundle result) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // fm.qingting.qtsdk.auth.IQTAuthResponse
        public void onCancel() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IQTAuthResponse {

        public static class Proxy implements IQTAuthResponse {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static IQTAuthResponse f21072a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f21073b;

            public Proxy(IBinder remote) {
                this.f21073b = remote;
            }

            @Override // fm.qingting.qtsdk.auth.IQTAuthResponse
            public void a(Bundle result) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("fm.qingting.qtsdk.auth.IQTAuthResponse");
                    if (this.f21073b.transact(1, parcelObtain, parcelObtain2, 0) || Stub.a() == null) {
                        parcelObtain2.readException();
                        if (parcelObtain2.readInt() != 0) {
                            result.readFromParcel(parcelObtain2);
                        }
                    } else {
                        Stub.a().a(result);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f21073b;
            }

            @Override // fm.qingting.qtsdk.auth.IQTAuthResponse
            public void onCancel() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("fm.qingting.qtsdk.auth.IQTAuthResponse");
                    if (this.f21073b.transact(2, parcelObtain, parcelObtain2, 0) || Stub.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.a().onCancel();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "fm.qingting.qtsdk.auth.IQTAuthResponse");
        }

        public static IQTAuthResponse a() {
            return Proxy.f21072a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code == 1) {
                data.enforceInterface("fm.qingting.qtsdk.auth.IQTAuthResponse");
                Bundle bundle = new Bundle();
                a(bundle);
                reply.writeNoException();
                reply.writeInt(1);
                bundle.writeToParcel(reply, 1);
                return true;
            }
            if (code != 2) {
                if (code != 1598968902) {
                    return super.onTransact(code, data, reply, flags);
                }
                reply.writeString("fm.qingting.qtsdk.auth.IQTAuthResponse");
                return true;
            }
            data.enforceInterface("fm.qingting.qtsdk.auth.IQTAuthResponse");
            onCancel();
            reply.writeNoException();
            return true;
        }

        public static IQTAuthResponse a(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = obj.queryLocalInterface("fm.qingting.qtsdk.auth.IQTAuthResponse");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IQTAuthResponse)) ? new Proxy(obj) : (IQTAuthResponse) iInterfaceQueryLocalInterface;
        }
    }

    void a(Bundle result) throws RemoteException;

    void onCancel() throws RemoteException;
}
