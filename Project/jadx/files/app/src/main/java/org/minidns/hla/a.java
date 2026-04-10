package org.minidns.hla;

import java.io.IOException;
import org.minidns.AbstractDnsClient;
import org.minidns.dnsname.DnsName;
import org.minidns.iterative.ReliableDnsClient;
import org.minidns.record.Record;
import org.minidns.record.h;

/* JADX INFO: compiled from: ResolverApi.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static final a b = new a(new ReliableDnsClient());
    private final AbstractDnsClient a;

    public a(AbstractDnsClient abstractDnsClient) {
        this.a = abstractDnsClient;
    }

    public final <D extends h> b<D> a(String str, Class<D> cls) throws IOException {
        return a(DnsName.a(str), cls);
    }

    public final <D extends h> b<D> a(DnsName dnsName, Class<D> cls) throws IOException {
        return a(new org.minidns.dnsmessage.a(dnsName, Record.TYPE.getType(cls)));
    }

    public <D extends h> b<D> a(org.minidns.dnsmessage.a aVar) throws IOException {
        return new b<>(aVar, this.a.query(aVar), null);
    }
}
