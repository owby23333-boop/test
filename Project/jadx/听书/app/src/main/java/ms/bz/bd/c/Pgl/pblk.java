package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.uy.a.dl;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import okio.Utf8;

/* JADX INFO: loaded from: classes4.dex */
public final class pblk {
    private final pblb z;

    public interface pblb {
        void z(String str);
    }

    final class pgla implements Runnable {
        final /* synthetic */ Context z;

        pgla(Context context) {
            this.z = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b94f7c", new byte[]{82, 8, 114, 33})).equals(pblk.z(pblk.this).toUpperCase())) {
                    new ms.bz.bd.c.Pgl.pgla(this.z).z(pblk.this.z);
                    return;
                }
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1b423b", new byte[]{8, 85, 102, 113, 41, 92})).equals(pblk.z(pblk.this).toUpperCase())) {
                    new pblo(this.z).z(pblk.this.z);
                    return;
                }
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ceb2eb", new byte[]{93, 87, 33, 105})).equals(pblk.z(pblk.this).toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "652279", new byte[]{8, Ascii.EM, 100, 118, 36, Ascii.ESC, 6})).equals(pblk.z(pblk.this).toUpperCase())) {
                    b1 b1Var = new b1(this.z);
                    b1Var.z(pblk.this.z);
                    return;
                }
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e50fbb", new byte[]{78, 3, 102})).equals(pblk.z(pblk.this).toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8661bd", new byte[]{15, 17, 119, 119, 112, 86, Ascii.DC4, 36})).equals(pblk.z(pblk.this).toUpperCase())) {
                    return;
                }
                pblk.this.getClass();
                if (pblk.z() || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fa8dcf", new byte[]{68, 80, 126, 57})).equals(pblk.z(pblk.this).toUpperCase())) {
                    return;
                }
                pblk.this.getClass();
                if (pblk.g() || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "22b542", new byte[]{16, 17, 60, 114, 62, 11, Ascii.SYN})).equals(pblk.z(pblk.this).toUpperCase())) {
                    return;
                }
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f871ad", new byte[]{91, Ascii.US, 106, 106, 104, 92})).equals(pblk.z(pblk.this).toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "601731", new byte[]{10, Ascii.GS, 118, 108, 32, 9, 7, 48})).equals(pblk.z(pblk.this).toUpperCase())) {
                    pbls pblsVar = new pbls(this.z);
                    pblsVar.z(pblk.this.z);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public pblk(pblb pblbVar) {
        this.z = pblbVar;
    }

    private void g(Context context) {
        new dl(new pgla(context), "bd/c/Pgl/pblk").start();
    }

    public static boolean g() {
        String strZ = z((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d7a200", new byte[]{103, 58, 92, 85, Ascii.FS, 50, 110, 88, 32, 112, 122, 49, 7, 69, Ascii.ESC}));
        return (TextUtils.isEmpty(strZ) || strZ.equalsIgnoreCase((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "338385", new byte[]{55, Utf8.REPLACEMENT_BYTE, SignedBytes.MAX_POWER_OF_TWO, 73, 8, 53, 62}))) ? false : true;
    }

    private static String z(String str) {
        if (str == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "efe468", new byte[]{117, 106, Ascii.DC2, 82, 6, 38, 98, 9, 59, 119, 58, 87, 15, 83, Ascii.GS, 42, 107, 119, 38, 107, 100, 97, 4, 84, 0, 42, 117}));
            return (String) cls.getMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "051d61", new byte[]{38, 50, 86}), String.class, String.class).invoke(cls, str, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "dc923d", new byte[]{96, 111, 65, 72, 3, 100, 105}));
        } catch (Exception unused) {
            return null;
        }
    }

    static String z(pblk pblkVar) {
        pblkVar.getClass();
        return Build.MANUFACTURER.toUpperCase();
    }

    public static boolean z() {
        String strZ = z((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "945b58", new byte[]{58, 57, 8, Ascii.DC4, Ascii.US, 38, 54, 17, 42, 52, 58, 51, 67, Ascii.ESC, 15, 97, 54, Ascii.DC4, 102, 55, 36}));
        return !TextUtils.isEmpty(strZ) && strZ.equalsIgnoreCase((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fb5fb1", new byte[]{81, 82, 99, 55, 112, 3, 74, 112}));
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x023e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void z(android.content.Context r13) {
        /*
            Method dump skipped, instruction units count: 698
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.pblk.z(android.content.Context):void");
    }
}
