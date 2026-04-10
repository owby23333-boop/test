package ms.bz.bd.c.Pgl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bytedance.sdk.component.utils.wp;
import com.google.common.base.Ascii;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: classes4.dex */
public final class pblt implements IInterface {
    private final IBinder z;

    public pblt(IBinder iBinder) {
        this.z = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return null;
    }

    public final String z() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            try {
                parcelObtain.writeInterfaceToken((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d68e76", new byte[]{118, 59, 70, 95, Ascii.DC2, 52, 110, 89, 109, 48, 99, Base64.padSymbol, 72, Ascii.DC4, 1, 37, 116, Ascii.DC2, 123, 35, 124, 55, 78, 95, 33, 5, 98, 1, 96, 54, 112, Base64.padSymbol, 79, 56, 6, 53, 98, 5, 111, 52, 118, 49}));
                this.z.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } catch (Exception e) {
                wp.z(e);
                parcelObtain2.recycle();
                parcelObtain.recycle();
                return null;
            }
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
