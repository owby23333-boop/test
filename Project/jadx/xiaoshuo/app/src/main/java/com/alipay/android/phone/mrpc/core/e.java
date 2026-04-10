package com.alipay.android.phone.mrpc.core;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes.dex */
class e extends DefaultRedirectHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f1644b;

    public e(d dVar) {
        this.f1644b = dVar;
    }

    @Override // org.apache.http.impl.client.DefaultRedirectHandler, org.apache.http.client.RedirectHandler
    public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
        int statusCode;
        this.f1643a++;
        boolean zIsRedirectRequested = super.isRedirectRequested(httpResponse, httpContext);
        if (zIsRedirectRequested || this.f1643a >= 5 || !((statusCode = httpResponse.getStatusLine().getStatusCode()) == 301 || statusCode == 302)) {
            return zIsRedirectRequested;
        }
        return true;
    }
}
