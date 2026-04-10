package com.sntech.okhttpconnection.log;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class IgnoreHostProxySelector extends ProxySelector {
    private static final String HOST_TO_IGNORE = "127.0.0.1";
    private static final List<Proxy> NO_PROXY_LIST = Arrays.asList(Proxy.NO_PROXY);
    private final ProxySelector defaultProxySelector = ProxySelector.getDefault();

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.defaultProxySelector.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return HOST_TO_IGNORE.equals(uri.getHost()) ? NO_PROXY_LIST : this.defaultProxySelector.select(uri);
    }
}
