package com.kwad.framework.filedownloader.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwad.framework.filedownloader.message.MessageSnapshot;

/* JADX INFO: loaded from: classes4.dex */
public interface a extends IInterface {
    void q(MessageSnapshot messageSnapshot);

    /* JADX INFO: renamed from: com.kwad.framework.filedownloader.c.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0373a extends Binder implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public AbstractBinderC0373a() {
            attachInterface(this, "com.kwad.framework.filedownloader.i.IFileDownloadIPCCallback");
        }

        public static a c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof a)) {
                return (a) iInterfaceQueryLocalInterface;
            }
            return new C0374a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCCallback");
                q(parcel.readInt() != 0 ? MessageSnapshot.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString("com.kwad.framework.filedownloader.i.IFileDownloadIPCCallback");
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        /* JADX INFO: renamed from: com.kwad.framework.filedownloader.c.a$a$a, reason: collision with other inner class name */
        static class C0374a implements a {
            public static a aoC;
            private IBinder mRemote;

            C0374a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.kwad.framework.filedownloader.c.a
            public final void q(MessageSnapshot messageSnapshot) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCCallback");
                    if (messageSnapshot != null) {
                        parcelObtain.writeInt(1);
                        messageSnapshot.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, parcelObtain, null, 1) || AbstractBinderC0373a.yI() == null) {
                        return;
                    }
                    AbstractBinderC0373a.yI().q(messageSnapshot);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public static a yI() {
            return C0374a.aoC;
        }
    }
}
