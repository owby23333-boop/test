package bykvm_19do.bykvm_19do.bykvm_19do;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface o1 extends IInterface {

    public static abstract class a extends Binder implements o1 {

        /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_19do.o1$a$a, reason: collision with other inner class name */
        static class C0018a implements o1 {
            private IBinder a;

            C0018a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_19do.o1
            public String a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
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

        public static o1 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof o1)) ? new C0018a(iBinder) : (o1) iInterfaceQueryLocalInterface;
        }
    }

    String a();
}
