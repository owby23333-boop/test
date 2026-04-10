package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: classes9.dex */
public class u0 {
    private final pblb e;

    public interface pblb {
        void e(String str);
    }

    public class pgla implements Runnable {
        final /* synthetic */ Context e;

        public pgla(Context context) {
            this.e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (((String) pblk.a(16777217, 0, 0L, "82030d", new byte[]{8, 3, 118, 116})).equals(u0.e(u0.this).toUpperCase())) {
                    new t0(this.e).e(u0.this.e);
                    return;
                }
                if (((String) pblk.a(16777217, 0, 0L, "dc377d", new byte[]{93, 84, 97, 116, 45, 90})).equals(u0.e(u0.this).toUpperCase())) {
                    new v0(this.e).e(u0.this.e);
                    return;
                }
                if (((String) pblk.a(16777217, 0, 0L, "9cdf49", new byte[]{7, 81, 39, Base64.padSymbol})).equals(u0.e(u0.this).toUpperCase()) || ((String) pblk.a(16777217, 0, 0L, "ab9f65", new byte[]{95, 78, 111, 34, 37, Ascii.ETB, 81})).equals(u0.e(u0.this).toUpperCase())) {
                    z0 z0Var = new z0(this.e);
                    z0Var.e(u0.this.e);
                    return;
                }
                if (((String) pblk.a(16777217, 0, 0L, "329ac5", new byte[]{Ascii.CAN, 4, 111})).equals(u0.e(u0.this).toUpperCase()) || ((String) pblk.a(16777217, 0, 0L, "8ac3b7", new byte[]{Ascii.SI, 70, 34, 117, 112, 5, Ascii.DC4, 115})).equals(u0.e(u0.this).toUpperCase()) || u0.this.e() || ((String) pblk.a(16777217, 0, 0L, "c6f3f6", new byte[]{65, 7, 32, 110})).equals(u0.e(u0.this).toUpperCase()) || u0.this.bf() || ((String) pblk.a(16777217, 0, 0L, "47eab3", new byte[]{Ascii.SYN, Ascii.DC4, 59, 38, 104, 10, 16})).equals(u0.e(u0.this).toUpperCase())) {
                    return;
                }
                if (((String) pblk.a(16777217, 0, 0L, "84eb05", new byte[]{5, 19, 56, 57, 57, Ascii.CR})).equals(u0.e(u0.this).toUpperCase()) || ((String) pblk.a(16777217, 0, 0L, "f967ae", new byte[]{90, Ascii.DC4, 113, 108, 114, 93, 87, 57})).equals(u0.e(u0.this).toUpperCase())) {
                    w0 w0Var = new w0(this.e);
                    w0Var.e(u0.this.e);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public u0(pblb pblbVar) {
        this.e = pblbVar;
    }

    private String e(String str) {
        if (str == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName((String) pblk.a(16777217, 0, 0L, "62b4bb", new byte[]{38, 62, Ascii.NAK, 82, 82, 124, 49, 93, 60, 119, 105, 3, 8, 83, 73, 112, 56, 35, 33, 107, 55, 53, 3, 84, 84, 112, 38}));
            Method method = cls.getMethod((String) pblk.a(16777217, 0, 0L, "344f2c", new byte[]{37, 51, 83}), String.class, String.class);
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = (String) pblk.a(16777217, 0, 0L, "5fb350", new byte[]{49, 106, Ascii.SUB, 73, 5, 48, 56});
            return (String) method.invoke(cls, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    private void bf(Context context) {
        new Thread(new pgla(context)).start();
    }

    public boolean e() {
        String strE = e((String) pblk.a(16777217, 0, 0L, "f65bfd", new byte[]{101, 59, 8, Ascii.DC4, 76, 122, 105, 19, 42, 52, 101, 49, 67, Ascii.ESC, 92, Base64.padSymbol, 105, Ascii.SYN, 102, 55, 123}));
        return !TextUtils.isEmpty(strE) && strE.equalsIgnoreCase((String) pblk.a(16777217, 0, 0L, "7938ed", new byte[]{0, 9, 101, 105, 119, 86, Ascii.ESC, 43}));
    }

    public static String e(u0 u0Var) {
        u0Var.getClass();
        return Build.MANUFACTURER.toUpperCase();
    }

    public boolean bf() {
        String strE = e((String) pblk.a(16777217, 0, 0L, "e0843f", new byte[]{102, Base64.padSymbol, 5, 83, Ascii.US, 100, 111, 95, 121, 118, 123, 54, 94, 67, Ascii.CAN}));
        return (TextUtils.isEmpty(strE) || strE.equalsIgnoreCase((String) pblk.a(16777217, 0, 0L, "b15897", new byte[]{102, Base64.padSymbol, 77, 66, 9, 55, 111}))) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x024d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e(android.content.Context r13) {
        /*
            Method dump skipped, instruction units count: 714
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.u0.e(android.content.Context):void");
    }
}
