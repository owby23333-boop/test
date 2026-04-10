package androidx.media3.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.media3.session.IMediaController;

/* JADX INFO: loaded from: classes.dex */
public interface IMediaSessionService extends IInterface {

    public static class Default implements IMediaSessionService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.media3.session.IMediaSessionService
        public void connect(IMediaController iMediaController, Bundle bundle) throws RemoteException {
        }
    }

    void connect(IMediaController iMediaController, Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements IMediaSessionService {
        private static final String DESCRIPTOR = "androidx.media3.session.IMediaSessionService";
        static final int TRANSACTION_connect = 3001;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMediaSessionService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IMediaSessionService)) {
                return (IMediaSessionService) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 3001) {
                parcel.enforceInterface(DESCRIPTOR);
                connect(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IMediaSessionService {
            public static IMediaSessionService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // androidx.media3.session.IMediaSessionService
            public void connect(IMediaController iMediaController, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(3001, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().connect(iMediaController, bundle);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IMediaSessionService iMediaSessionService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iMediaSessionService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iMediaSessionService;
            return true;
        }

        public static IMediaSessionService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
