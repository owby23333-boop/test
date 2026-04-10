package ms.bz.bd.c.Pgl;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okio.Utf8;

/* JADX INFO: loaded from: classes4.dex */
final class t1 extends SSLSocketFactory {
    private static final String[] g = {(String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "0dab2f", new byte[]{Ascii.NAK, 74, 33, 0, 92, Utf8.REPLACEMENT_BYTE, 97})};
    final SSLSocketFactory z;

    public t1(SSLSocketFactory sSLSocketFactory) {
        this.z = sSLSocketFactory;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i) throws IOException {
        Socket socketCreateSocket = this.z.createSocket(str, i);
        if (socketCreateSocket instanceof SSLSocket) {
            ((SSLSocket) socketCreateSocket).setEnabledProtocols(g);
        }
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.z.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.z.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        Socket socketCreateSocket = this.z.createSocket(str, i, inetAddress, i2);
        if (socketCreateSocket instanceof SSLSocket) {
            ((SSLSocket) socketCreateSocket).setEnabledProtocols(g);
        }
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        Socket socketCreateSocket = this.z.createSocket(inetAddress, i);
        if (socketCreateSocket instanceof SSLSocket) {
            ((SSLSocket) socketCreateSocket).setEnabledProtocols(g);
        }
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        Socket socketCreateSocket = this.z.createSocket(inetAddress, i, inetAddress2, i2);
        if (socketCreateSocket instanceof SSLSocket) {
            ((SSLSocket) socketCreateSocket).setEnabledProtocols(g);
        }
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        Socket socketCreateSocket = this.z.createSocket(socket, str, i, z);
        if (socketCreateSocket instanceof SSLSocket) {
            ((SSLSocket) socketCreateSocket).setEnabledProtocols(g);
        }
        return socketCreateSocket;
    }
}
