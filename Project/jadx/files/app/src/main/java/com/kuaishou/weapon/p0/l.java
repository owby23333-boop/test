package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes2.dex */
public class l {
    static TrustManager[] a = {new X509TrustManager() { // from class: com.kuaishou.weapon.p0.l.1
        @Override // javax.net.ssl.X509TrustManager
        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            try {
                l.b(x509CertificateArr);
            } catch (Throwable unused) {
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public final X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }};
    static SSLSocketFactory b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f16739c = "gzip";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f16740d = 1024;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile l f16741f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Context f16742g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f16743e = false;

    private l(Context context) {
        f16742g = context;
    }

    public static l a(Context context) {
        if (f16741f == null) {
            synchronized (l.class) {
                if (f16741f == null) {
                    f16741f = new l(context);
                }
            }
        }
        return f16741f;
    }

    private InputStream a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null && httpURLConnection != null) {
            try {
                if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                    this.f16743e = true;
                } else {
                    this.f16743e = false;
                }
                return httpURLConnection.getInputStream();
            } catch (IOException unused) {
            }
        }
        return null;
    }

    private static void a(String str) {
        try {
            new h(f16742g).c(de.f16690k, str, true);
        } catch (Exception unused) {
        }
    }

    private synchronized void a(HttpsURLConnection httpsURLConnection) {
        if (httpsURLConnection != null) {
            try {
                if (b == null) {
                    SSLContext sSLContext = SSLContext.getInstance("TLS");
                    sSLContext.init(null, a, new SecureRandom());
                    b = sSLContext.getSocketFactory();
                }
                if (b != null) {
                    httpsURLConnection.setSSLSocketFactory(b);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private boolean a(InputStream inputStream, File file) {
        BufferedOutputStream bufferedOutputStream;
        if (this.f16743e) {
            try {
                inputStream = new GZIPInputStream(inputStream);
            } catch (IOException unused) {
            }
        }
        if (inputStream == null) {
            return false;
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        } catch (Throwable unused2) {
            bufferedOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    try {
                        bufferedOutputStream.close();
                        return true;
                    } catch (IOException unused3) {
                        return true;
                    }
                }
                bufferedOutputStream.write(bArr, 0, i2);
                bufferedOutputStream.flush();
            }
        } catch (Throwable unused4) {
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException unused5) {
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(X509Certificate[] x509CertificateArr) {
        if (x509CertificateArr != null) {
            try {
                if (x509CertificateArr.length == 0) {
                    return;
                }
                String name = x509CertificateArr[0].getIssuerX500Principal().getName();
                if (Pattern.compile(".*(GeoTrust|VeriSign|Symantec|GlobalSign|Entrust|Thawte|DigiCert).*", 2).matcher(name).matches()) {
                    return;
                }
                a(name);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00dd A[Catch: Exception -> 0x00e0, TRY_LEAVE, TryCatch #0 {Exception -> 0x00e0, blocks: (B:46:0x00d8, B:48:0x00dd), top: B:64:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(com.kuaishou.weapon.p0.m r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.l.a(com.kuaishou.weapon.p0.m):java.lang.String");
    }

    public String a(Map<String, String> map) {
        String str = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str = str + DispatchConstants.SIGN_SPLIT_SYMBOL + entry.getKey() + "=" + entry.getValue();
        }
        return str.substring(1);
    }

    public HttpURLConnection a(String str, String str2) {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(str);
            if ("https".equals(url.getProtocol())) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                a(httpsURLConnection);
                httpURLConnection = httpsURLConnection;
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            try {
                httpURLConnection.setRequestMethod(str2);
                httpURLConnection.setAllowUserInteraction(true);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setChunkedStreamingMode(0);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                if (!str2.equalsIgnoreCase("post")) {
                    return httpURLConnection;
                }
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                return httpURLConnection;
            } catch (Exception unused) {
                return httpURLConnection;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public void a(m mVar, j jVar) throws Throwable {
        a(mVar, jVar, "GET");
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00f0 A[Catch: Exception -> 0x00f8, TryCatch #8 {Exception -> 0x00f8, blocks: (B:54:0x00eb, B:56:0x00f0, B:58:0x00f5), top: B:79:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f5 A[Catch: Exception -> 0x00f8, TRY_LEAVE, TryCatch #8 {Exception -> 0x00f8, blocks: (B:54:0x00eb, B:56:0x00f0, B:58:0x00f5), top: B:79:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.kuaishou.weapon.p0.m r10, com.kuaishou.weapon.p0.j r11, java.lang.String r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.l.a(com.kuaishou.weapon.p0.m, com.kuaishou.weapon.p0.j, java.lang.String):void");
    }

    public boolean a(String str, File file) {
        HttpURLConnection httpURLConnectionA;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        InputStream inputStreamA = null;
        try {
            httpURLConnectionA = a(str, "GET");
            try {
                inputStreamA = a(httpURLConnectionA);
                boolean zA = a(inputStreamA, file);
                if (inputStreamA != null) {
                    try {
                        inputStreamA.close();
                    } catch (Throwable unused) {
                        return false;
                    }
                }
                if (httpURLConnectionA != null) {
                    httpURLConnectionA.disconnect();
                }
                return zA;
            } catch (Throwable unused2) {
                if (inputStreamA != null) {
                    try {
                        inputStreamA.close();
                    } catch (Throwable unused3) {
                        return false;
                    }
                }
                if (httpURLConnectionA != null) {
                    httpURLConnectionA.disconnect();
                }
                return false;
            }
        } catch (Throwable unused4) {
            httpURLConnectionA = null;
        }
    }

    public void b(m mVar, j jVar) throws Throwable {
        a(mVar, jVar, "POST");
    }
}
