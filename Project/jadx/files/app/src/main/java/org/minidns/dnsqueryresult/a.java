package org.minidns.dnsqueryresult;

import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsqueryresult.DnsQueryResult;

/* JADX INFO: compiled from: CachedDnsQueryResult.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends DnsQueryResult {
    protected a(DnsMessage dnsMessage, DnsQueryResult dnsQueryResult) {
        super(DnsQueryResult.QueryMethod.cachedDirect, dnsMessage, dnsQueryResult.a);
    }
}
