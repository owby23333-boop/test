package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: loaded from: classes.dex */
public final class c0 {
    final a a;
    final Proxy b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final InetSocketAddress f1157c;

    public c0(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.a = aVar;
        this.b = proxy;
        this.f1157c = inetSocketAddress;
    }

    public a a() {
        return this.a;
    }

    public Proxy b() {
        return this.b;
    }

    public boolean c() {
        return this.a.f892i != null && this.b.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress d() {
        return this.f1157c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c0) {
            c0 c0Var = (c0) obj;
            if (c0Var.a.equals(this.a) && c0Var.b.equals(this.b) && c0Var.f1157c.equals(this.f1157c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.a.hashCode() + 527) * 31) + this.b.hashCode()) * 31) + this.f1157c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f1157c + "}";
    }
}
