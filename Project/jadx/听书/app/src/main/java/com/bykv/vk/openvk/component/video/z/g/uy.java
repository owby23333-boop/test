package com.bykv.vk.openvk.component.video.z.g;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class uy extends ProxySelector {
    private static final List<Proxy> z = Collections.singletonList(Proxy.NO_PROXY);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f116a;
    private final String dl;
    private final ProxySelector g = ProxySelector.getDefault();

    private uy(String str, int i) {
        this.dl = str;
        this.f116a = i;
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        if (uri != null) {
            return (this.dl.equalsIgnoreCase(uri.getHost()) && this.f116a == uri.getPort()) ? z : this.g.select(uri);
        }
        throw new IllegalArgumentException("URI can't be null");
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.g.connectFailed(uri, socketAddress, iOException);
    }

    static void z(String str, int i) {
        ProxySelector.setDefault(new uy(str, i));
    }
}
