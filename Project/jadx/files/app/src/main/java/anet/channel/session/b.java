package anet.channel.session;

import android.os.Build;
import android.util.Pair;
import anet.channel.RequestCb;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.bytes.ByteArray;
import anet.channel.bytes.a;
import anet.channel.request.Request;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.StringUtils;
import com.taobao.accs.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: compiled from: Taobao */
    public static class a {
        public int a;
        public byte[] b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Map<String, List<String>> f407c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f408d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f409e;
    }

    private b() {
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0347 A[Catch: all -> 0x0273, TRY_LEAVE, TryCatch #8 {all -> 0x0273, blocks: (B:12:0x0032, B:14:0x003c, B:15:0x0083, B:17:0x0097, B:19:0x00b3, B:21:0x00fc, B:23:0x0106, B:25:0x010c, B:32:0x0176, B:33:0x018a, B:35:0x01ae, B:37:0x01b4, B:39:0x01ba, B:41:0x01c0, B:44:0x01c7, B:46:0x01e6, B:48:0x01f6, B:49:0x01fd, B:53:0x021a, B:55:0x0231, B:57:0x024c, B:51:0x020b, B:52:0x0212, B:108:0x031c, B:110:0x0347, B:120:0x0384, B:122:0x03af, B:75:0x0279, B:77:0x027f, B:78:0x0283, B:80:0x028b, B:82:0x029f, B:81:0x029a, B:90:0x02c0, B:98:0x02f5, B:130:0x03e9, B:138:0x0411, B:146:0x0437, B:154:0x045d), top: B:177:0x0032, inners: #12, #15, #19, #21, #22, #25 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03af A[Catch: all -> 0x0273, TRY_LEAVE, TryCatch #8 {all -> 0x0273, blocks: (B:12:0x0032, B:14:0x003c, B:15:0x0083, B:17:0x0097, B:19:0x00b3, B:21:0x00fc, B:23:0x0106, B:25:0x010c, B:32:0x0176, B:33:0x018a, B:35:0x01ae, B:37:0x01b4, B:39:0x01ba, B:41:0x01c0, B:44:0x01c7, B:46:0x01e6, B:48:0x01f6, B:49:0x01fd, B:53:0x021a, B:55:0x0231, B:57:0x024c, B:51:0x020b, B:52:0x0212, B:108:0x031c, B:110:0x0347, B:120:0x0384, B:122:0x03af, B:75:0x0279, B:77:0x027f, B:78:0x0283, B:80:0x028b, B:82:0x029f, B:81:0x029a, B:90:0x02c0, B:98:0x02f5, B:130:0x03e9, B:138:0x0411, B:146:0x0437, B:154:0x045d), top: B:177:0x0032, inners: #12, #15, #19, #21, #22, #25 }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x036d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static anet.channel.session.b.a a(anet.channel.request.Request r22, anet.channel.RequestCb r23) {
        /*
            Method dump skipped, instruction units count: 1198
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.session.b.a(anet.channel.request.Request, anet.channel.RequestCb):anet.channel.session.b$a");
    }

    private static void a(Request request, a aVar, RequestCb requestCb, int i2, Throwable th) {
        String errMsg = ErrorConstant.getErrMsg(i2);
        ALog.e("awcn.HttpConnector", "onException", request.getSeq(), "errorCode", Integer.valueOf(i2), "errMsg", errMsg, "url", request.getUrlString(), Constants.KEY_HOST, request.getHost());
        if (aVar != null) {
            aVar.a = i2;
        }
        if (!request.a.isDone.get()) {
            RequestStatistic requestStatistic = request.a;
            requestStatistic.statusCode = i2;
            requestStatistic.msg = errMsg;
            requestStatistic.rspEnd = System.currentTimeMillis();
            if (i2 != -204) {
                AppMonitor.getInstance().commitStat(new ExceptionStatistic(i2, errMsg, request.a, th));
            }
        }
        if (requestCb != null) {
            requestCb.onFinish(i2, errMsg, request.a);
        }
    }

    private static HttpURLConnection a(Request request) throws IOException {
        HttpURLConnection httpURLConnection;
        Pair<String, Integer> wifiProxy = NetworkStatusHelper.getWifiProxy();
        Proxy proxy = wifiProxy != null ? new Proxy(Proxy.Type.HTTP, new InetSocketAddress((String) wifiProxy.first, ((Integer) wifiProxy.second).intValue())) : null;
        anet.channel.util.g gVarA = anet.channel.util.g.a();
        if (NetworkStatusHelper.getStatus().isMobile() && gVarA != null) {
            proxy = gVarA.b();
        }
        URL url = request.getUrl();
        if (proxy != null) {
            httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        httpURLConnection.setConnectTimeout(request.getConnectTimeout());
        httpURLConnection.setReadTimeout(request.getReadTimeout());
        httpURLConnection.setRequestMethod(request.getMethod());
        if (request.containsBody()) {
            httpURLConnection.setDoOutput(true);
        }
        Map<String, String> headers = request.getHeaders();
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
        String host = headers.get(HttpConstant.HOST);
        if (host == null) {
            host = request.getHost();
        }
        String strConcatString = request.getHttpUrl().containsNonDefaultPort() ? StringUtils.concatString(host, ":", String.valueOf(request.getHttpUrl().getPort())) : host;
        httpURLConnection.setRequestProperty(HttpConstant.HOST, strConcatString);
        if (NetworkStatusHelper.getApn().equals("cmwap")) {
            httpURLConnection.setRequestProperty(HttpConstant.X_ONLINE_HOST, strConcatString);
        }
        if (!headers.containsKey("Accept-Encoding")) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        }
        if (gVarA != null) {
            httpURLConnection.setRequestProperty("Authorization", gVarA.c());
        }
        if (url.getProtocol().equalsIgnoreCase("https")) {
            a(httpURLConnection, request, host);
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        return httpURLConnection;
    }

    private static void a(HttpURLConnection httpURLConnection, Request request, String str) {
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            ALog.e("awcn.HttpConnector", "supportHttps", "[supportHttps]Froyo 以下版本不支持https", new Object[0]);
            return;
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
        if (request.getSslSocketFactory() != null) {
            httpsURLConnection.setSSLSocketFactory(request.getSslSocketFactory());
        } else {
            SSLSocketFactory sSLSocketFactory = anet.channel.util.b.a;
            if (sSLSocketFactory != null) {
                httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
                if (ALog.isPrintLog(2)) {
                    ALog.i("awcn.HttpConnector", "HttpSslUtil", request.getSeq(), "SslSocketFactory", anet.channel.util.b.a);
                }
            }
        }
        if (request.getHostnameVerifier() != null) {
            httpsURLConnection.setHostnameVerifier(request.getHostnameVerifier());
            return;
        }
        HostnameVerifier hostnameVerifier = anet.channel.util.b.b;
        if (hostnameVerifier != null) {
            httpsURLConnection.setHostnameVerifier(hostnameVerifier);
            if (ALog.isPrintLog(2)) {
                ALog.i("awcn.HttpConnector", "HttpSslUtil", request.getSeq(), "HostnameVerifier", anet.channel.util.b.b);
                return;
            }
            return;
        }
        httpsURLConnection.setHostnameVerifier(new c(str));
    }

    private static int a(HttpURLConnection httpURLConnection, Request request) {
        int i2 = 0;
        if (request.containsBody()) {
            OutputStream outputStream = null;
            try {
                try {
                    outputStream = httpURLConnection.getOutputStream();
                    int iPostBody = request.postBody(outputStream);
                    if (outputStream != null) {
                        try {
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e2) {
                            ALog.e("awcn.HttpConnector", "postData", request.getSeq(), e2, new Object[0]);
                        }
                    }
                    i2 = iPostBody;
                } catch (Exception e3) {
                    ALog.e("awcn.HttpConnector", "postData error", request.getSeq(), e3, new Object[0]);
                    if (outputStream != null) {
                        try {
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e4) {
                            ALog.e("awcn.HttpConnector", "postData", request.getSeq(), e4, new Object[0]);
                        }
                    }
                }
                RequestStatistic requestStatistic = request.a;
                long j2 = i2;
                requestStatistic.reqBodyInflateSize = j2;
                requestStatistic.reqBodyDeflateSize = j2;
                requestStatistic.sendDataSize = j2;
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.flush();
                        outputStream.close();
                    } catch (IOException e5) {
                        ALog.e("awcn.HttpConnector", "postData", request.getSeq(), e5, new Object[0]);
                    }
                }
                throw th;
            }
        }
        return i2;
    }

    private static void a(HttpURLConnection httpURLConnection, Request request, a aVar, RequestCb requestCb) throws Throwable {
        InputStream errorStream;
        ByteArrayOutputStream byteArrayOutputStream;
        anet.channel.util.a aVar2;
        httpURLConnection.getURL().toString();
        try {
            errorStream = httpURLConnection.getInputStream();
        } catch (IOException e2) {
            if (e2 instanceof FileNotFoundException) {
                ALog.w("awcn.HttpConnector", "File not found", request.getSeq(), "url", request.getUrlString());
            }
            try {
                errorStream = httpURLConnection.getErrorStream();
            } catch (Exception e3) {
                ALog.e("awcn.HttpConnector", "get error stream failed.", request.getSeq(), e3, new Object[0]);
                errorStream = null;
            }
        }
        if (errorStream == null) {
            a(request, aVar, requestCb, ErrorConstant.ERROR_IO_EXCEPTION, null);
            return;
        }
        if (requestCb == null) {
            int i2 = aVar.f408d;
            if (i2 <= 0) {
                i2 = 1024;
            } else if (aVar.f409e) {
                i2 *= 2;
            }
            byteArrayOutputStream = new ByteArrayOutputStream(i2);
        } else {
            byteArrayOutputStream = null;
        }
        try {
            aVar2 = new anet.channel.util.a(errorStream);
        } catch (Throwable th) {
            th = th;
            aVar2 = null;
        }
        try {
            InputStream gZIPInputStream = aVar.f409e ? new GZIPInputStream(aVar2) : aVar2;
            ByteArray byteArrayA = null;
            while (!Thread.currentThread().isInterrupted()) {
                if (byteArrayA == null) {
                    byteArrayA = a.C0005a.a.a(2048);
                }
                int from = byteArrayA.readFrom(gZIPInputStream);
                if (from != -1) {
                    if (byteArrayOutputStream != null) {
                        byteArrayA.writeTo(byteArrayOutputStream);
                    } else {
                        requestCb.onDataReceive(byteArrayA, false);
                        byteArrayA = null;
                    }
                    long j2 = from;
                    request.a.recDataSize += j2;
                    request.a.rspBodyInflateSize += j2;
                } else {
                    if (byteArrayOutputStream != null) {
                        byteArrayA.recycle();
                    } else {
                        requestCb.onDataReceive(byteArrayA, true);
                    }
                    if (byteArrayOutputStream != null) {
                        aVar.b = byteArrayOutputStream.toByteArray();
                    }
                    request.a.recDataTime = System.currentTimeMillis() - request.a.rspStart;
                    request.a.rspBodyDeflateSize = aVar2.a();
                    try {
                        gZIPInputStream.close();
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                }
            }
            throw new CancellationException("task cancelled");
        } catch (Throwable th2) {
            th = th2;
            request.a.recDataTime = System.currentTimeMillis() - request.a.rspStart;
            request.a.rspBodyDeflateSize = aVar2.a();
            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }
}
