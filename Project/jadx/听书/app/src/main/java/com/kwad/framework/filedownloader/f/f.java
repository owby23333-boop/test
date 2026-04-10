package com.kwad.framework.filedownloader.f;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.common.net.HttpHeaders;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.sdk.utils.ay;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class f {
    private static int apM = 65536;
    private static long apN = 2000;
    private static String apO;
    private static Boolean apP;
    private static Boolean apQ;
    private static final Pattern apR = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");

    public static void cf(int i) throws IllegalAccessException {
        if (aJ(c.zz())) {
            apM = i;
            return;
        }
        throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-step'.");
    }

    public static void ac(long j) throws IllegalAccessException {
        if (aJ(c.zz())) {
            apN = j;
            return;
        }
        throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-time'.");
    }

    private static int zD() {
        return apM;
    }

    private static long zE() {
        return apN;
    }

    private static String zF() {
        if (!TextUtils.isEmpty(apO)) {
            return apO;
        }
        if (c.zz().getExternalCacheDir() == null) {
            return Environment.getDownloadCacheDirectory().getAbsolutePath();
        }
        return c.zz().getExternalCacheDir().getAbsolutePath();
    }

    public static String bB(String str) {
        return A(zF(), bC(str));
    }

    private static String bC(String str) {
        return md5(str);
    }

    private static String A(String str, String str2) {
        if (str2 == null) {
            throw new IllegalStateException("can't generate real path, the file name is null");
        }
        if (str == null) {
            throw new IllegalStateException("can't generate real path, the directory is null");
        }
        return c("%s%s%s", str, File.separator, str2);
    }

    public static String bD(String str) {
        return c("%s.temp", str);
    }

    public static int B(String str, String str2) {
        return com.kwad.framework.filedownloader.download.b.yc().yd().g(str, str2, false);
    }

    public static int g(String str, String str2, boolean z) {
        return com.kwad.framework.filedownloader.download.b.yc().yd().g(str, str2, z);
    }

    public static String md5(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b : bArrDigest) {
                int i = b & 255;
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("Huh, MD5 should be supported?", e2);
        }
    }

    public static boolean aJ(Context context) {
        boolean zEndsWith;
        Boolean bool = apP;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (e.zB().apH) {
            zEndsWith = true;
        } else {
            if (((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)) == null) {
                d.d(f.class, "fail to get the activity manager!", new Object[0]);
                return false;
            }
            zEndsWith = ay.getProcessName(context).endsWith(":filedownloader");
        }
        Boolean boolValueOf = Boolean.valueOf(zEndsWith);
        apP = boolValueOf;
        return boolValueOf.booleanValue();
    }

    public static String c(String str, Object... objArr) {
        try {
            return String.format(Locale.ENGLISH, str, objArr);
        } catch (Exception unused) {
            return str;
        }
    }

    public static void aK(Context context) {
        File fileAL = aL(context);
        try {
            fileAL.getParentFile().mkdirs();
            fileAL.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File aL(Context context) {
        return new File(context.getFilesDir().getAbsolutePath() + File.separator + "filedownloader", ".old_file_converted");
    }

    public static String bE(String str) {
        if (str == null) {
            return null;
        }
        try {
            Matcher matcher = apR.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (IllegalStateException unused) {
        }
        return null;
    }

    public static String a(String str, boolean z, String str2) {
        if (str == null) {
            return null;
        }
        if (!z) {
            return str;
        }
        if (str2 == null) {
            return null;
        }
        return A(str, str2);
    }

    public static String bF(String str) {
        int length = str.length();
        int i = (File.separatorChar == '\\' && length > 2 && str.charAt(1) == ':') ? 2 : 0;
        int iLastIndexOf = str.lastIndexOf(File.separatorChar);
        int i2 = (iLastIndexOf != -1 || i <= 0) ? iLastIndexOf : 2;
        if (i2 == -1 || str.charAt(length - 1) == File.separatorChar) {
            return null;
        }
        if (str.indexOf(File.separatorChar) == i2 && str.charAt(i) == File.separatorChar) {
            return str.substring(0, i2 + 1);
        }
        return str.substring(0, i2);
    }

    public static String bG(String str) {
        return "FileDownloader-" + str;
    }

    public static boolean zG() {
        ConnectivityManager connectivityManager = (ConnectivityManager) c.zz().getSystemService("connectivity");
        if (connectivityManager == null) {
            d.d(f.class, "failed to get connectivity manager!", new Object[0]);
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo == null || activeNetworkInfo.getType() != 1;
    }

    public static boolean bH(String str) {
        return c.zz().checkCallingOrSelfPermission(str) == 0;
    }

    private static long bI(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static String a(int i, com.kwad.framework.filedownloader.a.b bVar) {
        if (bVar == null) {
            throw new RuntimeException("connection is null when findEtag");
        }
        String strBn = bVar.bn("Etag");
        if (d.apD) {
            d.c(f.class, "etag find %s for task(%d)", strBn, Integer.valueOf(i));
        }
        return strBn;
    }

    public static long b(int i, com.kwad.framework.filedownloader.a.b bVar) {
        long jBI = bI(bVar.bn(HttpHeaders.CONTENT_LENGTH));
        String strBn = bVar.bn(HttpHeaders.TRANSFER_ENCODING);
        if (jBI < 0) {
            jBI = -1;
            if (!(strBn != null && strBn.equals("chunked"))) {
                if (e.zB().apG) {
                    if (d.apD) {
                        d.c(f.class, "%d response header is not legal but HTTP lenient is true, so handle as the case of transfer encoding chunk", Integer.valueOf(i));
                    }
                } else {
                    throw new FileDownloadGiveUpRetryException("can't know the size of the download file, and its Transfer-Encoding is not Chunked either.\nyou can ignore such exception by add http.lenient=true to the filedownloader.properties");
                }
            }
        }
        return jBI;
    }

    public static String a(com.kwad.framework.filedownloader.a.b bVar, String str) {
        String strBE = bE(bVar.bn(HttpHeaders.CONTENT_DISPOSITION));
        if (TextUtils.isEmpty(strBE)) {
            strBE = bC(str);
        }
        return strBE.replaceAll("\\/", "_");
    }

    public static com.kwad.framework.filedownloader.e.a bJ(String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("found invalid internal destination path, empty");
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            file.delete();
            if (!file.createNewFile()) {
                throw new RuntimeException(c("found invalid internal destination path[%s], & path is directory[%B]", str, Boolean.valueOf(file.isDirectory())));
            }
        }
        if (!file.exists() && !file.createNewFile()) {
            throw new IOException(c("create new file error  %s", file.getAbsolutePath()));
        }
        return com.kwad.framework.filedownloader.download.b.yc().b(file);
    }

    public static boolean b(int i, com.kwad.framework.filedownloader.d.c cVar) {
        return a(i, cVar, (Boolean) null);
    }

    private static boolean a(int i, com.kwad.framework.filedownloader.d.c cVar, Boolean bool) {
        if (cVar == null) {
            if (d.apD) {
                d.c(f.class, "can't continue %d model == null", Integer.valueOf(i));
            }
            return false;
        }
        if (cVar.yr() == null) {
            if (d.apD) {
                d.c(f.class, "can't continue %d temp path == null", Integer.valueOf(i));
            }
            return false;
        }
        return a(i, cVar, cVar.yr(), null);
    }

    public static boolean a(int i, com.kwad.framework.filedownloader.d.c cVar, String str, Boolean bool) {
        if (str == null) {
            if (d.apD) {
                d.c(f.class, "can't continue %d path = null", Integer.valueOf(i));
            }
        } else {
            File file = new File(str);
            boolean zExists = file.exists();
            boolean zIsDirectory = file.isDirectory();
            if (!zExists || zIsDirectory) {
                if (d.apD) {
                    d.c(f.class, "can't continue %d file not suit, exists[%B], directory[%B]", Integer.valueOf(i), Boolean.valueOf(zExists), Boolean.valueOf(zIsDirectory));
                }
            } else {
                long length = file.length();
                long jYZ = cVar.yZ();
                if (cVar.zc() <= 1 && jYZ == 0) {
                    if (d.apD) {
                        d.c(f.class, "can't continue %d the downloaded-record is zero.", Integer.valueOf(i));
                    }
                } else {
                    long total = cVar.getTotal();
                    if (length < jYZ || (total != -1 && (length > total || jYZ >= total))) {
                        if (d.apD) {
                            d.c(f.class, "can't continue %d dirty data fileLength[%d] sofar[%d] total[%d]", Integer.valueOf(i), Long.valueOf(length), Long.valueOf(jYZ), Long.valueOf(total));
                        }
                    } else {
                        if (bool == null || bool.booleanValue() || total != length) {
                            return true;
                        }
                        if (d.apD) {
                            d.c(f.class, "can't continue %d, because of the output stream doesn't support seek, but the task has already pre-allocated, so we only can download it from the very beginning.", Integer.valueOf(i));
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void C(String str, String str2) {
        bK(str2);
        bL(str);
    }

    private static void bK(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static void bL(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static boolean i(long j, long j2) {
        return j > ((long) zD()) && j2 > zE();
    }

    public static String zH() {
        return c("FileDownloader/%s", BuildConfig.VERSION_NAME);
    }
}
