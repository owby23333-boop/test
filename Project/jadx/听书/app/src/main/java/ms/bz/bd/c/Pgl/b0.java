package ms.bz.bd.c.Pgl;

import android.net.ConnectivityManager;
import com.google.common.base.Ascii;
import kotlin.io.encoding.Base64;
import ms.bz.bd.c.Pgl.pbly;

/* JADX INFO: loaded from: classes4.dex */
final class b0 extends pbly.pgla {
    b0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    protected final Object z(long j, String str, Object obj) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) pblv.z().g().getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "60965a", new byte[]{36, Base64.padSymbol, 68, 76, 15, 117, 33, Ascii.CAN, 126, 111, 51, 43}));
            return (String) (connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork()).hasTransport(4) ? com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e8a67e", new byte[]{37}) : com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "743fad", new byte[]{118}));
        } catch (Throwable unused) {
            return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6d3b33", new byte[]{119});
        }
    }
}
