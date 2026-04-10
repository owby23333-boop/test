package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import ms.bz.bd.c.Pgl.pbly;

/* JADX INFO: loaded from: classes4.dex */
final class h extends pbly.pgla {
    h() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object z(long j, String str, Object obj) throws Throwable {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    String name = networkInterfaceNextElement.getName();
                    if (!TextUtils.isEmpty(name) && !inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address) && name.startsWith((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b89079", new byte[]{97, 55, 68, 65, Ascii.FS}))) {
                        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "59fc1b", new byte[]{45, 53, 16, 3, 47, 113, 50, 10, 50, 32, 55, 123, Ascii.ESC, Ascii.SYN, 3, 112, 108});
                        networkInterfaceNextElement.getName();
                        return networkInterfaceNextElement.getName();
                    }
                }
            }
            return "";
        } catch (SocketException unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "aa0a2b", new byte[]{119, 102, 87, 85, 36, 101, 67, 68, 101, 35, 117, 112, 80, 85, 11, 116, 107, 76, 59});
            return "";
        }
    }
}
