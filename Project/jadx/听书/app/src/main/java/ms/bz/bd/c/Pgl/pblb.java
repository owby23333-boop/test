package ms.bz.bd.c.Pgl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import okio.Utf8;

/* JADX INFO: loaded from: classes4.dex */
public final class pblb implements IInterface {
    private final IBinder z;

    public pblb(IBinder iBinder) {
        this.z = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.z;
    }

    public final String z() {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6d8a6e", new byte[]{36, 105, 70, 91, 8, 97, 32, 86, 39, 60, 52, 103, 5, 38, Ascii.FS, 98, 37, 73, 108, 60, 34, 104, 95, Ascii.DC4, Ascii.ESC, 107, 17, 108, 77, 127, 14, 66, 66, 17, 40, 123, 49, 73, SignedBytes.MAX_POWER_OF_TWO, Utf8.REPLACEMENT_BYTE, 51, 99, 89, 19, 8, 113, 48}));
            this.z.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            string = parcelObtain2.readString();
        } catch (Throwable unused) {
            parcelObtain.recycle();
            parcelObtain2.recycle();
            string = null;
        }
        parcelObtain.recycle();
        parcelObtain2.recycle();
        return string;
    }
}
