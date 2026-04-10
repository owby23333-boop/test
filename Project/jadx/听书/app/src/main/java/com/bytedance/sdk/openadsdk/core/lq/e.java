package com.bytedance.sdk.openadsdk.core.lq;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public class e extends z {
    private static final String[] g = {"TLSv1.2"};
    private final g dl;

    public String toString() {
        return "Tls12SocketFactory";
    }

    public e(SSLSocketFactory sSLSocketFactory, g gVar) {
        this.z = sSLSocketFactory;
        this.dl = gVar;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.z.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.z.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        return z(this.z.createSocket());
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return z(this.z.createSocket(socket, str, i, z));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        return z(this.z.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return z(this.z.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return z(this.z.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return z(this.z.createSocket(inetAddress, i, inetAddress2, i2));
    }

    private Socket z(Socket socket) {
        boolean z = socket instanceof SSLSocket;
        this.dl.z("socketip", socket.getLocalAddress().getHostAddress());
        return socket;
    }
}
