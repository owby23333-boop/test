package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public interface f extends IInterface {

    /* JADX INFO: compiled from: Taobao */
    public static abstract class a extends Binder implements f {

        /* JADX INFO: renamed from: anetwork.channel.aidl.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Taobao */
        private static class C0012a implements f {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            private IBinder f533s;

            C0012a(IBinder iBinder) {
                this.f533s = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f533s;
            }

            @Override // anetwork.channel.aidl.f
            public int length() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableInputStream");
                    this.f533s.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.f
            public int read(byte[] bArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableInputStream");
                    if (bArr == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(bArr.length);
                    }
                    this.f533s.transact(5, parcelObtain, parcelObtain2, 0);
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

        public a() {
            attachInterface(this, "anetwork.channel.aidl.ParcelableInputStream");
        }

        public static f a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("anetwork.channel.aidl.ParcelableInputStream");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof f)) ? new C0012a(iBinder) : (f) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            byte[] bArr;
            if (i2 == 1598968902) {
                parcel2.writeString("anetwork.channel.aidl.ParcelableInputStream");
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface("anetwork.channel.aidl.ParcelableInputStream");
                    int iAvailable = available();
                    parcel2.writeNoException();
                    parcel2.writeInt(iAvailable);
                    return true;
                case 2:
                    parcel.enforceInterface("anetwork.channel.aidl.ParcelableInputStream");
                    close();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("anetwork.channel.aidl.ParcelableInputStream");
                    int i4 = readByte();
                    parcel2.writeNoException();
                    parcel2.writeInt(i4);
                    return true;
                case 4:
                    parcel.enforceInterface("anetwork.channel.aidl.ParcelableInputStream");
                    int i5 = parcel.readInt();
                    bArr = i5 >= 0 ? new byte[i5] : null;
                    int iA = a(bArr, parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iA);
                    parcel2.writeByteArray(bArr);
                    return true;
                case 5:
                    parcel.enforceInterface("anetwork.channel.aidl.ParcelableInputStream");
                    int i6 = parcel.readInt();
                    bArr = i6 >= 0 ? new byte[i6] : null;
                    int i7 = read(bArr);
                    parcel2.writeNoException();
                    parcel2.writeInt(i7);
                    parcel2.writeByteArray(bArr);
                    return true;
                case 6:
                    parcel.enforceInterface("anetwork.channel.aidl.ParcelableInputStream");
                    long jD = d(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(jD);
                    return true;
                case 7:
                    parcel.enforceInterface("anetwork.channel.aidl.ParcelableInputStream");
                    int length = length();
                    parcel2.writeNoException();
                    parcel2.writeInt(length);
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }
    }

    int a(byte[] bArr, int i2, int i3) throws RemoteException;

    int available() throws RemoteException;

    void close() throws RemoteException;

    long d(int i2) throws RemoteException;

    int length() throws RemoteException;

    int read(byte[] bArr) throws RemoteException;

    int readByte() throws RemoteException;
}
