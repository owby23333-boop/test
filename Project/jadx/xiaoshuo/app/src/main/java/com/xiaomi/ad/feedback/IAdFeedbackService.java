package com.xiaomi.ad.feedback;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaomi.ad.feedback.IAdFeedbackListener;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface IAdFeedbackService extends IInterface {

    public static class Default implements IAdFeedbackService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.xiaomi.ad.feedback.IAdFeedbackService
        public void showFeedbackWindow(IAdFeedbackListener iAdFeedbackListener) throws RemoteException {
        }

        @Override // com.xiaomi.ad.feedback.IAdFeedbackService
        public void showFeedbackWindowAndTrackResult(IAdFeedbackListener iAdFeedbackListener, String str, String str2, String str3) throws RemoteException {
        }

        @Override // com.xiaomi.ad.feedback.IAdFeedbackService
        public void showFeedbackWindowAndTrackResultForMultiAds(IAdFeedbackListener iAdFeedbackListener, String str, String str2, List<String> list) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAdFeedbackService {
        private static final String DESCRIPTOR = "com.xiaomi.ad.feedback.IAdFeedbackService";
        static final int TRANSACTION_showFeedbackWindow = 1;
        static final int TRANSACTION_showFeedbackWindowAndTrackResult = 2;
        static final int TRANSACTION_showFeedbackWindowAndTrackResultForMultiAds = 3;

        public static class Proxy implements IAdFeedbackService {
            public static IAdFeedbackService sDefaultImpl;
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

            @Override // com.xiaomi.ad.feedback.IAdFeedbackService
            public void showFeedbackWindow(IAdFeedbackListener iAdFeedbackListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iAdFeedbackListener != null ? iAdFeedbackListener.asBinder() : null);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().showFeedbackWindow(iAdFeedbackListener);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.ad.feedback.IAdFeedbackService
            public void showFeedbackWindowAndTrackResult(IAdFeedbackListener iAdFeedbackListener, String str, String str2, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iAdFeedbackListener != null ? iAdFeedbackListener.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().showFeedbackWindowAndTrackResult(iAdFeedbackListener, str, str2, str3);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.ad.feedback.IAdFeedbackService
            public void showFeedbackWindowAndTrackResultForMultiAds(IAdFeedbackListener iAdFeedbackListener, String str, String str2, List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iAdFeedbackListener != null ? iAdFeedbackListener.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStringList(list);
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().showFeedbackWindowAndTrackResultForMultiAds(iAdFeedbackListener, str, str2, list);
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

        public static IAdFeedbackService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAdFeedbackService)) ? new Proxy(iBinder) : (IAdFeedbackService) iInterfaceQueryLocalInterface;
        }

        public static IAdFeedbackService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IAdFeedbackService iAdFeedbackService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iAdFeedbackService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iAdFeedbackService;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                showFeedbackWindow(IAdFeedbackListener.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                showFeedbackWindowAndTrackResult(IAdFeedbackListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            showFeedbackWindowAndTrackResultForMultiAds(IAdFeedbackListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.createStringArrayList());
            parcel2.writeNoException();
            return true;
        }
    }

    void showFeedbackWindow(IAdFeedbackListener iAdFeedbackListener) throws RemoteException;

    void showFeedbackWindowAndTrackResult(IAdFeedbackListener iAdFeedbackListener, String str, String str2, String str3) throws RemoteException;

    void showFeedbackWindowAndTrackResultForMultiAds(IAdFeedbackListener iAdFeedbackListener, String str, String str2, List<String> list) throws RemoteException;
}
