package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    final s a;
    final o b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final SocketFactory f886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final b f887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final List<w> f888e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final List<k> f889f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final ProxySelector f890g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Proxy f891h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final SSLSocketFactory f892i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final HostnameVerifier f893j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final g f894k;

    public a(String str, int i2, o oVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, g gVar, b bVar, Proxy proxy, List<w> list, List<k> list2, ProxySelector proxySelector) {
        this.a = new s.a().e(sSLSocketFactory != null ? "https" : "http").c(str).a(i2).a();
        if (oVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.b = oVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.f886c = socketFactory;
        if (bVar == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.f887d = bVar;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.f888e = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f889f = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.f890g = proxySelector;
        this.f891h = proxy;
        this.f892i = sSLSocketFactory;
        this.f893j = hostnameVerifier;
        this.f894k = gVar;
    }

    public g a() {
        return this.f894k;
    }

    boolean a(a aVar) {
        return this.b.equals(aVar.b) && this.f887d.equals(aVar.f887d) && this.f888e.equals(aVar.f888e) && this.f889f.equals(aVar.f889f) && this.f890g.equals(aVar.f890g) && bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f891h, aVar.f891h) && bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f892i, aVar.f892i) && bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f893j, aVar.f893j) && bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f894k, aVar.f894k) && k().j() == aVar.k().j();
    }

    public List<k> b() {
        return this.f889f;
    }

    public o c() {
        return this.b;
    }

    public HostnameVerifier d() {
        return this.f893j;
    }

    public List<w> e() {
        return this.f888e;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.a.equals(aVar.a) && a(aVar)) {
                return true;
            }
        }
        return false;
    }

    public Proxy f() {
        return this.f891h;
    }

    public b g() {
        return this.f887d;
    }

    public ProxySelector h() {
        return this.f890g;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode();
        int iHashCode2 = this.b.hashCode();
        int iHashCode3 = this.f887d.hashCode();
        int iHashCode4 = this.f888e.hashCode();
        int iHashCode5 = this.f889f.hashCode();
        int iHashCode6 = this.f890g.hashCode();
        Proxy proxy = this.f891h;
        int iHashCode7 = proxy != null ? proxy.hashCode() : 0;
        SSLSocketFactory sSLSocketFactory = this.f892i;
        int iHashCode8 = sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0;
        HostnameVerifier hostnameVerifier = this.f893j;
        int iHashCode9 = hostnameVerifier != null ? hostnameVerifier.hashCode() : 0;
        g gVar = this.f894k;
        return ((iHashCode9 + ((iHashCode8 + ((iHashCode7 + ((((((((((((iHashCode + 527) * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + iHashCode5) * 31) + iHashCode6) * 31)) * 31)) * 31)) * 31) + (gVar != null ? gVar.hashCode() : 0);
    }

    public SocketFactory i() {
        return this.f886c;
    }

    public SSLSocketFactory j() {
        return this.f892i;
    }

    public s k() {
        return this.a;
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.a.g());
        sb.append(":");
        sb.append(this.a.j());
        if (this.f891h != null) {
            sb.append(", proxy=");
            obj = this.f891h;
        } else {
            sb.append(", proxySelector=");
            obj = this.f890g;
        }
        sb.append(obj);
        sb.append("}");
        return sb.toString();
    }
}
