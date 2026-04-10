package com.bykv.vk.openvk.component.video.e.bf;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class m extends ProxySelector {
    private static final List<Proxy> e = Collections.singletonList(Proxy.NO_PROXY);
    private final ProxySelector bf = ProxySelector.getDefault();
    private final String d;
    private final int tg;

    private m(String str, int i) {
        this.d = str;
        this.tg = i;
    }

    public static void e(String str, int i) {
        ProxySelector.setDefault(new m(str, i));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.bf.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        if (uri != null) {
            return (this.d.equalsIgnoreCase(uri.getHost()) && this.tg == uri.getPort()) ? e : this.bf.select(uri);
        }
        throw new IllegalArgumentException("URI can't be null");
    }
}
