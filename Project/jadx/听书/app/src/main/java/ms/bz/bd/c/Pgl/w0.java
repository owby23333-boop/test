package ms.bz.bd.c.Pgl;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import java.lang.reflect.Method;
import ms.bz.bd.c.Pgl.pbly;

/* JADX INFO: loaded from: classes4.dex */
public final class w0 {

    final class pblb extends pbly.pgla {
        pblb() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object z(long j, String str, Object obj) throws Throwable {
            a1.z(pblv.z().g());
            return null;
        }
    }

    final class pblc extends pbly.pgla {
        pblc() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object z(long j, String str, Object obj) throws Throwable {
            return a1.z(pblv.z().g()).z();
        }
    }

    final class pbld extends pbly.pgla {
        pbld() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object z(long j, String str, Object obj) throws Throwable {
            return j1.g(pblv.z().g());
        }
    }

    final class pble extends pbly.pgla {
        pble() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object z(long j, String str, Object obj) throws Throwable {
            return i1.z(pblv.z().g());
        }
    }

    final class pblf extends pbly.pgla {
        pblf() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object z(long j, String str, Object obj) throws Throwable {
            return "np";
        }
    }

    final class pblg extends pbly.pgla {
        pblg() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object z(long j, String str, Object obj) throws Throwable {
            return "np";
        }
    }

    final class pblh extends pbly.pgla {
        pblh() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object z(long j, String str, Object obj) throws Throwable {
            return h1.z(pblv.z().g());
        }
    }

    final class pbli extends pbly.pgla {
        pbli() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object z(long j, String str, Object obj) throws Throwable {
            return h1.g(pblv.z().g());
        }
    }

    final class pblj extends pbly.pgla {
        pblj() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object z(long j, String str, Object obj) throws Throwable {
            return ms.bz.bd.c.Pgl.pblh.z();
        }
    }

    final class pblk extends pbly.pgla {
        pblk() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object z(long j, String str, Object obj) throws Throwable {
            return k1.z(pblv.z().g());
        }
    }

    final class pbll extends pbly.pgla {
        pbll() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object z(long j, String str, Object obj) throws Throwable {
            String str2;
            String str3;
            StringBuilder sbAppend;
            String strTrim = "0";
            String strTrim2 = "null";
            try {
                WifiInfo connectionInfo = ((WifiManager) pblv.z().g().getSystemService("wifi")).getConnectionInfo();
                Class<?> cls = connectionInfo.getClass();
                Method declaredMethod = cls.getDeclaredMethod(new String(pbla.z("6765744253534944")), new Class[0]);
                declaredMethod.setAccessible(true);
                str2 = (String) declaredMethod.invoke(connectionInfo, new Object[0]);
                try {
                    Method declaredMethod2 = cls.getDeclaredMethod(new String(pbla.z("67657453534944")), new Class[0]);
                    declaredMethod2.setAccessible(true);
                    str3 = (String) declaredMethod2.invoke(connectionInfo, new Object[0]);
                    try {
                        Method declaredMethod3 = cls.getDeclaredMethod(new String(pbla.z("676574497041646472657373")), new Class[0]);
                        declaredMethod3.setAccessible(true);
                        String string = Integer.toString(((Integer) declaredMethod3.invoke(connectionInfo, new Object[0])).intValue());
                        String strZ = q1.z(str3);
                        String strZ2 = q1.z(str2);
                        String strZ3 = q1.z(string);
                        StringBuilder sbAppend2 = new StringBuilder().append((strZ2 == null || strZ2.length() <= 0) ? "null" : strZ2.trim()).append("[<!>]");
                        if (strZ != null && strZ.length() > 0) {
                            strTrim2 = strZ.trim();
                        }
                        sbAppend = sbAppend2.append(strTrim2).append("[<!>]");
                        if (strZ3 != null && strZ3.length() > 0) {
                            strTrim = strZ3.trim();
                        }
                    } catch (Throwable unused) {
                        String strZ4 = q1.z(str3);
                        String strZ5 = q1.z(str2);
                        String strZ6 = q1.z(null);
                        StringBuilder sbAppend3 = new StringBuilder().append((strZ5 == null || strZ5.length() <= 0) ? "null" : strZ5.trim()).append("[<!>]");
                        if (strZ4 != null && strZ4.length() > 0) {
                            strTrim2 = strZ4.trim();
                        }
                        sbAppend = sbAppend3.append(strTrim2).append("[<!>]");
                        if (strZ6 != null && strZ6.length() > 0) {
                            strTrim = strZ6.trim();
                        }
                    }
                } catch (Throwable unused2) {
                    str3 = null;
                }
            } catch (Throwable unused3) {
                str2 = null;
                str3 = null;
            }
            return sbAppend.append(strTrim).append("[<!>]").toString().trim();
        }
    }

    final class pblm extends pbly.pgla {
        pblm() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object z(long j, String str, Object obj) throws Throwable {
            return j1.z(pblv.z().g());
        }
    }

    final class pgla extends pbly.pgla {
        pgla() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object z(long j, String str, Object obj) throws Throwable {
            return null;
        }
    }

    public static void z() {
        pbly.z(268435457, new pble());
        pbly.z(268435458, new pblf());
        pbly.z(268435459, new pblg());
        pbly.z(268435460, new pblh());
        pbly.z(268435461, new pbli());
        pbly.z(268435462, new pblj());
        pbly.z(268435463, new pblk());
        pbly.z(268435464, new pbll());
        pbly.z(268435465, new pblm());
        pbly.z(268435466, new pgla());
        pbly.z(268435467, new pblb());
        pbly.z(268435468, new pblc());
        pbly.z(268435469, new pbld());
    }
}
