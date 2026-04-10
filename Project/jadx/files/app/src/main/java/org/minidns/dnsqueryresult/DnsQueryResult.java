package org.minidns.dnsqueryresult;

import org.minidns.dnsmessage.DnsMessage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DnsQueryResult {
    public final DnsMessage a;

    public enum QueryMethod {
        udp,
        tcp,
        asyncUdp,
        asyncTcp,
        cachedDirect,
        cachedSynthesized,
        testWorld
    }

    protected DnsQueryResult(QueryMethod queryMethod, DnsMessage dnsMessage, DnsMessage dnsMessage2) {
        this.a = dnsMessage2;
    }

    public String toString() {
        return this.a.toString();
    }
}
