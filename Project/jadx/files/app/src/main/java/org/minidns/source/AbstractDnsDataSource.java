package org.minidns.source;

import java.io.IOException;
import java.net.InetAddress;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsqueryresult.DnsQueryResult;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractDnsDataSource implements a {
    protected int a = 1024;
    protected int b = 5000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private QueryMode f21655c = QueryMode.dontCare;

    public enum QueryMode {
        dontCare,
        udpTcp,
        tcp
    }

    @Override // org.minidns.source.a
    public int a() {
        return this.a;
    }

    public QueryMode b() {
        return this.f21655c;
    }

    @Override // org.minidns.source.a
    public abstract DnsQueryResult query(DnsMessage dnsMessage, InetAddress inetAddress, int i2) throws IOException;
}
