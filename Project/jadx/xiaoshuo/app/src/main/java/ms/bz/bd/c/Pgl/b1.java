package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import kotlin.io.encoding.Base64;
import okio.Utf8;

/* JADX INFO: loaded from: classes9.dex */
public class b1 {
    private Class bf;
    private Object d;
    private final Context e;
    private Method tg;

    public b1(Context context) {
        int i;
        this.e = context;
        try {
            i = 1;
            try {
                Class<?> cls = Class.forName((String) pblk.a(16777217, 0, 0L, "621149", new byte[]{36, Utf8.REPLACEMENT_BYTE, 79, Ascii.VT, 10, 32, 49, 1, 111, 104, 35, 126, 75, 65, 69, 39, 56, 3, 108, 47, Ascii.SO, 52, 114, 87, 4, 56, 60, Ascii.ETB, 101, 115, Ascii.SO, Base64.padSymbol, 82, 73}));
                this.bf = cls;
                this.d = cls.newInstance();
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            i = 1;
        }
        try {
            Class cls2 = this.bf;
            byte[] bArr = new byte[7];
            bArr[0] = 47;
            bArr[i] = 62;
            bArr[2] = 95;
            bArr[3] = 99;
            bArr[4] = 40;
            bArr[5] = 95;
            bArr[6] = Ascii.RS;
            String str = (String) pblk.a(16777217, 0, 0L, "99886a", bArr);
            Class<?>[] clsArr = new Class[i];
            clsArr[0] = Context.class;
            this.tg = cls2.getMethod(str, clsArr);
        } catch (Exception unused3) {
        }
    }

    public String e() {
        Context context = this.e;
        Method method = this.tg;
        Object obj = this.d;
        if (obj != null && method != null) {
            try {
                return (String) method.invoke(obj, context);
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
