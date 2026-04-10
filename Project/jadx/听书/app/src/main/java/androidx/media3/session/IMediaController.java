package androidx.media3.session;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IMediaController extends IInterface {

    public static class Default implements IMediaController {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.media3.session.IMediaController
        public void onAvailableCommandsChangedFromPlayer(int i, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onAvailableCommandsChangedFromSession(int i, Bundle bundle, Bundle bundle2) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onChildrenChanged(int i, String str, int i2, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onConnected(int i, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onCustomCommand(int i, Bundle bundle, Bundle bundle2) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onDisconnected(int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onExtrasChanged(int i, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onLibraryResult(int i, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onPeriodicSessionPositionInfoChanged(int i, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onPlayerInfoChanged(int i, Bundle bundle, boolean z) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onPlayerInfoChangedWithExclusions(int i, Bundle bundle, Bundle bundle2) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onRenderedFirstFrame(int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onSearchResultChanged(int i, String str, int i2, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onSessionActivityChanged(int i, PendingIntent pendingIntent) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onSessionResult(int i, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaController
        public void onSetCustomLayout(int i, List<Bundle> list) throws RemoteException {
        }
    }

    void onAvailableCommandsChangedFromPlayer(int i, Bundle bundle) throws RemoteException;

    void onAvailableCommandsChangedFromSession(int i, Bundle bundle, Bundle bundle2) throws RemoteException;

    void onChildrenChanged(int i, String str, int i2, Bundle bundle) throws RemoteException;

    void onConnected(int i, Bundle bundle) throws RemoteException;

    void onCustomCommand(int i, Bundle bundle, Bundle bundle2) throws RemoteException;

    void onDisconnected(int i) throws RemoteException;

    void onExtrasChanged(int i, Bundle bundle) throws RemoteException;

    void onLibraryResult(int i, Bundle bundle) throws RemoteException;

    void onPeriodicSessionPositionInfoChanged(int i, Bundle bundle) throws RemoteException;

    void onPlayerInfoChanged(int i, Bundle bundle, boolean z) throws RemoteException;

    void onPlayerInfoChangedWithExclusions(int i, Bundle bundle, Bundle bundle2) throws RemoteException;

    void onRenderedFirstFrame(int i) throws RemoteException;

    void onSearchResultChanged(int i, String str, int i2, Bundle bundle) throws RemoteException;

    void onSessionActivityChanged(int i, PendingIntent pendingIntent) throws RemoteException;

    void onSessionResult(int i, Bundle bundle) throws RemoteException;

    void onSetCustomLayout(int i, List<Bundle> list) throws RemoteException;

    public static abstract class Stub extends Binder implements IMediaController {
        private static final String DESCRIPTOR = "androidx.media3.session.IMediaController";
        static final int TRANSACTION_onAvailableCommandsChangedFromPlayer = 3009;
        static final int TRANSACTION_onAvailableCommandsChangedFromSession = 3010;
        static final int TRANSACTION_onChildrenChanged = 4001;
        static final int TRANSACTION_onConnected = 3001;
        static final int TRANSACTION_onCustomCommand = 3005;
        static final int TRANSACTION_onDisconnected = 3006;
        static final int TRANSACTION_onExtrasChanged = 3012;
        static final int TRANSACTION_onLibraryResult = 3003;
        static final int TRANSACTION_onPeriodicSessionPositionInfoChanged = 3008;
        static final int TRANSACTION_onPlayerInfoChanged = 3007;
        static final int TRANSACTION_onPlayerInfoChangedWithExclusions = 3013;
        static final int TRANSACTION_onRenderedFirstFrame = 3011;
        static final int TRANSACTION_onSearchResultChanged = 4002;
        static final int TRANSACTION_onSessionActivityChanged = 3014;
        static final int TRANSACTION_onSessionResult = 3002;
        static final int TRANSACTION_onSetCustomLayout = 3004;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMediaController asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IMediaController)) {
                return (IMediaController) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 4001) {
                parcel.enforceInterface(DESCRIPTOR);
                onChildrenChanged(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i == 4002) {
                parcel.enforceInterface(DESCRIPTOR);
                onSearchResultChanged(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 3001:
                    parcel.enforceInterface(DESCRIPTOR);
                    onConnected(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 3002:
                    parcel.enforceInterface(DESCRIPTOR);
                    onSessionResult(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 3003:
                    parcel.enforceInterface(DESCRIPTOR);
                    onLibraryResult(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 3004:
                    parcel.enforceInterface(DESCRIPTOR);
                    onSetCustomLayout(parcel.readInt(), parcel.createTypedArrayList(Bundle.CREATOR));
                    return true;
                case 3005:
                    parcel.enforceInterface(DESCRIPTOR);
                    onCustomCommand(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 3006:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDisconnected(parcel.readInt());
                    return true;
                case TRANSACTION_onPlayerInfoChanged /* 3007 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPlayerInfoChanged(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                    return true;
                case TRANSACTION_onPeriodicSessionPositionInfoChanged /* 3008 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPeriodicSessionPositionInfoChanged(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case TRANSACTION_onAvailableCommandsChangedFromPlayer /* 3009 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    onAvailableCommandsChangedFromPlayer(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case TRANSACTION_onAvailableCommandsChangedFromSession /* 3010 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    onAvailableCommandsChangedFromSession(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case TRANSACTION_onRenderedFirstFrame /* 3011 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    onRenderedFirstFrame(parcel.readInt());
                    return true;
                case TRANSACTION_onExtrasChanged /* 3012 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    onExtrasChanged(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case TRANSACTION_onPlayerInfoChangedWithExclusions /* 3013 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPlayerInfoChangedWithExclusions(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case TRANSACTION_onSessionActivityChanged /* 3014 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    onSessionActivityChanged(parcel.readInt(), parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements IMediaController {
            public static IMediaController sDefaultImpl;
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

            @Override // androidx.media3.session.IMediaController
            public void onConnected(int i, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(3001, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onConnected(i, bundle);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onSessionResult(int i, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(3002, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onSessionResult(i, bundle);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onLibraryResult(int i, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(3003, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onLibraryResult(i, bundle);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onSetCustomLayout(int i, List<Bundle> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeTypedList(list);
                    if (this.mRemote.transact(3004, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onSetCustomLayout(i, list);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onCustomCommand(int i, Bundle bundle, Bundle bundle2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        parcelObtain.writeInt(1);
                        bundle2.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(3005, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onCustomCommand(i, bundle, bundle2);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onDisconnected(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (this.mRemote.transact(3006, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onDisconnected(i);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onPlayerInfoChanged(int i, Bundle bundle, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(Stub.TRANSACTION_onPlayerInfoChanged, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onPlayerInfoChanged(i, bundle, z);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onPlayerInfoChangedWithExclusions(int i, Bundle bundle, Bundle bundle2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        parcelObtain.writeInt(1);
                        bundle2.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(Stub.TRANSACTION_onPlayerInfoChangedWithExclusions, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onPlayerInfoChangedWithExclusions(i, bundle, bundle2);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onPeriodicSessionPositionInfoChanged(int i, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(Stub.TRANSACTION_onPeriodicSessionPositionInfoChanged, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onPeriodicSessionPositionInfoChanged(i, bundle);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onAvailableCommandsChangedFromPlayer(int i, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(Stub.TRANSACTION_onAvailableCommandsChangedFromPlayer, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onAvailableCommandsChangedFromPlayer(i, bundle);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onAvailableCommandsChangedFromSession(int i, Bundle bundle, Bundle bundle2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        parcelObtain.writeInt(1);
                        bundle2.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(Stub.TRANSACTION_onAvailableCommandsChangedFromSession, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onAvailableCommandsChangedFromSession(i, bundle, bundle2);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onRenderedFirstFrame(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (this.mRemote.transact(Stub.TRANSACTION_onRenderedFirstFrame, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onRenderedFirstFrame(i);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onExtrasChanged(int i, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(Stub.TRANSACTION_onExtrasChanged, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onExtrasChanged(i, bundle);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onSessionActivityChanged(int i, PendingIntent pendingIntent) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (pendingIntent != null) {
                        parcelObtain.writeInt(1);
                        pendingIntent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(Stub.TRANSACTION_onSessionActivityChanged, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onSessionActivityChanged(i, pendingIntent);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onChildrenChanged(int i, String str, int i2, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(4001, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onChildrenChanged(i, str, i2, bundle);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaController
            public void onSearchResultChanged(int i, String str, int i2, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(4002, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onSearchResultChanged(i, str, i2, bundle);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IMediaController iMediaController) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iMediaController == null) {
                return false;
            }
            Proxy.sDefaultImpl = iMediaController;
            return true;
        }

        public static IMediaController getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
