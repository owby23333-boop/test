package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface m extends IInterface {
    int[] bf() throws RemoteException;

    String e() throws RemoteException;

    void e(String str) throws RemoteException;

    public static abstract class e extends Binder implements m {
        public e() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
        }

        public static m d() {
            return C0504e.e;
        }

        public static m e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof m)) ? new C0504e(iBinder) : (m) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                e(parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                String strE = e();
                parcel2.writeNoException();
                parcel2.writeString(strE);
                return true;
            }
            if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            int[] iArrBf = bf();
            parcel2.writeNoException();
            parcel2.writeIntArray(iArrBf);
            return true;
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.m$e$e, reason: collision with other inner class name */
        public static class C0504e implements m {
            public static m e;
            private IBinder bf;

            public C0504e(IBinder iBinder) {
                this.bf = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.bf;
            }

            @Override // com.ss.android.socialbase.downloader.depend.m
            public int[] bf() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    if (!this.bf.transact(3, parcelObtain, parcelObtain2, 0) && e.d() != null) {
                        return e.d().bf();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createIntArray();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.m
            public void e(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    parcelObtain.writeString(str);
                    if (this.bf.transact(1, parcelObtain, parcelObtain2, 0) || e.d() == null) {
                        parcelObtain2.readException();
                    } else {
                        e.d().e(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.m
            public String e() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    if (!this.bf.transact(2, parcelObtain, parcelObtain2, 0) && e.d() != null) {
                        return e.d().e();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
