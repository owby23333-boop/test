package com.chinaums.pppay.unify;

import java.io.IOException;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.SSLContext;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes10.dex */
public class SocketFactory extends SSLSocketFactory {
    private SSLContext cS;

    public SocketFactory(KeyStore keyStore) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        super(keyStore);
        this.cS = SSLContext.getInstance("TLS");
        try {
            this.cS.init(null, new javax.net.ssl.TrustManager[]{new TrustManager()}, null);
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public final Socket createSocket() throws IOException {
        return this.cS.getSocketFactory().createSocket();
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return this.cS.getSocketFactory().createSocket(socket, str, i, z);
    }
}
