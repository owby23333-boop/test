package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
class l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f19037d = 5;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f19038e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f19039f = {"tbs_downloading_com.tencent.mtt", "tbs_downloading_com.tencent.mm", "tbs_downloading_com.tencent.mobileqq", "tbs_downloading_com.tencent.tbs", "tbs_downloading_com.qzone"};
    private Handler A;
    private boolean D;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Context f19041g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f19042h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f19043i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f19044j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private File f19045k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private File f19046l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f19047m;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f19050p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f19051q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f19052r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f19053s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f19054t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private HttpURLConnection f19055u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f19056v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final TbsLogReport.TbsLogInfo f19057w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f19058x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f19059y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f19060z;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f19040c = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f19048n = 30000;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f19049o = 20000;
    private boolean B = false;
    private int C = f19037d;
    String[] a = null;
    int b = 0;

    public l(Context context) throws NullPointerException {
        this.f19041g = context.getApplicationContext();
        this.f19057w = TbsLogReport.getInstance(this.f19041g).tbsLogInfo();
        this.f19056v = "tbs_downloading_" + this.f19041g.getPackageName();
        o.a();
        this.f19045k = o.r(this.f19041g);
        if (this.f19045k == null) {
            throw new NullPointerException("TbsCorePrivateDir is null!");
        }
        f();
        this.f19058x = null;
        this.f19059y = -1;
    }

    private long a(long j2, long j3) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f19057w.setDownConsumeTime(jCurrentTimeMillis - j2);
        this.f19057w.setDownloadSize(j3);
        return jCurrentTimeMillis;
    }

    private static File a(Context context, int i2) {
        File file = new File(FileUtil.a(context, i2));
        if (file.exists() && file.isDirectory()) {
            if (new File(file, TbsDownloader.getOverSea(context) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false)).exists()) {
                return file;
            }
        }
        return null;
    }

    private String a(Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        return stackTraceString.length() > 1024 ? stackTraceString.substring(0, 1024) : stackTraceString;
    }

    private void a(int i2, String str, boolean z2) {
        if (z2 || this.f19051q > this.C) {
            this.f19057w.setErrorCode(i2);
            this.f19057w.setFailDetail(str);
        }
    }

    private void a(long j2) {
        this.f19051q++;
        if (j2 <= 0) {
            try {
                j2 = m();
            } catch (Exception unused) {
                return;
            }
        }
        Thread.sleep(j2);
    }

    public static void a(Context context) {
        try {
            TbsLog.i(TbsDownloader.LOGTAG, "clearDecoupleDirOld #00");
            File fileA = o.a().a(context, context.getDir("tbs_64", 0));
            FileUtil.b(fileA);
            if (fileA != null) {
                TbsLog.i(TbsDownloader.LOGTAG, "clearDecoupleDirOld dir is " + fileA.getAbsolutePath());
            }
            File fileA2 = o.a().a(context, context.getDir("tbs", 0));
            FileUtil.b(fileA2);
            if (fileA2 != null) {
                TbsLog.i(TbsDownloader.LOGTAG, "clearDecoupleDirOld dir is " + fileA2.getAbsolutePath());
            }
        } catch (Throwable th) {
            TbsLog.i(TbsDownloader.LOGTAG, "clearDecoupleDirOld stack is " + Log.getStackTraceString(th));
        }
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void a(File file, Context context) {
        synchronized (com.tencent.smtt.utils.a.class) {
            if (file != null) {
                if (file.exists()) {
                    if (TbsShareManager.isThirdPartyApp(context)) {
                        return;
                    }
                    try {
                        File fileC = c(context);
                        if (fileC != null) {
                            File file2 = new File(fileC, TbsDownloader.getOverSea(context) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false));
                            file2.delete();
                            FileUtil.b(file, file2);
                            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupTbsApk]tbsApk is " + file.getAbsolutePath());
                            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupTbsApk]backUpApk is " + file2.getAbsolutePath());
                            boolean zContains = file2.getName().contains("tbs.org");
                            boolean zContains2 = file2.getName().contains("x5.tbs.decouple");
                            if (zContains2 || zContains) {
                                File[] fileArrListFiles = fileC.listFiles();
                                Pattern patternCompile = Pattern.compile(com.tencent.smtt.utils.a.a(zContains2) + "(.*)");
                                for (File file3 : fileArrListFiles) {
                                    if (patternCompile.matcher(file3.getName()).find() && file3.isFile() && file3.exists()) {
                                        file3.delete();
                                    }
                                }
                                File file4 = new File(fileC, com.tencent.smtt.utils.a.a(zContains2) + "." + TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                                if (file4.exists()) {
                                    TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupTbsApk]delete bacup config file error ");
                                    return;
                                }
                                file4.createNewFile();
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    private void a(String str) throws Exception {
        URL url = new URL(str);
        HttpURLConnection httpURLConnection = this.f19055u;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                TbsLog.e(TbsDownloader.LOGTAG, "[initHttpRequest] mHttpRequest.disconnect() Throwable:" + th.toString());
            }
        }
        this.f19055u = (HttpURLConnection) url.openConnection();
        this.f19055u.setRequestProperty("User-Agent", TbsDownloader.b(this.f19041g));
        this.f19055u.setRequestProperty("Accept-Encoding", "identity");
        this.f19055u.setRequestMethod("GET");
        this.f19055u.setInstanceFollowRedirects(false);
        this.f19055u.setConnectTimeout(this.f19049o);
        this.f19055u.setReadTimeout(this.f19048n);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a4, code lost:
    
        if (r10 != r8) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(boolean r13, boolean r14, java.io.File r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 523
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.l.a(boolean, boolean, java.io.File):boolean");
    }

    public static void b(Context context) {
        if (TbsShareManager.isThirdPartyApp(context) || com.tencent.smtt.utils.s.f(context)) {
            try {
                TbsLog.i(TbsDownloader.LOGTAG, "clearOldBackup #00");
                if (FileUtil.a(context)) {
                    String str = Environment.getExternalStorageDirectory() + File.separator;
                    if (!str.equals("")) {
                        str = str + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + context.getApplicationInfo().packageName;
                    }
                    File file = new File(str);
                    FileUtil.b(file);
                    TbsLog.i(TbsDownloader.LOGTAG, "clearOldBackup dir is " + file.getAbsolutePath());
                }
            } catch (Throwable th) {
                TbsLog.i(TbsDownloader.LOGTAG, "clearOldBackup stack is " + Log.getStackTraceString(th));
            }
        }
    }

    private boolean b(boolean z2, boolean z3) {
        return a(z2, z3, (File) null);
    }

    @TargetApi(8)
    static File c(Context context) {
        try {
            File file = Build.VERSION.SDK_INT >= 8 ? new File(FileUtil.a(context, 4)) : null;
            if (file != null && !file.exists() && !file.isDirectory()) {
                file.mkdirs();
            }
            return file;
        } catch (Exception e2) {
            e2.printStackTrace();
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupApkPath] Exception is " + e2.getMessage());
            return null;
        }
    }

    @TargetApi(8)
    static File d(Context context) {
        try {
            if (Build.VERSION.SDK_INT < 8) {
                return null;
            }
            File fileA = a(context, 4);
            if (fileA == null) {
                fileA = a(context, 3);
            }
            if (fileA == null) {
                fileA = a(context, 2);
            }
            return fileA == null ? a(context, 1) : fileA;
        } catch (Exception e2) {
            e2.printStackTrace();
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupApkPath] Exception is " + e2.getMessage());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0134  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(boolean r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 624
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.l.d(boolean):void");
    }

    public static void e(Context context) {
        try {
            o.a();
            File fileR = o.r(context);
            new File(fileR, "x5.tbs").delete();
            new File(fileR, "x5.tbs.temp").delete();
            File fileC = c(context);
            if (fileC != null) {
                new File(fileC, TbsDownloader.getBackupFileName(false)).delete();
                new File(fileC, "x5.oversea.tbs.org").delete();
                File[] fileArrListFiles = fileC.listFiles();
                Pattern patternCompile = Pattern.compile(com.tencent.smtt.utils.a.a(true) + "(.*)");
                for (File file : fileArrListFiles) {
                    if (patternCompile.matcher(file.getName()).find() && file.isFile() && file.exists()) {
                        file.delete();
                    }
                }
                Pattern patternCompile2 = Pattern.compile(com.tencent.smtt.utils.a.a(false) + "(.*)");
                for (File file2 : fileArrListFiles) {
                    if (patternCompile2.matcher(file2.getName()).find() && file2.isFile() && file2.exists()) {
                        file2.delete();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private boolean e(boolean z2) {
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.deleteFile] isApk=" + z2);
        File file = z2 ? new File(this.f19045k, "x5.tbs") : new File(this.f19045k, "x5.tbs.temp");
        if (file.exists()) {
            FileUtil.b(file);
        }
        return true;
    }

    private void f() {
        this.f19051q = 0;
        this.f19052r = 0;
        this.f19047m = -1L;
        this.f19044j = null;
        this.f19050p = false;
        this.f19053s = false;
        this.f19054t = false;
        this.f19060z = false;
    }

    private void g() {
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.closeHttpRequest]");
        HttpURLConnection httpURLConnection = this.f19055u;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                TbsLog.e(TbsDownloader.LOGTAG, "[closeHttpRequest] mHttpRequest.disconnect() Throwable:" + th.toString());
            }
            this.f19055u = null;
        }
        int i2 = this.f19057w.a;
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.closeHttpRequest] download finish code: " + i2);
        if (!this.f19053s && this.f19060z) {
            h();
        } else if (!this.f19040c) {
            TbsDownloader.a = false;
        }
        QbSdk.f18849n.onDownloadFinish(i2);
    }

    private void h() {
        this.f19057w.setEventTime(System.currentTimeMillis());
        String apnInfo = Apn.getApnInfo(this.f19041g);
        if (apnInfo == null) {
            apnInfo = "";
        }
        int apnType = Apn.getApnType(this.f19041g);
        this.f19057w.setApn(apnInfo);
        this.f19057w.setNetworkType(apnType);
        if (apnType != this.f19059y || !apnInfo.equals(this.f19058x)) {
            this.f19057w.setNetworkChange(0);
        }
        int i2 = this.f19057w.a;
        if ((i2 == 0 || i2 == 107) && this.f19057w.getDownFinalFlag() == 0 && (!Apn.isNetworkAvailable(this.f19041g) || !l())) {
            a(101, (String) null, true);
        }
        TbsLogReport.getInstance(this.f19041g).eventReport(TbsLogReport.EventType.TYPE_CDN_DOWNLOAD_STAT, this.f19057w);
        this.f19057w.resetArgs();
    }

    private void i() {
        int apnType = Apn.getApnType(this.f19041g);
        String apnInfo = Apn.getApnInfo(this.f19041g);
        if (this.f19058x != null || this.f19059y != -1) {
            if (apnType == this.f19059y && apnInfo.equals(this.f19058x)) {
                return;
            } else {
                this.f19057w.setNetworkChange(0);
            }
        }
        this.f19058x = apnInfo;
        this.f19059y = apnType;
    }

    private boolean j() {
        return new File(this.f19045k, "x5.tbs.temp").exists();
    }

    private long k() {
        File file = new File(this.f19045k, "x5.tbs.temp");
        if (file.exists()) {
            return file.length();
        }
        return 0L;
    }

    private boolean l() {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        boolean z2 = false;
        Closeable closeable = null;
        try {
            InputStream inputStream = Runtime.getRuntime().exec("ping www.qq.com").getInputStream();
            try {
                inputStreamReader = new InputStreamReader(inputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    int i2 = 0;
                    do {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            if (line.contains("TTL") || line.contains("ttl")) {
                                z2 = true;
                                break;
                            }
                            i2++;
                        } catch (Throwable th) {
                            closeable = inputStream;
                            th = th;
                            try {
                                th.printStackTrace();
                                a(closeable);
                            } catch (Throwable th2) {
                                a(closeable);
                                a(inputStreamReader);
                                a(bufferedReader);
                                throw th2;
                            }
                        }
                    } while (i2 < 5);
                    a(inputStream);
                } catch (Throwable th3) {
                    closeable = inputStream;
                    th = th3;
                    bufferedReader = null;
                }
            } catch (Throwable th4) {
                bufferedReader = null;
                closeable = inputStream;
                th = th4;
                inputStreamReader = null;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStreamReader = null;
            bufferedReader = null;
        }
        a(inputStreamReader);
        a(bufferedReader);
        return z2;
    }

    private long m() {
        int i2 = this.f19051q;
        return (i2 == 1 || i2 == 2) ? ((long) this.f19051q) * 20000 : (i2 == 3 || i2 == 4) ? 100000L : 200000L;
    }

    private boolean n() {
        HttpURLConnection httpURLConnection;
        boolean z2;
        boolean z3 = Apn.getApnType(this.f19041g) == 3;
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] isWifi=" + z3);
        if (z3) {
            try {
                httpURLConnection = (HttpURLConnection) new URL("https://pms.mb.qq.com/rsp204").openConnection();
            } catch (Throwable th) {
                th = th;
                httpURLConnection = null;
            }
            try {
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.getInputStream();
                int responseCode = httpURLConnection.getResponseCode();
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] responseCode=" + responseCode);
                z2 = responseCode == 204;
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception unused2) {
                        }
                    }
                    z2 = false;
                } catch (Throwable th3) {
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th3;
                }
            }
        } else {
            z2 = false;
        }
        if (z2) {
            this.B = true;
        } else {
            this.B = false;
            this.A.sendMessageDelayed(this.A.obtainMessage(TbsListener.ErrorCode.STARTDOWNLOAD_API_LEVEL_BELOW_FROYO, null), 120000L);
        }
        return z2;
    }

    public Bundle a(int i2, File file, boolean z2) {
        File file2;
        if (z2) {
            file2 = new File(file, TbsDownloader.getBackupFileName(true));
        } else {
            file2 = new File(file, TbsDownloader.getOverSea(this.f19041g) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false));
        }
        int iA = com.tencent.smtt.utils.a.a(this.f19041g, file2);
        File file3 = new File(this.f19045k, "x5.tbs");
        String absolutePath = file3.exists() ? file3.getAbsolutePath() : null;
        int i3 = TbsDownloadConfig.getInstance(this.f19041g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        Bundle bundle = new Bundle();
        bundle.putInt("operation", i2);
        bundle.putInt("old_core_ver", iA);
        bundle.putInt("new_core_ver", i3);
        bundle.putString("old_apk_location", file2.getAbsolutePath());
        bundle.putString("new_apk_location", absolutePath);
        bundle.putString("diff_file_location", absolutePath);
        return bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.os.Bundle a(int r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.l.a(int, boolean):android.os.Bundle");
    }

    public void a() {
        this.f19053s = true;
        if (TbsShareManager.isThirdPartyApp(this.f19041g)) {
            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(this.f19041g).tbsLogInfo();
            tbsLogInfo.setErrorCode(-309);
            tbsLogInfo.setFailDetail(new Exception());
            TbsLogReport.getInstance(this.f19041g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
        }
    }

    public void a(int i2) {
        if (o.a().s(this.f19041g)) {
            o.a().c();
            try {
                File file = new File(this.f19045k, "x5.tbs");
                int iA = com.tencent.smtt.utils.a.a(this.f19041g, file);
                if (-1 == iA || (i2 > 0 && i2 == iA)) {
                    FileUtil.b(file);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void a(boolean z2) {
        a(z2, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:191:0x04fb, code lost:
    
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.f19041g).setDownloadInterruptCode(-315);
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x0506, code lost:
    
        if (r40 != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x05b6, code lost:
    
        a(113, "tbsApkFileSize=" + r10 + "  but contentLength=" + r39.f19047m, true);
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.f19041g).setDownloadInterruptCode(-310);
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x05e1, code lost:
    
        a(101, "WifiNetworkUnAvailable", true);
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.f19041g).setDownloadInterruptCode(anet.channel.util.ErrorConstant.ERROR_TNET_REQUEST_FAIL);
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x05f4, code lost:
    
        if (r40 != false) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x05f6, code lost:
    
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.f19041g).mSyncMap.put(r9, java.lang.Long.valueOf(r5));
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.f19041g).commit();
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x060e, code lost:
    
        r15 = r4;
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x06f1, code lost:
    
        com.tencent.smtt.utils.TbsLog.i(r7, "STEP 1/2 begin downloading...Canceled!", true);
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.f19041g).setDownloadInterruptCode(-309);
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x0702, code lost:
    
        r15 = r4;
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x0773, code lost:
    
        com.tencent.smtt.utils.TbsLog.i(r17, "STEP 1/2 begin downloading...failed because you exceeded max flow!", true);
        a(112, "downloadFlow=" + r6 + " downloadMaxflow=" + r12, true);
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.f19041g).setDownloadInterruptCode(-307);
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x07a0, code lost:
    
        r26 = r6;
        r6 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x07a5, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x07a6, code lost:
    
        r5 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x07ad, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x07ae, code lost:
    
        r5 = r3;
        r15 = r4;
        r26 = r6;
        r6 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:389:0x0953, code lost:
    
        if (r40 != false) goto L391;
     */
    /* JADX WARN: Code restructure failed: missing block: B:390:0x0955, code lost:
    
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.f19041g).mSyncMap.put(r9, java.lang.Long.valueOf(r26));
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.f19041g).commit();
     */
    /* JADX WARN: Code restructure failed: missing block: B:391:0x096d, code lost:
    
        r16 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0145, code lost:
    
        r2.setDownloadInterruptCode(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0148, code lost:
    
        r7 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01e4, code lost:
    
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.f19041g).mSyncMap.put(r9, java.lang.Long.valueOf(r5));
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.f19041g).commit();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:237:0x064c  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x06b8  */
    /* JADX WARN: Removed duplicated region for block: B:402:0x0996 A[Catch: all -> 0x0a90, TryCatch #29 {all -> 0x0a90, blocks: (B:400:0x098f, B:402:0x0996, B:406:0x099e, B:408:0x09a6, B:414:0x0a0a, B:419:0x0a1a, B:422:0x0a22, B:428:0x0a51), top: B:526:0x098f }] */
    /* JADX WARN: Removed duplicated region for block: B:426:0x0a35 A[PHI: r6 r15 r16 r26 r31
  0x0a35: PHI (r6v16 java.lang.String) = (r6v15 java.lang.String), (r6v39 java.lang.String) binds: [B:425:0x0a33, B:350:0x08c6] A[DONT_GENERATE, DONT_INLINE]
  0x0a35: PHI (r15v12 boolean) = (r15v11 boolean), (r15v39 boolean) binds: [B:425:0x0a33, B:350:0x08c6] A[DONT_GENERATE, DONT_INLINE]
  0x0a35: PHI (r16v10 boolean) = (r16v2 boolean), (r16v16 boolean) binds: [B:425:0x0a33, B:350:0x08c6] A[DONT_GENERATE, DONT_INLINE]
  0x0a35: PHI (r26v9 long) = (r26v8 long), (r26v34 long) binds: [B:425:0x0a33, B:350:0x08c6] A[DONT_GENERATE, DONT_INLINE]
  0x0a35: PHI (r31v8 long) = (r31v7 long), (r31v29 long) binds: [B:425:0x0a33, B:350:0x08c6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:427:0x0a4e  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x0a6d  */
    /* JADX WARN: Removed duplicated region for block: B:452:0x0abd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:465:0x0b32  */
    /* JADX WARN: Removed duplicated region for block: B:492:0x0be3  */
    /* JADX WARN: Removed duplicated region for block: B:499:0x0bf9  */
    /* JADX WARN: Removed duplicated region for block: B:585:0x0b10 A[EDGE_INSN: B:585:0x0b10->B:460:0x0b10 BREAK  A[LOOP:0: B:37:0x0137->B:586:0x0137], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r39v0, types: [com.tencent.smtt.sdk.l] */
    /* JADX WARN: Type inference failed for: r3v12, types: [com.tencent.smtt.sdk.TbsLogReport$TbsLogInfo] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r40, boolean r41) {
        /*
            Method dump skipped, instruction units count: 3150
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.l.a(boolean, boolean):void");
    }

    public void b() {
        a();
        e(false);
        e(true);
    }

    public boolean b(boolean z2) {
        String[] strArr;
        int i2;
        if ((z2 && !n() && (!QbSdk.canDownloadWithoutWifi() || !Apn.isNetworkAvailable(this.f19041g))) || (strArr = this.a) == null || (i2 = this.b) < 0 || i2 >= strArr.length) {
            return false;
        }
        this.b = i2 + 1;
        this.f19044j = strArr[i2];
        this.f19051q = 0;
        this.f19052r = 0;
        this.f19047m = -1L;
        this.f19050p = false;
        this.f19053s = false;
        this.f19054t = false;
        this.f19060z = false;
        return true;
    }

    public int c(boolean z2) {
        File fileC = c(this.f19041g);
        if (z2) {
            if (fileC == null) {
                return 0;
            }
            return com.tencent.smtt.utils.a.a(this.f19041g, new File(fileC, TbsDownloader.getBackupFileName(true)));
        }
        if (fileC == null) {
            return 0;
        }
        Context context = this.f19041g;
        return com.tencent.smtt.utils.a.a(context, new File(fileC, TbsDownloader.getOverSea(context) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false)));
    }

    public boolean c() {
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=" + this.D);
        return this.D;
    }

    void d() {
        TbsLog.i(TbsDownloader.LOGTAG, "pauseDownload,isPause=" + this.f19040c + "isDownloading=" + TbsDownloader.isDownloading());
        if (this.f19040c || !TbsDownloader.isDownloading()) {
            return;
        }
        a();
        this.f19040c = true;
        this.f19060z = false;
    }

    void e() {
        TbsLog.i(TbsDownloader.LOGTAG, "resumeDownload,isPause=" + this.f19040c + "isDownloading=" + TbsDownloader.isDownloading());
        if (this.f19040c && TbsDownloader.isDownloading()) {
            this.f19040c = false;
            a(false);
        }
    }
}
