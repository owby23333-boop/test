package com.bytedance.sdk.component.dl.g;

import com.bytedance.sdk.component.dl.g.js;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final g f649a;
    final SocketFactory dl;
    final ProxySelector e;
    final SSLSocketFactory fo;
    final pf g;
    final List<io> gc;
    final Proxy gz;
    final e kb;
    final List<kb> m;
    final HostnameVerifier uy;
    final js z;

    public z(String str, int i, pf pfVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, e eVar, g gVar, Proxy proxy, List<io> list, List<kb> list2, ProxySelector proxySelector) {
        this.z = new js.z().z(sSLSocketFactory != null ? "https" : "http").a(str).z(i).dl();
        if (pfVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.g = pfVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.dl = socketFactory;
        if (gVar == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.f649a = gVar;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.gc = com.bytedance.sdk.component.dl.g.z.dl.z(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.m = com.bytedance.sdk.component.dl.g.z.dl.z(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.e = proxySelector;
        this.gz = proxy;
        this.fo = sSLSocketFactory;
        this.uy = hostnameVerifier;
        this.kb = eVar;
    }

    public js z() {
        return this.z;
    }

    public pf g() {
        return this.g;
    }

    public SocketFactory dl() {
        return this.dl;
    }

    public g a() {
        return this.f649a;
    }

    public List<io> gc() {
        return this.gc;
    }

    public List<kb> m() {
        return this.m;
    }

    public ProxySelector e() {
        return this.e;
    }

    public Proxy gz() {
        return this.gz;
    }

    public SSLSocketFactory fo() {
        return this.fo;
    }

    public HostnameVerifier uy() {
        return this.uy;
    }

    public e kb() {
        return this.kb;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return this.z.equals(zVar.z) && z(zVar);
    }

    public int hashCode() {
        int iHashCode = (((((((((((this.z.hashCode() + 527) * 31) + this.g.hashCode()) * 31) + this.f649a.hashCode()) * 31) + this.gc.hashCode()) * 31) + this.m.hashCode()) * 31) + this.e.hashCode()) * 31;
        Proxy proxy = this.gz;
        int iHashCode2 = (iHashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.fo;
        int iHashCode3 = (iHashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.uy;
        int iHashCode4 = (iHashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        e eVar = this.kb;
        return iHashCode4 + (eVar != null ? eVar.hashCode() : 0);
    }

    boolean z(z zVar) {
        return this.g.equals(zVar.g) && this.f649a.equals(zVar.f649a) && this.gc.equals(zVar.gc) && this.m.equals(zVar.m) && this.e.equals(zVar.e) && com.bytedance.sdk.component.dl.g.z.dl.z(this.gz, zVar.gz) && com.bytedance.sdk.component.dl.g.z.dl.z(this.fo, zVar.fo) && com.bytedance.sdk.component.dl.g.z.dl.z(this.uy, zVar.uy) && com.bytedance.sdk.component.dl.g.z.dl.z(this.kb, zVar.kb) && z().gz() == zVar.z().gz();
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("Address{").append(this.z.e()).append(":").append(this.z.gz());
        if (this.gz != null) {
            sbAppend.append(", proxy=").append(this.gz);
        } else {
            sbAppend.append(", proxySelector=").append(this.e);
        }
        sbAppend.append("}");
        return sbAppend.toString();
    }
}
