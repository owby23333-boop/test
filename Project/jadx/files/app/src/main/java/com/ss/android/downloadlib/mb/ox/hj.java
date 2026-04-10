package com.ss.android.downloadlib.mb.ox;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.x;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface hj extends IInterface {

    public static abstract class mb extends Binder implements hj {
        private static String mb = "";

        /* JADX INFO: renamed from: com.ss.android.downloadlib.mb.ox.hj$mb$mb, reason: collision with other inner class name */
        private static class C0514mb implements hj {
            private IBinder mb;

            C0514mb(IBinder iBinder) {
                if (TextUtils.isEmpty(mb.mb)) {
                    JSONObject jSONObjectLz = x.lz();
                    String unused = mb.mb = com.ss.android.socialbase.appdownloader.u.b.mb(jSONObjectLz.optString("t"), jSONObjectLz.optString("s"));
                }
                this.mb = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mb;
            }

            @Override // com.ss.android.downloadlib.mb.ox.hj
            public void mb(ox oxVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(mb.mb);
                    if (oxVar != null) {
                        parcelObtain.writeInt(1);
                        oxVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.mb.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface(mb);
                mb(parcel.readInt() != 0 ? ox.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel2.writeString(mb);
            return true;
        }

        public static hj mb(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(mb);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof hj)) {
                return (hj) iInterfaceQueryLocalInterface;
            }
            return new C0514mb(iBinder);
        }
    }

    void mb(ox oxVar) throws RemoteException;
}
