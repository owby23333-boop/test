package com.liulishuo.filedownloader.h0;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.liulishuo.filedownloader.exception.FileDownloadSecurityException;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: FileDownloadUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class f {
    private static int a = 65536;
    private static long b = 2000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f17213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Boolean f17214d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Pattern f17215e = Pattern.compile("attachment;\\s*filename\\*\\s*=\\s*\"*([^\"]*)'\\S*'([^\"]*)\"*");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pattern f17216f = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"*([^\"\\n]*)\"*");

    public static void a(int i2) throws IllegalAccessException {
        if (!c(c.a())) {
            throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-step'.");
        }
        a = i2;
    }

    public static String b() {
        if (!TextUtils.isEmpty(f17213c)) {
            return f17213c;
        }
        boolean z2 = false;
        if (c.a().getExternalCacheDir() != null && Environment.getExternalStorageState().equals("mounted") && Environment.getExternalStorageDirectory().getFreeSpace() > 0) {
            z2 = true;
        }
        return z2 ? c.a().getExternalCacheDir().getAbsolutePath() : c.a().getCacheDir().getAbsolutePath();
    }

    public static int c() {
        return a;
    }

    public static long d() {
        return b;
    }

    public static boolean e() {
        ConnectivityManager connectivityManager = (ConnectivityManager) c.a().getSystemService("connectivity");
        if (connectivityManager == null) {
            d.e(f.class, "failed to get connectivity manager!", new Object[0]);
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo == null || activeNetworkInfo.getType() != 1;
    }

    static String f(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                String path = new URL(str).getPath();
                String strSubstring = path.substring(path.lastIndexOf(47) + 1);
                if (strSubstring.isEmpty()) {
                    return null;
                }
                return strSubstring;
            } catch (MalformedURLException unused) {
            }
        }
        return null;
    }

    public static String g(String str) {
        return n(str);
    }

    public static String h(String str) {
        return b(b(), g(str));
    }

    public static long i(String str) {
        StatFs statFs = new StatFs(str);
        return Build.VERSION.SDK_INT >= 18 ? statFs.getAvailableBytes() : ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    public static String j(String str) {
        int length = str.length();
        int i2 = (File.separatorChar == '\\' && length > 2 && str.charAt(1) == ':') ? 2 : 0;
        int iLastIndexOf = str.lastIndexOf(File.separatorChar);
        int i3 = (iLastIndexOf != -1 || i2 <= 0) ? iLastIndexOf : 2;
        if (i3 == -1) {
            return null;
        }
        char cCharAt = str.charAt(length - 1);
        char c2 = File.separatorChar;
        if (cCharAt == c2) {
            return null;
        }
        return (str.indexOf(c2) == i3 && str.charAt(i2) == File.separatorChar) ? str.substring(0, i3 + 1) : str.substring(0, i3);
    }

    public static String k(String str) {
        return a("%s.temp", str);
    }

    public static String l(String str) {
        return "FileDownloader-" + str;
    }

    public static boolean m(String str) {
        return true;
    }

    public static String n(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b2 : bArrDigest) {
                int i2 = b2 & 255;
                if (i2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i2));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new RuntimeException("Huh, MD5 should be supported?", e3);
        }
    }

    public static String o(String str) {
        Matcher matcher;
        if (str == null) {
            return null;
        }
        try {
            matcher = f17215e.matcher(str);
        } catch (UnsupportedEncodingException | IllegalStateException unused) {
        }
        if (matcher.find()) {
            return URLDecoder.decode(matcher.group(2), matcher.group(1));
        }
        Matcher matcher2 = f17216f.matcher(str);
        if (matcher2.find()) {
            return matcher2.group(1);
        }
        return null;
    }

    public static long p(String str) {
        if (str != null && str.length() != 0) {
            try {
                Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(str);
                if (matcher.find()) {
                    return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                }
            } catch (Exception e2) {
                d.a(f.class, e2, "parse content length from content range error", new Object[0]);
            }
        }
        return -1L;
    }

    public static long q(String str) {
        if (str == null) {
            return -1L;
        }
        String[] strArrSplit = str.split("/");
        if (strArrSplit.length >= 2) {
            try {
                return Long.parseLong(strArrSplit[1]);
            } catch (NumberFormatException unused) {
                d.e(f.class, "parse instance length failed with %s", str);
            }
        }
        return -1L;
    }

    public static int c(String str, String str2) {
        return com.liulishuo.filedownloader.download.c.i().c().a(str, str2, false);
    }

    public static void d(Context context) {
        File fileA = a(context);
        try {
            fileA.getParentFile().mkdirs();
            fileA.createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void a(long j2) throws IllegalAccessException {
        if (c(c.a())) {
            b = j2;
            return;
        }
        throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-time'.");
    }

    public static boolean c(Context context) {
        Boolean bool = f17214d;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean zEndsWith = false;
        if (!e.a().f17208d) {
            int iMyPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                d.e(f.class, "fail to get the activity manager!", new Object[0]);
                return false;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == iMyPid) {
                        zEndsWith = next.processName.endsWith(":filedownloader");
                        break;
                    }
                }
            } else {
                d.e(f.class, "The running app process info list from ActivityManager is null or empty, maybe current App is not running.", new Object[0]);
                return false;
            }
        } else {
            zEndsWith = true;
        }
        f17214d = Boolean.valueOf(zEndsWith);
        return f17214d.booleanValue();
    }

    private static String d(com.liulishuo.filedownloader.d0.b bVar) {
        return bVar.getResponseHeaderField("Content-Range");
    }

    public static void e(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static int a(String str, String str2, boolean z2) {
        return com.liulishuo.filedownloader.download.c.i().c().a(str, str2, z2);
    }

    public static void d(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static String b(String str, String str2) {
        if (str2 == null) {
            throw new IllegalStateException("can't generate real path, the file name is null");
        }
        if (str != null) {
            return a("%s%s%s", str, File.separator, str2);
        }
        throw new IllegalStateException("can't generate real path, the directory is null");
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    public static boolean e(Context context) {
        return Build.VERSION.SDK_INT >= 26 && !b(context);
    }

    public static File a(Context context) {
        return new File(context.getFilesDir().getAbsolutePath() + File.separator + "filedownloader", ".old_file_converted");
    }

    public static String a(String str, boolean z2, String str2) {
        if (str == null) {
            return null;
        }
        if (!z2) {
            return str;
        }
        if (str2 == null) {
            return null;
        }
        return b(str, str2);
    }

    public static long b(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static boolean a(String str) {
        return c.a().checkCallingOrSelfPermission(str) == 0;
    }

    public static String b(int i2, com.liulishuo.filedownloader.d0.b bVar) {
        if (bVar != null) {
            String responseHeaderField = bVar.getResponseHeaderField(DownloadUtils.ETAG);
            if (d.a) {
                d.a(f.class, "etag find %s for task(%d)", responseHeaderField, Integer.valueOf(i2));
            }
            return responseHeaderField;
        }
        throw new RuntimeException("connection is null when findEtag");
    }

    public static long a(int i2, com.liulishuo.filedownloader.d0.b bVar) {
        long jB = b(bVar.getResponseHeaderField("Content-Length"));
        String responseHeaderField = bVar.getResponseHeaderField(DownloadUtils.TRANSFER_ENCODING);
        if (jB >= 0) {
            return jB;
        }
        if (responseHeaderField != null && responseHeaderField.equals(DownloadUtils.VALUE_CHUNKED)) {
            return -1L;
        }
        if (e.a().f17207c) {
            if (!d.a) {
                return -1L;
            }
            d.a(f.class, "%d response header is not legal but HTTP lenient is true, so handle as the case of transfer encoding chunk", Integer.valueOf(i2));
            return -1L;
        }
        throw new FileDownloadGiveUpRetryException("can't know the size of the download file, and its Transfer-Encoding is not Chunked either.\nyou can ignore such exception by add http.lenient=true to the filedownloader.properties");
    }

    public static long b(com.liulishuo.filedownloader.d0.b bVar) {
        long jC = c(bVar);
        if (jC < 0) {
            d.e(f.class, "don't get instance length fromContent-Range header", new Object[0]);
            jC = -1;
        }
        if (jC == 0 && e.a().f17212h) {
            return -1L;
        }
        return jC;
    }

    public static boolean c(int i2, com.liulishuo.filedownloader.d0.b bVar) {
        if (i2 == 206 || i2 == 1) {
            return true;
        }
        return "bytes".equals(bVar.getResponseHeaderField(DownloadUtils.ACCEPT_RANGES));
    }

    private static boolean b(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        PowerManager powerManager;
        ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null || (powerManager = (PowerManager) context.getSystemService("power")) == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT > 19) {
            if (!powerManager.isInteractive()) {
                return false;
            }
        } else if (!powerManager.isScreenOn()) {
            return false;
        }
        String packageName = context.getApplicationContext().getPackageName();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(packageName) && runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }

    public static long c(com.liulishuo.filedownloader.d0.b bVar) {
        return q(d(bVar));
    }

    public static com.liulishuo.filedownloader.g0.a c(String str) throws IOException {
        if (!TextUtils.isEmpty(str)) {
            if (m(str)) {
                File file = new File(str);
                if (file.exists() && file.isDirectory()) {
                    throw new RuntimeException(a("found invalid internal destination path[%s], & path is directory[%B]", str, Boolean.valueOf(file.isDirectory())));
                }
                if (!file.exists() && !file.createNewFile()) {
                    throw new IOException(a("create new file error  %s", file.getAbsolutePath()));
                }
                return com.liulishuo.filedownloader.download.c.i().a(file);
            }
            throw new RuntimeException(a("found invalid internal destination filename %s", str));
        }
        throw new RuntimeException("found invalid internal destination path, empty");
    }

    public static long a(com.liulishuo.filedownloader.d0.b bVar) {
        long jP = p(d(bVar));
        if (jP < 0) {
            return -1L;
        }
        return jP;
    }

    public static String a(com.liulishuo.filedownloader.d0.b bVar, String str) throws FileDownloadSecurityException {
        String strO = o(bVar.getResponseHeaderField(DownloadUtils.CONTENT_DISPOSITION));
        if (TextUtils.isEmpty(strO)) {
            strO = f(str);
        }
        if (TextUtils.isEmpty(strO)) {
            return g(str);
        }
        if (strO.contains("../")) {
            throw new FileDownloadSecurityException(a("The filename [%s] from the response is not allowable, because it contains '../', which can raise the directory traversal vulnerability", strO));
        }
        return strO;
    }

    public static boolean a(int i2, FileDownloadModel fileDownloadModel) {
        return a(i2, fileDownloadModel, (Boolean) null);
    }

    public static boolean a(int i2, FileDownloadModel fileDownloadModel, Boolean bool) {
        if (fileDownloadModel == null) {
            if (d.a) {
                d.a(f.class, "can't continue %d model == null", Integer.valueOf(i2));
            }
            return false;
        }
        if (fileDownloadModel.n() == null) {
            if (d.a) {
                d.a(f.class, "can't continue %d temp path == null", Integer.valueOf(i2));
            }
            return false;
        }
        return a(i2, fileDownloadModel, fileDownloadModel.n(), bool);
    }

    public static boolean a(int i2, FileDownloadModel fileDownloadModel, String str, Boolean bool) {
        if (str == null) {
            if (!d.a) {
                return false;
            }
            d.a(f.class, "can't continue %d path = null", Integer.valueOf(i2));
            return false;
        }
        File file = new File(str);
        boolean zExists = file.exists();
        boolean zIsDirectory = file.isDirectory();
        if (zExists && !zIsDirectory) {
            long length = file.length();
            long jG = fileDownloadModel.g();
            if (fileDownloadModel.a() <= 1 && jG == 0) {
                if (!d.a) {
                    return false;
                }
                d.a(f.class, "can't continue %d the downloaded-record is zero.", Integer.valueOf(i2));
                return false;
            }
            long jO = fileDownloadModel.o();
            if (length >= jG && (jO == -1 || (length <= jO && jG < jO))) {
                if (bool == null || bool.booleanValue() || jO != length) {
                    return true;
                }
                if (!d.a) {
                    return false;
                }
                d.a(f.class, "can't continue %d, because of the output stream doesn't support seek, but the task has already pre-allocated, so we only can download it from the very beginning.", Integer.valueOf(i2));
                return false;
            }
            if (!d.a) {
                return false;
            }
            d.a(f.class, "can't continue %d dirty data fileLength[%d] sofar[%d] total[%d]", Integer.valueOf(i2), Long.valueOf(length), Long.valueOf(jG), Long.valueOf(jO));
            return false;
        }
        if (!d.a) {
            return false;
        }
        d.a(f.class, "can't continue %d file not suit, exists[%B], directory[%B]", Integer.valueOf(i2), Boolean.valueOf(zExists), Boolean.valueOf(zIsDirectory));
        return false;
    }

    public static void a(String str, String str2) {
        e(str2);
        d(str);
    }

    public static boolean a(long j2, long j3) {
        return j2 > ((long) c()) && j3 > d();
    }

    public static String a() {
        return a("FileDownloader/%s", "1.7.7");
    }
}
