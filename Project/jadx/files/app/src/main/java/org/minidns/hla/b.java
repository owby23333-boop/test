package org.minidns.hla;

import java.util.Collections;
import java.util.Set;
import org.minidns.MiniDnsException;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsqueryresult.DnsQueryResult;
import org.minidns.record.h;

/* JADX INFO: compiled from: ResolverResult.java */
/* JADX INFO: loaded from: classes3.dex */
public class b<D extends h> {
    protected final org.minidns.dnsmessage.a a;
    private final DnsMessage.RESPONSE_CODE b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<D> f21508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f21509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final Set<Object> f21510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final DnsMessage f21511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ResolutionUnsuccessfulException f21512g;

    b(org.minidns.dnsmessage.a aVar, DnsQueryResult dnsQueryResult, Set<Object> set) throws MiniDnsException.NullResultException {
        if (dnsQueryResult == null) {
            throw new MiniDnsException.NullResultException(aVar.a().a());
        }
        DnsMessage dnsMessage = dnsQueryResult.a;
        this.a = aVar;
        this.b = dnsMessage.f21416c;
        this.f21511f = dnsMessage;
        Set<D> setA = dnsMessage.a(aVar);
        if (setA == null) {
            this.f21508c = Collections.emptySet();
        } else {
            this.f21508c = Collections.unmodifiableSet(setA);
        }
        if (set == null) {
            this.f21510e = null;
            this.f21509d = false;
        } else {
            this.f21510e = Collections.unmodifiableSet(set);
            this.f21509d = this.f21510e.isEmpty();
        }
    }

    public Set<D> a() {
        f();
        return this.f21508c;
    }

    public DnsMessage b() {
        return this.f21511f;
    }

    public ResolutionUnsuccessfulException c() {
        if (g()) {
            return null;
        }
        if (this.f21512g == null) {
            this.f21512g = new ResolutionUnsuccessfulException(this.a, this.b);
        }
        return this.f21512g;
    }

    public DnsMessage.RESPONSE_CODE d() {
        return this.b;
    }

    boolean e() {
        Set<Object> set = this.f21510e;
        return (set == null || set.isEmpty()) ? false : true;
    }

    protected void f() {
        ResolutionUnsuccessfulException resolutionUnsuccessfulExceptionC = c();
        if (resolutionUnsuccessfulExceptionC != null) {
            throw new IllegalStateException("Can not perform operation because the DNS resolution was unsuccessful", resolutionUnsuccessfulExceptionC);
        }
    }

    public boolean g() {
        return this.b == DnsMessage.RESPONSE_CODE.NO_ERROR;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(b.class.getName());
        sb.append('\n');
        sb.append("Question: ");
        sb.append(this.a);
        sb.append('\n');
        sb.append("Response Code: ");
        sb.append(this.b);
        sb.append('\n');
        if (this.b == DnsMessage.RESPONSE_CODE.NO_ERROR) {
            if (this.f21509d) {
                sb.append("Results verified via DNSSEC\n");
            }
            if (e()) {
                sb.append(this.f21510e);
                sb.append('\n');
            }
            sb.append(this.f21511f.f21425l);
        }
        return sb.toString();
    }
}
