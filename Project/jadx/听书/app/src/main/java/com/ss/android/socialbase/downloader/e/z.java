package com.ss.android.socialbase.downloader.e;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.a.e;
import com.ss.android.socialbase.downloader.a.eo;
import com.ss.android.socialbase.downloader.a.fo;
import com.ss.android.socialbase.downloader.a.gz;
import com.ss.android.socialbase.downloader.a.h;
import com.ss.android.socialbase.downloader.a.i;
import com.ss.android.socialbase.downloader.a.kb;
import com.ss.android.socialbase.downloader.a.m;
import com.ss.android.socialbase.downloader.a.mc;
import com.ss.android.socialbase.downloader.a.p;
import com.ss.android.socialbase.downloader.a.uy;
import com.ss.android.socialbase.downloader.a.zw;

/* JADX INFO: loaded from: classes4.dex */
public interface z extends IInterface {
    mc a() throws RemoteException;

    h dl() throws RemoteException;

    i dl(int i) throws RemoteException;

    zw e() throws RemoteException;

    p fo() throws RemoteException;

    com.ss.android.socialbase.downloader.a.m g() throws RemoteException;

    uy g(int i) throws RemoteException;

    fo gc() throws RemoteException;

    eo gz() throws RemoteException;

    gz kb() throws RemoteException;

    com.ss.android.socialbase.downloader.a.e m() throws RemoteException;

    kb uy() throws RemoteException;

    int wp() throws RemoteException;

    int z(int i) throws RemoteException;

    uy z(int i, int i2) throws RemoteException;

