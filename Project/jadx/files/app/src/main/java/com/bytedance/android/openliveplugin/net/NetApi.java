package com.bytedance.android.openliveplugin.net;

import com.umeng.message.utils.HttpRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.Arrays;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NetApi {
    private static final int BUFFER_SIZE = 1024;
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final String PROTOCOL_CHARSET = "utf-8";
    private static final int TIMEOUT = 5000;

    private static final class Holder {
        private static final NetApi INSTANCE = new NetApi();

        private Holder() {
        }
    }

    private byte[] getBody(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.toString().getBytes("utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static NetApi getInstance() {
        return Holder.INSTANCE;
    }

    private static byte[] inputStreamToByteArray(InputStream inputStream, int i2) throws IOException {
        if (inputStream == null) {
            return null;
        }
        if (i2 < 1) {
            i2 = 1;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[i2];
        while (true) {
            int i3 = inputStream.read(bArr);
            if (i3 == -1) {
                byteArrayOutputStream.close();
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i3);
        }
    }

    private static String parseCharset(String str, String str2) {
        if (str != null) {
            String[] strArrSplit = str.split(";", 0);
            for (int i2 = 1; i2 < strArrSplit.length; i2++) {
                String[] strArrSplit2 = strArrSplit[i2].trim().split("=", 0);
                if (strArrSplit2.length == 2 && strArrSplit2[0].equals(HttpRequest.PARAM_CHARSET)) {
                    return strArrSplit2[1];
                }
            }
        }
        return str2;
    }

    private SSLSocketFactory systemDefaultSslSocketFactory(X509TrustManager x509TrustManager) throws IOException {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e2) {
            throw new IOException("No System TLS", e2);
        }
    }

    private X509TrustManager systemDefaultTrustManager() throws IOException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e2) {
            throw new IOException("No System TLS", e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x007c A[EXC_TOP_SPLITTER, PHI: r5
  0x007c: PHI (r5v6 javax.net.ssl.HttpsURLConnection) = (r5v5 javax.net.ssl.HttpsURLConnection), (r5v10 javax.net.ssl.HttpsURLConnection) binds: [B:30:0x008a, B:20:0x007a] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String request(boolean r4, java.lang.String r5, byte[] r6) throws java.lang.Throwable {
        /*
            r3 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            javax.net.ssl.X509TrustManager r5 = r3.systemDefaultTrustManager()     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            javax.net.ssl.SSLSocketFactory r5 = r3.systemDefaultSslSocketFactory(r5)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(r5)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            java.net.URLConnection r5 = r1.openConnection()     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            javax.net.ssl.HttpsURLConnection r5 = (javax.net.ssl.HttpsURLConnection) r5     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            r1 = 5000(0x1388, float:7.006E-42)
            r5.setConnectTimeout(r1)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8e
            com.bytedance.android.openliveplugin.net.DefaultHostnameVerifier r1 = com.bytedance.android.openliveplugin.net.DefaultHostnameVerifier.INSTANCE     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8e
            r5.setHostnameVerifier(r1)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8e
            if (r4 == 0) goto L48
            if (r6 == 0) goto L48
            int r4 = r6.length     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8e
            if (r4 == 0) goto L48
            r4 = 1
            r5.setDoOutput(r4)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8e
            int r4 = r6.length     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8e
            r5.setFixedLengthStreamingMode(r4)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8e
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8e
            java.io.OutputStream r1 = r5.getOutputStream()     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8e
            r4.<init>(r1)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8e
            r4.write(r6)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8e
            r4.flush()     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8e
            r4.close()     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8e
            java.lang.String r4 = "POST"
            r5.setRequestMethod(r4)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8e
            goto L4d
        L48:
            java.lang.String r4 = "GET"
            r5.setRequestMethod(r4)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8e
        L4d:
            int r4 = r5.getResponseCode()     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8e
            r6 = 200(0xc8, float:2.8E-43)
            if (r4 < r6) goto L7a
            r6 = 300(0x12c, float:4.2E-43)
            if (r4 >= r6) goto L7a
            java.lang.String r4 = "Content-Type"
            java.lang.String r4 = r5.getHeaderField(r4)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8e
            java.lang.String r6 = "utf-8"
            java.lang.String r4 = parseCharset(r4, r6)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8e
            java.lang.String r6 = new java.lang.String     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8e
            java.io.InputStream r1 = r5.getInputStream()     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8e
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r1 = inputStreamToByteArray(r1, r2)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8e
            r6.<init>(r1, r4)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8e
            if (r5 == 0) goto L79
            r5.disconnect()     // Catch: java.lang.Exception -> L79
        L79:
            return r6
        L7a:
            if (r5 == 0) goto L8d
        L7c:
            r5.disconnect()     // Catch: java.lang.Exception -> L8d
            goto L8d
        L80:
            r4 = move-exception
            goto L87
        L82:
            r4 = move-exception
            r5 = r0
            goto L8f
        L85:
            r4 = move-exception
            r5 = r0
        L87:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L8e
            if (r5 == 0) goto L8d
            goto L7c
        L8d:
            return r0
        L8e:
            r4 = move-exception
        L8f:
            if (r5 == 0) goto L94
            r5.disconnect()     // Catch: java.lang.Exception -> L94
        L94:
            goto L96
        L95:
            throw r4
        L96:
            goto L95
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.android.openliveplugin.net.NetApi.request(boolean, java.lang.String, byte[]):java.lang.String");
    }

    private NetApi() {
    }
}
