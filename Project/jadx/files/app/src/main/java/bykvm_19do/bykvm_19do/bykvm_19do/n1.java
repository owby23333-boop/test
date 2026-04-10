package bykvm_19do.bykvm_19do.bykvm_19do;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface n1 extends IInterface {

    public static abstract class a extends Binder implements n1 {

        /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_19do.n1$a$a, reason: collision with other inner class name */
        static class C0017a implements n1 {
            private IBinder a;

            C0017a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_19do.n1
            public String a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
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

        public static n1 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof n1)) ? new C0017a(iBinder) : (n1) iInterfaceQueryLocalInterface;
        }
    }

    String a();
}
