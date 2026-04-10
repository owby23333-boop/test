package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes3.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1861a = "gzip";
    private static final int b = 1024;
    private static volatile l d;
    private static Context e;
    private boolean c = false;

    public static l a(Context context) {
        if (d == null) {
            synchronized (l.class) {
                if (d == null) {
                    d = new l(context);
                }
            }
        }
        return d;
    }

    private l(Context context) {
        e = context;
    }

    public void a(m mVar, j jVar) throws Throwable {
        a(mVar, jVar, "GET");
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
                httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
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

    private synchronized void a(HttpsURLConnection httpsURLConnection) {
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00f8 A[Catch: Exception -> 0x0100, TryCatch #0 {Exception -> 0x0100, blocks: (B:54:0x00f3, B:56:0x00f8, B:58:0x00fd), top: B:73:0x00f3 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00fd A[Catch: Exception -> 0x0100, TRY_LEAVE, TryCatch #0 {Exception -> 0x0100, blocks: (B:54:0x00f3, B:56:0x00f8, B:58:0x00fd), top: B:73:0x00f3 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.kuaishou.weapon.p0.m r10, com.kuaishou.weapon.p0.j r11, java.lang.String r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.l.a(com.kuaishou.weapon.p0.m, com.kuaishou.weapon.p0.j, java.lang.String):void");
    }

    public void b(m mVar, j jVar) throws Throwable {
        a(mVar, jVar, "POST");
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00e1 A[Catch: Exception -> 0x00e4, TRY_LEAVE, TryCatch #7 {Exception -> 0x00e4, blocks: (B:46:0x00dc, B:48:0x00e1), top: B:68:0x00dc }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(com.kuaishou.weapon.p0.m r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.l.a(com.kuaishou.weapon.p0.m):java.lang.String");
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

    private InputStream a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null && httpURLConnection != null) {
            try {
                if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                    this.c = true;
                } else {
                    this.c = false;
                }
                return httpURLConnection.getInputStream();
            } catch (IOException unused) {
            }
        }
        return null;
    }

    private boolean a(InputStream inputStream, File file) {
        BufferedOutputStream bufferedOutputStream;
        if (this.c) {
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
                int i = inputStream.read(bArr);
                if (i != -1) {
                    bufferedOutputStream.write(bArr, 0, i);
                    bufferedOutputStream.flush();
                } else {
                    try {
                        bufferedOutputStream.close();
                        return true;
                    } catch (IOException unused3) {
                        return true;
                    }
                }
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

    public String a(Map<String, String> map) {
        String str = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str = str + "&" + entry.getKey() + "=" + entry.getValue();
        }
        return str.substring(1);
    }
}
