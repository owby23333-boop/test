package com.bytedance.sdk.openadsdk.core.lq;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z extends SSLSocketFactory {
    protected SSLSocketFactory z = HttpsURLConnection.getDefaultSSLSocketFactory();
}
