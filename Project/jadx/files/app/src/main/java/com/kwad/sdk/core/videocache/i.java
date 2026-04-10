package com.kwad.sdk.core.videocache;

import com.kwad.sdk.utils.an;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class i extends ProxySelector {
    private static final List<Proxy> ans = Arrays.asList(Proxy.NO_PROXY);
    private final ProxySelector ant;
    private final String anu;
    private final int anv;

    private i(ProxySelector proxySelector, String str, int i2) {
        this.ant = (ProxySelector) an.checkNotNull(proxySelector);
        this.anu = an.et(str);
        this.anv = i2;
    }

    static void install(String str, int i2) {
        ProxySelector.setDefault(new i(ProxySelector.getDefault(), str, i2));
    }

    @Override // java.net.ProxySelector
    public final void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.ant.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public final List<Proxy> select(URI uri) {
        return this.anu.equals(uri.getHost()) && this.anv == uri.getPort() ? ans : this.ant.select(uri);
    }
}
