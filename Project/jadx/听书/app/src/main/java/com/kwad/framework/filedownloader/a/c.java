package com.kwad.framework.filedownloader.a;

import com.kwad.framework.filedownloader.f.c;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.j;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements com.kwad.framework.filedownloader.a.b {
    protected URLConnection amB;

    @Override // com.kwad.framework.filedownloader.a.b
    public final void xS() {
    }

    public c(String str, a aVar) {
        this(new URL(str), aVar);
    }

    private c(URL url, a aVar) {
        if (aVar == null || aVar.amC == null) {
            this.amB = url.openConnection();
        } else {
            this.amB = url.openConnection(aVar.amC);
        }
        try {
            TLSConnectionUtils.wrapHttpURLConnection(this.amB);
        } catch (Throwable unused) {
        }
        if (aVar != null) {
            if (aVar.amD != null) {
                this.amB.setReadTimeout(aVar.amD.intValue());
            }
            if (aVar.amE != null) {
                this.amB.setConnectTimeout(aVar.amE.intValue());
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void addHeader(String str, String str2) {
        this.amB.addRequestProperty(str, str2);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final InputStream getInputStream() throws IOException {
        return ((j) ServiceProvider.get(j.class)).wrapInputStream(this.amB.getInputStream());
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final Map<String, List<String>> xQ() {
        return this.amB.getRequestProperties();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final Map<String, List<String>> xR() {
        return this.amB.getHeaderFields();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final String bn(String str) {
        return this.amB.getHeaderField(str);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void execute() throws IOException {
        this.amB.connect();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final int getResponseCode() throws IOException {
        URLConnection uRLConnection = this.amB;
        if (!(uRLConnection instanceof HttpURLConnection)) {
            return 0;
        }
        try {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    public static class b implements c.b {
        private final a amF;

        public b() {
            this(null);
        }

        private b(a aVar) {
            this.amF = null;
        }

        @Override // com.kwad.framework.filedownloader.f.c.b
        public final com.kwad.framework.filedownloader.a.b bo(String str) {
            return new c(str, this.amF);
        }
    }

    public static class a {
        private Proxy amC;
        private Integer amD;
        private Integer amE;
    }
}
