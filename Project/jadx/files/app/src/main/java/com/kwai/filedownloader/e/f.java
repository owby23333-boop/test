package com.kwai.filedownloader.e;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.text.TextUtils;
import com.kwad.sdk.utils.ao;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class f {
    private static int aIc = 65536;
    private static long aId = 2000;
    private static String aIe;
    private static Boolean aIf;
    private static Boolean aIg;
    private static final Pattern aIh = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");

    private static int IR() {
        return aIc;
    }

    private static long IS() {
        return aId;
    }

    private static String IT() {
        if (TextUtils.isEmpty(aIe)) {
            return (c.IN().getExternalCacheDir() == null ? Environment.getDownloadCacheDirectory() : c.IN().getExternalCacheDir()).getAbsolutePath();
        }
        return aIe;
    }

    public static boolean IU() {
        ConnectivityManager connectivityManager = (ConnectivityManager) c.IN().getSystemService("connectivity");
        if (connectivityManager == null) {
            d.h(f.class, "failed to get connectivity manager!", new Object[0]);
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo == null || activeNetworkInfo.getType() != 1;
    }

    public static String IV() {
        return j("FileDownloader/%s", "3.3.38");
    }

    public static String a(int i2, com.kwai.filedownloader.kwai.b bVar) {
        if (bVar == null) {
            throw new RuntimeException("connection is null when findEtag");
        }
        String strO = bVar.o(DownloadUtils.ETAG);
        if (d.aHT) {
            d.g(f.class, "etag find %s for task(%d)", strO, Integer.valueOf(i2));
        }
        return strO;
    }

    public static String a(com.kwai.filedownloader.kwai.b bVar, String str) {
        String strFl = fl(bVar.o(DownloadUtils.CONTENT_DISPOSITION));
        if (TextUtils.isEmpty(strFl)) {
            strFl = fj(str);
        }
        return strFl.replaceAll("\\/", "_");
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
        return al(str, str2);
    }

    private static boolean a(int i2, com.kwai.filedownloader.c.c cVar, Boolean bool) {
        if (cVar == null) {
            if (d.aHT) {
                d.g(f.class, "can't continue %d model == null", Integer.valueOf(i2));
            }
            return false;
        }
        if (cVar.HH() != null) {
            return a(i2, cVar, cVar.HH(), null);
        }
        if (d.aHT) {
            d.g(f.class, "can't continue %d temp path == null", Integer.valueOf(i2));
        }
        return false;
    }

    public static boolean a(int i2, com.kwai.filedownloader.c.c cVar, String str, Boolean bool) {
        if (str == null) {
            if (!d.aHT) {
                return false;
            }
            d.g(f.class, "can't continue %d path = null", Integer.valueOf(i2));
            return false;
        }
        File file = new File(str);
        boolean zExists = file.exists();
        boolean zIsDirectory = file.isDirectory();
        if (!zExists || zIsDirectory) {
            if (!d.aHT) {
                return false;
            }
            d.g(f.class, "can't continue %d file not suit, exists[%B], directory[%B]", Integer.valueOf(i2), Boolean.valueOf(zExists), Boolean.valueOf(zIsDirectory));
            return false;
        }
        long length = file.length();
        long jIp = cVar.Ip();
        if (cVar.Ir() <= 1 && jIp == 0) {
            if (!d.aHT) {
                return false;
            }
            d.g(f.class, "can't continue %d the downloaded-record is zero.", Integer.valueOf(i2));
            return false;
        }
        long total = cVar.getTotal();
        if (length < jIp || (total != -1 && (length > total || jIp >= total))) {
            if (!d.aHT) {
                return false;
            }
            d.g(f.class, "can't continue %d dirty data fileLength[%d] sofar[%d] total[%d]", Integer.valueOf(i2), Long.valueOf(length), Long.valueOf(jIp), Long.valueOf(total));
            return false;
        }
        if (bool == null || bool.booleanValue() || total != length) {
            return true;
        }
        if (!d.aHT) {
            return false;
        }
        d.g(f.class, "can't continue %d, because of the output stream doesn't support seek, but the task has already pre-allocated, so we only can download it from the very beginning.", Integer.valueOf(i2));
        return false;
    }

    private static String al(String str, String str2) {
        if (str2 == null) {
            throw new IllegalStateException("can't generate real path, the file name is null");
        }
        if (str != null) {
            return j("%s%s%s", str, File.separator, str2);
        }
        throw new IllegalStateException("can't generate real path, the directory is null");
    }

    public static int am(String str, String str2) {
        return com.kwai.filedownloader.download.b.Ht().Hu().k(str, str2, false);
    }

    public static void an(String str, String str2) {
        fr(str2);
        fs(str);
    }

    public static void ar(long j2) throws IllegalAccessException {
        if (!dz(c.IN())) {
            throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-time'.");
        }
        aId = j2;
    }

    public static long b(int i2, com.kwai.filedownloader.kwai.b bVar) {
        long jFp = fp(bVar.o("Content-Length"));
        String strO = bVar.o(DownloadUtils.TRANSFER_ENCODING);
        if (jFp >= 0) {
            return jFp;
        }
        if (strO != null && strO.equals(DownloadUtils.VALUE_CHUNKED)) {
            return -1L;
        }
        if (!e.IP().aHW) {
            throw new FileDownloadGiveUpRetryException("can't know the size of the download file, and its Transfer-Encoding is not Chunked either.\nyou can ignore such exception by add http.lenient=true to the filedownloader.properties");
        }
        if (!d.aHT) {
            return -1L;
        }
        d.g(f.class, "%d response header is not legal but HTTP lenient is true, so handle as the case of transfer encoding chunk", Integer.valueOf(i2));
        return -1L;
    }

    public static boolean b(int i2, com.kwai.filedownloader.c.c cVar) {
        return a(i2, cVar, (Boolean) null);
    }

    public static void dA(Context context) {
        File fileDB = dB(context);
        try {
            fileDB.getParentFile().mkdirs();
            fileDB.createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private static File dB(Context context) {
        return new File(context.getFilesDir().getAbsolutePath() + File.separator + "filedownloader", ".old_file_converted");
    }

    public static void df(int i2) throws IllegalAccessException {
        if (!dz(c.IN())) {
            throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-step'.");
        }
        aIc = i2;
    }

    public static boolean dz(Context context) {
        boolean zEndsWith;
        Boolean bool = aIf;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (e.IP().aHX) {
            zEndsWith = true;
        } else {
            if (((ActivityManager) context.getSystemService("activity")) == null) {
                d.h(f.class, "fail to get the activity manager!", new Object[0]);
                return false;
            }
            zEndsWith = ao.getProcessName(context).endsWith(":filedownloader");
        }
        Boolean boolValueOf = Boolean.valueOf(zEndsWith);
        aIf = boolValueOf;
        return boolValueOf.booleanValue();
    }

    public static String el(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b : bArrDigest) {
                int i2 = b & 255;
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

    public static String fi(String str) {
        return al(IT(), fj(str));
    }

    private static String fj(String str) {
        return el(str);
    }

    public static String fk(String str) {
        return j("%s.temp", str);
    }

    public static String fl(String str) {
        if (str == null) {
            return null;
        }
        try {
            Matcher matcher = aIh.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (IllegalStateException unused) {
        }
        return null;
    }

    public static String fm(String str) {
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

    public static String fn(String str) {
        return "FileDownloader-" + str;
    }

    public static boolean fo(String str) {
        return c.IN().checkCallingOrSelfPermission(str) == 0;
    }

    private static long fp(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static com.kwai.filedownloader.d.a fq(String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("found invalid internal destination path, empty");
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            file.delete();
            if (!file.createNewFile()) {
                throw new RuntimeException(j("found invalid internal destination path[%s], & path is directory[%B]", str, Boolean.valueOf(file.isDirectory())));
            }
        }
        if (file.exists() || file.createNewFile()) {
            return com.kwai.filedownloader.download.b.Ht().ab(file);
        }
        throw new IOException(j("create new file error  %s", file.getAbsolutePath()));
    }

    private static void fr(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static void fs(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static boolean h(long j2, long j3) {
        return j2 > ((long) IR()) && j3 > IS();
    }

    public static String j(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    public static int k(String str, String str2, boolean z2) {
        return com.kwai.filedownloader.download.b.Ht().Hu().k(str, str2, z2);
    }
}
