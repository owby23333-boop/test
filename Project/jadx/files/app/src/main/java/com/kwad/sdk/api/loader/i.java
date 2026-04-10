package com.kwad.sdk.api.loader;

import com.kwad.sdk.api.core.TLSConnectionUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public final class i {
    private static HttpURLConnection aR(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        TLSConnectionUtils.wrapHttpURLConnection(httpURLConnection);
        httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(120000);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Connection", "keep-alive");
        httpURLConnection.setRequestProperty("Charset", "UTF-8");
        return httpURLConnection;
    }

    public static void b(String str, File file) throws Throwable {
        HttpURLConnection httpURLConnection;
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            if (file.exists()) {
                h.e(file);
            }
            fileOutputStream = new FileOutputStream(file, false);
            try {
                HttpURLConnection httpURLConnectionAR = aR(str);
                try {
                    bufferedInputStream = new BufferedInputStream(httpURLConnectionAR.getInputStream());
                } catch (Throwable th) {
                    httpURLConnection = httpURLConnectionAR;
                    th = th;
                }
                try {
                    byte[] bArr = new byte[10240];
                    while (true) {
                        int i2 = bufferedInputStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, i2);
                        }
                    }
                    closeQuietly(fileOutputStream);
                    closeQuietly(bufferedInputStream);
                    if (httpURLConnectionAR != null) {
                        httpURLConnectionAR.disconnect();
                    }
                } catch (Throwable th2) {
                    httpURLConnection = httpURLConnectionAR;
                    th = th2;
                    bufferedInputStream2 = bufferedInputStream;
                    closeQuietly(fileOutputStream);
                    closeQuietly(bufferedInputStream2);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = null;
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            fileOutputStream = null;
        }
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