    dl z() throws RemoteException;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.e.z$z, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0475z extends Binder implements z {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public AbstractBinderC0475z() {
            attachInterface(this, "com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        }

        public static z z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof z)) {
                return (z) iInterfaceQueryLocalInterface;
            }
            return new C0476z(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    dl dlVarZ = z();
                    parcel2.writeNoException();
                    if (dlVarZ != null) {
                        parcel2.writeInt(1);
                        dlVarZ.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    com.ss.android.socialbase.downloader.a.m mVarG = g();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(mVarG != null ? mVarG.asBinder() : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    int iZ = z(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iZ);
                    return true;
                case 4:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    uy uyVarZ = z(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(uyVarZ != null ? uyVarZ.asBinder() : null);
                    return true;
                case 5:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    uy uyVarG = g(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(uyVarG != null ? uyVarG.asBinder() : null);
                    return true;
                case 6:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    h hVarDl = dl();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(hVarDl != null ? hVarDl.asBinder() : null);
                    return true;
                case 7:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    mc mcVarA = a();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(mcVarA != null ? mcVarA.asBinder() : null);
                    return true;
                case 8:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    fo foVarGc = gc();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(foVarGc != null ? foVarGc.asBinder() : null);
                    return true;
                case 9:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    com.ss.android.socialbase.downloader.a.e eVarM = m();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(eVarM != null ? eVarM.asBinder() : null);
                    return true;
                case 10:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    zw zwVarE = e();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zwVarE != null ? zwVarE.asBinder() : null);
                    return true;
                case 11:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    eo eoVarGz = gz();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(eoVarGz != null ? eoVarGz.asBinder() : null);
                    return true;
                case 12:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    p pVarFo = fo();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(pVarFo != null ? pVarFo.asBinder() : null);
                    return true;
                case 13:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    kb kbVarUy = uy();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(kbVarUy != null ? kbVarUy.asBinder() : null);
                    return true;
                case 14:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    gz gzVarKb = kb();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(gzVarKb != null ? gzVarKb.asBinder() : null);
                    return true;
                case 15:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    int iWp = wp();
                    parcel2.writeNoException();
                    parcel2.writeInt(iWp);
                    return true;
                case 16:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    i iVarDl = dl(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(iVarDl != null ? iVarDl.asBinder() : null);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.e.z$z$z, reason: collision with other inner class name */
        private static class C0476z implements z {
            public static z z;
            private IBinder g;

            C0476z(IBinder iBinder) {
                this.g = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.g;
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public dl z() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.g.transact(1, parcelObtain, parcelObtain2, 0) && AbstractBinderC0475z.i() != null) {
                        return AbstractBinderC0475z.i().z();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? dl.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public com.ss.android.socialbase.downloader.a.m g() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.g.transact(2, parcelObtain, parcelObtain2, 0) && AbstractBinderC0475z.i() != null) {
                        return AbstractBinderC0475z.i().g();
                    }
                    parcelObtain2.readException();
                    return m.z.z(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public int z(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(3, parcelObtain, parcelObtain2, 0) && AbstractBinderC0475z.i() != null) {
                        return AbstractBinderC0475z.i().z(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public uy z(int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    if (!this.g.transact(4, parcelObtain, parcelObtain2, 0) && AbstractBinderC0475z.i() != null) {
                        return AbstractBinderC0475z.i().z(i, i2);
                    }
                    parcelObtain2.readException();
                    return uy.z.z(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public uy g(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(5, parcelObtain, parcelObtain2, 0) && AbstractBinderC0475z.i() != null) {
                        return AbstractBinderC0475z.i().g(i);
                    }
                    parcelObtain2.readException();
                    return uy.z.z(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public h dl() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.g.transact(6, parcelObtain, parcelObtain2, 0) && AbstractBinderC0475z.i() != null) {
                        return AbstractBinderC0475z.i().dl();
                    }
                    parcelObtain2.readException();
                    return h.z.z(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public mc a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.g.transact(7, parcelObtain, parcelObtain2, 0) && AbstractBinderC0475z.i() != null) {
                        return AbstractBinderC0475z.i().a();
                    }
                    parcelObtain2.readException();
                    return mc.z.z(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public fo gc() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.g.transact(8, parcelObtain, parcelObtain2, 0) && AbstractBinderC0475z.i() != null) {
                        return AbstractBinderC0475z.i().gc();
                    }
                    parcelObtain2.readException();
                    return fo.z.z(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public com.ss.android.socialbase.downloader.a.e m() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.g.transact(9, parcelObtain, parcelObtain2, 0) && AbstractBinderC0475z.i() != null) {
                        return AbstractBinderC0475z.i().m();
                    }
                    parcelObtain2.readException();
                    return e.z.z(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public zw e() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.g.transact(10, parcelObtain, parcelObtain2, 0) && AbstractBinderC0475z.i() != null) {
                        return AbstractBinderC0475z.i().e();
                    }
                    parcelObtain2.readException();
                    return zw.z.z(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public eo gz() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.g.transact(11, parcelObtain, parcelObtain2, 0) && AbstractBinderC0475z.i() != null) {
                        return AbstractBinderC0475z.i().gz();
                    }
                    parcelObtain2.readException();
                    return eo.z.z(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public p fo() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.g.transact(12, parcelObtain, parcelObtain2, 0) && AbstractBinderC0475z.i() != null) {
                        return AbstractBinderC0475z.i().fo();
                    }
                    parcelObtain2.readException();
                    return p.z.z(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public kb uy() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.g.transact(13, parcelObtain, parcelObtain2, 0) && AbstractBinderC0475z.i() != null) {
                        return AbstractBinderC0475z.i().uy();
                    }
                    parcelObtain2.readException();
                    return kb.z.z(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public gz kb() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.g.transact(14, parcelObtain, parcelObtain2, 0) && AbstractBinderC0475z.i() != null) {
                        return AbstractBinderC0475z.i().kb();
                    }
                    parcelObtain2.readException();
                    return gz.z.z(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public int wp() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.g.transact(15, parcelObtain, parcelObtain2, 0) && AbstractBinderC0475z.i() != null) {
                        return AbstractBinderC0475z.i().wp();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public i dl(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(16, parcelObtain, parcelObtain2, 0) && AbstractBinderC0475z.i() != null) {
                        return AbstractBinderC0475z.i().dl(i);
                    }
                    parcelObtain2.readException();
                    return i.z.z(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static z i() {
            return C0476z.z;
        }
    }
}
