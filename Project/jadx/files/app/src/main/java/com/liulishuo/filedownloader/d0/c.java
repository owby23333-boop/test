package com.liulishuo.filedownloader.d0;

import com.liulishuo.filedownloader.h0.c;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: FileDownloadUrlConnection.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements com.liulishuo.filedownloader.d0.b {
    protected URLConnection a;

    /* JADX INFO: compiled from: FileDownloadUrlConnection.java */
    public static class a {
        private Proxy a;
        private Integer b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Integer f17105c;
    }

    /* JADX INFO: compiled from: FileDownloadUrlConnection.java */
    public static class b implements c.b {
        private final a a;

        public b() {
            this(null);
        }

        @Override // com.liulishuo.filedownloader.h0.c.b
        public com.liulishuo.filedownloader.d0.b a(String str) throws IOException {
            return new c(str, this.a);
        }

        public b(a aVar) {
            this.a = aVar;
        }
    }

    public c(String str, a aVar) throws IOException {
        this(new URL(str), aVar);
    }

    @Override // com.liulishuo.filedownloader.d0.b
    public boolean a(String str) throws ProtocolException {
        URLConnection uRLConnection = this.a;
        if (!(uRLConnection instanceof HttpURLConnection)) {
            return false;
        }
        ((HttpURLConnection) uRLConnection).setRequestMethod(str);
        return true;
    }

    @Override // com.liulishuo.filedownloader.d0.b
    public boolean a(String str, long j2) {
        return false;
    }

    @Override // com.liulishuo.filedownloader.d0.b
    public void addHeader(String str, String str2) {
        this.a.addRequestProperty(str, str2);
    }

    @Override // com.liulishuo.filedownloader.d0.b
    public Map<String, List<String>> b() {
        return this.a.getRequestProperties();
    }

    @Override // com.liulishuo.filedownloader.d0.b
    public Map<String, List<String>> c() {
        return this.a.getHeaderFields();
    }

    @Override // com.liulishuo.filedownloader.d0.b
    public void execute() throws IOException {
        this.a.connect();
    }

    @Override // com.liulishuo.filedownloader.d0.b
    public InputStream getInputStream() throws IOException {
        return this.a.getInputStream();
    }

    @Override // com.liulishuo.filedownloader.d0.b
    public int getResponseCode() throws IOException {
        URLConnection uRLConnection = this.a;
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        }
        return 0;
    }

    @Override // com.liulishuo.filedownloader.d0.b
    public String getResponseHeaderField(String str) {
        return this.a.getHeaderField(str);
    }

    public c(URL url, a aVar) throws IOException {
        if (aVar == null || aVar.a == null) {
            this.a = url.openConnection();
        } else {
            this.a = url.openConnection(aVar.a);
        }
        if (aVar != null) {
            if (aVar.b != null) {
                this.a.setReadTimeout(aVar.b.intValue());
            }
            if (aVar.f17105c != null) {
                this.a.setConnectTimeout(aVar.f17105c.intValue());
            }
        }
    }

    @Override // com.liulishuo.filedownloader.d0.b
    public void a() {
        try {
            this.a.getInputStream().close();
        } catch (IOException unused) {
        }
    }
}
