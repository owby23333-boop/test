package com.kwai.filedownloader.kwai;

import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.h;
import com.kwai.filedownloader.e.c;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements com.kwai.filedownloader.kwai.b {
    protected URLConnection aER;

    public static class a {
        private Proxy aES;
        private Integer aET;
        private Integer aEU;
    }

    public static class b implements c.b {
        private final a aEV;

        public b() {
            this(null);
        }

        private b(a aVar) {
            this.aEV = null;
        }

        @Override // com.kwai.filedownloader.e.c.b
        public final com.kwai.filedownloader.kwai.b q(String str) {
            return new c(str, this.aEV);
        }
    }

    public c(String str, a aVar) {
        this(new URL(str), aVar);
    }

    private c(URL url, a aVar) {
        this.aER = (aVar == null || aVar.aES == null) ? url.openConnection() : url.openConnection(aVar.aES);
        try {
            TLSConnectionUtils.wrapHttpURLConnection(this.aER);
        } catch (Throwable unused) {
        }
        if (aVar != null) {
            if (aVar.aET != null) {
                this.aER.setReadTimeout(aVar.aET.intValue());
            }
            if (aVar.aEU != null) {
                this.aER.setConnectTimeout(aVar.aEU.intValue());
            }
        }
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final Map<String, List<String>> V() {
        return this.aER.getRequestProperties();
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final Map<String, List<String>> W() {
        return this.aER.getHeaderFields();
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final void X() {
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final void addHeader(String str, String str2) {
        this.aER.addRequestProperty(str, str2);
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final void execute() throws IOException {
        this.aER.connect();
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final InputStream getInputStream() throws IOException {
        return ((h) ServiceProvider.get(h.class)).wrapInputStream(this.aER.getInputStream());
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final int getResponseCode() throws IOException {
        URLConnection uRLConnection = this.aER;
        if (!(uRLConnection instanceof HttpURLConnection)) {
            return 0;
        }
        try {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final String o(String str) {
        return this.aER.getHeaderField(str);
    }
}
