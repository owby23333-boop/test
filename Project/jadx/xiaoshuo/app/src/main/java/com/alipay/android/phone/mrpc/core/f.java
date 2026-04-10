package com.alipay.android.phone.mrpc.core;

import com.yuewen.f82;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes.dex */
class f implements ConnectionKeepAliveStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f1645a;

    public f(d dVar) {
        this.f1645a = dVar;
    }

    @Override // org.apache.http.conn.ConnectionKeepAliveStrategy
    public long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
        return f82.g;
    }
}
