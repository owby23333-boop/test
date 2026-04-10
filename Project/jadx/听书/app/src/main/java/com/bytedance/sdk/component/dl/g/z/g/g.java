package com.bytedance.sdk.component.dl.g.z.g;

import com.bytedance.sdk.component.dl.g.kb;
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

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f661a;
    private boolean dl;
    private int g = 0;
    private final List<kb> z;

    public g(List<kb> list) {
        this.z = list;
    }

    public kb z(SSLSocket sSLSocket) throws IOException {
        kb kbVar;
        int i = this.g;
        int size = this.z.size();
        while (true) {
            if (i >= size) {
                kbVar = null;
                break;
            }
            kbVar = this.z.get(i);
            if (kbVar.z(sSLSocket)) {
                this.g = i + 1;
                break;
            }
            i++;
        }
        if (kbVar == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f661a + ", modes=" + this.z + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        this.dl = g(sSLSocket);
        com.bytedance.sdk.component.dl.g.z.z.z.z(kbVar, sSLSocket, this.f661a);
        return kbVar;
    }

    public boolean z(IOException iOException) {
        this.f661a = true;
        if (!this.dl || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof SSLProtocolException);
    }

    private boolean g(SSLSocket sSLSocket) {
        for (int i = this.g; i < this.z.size(); i++) {
            if (this.z.get(i).z(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
