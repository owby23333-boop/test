package ms.bz.bd.c.Pgl;

import android.telephony.TelephonyManager;
import com.google.common.base.Ascii;
import ms.bz.bd.c.Pgl.pblb;

/* JADX INFO: loaded from: classes9.dex */
final class m extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, long j, String str, Object obj) throws Throwable {
        Boolean bool = Boolean.FALSE;
        TelephonyManager telephonyManager = (TelephonyManager) pgla.e().bf().getApplicationContext().getSystemService((String) pblk.a(16777217, 0, 0L, "cd9353", new byte[]{98, 110, 69, 73, Ascii.SI}));
        return (telephonyManager == null || telephonyManager.getSimState() != 5) ? bool : Boolean.TRUE;
    }
}
