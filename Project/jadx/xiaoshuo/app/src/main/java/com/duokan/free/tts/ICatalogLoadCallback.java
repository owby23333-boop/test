package com.duokan.free.tts;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.duokan.free.tts.data.CatalogItem;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public interface ICatalogLoadCallback extends IInterface {
    public static final String a0 = "com.duokan.free.tts.ICatalogLoadCallback";

    public static class Default implements ICatalogLoadCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.duokan.free.tts.ICatalogLoadCallback
        public void b(List<CatalogItem> list, int i) throws RemoteException {
        }

        @Override // com.duokan.free.tts.ICatalogLoadCallback
        public void d(Bundle bundle) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICatalogLoadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f3599a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f3600b = 2;

        public static class a implements ICatalogLoadCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f3601a;

            public a(IBinder iBinder) {
                this.f3601a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3601a;
            }

            @Override // com.duokan.free.tts.ICatalogLoadCallback
            public void b(List<CatalogItem> list, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICatalogLoadCallback.a0);
                    a.e(parcelObtain, list, 0);
                    parcelObtain.writeInt(i);
                    this.f3601a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.duokan.free.tts.ICatalogLoadCallback
            public void d(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICatalogLoadCallback.a0);
                    a.f(parcelObtain, bundle, 0);
                    this.f3601a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String f() {
                return ICatalogLoadCallback.a0;
            }
        }

        public Stub() {
            attachInterface(this, ICatalogLoadCallback.a0);
        }

        public static ICatalogLoadCallback e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ICatalogLoadCallback.a0);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ICatalogLoadCallback)) ? new a(iBinder) : (ICatalogLoadCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ICatalogLoadCallback.a0);
            }
            if (i == 1598968902) {
                parcel2.writeString(ICatalogLoadCallback.a0);
                return true;
            }
            if (i == 1) {
                b(parcel.createTypedArrayList(CatalogItem.CREATOR), parcel.readInt());
                parcel2.writeNoException();
            } else {
                if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                d((Bundle) a.d(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
            }
            return true;
        }
    }

    public static class a {
        public static <T> T d(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static <T extends Parcelable> void e(Parcel parcel, List<T> list, int i) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                f(parcel, list.get(i2), i);
            }
        }

        public static <T extends Parcelable> void f(Parcel parcel, T t, int i) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            }
        }
    }

    void b(List<CatalogItem> list, int i) throws RemoteException;

    void d(Bundle bundle) throws RemoteException;
}
