package com.ss.android.socialbase.downloader.db;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface ISqlCacheLoadCompleteCallbackAidl extends IInterface {

    public static class Default implements ISqlCacheLoadCompleteCallbackAidl {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl
        public void callback(Map map, Map map2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ISqlCacheLoadCompleteCallbackAidl {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl";
        static final int TRANSACTION_callback = 1;

        private static class Proxy implements ISqlCacheLoadCompleteCallbackAidl {
            public static ISqlCacheLoadCompleteCallbackAidl sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl
            public void callback(Map map, Map map2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeMap(map);
                    parcelObtain.writeMap(map2);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().callback(map, map2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISqlCacheLoadCompleteCallbackAidl asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ISqlCacheLoadCompleteCallbackAidl)) ? new Proxy(iBinder) : (ISqlCacheLoadCompleteCallbackAidl) iInterfaceQueryLocalInterface;
        }

        public static ISqlCacheLoadCompleteCallbackAidl getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ISqlCacheLoadCompleteCallbackAidl iSqlCacheLoadCompleteCallbackAidl) {
            if (Proxy.sDefaultImpl != null || iSqlCacheLoadCompleteCallbackAidl == null) {
                return false;
            }
            Proxy.sDefaultImpl = iSqlCacheLoadCompleteCallbackAidl;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 != 1) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            ClassLoader classLoader = getClass().getClassLoader();
            callback(parcel.readHashMap(classLoader), parcel.readHashMap(classLoader));
            parcel2.writeNoException();
            return true;
        }
    }

    void callback(Map map, Map map2) throws RemoteException;
}
