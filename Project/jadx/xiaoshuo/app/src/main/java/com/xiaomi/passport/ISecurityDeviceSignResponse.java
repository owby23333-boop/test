package com.xiaomi.passport;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes8.dex */
public interface ISecurityDeviceSignResponse extends IInterface {
    public static final String DESCRIPTOR = "com.xiaomi.passport.ISecurityDeviceSignResponse";

    public static class Default implements ISecurityDeviceSignResponse {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.xiaomi.passport.ISecurityDeviceSignResponse
        public void onResult(Bundle bundle) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ISecurityDeviceSignResponse {
        static final int TRANSACTION_onResult = 1;

        public static class Proxy implements ISecurityDeviceSignResponse {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISecurityDeviceSignResponse.DESCRIPTOR;
            }

            @Override // com.xiaomi.passport.ISecurityDeviceSignResponse
            public void onResult(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISecurityDeviceSignResponse.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ISecurityDeviceSignResponse.DESCRIPTOR);
        }

        public static ISecurityDeviceSignResponse asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISecurityDeviceSignResponse.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ISecurityDeviceSignResponse)) ? new Proxy(iBinder) : (ISecurityDeviceSignResponse) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ISecurityDeviceSignResponse.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ISecurityDeviceSignResponse.DESCRIPTOR);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            onResult((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
            return true;
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t, int i) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            }
        }
    }

    void onResult(Bundle bundle) throws RemoteException;
}
