package bykvm_19do.bykvm_19do.bykvm_19do;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface q1 extends IInterface {

    public static abstract class a extends Binder implements q1 {

        /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_19do.q1$a$a, reason: collision with other inner class name */
        static class C0020a implements q1 {
            private IBinder a;

            C0020a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_19do.q1
            public String a(String str, String str2, String str3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public static q1 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof q1)) ? new C0020a(iBinder) : (q1) iInterfaceQueryLocalInterface;
        }
    }

    String a(String str, String str2, String str3);
}
