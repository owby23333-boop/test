package com.bytedance.sdk.component.dl.g.z.fo;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes2.dex */
public abstract class dl {
    public abstract List<Certificate> z(List<Certificate> list, String str) throws SSLPeerUnverifiedException;

    public static dl z(X509TrustManager x509TrustManager) {
        return com.bytedance.sdk.component.dl.g.z.e.gc.g().z(x509TrustManager);
    }
}
