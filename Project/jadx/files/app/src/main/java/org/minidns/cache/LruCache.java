package org.minidns.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import org.minidns.a;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsname.DnsName;
import org.minidns.dnsqueryresult.DnsQueryResult;
import org.minidns.dnsqueryresult.b;

/* JADX INFO: loaded from: classes3.dex */
public class LruCache extends a {
    protected long a;
    protected long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected long f21389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f21390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected long f21391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected LinkedHashMap<DnsMessage, org.minidns.dnsqueryresult.a> f21392f;

    public LruCache(final int i2, long j2) {
        this.a = 0L;
        this.b = 0L;
        this.f21389c = 0L;
        this.f21390d = i2;
        this.f21391e = j2;
        this.f21392f = new LinkedHashMap<DnsMessage, org.minidns.dnsqueryresult.a>(this, Math.min(((i2 + 3) / 4) + i2 + 2, 11), 0.75f, true) { // from class: org.minidns.cache.LruCache.1
            @Override // java.util.LinkedHashMap
            protected boolean removeEldestEntry(Map.Entry<DnsMessage, org.minidns.dnsqueryresult.a> entry) {
                return size() > i2;
            }
        };
    }

    @Override // org.minidns.a
    public void a(DnsMessage dnsMessage, DnsQueryResult dnsQueryResult, DnsName dnsName) {
    }

    @Override // org.minidns.a
    protected synchronized void b(DnsMessage dnsMessage, DnsQueryResult dnsQueryResult) {
        if (dnsQueryResult.a.f21429p <= 0) {
            return;
        }
        this.f21392f.put(dnsMessage, new b(dnsMessage, dnsQueryResult));
    }

    public String toString() {
        return "LRUCache{usage=" + this.f21392f.size() + "/" + this.f21390d + ", hits=" + this.f21389c + ", misses=" + this.a + ", expires=" + this.b + "}";
    }

    @Override // org.minidns.a
    protected synchronized org.minidns.dnsqueryresult.a b(DnsMessage dnsMessage) {
        org.minidns.dnsqueryresult.a aVar = this.f21392f.get(dnsMessage);
        if (aVar == null) {
            this.a++;
            return null;
        }
        DnsMessage dnsMessage2 = aVar.a;
        if (dnsMessage2.f21429p + (Math.min(dnsMessage2.e(), this.f21391e) * 1000) < System.currentTimeMillis()) {
            this.a++;
            this.b++;
            this.f21392f.remove(dnsMessage);
            return null;
        }
        this.f21389c++;
        return aVar;
    }

    public LruCache(int i2) {
        this(i2, Long.MAX_VALUE);
    }

    public LruCache() {
        this(512);
    }
}
