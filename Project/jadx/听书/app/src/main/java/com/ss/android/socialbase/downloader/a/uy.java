package com.ss.android.socialbase.downloader.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface uy extends IInterface {
    void a(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException;

    void dl(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException;

    void dl(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar) throws RemoteException;

    void e(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException;

    void fo(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException;

    void g(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException;

    void g(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar) throws RemoteException;

    void gc(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException;

    void gz(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException;

    void m(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException;

    int z() throws RemoteException;

    void z(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException;

    void z(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar) throws RemoteException;

    public static abstract class z extends Binder implements uy {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public z() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
        }

        public static uy z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof uy)) {
                return (uy) iInterfaceQueryLocalInterface;
            }
            return new C0468z(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    int iZ = z();
                    parcel2.writeNoException();
                    parcel2.writeInt(iZ);
                    return true;
                case 2:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    z(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    g(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    dl(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    a(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    gc(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    z(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.gc.z.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    m(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    e(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    gz(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    g(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.gc.z.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    dl(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.gc.z.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    fo(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.a.uy$z$z, reason: collision with other inner class name */
        private static class C0468z implements uy {
            public static uy z;
            private IBinder g;

            C0468z(IBinder iBinder) {
                this.g = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.g;
            }

            @Override // com.ss.android.socialbase.downloader.a.uy
            public int z() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (!this.g.transact(1, parcelObtain, parcelObtain2, 0) && z.g() != null) {
                        return z.g().z();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.uy
            public void z(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (dlVar != null) {
                        parcelObtain.writeInt(1);
                        dlVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.g.transact(2, parcelObtain, parcelObtain2, 0) && z.g() != null) {
                        z.g().z(dlVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.uy
            public void g(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (dlVar != null) {
                        parcelObtain.writeInt(1);
                        dlVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.g.transact(3, parcelObtain, parcelObtain2, 0) && z.g() != null) {
                        z.g().g(dlVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.uy
            public void dl(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (dlVar != null) {
                        parcelObtain.writeInt(1);
                        dlVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.g.transact(4, parcelObtain, parcelObtain2, 0) && z.g() != null) {
                        z.g().dl(dlVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.uy
            public void a(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (dlVar != null) {
                        parcelObtain.writeInt(1);
                        dlVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.g.transact(5, parcelObtain, parcelObtain2, 0) && z.g() != null) {
                        z.g().a(dlVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.uy
            public void gc(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (dlVar != null) {
                        parcelObtain.writeInt(1);
                        dlVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.g.transact(6, parcelObtain, parcelObtain2, 0) && z.g() != null) {
                        z.g().gc(dlVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.uy
            public void z(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (dlVar != null) {
                        parcelObtain.writeInt(1);
                        dlVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (zVar != null) {
                        parcelObtain.writeInt(1);
                        zVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.g.transact(7, parcelObtain, parcelObtain2, 0) && z.g() != null) {
                        z.g().z(dlVar, zVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.uy
            public void m(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (dlVar != null) {
                        parcelObtain.writeInt(1);
                        dlVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.g.transact(8, parcelObtain, parcelObtain2, 0) && z.g() != null) {
                        z.g().m(dlVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.uy
            public void e(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (dlVar != null) {
                        parcelObtain.writeInt(1);
                        dlVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.g.transact(9, parcelObtain, parcelObtain2, 0) && z.g() != null) {
                        z.g().e(dlVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.uy
            public void gz(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (dlVar != null) {
                        parcelObtain.writeInt(1);
                        dlVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.g.transact(10, parcelObtain, parcelObtain2, 0) && z.g() != null) {
                        z.g().gz(dlVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.uy
            public void g(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (dlVar != null) {
                        parcelObtain.writeInt(1);
                        dlVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (zVar != null) {
                        parcelObtain.writeInt(1);
                        zVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.g.transact(11, parcelObtain, parcelObtain2, 0) && z.g() != null) {
                        z.g().g(dlVar, zVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.uy
            public void dl(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (dlVar != null) {
                        parcelObtain.writeInt(1);
                        dlVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (zVar != null) {
                        parcelObtain.writeInt(1);
                        zVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.g.transact(12, parcelObtain, parcelObtain2, 0) && z.g() != null) {
                        z.g().dl(dlVar, zVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.uy
            public void fo(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (dlVar != null) {
                        parcelObtain.writeInt(1);
                        dlVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.g.transact(13, parcelObtain, parcelObtain2, 0) && z.g() != null) {
                        z.g().fo(dlVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static uy g() {
            return C0468z.z;
        }
    }
}
