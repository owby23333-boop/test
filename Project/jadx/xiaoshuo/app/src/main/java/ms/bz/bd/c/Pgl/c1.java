package ms.bz.bd.c.Pgl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;
import okio.Utf8;

/* JADX INFO: loaded from: classes9.dex */
public final class c1 implements IInterface {
    private final IBinder e;

    public c1(IBinder iBinder) {
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
            parcelObtain.writeInterfaceToken((String) pblk.a(16777217, 0, 0L, "38b7dc", new byte[]{33, 53, Ascii.FS, Ascii.CR, 90, 103, 37, 10, 125, 106, 49, 59, 95, 112, 78, 100, 32, Ascii.NAK, 54, 106, 39, 52, 5, 66, 73, 109, Ascii.DC4, 48, Ascii.ETB, 41, Ascii.VT, Ascii.RS, Ascii.CAN, 71, 122, 125, 52, Ascii.NAK, Ascii.SUB, 105, 54, Utf8.REPLACEMENT_BYTE, 3, 69, 90, 119, 53}));
            try {
                this.e.transact(3, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                string = parcelObtain2.readString();
            } catch (Throwable unused) {
                parcelObtain.recycle();
                parcelObtain2.recycle();
                string = null;
            }
        } catch (Throwable unused2) {
        }
        parcelObtain.recycle();
        parcelObtain2.recycle();
        return string;
    }
}
