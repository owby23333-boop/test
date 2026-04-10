package org.minidns;

import java.io.IOException;
import java.net.InetAddress;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.minidns.cache.LruCache;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsname.DnsName;
import org.minidns.dnsqueryresult.DnsQueryResult;
import org.minidns.record.Record;
import org.minidns.record.h;
import org.minidns.record.l;
import org.minidns.source.a;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractDnsClient {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected static final LruCache f21357g = new LruCache();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected static final Logger f21358h = Logger.getLogger(AbstractDnsClient.class.getName());

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected static IpVersionSetting f21359i = IpVersionSetting.v4v6;
    private final a.InterfaceC0592a a;
    protected final Random b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final Random f21360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final org.minidns.a f21361d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected org.minidns.source.a f21362e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected IpVersionSetting f21363f;

    public enum IpVersionSetting {
        v4only(true, false),
        v6only(false, true),
        v4v6(true, true),
        v6v4(true, true);


        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final boolean f21369s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final boolean f21370t;

        IpVersionSetting(boolean z2, boolean z3) {
            this.f21369s = z2;
            this.f21370t = z3;
        }
    }

    class a implements a.InterfaceC0592a {
        a() {
        }

        @Override // org.minidns.source.a.InterfaceC0592a
        public void a(DnsMessage dnsMessage, DnsQueryResult dnsQueryResult) {
            org.minidns.dnsmessage.a aVarF = dnsMessage.f();
            AbstractDnsClient abstractDnsClient = AbstractDnsClient.this;
            if (abstractDnsClient.f21361d == null || !abstractDnsClient.a(aVarF, dnsQueryResult)) {
                return;
            }
            AbstractDnsClient.this.f21361d.a(dnsMessage.b(), dnsQueryResult);
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a = new int[Record.TYPE.values().length];

        static {
            try {
                a[Record.TYPE.A.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Record.TYPE.AAAA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    protected AbstractDnsClient(org.minidns.a aVar) {
        SecureRandom secureRandom;
        this.a = new a();
        this.f21360c = new Random();
        this.f21362e = new org.minidns.source.b();
        this.f21363f = f21359i;
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException unused) {
            secureRandom = new SecureRandom();
        }
        this.b = secureRandom;
        this.f21361d = aVar;
    }

    protected abstract DnsMessage.b a(DnsMessage.b bVar);

    protected boolean a(org.minidns.dnsmessage.a aVar, DnsQueryResult dnsQueryResult) {
        Iterator<Record<? extends h>> it = dnsQueryResult.a.f21425l.iterator();
        while (it.hasNext()) {
            if (it.next().a(aVar)) {
                return true;
            }
        }
        return false;
    }

    protected DnsMessage b(org.minidns.dnsmessage.a aVar) {
        return a(aVar).a();
    }

    public Set<org.minidns.record.b> c(DnsName dnsName) {
        return b(dnsName, Record.TYPE.AAAA);
    }

    public Set<org.minidns.record.b> d(DnsName dnsName) {
        return a(dnsName, Record.TYPE.AAAA);
    }

    public Set<l> e(DnsName dnsName) {
        return b(dnsName, Record.TYPE.NS);
    }

    public final DnsQueryResult query(String str, Record.TYPE type, Record.CLASS r4) throws IOException {
        return query(new org.minidns.dnsmessage.a(str, type, r4));
    }

    protected abstract DnsQueryResult query(DnsMessage.b bVar) throws IOException;

    private <D extends h> Set<D> b(DnsName dnsName, Record.TYPE type) {
        if (this.f21361d == null) {
            return Collections.emptySet();
        }
        org.minidns.dnsmessage.a aVar = new org.minidns.dnsmessage.a(dnsName, type);
        org.minidns.dnsqueryresult.a aVarA = this.f21361d.a(b(aVar));
        if (aVarA == null) {
            return Collections.emptySet();
        }
        return aVarA.a.a(aVar);
    }

    public final DnsQueryResult query(DnsName dnsName, Record.TYPE type) throws IOException {
        return query(new org.minidns.dnsmessage.a(dnsName, type, Record.CLASS.IN));
    }

    final DnsMessage.b a(org.minidns.dnsmessage.a aVar) {
        DnsMessage.b bVarG = DnsMessage.g();
        bVarG.a(aVar);
        bVarG.a(this.b.nextInt());
        return a(bVarG);
    }

    public final DnsQueryResult query(CharSequence charSequence, Record.TYPE type) throws IOException {
        return query(new org.minidns.dnsmessage.a(charSequence, type, Record.CLASS.IN));
    }

    public DnsQueryResult query(org.minidns.dnsmessage.a aVar) throws IOException {
        return query(a(aVar));
    }

    public Set<org.minidns.record.a> a(DnsName dnsName) {
        return b(dnsName, Record.TYPE.A);
    }

    private <D extends h> Set<D> a(DnsName dnsName, Record.TYPE type) {
        Collection collectionA;
        Set<l> setE = e(dnsName);
        if (setE.isEmpty()) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(setE.size() * 3);
        for (l lVar : setE) {
            int i2 = b.a[type.ordinal()];
            if (i2 == 1) {
                collectionA = a(lVar.f21639u);
            } else if (i2 == 2) {
                collectionA = c(lVar.f21639u);
            } else {
                throw new AssertionError();
            }
            hashSet.addAll(collectionA);
        }
        return hashSet;
    }

    public final DnsQueryResult query(org.minidns.dnsmessage.a aVar, InetAddress inetAddress, int i2) throws IOException {
        return query(b(aVar), inetAddress, i2);
    }

    protected AbstractDnsClient() {
        this(f21357g);
    }

    public Set<org.minidns.record.a> b(DnsName dnsName) {
        return a(dnsName, Record.TYPE.A);
    }

    public final DnsQueryResult query(DnsMessage dnsMessage, InetAddress inetAddress, int i2) throws IOException {
        org.minidns.a aVar = this.f21361d;
        org.minidns.dnsqueryresult.a aVarA = aVar == null ? null : aVar.a(dnsMessage);
        if (aVarA != null) {
            return aVarA;
        }
        org.minidns.dnsmessage.a aVarF = dnsMessage.f();
        Level level = Level.FINE;
        f21358h.log(level, "Asking {0} on {1} for {2} with:\n{3}", new Object[]{inetAddress, Integer.valueOf(i2), aVarF, dnsMessage});
        try {
            DnsQueryResult dnsQueryResultQuery = this.f21362e.query(dnsMessage, inetAddress, i2);
            f21358h.log(level, "Response from {0} on {1} for {2}:\n{3}", new Object[]{inetAddress, Integer.valueOf(i2), aVarF, dnsQueryResultQuery});
            this.a.a(dnsMessage, dnsQueryResultQuery);
            return dnsQueryResultQuery;
        } catch (IOException e2) {
            f21358h.log(level, "IOException {0} on {1} while resolving {2}: {3}", new Object[]{inetAddress, Integer.valueOf(i2), aVarF, e2});
            throw e2;
        }
    }

    public DnsQueryResult query(String str, Record.TYPE type, Record.CLASS r4, InetAddress inetAddress, int i2) throws IOException {
        return query(new org.minidns.dnsmessage.a(str, type, r4), inetAddress, i2);
    }

    public DnsQueryResult query(String str, Record.TYPE type, Record.CLASS r4, InetAddress inetAddress) throws IOException {
        return query(new org.minidns.dnsmessage.a(str, type, r4), inetAddress);
    }

    public DnsQueryResult query(String str, Record.TYPE type, InetAddress inetAddress) throws IOException {
        return query(new org.minidns.dnsmessage.a(str, type, Record.CLASS.IN), inetAddress);
    }

    public final DnsQueryResult query(DnsMessage dnsMessage, InetAddress inetAddress) throws IOException {
        return query(dnsMessage, inetAddress, 53);
    }

    public DnsQueryResult query(org.minidns.dnsmessage.a aVar, InetAddress inetAddress) throws IOException {
        return query(aVar, inetAddress, 53);
    }
}
