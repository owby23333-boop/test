package org.minidns;

import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsname.DnsName;
import org.minidns.dnsqueryresult.DnsQueryResult;

/* JADX INFO: compiled from: DnsCache.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public final void a(DnsMessage dnsMessage, DnsQueryResult dnsQueryResult) {
        b(dnsMessage.b(), dnsQueryResult);
    }

    public abstract void a(DnsMessage dnsMessage, DnsQueryResult dnsQueryResult, DnsName dnsName);

    protected abstract org.minidns.dnsqueryresult.a b(DnsMessage dnsMessage);

    protected abstract void b(DnsMessage dnsMessage, DnsQueryResult dnsQueryResult);

    public final org.minidns.dnsqueryresult.a a(DnsMessage dnsMessage) {
        return b(dnsMessage.b());
    }
}
