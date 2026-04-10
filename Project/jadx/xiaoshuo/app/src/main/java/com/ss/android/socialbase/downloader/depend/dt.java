package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface dt extends IInterface {
    void e(List<String> list) throws RemoteException;

    boolean e() throws RemoteException;

    public static abstract class e extends Binder implements dt {
        public e() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
        }

        public static dt bf() {
            return C0502e.e;
        }

        public static dt e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof dt)) ? new C0502e(iBinder) : (dt) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                e(parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
            boolean zE = e();
            parcel2.writeNoException();
            parcel2.writeInt(zE ? 1 : 0);
            return true;
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.dt$e$e, reason: collision with other inner class name */
        public static class C0502e implements dt {
            public static dt e;
            private IBinder bf;

            public C0502e(IBinder iBinder) {
                this.bf = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.bf;
            }

            @Override // com.ss.android.socialbase.downloader.depend.dt
            public void e(List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                    parcelObtain.writeStringList(list);
                    if (this.bf.transact(1, parcelObtain, parcelObtain2, 0) || e.bf() == null) {
                        parcelObtain2.readException();
                    } else {
                        e.bf().e(list);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.dt
            public boolean e() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                    if (!this.bf.transact(2, parcelObtain, parcelObtain2, 0) && e.bf() != null) {
                        return e.bf().e();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
