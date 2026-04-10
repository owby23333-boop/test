package org.minidns.iterative;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import org.minidns.AbstractDnsClient;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsqueryresult.DnsQueryResult;
import org.minidns.util.MultipleIoException;

/* JADX INFO: loaded from: classes3.dex */
public class ReliableDnsClient extends AbstractDnsClient {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final org.minidns.iterative.a f21513j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final org.minidns.b f21514k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Mode f21515l;

    public enum Mode {
        recursiveWithIterativeFallback,
        recursiveOnly,
        iterativeOnly
    }

    public ReliableDnsClient(org.minidns.a aVar) {
        super(aVar);
        this.f21515l = Mode.recursiveWithIterativeFallback;
        this.f21513j = new a(aVar);
        this.f21514k = new b(aVar);
    }

    protected String a(DnsMessage dnsMessage) {
        return null;
    }

    @Override // org.minidns.AbstractDnsClient
    protected DnsMessage.b a(DnsMessage.b bVar) {
        return bVar;
    }

    @Override // org.minidns.AbstractDnsClient
    protected boolean a(org.minidns.dnsmessage.a aVar, DnsQueryResult dnsQueryResult) {
        return a(dnsQueryResult.a) == null;
    }

    @Override // org.minidns.AbstractDnsClient
    protected DnsQueryResult query(DnsMessage.b bVar) throws IOException {
        DnsQueryResult dnsQueryResultQuery;
        String str;
        LinkedList linkedList = new LinkedList();
        String str2 = null;
        if (this.f21515l != Mode.iterativeOnly) {
            try {
                dnsQueryResultQuery = this.f21514k.query(bVar);
                if (dnsQueryResultQuery != null) {
                    try {
                        String strA = a(dnsQueryResultQuery.a);
                        if (strA == null) {
                            return dnsQueryResultQuery;
                        }
                        str2 = strA;
                    } catch (IOException e2) {
                        e = e2;
                        linkedList.add(e);
                    }
                }
            } catch (IOException e3) {
                e = e3;
                dnsQueryResultQuery = null;
            }
        } else {
            dnsQueryResultQuery = null;
        }
        if (this.f21515l == Mode.recursiveOnly) {
            return dnsQueryResultQuery;
        }
        Level level = Level.FINE;
        if (AbstractDnsClient.f21358h.isLoggable(level) && this.f21515l != Mode.iterativeOnly) {
            if (!linkedList.isEmpty()) {
                str = "Resolution fall back to iterative mode because: " + linkedList.get(0);
            } else if (dnsQueryResultQuery == null) {
                str = "Resolution fall back to iterative mode because:  DnsClient did not return a response";
            } else {
                if (str2 == null) {
                    throw new AssertionError("This should never been reached");
                }
                str = "Resolution fall back to iterative mode because: " + str2 + ". Response:\n" + dnsQueryResultQuery;
            }
            AbstractDnsClient.f21358h.log(level, str);
        }
        try {
            dnsQueryResultQuery = this.f21513j.query(bVar);
        } catch (IOException e4) {
            linkedList.add(e4);
        }
        if (dnsQueryResultQuery == null) {
            MultipleIoException.a((List<? extends IOException>) linkedList);
        }
        return dnsQueryResultQuery;
    }

    class a extends org.minidns.iterative.a {
        a(org.minidns.a aVar) {
            super(aVar);
        }

        @Override // org.minidns.iterative.a, org.minidns.AbstractDnsClient
        protected DnsMessage.b a(DnsMessage.b bVar) {
            super.a(bVar);
            return ReliableDnsClient.this.a(bVar);
        }

        @Override // org.minidns.iterative.a, org.minidns.AbstractDnsClient
        protected boolean a(org.minidns.dnsmessage.a aVar, DnsQueryResult dnsQueryResult) {
            return ReliableDnsClient.this.a(aVar, dnsQueryResult) && super.a(aVar, dnsQueryResult);
        }
    }

    class b extends org.minidns.b {
        b(org.minidns.a aVar) {
            super(aVar);
        }

        @Override // org.minidns.b, org.minidns.AbstractDnsClient
        protected DnsMessage.b a(DnsMessage.b bVar) {
            super.a(bVar);
            return ReliableDnsClient.this.a(bVar);
        }

        @Override // org.minidns.AbstractDnsClient
        protected boolean a(org.minidns.dnsmessage.a aVar, DnsQueryResult dnsQueryResult) {
            return ReliableDnsClient.this.a(aVar, dnsQueryResult) && super.a(aVar, dnsQueryResult);
        }
    }

    public ReliableDnsClient() {
        this(AbstractDnsClient.f21357g);
    }
}
