package ms.bz.bd.c.Pgl;

import android.telephony.TelephonyManager;
import com.google.common.base.Ascii;
import ms.bz.bd.c.Pgl.pbly;

/* JADX INFO: loaded from: classes4.dex */
final class k extends pbly.pgla {
    k() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object z(long j, String str, Object obj) throws Throwable {
        Boolean bool = Boolean.FALSE;
        TelephonyManager telephonyManager = (TelephonyManager) pblv.z().g().getApplicationContext().getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "082ff5", new byte[]{49, 50, 78, Ascii.FS, 92}));
        return (telephonyManager == null || telephonyManager.getSimState() != 5) ? bool : Boolean.TRUE;
    }
}
