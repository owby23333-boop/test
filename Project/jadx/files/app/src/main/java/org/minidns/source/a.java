package org.minidns.source;

import java.io.IOException;
import java.net.InetAddress;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsqueryresult.DnsQueryResult;

/* JADX INFO: compiled from: DnsDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public interface a {

    /* JADX INFO: renamed from: org.minidns.source.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DnsDataSource.java */
    public interface InterfaceC0592a {
        void a(DnsMessage dnsMessage, DnsQueryResult dnsQueryResult);
    }

    int a();

    DnsQueryResult query(DnsMessage dnsMessage, InetAddress inetAddress, int i2) throws IOException;
}
