package com.ss.android.downloadlib.z.z;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.wp;
import com.umeng.analytics.pro.an;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface a extends IInterface {
    void z(g gVar) throws RemoteException;

    public static abstract class z extends Binder implements a {
        private static String z = "";

        public static a z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(z);
            if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) {
                return new C0448z(iBinder);
            }
            return (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(z);
                z(parcel.readInt() != 0 ? g.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(z);
            return true;
        }

        /* JADX INFO: renamed from: com.ss.android.downloadlib.z.z.a$z$z, reason: collision with other inner class name */
        private static class C0448z implements a {
            private IBinder z;

            C0448z(IBinder iBinder) {
                if (TextUtils.isEmpty(z.z)) {
                    JSONObject jSONObjectFo = wp.fo();
                    String unused = z.z = com.ss.android.socialbase.appdownloader.m.dl.z(jSONObjectFo.optString(an.aI), jSONObjectFo.optString("s"));
                }
                this.z = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.z;
            }

            @Override // com.ss.android.downloadlib.z.z.a
            public void z(g gVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(z.z);
                    if (gVar != null) {
                        parcelObtain.writeInt(1);
                        gVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.z.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
