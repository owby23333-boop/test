package org.minidns.d;

import java.net.IDN;
import org.minidns.dnsname.DnsName;

/* JADX INFO: compiled from: DefaultIdnaTransformator.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements b {
    @Override // org.minidns.d.b
    public String a(String str) {
        return IDN.toUnicode(str);
    }

    @Override // org.minidns.d.b
    public String b(String str) {
        return DnsName.f21472z.f21473s.equals(str) ? DnsName.f21472z.f21473s : IDN.toASCII(str);
    }
}
