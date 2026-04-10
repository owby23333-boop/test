package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface ls extends IInterface {
    String z(String str, String str2, String str3);

    public static abstract class z extends Binder implements ls {
        public static ls z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ls)) {
                return (ls) iInterfaceQueryLocalInterface;
            }
            return new C0060z(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.heytap.openid.IOpenID");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.heytap.openid.IOpenID");
            String strZ = z(parcel.readString(), parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(strZ);
            return true;
        }

        /* JADX INFO: renamed from: com.bytedance.embedapplog.ls$z$z, reason: collision with other inner class name */
        static class C0060z implements ls {
            private IBinder z;

            C0060z(IBinder iBinder) {
                this.z = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.z;
            }

            @Override // com.bytedance.embedapplog.ls
            public String z(String str, String str2, String str3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.z.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
