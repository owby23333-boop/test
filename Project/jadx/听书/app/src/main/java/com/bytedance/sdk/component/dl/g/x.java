package com.bytedance.sdk.component.dl.g;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public final class x {
    final InetSocketAddress dl;
    final Proxy g;
    final z z;

    public x(z zVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (zVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.z = zVar;
        this.g = proxy;
        this.dl = inetSocketAddress;
    }

    public z z() {
        return this.z;
    }

    public Proxy g() {
        return this.g;
    }

    public InetSocketAddress dl() {
        return this.dl;
    }

    public boolean a() {
        return this.z.fo != null && this.g.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return xVar.z.equals(this.z) && xVar.g.equals(this.g) && xVar.dl.equals(this.dl);
    }

    public int hashCode() {
        return ((((this.z.hashCode() + 527) * 31) + this.g.hashCode()) * 31) + this.dl.hashCode();
    }

    public String toString() {
        return "Route{" + this.dl + "}";
    }
}
