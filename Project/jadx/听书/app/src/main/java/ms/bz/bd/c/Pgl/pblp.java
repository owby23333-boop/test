package ms.bz.bd.c.Pgl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bytedance.sdk.component.utils.wp;
import com.google.common.base.Ascii;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: classes4.dex */
public final class pblp implements IInterface {
    private final IBinder z;

    public pblp(IBinder iBinder) {
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
            parcelObtain.writeInterfaceToken((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f0e422", new byte[]{116, Base64.padSymbol, Ascii.ESC, 14, Ascii.CAN, 42, 97, Ascii.CAN, 39, 42, 120, 34, 19, 78, 9, 32, 115, Ascii.CAN, 55, 97, 57, 51, Ascii.US, 68, 1, 107, 74, 1, 49, 106, 83, 55, 0, 73, 14, 32, 76, Ascii.NAK, 49, 106, 99, 59, 16, 73, 8, 55, 86, Ascii.DC4, 38, 114, 126, 49, 19}));
            this.z.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            string = parcelObtain2.readString();
        } catch (Throwable th) {
            parcelObtain.recycle();
            parcelObtain2.recycle();
            wp.z(th);
            string = null;
        }
        parcelObtain.recycle();
        parcelObtain2.recycle();
        return string;
    }
}
