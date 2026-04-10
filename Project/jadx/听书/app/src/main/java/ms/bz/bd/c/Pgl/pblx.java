package ms.bz.bd.c.Pgl;

import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import ms.bz.bd.c.Pgl.pbly;
import okio.Utf8;

/* JADX INFO: loaded from: classes4.dex */
public abstract class pblx extends pbly.pgla {
    protected static void z(BufferedInputStream bufferedInputStream) {
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException unused) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b250a5", new byte[]{126, 51, 121, 71, 87});
            }
        }
    }

    protected static void z(DataOutputStream dataOutputStream) {
        if (dataOutputStream != null) {
            try {
                dataOutputStream.close();
            } catch (IOException unused) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "983f9c", new byte[]{37, 57, 127, 17, 9});
            }
        }
    }

    public abstract Object[] g(String str, String str2, String str3);

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object z(int i, int i2, long j, String str, Object obj) throws Throwable {
        if (!d1.z((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "939559", new byte[]{41, Utf8.REPLACEMENT_BYTE, 78, 83, 5, 39, 62, 92, 120, 96, 58, 60, 67, 82, Ascii.EM, 39, 53, Ascii.FS, 38, 76, 6, 5, 111, 115, 36, 11, 14}))) {
            return null;
        }
        switch (i) {
            case 196609:
                Object[] objArr = (Object[]) obj;
                return z(str, (byte[]) objArr[0], (String) objArr[1], (String) objArr[2]);
            case 196610:
                Object[] objArr2 = (Object[]) obj;
                return z(str, (String) objArr2[0], (String) objArr2[1]);
            case 196611:
                Object[] objArr3 = (Object[]) obj;
                return g(str, (String) objArr3[0], (String) objArr3[1]);
            default:
                return super.z(i, i2, j, str, obj);
        }
    }

    public abstract Object[] z(String str, String str2, String str3);

    public abstract Object[] z(String str, byte[] bArr, String str2, String str3);
}
