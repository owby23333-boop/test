package com.kwad.sdk.core.network.kwai;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.anythink.expressad.video.module.a.a.m;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.q;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import okhttp3.ConnectionSpec;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static final Pattern agL = Pattern.compile("Unexpected response code for CONNECT: ([0-9]+)", 2);
    public static String agM = "UTF-8";
    private static OkHttpClient agN = null;
    public static OkHttpClient agO = wx();

    public static com.kwad.sdk.core.network.c a(String str, @Nullable Map<String, String> map, boolean z2) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder builderUrl = new Request.Builder().url(str);
            a(builderUrl);
            a(builderUrl, map);
            Response responseExecute = ww().newCall(builderUrl.build()).execute();
            cVar.code = responseExecute.code();
            cVar.afI = cVar.code;
            cVar.afK = z2 ? a(responseExecute) : "";
        } catch (Exception e2) {
            a(cVar, e2);
        }
        return cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable, java.io.InputStreamReader, java.io.Reader] */
    private static String a(Response response) throws Throwable {
        InputStream inputStreamByteStream;
        InputStream inputStream;
        ?? inputStreamReader;
        InputStream gZIPInputStream;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            inputStreamByteStream = response.body().byteStream();
            try {
                List<String> listHeaders = response.headers("Content-Encoding");
                boolean z2 = false;
                if (listHeaders != null) {
                    Iterator<String> it = listHeaders.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if ("gzip".equalsIgnoreCase(it.next())) {
                            z2 = true;
                            break;
                        }
                    }
                }
                if (z2) {
                    gZIPInputStream = new GZIPInputStream(inputStreamByteStream);
                    inputStream = gZIPInputStream;
                } else {
                    inputStream = null;
                    gZIPInputStream = inputStreamByteStream;
                }
                try {
                    inputStreamReader = new InputStreamReader(gZIPInputStream, agM);
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader, 8);
                        while (true) {
                            try {
                                String line = bufferedReader2.readLine();
                                if (line == null) {
                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                                    com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) inputStreamReader);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamByteStream);
                                    return sb.toString();
                                }
                                sb.append(line);
                            } catch (Throwable th) {
                                bufferedReader = bufferedReader2;
                                th = th;
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) inputStreamReader);
                                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                                com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamByteStream);
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStreamReader = 0;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                inputStreamReader = inputStream;
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) inputStreamReader);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamByteStream);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStreamByteStream = null;
            inputStream = null;
        }
    }

    private static void a(@NonNull com.kwad.sdk.core.network.c cVar, Exception exc) {
        String message;
        cVar.afJ = exc;
        if (cVar.afI == -1 && (exc instanceof IOException) && (message = exc.getMessage()) != null) {
            Matcher matcher = agL.matcher(message);
            if (matcher.find()) {
                try {
                    cVar.afI = Integer.parseInt(matcher.group(1));
                } catch (Exception unused) {
                }
            }
        }
        if (exc instanceof SocketTimeoutException) {
            f fVar = f.afN;
            cVar.code = fVar.errorCode;
            cVar.afK = fVar.msg;
        } else {
            cVar.code = f.afO.errorCode;
            try {
                cVar.afK = f.afO.msg + "/n" + Log.getStackTraceString(exc);
            } catch (Exception unused2) {
            }
        }
        if (com.kwad.b.kwai.a.bI.booleanValue()) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(exc);
        }
    }

    private static void a(Request.Builder builder) {
        builder.addHeader("User-Agent", q.getUserAgent());
        builder.addHeader("BrowserUa", q.wt());
        builder.addHeader("SystemUa", q.ws());
    }

    private static void a(Request.Builder builder, @Nullable Map<String, String> map) {
        if (builder == null || map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                try {
                    builder.removeHeader(entry.getKey());
                    builder.addHeader(entry.getKey(), entry.getValue());
                } catch (Exception unused) {
                }
            }
        }
    }

    private static void a(Request.Builder builder, JSONObject jSONObject) {
        builder.post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jSONObject.toString()));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0030 A[Catch: all -> 0x0081, TRY_LEAVE, TryCatch #0 {all -> 0x0081, blocks: (B:4:0x0009, B:6:0x0013, B:7:0x0017, B:9:0x001d, B:14:0x0030), top: B:50:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0047 A[Catch: all -> 0x007a, LOOP:1: B:21:0x0047->B:64:?, LOOP_START, PHI: r6
  0x0047: PHI (r6v1 long) = (r6v0 long), (r6v2 long) binds: [B:20:0x0045, B:64:?] A[DONT_GENERATE, DONT_INLINE], TryCatch #3 {all -> 0x007a, blocks: (B:19:0x0040, B:21:0x0047, B:23:0x004d, B:27:0x0057), top: B:56:0x0040 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(okhttp3.Response r11, java.io.OutputStream r12, int r13) throws java.lang.Throwable {
        /*
            r0 = 0
            okhttp3.ResponseBody r1 = r11.body()     // Catch: java.lang.Throwable -> L85
            java.io.InputStream r1 = r1.byteStream()     // Catch: java.lang.Throwable -> L85
            java.lang.String r2 = "Content-Encoding"
            java.util.List r11 = r11.headers(r2)     // Catch: java.lang.Throwable -> L81
            r2 = 1
            r3 = 0
            if (r11 == 0) goto L2d
            java.util.Iterator r11 = r11.iterator()     // Catch: java.lang.Throwable -> L81
        L17:
            boolean r4 = r11.hasNext()     // Catch: java.lang.Throwable -> L81
            if (r4 == 0) goto L2d
            java.lang.Object r4 = r11.next()     // Catch: java.lang.Throwable -> L81
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L81
            java.lang.String r5 = "gzip"
            boolean r4 = r5.equalsIgnoreCase(r4)     // Catch: java.lang.Throwable -> L81
            if (r4 == 0) goto L17
            r11 = 1
            goto L2e
        L2d:
            r11 = 0
        L2e:
            if (r11 == 0) goto L37
            java.util.zip.GZIPInputStream r11 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L81
            r11.<init>(r1)     // Catch: java.lang.Throwable -> L81
            r4 = r11
            goto L39
        L37:
            r4 = r0
            r11 = r1
        L39:
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L7e
            r5.<init>(r11)     // Catch: java.lang.Throwable -> L7e
            r11 = 1024(0x400, float:1.435E-42)
            byte[] r11 = new byte[r11]     // Catch: java.lang.Throwable -> L7a
            r6 = 0
            r8 = -1
            if (r13 <= 0) goto L55
        L47:
            int r12 = r5.read(r11)     // Catch: java.lang.Throwable -> L7a
            if (r12 == r8) goto L6c
            long r9 = (long) r12     // Catch: java.lang.Throwable -> L7a
            long r6 = r6 + r9
            long r9 = (long) r13     // Catch: java.lang.Throwable -> L7a
            int r12 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r12 <= 0) goto L47
            goto L6c
        L55:
            if (r13 >= 0) goto L6c
            java.io.BufferedOutputStream r13 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L7a
            r13.<init>(r12)     // Catch: java.lang.Throwable -> L7a
        L5c:
            int r12 = r5.read(r11)     // Catch: java.lang.Throwable -> L6a
            if (r12 == r8) goto L66
            r13.write(r11, r3, r12)     // Catch: java.lang.Throwable -> L6a
            goto L5c
        L66:
            r13.flush()     // Catch: java.lang.Throwable -> L6a
            goto L6d
        L6a:
            r11 = move-exception
            goto L7c
        L6c:
            r13 = r0
        L6d:
            com.kwad.sdk.crash.utils.b.closeQuietly(r5)
            com.kwad.sdk.crash.utils.b.closeQuietly(r13)
            com.kwad.sdk.crash.utils.b.closeQuietly(r4)
            com.kwad.sdk.crash.utils.b.closeQuietly(r1)
            return r2
        L7a:
            r11 = move-exception
            r13 = r0
        L7c:
            r0 = r5
            goto L89
        L7e:
            r11 = move-exception
            r13 = r0
            goto L89
        L81:
            r11 = move-exception
            r13 = r0
            r4 = r13
            goto L89
        L85:
            r11 = move-exception
            r13 = r0
            r1 = r13
            r4 = r1
        L89:
            com.kwad.sdk.crash.utils.b.closeQuietly(r0)
            com.kwad.sdk.crash.utils.b.closeQuietly(r13)
            com.kwad.sdk.crash.utils.b.closeQuietly(r4)
            com.kwad.sdk.crash.utils.b.closeQuietly(r1)
            goto L97
        L96:
            throw r11
        L97:
            goto L96
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.network.kwai.c.a(okhttp3.Response, java.io.OutputStream, int):boolean");
    }

    private static void b(Request.Builder builder, Map<String, String> map) {
        FormBody formBodyBuild;
        if (map == null || map.isEmpty()) {
            formBodyBuild = null;
        } else {
            FormBody.Builder builder2 = new FormBody.Builder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null) {
                    try {
                        builder2.addEncoded(entry.getKey(), encode(entry.getValue()));
                    } catch (Exception unused) {
                    }
                }
            }
            formBodyBuild = builder2.build();
        }
        if (builder == null || formBodyBuild == null) {
            return;
        }
        builder.post(formBodyBuild);
    }

    public static com.kwad.sdk.core.network.c doGet(String str, @Nullable Map<String, String> map) {
        return a(str, map, true);
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, Map<String, String> map2) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder builderUrl = new Request.Builder().url(str);
            a(builderUrl);
            a(builderUrl, map);
            b(builderUrl, map2);
            Response responseExecute = ww().newCall(builderUrl.build()).execute();
            cVar.code = responseExecute.code();
            cVar.afI = cVar.code;
            cVar.afK = a(responseExecute);
        } catch (Exception e2) {
            a(cVar, e2);
        }
        return cVar;
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder builderUrl = new Request.Builder().url(str);
            a(builderUrl);
            a(builderUrl, map);
            a(builderUrl, jSONObject);
            Response responseExecute = ww().newCall(builderUrl.build()).execute();
            cVar.code = responseExecute.code();
            cVar.afI = cVar.code;
            cVar.afK = a(responseExecute);
        } catch (Exception e2) {
            a(cVar, e2);
        }
        return cVar;
    }

    public static boolean downloadUrlToStream(String str, OutputStream outputStream, int i2) throws Throwable {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        Request.Builder builderUrl = new Request.Builder().url(str);
        HashMap map = new HashMap();
        map.put("Accept-Language", "zh-CN");
        map.put("Connection", "keep-alive");
        map.put("Charset", "UTF-8");
        a(builderUrl);
        a(builderUrl, map);
        Response responseExecute = ww().newCall(builderUrl.build()).execute();
        cVar.code = responseExecute.code();
        cVar.afI = cVar.code;
        a(responseExecute, outputStream, i2);
        return true;
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

    public static OkHttpClient ww() {
        if (!com.kwad.b.kwai.a.bI.booleanValue()) {
            return agO;
        }
        if (agN == null) {
            agN = agO.newBuilder().build();
        }
        return agN;
    }

    private static OkHttpClient wx() {
        if (agO == null) {
            OkHttpClient.Builder builderConnectionSpecs = new OkHttpClient.Builder().connectTimeout(m.ag, TimeUnit.MILLISECONDS).readTimeout(6000L, TimeUnit.MILLISECONDS).connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
            try {
                builderConnectionSpecs.dns(new d());
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTrace(th);
            }
            agO = builderConnectionSpecs.build();
        }
        return agO;
    }
}
