package com.danikula.videocache;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: IgnoreHostProxySelector.java */
/* JADX INFO: loaded from: classes2.dex */
class i extends ProxySelector {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<Proxy> f14781d = Arrays.asList(Proxy.NO_PROXY);
    private final ProxySelector a;
    private final String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f14782c;

    i(ProxySelector proxySelector, String str, int i2) {
        k.a(proxySelector);
        this.a = proxySelector;
        k.a(str);
        this.b = str;
        this.f14782c = i2;
    }

    static void a(String str, int i2) {
        ProxySelector.setDefault(new i(ProxySelector.getDefault(), str, i2));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.a.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return this.b.equals(uri.getHost()) && this.f14782c == uri.getPort() ? f14781d : this.a.select(uri);
    }
}
