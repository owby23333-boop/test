package com.ss.android.socialbase.downloader.dl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.dl.g;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface dl extends IInterface {
    com.ss.android.socialbase.downloader.e.dl a(int i, long j) throws RemoteException;

    List<com.ss.android.socialbase.downloader.e.dl> a(String str) throws RemoteException;

    void a(int i) throws RemoteException;

    boolean a() throws RemoteException;

    com.ss.android.socialbase.downloader.e.dl dl(int i, long j) throws RemoteException;

    List<com.ss.android.socialbase.downloader.e.g> dl(int i) throws RemoteException;

    List<com.ss.android.socialbase.downloader.e.dl> dl(String str) throws RemoteException;

    void dl() throws RemoteException;

    com.ss.android.socialbase.downloader.e.dl e(int i) throws RemoteException;

    com.ss.android.socialbase.downloader.e.dl fo(int i) throws RemoteException;

    com.ss.android.socialbase.downloader.e.dl g(int i) throws RemoteException;

    com.ss.android.socialbase.downloader.e.dl g(int i, long j) throws RemoteException;

    List<com.ss.android.socialbase.downloader.e.dl> g() throws RemoteException;

    List<com.ss.android.socialbase.downloader.e.dl> g(String str) throws RemoteException;

    void g(int i, List<com.ss.android.socialbase.downloader.e.g> list) throws RemoteException;

    void g(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException;

    void g(com.ss.android.socialbase.downloader.e.g gVar) throws RemoteException;

    com.ss.android.socialbase.downloader.e.dl gc(int i, long j) throws RemoteException;

    boolean gc() throws RemoteException;

    boolean gc(int i) throws RemoteException;

    com.ss.android.socialbase.downloader.e.dl gz(int i) throws RemoteException;

    boolean m(int i) throws RemoteException;

    com.ss.android.socialbase.downloader.e.dl uy(int i) throws RemoteException;

    com.ss.android.socialbase.downloader.e.dl z(int i, int i2) throws RemoteException;

    com.ss.android.socialbase.downloader.e.dl z(int i, long j) throws RemoteException;

    com.ss.android.socialbase.downloader.e.dl z(int i, long j, String str, String str2) throws RemoteException;

    List<com.ss.android.socialbase.downloader.e.dl> z(String str) throws RemoteException;

    void z() throws RemoteException;

    void z(int i, int i2, int i3, int i4) throws RemoteException;

    void z(int i, int i2, int i3, long j) throws RemoteException;

    void z(int i, int i2, long j) throws RemoteException;

    void z(int i, List<com.ss.android.socialbase.downloader.e.g> list) throws RemoteException;

    void z(g gVar) throws RemoteException;

    void z(com.ss.android.socialbase.downloader.e.g gVar) throws RemoteException;

    boolean z(int i) throws RemoteException;

    boolean z(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException;

    public static abstract class z extends Binder implements dl {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public z() {
            attachInterface(this, "com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        }

        public static dl z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof dl)) {
                return (dl) iInterfaceQueryLocalInterface;
            }
            return new C0471z(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    z();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean z = z(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(z ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    com.ss.android.socialbase.downloader.e.dl dlVarG = g(parcel.readInt());
                    parcel2.writeNoException();
                    if (dlVarG != null) {
                        parcel2.writeInt(1);
                        dlVarG.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 4:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<com.ss.android.socialbase.downloader.e.dl> listZ = z(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listZ);
                    return true;
                case 5:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<com.ss.android.socialbase.downloader.e.dl> listG = g(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listG);
                    return true;
                case 6:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<com.ss.android.socialbase.downloader.e.dl> listDl = dl(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listDl);
                    return true;
                case 7:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<com.ss.android.socialbase.downloader.e.dl> listA = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listA);
                    return true;
                case 8:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<com.ss.android.socialbase.downloader.e.dl> listG2 = g();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listG2);
                    return true;
                case 9:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<com.ss.android.socialbase.downloader.e.g> listDl2 = dl(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listDl2);
                    return true;
                case 10:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    z(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.e.g.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    g(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.e.g.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    z(parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    z(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    z(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    com.ss.android.socialbase.downloader.e.dl dlVarZ = z(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    if (dlVarZ != null) {
                        parcel2.writeInt(1);
                        dlVarZ.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 17:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean z2 = z(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(z2 ? 1 : 0);
                    return true;
                case 18:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean zGc = gc(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zGc ? 1 : 0);
                    return true;
                case 19:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean zM = m(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zM ? 1 : 0);
                    return true;
                case 20:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    dl();
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    com.ss.android.socialbase.downloader.e.dl dlVarE = e(parcel.readInt());
                    parcel2.writeNoException();
                    if (dlVarE != null) {
                        parcel2.writeInt(1);
                        dlVarE.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 22:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    com.ss.android.socialbase.downloader.e.dl dlVarZ2 = z(parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (dlVarZ2 != null) {
                        parcel2.writeInt(1);
                        dlVarZ2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 23:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    com.ss.android.socialbase.downloader.e.dl dlVarZ3 = z(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (dlVarZ3 != null) {
                        parcel2.writeInt(1);
                        dlVarZ3.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 24:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    com.ss.android.socialbase.downloader.e.dl dlVarG2 = g(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (dlVarG2 != null) {
                        parcel2.writeInt(1);
                        dlVarG2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 25:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    com.ss.android.socialbase.downloader.e.dl dlVarGz = gz(parcel.readInt());
                    parcel2.writeNoException();
                    if (dlVarGz != null) {
                        parcel2.writeInt(1);
                        dlVarGz.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 26:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    com.ss.android.socialbase.downloader.e.dl dlVarDl = dl(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (dlVarDl != null) {
                        parcel2.writeInt(1);
                        dlVarDl.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 27:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    com.ss.android.socialbase.downloader.e.dl dlVarA = a(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (dlVarA != null) {
                        parcel2.writeInt(1);
                        dlVarA.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 28:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    com.ss.android.socialbase.downloader.e.dl dlVarGc = gc(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (dlVarGc != null) {
                        parcel2.writeInt(1);
                        dlVarGc.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 29:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    com.ss.android.socialbase.downloader.e.dl dlVarFo = fo(parcel.readInt());
                    parcel2.writeNoException();
                    if (dlVarFo != null) {
                        parcel2.writeInt(1);
                        dlVarFo.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 30:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    com.ss.android.socialbase.downloader.e.dl dlVarUy = uy(parcel.readInt());
                    parcel2.writeNoException();
                    if (dlVarUy != null) {
                        parcel2.writeInt(1);
                        dlVarUy.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 31:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean zA = a();
                    parcel2.writeNoException();
                    parcel2.writeInt(zA ? 1 : 0);
                    return true;
                case 32:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean zGc2 = gc();
                    parcel2.writeNoException();
                    parcel2.writeInt(zGc2 ? 1 : 0);
                    return true;
                case 33:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    g(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    z(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.e.g.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    g(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.e.g.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    z(g.z.z(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.dl.dl$z$z, reason: collision with other inner class name */
        private static class C0471z implements dl {
            public static dl z;
            private IBinder g;

            C0471z(IBinder iBinder) {
                this.g = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.g;
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public void z() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.g.transact(1, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        z.m().z();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public boolean z(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(2, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        return z.m().z(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public com.ss.android.socialbase.downloader.e.dl g(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(3, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        return z.m().g(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public List<com.ss.android.socialbase.downloader.e.dl> z(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeString(str);
                    if (!this.g.transact(4, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        return z.m().z(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(com.ss.android.socialbase.downloader.e.dl.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public List<com.ss.android.socialbase.downloader.e.dl> g(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeString(str);
                    if (!this.g.transact(5, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        return z.m().g(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(com.ss.android.socialbase.downloader.e.dl.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public List<com.ss.android.socialbase.downloader.e.dl> dl(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeString(str);
                    if (!this.g.transact(6, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        return z.m().dl(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(com.ss.android.socialbase.downloader.e.dl.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public List<com.ss.android.socialbase.downloader.e.dl> a(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeString(str);
                    if (!this.g.transact(7, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        return z.m().a(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(com.ss.android.socialbase.downloader.e.dl.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public List<com.ss.android.socialbase.downloader.e.dl> g() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.g.transact(8, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        return z.m().g();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(com.ss.android.socialbase.downloader.e.dl.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public List<com.ss.android.socialbase.downloader.e.g> dl(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(9, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        return z.m().dl(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(com.ss.android.socialbase.downloader.e.g.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public void a(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(10, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        z.m().a(i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public void z(com.ss.android.socialbase.downloader.e.g gVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (gVar != null) {
                        parcelObtain.writeInt(1);
                        gVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.g.transact(11, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        z.m().z(gVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public void g(com.ss.android.socialbase.downloader.e.g gVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (gVar != null) {
                        parcelObtain.writeInt(1);
                        gVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.g.transact(12, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        z.m().g(gVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public void z(int i, int i2, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeLong(j);
                    if (!this.g.transact(13, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        z.m().z(i, i2, j);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public void z(int i, int i2, int i3, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeLong(j);
                    if (!this.g.transact(14, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        z.m().z(i, i2, i3, j);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public void z(int i, int i2, int i3, int i4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    if (!this.g.transact(15, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        z.m().z(i, i2, i3, i4);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public com.ss.android.socialbase.downloader.e.dl z(int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    if (!this.g.transact(16, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        return z.m().z(i, i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public boolean z(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (dlVar != null) {
                        parcelObtain.writeInt(1);
                        dlVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.g.transact(17, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        return z.m().z(dlVar);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public boolean gc(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(18, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        return z.m().gc(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public boolean m(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(19, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        return z.m().m(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public void dl() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.g.transact(20, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        z.m().dl();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public com.ss.android.socialbase.downloader.e.dl e(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(21, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        return z.m().e(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public com.ss.android.socialbase.downloader.e.dl z(int i, long j, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.g.transact(22, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        return z.m().z(i, j, str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public com.ss.android.socialbase.downloader.e.dl z(int i, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    if (!this.g.transact(23, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        return z.m().z(i, j);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public com.ss.android.socialbase.downloader.e.dl g(int i, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    if (!this.g.transact(24, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        return z.m().g(i, j);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public com.ss.android.socialbase.downloader.e.dl gz(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(25, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        return z.m().gz(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public com.ss.android.socialbase.downloader.e.dl dl(int i, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    if (!this.g.transact(26, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        return z.m().dl(i, j);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public com.ss.android.socialbase.downloader.e.dl a(int i, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    if (!this.g.transact(27, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        return z.m().a(i, j);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public com.ss.android.socialbase.downloader.e.dl gc(int i, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    if (!this.g.transact(28, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        return z.m().gc(i, j);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public com.ss.android.socialbase.downloader.e.dl fo(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(29, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        return z.m().fo(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public com.ss.android.socialbase.downloader.e.dl uy(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(30, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        return z.m().uy(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public boolean a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.g.transact(31, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        return z.m().a();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public boolean gc() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.g.transact(32, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        return z.m().gc();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public void g(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (dlVar != null) {
                        parcelObtain.writeInt(1);
                        dlVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.g.transact(33, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        z.m().g(dlVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public void z(int i, List<com.ss.android.socialbase.downloader.e.g> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeTypedList(list);
                    if (!this.g.transact(34, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        z.m().z(i, list);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public void g(int i, List<com.ss.android.socialbase.downloader.e.g> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeTypedList(list);
                    if (!this.g.transact(35, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        z.m().g(i, list);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.dl.dl
            public void z(g gVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeStrongBinder(gVar != null ? gVar.asBinder() : null);
                    if (!this.g.transact(36, parcelObtain, parcelObtain2, 0) && z.m() != null) {
                        z.m().z(gVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static dl m() {
            return C0471z.z;
        }
    }
}
