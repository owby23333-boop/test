package com.bytedance.sdk.openadsdk.api.plugin.g;

import com.bykv.vk.openvk.api.proto.EventListener;
import com.bytedance.sdk.openadsdk.api.m;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.Arrays;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private dl() {
    }

    private static final class z {
        private static final dl z = new dl();
    }

    public static dl z() {
        return z.z;
    }

    public void z(String str, String str2, String str3, EventListener eventListener) throws Throwable {
        a aVar;
        HttpsURLConnection httpsURLConnection = null;
        try {
            try {
                URL url = new URL(str);
                HttpsURLConnection.setDefaultSSLSocketFactory(z(g()));
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                try {
                    httpsURLConnection2.setConnectTimeout(5000);
                    httpsURLConnection2.setHostnameVerifier(com.bytedance.sdk.openadsdk.api.plugin.g.z.z);
                    httpsURLConnection2.setRequestMethod("GET");
                    if (httpsURLConnection2.getResponseCode() == 200 && z(httpsURLConnection2.getInputStream(), str2, str3, eventListener)) {
                        eventListener.onEvent(0, new a(str2 + "/" + str3));
                    }
                    if (httpsURLConnection2 != null) {
                        try {
                            httpsURLConnection2.disconnect();
                        } catch (Exception e) {
                            aVar = new a(e.getMessage());
                            eventListener.onEvent(2, aVar);
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    httpsURLConnection = httpsURLConnection2;
                    m.z(e);
                    eventListener.onEvent(1, new a(e.getMessage()));
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.disconnect();
                        } catch (Exception e3) {
                            aVar = new a(e3.getMessage());
                            eventListener.onEvent(2, aVar);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    httpsURLConnection = httpsURLConnection2;
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.disconnect();
                        } catch (Exception e4) {
                            eventListener.onEvent(2, new a(e4.getMessage()));
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public boolean z(InputStream inputStream, String str, String str2, EventListener eventListener) throws Throwable {
        if (inputStream == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                if (!file.exists() && !file.mkdirs()) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(file, str2));
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, i);
                    }
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    inputStream.close();
                    if (inputStream == null) {
                        return true;
                    }
                    try {
                        inputStream.close();
                        return true;
                    } catch (Exception unused2) {
                        return true;
                    }
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    if (inputStream == null) {
                        throw th;
                    }
                    try {
                        inputStream.close();
                        throw th;
                    } catch (Exception unused4) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        eventListener.onEvent(3, new a(e.getMessage()));
        m.g("NetApi", "save error: ", e);
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception unused5) {
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused6) {
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x007c A[EXC_TOP_SPLITTER, PHI: r5
  0x007c: PHI (r5v4 javax.net.ssl.HttpsURLConnection) = (r5v3 javax.net.ssl.HttpsURLConnection), (r5v8 javax.net.ssl.HttpsURLConnection) binds: [B:30:0x0089, B:20:0x007a] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String z(boolean r4, java.lang.String r5, byte[] r6) throws java.lang.Throwable {
        /*
            r3 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            javax.net.ssl.X509TrustManager r5 = r3.g()     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            javax.net.ssl.SSLSocketFactory r5 = r3.z(r5)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(r5)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            java.net.URLConnection r5 = r1.openConnection()     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            javax.net.ssl.HttpsURLConnection r5 = (javax.net.ssl.HttpsURLConnection) r5     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            r1 = 5000(0x1388, float:7.006E-42)
            r5.setConnectTimeout(r1)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            com.bytedance.sdk.openadsdk.api.plugin.g.z r1 = com.bytedance.sdk.openadsdk.api.plugin.g.z.z     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            r5.setHostnameVerifier(r1)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            if (r4 == 0) goto L48
            if (r6 == 0) goto L48
            int r4 = r6.length     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            if (r4 == 0) goto L48
            r4 = 1
            r5.setDoOutput(r4)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            int r4 = r6.length     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            r5.setFixedLengthStreamingMode(r4)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            java.io.OutputStream r1 = r5.getOutputStream()     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            r4.<init>(r1)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            r4.write(r6)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            r4.flush()     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            r4.close()     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            java.lang.String r4 = "POST"
            r5.setRequestMethod(r4)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            goto L4d
        L48:
            java.lang.String r4 = "GET"
            r5.setRequestMethod(r4)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
        L4d:
            int r4 = r5.getResponseCode()     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            r6 = 200(0xc8, float:2.8E-43)
            if (r4 < r6) goto L7a
            r6 = 300(0x12c, float:4.2E-43)
            if (r4 >= r6) goto L7a
            java.lang.String r4 = "Content-Type"
            java.lang.String r4 = r5.getHeaderField(r4)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            java.lang.String r6 = "utf-8"
            java.lang.String r4 = z(r4, r6)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            java.lang.String r6 = new java.lang.String     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            java.io.InputStream r1 = r5.getInputStream()     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r1 = z(r1, r2)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            r6.<init>(r1, r4)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            if (r5 == 0) goto L79
            r5.disconnect()     // Catch: java.lang.Exception -> L79
        L79:
            return r6
        L7a:
            if (r5 == 0) goto L8c
        L7c:
            r5.disconnect()     // Catch: java.lang.Exception -> L8c
            goto L8c
        L80:
            r4 = move-exception
            goto L86
        L82:
            r4 = move-exception
            goto L8f
        L84:
            r4 = move-exception
            r5 = r0
        L86:
            com.bytedance.sdk.openadsdk.api.m.z(r4)     // Catch: java.lang.Throwable -> L8d
            if (r5 == 0) goto L8c
            goto L7c
        L8c:
            return r0
        L8d:
            r4 = move-exception
            r0 = r5
        L8f:
            if (r0 == 0) goto L94
            r0.disconnect()     // Catch: java.lang.Exception -> L94
        L94:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.api.plugin.g.dl.z(boolean, java.lang.String, byte[]):java.lang.String");
    }

    private static byte[] z(InputStream inputStream, int i) throws IOException {
        if (inputStream == null) {
            return null;
        }
        if (i <= 0) {
            i = 1;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[i];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 != -1) {
                byteArrayOutputStream.write(bArr, 0, i2);
            } else {
                byteArrayOutputStream.close();
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    private static String z(String str, String str2) {
        if (str != null) {
            String[] strArrSplit = str.split(";", 0);
            for (int i = 1; i < strArrSplit.length; i++) {
                String[] strArrSplit2 = strArrSplit[i].trim().split("=", 0);
                if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                    return strArrSplit2[1];
                }
            }
        }
        return str2;
    }

    private SSLSocketFactory z(X509TrustManager x509TrustManager) throws IOException {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw new IOException("No System TLS", e);
        }
    }

    private X509TrustManager g() throws IOException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e) {
            throw new IOException("No System TLS", e);
        }
    }
}
