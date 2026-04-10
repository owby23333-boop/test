package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.a.gz;
import com.ss.android.socialbase.downloader.a.h;
import com.ss.android.socialbase.downloader.a.mc;
import com.ss.android.socialbase.downloader.a.uy;
import com.ss.android.socialbase.downloader.a.wj;
import com.ss.android.socialbase.downloader.e.z;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface kb extends IInterface {
    List<com.ss.android.socialbase.downloader.e.dl> a(String str) throws RemoteException;

    void a(int i) throws RemoteException;

    void a(int i, boolean z2) throws RemoteException;

    boolean a() throws RemoteException;

    List<com.ss.android.socialbase.downloader.e.dl> dl(String str) throws RemoteException;

    void dl(int i) throws RemoteException;

    void dl(int i, boolean z2) throws RemoteException;

    boolean dl() throws RemoteException;

    boolean e(int i) throws RemoteException;

    List<com.ss.android.socialbase.downloader.e.g> fo(int i) throws RemoteException;

    mc fv(int i) throws RemoteException;

    com.ss.android.socialbase.downloader.e.dl g(String str, String str2) throws RemoteException;

    List<com.ss.android.socialbase.downloader.e.dl> g() throws RemoteException;

    List<com.ss.android.socialbase.downloader.e.dl> g(String str) throws RemoteException;

    void g(int i, int i2, com.ss.android.socialbase.downloader.a.uy uyVar, int i3, boolean z2) throws RemoteException;

    void g(int i, List<com.ss.android.socialbase.downloader.e.g> list) throws RemoteException;

    void g(int i, boolean z2) throws RemoteException;

    void g(List<String> list) throws RemoteException;

    boolean g(int i) throws RemoteException;

    boolean g(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException;

    long gc(int i) throws RemoteException;

    List<com.ss.android.socialbase.downloader.e.dl> gc(String str) throws RemoteException;

    void gc() throws RemoteException;

    com.ss.android.socialbase.downloader.e.dl gz(int i) throws RemoteException;

    int i(int i) throws RemoteException;

    com.ss.android.socialbase.downloader.a.gz js(int i) throws RemoteException;

    boolean kb(int i) throws RemoteException;

    boolean ls(int i) throws RemoteException;

    int m(int i) throws RemoteException;

    boolean m() throws RemoteException;

    h p(int i) throws RemoteException;

    void pf(int i) throws RemoteException;

    void uy(int i) throws RemoteException;

    boolean v(int i) throws RemoteException;

    void wp(int i) throws RemoteException;

    int z(String str, String str2) throws RemoteException;

    List<com.ss.android.socialbase.downloader.e.dl> z(String str) throws RemoteException;

    void z() throws RemoteException;

    void z(int i) throws RemoteException;

    void z(int i, int i2) throws RemoteException;

    void z(int i, int i2, int i3, int i4) throws RemoteException;

    void z(int i, int i2, int i3, long j) throws RemoteException;

    void z(int i, int i2, long j) throws RemoteException;

    void z(int i, int i2, com.ss.android.socialbase.downloader.a.uy uyVar, int i3, boolean z2) throws RemoteException;

    void z(int i, int i2, com.ss.android.socialbase.downloader.a.uy uyVar, int i3, boolean z2, boolean z3) throws RemoteException;

    void z(int i, long j) throws RemoteException;

    void z(int i, Notification notification) throws RemoteException;

    void z(int i, h hVar) throws RemoteException;

    void z(int i, List<com.ss.android.socialbase.downloader.e.g> list) throws RemoteException;

    void z(int i, boolean z2) throws RemoteException;

    void z(wj wjVar) throws RemoteException;

    void z(com.ss.android.socialbase.downloader.e.g gVar) throws RemoteException;

    void z(com.ss.android.socialbase.downloader.e.z zVar) throws RemoteException;

    void z(List<String> list) throws RemoteException;

    void z(boolean z2) throws RemoteException;

    boolean z(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException;

    public static abstract class z extends Binder implements kb {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public z() {
            attachInterface(this, "com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        }

        public static kb z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof kb)) {
                return (kb) iInterfaceQueryLocalInterface;
            }
            return new C0474z(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    z(z.AbstractBinderC0475z.z(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    z(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    z(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zG = g(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zG ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    dl(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    z();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    long jGc = gc(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(jGc);
                    return true;
                case 9:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    int iM = m(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iM);
                    return true;
                case 10:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zE = e(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zE ? 1 : 0);
                    return true;
                case 11:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    com.ss.android.socialbase.downloader.e.dl dlVarGz = gz(parcel.readInt());
                    parcel2.writeNoException();
                    if (dlVarGz != null) {
                        parcel2.writeInt(1);
                        dlVarGz.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 12:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    List<com.ss.android.socialbase.downloader.e.dl> listZ = z(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listZ);
                    return true;
                case 13:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    List<com.ss.android.socialbase.downloader.e.g> listFo = fo(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listFo);
                    return true;
                case 14:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    int iZ = z(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iZ);
                    return true;
                case 15:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    com.ss.android.socialbase.downloader.e.dl dlVarG = g(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (dlVarG != null) {
                        parcel2.writeInt(1);
                        dlVarG.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 16:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    List<com.ss.android.socialbase.downloader.e.dl> listG = g(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listG);
                    return true;
                case 17:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    List<com.ss.android.socialbase.downloader.e.dl> listDl = dl(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listDl);
                    return true;
                case 18:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    List<com.ss.android.socialbase.downloader.e.dl> listA = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listA);
                    return true;
                case 19:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    List<com.ss.android.socialbase.downloader.e.dl> listG2 = g();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listG2);
                    return true;
                case 20:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    z(parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    g(parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    g(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    dl(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    uy(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    z(parcel.readInt(), parcel.readInt(), uy.z.z(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    g(parcel.readInt(), parcel.readInt(), uy.z.z(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    z(parcel.readInt(), parcel.readInt(), uy.z.z(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 28:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean z = z(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(z ? 1 : 0);
                    return true;
                case 29:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    z(parcel.readInt(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 30:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    z(parcel.readInt() != 0);
                    return true;
                case 31:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zDl = dl();
                    parcel2.writeNoException();
                    parcel2.writeInt(zDl ? 1 : 0);
                    return true;
                case 32:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    List<com.ss.android.socialbase.downloader.e.dl> listGc = gc(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listGc);
                    return true;
                case 33:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zKb = kb(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zKb ? 1 : 0);
                    return true;
                case 34:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    wp(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zA = a();
                    parcel2.writeNoException();
                    parcel2.writeInt(zA ? 1 : 0);
                    return true;
                case 36:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    a(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 37:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    int i3 = i(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 38:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    z(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.e.g.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 39:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zG2 = g(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zG2 ? 1 : 0);
                    return true;
                case 40:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zV = v(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zV ? 1 : 0);
                    return true;
                case 41:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    pf(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    z(parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 43:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    z(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 44:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    z(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 45:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zLs = ls(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zLs ? 1 : 0);
                    return true;
                case 46:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    gc();
                    parcel2.writeNoException();
                    return true;
                case 47:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    z(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.e.g.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 48:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    g(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.e.g.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 49:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    z(wj.z.z(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 50:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    z(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 51:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    h hVarP = p(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(hVarP != null ? hVarP.asBinder() : null);
                    return true;
                case 52:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    mc mcVarFv = fv(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(mcVarFv != null ? mcVarFv.asBinder() : null);
                    return true;
                case 53:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    z(parcel.readInt(), h.z.z(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 54:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    com.ss.android.socialbase.downloader.a.gz gzVarJs = js(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(gzVarJs != null ? gzVarJs.asBinder() : null);
                    return true;
                case 55:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zM = m();
                    parcel2.writeNoException();
                    parcel2.writeInt(zM ? 1 : 0);
                    return true;
                case 56:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    z(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.downloader.kb$z$z, reason: collision with other inner class name */
        private static class C0474z implements kb {
            public static kb z;
            private IBinder g;

            C0474z(IBinder iBinder) {
                this.g = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.g;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void z(com.ss.android.socialbase.downloader.e.z zVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeStrongBinder(zVar != null ? zVar.asBinder() : null);
                    if (!this.g.transact(1, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().z(zVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void z(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(2, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().z(i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void z(int i, boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    if (!this.g.transact(3, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().z(i, z2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public boolean g(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(4, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().g(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void dl(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(5, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().dl(i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void a(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(6, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().a(i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void z() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.g.transact(7, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().z();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public long gc(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(8, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().gc(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public int m(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(9, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().m(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public boolean e(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(10, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().e(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public com.ss.android.socialbase.downloader.e.dl gz(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(11, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().gz(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public List<com.ss.android.socialbase.downloader.e.dl> z(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeString(str);
                    if (!this.g.transact(12, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().z(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(com.ss.android.socialbase.downloader.e.dl.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public List<com.ss.android.socialbase.downloader.e.g> fo(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(13, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().fo(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(com.ss.android.socialbase.downloader.e.g.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public int z(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.g.transact(14, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().z(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public com.ss.android.socialbase.downloader.e.dl g(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.g.transact(15, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().g(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? com.ss.android.socialbase.downloader.e.dl.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public List<com.ss.android.socialbase.downloader.e.dl> g(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeString(str);
                    if (!this.g.transact(16, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().g(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(com.ss.android.socialbase.downloader.e.dl.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public List<com.ss.android.socialbase.downloader.e.dl> dl(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeString(str);
                    if (!this.g.transact(17, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().dl(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(com.ss.android.socialbase.downloader.e.dl.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public List<com.ss.android.socialbase.downloader.e.dl> a(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeString(str);
                    if (!this.g.transact(18, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().a(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(com.ss.android.socialbase.downloader.e.dl.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public List<com.ss.android.socialbase.downloader.e.dl> g() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.g.transact(19, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().g();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(com.ss.android.socialbase.downloader.e.dl.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void z(List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeStringList(list);
                    if (!this.g.transact(20, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().z(list);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void g(List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeStringList(list);
                    if (!this.g.transact(21, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().g(list);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void g(int i, boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    if (!this.g.transact(22, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().g(i, z2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void dl(int i, boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    if (!this.g.transact(23, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().dl(i, z2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void uy(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(24, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().uy(i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void z(int i, int i2, com.ss.android.socialbase.downloader.a.uy uyVar, int i3, boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStrongBinder(uyVar != null ? uyVar.asBinder() : null);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    if (!this.g.transact(25, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().z(i, i2, uyVar, i3, z2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void g(int i, int i2, com.ss.android.socialbase.downloader.a.uy uyVar, int i3, boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStrongBinder(uyVar != null ? uyVar.asBinder() : null);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    if (!this.g.transact(26, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().g(i, i2, uyVar, i3, z2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void z(int i, int i2, com.ss.android.socialbase.downloader.a.uy uyVar, int i3, boolean z2, boolean z3) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStrongBinder(uyVar != null ? uyVar.asBinder() : null);
                    parcelObtain.writeInt(i3);
                    int i4 = 1;
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    if (!z3) {
                        i4 = 0;
                    }
                    parcelObtain.writeInt(i4);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (!this.g.transact(27, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().z(i, i2, uyVar, i3, z2, z3);
                    } else {
                        parcelObtain2.readException();
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th2) {
                    th = th2;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public boolean z(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (dlVar != null) {
                        parcelObtain.writeInt(1);
                        dlVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.g.transact(28, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().z(dlVar);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void z(int i, Notification notification) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (notification != null) {
                        parcelObtain.writeInt(1);
                        notification.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.g.transact(29, parcelObtain, null, 1) || z.e() == null) {
                        return;
                    }
                    z.e().z(i, notification);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void z(boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    if (this.g.transact(30, parcelObtain, null, 1) || z.e() == null) {
                        return;
                    }
                    z.e().z(z2);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public boolean dl() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.g.transact(31, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().dl();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public List<com.ss.android.socialbase.downloader.e.dl> gc(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeString(str);
                    if (!this.g.transact(32, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().gc(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(com.ss.android.socialbase.downloader.e.dl.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public boolean kb(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(33, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().kb(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void wp(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(34, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().wp(i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public boolean a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.g.transact(35, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().a();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void a(int i, boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    if (!this.g.transact(36, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().a(i, z2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public int i(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(37, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().i(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void z(com.ss.android.socialbase.downloader.e.g gVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (gVar != null) {
                        parcelObtain.writeInt(1);
                        gVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.g.transact(38, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().z(gVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public boolean g(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (dlVar != null) {
                        parcelObtain.writeInt(1);
                        dlVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.g.transact(39, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().g(dlVar);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public boolean v(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(40, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().v(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void pf(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(41, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().pf(i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void z(int i, int i2, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeLong(j);
                    if (!this.g.transact(42, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().z(i, i2, j);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void z(int i, int i2, int i3, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeLong(j);
                    if (!this.g.transact(43, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().z(i, i2, i3, j);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void z(int i, int i2, int i3, int i4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    if (!this.g.transact(44, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().z(i, i2, i3, i4);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public boolean ls(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(45, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().ls(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void gc() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.g.transact(46, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().gc();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void z(int i, List<com.ss.android.socialbase.downloader.e.g> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeTypedList(list);
                    if (!this.g.transact(47, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().z(i, list);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void g(int i, List<com.ss.android.socialbase.downloader.e.g> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeTypedList(list);
                    if (!this.g.transact(48, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().g(i, list);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void z(wj wjVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeStrongBinder(wjVar != null ? wjVar.asBinder() : null);
                    if (!this.g.transact(49, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().z(wjVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void z(int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    if (!this.g.transact(50, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().z(i, i2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public h p(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(51, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().p(i);
                    }
                    parcelObtain2.readException();
                    return h.z.z(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public mc fv(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(52, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().fv(i);
                    }
                    parcelObtain2.readException();
                    return mc.z.z(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void z(int i, h hVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(hVar != null ? hVar.asBinder() : null);
                    if (!this.g.transact(53, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().z(i, hVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public com.ss.android.socialbase.downloader.a.gz js(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(54, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().js(i);
                    }
                    parcelObtain2.readException();
                    return gz.z.z(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public boolean m() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.g.transact(55, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        return z.e().m();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.kb
            public void z(int i, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    if (!this.g.transact(56, parcelObtain, parcelObtain2, 0) && z.e() != null) {
                        z.e().z(i, j);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static kb e() {
            return C0474z.z;
        }
    }
}
