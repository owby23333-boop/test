package com.bytedance.sdk.component.d.bf.e.bf;

import com.bytedance.sdk.component.d.bf.wu;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
public final class bf {
    private int bf = 0;
    private boolean d;
    private final List<wu> e;
    private boolean tg;

    public bf(List<wu> list) {
        this.e = list;
    }

    private boolean bf(SSLSocket sSLSocket) {
        for (int i = this.bf; i < this.e.size(); i++) {
            if (this.e.get(i).e(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public wu e(SSLSocket sSLSocket) throws IOException {
        wu wuVar;
        int i = this.bf;
        int size = this.e.size();
        while (true) {
            if (i >= size) {
                wuVar = null;
                break;
            }
            wuVar = this.e.get(i);
            if (wuVar.e(sSLSocket)) {
                this.bf = i + 1;
                break;
            }
            i++;
        }
        if (wuVar != null) {
            this.d = bf(sSLSocket);
            com.bytedance.sdk.component.d.bf.e.e.e.e(wuVar, sSLSocket, this.tg);
            return wuVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.tg + ", modes=" + this.e + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean e(IOException iOException) {
        this.tg = true;
        if (!this.d || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof SSLProtocolException);
    }
}
