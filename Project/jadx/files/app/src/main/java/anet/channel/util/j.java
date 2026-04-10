package anet.channel.util;

import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import com.taobao.accs.common.Constants;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class j extends SSLSocketFactory {
    private final String a = "awcn.TlsSniSocketFactory";
    private Method b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f499c;

    public j(String str) {
        this.f499c = str;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return null;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z2) throws IOException {
        if (this.f499c == null) {
            this.f499c = str;
        }
        if (ALog.isPrintLog(1)) {
            ALog.i("awcn.TlsSniSocketFactory", "customized createSocket", null, Constants.KEY_HOST, this.f499c);
        }
        InetAddress inetAddress = socket.getInetAddress();
        if (z2) {
            socket.close();
        }
        SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i2);
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        if (Build.VERSION.SDK_INT >= 17) {
            sSLCertificateSocketFactory.setHostname(sSLSocket, this.f499c);
        } else {
            try {
                if (this.b == null) {
                    this.b = sSLSocket.getClass().getMethod("setHostname", String.class);
                    this.b.setAccessible(true);
                }
                this.b.invoke(sSLSocket, this.f499c);
            } catch (Exception e2) {
                ALog.w("awcn.TlsSniSocketFactory", "SNI not useable", null, e2, new Object[0]);
            }
        }
        SSLSession session = sSLSocket.getSession();
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.TlsSniSocketFactory", null, null, "SSLSession PeerHost", session.getPeerHost());
        }
        return sSLSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
    }
}
