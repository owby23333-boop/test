package com.bytedance.sdk.openadsdk.i;

import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.hh.a;
import com.google.common.net.HttpHeaders;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.i.z$z, reason: collision with other inner class name */
    public interface InterfaceC0219z {
        void z(int i, String str);

        void z(String str);
    }

    private static SSLSocketFactory z(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (Throwable th) {
            throw new RuntimeException("No System TLS", th);
        }
    }

    private static X509TrustManager z() {
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
        } catch (Throwable th) {
            wp.g("Https", th);
            return null;
        }
    }

    public void z(String str, File file, Map<String, String> map, InterfaceC0219z interfaceC0219z, Map<String, String> map2) {
        DataOutputStream dataOutputStream;
        HttpsURLConnection httpsURLConnection;
        String string;
        HttpsURLConnection httpsURLConnection2 = null;
        try {
            httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            try {
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setReadTimeout(20000);
                httpsURLConnection.setConnectTimeout(10000);
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setUseCaches(false);
                string = UUID.randomUUID().toString();
                if (map2 != null) {
                    for (Map.Entry<String, String> entry : map2.entrySet()) {
                        httpsURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpsURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "multipart/form-data;boundary=" + string);
                httpsURLConnection.setSSLSocketFactory(z(z()));
                httpsURLConnection.connect();
                dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
            } catch (Throwable th) {
                th = th;
                dataOutputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            dataOutputStream = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("--").append(string).append("\r\nContent-Disposition: form-data; name=\"logFile\"; filename=\"").append(file.getName()).append("\"\r\nContent-Type: multipart/form-data\r\nContent-Length: ").append(file.length()).append("\r\n\r\n");
            dataOutputStream.writeBytes(sb.toString());
            dataOutputStream.flush();
            a.z(dataOutputStream, file);
            dataOutputStream.writeBytes("\r\n");
            if (map != null) {
                for (Map.Entry<String, String> entry2 : map.entrySet()) {
                    String key = entry2.getKey();
                    String value = entry2.getValue();
                    if (value != null && key != null) {
                        z(dataOutputStream, key, value, string);
                    }
                }
            }
            dataOutputStream.writeBytes("--" + string + "--\r\n");
            dataOutputStream.flush();
            dataOutputStream.close();
            z(httpsURLConnection, interfaceC0219z);
            if (httpsURLConnection != null) {
                httpsURLConnection.disconnect();
            }
            a.z(dataOutputStream);
        } catch (Throwable th3) {
            th = th3;
            httpsURLConnection2 = httpsURLConnection;
            try {
                wp.g("Https", th);
                if (interfaceC0219z != null) {
                    interfaceC0219z.z(-1, th.getMessage());
                }
            } finally {
                if (httpsURLConnection2 != null) {
                    httpsURLConnection2.disconnect();
                }
                a.z(dataOutputStream);
            }
        }
    }

    private void z(DataOutputStream dataOutputStream, String str, String str2, String str3) throws IOException {
        dataOutputStream.writeBytes("\r\n--" + str3 + "\r\nContent-Disposition: form-data; name=\"" + str + "\";\r\nContent-Length: " + str2.length() + "\r\n\r\n" + str2 + "\r\n");
    }

    private void z(HttpURLConnection httpURLConnection, InterfaceC0219z interfaceC0219z) throws IOException {
        int responseCode = httpURLConnection.getResponseCode();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            } else {
                sb.append(line);
            }
        }
        if (responseCode == 200) {
            if (interfaceC0219z != null) {
                interfaceC0219z.z(sb.toString());
            }
        } else if (interfaceC0219z != null) {
            interfaceC0219z.z(responseCode, sb.toString());
        }
    }
}
