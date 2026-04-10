package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import ms.bz.bd.c.Pgl.pblb;

/* JADX INFO: loaded from: classes9.dex */
final class j extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, long j, String str, Object obj) throws Throwable {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    String name = networkInterfaceNextElement.getName();
                    if (!TextUtils.isEmpty(name) && !inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address) && name.startsWith((String) pblk.a(16777217, 0, 0L, "9c660c", new byte[]{58, 108, 75, 71, Ascii.ESC}))) {
                        networkInterfaceNextElement.getName();
                        return networkInterfaceNextElement.getName();
                    }
                }
            }
            return "";
        } catch (SocketException e) {
            e.toString();
            return "";
        }
    }
}
