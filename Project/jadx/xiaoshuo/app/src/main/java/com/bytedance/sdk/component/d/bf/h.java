package com.bytedance.sdk.component.d.bf;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: loaded from: classes.dex */
public final class h {
    final Proxy bf;
    final InetSocketAddress d;
    final e e;

    public h(e eVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (eVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.e = eVar;
        this.bf = proxy;
        this.d = inetSocketAddress;
    }

    public Proxy bf() {
        return this.bf;
    }

    public InetSocketAddress d() {
        return this.d;
    }

    public e e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (hVar.e.equals(this.e) && hVar.bf.equals(this.bf) && hVar.d.equals(this.d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.e.hashCode()) * 31) + this.bf.hashCode()) * 31) + this.d.hashCode();
    }

    public boolean tg() {
        return this.e.zk != null && this.bf.type() == Proxy.Type.HTTP;
    }

    public String toString() {
        return "Route{" + this.d + com.alipay.sdk.m.y.l.d;
    }
}
