package ms.bz.bd.c.Pgl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;
import okio.Utf8;

/* JADX INFO: loaded from: classes9.dex */
public class e1 implements IInterface {
    private final IBinder e;

    public e1(IBinder iBinder) {
        this.e = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    public String e() throws Throwable {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken((String) pblk.a(16777217, 0, 0L, "9726da", new byte[]{43, 58, 76, Ascii.FF, 65, 99, 51, 88, 103, 99, 62, 60, 66, 71, 82, 114, 41, 19, 113, 112, 33, 54, 68, Ascii.FF, 114, 82, Utf8.REPLACEMENT_BYTE, 0, 106, 101, 45, 60, 69, 107, 85, 98, Utf8.REPLACEMENT_BYTE, 4, 101, 103, 43, 48}));
        } catch (Exception e) {
            e = e;
        } catch (Throwable th) {
            th = th;
            parcelObtain2.recycle();
            parcelObtain.recycle();
            throw th;
        }
        try {
            try {
                this.e.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                String string = parcelObtain2.readString();
                parcelObtain2.recycle();
                parcelObtain.recycle();
                return string;
            } catch (Throwable th2) {
                th = th2;
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            parcelObtain2.recycle();
            parcelObtain.recycle();
            return null;
        }
    }
}
