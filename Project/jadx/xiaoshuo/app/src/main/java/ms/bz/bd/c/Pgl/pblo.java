package ms.bz.bd.c.Pgl;

import android.os.Process;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import ms.bz.bd.c.Pgl.pblb;
import okio.Utf8;

/* JADX INFO: loaded from: classes9.dex */
public abstract class pblo extends pblb.pgla {
    public abstract Object[] bf(String str, String str2, String str3);

    public void e(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public abstract Object[] e(String str, String str2, String str3);

    public abstract Object[] e(String str, byte[] bArr, String str2, String str3);

    public void e(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, int i2, long j, String str, Object obj) throws Throwable {
        if (!(pgla.e().bf().checkPermission(new String[]{(String) pblk.a(16777217, 0, 0L, "86b265", new byte[]{40, 58, Ascii.NAK, 84, 6, 43, Utf8.REPLACEMENT_BYTE, 89, 35, 103, 59, 57, Ascii.CAN, 85, Ascii.SUB, 43, 52, Ascii.EM, 125, 75, 7, 0, 52, 116, 39, 7, Ascii.SI})}[0], Process.myPid(), Process.myUid()) == 0)) {
            return null;
        }
        switch (i) {
            case 196609:
                Object[] objArr = (Object[]) obj;
                return e(str, (byte[]) objArr[0], (String) objArr[1], (String) objArr[2]);
            case 196610:
                Object[] objArr2 = (Object[]) obj;
                return e(str, (String) objArr2[0], (String) objArr2[1]);
            case 196611:
                Object[] objArr3 = (Object[]) obj;
                return bf(str, (String) objArr3[0], (String) objArr3[1]);
            default:
                return super.e(i, i2, j, str, obj);
        }
    }
}
