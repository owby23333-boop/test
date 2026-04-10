package com.ss.android.downloadlib.z.z;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.downloadlib.z.z.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface dl extends IInterface {
    void z(g gVar, a aVar) throws RemoteException;

    public static abstract class z extends Binder implements dl {
        private static String z = "";

        public static dl z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(z);
            if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof dl)) {
                return new C0449z(iBinder);
            }
            return (dl) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(z);
                return true;
            }
            if (i == 1) {
                parcel.enforceInterface(z);
                z(parcel.readInt() != 0 ? g.CREATOR.createFromParcel(parcel) : null, a.z.z(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        /* JADX INFO: renamed from: com.ss.android.downloadlib.z.z.dl$z$z, reason: collision with other inner class name */
        private static class C0449z implements dl {
            private IBinder z;

            C0449z(IBinder iBinder) {
                if (TextUtils.isEmpty(z.z)) {
                    JSONObject jSONObjectFo = wp.fo();
                    String unused = z.z = com.ss.android.socialbase.appdownloader.m.dl.z(jSONObjectFo.optString("r"), jSONObjectFo.optString("s"));
                }
                this.z = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.z;
            }

            @Override // com.ss.android.downloadlib.z.z.dl
            public void z(g gVar, a aVar) throws RemoteException {
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
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
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
