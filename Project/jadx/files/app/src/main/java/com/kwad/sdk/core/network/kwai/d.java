package com.kwad.sdk.core.network.kwai;

import android.text.TextUtils;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;
import okhttp3.Dns;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Dns {
    private static final Dns SYSTEM = Dns.SYSTEM;

    @Override // okhttp3.Dns
    public final List<InetAddress> lookup(String str) {
        String strDI = com.kwad.sdk.ip.direct.a.dI(str);
        if (TextUtils.isEmpty(strDI)) {
            com.kwad.sdk.core.d.b.d("IpDirect_OkHttpDns", "Dns.SYSTEM.lookup(hostname):" + Dns.SYSTEM.lookup(str));
        } else {
            List<InetAddress> listAsList = Arrays.asList(InetAddress.getAllByName(strDI));
            if (listAsList != null && !listAsList.isEmpty()) {
                com.kwad.sdk.core.d.b.d("IpDirect_OkHttpDns", "inetAddresses:" + listAsList);
                return listAsList;
            }
        }
        return SYSTEM.lookup(str);
    }
}
