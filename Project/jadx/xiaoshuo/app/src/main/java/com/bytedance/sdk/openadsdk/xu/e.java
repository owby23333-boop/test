package com.bytedance.sdk.openadsdk.xu;

import com.bytedance.sdk.component.utils.wu;
import com.bytedance.sdk.openadsdk.s.tg;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import net.oauth.http.HttpResponseMessage;

/* JADX INFO: loaded from: classes10.dex */
public class e {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.xu.e$e, reason: collision with other inner class name */
    public interface InterfaceC0179e {
        void e(int i, String str);

        void e(String str);
    }

    private static SSLSocketFactory e(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (Throwable th) {
            throw new RuntimeException("No System TLS", th);
        }
    }

    private static X509TrustManager e() {
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
            wu.d("Https", th);
            return null;
        }
    }

    private static StringBuilder e(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(str3);
        sb.append(HttpResponseMessage.EOL);
        sb.append("Content-Disposition: form-data; name=\"");
        sb.append(str);
        sb.append("\"");
        sb.append(HttpResponseMessage.EOL);
        sb.append("Content-Length: ");
        sb.append(str2.length());
        sb.append(HttpResponseMessage.EOL);
        sb.append(HttpResponseMessage.EOL);
        sb.append(str2);
        sb.append(HttpResponseMessage.EOL);
        return sb;
    }

    public void e(String str, File file, String str2, InterfaceC0179e interfaceC0179e) {
        DataOutputStream dataOutputStream;
        String string;
        HttpsURLConnection httpsURLConnection = null;
        try {
            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(str).openConnection();
            try {
                httpsURLConnection2.setRequestMethod("POST");
                httpsURLConnection2.setReadTimeout(20000);
                httpsURLConnection2.setConnectTimeout(10000);
                httpsURLConnection2.setDoOutput(true);
                httpsURLConnection2.setDoInput(true);
                httpsURLConnection2.setUseCaches(false);
                string = UUID.randomUUID().toString();
                httpsURLConnection2.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + string);
                httpsURLConnection2.setSSLSocketFactory(e(e()));
                httpsURLConnection2.connect();
                dataOutputStream = new DataOutputStream(httpsURLConnection2.getOutputStream());
            } catch (Throwable th) {
                th = th;
                dataOutputStream = null;
            }
            try {
                dataOutputStream.writeBytes("--" + string + HttpResponseMessage.EOL + "Content-Disposition: form-data; name=\"logFile\"; filename=\"" + file.getName() + "\"" + HttpResponseMessage.EOL + "Content-Type: multipart/form-data" + HttpResponseMessage.EOL + "Content-Length: " + file.length() + HttpResponseMessage.EOL + HttpResponseMessage.EOL);
                dataOutputStream.flush();
                tg.e(dataOutputStream, file);
                dataOutputStream.writeBytes(HttpResponseMessage.EOL);
                dataOutputStream.writeBytes(e("deviceInfo", str2, string).toString());
                StringBuilder sb = new StringBuilder();
                sb.append("--");
                sb.append(string);
                sb.append("--");
                sb.append(HttpResponseMessage.EOL);
                dataOutputStream.writeBytes(sb.toString());
                dataOutputStream.flush();
                dataOutputStream.close();
                e(httpsURLConnection2, interfaceC0179e);
                httpsURLConnection2.disconnect();
            } catch (Throwable th2) {
                th = th2;
                httpsURLConnection = httpsURLConnection2;
                try {
                    wu.d("Https", th);
                    if (interfaceC0179e != null) {
                        interfaceC0179e.e(-1, th.getMessage());
                    }
                } finally {
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    tg.e(dataOutputStream);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
        }
    }

    private void e(HttpURLConnection httpURLConnection, InterfaceC0179e interfaceC0179e) throws IOException {
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
            if (interfaceC0179e != null) {
                interfaceC0179e.e(sb.toString());
            }
        } else if (interfaceC0179e != null) {
            interfaceC0179e.e(responseCode, sb.toString());
        }
    }
}
