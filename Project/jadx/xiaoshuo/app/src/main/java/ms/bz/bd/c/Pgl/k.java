package ms.bz.bd.c.Pgl;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import com.google.common.base.Ascii;
import kotlin.io.encoding.Base64;
import ms.bz.bd.c.Pgl.pblb;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes9.dex */
final class k extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, long j, String str, Object obj) throws Throwable {
        JSONArray jSONArray = new JSONArray();
        try {
            DhcpInfo dhcpInfo = ((WifiManager) pgla.e().bf().getApplicationContext().getSystemService((String) pblk.a(16777217, 0, 0L, "b03a6d", new byte[]{100, 59, 70, Ascii.FS}))).getDhcpInfo();
            StringBuilder sb = new StringBuilder();
            sb.append(dhcpInfo.dns1 & 255);
            sb.append((String) pblk.a(16777217, 0, 0L, "7ca837", new byte[]{104}));
            sb.append((dhcpInfo.dns1 >> 8) & 255);
            sb.append((String) pblk.a(16777217, 0, 0L, "654d13", new byte[]{105}));
            sb.append((dhcpInfo.dns1 >> 16) & 255);
            sb.append((String) pblk.a(16777217, 0, 0L, "dd8111", new byte[]{59}));
            sb.append((dhcpInfo.dns1 >> 24) & 255);
            jSONArray.put(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(dhcpInfo.dns2 & 255);
            sb2.append((String) pblk.a(16777217, 0, 0L, "bdbcb1", new byte[]{Base64.padSymbol}));
            sb2.append((dhcpInfo.dns2 >> 8) & 255);
            sb2.append((String) pblk.a(16777217, 0, 0L, "8809f2", new byte[]{103}));
            sb2.append((dhcpInfo.dns2 >> 16) & 255);
            sb2.append((String) pblk.a(16777217, 0, 0L, "163ce1", new byte[]{110}));
            sb2.append((dhcpInfo.dns2 >> 24) & 255);
            jSONArray.put(sb2.toString());
        } catch (Throwable unused) {
        }
        return jSONArray.toString();
    }
}
