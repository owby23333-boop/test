package bykvm_19do.bykvm_19do.bykvm_19do;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface r1 extends IInterface {

    public static abstract class a extends Binder implements r1 {

        /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_19do.r1$a$a, reason: collision with other inner class name */
        static class C0021a implements r1 {
            private IBinder a;

            C0021a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_19do.r1
            public String a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
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

        public static r1 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof r1)) ? new C0021a(iBinder) : (r1) iInterfaceQueryLocalInterface;
        }
    }

    String a();
}
