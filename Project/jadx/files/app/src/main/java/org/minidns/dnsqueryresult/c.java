package org.minidns.dnsqueryresult;

import java.net.InetAddress;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsqueryresult.DnsQueryResult;

/* JADX INFO: compiled from: StandardDnsQueryResult.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends DnsQueryResult {
    public c(InetAddress inetAddress, int i2, DnsQueryResult.QueryMethod queryMethod, DnsMessage dnsMessage, DnsMessage dnsMessage2) {
        super(queryMethod, dnsMessage, dnsMessage2);
    }
}
