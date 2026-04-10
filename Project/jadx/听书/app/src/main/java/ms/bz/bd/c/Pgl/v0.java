package ms.bz.bd.c.Pgl;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public final class v0 {
    /* JADX INFO: Access modifiers changed from: private */
    public static boolean g(Context context, String str, String str2) {
        try {
            String[] list = context.getAssets().list(str);
            if (list.length <= 0) {
                throw null;
            }
            new File(str2).mkdirs();
            for (String str3 : list) {
                g(context, str + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f7d399", new byte[]{56})) + str3, str2 + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5e96a0", new byte[]{107})) + str3);
            }
            return true;
        } catch (Exception unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d3691d", new byte[]{118, 48, 67});
            return false;
        }
    }

    public static void z() {
        pbly.z(65537, new o0());
        pbly.z(65538, new p0());
        pbly.z(65539, new q0());
        pbly.z(InputDeviceCompat.SOURCE_TRACKBALL, new r0());
        pbly.z(65541, new s0());
        pbly.z(65542, new t0());
        pbly.z(65543, new u0());
        r1 r1Var = new r1();
        pbly.z(196609, r1Var);
        pbly.z(196610, r1Var);
        pbly.z(196611, r1Var);
        pblw o1Var = pbli.z() ? new o1() : new pblj();
        pblw.z(o1Var);
        pbly.z(131073, o1Var);
        pbly.z(131074, o1Var);
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "cf6e7f", new byte[]{119, 114, SignedBytes.MAX_POWER_OF_TWO, Ascii.US, Ascii.FS, 93, 111, SignedBytes.MAX_POWER_OF_TWO, 74, 52, 124, 101, 66, Ascii.DC4, Ascii.SUB, 49, 99, 75, 102, 38, 97, 36, 76, 2, 72});
    }
}
