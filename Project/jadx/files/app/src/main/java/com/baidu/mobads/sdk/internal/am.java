package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.umeng.message.common.inter.ITagManager;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class am {
    public static final String a = "OAdURLConnection";
    public static final String b = "POST";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f12846c = "GET";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f12847d = "application/json";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f12848e = "text/plain";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HttpURLConnection f12849f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private bq f12850g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private b f12851h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private c f12852i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f12853j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f12854k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f12855l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f12856m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f12857n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f12858o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f12859p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Uri.Builder f12860q;

    class a extends h {
        a() {
        }

        @Override // com.baidu.mobads.sdk.internal.h
        public Object i() throws Throwable {
            am.this.e();
            am.this.f();
            return null;
        }
    }

    public interface b {
        void a(String str, int i2);

        void a(String str, String str2);
    }

    public interface c {
        void a(InputStream inputStream, String str);

        void a(String str, int i2);
    }

    public am(String str) {
        this(str, "GET");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() throws Throwable {
        if (TextUtils.isEmpty(this.f12853j)) {
            return;
        }
        try {
            this.f12849f = cn.a().a(new URL(this.f12853j));
            this.f12849f.setConnectTimeout(this.f12857n);
            if (Integer.parseInt(bj.a((Context) null).b()) < 8) {
                System.setProperty("http.keepAlive", ITagManager.STATUS_FALSE);
            }
            this.f12849f.setRequestMethod(this.f12854k);
            this.f12849f.setUseCaches(this.f12859p);
            if (!TextUtils.isEmpty(this.f12855l)) {
                this.f12849f.setRequestProperty("User-Agent", this.f12855l);
            }
            this.f12849f.setRequestProperty("Content-type", this.f12856m);
            this.f12849f.setRequestProperty("Connection", "keep-alive");
            this.f12849f.setRequestProperty("Cache-Control", "no-cache");
            if (this.f12854k.equals("POST")) {
                this.f12849f.setDoInput(true);
                this.f12849f.setDoOutput(true);
                if (this.f12860q != null) {
                    a(this.f12860q.build().getEncodedQuery(), this.f12849f);
                }
            }
        } catch (Exception e2) {
            b bVar = this.f12851h;
            if (bVar != null) {
                bVar.a("Net Create RuntimeError: " + e2.toString(), 0);
            }
            c cVar = this.f12852i;
            if (cVar != null) {
                cVar.a("Net Create RuntimeError: " + e2.toString(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        HttpURLConnection httpURLConnection;
        try {
            try {
                this.f12849f.connect();
                this.f12850g.a(a, this.f12849f.getRequestMethod() + " connect code :" + this.f12849f.getResponseCode());
                int responseCode = this.f12849f.getResponseCode();
                if (responseCode == 302 || responseCode == 301) {
                    this.f12849f.setInstanceFollowRedirects(false);
                    this.f12849f = a(this.f12849f);
                    responseCode = this.f12849f.getResponseCode();
                }
                if (responseCode / 100 != 2) {
                    if (this.f12851h != null) {
                        this.f12851h.a(this.f12849f.getResponseMessage(), responseCode);
                    }
                    if (this.f12852i != null) {
                        this.f12852i.a(this.f12849f.getResponseMessage(), responseCode);
                    }
                } else {
                    String strF = cn.a().f(this.f12853j);
                    if (this.f12851h != null) {
                        this.f12851h.a(c(), strF);
                    }
                    if (this.f12852i != null) {
                        this.f12852i.a(this.f12849f.getInputStream(), strF);
                    }
                }
                httpURLConnection = this.f12849f;
                if (httpURLConnection == null) {
                    return;
                }
            } catch (Exception e2) {
                if (this.f12851h != null) {
                    this.f12851h.a("Net Connect RuntimeError: " + e2.toString(), 0);
                }
                if (this.f12852i != null) {
                    this.f12852i.a("Net Connect RuntimeError: " + e2.toString(), 0);
                }
                httpURLConnection = this.f12849f;
                if (httpURLConnection == null) {
                    return;
                }
            }
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            HttpURLConnection httpURLConnection2 = this.f12849f;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    public String c() throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = this.f12849f.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[128];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toString();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public void d() {
        HttpURLConnection httpURLConnection = this.f12849f;
        if (httpURLConnection != null) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e2) {
                av.h(a).f(e2.toString());
            }
        }
    }

    public am(String str, String str2) {
        this.f12850g = bq.a();
        this.f12851h = null;
        this.f12852i = null;
        this.f12856m = f12848e;
        this.f12857n = 10000;
        this.f12858o = 10000;
        this.f12859p = false;
        this.f12860q = null;
        this.f12853j = str;
        this.f12854k = str2;
    }

    public String a() throws Throwable {
        e();
        HttpURLConnection httpURLConnection = this.f12849f;
        if (httpURLConnection != null) {
            try {
                if (httpURLConnection.getResponseCode() / 100 != 2) {
                    HttpURLConnection httpURLConnection2 = this.f12849f;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return null;
                }
                String strC = c();
                HttpURLConnection httpURLConnection3 = this.f12849f;
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
                return strC;
            } catch (Throwable unused) {
                HttpURLConnection httpURLConnection4 = this.f12849f;
                if (httpURLConnection4 != null) {
                    httpURLConnection4.disconnect();
                }
            }
        }
        return null;
    }

    public void b() {
        try {
            ba.a().a((h) new a());
        } catch (Exception unused) {
        }
    }

    public void b(int i2) {
        this.f12858o = i2;
    }

    private void a(String str, HttpURLConnection httpURLConnection) throws Throwable {
        OutputStream outputStream;
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2 = null;
        try {
            outputStream = httpURLConnection.getOutputStream();
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
        }
        try {
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter2 = bufferedWriter;
            if (bufferedWriter2 != null) {
                bufferedWriter2.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            throw th;
        }
    }

    public void a(Map<String, String> map) {
        if (this.f12849f != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f12849f.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    private HttpURLConnection a(HttpURLConnection httpURLConnection) {
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(httpURLConnection.getHeaderField("Location")).openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(httpURLConnection2.getConnectTimeout());
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setRequestProperty("Range", "bytes=0-");
                    httpURLConnection = httpURLConnection2;
                } catch (Exception unused) {
                    return httpURLConnection2;
                }
            } catch (Exception unused2) {
                return httpURLConnection;
            }
        }
    }

    public void a(b bVar) {
        this.f12851h = bVar;
    }

    public void a(c cVar) {
        this.f12852i = cVar;
    }

    public void a(int i2) {
        this.f12857n = i2;
    }

    public void a(Uri.Builder builder) {
        this.f12860q = builder;
    }

    public void a(String str) {
        this.f12856m = str;
    }
}
