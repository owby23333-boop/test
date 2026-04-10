package com.bytedance.sdk.component.g.z.z.g;

import android.text.TextUtils;
import com.bytedance.sdk.component.g.z.fo;
import com.bytedance.sdk.component.g.z.kb;
import com.bytedance.sdk.component.g.z.ls;
import com.bytedance.sdk.component.g.z.pf;
import com.bytedance.sdk.component.g.z.v;
import com.bytedance.sdk.component.utils.wp;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class z implements com.bytedance.sdk.component.g.z.g {
    a g;
    private volatile boolean m;
    v z;
    private AtomicBoolean gc = new AtomicBoolean(false);
    final String dl = com.bytedance.sdk.component.g.z.g.a.z(UUID.randomUUID().toString()).z();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    kb f727a = new kb();

    z(v vVar, a aVar) {
        this.z = vVar;
        this.g = aVar;
    }

    @Override // com.bytedance.sdk.component.g.z.g
    public v z() {
        return this.z;
    }

    @Override // com.bytedance.sdk.component.g.z.g
    public void z(com.bytedance.sdk.component.g.z.dl dlVar) {
        try {
            synchronized (this) {
                if (this.m) {
                    throw new IllegalStateException("Already Executed");
                }
                this.m = true;
            }
            this.g.z(new C0134z(dlVar, this));
        } catch (Throwable th) {
            if (dlVar != null) {
                dlVar.onFailure(this, new IOException(th.getMessage()));
            }
        }
    }

    @Override // com.bytedance.sdk.component.g.z.g
    public ls g() throws IOException {
        synchronized (this) {
            if (this.m) {
                throw new IllegalStateException("Already Executed");
            }
            this.m = true;
        }
        try {
            this.g.z(this);
            return gc();
        } finally {
            this.g.g(this);
        }
    }

    public ls gc() {
        if (this.gc.get()) {
            return null;
        }
        try {
            if (this.z.z != null && this.z.z.z != null && this.z.z.z.size() > 0) {
                ArrayList arrayList = new ArrayList(this.z.z.z);
                arrayList.add(new fo() { // from class: com.bytedance.sdk.component.g.z.z.g.z.1
                    @Override // com.bytedance.sdk.component.g.z.fo
                    public ls z(fo.z zVar) throws IOException {
                        return z.this.z(zVar.z());
                    }
                });
                return ((fo) arrayList.get(0)).z(new g(arrayList, this.z));
            }
            return z(this.z);
        } catch (Throwable unused) {
            return null;
        }
    }

    public ls z(v vVar) throws IOException {
        try {
            kb kbVar = this.f727a;
            if (kbVar != null) {
                kbVar.g();
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(vVar.g().z().toString()).openConnection();
            if (vVar.a() != null && vVar.a().size() > 0) {
                for (Map.Entry<String, List<String>> entry : vVar.a().entrySet()) {
                    Iterator<String> it = entry.getValue().iterator();
                    while (it.hasNext()) {
                        httpURLConnection.addRequestProperty(entry.getKey(), it.next());
                    }
                }
            }
            if (vVar.z != null) {
                if (vVar.z.dl != null) {
                    httpURLConnection.setConnectTimeout((int) vVar.z.dl.toMillis(vVar.z.g));
                }
                if (vVar.z.gc != null) {
                    httpURLConnection.setReadTimeout((int) vVar.z.gc.toMillis(vVar.z.f723a));
                }
            }
            if (vVar.m() == null) {
                httpURLConnection.setRequestMethod("GET");
            } else {
                if (!e() && vVar.m().dl != null) {
                    httpURLConnection.addRequestProperty(HttpHeaders.CONTENT_TYPE, vVar.m().dl.toString());
                }
                httpURLConnection.setRequestMethod(vVar.dl());
                if (z(vVar.m())) {
                    z(httpURLConnection);
                }
                if ("POST".equalsIgnoreCase(vVar.dl())) {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    if (dl(vVar.m())) {
                        outputStream.write(vVar.m().f719a.getBytes());
                    } else if (z(vVar.m())) {
                        z(vVar.m().gc, outputStream, vVar.m().g(), vVar.m().z());
                    } else if (g(vVar.m())) {
                        outputStream.write(vVar.m().gc);
                    }
                    outputStream.flush();
                    outputStream.close();
                }
            }
            httpURLConnection.connect();
            long jCurrentTimeMillis = System.currentTimeMillis();
            kb kbVar2 = this.f727a;
            if (kbVar2 != null) {
                kbVar2.dl();
                this.f727a.z(jCurrentTimeMillis);
            }
            httpURLConnection.getResponseCode();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (this.gc.get()) {
                httpURLConnection.disconnect();
                return null;
            }
            m mVar = new m(httpURLConnection, vVar);
            mVar.f726a = jCurrentTimeMillis;
            mVar.dl = jCurrentTimeMillis2;
            kb kbVar3 = this.f727a;
            if (kbVar3 != null) {
                kbVar3.g(jCurrentTimeMillis2);
            }
            mVar.gc = this.f727a;
            return mVar;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private void z(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "multipart/form-data; boundary=" + this.dl);
    }

    private void z(byte[] bArr, OutputStream outputStream, String str, String str2) throws IOException {
        if (bArr == null || outputStream == null) {
            return;
        }
        PrintWriter printWriter = new PrintWriter((Writer) new OutputStreamWriter(outputStream, "UTF-8"), true);
        printWriter.append((CharSequence) ("--" + this.dl)).append((CharSequence) "\r\n");
        printWriter.append((CharSequence) ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"")).append((CharSequence) "\r\n");
        printWriter.append((CharSequence) "Content-Type: multipart/form-data").append((CharSequence) "\r\n");
        printWriter.append((CharSequence) ("Content-Length: " + bArr.length)).append((CharSequence) "\r\n");
        printWriter.append((CharSequence) "\r\n");
        printWriter.flush();
        outputStream.write(bArr);
        printWriter.append((CharSequence) "\r\n");
        printWriter.append((CharSequence) ("--" + this.dl + "--")).append((CharSequence) "\r\n");
        printWriter.flush();
        printWriter.close();
    }

    private boolean z(pf pfVar) {
        v vVar;
        return pfVar != null && (vVar = this.z) != null && "POST".equalsIgnoreCase(vVar.dl()) && pfVar.m == pf.z.FILE_TYPE && pfVar.gc != null && pfVar.gc.length > 0;
    }

    private boolean g(pf pfVar) {
        v vVar;
        return pfVar != null && (vVar = this.z) != null && "POST".equalsIgnoreCase(vVar.dl()) && pfVar.m == pf.z.BYTE_ARRAY_TYPE && pfVar.gc != null && pfVar.gc.length > 0;
    }

    private boolean dl(pf pfVar) {
        v vVar;
        return (pfVar == null || (vVar = this.z) == null || !"POST".equalsIgnoreCase(vVar.dl()) || pfVar.m != pf.z.STRING_TYPE || TextUtils.isEmpty(pfVar.f719a)) ? false : true;
    }

    private boolean e() {
        if (this.z.a() == null) {
            return false;
        }
        return this.z.a().containsKey(HttpHeaders.CONTENT_TYPE);
    }

    @Override // com.bytedance.sdk.component.g.z.g
    public void dl() {
        this.gc.set(true);
    }

    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.g.z.g clone() {
        return new z(this.z, this.g);
    }

    @Override // com.bytedance.sdk.component.g.z.g
    public boolean a() {
        return this.gc.get();
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.g.z.z.g.z$z, reason: collision with other inner class name */
    final class C0134z extends com.bytedance.sdk.component.g.z.g.gc {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final z f728a;
        private final com.bytedance.sdk.component.g.z.dl dl;

        C0134z(com.bytedance.sdk.component.g.z.dl dlVar, z zVar) {
            super("net-async-call", new Object[0]);
            this.dl = dlVar;
            this.f728a = zVar;
        }

        public void z() {
            z zVar = this.f728a;
            if (zVar == null || zVar.f727a == null) {
                return;
            }
            this.f728a.f727a.a();
        }

        @Override // com.bytedance.sdk.component.g.z.g.gc
        protected void g() {
            try {
                z zVar = this.f728a;
                if (zVar != null && zVar.f727a != null) {
                    this.f728a.f727a.z();
                }
                ls lsVarGc = z.this.gc();
                if (lsVarGc == null) {
                    this.dl.onFailure(z.this, new IOException("response is null"));
                } else {
                    this.dl.onResponse(z.this, lsVarGc);
                }
            } catch (Throwable th) {
                try {
                    if (th instanceof IOException) {
                        this.dl.onFailure(z.this, th);
                    } else {
                        this.dl.onFailure(z.this, new IOException(th));
                    }
                    try {
                        this.f728a.g.g(this);
                    } catch (Throwable th2) {
                        wp.z(th2);
                    }
                } finally {
                    try {
                        this.f728a.g.g(this);
                    } catch (Throwable th3) {
                        wp.z(th3);
                    }
                }
            }
        }
    }
}
