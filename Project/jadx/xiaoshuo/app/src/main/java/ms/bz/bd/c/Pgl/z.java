package ms.bz.bd.c.Pgl;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import ms.bz.bd.c.Pgl.pblb;

/* JADX INFO: loaded from: classes9.dex */
final class z extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, long j, String str, Object obj) throws Throwable {
        String string;
        try {
            WifiInfo connectionInfo = ((WifiManager) pgla.e().bf().getApplicationContext().getSystemService((String) pblk.a(16777217, 0, 0L, "534084", new byte[]{51, 56, 65, 77}))).getConnectionInfo();
            Method declaredMethod = connectionInfo.getClass().getDeclaredMethod(new String(pbly.e((String) pblk.a(16777217, 0, 0L, "592147", new byte[]{114, 108, Ascii.ETB, 16, 92, 116, 98, 65, 52, 49, 112, 106, Ascii.ETB, 17, 93, 116, 97, 74, 53, 52, 115, 104, Ascii.SYN, Ascii.SYN}))), new Class[0]);
            declaredMethod.setAccessible(true);
            string = Integer.toString(((Integer) declaredMethod.invoke(connectionInfo, new Object[0])).intValue());
        } catch (Throwable unused) {
            string = null;
        }
        return TextUtils.isEmpty(string) ? (String) pblk.a(16777217, 0, 0L, "c0b71d", new byte[]{34}) : string.trim();
    }
}
