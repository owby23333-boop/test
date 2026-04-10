package com.xiaomi.accountsdk.request;

import android.util.Base64;
import com.google.common.net.HttpHeaders;
import com.xiaomi.accountsdk.utils.IOUtils;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

/* JADX INFO: loaded from: classes5.dex */
public class UploadFileRequest {
    private static final String CRLF = "\r\n";

    public static String execute(String str, InputStream inputStream, String str2, String str3) throws Throwable {
        HttpURLConnection httpURLConnection;
        String strEncodeToString;
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                byte[] bArr = new byte[16];
                new Random().nextBytes(bArr);
                strEncodeToString = Base64.encodeToString(bArr, 2);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty(HttpHeaders.CONNECTION, "Keep-Alive");
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + strEncodeToString);
                httpURLConnection.setRequestProperty(HttpHeaders.CACHE_CONTROL, "no-cache");
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
        try {
            dataOutputStream.writeBytes("--" + strEncodeToString + "\r\n");
            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str2 + "\"; filename=\"" + str3 + "\"\r\n");
            StringBuilder sb = new StringBuilder();
            sb.append("Content-Type: ");
            sb.append(getMIMEType(str3));
            sb.append("\r\n");
            dataOutputStream.writeBytes(sb.toString());
            dataOutputStream.writeBytes("\r\n");
            byte[] bArr2 = new byte[8192];
            while (true) {
                int i = inputStream.read(bArr2);
                if (i == -1) {
                    break;
                }
                dataOutputStream.write(bArr2, 0, i);
            }
            dataOutputStream.flush();
            dataOutputStream.writeBytes("\r\n");
            dataOutputStream.flush();
            dataOutputStream.writeBytes("--" + strEncodeToString + "--\r\n");
            dataOutputStream.flush();
            inputStream.close();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                throw new InvalidResponseException(responseCode, "failed to upload file");
            }
            StringBuilder sb2 = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()), 1024);
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb2.append(line);
                } catch (Throwable th3) {
                    IOUtils.closeQuietly(bufferedReader);
                    throw th3;
                }
            }
            IOUtils.closeQuietly(bufferedReader);
            String string = sb2.toString();
            try {
                dataOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            httpURLConnection.disconnect();
            return string;
        } catch (Throwable th4) {
            th = th4;
            dataOutputStream2 = dataOutputStream;
            if (dataOutputStream2 != null) {
                try {
                    dataOutputStream2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            if (httpURLConnection == null) {
                throw th;
            }
            httpURLConnection.disconnect();
            throw th;
        }
    }

    private static String getMIMEType(String str) {
        return (str.endsWith("png") || str.endsWith("PNG")) ? "image/png" : "image/jpg";
    }
}
