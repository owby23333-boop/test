package com.xiaomi.ad.feedback;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
public interface IAdFeedbackListener extends IInterface {

    public static class Default implements IAdFeedbackListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.xiaomi.ad.feedback.IAdFeedbackListener
        public void onFinished(int i) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAdFeedbackListener {
        private static final String DESCRIPTOR = "com.xiaomi.ad.feedback.IAdFeedbackListener";
        static final int TRANSACTION_onFinished = 1;

        public static class Proxy implements IAdFeedbackListener {
            public static IAdFeedbackListener sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.xiaomi.ad.feedback.IAdFeedbackListener
            public void onFinished(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onFinished(i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAdFeedbackListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAdFeedbackListener)) ? new Proxy(iBinder) : (IAdFeedbackListener) iInterfaceQueryLocalInterface;
        }

        public static IAdFeedbackListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IAdFeedbackListener iAdFeedbackListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iAdFeedbackListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iAdFeedbackListener;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            onFinished(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    void onFinished(int i) throws RemoteException;
}
