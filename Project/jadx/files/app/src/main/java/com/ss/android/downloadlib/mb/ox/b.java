package com.ss.android.downloadlib.mb.ox;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.mb.ox.hj;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface b extends IInterface {

    public static abstract class mb extends Binder implements b {
        private static String mb = "";

        /* JADX INFO: renamed from: com.ss.android.downloadlib.mb.ox.b$mb$mb, reason: collision with other inner class name */
        private static class C0513mb implements b {
            private IBinder mb;

            C0513mb(IBinder iBinder) {
                if (TextUtils.isEmpty(mb.mb)) {
                    JSONObject jSONObjectLz = x.lz();
                    String unused = mb.mb = com.ss.android.socialbase.appdownloader.u.b.mb(jSONObjectLz.optString("r"), jSONObjectLz.optString("s"));
                }
                this.mb = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mb;
            }

            @Override // com.ss.android.downloadlib.mb.ox.b
            public void mb(ox oxVar, hj hjVar) throws RemoteException {
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
                    parcelObtain.writeStrongBinder(hjVar != null ? hjVar.asBinder() : null);
                    this.mb.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        @Override // android.os.Binder
        @SuppressLint({"WrongConstant"})
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString(mb);
                return true;
            }
            if (i2 != 1) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel.enforceInterface(mb);
            mb(parcel.readInt() != 0 ? ox.CREATOR.createFromParcel(parcel) : null, hj.mb.mb(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        public static b mb(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(mb);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof b)) {
                return (b) iInterfaceQueryLocalInterface;
            }
            return new C0513mb(iBinder);
        }
    }

    void mb(ox oxVar, hj hjVar) throws RemoteException;
}
