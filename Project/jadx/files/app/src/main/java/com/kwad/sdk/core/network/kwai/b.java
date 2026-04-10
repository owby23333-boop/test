package com.kwad.sdk.core.network.kwai;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.q;
import com.kwad.sdk.core.network.s;
import com.kwad.sdk.crash.utils.h;
import com.umeng.message.utils.HttpRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static com.kwad.sdk.core.network.c a(String str, Map<String, String> map, String str2, boolean z2) throws Throwable {
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        OutputStream outputStream2 = null;
        outputStream2 = null;
        outputStream2 = null;
        outputStream2 = null;
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                s.wrapHttpURLConnection(httpURLConnection);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Content-Type", z2 ? "application/json" : "application/x-www-form-urlencoded");
                q.b(httpURLConnection);
                a(httpURLConnection, map);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.connect();
                if (!TextUtils.isEmpty(str2)) {
                    outputStream2 = httpURLConnection.getOutputStream();
                    outputStream2.write(str2.getBytes());
                    outputStream2.flush();
                }
                int responseCode = httpURLConnection.getResponseCode();
                cVar.code = responseCode;
                cVar.afI = cVar.code;
                if (responseCode == 200) {
                    cVar.afK = a(httpURLConnection.getInputStream());
                }
                com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream2);
            } catch (Exception e2) {
                e = e2;
                OutputStream outputStream3 = outputStream2;
                httpURLConnection2 = httpURLConnection;
                outputStream = outputStream3;
                try {
                    a(cVar, e);
                    com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                } catch (Throwable th) {
                    th = th;
                    HttpURLConnection httpURLConnection3 = httpURLConnection2;
                    outputStream2 = outputStream;
                    httpURLConnection = httpURLConnection3;
                    com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            outputStream = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
        }
        return cVar;
    }

    public static com.kwad.sdk.core.network.c a(String str, Map<String, String> map, boolean z2) throws Throwable {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        InputStream inputStream2 = null;
        inputStream2 = null;
        inputStream2 = null;
        inputStream2 = null;
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Exception e2) {
            e = e2;
            inputStream = null;
        } catch (Throwable th) {
            th = th;
            httpURLConnection = null;
        }
        try {
            s.wrapHttpURLConnection(httpURLConnection);
            a(httpURLConnection, map);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty(HttpRequest.HEADER_ACCEPT, "application/json");
            q.b(httpURLConnection);
            cVar.code = httpURLConnection.getResponseCode();
            cVar.afI = cVar.code;
            StringBuilder sb = new StringBuilder();
            if (z2) {
                inputStream2 = httpURLConnection.getInputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int i2 = inputStream2.read(bArr);
                    if (i2 == -1) {
                        break;
                    }
                    sb.append(new String(bArr, 0, i2));
                }
            }
            cVar.afK = sb.toString();
            com.kwad.sdk.crash.utils.b.a(httpURLConnection);
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
        } catch (Exception e3) {
            e = e3;
            InputStream inputStream3 = inputStream2;
            httpURLConnection2 = httpURLConnection;
            inputStream = inputStream3;
            try {
                a(cVar, e);
                com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            } catch (Throwable th2) {
                th = th2;
                HttpURLConnection httpURLConnection3 = httpURLConnection2;
                inputStream2 = inputStream;
                httpURLConnection = httpURLConnection3;
                com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            com.kwad.sdk.crash.utils.b.a(httpURLConnection);
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
            throw th;
        }
        return cVar;
    }

    private static String a(InputStream inputStream) {
        try {
            try {
                return h.c(inputStream);
            } catch (IOException e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                return null;
            }
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        }
    }

    private static void a(@NonNull com.kwad.sdk.core.network.c cVar, Exception exc) {
        int i2 = cVar.code;
        if (i2 == 0) {
            i2 = -1;
        }
        cVar.afI = i2;
        cVar.afJ = exc;
        if (exc instanceof SocketTimeoutException) {
            f fVar = f.afN;
            cVar.code = fVar.errorCode;
            cVar.afK = fVar.msg;
        } else {
            cVar.code = f.afO.errorCode;
            try {
                cVar.afK = f.afO.msg + "/n" + Log.getStackTraceString(exc);
            } catch (Exception unused) {
            }
        }
        if (com.kwad.b.kwai.a.bI.booleanValue()) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(exc);
        }
    }

    private static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public static com.kwad.sdk.core.network.c doGet(String str, Map<String, String> map) {
        return a(str, map, true);
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, Map<String, String> map2) {
        String strSubstring;
        if (map2 != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                String strEncode = encode(entry.getValue());
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(strEncode);
                sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            }
            strSubstring = sb.substring(0, sb.length() - 1);
        } else {
            strSubstring = null;
        }
        return a(str, map, strSubstring, false);
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        return a(str, map, jSONObject != null ? jSONObject.toString() : null, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean downloadUrlToStream(java.lang.String r10, java.io.OutputStream r11, int r12) throws java.lang.Throwable {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L84
            r1.<init>(r10)     // Catch: java.lang.Throwable -> L84
            java.net.URLConnection r10 = r1.openConnection()     // Catch: java.lang.Throwable -> L84
            java.net.HttpURLConnection r10 = (java.net.HttpURLConnection) r10     // Catch: java.lang.Throwable -> L84
            com.kwad.sdk.core.network.s.wrapHttpURLConnection(r10)     // Catch: java.lang.Throwable -> L81
            java.lang.String r1 = "Accept-Language"
            java.lang.String r2 = "zh-CN"
            r10.setRequestProperty(r1, r2)     // Catch: java.lang.Throwable -> L81
            r1 = 10000(0x2710, float:1.4013E-41)
            r10.setConnectTimeout(r1)     // Catch: java.lang.Throwable -> L81
            r1 = 120000(0x1d4c0, float:1.68156E-40)
            r10.setReadTimeout(r1)     // Catch: java.lang.Throwable -> L81
            r1 = 0
            r10.setUseCaches(r1)     // Catch: java.lang.Throwable -> L81
            r2 = 1
            r10.setDoInput(r2)     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = "Connection"
            java.lang.String r4 = "keep-alive"
            r10.setRequestProperty(r3, r4)     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = "Charset"
            java.lang.String r4 = "UTF-8"
            r10.setRequestProperty(r3, r4)     // Catch: java.lang.Throwable -> L81
            com.kwad.sdk.core.network.q.b(r10)     // Catch: java.lang.Throwable -> L81
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L81
            java.io.InputStream r4 = r10.getInputStream()     // Catch: java.lang.Throwable -> L81
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L81
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L7f
            r5 = 0
            r7 = -1
            if (r12 <= 0) goto L5a
        L4c:
            int r11 = r3.read(r4)     // Catch: java.lang.Throwable -> L7f
            if (r11 == r7) goto L72
            long r8 = (long) r11     // Catch: java.lang.Throwable -> L7f
            long r5 = r5 + r8
            long r8 = (long) r12     // Catch: java.lang.Throwable -> L7f
            int r11 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r11 <= 0) goto L4c
            goto L72
        L5a:
            if (r12 >= 0) goto L72
            java.io.BufferedOutputStream r12 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L7f
            r12.<init>(r11)     // Catch: java.lang.Throwable -> L7f
        L61:
            int r11 = r3.read(r4)     // Catch: java.lang.Throwable -> L6f
            if (r11 == r7) goto L6b
            r12.write(r4, r1, r11)     // Catch: java.lang.Throwable -> L6f
            goto L61
        L6b:
            r12.flush()     // Catch: java.lang.Throwable -> L6f
            goto L73
        L6f:
            r11 = move-exception
            r0 = r12
            goto L87
        L72:
            r12 = r0
        L73:
            com.kwad.sdk.crash.utils.b.closeQuietly(r12)
            com.kwad.sdk.crash.utils.b.closeQuietly(r3)
            if (r10 == 0) goto L7e
            r10.disconnect()
        L7e:
            return r2
        L7f:
            r11 = move-exception
            goto L87
        L81:
            r11 = move-exception
            r3 = r0
            goto L87
        L84:
            r11 = move-exception
            r10 = r0
            r3 = r10
        L87:
            com.kwad.sdk.crash.utils.b.closeQuietly(r0)
            com.kwad.sdk.crash.utils.b.closeQuietly(r3)
            if (r10 == 0) goto L92
            r10.disconnect()
        L92:
            goto L94
        L93:
            throw r11
        L94:
            goto L93
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.network.kwai.b.downloadUrlToStream(java.lang.String, java.io.OutputStream, int):boolean");
    }

    private static String encode(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            return "";
        }
    }
}
