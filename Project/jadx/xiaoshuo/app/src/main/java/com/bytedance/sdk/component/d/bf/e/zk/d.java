package com.bytedance.sdk.component.d.bf.e.zk;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static d e(X509TrustManager x509TrustManager) {
        return com.bytedance.sdk.component.d.bf.e.p.ga.bf().e(x509TrustManager);
    }

    public abstract List<Certificate> e(List<Certificate> list, String str) throws SSLPeerUnverifiedException;
}
