package com.youxiao.key;

import com.anythink.expressad.foundation.g.a;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes6.dex */
public class HttpClient {
    public int code;
    public HttpURLConnection conn;
    public String errorMsg;
    public String responseBody;

    public void sendPost(String str, String str2) {
        HttpURLConnection httpURLConnection;
        try {
            if (str.startsWith("https://")) {
                this.conn = (HttpsURLConnection) new URL(str).openConnection();
            } else {
                this.conn = (HttpURLConnection) new URL(str).openConnection();
            }
            this.conn.setRequestMethod("POST");
            this.conn.setConnectTimeout(BaseConstants.Time.MINUTE);
            this.conn.setReadTimeout(BaseConstants.Time.MINUTE);
            this.conn.setUseCaches(false);
            this.conn.setRequestProperty("Content-Type", "application/json");
            this.conn.setDoOutput(true);
            this.conn.getOutputStream().write(str2.getBytes());
            this.code = this.conn.getResponseCode();
            if (this.conn.getResponseCode() == 200) {
                this.responseBody = readResponseData(this.conn.getInputStream());
            } else {
                this.errorMsg = "http code:" + this.conn.getResponseCode() + ",msg:" + this.conn.getResponseMessage();
            }
            httpURLConnection = this.conn;
            if (httpURLConnection == null) {
                return;
            }
        } catch (Exception unused) {
            httpURLConnection = this.conn;
            if (httpURLConnection == null) {
                return;
            }
        } catch (Throwable th) {
            HttpURLConnection httpURLConnection2 = this.conn;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
        httpURLConnection.disconnect();
    }

    public void sendGet(String str) {
        HttpURLConnection httpURLConnection;
        try {
            if (str.startsWith("https://")) {
                this.conn = (HttpsURLConnection) new URL(str).openConnection();
            } else {
                this.conn = (HttpURLConnection) new URL(str).openConnection();
            }
            this.conn.setRequestMethod("GET");
            this.conn.setConnectTimeout(BaseConstants.Time.MINUTE);
            this.conn.setReadTimeout(BaseConstants.Time.MINUTE);
            this.conn.setUseCaches(false);
            this.conn.setRequestProperty("Content-Type", "application/json");
            this.conn.setDoOutput(false);
            this.code = this.conn.getResponseCode();
            if (this.conn.getResponseCode() == 200) {
                this.responseBody = readResponseData(this.conn.getInputStream());
            } else {
                this.errorMsg = "http code:" + this.conn.getResponseCode() + ",msg:" + this.conn.getResponseMessage();
            }
            httpURLConnection = this.conn;
            if (httpURLConnection == null) {
                return;
            }
        } catch (Exception unused) {
            httpURLConnection = this.conn;
            if (httpURLConnection == null) {
                return;
            }
        } catch (Throwable th) {
            HttpURLConnection httpURLConnection2 = this.conn;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
        httpURLConnection.disconnect();
    }

    private String readResponseData(InputStream inputStream) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 > 0) {
                byteArrayOutputStream.write(bArr, 0, i2);
            } else {
                return byteArrayOutputStream.toString(a.bN);
            }
        }
    }
}
