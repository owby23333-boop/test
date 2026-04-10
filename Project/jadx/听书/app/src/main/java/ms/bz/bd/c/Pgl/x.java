package ms.bz.bd.c.Pgl;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import ms.bz.bd.c.Pgl.pbly;
import okio.Utf8;

/* JADX INFO: loaded from: classes4.dex */
final class x extends pbly.pgla {
    x() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    protected final Object z(long j, String str, Object obj) throws Throwable {
        String string;
        try {
            WifiInfo connectionInfo = ((WifiManager) pblv.z().g().getApplicationContext().getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4cf430", new byte[]{50, 104, 19, 73}))).getConnectionInfo();
            Method declaredMethod = connectionInfo.getClass().getDeclaredMethod(new String(pbla.z((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3c8e59", new byte[]{116, 54, Ascii.GS, 68, 93, 122, 100, Ascii.ESC, 62, 101, 118, 48, Ascii.GS, 69, 92, 122, 103, 16, Utf8.REPLACEMENT_BYTE, 96, 117, 50, Ascii.FS, 66}))), new Class[0]);
            declaredMethod.setAccessible(true);
            string = Integer.toString(((Integer) declaredMethod.invoke(connectionInfo, new Object[0])).intValue());
        } catch (Throwable unused) {
            string = null;
        }
        return TextUtils.isEmpty(string) ? (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "646eb2", new byte[]{119}) : string.trim();
    }
}
