package com.kwad.sdk.core.download;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.ksad.download.DownloadTask;
import com.kwad.sdk.core.network.s;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.utils.v;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    @SuppressLint({"StaticFieldLeak"})
    private static Context mContext;
    private static volatile boolean mHasInit;

    /* JADX INFO: renamed from: com.kwad.sdk.core.download.a$a, reason: collision with other inner class name */
    public static class C0437a implements c {
        final OutputStream aeB;

        public C0437a(File file, boolean z2) {
            this.aeB = new FileOutputStream(file, z2);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            this.aeB.close();
        }

        @Override // com.kwad.sdk.core.download.a.c
        public final void write(byte[] bArr, int i2, int i3) throws IOException {
            this.aeB.write(bArr, 0, i3);
        }
    }

    public interface b {
    }

    public interface c extends Closeable {
        void write(byte[] bArr, int i2, int i3);
    }

    @Nullable
    public static String A(AdInfo adInfo) {
        if (mContext == null) {
            return "";
        }
        DownloadParams downloadParamsTransform = DownloadParams.transform(adInfo);
        if (TextUtils.isEmpty(downloadParamsTransform.mFileUrl)) {
            return null;
        }
        return au.cR(mContext) + File.separator + bw(downloadParamsTransform.mFileUrl);
    }

    public static void B(@NonNull AdInfo adInfo) {
        a(adInfo, false);
    }

    private static InputStream a(Map<String, List<String>> map, InputStream inputStream) {
        List<String> value;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if ("Content-Encoding".equalsIgnoreCase(entry.getKey()) && (value = entry.getValue()) != null && !value.isEmpty()) {
                boolean z2 = false;
                Iterator<String> it = value.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if ("gzip".equalsIgnoreCase(it.next())) {
                        z2 = true;
                        break;
                    }
                }
                if (z2) {
                    try {
                        return new GZIPInputStream(inputStream);
                    } catch (IOException unused) {
                    }
                } else {
                    continue;
                }
            }
        }
        return inputStream;
    }

    private static URLConnection a(String str, int i2, int i3, boolean z2) throws IOException {
        try {
            URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
            s.wrapHttpURLConnection(uRLConnectionOpenConnection);
            uRLConnectionOpenConnection.setRequestProperty("Accept-Language", "zh-CN");
            uRLConnectionOpenConnection.setConnectTimeout(10000);
            if (i3 > 0) {
                uRLConnectionOpenConnection.setReadTimeout(i3);
            }
            uRLConnectionOpenConnection.setUseCaches(false);
            uRLConnectionOpenConnection.setDoInput(true);
            uRLConnectionOpenConnection.setRequestProperty("Connection", "keep-alive");
            uRLConnectionOpenConnection.setRequestProperty("Charset", "UTF-8");
            return uRLConnectionOpenConnection;
        } catch (MalformedURLException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            return null;
        }
    }

    private static void a(@NonNull AdInfo adInfo, boolean z2) {
        Context context = mContext;
        if (context == null) {
            return;
        }
        if (!af.isNetworkConnected(context)) {
            Context context2 = mContext;
            u.F(context2, v.ca(context2));
            return;
        }
        DownloadParams downloadParamsTransform = DownloadParams.transform(adInfo);
        int i2 = 0;
        downloadParamsTransform.requestInstallPermission = false;
        String str = downloadParamsTransform.mFileUrl;
        if (TextUtils.isEmpty(str) || !URLUtil.isNetworkUrl(str)) {
            return;
        }
        DownloadTask.DownloadRequest downloadRequest = new DownloadTask.DownloadRequest(downloadParamsTransform.mFileUrl);
        downloadRequest.setDestinationFileName(bw(str));
        downloadRequest.setTag(downloadParamsTransform);
        downloadRequest.setDownloadEnablePause(downloadParamsTransform.downloadEnablePause);
        if (ServiceProvider.CF().showNotification && aV(mContext)) {
            i2 = 3;
        }
        downloadRequest.setNotificationVisibility(i2);
        com.ksad.download.kwai.a.a(mContext, downloadParamsTransform.mDownloadid, downloadRequest);
    }

    private static boolean a(String str, File file, b bVar, int i2) throws Throwable {
        C0437a c0437a = null;
        try {
            C0437a c0437a2 = new C0437a(file, false);
            try {
                boolean zA = a(str, (String) null, c0437a2, (b) null, 0);
                com.kwad.sdk.crash.utils.b.closeQuietly(c0437a2);
                return zA;
            } catch (Throwable th) {
                th = th;
                c0437a = c0437a2;
                com.kwad.sdk.crash.utils.b.closeQuietly(c0437a);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean a(String str, File file, b bVar, int i2, boolean z2) throws Throwable {
        C0437a c0437a;
        C0437a c0437a2 = null;
        try {
            c0437a = new C0437a(file, true);
        } catch (Throwable th) {
            th = th;
        }
        try {
            boolean zA = a(str, (String) null, (c) c0437a, (b) null, -1, file.length(), -1L, true);
            com.kwad.sdk.crash.utils.b.closeQuietly(c0437a);
            return zA;
        } catch (Throwable th2) {
            th = th2;
            c0437a2 = c0437a;
            com.kwad.sdk.crash.utils.b.closeQuietly(c0437a2);
            throw th;
        }
    }

    private static boolean a(String str, String str2, c cVar, b bVar, int i2) {
        return a(str, (String) null, cVar, bVar, i2, -1L, -1L, false);
    }

    private static boolean a(String str, String str2, c cVar, b bVar, int i2, long j2, long j3, boolean z2) throws Throwable {
        HttpURLConnection httpURLConnection;
        try {
            httpURLConnection = (HttpURLConnection) a(str, 10000, i2 > 0 ? i2 : 120000, false);
            try {
                if (httpURLConnection == null) {
                    throw new IOException("Fail to createUrlConnection");
                }
                boolean zA = a(httpURLConnection, str2, cVar, bVar, i2, j2, -1L, z2);
                com.kwad.sdk.crash.utils.b.closeQuietly(cVar);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return zA;
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(cVar);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0041 A[Catch: all -> 0x0131, TryCatch #0 {all -> 0x0131, blocks: (B:5:0x0010, B:7:0x0021, B:9:0x0028, B:10:0x0031, B:12:0x0041, B:14:0x0052, B:20:0x006d), top: B:78:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0080 A[Catch: all -> 0x012e, TryCatch #6 {all -> 0x012e, blocks: (B:21:0x0076, B:23:0x0080, B:25:0x008f, B:29:0x00a1, B:24:0x0086), top: B:89:0x0076 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0086 A[Catch: all -> 0x012e, TryCatch #6 {all -> 0x012e, blocks: (B:21:0x0076, B:23:0x0080, B:25:0x008f, B:29:0x00a1, B:24:0x0086), top: B:89:0x0076 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a1 A[Catch: all -> 0x012e, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x012e, blocks: (B:21:0x0076, B:23:0x0080, B:25:0x008f, B:29:0x00a1, B:24:0x0086), top: B:89:0x0076 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010e A[Catch: all -> 0x0126, LOOP:1: B:43:0x0108->B:45:0x010e, LOOP_END, TRY_LEAVE, TryCatch #2 {all -> 0x0126, blocks: (B:36:0x00ed, B:42:0x0103, B:43:0x0108, B:45:0x010e), top: B:81:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0138 A[Catch: all -> 0x0162, TryCatch #1 {all -> 0x0162, blocks: (B:63:0x0134, B:65:0x0138, B:67:0x0161, B:66:0x013b), top: B:79:0x0134 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x013b A[Catch: all -> 0x0162, TryCatch #1 {all -> 0x0162, blocks: (B:63:0x0134, B:65:0x0138, B:67:0x0161, B:66:0x013b), top: B:79:0x0134 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0112 A[EDGE_INSN: B:92:0x0112->B:47:0x0112 BREAK  A[LOOP:1: B:43:0x0108->B:45:0x010e], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.net.HttpURLConnection r14, java.lang.String r15, com.kwad.sdk.core.download.a.c r16, com.kwad.sdk.core.download.a.b r17, int r18, long r19, long r21, boolean r23) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 377
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.download.a.a(java.net.HttpURLConnection, java.lang.String, com.kwad.sdk.core.download.a$c, com.kwad.sdk.core.download.a$b, int, long, long, boolean):boolean");
    }

    public static synchronized void aU(Context context) {
        if (context != null) {
            if (!mHasInit) {
                mContext = context;
                com.ksad.download.c.M().init(context);
                com.kwad.sdk.core.download.c.vG().init(context);
                mHasInit = true;
            }
        }
    }

    private static boolean aV(Context context) {
        try {
            new NotificationCompat.Builder(context, "");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String bw(String str) {
        return ac.el(str) + com.anythink.china.common.a.a.f6395g;
    }

    public static void bx(String str) {
        if (mContext == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.ksad.download.kwai.a.e(mContext, str);
    }

    public static void c(int i2, AdTemplate adTemplate) {
        com.kwad.sdk.core.download.b bVar = (com.kwad.sdk.core.download.b) ServiceProvider.get(com.kwad.sdk.core.download.b.class);
        if (bVar != null) {
            bVar.b(1, adTemplate);
        }
    }

    public static boolean c(String str, File file) {
        try {
            return a(str, file, (b) null, 0);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            return false;
        }
    }
}
