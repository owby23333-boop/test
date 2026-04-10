package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import anetwork.channel.aidl.f;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public interface g extends IInterface {
    void a(DefaultFinishEvent defaultFinishEvent) throws RemoteException;

    void a(DefaultProgressEvent defaultProgressEvent) throws RemoteException;

    void a(f fVar) throws RemoteException;

    boolean a(int i2, ParcelableHeader parcelableHeader) throws RemoteException;

    byte g() throws RemoteException;

    /* JADX INFO: compiled from: Taobao */
    public static abstract class a extends Binder implements g {
        public a() {
            attachInterface(this, "anetwork.channel.aidl.ParcelableNetworkListener");
        }

        public static g a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("anetwork.channel.aidl.ParcelableNetworkListener");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof g)) ? new C0013a(iBinder) : (g) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("anetwork.channel.aidl.ParcelableNetworkListener");
                a(parcel.readInt() != 0 ? DefaultProgressEvent.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface("anetwork.channel.aidl.ParcelableNetworkListener");
                a(parcel.readInt() != 0 ? DefaultFinishEvent.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i2 == 3) {
                parcel.enforceInterface("anetwork.channel.aidl.ParcelableNetworkListener");
                boolean zA = a(parcel.readInt(), parcel.readInt() != 0 ? ParcelableHeader.f520u.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(zA ? 1 : 0);
                return true;
            }
            if (i2 == 4) {
                parcel.enforceInterface("anetwork.channel.aidl.ParcelableNetworkListener");
                a(f.a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i2 != 5) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("anetwork.channel.aidl.ParcelableNetworkListener");
                return true;
            }
            parcel.enforceInterface("anetwork.channel.aidl.ParcelableNetworkListener");
            byte bG = g();
            parcel2.writeNoException();
            parcel2.writeByte(bG);
            return true;
        }

        /* JADX INFO: renamed from: anetwork.channel.aidl.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Taobao */
        private static class C0013a implements g {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            private IBinder f534s;

            C0013a(IBinder iBinder) {
                this.f534s = iBinder;
            }

            @Override // anetwork.channel.aidl.g
            public void a(DefaultProgressEvent defaultProgressEvent) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableNetworkListener");
                    if (defaultProgressEvent != null) {
                        parcelObtain.writeInt(1);
                        defaultProgressEvent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f534s.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f534s;
            }

            @Override // anetwork.channel.aidl.g
            public byte g() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableNetworkListener");
                    this.f534s.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readByte();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.g
            public void a(DefaultFinishEvent defaultFinishEvent) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableNetworkListener");
                    if (defaultFinishEvent != null) {
                        parcelObtain.writeInt(1);
                        defaultFinishEvent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f534s.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.g
            public boolean a(int i2, ParcelableHeader parcelableHeader) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableNetworkListener");
                    parcelObtain.writeInt(i2);
                    if (parcelableHeader != null) {
                        parcelObtain.writeInt(1);
                        parcelableHeader.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f534s.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.g
            public void a(f fVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableNetworkListener");
                    parcelObtain.writeStrongBinder(fVar != null ? fVar.asBinder() : null);
                    this.f534s.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
