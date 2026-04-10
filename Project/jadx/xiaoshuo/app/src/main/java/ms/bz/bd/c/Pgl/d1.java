package ms.bz.bd.c.Pgl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes9.dex */
public final class d1 implements IInterface {
    private final IBinder e;

    public d1(IBinder iBinder) {
        this.e = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.e;
    }

    public String e() {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken((String) pblk.a(16777217, 0, 0L, "2c640a", new byte[]{32, 110, 72, Ascii.SO, Ascii.SUB, 121, 53, 75, 116, 42, 44, 113, 64, 78, Ascii.VT, 115, 39, 75, 100, 97, 109, 96, 76, 68, 3, 56, Ascii.RS, 82, 98, 106, 7, 100, 83, 73, Ascii.FF, 115, Ascii.CAN, 70, 98, 106, 55, 104, 67, 73, 10, 100, 2, 71, 117, 114, 42, 98, 64}));
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.e.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            string = parcelObtain2.readString();
        } catch (Throwable th2) {
            th = th2;
            parcelObtain.recycle();
            parcelObtain2.recycle();
            th.printStackTrace();
            string = null;
        }
        parcelObtain.recycle();
        parcelObtain2.recycle();
        return string;
    }
}
