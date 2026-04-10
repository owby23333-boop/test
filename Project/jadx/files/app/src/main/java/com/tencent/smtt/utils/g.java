package com.tencent.smtt.utils;

import android.os.Build;
import com.umeng.message.common.inter.ITagManager;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

/* JADX INFO: loaded from: classes3.dex */
public class g {

    public interface a {
        void a(int i2);
    }

    public static String a(String str, Map<String, String> map, byte[] bArr, a aVar, boolean z2) throws Throwable {
        HttpURLConnection httpURLConnectionA;
        if (bArr == null || (httpURLConnectionA = a(str, map)) == null) {
            return null;
        }
        if (z2) {
            a(httpURLConnectionA, bArr);
        } else {
            b(httpURLConnectionA, bArr);
        }
        return a(httpURLConnectionA, aVar, false);
    }

    public static String a(String str, byte[] bArr, a aVar, boolean z2) {
        String str2;
        String str3;
        try {
            str3 = str + (z2 ? i.a().c() : h.a().b());
            try {
                bArr = z2 ? i.a().a(bArr) : h.a().a(bArr);
            } catch (Exception e2) {
                e2.printStackTrace();
                TbsLog.e("HttpUtils", "rsaKey exception #2: " + e2);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            str2 = "rsaKey exception #1: " + e3;
        }
        if (bArr == null) {
            str2 = "postData is null";
            TbsLog.e("HttpUtils", str2);
            return null;
        }
        HashMap map = new HashMap();
        map.put("Content-Type", "application/x-www-form-urlencoded");
        map.put("Content-Length", String.valueOf(bArr.length));
        HttpURLConnection httpURLConnectionA = a(str3, map);
        if (httpURLConnectionA == null) {
            return null;
        }
        b(httpURLConnectionA, bArr);
        return a(httpURLConnectionA, aVar, z2);
    }

    private static String a(HttpURLConnection httpURLConnection, a aVar, boolean z2) {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inflaterInputStream;
        InputStream inputStream = null;
        String str = null;
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (aVar != null) {
                aVar.a(responseCode);
            }
            if (responseCode == 200) {
                InputStream inputStream2 = httpURLConnection.getInputStream();
                String contentEncoding = httpURLConnection.getContentEncoding();
                inflaterInputStream = (contentEncoding == null || !contentEncoding.equalsIgnoreCase("gzip")) ? (contentEncoding == null || !contentEncoding.equalsIgnoreCase("deflate")) ? inputStream2 : new InflaterInputStream(inputStream2, new Inflater(true)) : new GZIPInputStream(inputStream2);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Throwable th) {
                    inputStream = inflaterInputStream;
                    th = th;
                    byteArrayOutputStream = null;
                }
                try {
                    byte[] bArr = new byte[128];
                    while (true) {
                        int i2 = inflaterInputStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i2);
                    }
                    str = z2 ? new String(byteArrayOutputStream.toByteArray(), com.anythink.expressad.foundation.g.a.bN) : new String(h.a().c(byteArrayOutputStream.toByteArray()));
                } catch (Throwable th2) {
                    inputStream = inflaterInputStream;
                    th = th2;
                    try {
                        th.printStackTrace();
                        TbsLog.e("HttpUtil", "httpPost exception: " + th);
                        return "[HttpError] " + th.getMessage();
                    } finally {
                        a(inputStream);
                        a(byteArrayOutputStream);
                    }
                }
            } else {
                inflaterInputStream = null;
                byteArrayOutputStream = null;
            }
            a(inflaterInputStream);
            a(byteArrayOutputStream);
            return str;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
    }

    private static HttpURLConnection a(String str, Map<String, String> map) {
        String str2;
        String str3;
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setConnectTimeout(20000);
                if (Build.VERSION.SDK_INT > 13) {
                    str2 = "Connection";
                    str3 = com.anythink.expressad.foundation.d.c.cf;
                } else {
                    str2 = "http.keepAlive";
                    str3 = ITagManager.STATUS_FALSE;
                }
                httpURLConnection2.setRequestProperty(str2, str3);
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                }
                return httpURLConnection2;
            } catch (Exception e2) {
                e = e2;
                httpURLConnection = httpURLConnection2;
                TbsLog.e("HttpUtil", "initHttpPostURLConnection exception: " + e);
                return httpURLConnection;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    private static void a(HttpURLConnection httpURLConnection, byte[] bArr) throws Throwable {
        GZIPOutputStream gZIPOutputStream;
        try {
            gZIPOutputStream = new GZIPOutputStream(new BufferedOutputStream(httpURLConnection.getOutputStream(), 204800));
        } catch (Exception e2) {
            e = e2;
            gZIPOutputStream = null;
        } catch (Throwable th) {
            th = th;
            gZIPOutputStream = null;
            a(null);
            a(gZIPOutputStream);
            throw th;
        }
        try {
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.flush();
            } catch (Throwable th2) {
                th = th2;
                a(null);
                a(gZIPOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
        }
        a(null);
        a(gZIPOutputStream);
    }

    private static void b(HttpURLConnection httpURLConnection, byte[] bArr) {
        OutputStream outputStream = null;
        try {
            try {
                outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.flush();
            } catch (Exception e2) {
                TbsLog.e("HttpUtil", "writePostData exception: " + e2);
            }
        } finally {
            a(outputStream);
        }
    }
}
