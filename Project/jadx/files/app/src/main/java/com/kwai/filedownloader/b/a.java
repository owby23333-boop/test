package com.kwai.filedownloader.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwai.filedownloader.message.MessageSnapshot;

/* JADX INFO: loaded from: classes3.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.kwai.filedownloader.b.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0464a extends Binder implements a {

        /* JADX INFO: renamed from: com.kwai.filedownloader.b.a$a$a, reason: collision with other inner class name */
        static class C0465a implements a {
            public static a aGQ;
            private IBinder mRemote;

            C0465a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.kwai.filedownloader.b.a
            public final void q(MessageSnapshot messageSnapshot) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCCallback");
                    if (messageSnapshot != null) {
                        parcelObtain.writeInt(1);
                        messageSnapshot.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, parcelObtain, null, 1) || AbstractBinderC0464a.HY() == null) {
                        return;
                    }
                    AbstractBinderC0464a.HY().q(messageSnapshot);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC0464a() {
            attachInterface(this, "com.kwai.filedownloader.i.IFileDownloadIPCCallback");
        }

        public static a HY() {
            return C0465a.aGQ;
        }

        public static a c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.kwai.filedownloader.i.IFileDownloadIPCCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0465a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCCallback");
                q(parcel.readInt() != 0 ? MessageSnapshot.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel2.writeString("com.kwai.filedownloader.i.IFileDownloadIPCCallback");
            return true;
        }
    }

    void q(MessageSnapshot messageSnapshot);
}
