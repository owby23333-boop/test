package ms.bz.bd.c.Pgl;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okio.Utf8;

/* JADX INFO: loaded from: classes9.dex */
class pbla extends SSLSocketFactory {
    private static final String[] bf = {(String) pblk.a(16777217, 0, 0, "00852f", new byte[]{Ascii.NAK, Ascii.RS, 120, 87, 92, Utf8.REPLACEMENT_BYTE, 97})};
    final SSLSocketFactory e;

    public pbla(SSLSocketFactory sSLSocketFactory) {
        this.e = sSLSocketFactory;
    }

    private Socket e(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(bf);
        }
        return socket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        return e(this.e.createSocket(str, i));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.e.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.e.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return e(this.e.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return e(this.e.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return e(this.e.createSocket(inetAddress, i, inetAddress2, i2));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return e(this.e.createSocket(socket, str, i, z));
    }
}
