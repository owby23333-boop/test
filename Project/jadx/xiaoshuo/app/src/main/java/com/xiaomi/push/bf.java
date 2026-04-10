package com.xiaomi.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.iflytek.aikit.media.param.MscKeys;
import com.xiaomi.mipush.sdk.Constants;
import com.yuewen.g72;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import net.oauth.http.HttpResponseMessage;

/* JADX INFO: loaded from: classes8.dex */
public class bf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReference<a<bi>> f7819a = new AtomicReference<>(a());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Pattern f168a = Pattern.compile("([^\\s;]+)(.*)");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f7820b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
    public static final Pattern c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    public static class a<T> extends FutureTask<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f7821a;

        public a(Callable<T> callable) {
            super(callable);
        }

        public boolean a() {
            return j.m612a(C0855r.m693a()) || (isDone() && Math.abs(SystemClock.elapsedRealtime() - this.f7821a) > 1800000);
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            this.f7821a = SystemClock.elapsedRealtime();
            super.run();
        }
    }

    public static final class b extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f7822a;

        public b(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int i3;
            if (!this.f7822a && (i3 = super.read(bArr, i, i2)) != -1) {
                return i3;
            }
            this.f7822a = true;
            return -1;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7823a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Map<String, String> f169a;

        public String toString() {
            return String.format("resCode = %1$d, headers = %2$s", Integer.valueOf(this.f7823a), this.f169a.toString());
        }
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2) {
        return a(context, url, z, str, str2, null, null);
    }

    public static void b() {
        f7819a.set(a());
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(android.content.Context r3) {
        /*
            java.lang.String r0 = "connectivity"
            java.lang.Object r0 = r3.getSystemService(r0)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            r1 = 0
            if (r0 == 0) goto L1c
            android.net.Network r2 = r0.getActiveNetwork()     // Catch: java.lang.Exception -> L1c
            android.net.NetworkCapabilities r0 = r0.getNetworkCapabilities(r2)     // Catch: java.lang.Exception -> L1c
            if (r0 == 0) goto L1c
            r2 = 16
            boolean r0 = r0.hasCapability(r2)     // Catch: java.lang.Exception -> L1c
            goto L1d
        L1c:
            r0 = r1
        L1d:
            if (r0 == 0) goto L26
            boolean r3 = d(r3)
            if (r3 == 0) goto L26
            r1 = 1
        L26:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.bf.c(android.content.Context):boolean");
    }

    public static boolean d(Context context) {
        bi biVarM216a = m216a();
        return biVarM216a != null && biVarM216a.m227a();
    }

    public static boolean e(Context context) {
        bi biVarM216a = m216a();
        return biVarM216a != null && 1 == biVarM216a.a();
    }

    public static boolean f(Context context) {
        bi biVarM217a = m217a(context);
        return biVarM217a != null && biVarM217a.a() == 0 && 20 == biVarM217a.b();
    }

    public static boolean g(Context context) {
        bi biVarM217a = m217a(context);
        return biVarM217a != null && biVarM217a.a() == 0 && 13 == biVarM217a.b();
    }

    public static boolean h(Context context) {
        bi biVarM217a = m217a(context);
        if (biVarM217a == null || biVarM217a.a() != 0) {
            return false;
        }
        String strM228b = biVarM217a.m228b();
        if (!"TD-SCDMA".equalsIgnoreCase(strM228b) && !"CDMA2000".equalsIgnoreCase(strM228b) && !"WCDMA".equalsIgnoreCase(strM228b)) {
            switch (biVarM217a.b()) {
            }
            return false;
        }
        return true;
    }

    public static boolean i(Context context) {
        bi biVarM217a = m217a(context);
        if (biVarM217a == null || biVarM217a.a() != 0) {
            return false;
        }
        int iB = biVarM217a.b();
        return iB == 1 || iB == 2 || iB == 4 || iB == 7 || iB == 11;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m222a() {
        b();
    }

    public static boolean b(Context context) {
        return a(context) >= 0;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static Object m218a(Context context) {
        ConnectivityManager connectivityManager;
        NetworkRequest networkRequestBuild;
        bg bgVar;
        if (context == null) {
            context = C0855r.m693a();
        }
        bg bgVar2 = null;
        if (context == null || j.m612a(context)) {
            return null;
        }
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            networkRequestBuild = new NetworkRequest.Builder().build();
            bgVar = new bg();
        } catch (Throwable th) {
            th = th;
        }
        try {
            connectivityManager.registerNetworkCallback(networkRequestBuild, bgVar);
            return bgVar;
        } catch (Throwable th2) {
            th = th2;
            bgVar2 = bgVar;
            com.xiaomi.channel.commonutils.logger.b.m106a("exception occurred in adding network callback :" + th);
            return bgVar2;
        }
    }

    public static void a(Context context, Object obj) {
        if (context == null || obj == null) {
            return;
        }
        try {
            if (obj instanceof ConnectivityManager.NetworkCallback) {
                ((ConnectivityManager) context.getSystemService("connectivity")).unregisterNetworkCallback((ConnectivityManager.NetworkCallback) obj);
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m106a("exception occurred in removing network callback :" + th);
        }
    }

    private static a<bi> a() {
        return new a<>(new bh());
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static bi m216a() {
        AtomicReference<a<bi>> atomicReference = f7819a;
        a<bi> aVarA = atomicReference.get();
        if (aVarA != null) {
            try {
                if (aVarA.a()) {
                    aVarA = a();
                    atomicReference.set(aVarA);
                }
                if (!aVarA.isDone()) {
                    aVarA.run();
                }
                return aVarA.get();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2, Map<String, String> map, c cVar) throws IOException {
        if (context == null) {
            throw new IllegalArgumentException("context");
        }
        if (url != null) {
            URL url2 = !z ? new URL(a(url.toString())) : url;
            try {
                HttpURLConnection.setFollowRedirects(true);
                HttpURLConnection httpURLConnectionM220a = m220a(context, url2);
                httpURLConnectionM220a.setConnectTimeout(10000);
                httpURLConnectionM220a.setReadTimeout(15000);
                if (!TextUtils.isEmpty(str)) {
                    httpURLConnectionM220a.setRequestProperty("User-Agent", str);
                }
                if (str2 != null) {
                    httpURLConnectionM220a.setRequestProperty(HttpHeaders.COOKIE, str2);
                }
                if (map != null) {
                    for (String str3 : map.keySet()) {
                        httpURLConnectionM220a.setRequestProperty(str3, map.get(str3));
                    }
                }
                if (cVar != null && (url.getProtocol().equals("http") || url.getProtocol().equals("https"))) {
                    cVar.f7823a = httpURLConnectionM220a.getResponseCode();
                    if (cVar.f169a == null) {
                        cVar.f169a = new HashMap();
                    }
                    int i = 0;
                    while (true) {
                        String headerFieldKey = httpURLConnectionM220a.getHeaderFieldKey(i);
                        String headerField = httpURLConnectionM220a.getHeaderField(i);
                        if (headerFieldKey == null && headerField == null) {
                            break;
                        }
                        if (!TextUtils.isEmpty(headerFieldKey) && !TextUtils.isEmpty(headerField)) {
                            cVar.f169a.put(headerFieldKey, headerField);
                        }
                        i++;
                    }
                }
                return new b(httpURLConnectionM220a.getInputStream());
            } catch (IOException e) {
                throw new IOException("IOException:" + e.getClass().getSimpleName());
            } catch (Throwable th) {
                throw new IOException(th.getMessage());
            }
        }
        throw new IllegalArgumentException("url");
    }

    public static String a(Context context, URL url) {
        return a(context, url, false, null, "UTF-8", null);
    }

    public static String a(Context context, URL url, boolean z, String str, String str2, String str3) throws Throwable {
        InputStream inputStreamA;
        try {
            inputStreamA = a(context, url, z, str, str3);
        } catch (Throwable th) {
            th = th;
            inputStreamA = null;
        }
        try {
            StringBuilder sb = new StringBuilder(1024);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamA, str2));
            char[] cArr = new char[4096];
            while (true) {
                int i = bufferedReader.read(cArr);
                if (-1 != i) {
                    sb.append(cArr, 0, i);
                } else {
                    x.a((Closeable) inputStreamA);
                    return sb.toString();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            x.a((Closeable) inputStreamA);
            throw th;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new String();
        return String.format("%s&key=%s", str, bn.a(String.format("%sbe988a6134bc8254465424e5a70ef037", str)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String a(String str, Map<String, String> map, File file, String str2) {
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        FileInputStream fileInputStream;
        byte[] bArr;
        if (!file.exists()) {
            return null;
        }
        String name = file.getName();
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty(HttpHeaders.CONNECTION, "Keep-Alive");
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****");
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.setFixedLengthStreamingMode(name.length() + 77 + ((int) file.length()) + str2.length());
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.writeBytes("--*****\r\n");
                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str2 + "\";filename=\"" + file.getName() + "\"" + HttpResponseMessage.EOL);
                dataOutputStream.writeBytes(HttpResponseMessage.EOL);
                fileInputStream = new FileInputStream(file);
                try {
                    bArr = new byte[1024];
                } catch (IOException e) {
                    e = e;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                e = e2;
            } catch (Throwable th2) {
                th = th2;
            }
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                dataOutputStream.write(bArr, 0, i);
                dataOutputStream.flush();
                throw new IOException("IOException:" + e.getClass().getSimpleName());
            }
            dataOutputStream.writeBytes(HttpResponseMessage.EOL);
            dataOutputStream.writeBytes("--");
            dataOutputStream.writeBytes("*****");
            dataOutputStream.writeBytes("--");
            dataOutputStream.writeBytes(HttpResponseMessage.EOL);
            dataOutputStream.flush();
            StringBuffer stringBuffer = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new b(httpURLConnection.getInputStream())));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        stringBuffer.append(line);
                    } else {
                        String string = stringBuffer.toString();
                        x.a((Closeable) fileInputStream);
                        x.a(bufferedReader);
                        return string;
                    }
                } catch (IOException e3) {
                    e = e3;
                } catch (Throwable th3) {
                    th = th3;
                    throw new IOException(th.getMessage());
                }
            }
        } catch (Throwable th4) {
            x.a((Closeable) null);
            x.a((Closeable) file);
            throw th4;
        }
    }

    public static int a(Context context) {
        bi biVarM216a = m216a();
        if (biVarM216a == null) {
            return -1;
        }
        return biVarM216a.a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m223a(Context context) {
        bi biVarM216a;
        if (!"CN".equalsIgnoreCase(((TelephonyManager) context.getSystemService(com.xiaomi.onetrack.api.at.d)).getSimCountryIso()) || (biVarM216a = m216a()) == null) {
            return false;
        }
        String strC = biVarM216a.c();
        return !TextUtils.isEmpty(strC) && strC.length() >= 3 && strC.contains("ctwap");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static HttpURLConnection m220a(Context context, URL url) {
        if (!"http".equals(url.getProtocol())) {
            return (HttpURLConnection) url.openConnection();
        }
        if (m223a(context)) {
            return (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80)));
        }
        return (HttpURLConnection) url.openConnection();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static bi m217a(Context context) {
        return m216a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m219a(Context context) {
        if (e(context)) {
            return g72.g;
        }
        bi biVarM216a = m216a();
        if (biVarM216a == null) {
            return "";
        }
        return (biVarM216a.m226a() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + biVarM216a.m228b() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + biVarM216a.c()).toLowerCase();
    }

    public static bd a(Context context, String str, Map<String, String> map) {
        return a(context, str, "POST", (Map<String, String>) null, a(map));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static bd a(Context context, String str, String str2, Map<String, String> map, String str3) {
        HttpURLConnection httpURLConnectionM220a;
        int i;
        boolean zEqualsIgnoreCase;
        BufferedReader bufferedReader;
        OutputStream outputStream;
        bd bdVar = new bd();
        try {
            try {
                try {
                    httpURLConnectionM220a = m220a(context, m221a(str));
                    httpURLConnectionM220a.setConnectTimeout(10000);
                    httpURLConnectionM220a.setReadTimeout(15000);
                    String str4 = str2;
                    if (str2 == 0) {
                        str4 = "GET";
                    }
                    httpURLConnectionM220a.setRequestMethod(str4);
                    i = 0;
                    if (map != null) {
                        zEqualsIgnoreCase = "gzip".equalsIgnoreCase(map.get("Content-Encoding"));
                        for (String str5 : map.keySet()) {
                            httpURLConnectionM220a.setRequestProperty(str5, map.get(str5));
                        }
                    } else {
                        zEqualsIgnoreCase = false;
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        httpURLConnectionM220a.setDoOutput(true);
                        byte[] bytes = str3.getBytes();
                        if (zEqualsIgnoreCase) {
                            outputStream = new GZIPOutputStream(httpURLConnectionM220a.getOutputStream());
                        } else {
                            outputStream = httpURLConnectionM220a.getOutputStream();
                        }
                        try {
                            outputStream.write(bytes, 0, bytes.length);
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e) {
                            e = e;
                        } catch (Throwable th) {
                            th = th;
                            throw new IOException(th.getMessage());
                        }
                    }
                    bdVar.f7818a = httpURLConnectionM220a.getResponseCode();
                    com.xiaomi.channel.commonutils.logger.b.m106a("Http POST Response Code: " + bdVar.f7818a);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e2) {
                e = e2;
            }
            while (true) {
                String headerFieldKey = httpURLConnectionM220a.getHeaderFieldKey(i);
                String headerField = httpURLConnectionM220a.getHeaderField(i);
                if (headerFieldKey == null && headerField == null) {
                    try {
                        break;
                    } catch (IOException unused) {
                        bufferedReader = new BufferedReader(new InputStreamReader(new b(httpURLConnectionM220a.getErrorStream())));
                    }
                } else {
                    bdVar.f167a.put(headerFieldKey, headerField);
                    i = i + 1 + 1;
                }
                throw new IOException("err while request " + str + ":" + e.getClass().getSimpleName());
            }
            bufferedReader = new BufferedReader(new InputStreamReader(new b(httpURLConnectionM220a.getInputStream())));
            try {
                StringBuffer stringBuffer = new StringBuffer();
                String property = System.getProperty("line.separator");
                for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                    stringBuffer.append(line);
                    stringBuffer.append(property);
                }
                bdVar.f166a = stringBuffer.toString();
                bufferedReader.close();
                x.a((Closeable) null);
                x.a((Closeable) null);
                return bdVar;
            } catch (IOException e3) {
                e = e3;
            } catch (Throwable th3) {
                th = th3;
                throw new IOException(th.getMessage());
            }
        } catch (Throwable th4) {
            x.a((Closeable) null);
            x.a((Closeable) str2);
            throw th4;
        }
    }

    public static String a(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                try {
                    stringBuffer.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                    stringBuffer.append(MscKeys.KEY_VAL_SEP);
                    stringBuffer.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                    stringBuffer.append(com.alipay.sdk.m.w.a.p);
                } catch (UnsupportedEncodingException e) {
                    com.xiaomi.channel.commonutils.logger.b.m106a("Failed to convert from params map to string: " + e);
                    com.xiaomi.channel.commonutils.logger.b.m106a("map: " + map.toString());
                    return null;
                }
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static URL m221a(String str) {
        return new URL(str);
    }
}
