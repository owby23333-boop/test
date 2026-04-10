package com.ss.android.socialbase.downloader.bf;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface bf extends IInterface {
    void e(Map map, Map map2) throws RemoteException;

    public static abstract class e extends Binder implements bf {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.bf.bf$e$e, reason: collision with other inner class name */
        public static class C0498e implements bf {
            public static bf e;
            private IBinder bf;

            public C0498e(IBinder iBinder) {
                this.bf = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.bf;
            }

            @Override // com.ss.android.socialbase.downloader.bf.bf
            public void e(Map map, Map map2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
                    parcelObtain.writeMap(map);
                    parcelObtain.writeMap(map2);
                    if (this.bf.transact(1, parcelObtain, parcelObtain2, 0) || e.e() == null) {
                        parcelObtain2.readException();
                    } else {
                        e.e().e(map, map2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public e() {
            attachInterface(this, "com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
        }

        public static bf e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof bf)) ? new C0498e(iBinder) : (bf) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
            ClassLoader classLoader = getClass().getClassLoader();
            e(parcel.readHashMap(classLoader), parcel.readHashMap(classLoader));
            parcel2.writeNoException();
            return true;
        }

        public static bf e() {
            return C0498e.e;
        }
    }
}
