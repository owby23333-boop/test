package com.liulishuo.filedownloader.f0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.liulishuo.filedownloader.message.MessageSnapshot;

/* JADX INFO: compiled from: IFileDownloadIPCCallback.java */
/* JADX INFO: loaded from: classes3.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.liulishuo.filedownloader.f0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IFileDownloadIPCCallback.java */
    public static abstract class AbstractBinderC0487a extends Binder implements a {

        /* JADX INFO: renamed from: com.liulishuo.filedownloader.f0.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IFileDownloadIPCCallback.java */
        private static class C0488a implements a {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            private IBinder f17201s;

            C0488a(IBinder iBinder) {
                this.f17201s = iBinder;
            }

            @Override // com.liulishuo.filedownloader.f0.a
            public void a(MessageSnapshot messageSnapshot) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCCallback");
                    if (messageSnapshot != null) {
                        parcelObtain.writeInt(1);
                        messageSnapshot.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f17201s.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f17201s;
            }
        }

        public AbstractBinderC0487a() {
            attachInterface(this, "com.liulishuo.filedownloader.i.IFileDownloadIPCCallback");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0488a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCCallback");
                a(parcel.readInt() != 0 ? MessageSnapshot.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel2.writeString("com.liulishuo.filedownloader.i.IFileDownloadIPCCallback");
            return true;
        }
    }

    void a(MessageSnapshot messageSnapshot) throws RemoteException;
}
