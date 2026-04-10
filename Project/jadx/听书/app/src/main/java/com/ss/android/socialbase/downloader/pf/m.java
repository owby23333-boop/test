package com.ss.android.socialbase.downloader.pf;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.common.net.HttpHeaders;
import com.ss.android.socialbase.downloader.a.l;
import com.ss.android.socialbase.downloader.a.oq;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.internal.http2.StreamResetException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class m {
    private static ConnectivityManager fo = null;
    private static Boolean kb = null;
    private static Boolean uy = null;
    private static final String z = "m";
    private static final Pattern g = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");
    private static String dl = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile SparseArray<Boolean> f2110a = new SparseArray<>();
    private static volatile SparseArray<List<oq>> gc = new SparseArray<>();
    private static final char[] m = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static Pattern e = null;
    private static Pattern gz = null;

    public static boolean a(int i) {
        return i == 206 || i == 200;
    }

    public static boolean dl(int i) {
        return i == 200 || i == 201 || i == 0;
    }

    public static boolean g(long j) {
        return j == -1;
    }

    public static double z(long j) {
        return j / 1048576.0d;
    }

    public static boolean z(int i) {
        return i == 0 || i == 2;
    }

    public static String z(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        return z(bArr, 0, bArr.length);
    }

    public static String z(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        if (i < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2 * 2;
        char[] cArr = new char[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = bArr[i5 + i] & 255;
            int i7 = i4 + 1;
            char[] cArr2 = m;
            cArr[i4] = cArr2[i6 >> 4];
            i4 = i7 + 1;
            cArr[i7] = cArr2[i6 & 15];
        }
        return new String(cArr, 0, i3);
    }

    public static String z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            try {
                bArr[i] = (byte) (Integer.parseInt(str.substring(i2, i2 + 2), 16) & 255);
            } catch (Exception e2) {
                wp.z(e2);
            }
        }
        try {
            return new String(bArr, "utf-8");
        } catch (Exception e3) {
            wp.z(e3);
            return str;
        }
    }

    public static long z(com.ss.android.socialbase.downloader.fo.e eVar) {
        if (eVar == null) {
            return -1L;
        }
        String strG = g(eVar, HttpHeaders.CONTENT_LENGTH);
        if (TextUtils.isEmpty(strG) && z.z(1)) {
            return g(eVar);
        }
        try {
            return Long.parseLong(strG);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static long g(com.ss.android.socialbase.downloader.fo.e eVar) {
        if (eVar == null) {
            return -1L;
        }
        String strG = g(eVar, HttpHeaders.CONTENT_RANGE);
        if (TextUtils.isEmpty(strG)) {
            return -1L;
        }
        try {
            Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(strG);
            if (matcher.find()) {
                return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            }
        } catch (Exception e2) {
            com.ss.android.socialbase.downloader.m.z.a(z, "parse content-length from content-range failed " + e2);
        }
        return -1L;
    }

    public static long g(String str) {
        if (str == null) {
            return -1L;
        }
        String[] strArrSplit = str.split("/");
        if (strArrSplit.length >= 2) {
            try {
                return Long.parseLong(strArrSplit[1]);
            } catch (NumberFormatException unused) {
                com.ss.android.socialbase.downloader.m.z.a(z, "parse instance length failed with " + str);
            }
        }
        return -1L;
    }

    private static String uy(String str) {
        Matcher matcher;
        if (str == null) {
            return null;
        }
        try {
            if (e == null) {
                e = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
            }
            matcher = e.matcher(str);
        } catch (Exception unused) {
        }
        if (matcher.find()) {
            return matcher.group(1);
        }
        if (gz == null) {
            gz = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
        }
        Matcher matcher2 = gz.matcher(str);
        if (matcher2.find()) {
            return matcher2.group(1);
        }
        return null;
    }

    public static String z(com.ss.android.socialbase.downloader.fo.e eVar, String str) {
        String strUy = uy(eVar.z(HttpHeaders.CONTENT_DISPOSITION));
        return TextUtils.isEmpty(strUy) ? gc(str) : strUy;
    }

    public static com.ss.android.socialbase.downloader.e.e z(com.ss.android.socialbase.downloader.e.dl dlVar, String str, String str2, int i) throws com.ss.android.socialbase.downloader.gc.z {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new com.ss.android.socialbase.downloader.gc.z(1021, new IOException("path must be not empty"));
        }
        File file = new File(str, str2);
        if (file.exists() && file.isDirectory()) {
            throw new com.ss.android.socialbase.downloader.gc.z(1035, new IOException(String.format("path is :%s, path is directory:%B:", str, Boolean.valueOf(file.isDirectory()))));
        }
        if (!file.exists()) {
            try {
                File file2 = new File(str);
                if (!file2.exists() || !file2.isDirectory()) {
                    if (!file2.exists()) {
                        if (!file2.mkdirs() && !file2.exists()) {
                            boolean zMkdirs = false;
                            if (com.ss.android.socialbase.downloader.i.z.z(dlVar).z("opt_mkdir_failed", 0) != 1) {
                                throw new com.ss.android.socialbase.downloader.gc.z(1030, "download savePath directory can not created:" + str);
                            }
                            int i2 = 0;
                            while (!zMkdirs) {
                                int i3 = i2 + 1;
                                if (i2 >= 3) {
                                    break;
                                }
                                try {
                                    Thread.sleep(10L);
                                    zMkdirs = file2.mkdirs();
                                    i2 = i3;
                                } catch (InterruptedException unused) {
                                }
                            }
                            if (!zMkdirs) {
                                if (a(dlVar.kb()) < 16384) {
                                    throw new com.ss.android.socialbase.downloader.gc.z(1006, "download savePath directory can not created:" + str);
                                }
                                throw new com.ss.android.socialbase.downloader.gc.z(1030, "download savePath directory can not created:" + str);
                            }
                        }
                    } else {
                        file2.delete();
                        if (!file2.mkdirs() && !file2.exists()) {
                            throw new com.ss.android.socialbase.downloader.gc.z(1031, "download savePath is not directory:path=" + str);
                        }
                        throw new com.ss.android.socialbase.downloader.gc.z(1031, "download savePath is not directory:" + str);
                    }
                }
                file.createNewFile();
            } catch (IOException e2) {
                throw new com.ss.android.socialbase.downloader.gc.z(1036, e2);
            }
        }
        return new com.ss.android.socialbase.downloader.e.e(file, i);
    }

    public static List<com.ss.android.socialbase.downloader.e.g> z(List<com.ss.android.socialbase.downloader.e.g> list) {
        SparseArray sparseArray = new SparseArray();
        SparseArray sparseArray2 = new SparseArray();
        for (com.ss.android.socialbase.downloader.e.g gVar : list) {
            if (gVar != null) {
                if (gVar.a()) {
                    sparseArray.put(gVar.js(), gVar);
                    List<com.ss.android.socialbase.downloader.e.g> list2 = (List) sparseArray2.get(gVar.js());
                    if (list2 != null) {
                        Iterator<com.ss.android.socialbase.downloader.e.g> it = list2.iterator();
                        while (it.hasNext()) {
                            it.next().z(gVar);
                        }
                        gVar.z(list2);
                    }
                } else {
                    com.ss.android.socialbase.downloader.e.g gVar2 = (com.ss.android.socialbase.downloader.e.g) sparseArray.get(gVar.g());
                    if (gVar2 != null) {
                        List<com.ss.android.socialbase.downloader.e.g> listE = gVar2.e();
                        if (listE == null) {
                            listE = new ArrayList<>();
                            gVar2.z(listE);
                        }
                        gVar.z(gVar2);
                        listE.add(gVar);
                    } else {
                        List arrayList = (List) sparseArray2.get(gVar.g());
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            sparseArray2.put(gVar.g(), arrayList);
                        }
                        arrayList.add(gVar);
                    }
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList2.add(sparseArray.get(sparseArray.keyAt(i)));
        }
        return arrayList2.isEmpty() ? list : arrayList2;
    }

    public static String z(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return String.format("%s%s%s", str, File.separator, str2);
    }

    public static String g(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public static String dl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.format("%s.tp", str);
    }

    public static long g(List<com.ss.android.socialbase.downloader.e.g> list) {
        Iterator<com.ss.android.socialbase.downloader.e.g> it = list.iterator();
        long jPf = 0;
        while (it.hasNext()) {
            jPf += it.next().pf();
        }
        return jPf;
    }

    public static void z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        z(dlVar, true);
    }

    public static void z(com.ss.android.socialbase.downloader.e.dl dlVar, boolean z2) {
        if (dlVar == null) {
            return;
        }
        if (z2) {
            try {
                dl(dlVar.kb(), dlVar.gz());
            } catch (Throwable th) {
                wp.z(th);
                return;
            }
        }
        dl(dlVar.wp(), dlVar.i());
        if (dlVar.gl()) {
            g(dlVar);
        }
        if (z2) {
            String strGc = gc(dlVar.uy());
            if (TextUtils.isEmpty(strGc) || TextUtils.isEmpty(dlVar.kb()) || !dlVar.kb().contains(strGc)) {
                return;
            }
            kb(dlVar.kb());
        }
    }

    public static void g(com.ss.android.socialbase.downloader.e.dl dlVar) {
        com.ss.android.socialbase.downloader.i.z zVarZ;
        JSONObject jSONObjectA;
        if (dlVar == null || (jSONObjectA = (zVarZ = com.ss.android.socialbase.downloader.i.z.z(dlVar.e())).a("download_dir")) == null) {
            return;
        }
        String strOptString = jSONObjectA.optString("ins_desc");
        if (!TextUtils.isEmpty(strOptString)) {
            dl(dlVar.kb(), strOptString);
        }
        String strFo = dlVar.fo();
        if (TextUtils.isEmpty(strFo)) {
            strFo = dlVar.gz();
        }
        String strZ = z(strFo, zVarZ);
        String strKb = dlVar.kb();
        if (TextUtils.isEmpty(strZ) || TextUtils.isEmpty(strKb)) {
            return;
        }
        File file = new File(strZ);
        for (File file2 = new File(strKb); file != null && file2 != null && file2.isDirectory() && TextUtils.equals(file.getName(), file2.getName()); file2 = file2.getParentFile()) {
            kb(file2.getPath());
            file = file.getParentFile();
        }
    }

    private static boolean kb(String str) {
        String str2 = z;
        wp.g(str2, "deleteDirIfEmpty on thread: " + Thread.currentThread());
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.isDirectory()) {
                if (file.delete()) {
                    return true;
                }
                wp.g(str2, "deleteDirIfEmpty return false");
                return false;
            }
        }
        return false;
    }

    public static void dl(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            wp.a(z, "deleteFile: " + str + "/" + str2);
            file.delete();
        }
    }

    public static boolean z(Context context, String str) {
        return (context == null || TextUtils.isEmpty(str) || context.checkCallingOrSelfPermission(str) != 0) ? false : true;
    }

    public static boolean dl(com.ss.android.socialbase.downloader.e.dl dlVar) {
        return z(dlVar, dlVar.vo(), dlVar.mc());
    }

    public static boolean z(com.ss.android.socialbase.downloader.e.dl dlVar, boolean z2, String str) {
        if (!z2 && !TextUtils.isEmpty(dlVar.kb()) && !TextUtils.isEmpty(dlVar.gz())) {
            try {
                if (new File(dlVar.kb(), dlVar.gz()).exists()) {
                    if (g(dlVar.kb(), dlVar.gz(), str)) {
                        return true;
                    }
                }
            } catch (OutOfMemoryError e2) {
                wp.z(e2);
            }
        }
        return false;
    }

    public static boolean a(com.ss.android.socialbase.downloader.e.dl dlVar) {
        boolean z2 = false;
        if (!dlVar.ja() && TextUtils.isEmpty(dlVar.lw())) {
            com.ss.android.socialbase.downloader.m.z.g(z, "dcache::last modify is emtpy, so just return cache");
        } else {
            com.ss.android.socialbase.downloader.m.z.g(z, "dcache::curt=" + System.currentTimeMillis() + " expired=" + dlVar.zx());
            if (System.currentTimeMillis() > dlVar.zx()) {
                z2 = true;
            }
        }
        com.ss.android.socialbase.downloader.m.z.g(z, "cacheExpired::dcache::name=" + dlVar.gz() + " expired=" + z2);
        return z2;
    }

    public static int z(String str, String str2, String str3) {
        return com.ss.android.dl.dl.z(str3, new File(str, str2));
    }

    public static boolean g(String str, String str2, String str3) {
        return z(z(str, str2, str3));
    }

    public static int z(File file, String str) {
        return com.ss.android.dl.dl.z(str, file);
    }

    public static String g(int i) {
        String str = "ttmd5 check code = " + i + ", ";
        if (i != 99) {
            switch (i) {
                case 0:
                    return str + "md5 match";
                case 1:
                    return str + "md5 not match";
                case 2:
                    return str + "md5 empty";
                case 3:
                    return str + "ttmd5 version not support";
                case 4:
                    return str + "ttmd5 tag parser error";
                case 5:
                    return str + "file not exist";
                case 6:
                    return str + "get file md5 error";
                default:
                    return str;
            }
        }
        return str + "unknown error";
    }

    public static long a(String str) throws com.ss.android.socialbase.downloader.gc.z {
        try {
            return new StatFs(str).getAvailableBytes();
        } catch (IllegalArgumentException e2) {
            throw new com.ss.android.socialbase.downloader.gc.z(1050, e2);
        } catch (Throwable th) {
            throw new com.ss.android.socialbase.downloader.gc.z(1052, th);
        }
    }

    public static void z(com.ss.android.socialbase.downloader.e.dl dlVar, l lVar, oq oqVar) {
        boolean z2;
        com.ss.android.socialbase.downloader.gc.z zVar;
        boolean z3;
        String str = z;
        com.ss.android.socialbase.downloader.m.z.g(str, "saveFileAsTargetName targetName is " + dlVar.v());
        try {
            synchronized (f2110a) {
                if (f2110a.get(dlVar.e()) == Boolean.TRUE) {
                    com.ss.android.socialbase.downloader.m.z.g(str, "has another same task is saving temp file");
                    if (oqVar != null) {
                        List<oq> arrayList = gc.get(dlVar.e());
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                            gc.put(dlVar.e(), arrayList);
                        }
                        arrayList.add(oqVar);
                    }
                    return;
                }
                com.ss.android.socialbase.downloader.m.z.g(str, "saveTempFileStatusMap put id:" + dlVar.e());
                f2110a.put(dlVar.e(), Boolean.TRUE);
                File file = new File(dlVar.wp(), dlVar.i());
                File file2 = new File(dlVar.kb(), dlVar.gz());
                boolean zGz = gz(dlVar.kb());
                if (file2.exists()) {
                    com.ss.android.socialbase.downloader.m.z.g(str, "targetFile exist");
                    int iZ = z(file2, dlVar.mc());
                    if (z(iZ)) {
                        com.ss.android.socialbase.downloader.m.z.g(str, "tempFile not exist , targetFile exists and md5 check valid");
                        dlVar.z(iZ);
                        if (oqVar != null) {
                            oqVar.z();
                        }
                        z(dlVar.e(), true, (com.ss.android.socialbase.downloader.gc.z) null);
                    } else {
                        if (file.exists()) {
                            z2 = true;
                        } else {
                            com.ss.android.socialbase.downloader.gc.z zVar2 = new com.ss.android.socialbase.downloader.gc.z(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist and target file is exist but md5 verify invalid :%s", dlVar.wp(), dlVar.i(), dlVar.kb(), dlVar.gz(), g(iZ)));
                            if (oqVar != null) {
                                oqVar.z(zVar2);
                            }
                            z(dlVar.e(), false, zVar2);
                            z2 = false;
                        }
                        if (zGz && !file2.delete()) {
                            if (z2) {
                                com.ss.android.socialbase.downloader.gc.z zVar3 = new com.ss.android.socialbase.downloader.gc.z(1037, "delete targetPath file existed with md5 check invalid status:" + g(iZ));
                                if (oqVar != null) {
                                    oqVar.z(zVar3);
                                }
                                z(dlVar.e(), false, zVar3);
                            } else if (lVar != null) {
                                com.ss.android.socialbase.downloader.gz.z.z(lVar, dlVar, new com.ss.android.socialbase.downloader.gc.z(1038, "tempFile is not exist and target file is exist but md5 verify invalid, delete target file failed"), dlVar.p());
                            }
                        }
                    }
                    z2 = false;
                } else if (file.exists()) {
                    z2 = true;
                } else {
                    com.ss.android.socialbase.downloader.gc.z zVar4 = new com.ss.android.socialbase.downloader.gc.z(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist", dlVar.wp(), dlVar.i(), dlVar.kb(), dlVar.gz()));
                    if (oqVar != null) {
                        oqVar.z(zVar4);
                    }
                    z(dlVar.e(), false, zVar4);
                    z2 = false;
                }
                if (z2) {
                    try {
                        int iZ2 = com.ss.android.socialbase.downloader.i.z.z(dlVar.e()).z("download_finish_check_ttmd5", 2);
                        if (iZ2 > 0) {
                            int iZ3 = z(file, dlVar.mc());
                            dlVar.z(iZ3);
                            if (iZ2 >= 2 && !z(iZ3)) {
                                com.ss.android.socialbase.downloader.gc.z zVar5 = new com.ss.android.socialbase.downloader.gc.z(1034, g(iZ3));
                                if (oqVar != null) {
                                    oqVar.z(zVar5);
                                }
                                z(dlVar.e(), false, zVar5);
                                z(dlVar, zGz);
                                return;
                            }
                        }
                        z3 = !g(file, file2);
                        zVar = null;
                    } catch (com.ss.android.socialbase.downloader.gc.z e2) {
                        if (com.ss.android.socialbase.downloader.i.z.z(dlVar.e()).z("fix_file_rename_failed")) {
                            zVar = e2;
                            z3 = true;
                        } else {
                            zVar = e2;
                            z3 = false;
                        }
                    }
                    if (z3) {
                        if (zVar == null) {
                            zVar = new com.ss.android.socialbase.downloader.gc.z(1038, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s)", dlVar.wp(), dlVar.i(), dlVar.kb(), dlVar.gz()));
                        }
                        if (oqVar != null) {
                            oqVar.z(zVar);
                        }
                        z(dlVar.e(), false, zVar);
                        return;
                    }
                    if (oqVar != null) {
                        oqVar.z();
                    }
                    z(dlVar.e(), true, (com.ss.android.socialbase.downloader.gc.z) null);
                }
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.m.z.g(z, "saveFileAsTargetName throwable " + th.getMessage());
            if (oqVar != null) {
                oqVar.z(new com.ss.android.socialbase.downloader.gc.z(1038, g(th, "saveFileAsTargetName")));
            }
        }
    }

    private static void z(int i, boolean z2, com.ss.android.socialbase.downloader.gc.z zVar) {
        synchronized (f2110a) {
            List<oq> list = gc.get(i);
            if (list != null) {
                for (oq oqVar : list) {
                    if (oqVar != null) {
                        if (z2) {
                            oqVar.z();
                        } else {
                            oqVar.z(zVar);
                        }
                    }
                }
            }
            com.ss.android.socialbase.downloader.m.z.g(z, "handleTempSaveCallback id:" + i);
            f2110a.remove(i);
        }
    }

    public static void z(com.ss.android.socialbase.downloader.e.dl dlVar, String str) throws com.ss.android.socialbase.downloader.gc.z {
        if (dlVar == null || TextUtils.isEmpty(str) || str.equals(dlVar.gz())) {
            return;
        }
        File file = new File(dlVar.kb(), str);
        File file2 = new File(dlVar.kb(), dlVar.gz());
        wp.a(z, "copyFileFromExistFileWithSameName: existFile:" + file.getPath() + " targetFile:" + file2.getPath());
        if (file2.exists() && !file2.canWrite()) {
            throw new com.ss.android.socialbase.downloader.gc.z(1001, "targetPath file exists but read-only");
        }
        if (!z(file, file2)) {
            throw new com.ss.android.socialbase.downloader.gc.z(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", dlVar.kb(), str, dlVar.kb(), dlVar.gz()));
        }
    }

    public static boolean z(File file, File file2) throws com.ss.android.socialbase.downloader.gc.z {
        return z(file, file2, true);
    }

    public static boolean z(File file, File file2, boolean z2) throws com.ss.android.socialbase.downloader.gc.z {
        if (file != null && file2 != null) {
            try {
                if (file.exists() && !file.isDirectory() && !file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                    File parentFile = file2.getParentFile();
                    if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                        throw new com.ss.android.socialbase.downloader.gc.z(1053, "Destination '" + parentFile + "' directory cannot be created");
                    }
                    wp.a(z, "copyFile: srcFile:" + file.getPath() + " destFile:" + file2.getPath());
                    if (file2.exists() && !file2.canWrite()) {
                        throw new IOException("Destination '" + file2 + "' exists but is read-only");
                    }
                    g(file, file2, z2);
                    return true;
                }
            } catch (com.ss.android.socialbase.downloader.gc.z e2) {
                throw e2;
            } catch (Throwable th) {
                z(th, "CopyFile");
                return false;
            }
        }
        return false;
    }

    private static void g(File file, File file2, boolean z2) throws IOException {
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileChannel channel = fileInputStream.getChannel();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    FileChannel channel2 = fileOutputStream.getChannel();
                    try {
                        long size = channel.size();
                        long j = 0;
                        while (j < size) {
                            long j2 = size - j;
                            long jTransferFrom = channel2.transferFrom(channel, j, j2 > 31457280 ? 31457280L : j2);
                            if (jTransferFrom == 0) {
                                break;
                            } else {
                                j += jTransferFrom;
                            }
                        }
                        if (channel2 != null) {
                            channel2.close();
                        }
                        fileOutputStream.close();
                        if (channel != null) {
                            channel.close();
                        }
                        fileInputStream.close();
                        long length = file.length();
                        long length2 = file2.length();
                        if (length != length2) {
                            throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + length + " Actual: " + length2);
                        }
                        if (z2) {
                            file2.setLastModified(file.lastModified());
                        }
                    } finally {
                        try {
                        } finally {
                        }
                    }
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    public static boolean g(File file, File file2) throws com.ss.android.socialbase.downloader.gc.z {
        String str = z;
        wp.a(str, "moveFile1: src:" + file.getPath() + " dest:" + file2.getPath());
        boolean zRenameTo = file.renameTo(file2);
        if (!zRenameTo) {
            zRenameTo = z(file, file2);
            try {
                wp.a(str, "moveFile2: src:" + file.getPath() + " dest:" + file2.getPath());
                file.delete();
            } catch (Throwable th) {
                wp.z(th);
            }
        }
        return zRenameTo;
    }

    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return new File(str, str2).exists();
    }

    public static boolean z(int i, String str) {
        if (z.z(16777216)) {
            return i == 206 || i == 1;
        }
        if (i >= 400) {
            return false;
        }
        return i == 206 || i == 1 || "bytes".equals(str);
    }

    public static boolean dl(com.ss.android.socialbase.downloader.fo.e eVar) {
        if (eVar == null) {
            return false;
        }
        return z.z(8) ? "chunked".equals(eVar.z(HttpHeaders.TRANSFER_ENCODING)) || z(eVar) == -1 : z(eVar) == -1;
    }

    public static List<com.ss.android.socialbase.downloader.e.gc> z(List<com.ss.android.socialbase.downloader.e.gc> list, String str, com.ss.android.socialbase.downloader.e.g gVar) {
        return z(list, str, gVar.i(), gVar.ls());
    }

    public static List<com.ss.android.socialbase.downloader.e.gc> z(List<com.ss.android.socialbase.downloader.e.gc> list, String str, long j, long j2) {
        String str2;
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.e.gc gcVar : list) {
                if (gcVar != null) {
                    arrayList.add(gcVar);
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new com.ss.android.socialbase.downloader.e.gc(HttpHeaders.IF_MATCH, str));
        }
        arrayList.add(new com.ss.android.socialbase.downloader.e.gc(HttpHeaders.ACCEPT_ENCODING, "identity"));
        if (j2 <= 0) {
            str2 = String.format("bytes=%s-", String.valueOf(j));
        } else {
            str2 = String.format("bytes=%s-%s", String.valueOf(j), String.valueOf(j2));
        }
        arrayList.add(new com.ss.android.socialbase.downloader.e.gc(HttpHeaders.RANGE, str2));
        com.ss.android.socialbase.downloader.m.z.g(z, " range CurrentOffset:" + j + " EndOffset:" + j2 + ", range = " + str2);
        return arrayList;
    }

    public static boolean z(int i, String str, String str2) {
        return i == -3 && !a(str, str2);
    }

    public static ConnectivityManager z(Context context) {
        ConnectivityManager connectivityManager = fo;
        if (connectivityManager != null) {
            return connectivityManager;
        }
        ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
        fo = connectivityManager2;
        return connectivityManager2;
    }

    public static boolean g(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManagerZ = z(context);
            if (connectivityManagerZ != null && (activeNetworkInfo = connectivityManagerZ.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                if (1 == activeNetworkInfo.getType()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean dl(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManagerZ = z(context);
            if (connectivityManagerZ == null || (activeNetworkInfo = connectivityManagerZ.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public static String gc(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(str.getBytes("UTF-8"));
                    return z(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String a(Context context) {
        String str = dl;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String strUy = uy();
        dl = strUy;
        if (!TextUtils.isEmpty(strUy)) {
            return dl;
        }
        String strKb = kb();
        dl = strKb;
        if (!TextUtils.isEmpty(strKb)) {
            return dl;
        }
        String strGc = gc(context);
        dl = strGc;
        if (!TextUtils.isEmpty(strGc)) {
            return dl;
        }
        String strFo = fo();
        dl = strFo;
        return strFo;
    }

    private static String fo() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i = bufferedReader.read();
                    if (i <= 0) {
                        break;
                    }
                    sb.append((char) i);
                }
                if (com.ss.android.socialbase.downloader.m.z.z()) {
                    com.ss.android.socialbase.downloader.m.z.g("Process", "get processName = " + sb.toString());
                }
                String string = sb.toString();
                z(bufferedReader);
                return string;
            } catch (Throwable unused) {
                z(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    private static String uy() {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            String processName = Application.getProcessName();
            if (!TextUtils.isEmpty(processName) && com.ss.android.socialbase.downloader.m.z.z()) {
                com.ss.android.socialbase.downloader.m.z.g("Process", "processName = " + processName);
            }
            return processName;
        } catch (Exception e2) {
            wp.z(e2);
            return null;
        }
    }

    private static String kb() {
        String str;
        Throwable th;
        Object objInvoke;
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            objInvoke = declaredMethod.invoke(null, new Object[0]);
        } catch (Throwable th2) {
            str = null;
            th = th2;
        }
        if (!(objInvoke instanceof String)) {
            return null;
        }
        str = (String) objInvoke;
        try {
            if (!TextUtils.isEmpty(str) && com.ss.android.socialbase.downloader.m.z.z()) {
                com.ss.android.socialbase.downloader.m.z.g("Process", "processName = " + str);
            }
        } catch (Throwable th3) {
            th = th3;
            wp.z(th);
        }
        return str;
        wp.z(th);
        return str;
    }

    private static String gc(Context context) {
        if (context == null) {
            return null;
        }
        try {
            int iMyPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == iMyPid) {
                        if (com.ss.android.socialbase.downloader.m.z.z()) {
                            com.ss.android.socialbase.downloader.m.z.g("Process", "processName = " + runningAppProcessInfo.processName);
                        }
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Exception e2) {
            wp.z(e2);
        }
        return null;
    }

    public static boolean z() {
        Boolean bool = uy;
        if (bool != null) {
            return bool.booleanValue();
        }
        String strA = a(com.ss.android.socialbase.downloader.downloader.dl.xl());
        Boolean boolValueOf = Boolean.valueOf((strA == null || !strA.contains(":")) && strA != null && strA.equals(com.ss.android.socialbase.downloader.downloader.dl.xl().getPackageName()));
        uy = boolValueOf;
        return boolValueOf.booleanValue();
    }

    public static boolean g() {
        return !dl() && com.ss.android.socialbase.downloader.downloader.dl.g() && com.ss.android.socialbase.downloader.impls.wp.z(true).e();
    }

    public static boolean dl() {
        Boolean bool = kb;
        if (bool != null) {
            return bool.booleanValue();
        }
        String strA = a(com.ss.android.socialbase.downloader.downloader.dl.xl());
        if (strA != null && strA.equals(com.ss.android.socialbase.downloader.downloader.dl.xl().getPackageName() + ":downloader")) {
            kb = Boolean.TRUE;
        } else {
            kb = Boolean.FALSE;
        }
        return kb.booleanValue();
    }

    public static boolean m(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String strA = a(com.ss.android.socialbase.downloader.downloader.dl.xl());
        return strA != null && strA.equals(str);
    }

    public static boolean a() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static String e(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static boolean z(Throwable th) {
        if (th == null) {
            return false;
        }
        String strUy = uy(th);
        if (th instanceof SocketTimeoutException) {
            return true;
        }
        return !TextUtils.isEmpty(strUy) && (strUy.contains("time out") || strUy.contains("Time-out"));
    }

    public static boolean g(Throwable th) {
        com.ss.android.socialbase.downloader.gc.dl dlVar;
        if (th == null) {
            return false;
        }
        String strUy = uy(th);
        if (!(th instanceof com.ss.android.socialbase.downloader.gc.dl) || (((dlVar = (com.ss.android.socialbase.downloader.gc.dl) th) == null || dlVar.a() != 403) && (TextUtils.isEmpty(strUy) || !strUy.contains("403")))) {
            return !TextUtils.isEmpty(strUy) && strUy.contains("Forbidden");
        }
        return true;
    }

    public static boolean dl(Throwable th) {
        if (th == null) {
            return false;
        }
        String strUy = uy(th);
        return !TextUtils.isEmpty(strUy) && strUy.contains("network not available");
    }

    public static boolean a(Throwable th) {
        if (th == null) {
            return false;
        }
        String strUy = uy(th);
        return !TextUtils.isEmpty(strUy) && strUy.contains("Exception in connect");
    }

    public static boolean gc(Throwable th) {
        if (th == null) {
            return false;
        }
        String strUy = uy(th);
        return !TextUtils.isEmpty(strUy) && strUy.contains("Precondition Failed");
    }

    public static boolean m(Throwable th) {
        if (th == null) {
            return false;
        }
        String strUy = uy(th);
        return !TextUtils.isEmpty(strUy) && strUy.contains("Requested Range Not Satisfiable");
    }

    public static boolean e(Throwable th) {
        return com.ss.android.socialbase.downloader.downloader.dl.na().z(th);
    }

    public static boolean z(com.ss.android.socialbase.downloader.gc.z zVar) {
        return zVar != null && zVar.z() == 1051;
    }

    public static boolean g(com.ss.android.socialbase.downloader.gc.z zVar) {
        if (!(zVar instanceof com.ss.android.socialbase.downloader.gc.dl)) {
            return false;
        }
        com.ss.android.socialbase.downloader.gc.dl dlVar = (com.ss.android.socialbase.downloader.gc.dl) zVar;
        return dlVar.a() == 412 || dlVar.a() == 416;
    }

    public static boolean dl(com.ss.android.socialbase.downloader.gc.z zVar) {
        if (zVar == null) {
            return false;
        }
        if (zVar.z() != 1011) {
            return zVar.getCause() != null && (zVar.getCause() instanceof SSLHandshakeException);
        }
        return true;
    }

    public static void z(Throwable th, String str) throws com.ss.android.socialbase.downloader.gc.z {
        String str2 = !TextUtils.isEmpty(str) ? str : "";
        if (th instanceof com.ss.android.socialbase.downloader.gc.z) {
            com.ss.android.socialbase.downloader.gc.z zVar = (com.ss.android.socialbase.downloader.gc.z) th;
            zVar.z(str2 + "-" + zVar.g());
            throw zVar;
        }
        if (th instanceof SSLHandshakeException) {
            throw new com.ss.android.socialbase.downloader.gc.z(1011, g(th, str2));
        }
        if (z(th)) {
            throw new com.ss.android.socialbase.downloader.gc.z(1048, g(th, str2));
        }
        if (gc(th)) {
            throw new com.ss.android.socialbase.downloader.gc.dl(1004, TTAdConstant.IMAGE_URL_CODE, g(th, str2));
        }
        if (m(th)) {
            throw new com.ss.android.socialbase.downloader.gc.dl(1004, 416, g(th, str2));
        }
        if (g(th)) {
            throw new com.ss.android.socialbase.downloader.gc.z(1047, g(th, str2));
        }
        if (dl(th)) {
            throw new com.ss.android.socialbase.downloader.gc.z(1049, g(th, str2));
        }
        if (a(th)) {
            throw new com.ss.android.socialbase.downloader.gc.z(1041, g(th, str2));
        }
        if (th instanceof IOException) {
            dl(th, str);
            z((IOException) th, str);
            return;
        }
        throw new com.ss.android.socialbase.downloader.gc.z(1000, g(th, str2));
    }

    private static void dl(Throwable th, String str) throws com.ss.android.socialbase.downloader.gc.gz {
        com.ss.android.socialbase.downloader.gc.gz gzVarZ = com.ss.android.socialbase.downloader.downloader.dl.na().z(th, null);
        if (gzVarZ == null) {
            gzVarZ = com.ss.android.socialbase.downloader.downloader.dl.na().z(th.getCause(), null);
        }
        if (gzVarZ == null) {
            return;
        }
        throw new com.ss.android.socialbase.downloader.gc.gz(gzVarZ.z(), g(gzVarZ, str)).dl(gzVarZ.a());
    }

    public static void z(IOException iOException, String str) throws com.ss.android.socialbase.downloader.gc.z {
        if (str == null) {
            str = "";
        }
        String strG = g(iOException, str);
        if (iOException instanceof ConnectException) {
            throw new com.ss.android.socialbase.downloader.gc.z(1041, strG);
        }
        if (iOException instanceof UnknownHostException) {
            throw new com.ss.android.socialbase.downloader.gc.z(1055, strG);
        }
        if (iOException instanceof NoRouteToHostException) {
            throw new com.ss.android.socialbase.downloader.gc.z(1056, strG);
        }
        if (iOException instanceof UnknownServiceException) {
            throw new com.ss.android.socialbase.downloader.gc.z(1057, strG);
        }
        if (iOException instanceof PortUnreachableException) {
            throw new com.ss.android.socialbase.downloader.gc.z(1058, strG);
        }
        if (iOException instanceof SocketTimeoutException) {
            throw new com.ss.android.socialbase.downloader.gc.z(1048, strG);
        }
        if (iOException instanceof SocketException) {
            throw new com.ss.android.socialbase.downloader.gc.z(1059, strG);
        }
        if (iOException instanceof HttpRetryException) {
            throw new com.ss.android.socialbase.downloader.gc.z(1060, strG);
        }
        if (iOException instanceof ProtocolException) {
            throw new com.ss.android.socialbase.downloader.gc.z(1061, strG);
        }
        if (iOException instanceof MalformedURLException) {
            throw new com.ss.android.socialbase.downloader.gc.z(1062, strG);
        }
        if (iOException instanceof FileNotFoundException) {
            throw new com.ss.android.socialbase.downloader.gc.z(1063, strG);
        }
        if (iOException instanceof InterruptedIOException) {
            throw new com.ss.android.socialbase.downloader.gc.z(1064, strG);
        }
        if (iOException instanceof UnsupportedEncodingException) {
            throw new com.ss.android.socialbase.downloader.gc.z(1065, strG);
        }
        if (iOException instanceof EOFException) {
            throw new com.ss.android.socialbase.downloader.gc.z(1066, strG);
        }
        if (iOException instanceof StreamResetException) {
            throw new com.ss.android.socialbase.downloader.gc.z(1067, strG);
        }
        if (iOException instanceof SSLException) {
            throw new com.ss.android.socialbase.downloader.gc.z(1011, strG);
        }
        if (gz(iOException)) {
            throw new com.ss.android.socialbase.downloader.gc.z(1006, strG);
        }
        throw new com.ss.android.socialbase.downloader.gc.z(AnalyticsListener.EVENT_DRM_KEYS_LOADED, strG);
    }

    public static boolean gz(Throwable th) {
        if (th == null) {
            return false;
        }
        if (th instanceof com.ss.android.socialbase.downloader.gc.z) {
            com.ss.android.socialbase.downloader.gc.z zVar = (com.ss.android.socialbase.downloader.gc.z) th;
            int iZ = zVar.z();
            if (iZ == 1006) {
                return true;
            }
            if (iZ == 1023 || iZ == 1039 || iZ == 1040 || iZ == 1054 || iZ == 1064) {
                String message = zVar.getMessage();
                return !TextUtils.isEmpty(message) && message.contains("ENOSPC");
            }
        } else if (th instanceof IOException) {
            String strUy = uy(th);
            if (!TextUtils.isEmpty(strUy) && strUy.contains("ENOSPC")) {
                return true;
            }
        }
        return false;
    }

    public static boolean fo(Throwable th) {
        if (!(th instanceof com.ss.android.socialbase.downloader.gc.z)) {
            return false;
        }
        int iZ = ((com.ss.android.socialbase.downloader.gc.z) th).z();
        return iZ == 1055 || iZ == 1023 || iZ == 1041 || iZ == 1022 || iZ == 1048 || iZ == 1056 || iZ == 1057 || iZ == 1058 || iZ == 1059 || iZ == 1060 || iZ == 1061 || iZ == 1067 || iZ == 1049 || iZ == 1047 || iZ == 1051 || iZ == 1004 || iZ == 1011 || iZ == 1002 || iZ == 1013;
    }

    public static boolean z(com.ss.android.socialbase.downloader.gc.z zVar, com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (zVar == null) {
            return false;
        }
        int iZ = zVar.z();
        if (iZ == 1000 || iZ == 1032 || iZ == 1033 || iZ == 1034 || iZ == 1008 || iZ == 1026 || iZ == 1027 || iZ == 1044 || iZ == 1020) {
            return true;
        }
        return (iZ == 1049 || iZ == 1055 || iZ == 1006 || dlVar == null || dlVar.sf() >= 8388608) ? false : true;
    }

    public static String g(Throwable th, String str) {
        if (str == null) {
            return uy(th);
        }
        return str + "-" + uy(th);
    }

    public static String uy(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            return th.toString();
        } catch (Throwable th2) {
            wp.z(th2);
            return "throwable getMsg error";
        }
    }

    public static com.ss.android.socialbase.downloader.g.gz gc(int i) {
        com.ss.android.socialbase.downloader.g.gz gzVar = com.ss.android.socialbase.downloader.g.gz.MAIN;
        if (i == com.ss.android.socialbase.downloader.g.gz.SUB.ordinal()) {
            return com.ss.android.socialbase.downloader.g.gz.SUB;
        }
        return i == com.ss.android.socialbase.downloader.g.gz.NOTIFICATION.ordinal() ? com.ss.android.socialbase.downloader.g.gz.NOTIFICATION : gzVar;
    }

    public static <K> HashMap<Integer, K> z(SparseArray<K> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        HashMap<Integer, K> map = new HashMap<>();
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            int iKeyAt = sparseArray.keyAt(i);
            map.put(Integer.valueOf(iKeyAt), sparseArray.valueAt(i));
        }
        return map;
    }

    public static <K> void z(SparseArray<K> sparseArray, Map<Integer, K> map) {
        if (map == null || sparseArray == null) {
            return;
        }
        for (Integer num : map.keySet()) {
            if (num != null) {
                sparseArray.put(num.intValue(), map.get(num));
            }
        }
    }

    public static long gc(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (dlVar == null) {
            return -1L;
        }
        List<com.ss.android.socialbase.downloader.e.g> listDl = com.ss.android.socialbase.downloader.downloader.dl.io().dl(dlVar.e());
        if (dlVar.ux() == 1) {
            return dlVar.sf();
        }
        if (listDl != null && listDl.size() > 1) {
            long jA = a(listDl);
            if (jA >= 0) {
                return jA;
            }
        }
        return 0L;
    }

    private static long a(List<com.ss.android.socialbase.downloader.e.g> list) {
        if (list == null || list.isEmpty()) {
            return -1L;
        }
        long jV = -1;
        for (com.ss.android.socialbase.downloader.e.g gVar : list) {
            if (gVar != null && (gVar.v() <= gVar.ls() || gVar.ls() == 0)) {
                if (jV == -1 || jV > gVar.v()) {
                    jV = gVar.v();
                }
            }
        }
        return jV;
    }

    public static long m(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (dlVar == null) {
            return 0L;
        }
        List<com.ss.android.socialbase.downloader.e.g> listDl = com.ss.android.socialbase.downloader.downloader.dl.io().dl(dlVar.e());
        int iUx = dlVar.ux();
        boolean z2 = iUx > 1;
        if (!dlVar.um()) {
            return 0L;
        }
        if (z2) {
            if (listDl == null || iUx != listDl.size()) {
                return 0L;
            }
            return g(listDl);
        }
        return dlVar.sf();
    }

    public static boolean z(List<com.ss.android.socialbase.downloader.e.gc> list, List<com.ss.android.socialbase.downloader.e.gc> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        return new HashSet(list).equals(new HashSet(list2));
    }

    public static void z(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th) {
                    wp.z(th);
                }
            }
        }
    }

    public static void z(Cursor... cursorArr) {
        if (cursorArr == null) {
            return;
        }
        for (Cursor cursor : cursorArr) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable th) {
                    wp.z(th);
                }
            }
        }
    }

    public static String z(String str, int i) {
        return i == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(0, i);
    }

    public static String z(String str, com.ss.android.socialbase.downloader.i.z zVar) {
        JSONObject jSONObjectA;
        String str2;
        if (zVar == null || (jSONObjectA = zVar.a("download_dir")) == null) {
            return "";
        }
        String strOptString = jSONObjectA.optString("dir_name");
        if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith("/")) {
            strOptString = strOptString.substring(1);
        }
        if (TextUtils.isEmpty(strOptString)) {
            return strOptString;
        }
        if (!strOptString.contains("%s")) {
            str2 = strOptString + str;
        } else {
            try {
                str2 = String.format(strOptString, str);
            } catch (Throwable unused) {
            }
        }
        strOptString = str2;
        return strOptString.length() > 255 ? strOptString.substring(strOptString.length() - 255) : strOptString;
    }

    public static String gc() {
        return z(com.ss.android.socialbase.downloader.downloader.e.g(com.ss.android.socialbase.downloader.downloader.dl.xl()).dl(), true);
    }

    public static String m() {
        return z(com.ss.android.socialbase.downloader.downloader.e.g(com.ss.android.socialbase.downloader.downloader.dl.xl()).a(), false);
    }

    private static String z(File file, boolean z2) {
        Context contextXl = com.ss.android.socialbase.downloader.downloader.dl.xl();
        if (z(file)) {
            return file.getAbsolutePath();
        }
        int i = contextXl.getApplicationInfo().targetSdkVersion;
        if (Build.VERSION.SDK_INT >= 29 && ((i == 29 && !Environment.isExternalStorageLegacy()) || i > 29)) {
            if (com.ss.android.socialbase.downloader.i.z.dl().g("fix_save_external_dir") <= 0) {
                File fileZ = com.bytedance.sdk.openadsdk.api.plugin.g.z(contextXl, Environment.DIRECTORY_DOWNLOADS);
                if (z(fileZ)) {
                    return fileZ.getAbsolutePath();
                }
            }
        } else {
            if (z2) {
                File fileE = e();
                if (z(fileE)) {
                    return fileE.getAbsolutePath();
                }
            }
            if (com.ss.android.socialbase.downloader.i.z.dl().g("fix_save_external_dir") <= 0) {
                File fileZ2 = com.bytedance.sdk.openadsdk.api.plugin.g.z(contextXl, Environment.DIRECTORY_DOWNLOADS);
                if (z(fileZ2)) {
                    return fileZ2.getAbsolutePath();
                }
            }
        }
        return com.bytedance.sdk.openadsdk.api.plugin.g.z(contextXl).getAbsolutePath();
    }

    public static boolean gz(String str) {
        Context contextXl;
        return com.ss.android.socialbase.downloader.i.z.dl().g("save_path_security") <= 0 || (contextXl = com.ss.android.socialbase.downloader.downloader.dl.xl()) == null || TextUtils.isEmpty(str) || str.startsWith("/data") || str.contains(new StringBuilder("Android/data/").append(contextXl.getPackageName()).toString());
    }

    public static boolean z(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.exists() || file.mkdirs()) {
                return file.isDirectory();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static File e() {
        String externalStorageState;
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (Exception unused) {
            externalStorageState = "";
        }
        if ("mounted".equals(externalStorageState)) {
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        }
        return null;
    }

    public static void z(List<com.ss.android.socialbase.downloader.e.gc> list, com.ss.android.socialbase.downloader.e.dl dlVar) {
        long jEp = dlVar.ep();
        if (jEp > 0) {
            list.add(new com.ss.android.socialbase.downloader.e.gc("extra_throttle_net_speed", String.valueOf(jEp)));
        }
    }

    public static void g(List<com.ss.android.socialbase.downloader.e.gc> list, com.ss.android.socialbase.downloader.e.dl dlVar) {
        long jCn = dlVar.cn();
        if (jCn > 300) {
            list.add(new com.ss.android.socialbase.downloader.e.gc("extra_ttnet_protect_timeout", String.valueOf(jCn)));
        }
    }

    public static long dl(long j) {
        return System.currentTimeMillis() - j;
    }

    public static String g(com.ss.android.socialbase.downloader.fo.e eVar, String str) {
        if (eVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String strZ = eVar.z(str);
        if (!com.ss.android.socialbase.downloader.i.z.dl().g("fix_get_http_resp_head_ignore_case", true)) {
            return strZ;
        }
        if (TextUtils.isEmpty(strZ)) {
            strZ = eVar.z(str.toLowerCase());
        }
        return TextUtils.isEmpty(strZ) ? eVar.z(str.toUpperCase()) : strZ;
    }

    public static int z(Object obj, int i) {
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException unused) {
            return i;
        }
    }

    public static String z(Object obj, String str) {
        try {
            return (String) obj;
        } catch (ClassCastException unused) {
            return str;
        }
    }

    public static boolean z(Object obj, boolean z2) {
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException unused) {
            return z2;
        }
    }

    public static boolean g(com.ss.android.socialbase.downloader.gc.z zVar, com.ss.android.socialbase.downloader.e.dl dlVar) {
        return dlVar != null && dlVar.io() && dl(com.ss.android.socialbase.downloader.downloader.dl.xl());
    }

    public static boolean gz() {
        Context contextXl = com.ss.android.socialbase.downloader.downloader.dl.xl();
        return (contextXl == null || g(contextXl) || !dl(contextXl)) ? false : true;
    }

    public static long fo(String str) {
        long j = 0;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            Matcher matcher = Pattern.compile("max-age=([0-9]+)").matcher(str);
            if (!matcher.find()) {
                return 0L;
            }
            try {
                j = Long.parseLong(matcher.group(1));
                return j;
            } catch (Throwable th) {
                wp.z(th);
                return 0L;
            }
        } catch (Throwable th2) {
            wp.z(th2);
            return j;
        }
    }

    public static String gc(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strGc = gc(str2);
        return (TextUtils.isEmpty(strGc) || str.contains(strGc)) ? str : new File(str, strGc).getAbsolutePath();
    }

    public static boolean dl(List<com.ss.android.socialbase.downloader.e.gc> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (com.ss.android.socialbase.downloader.e.gc gcVar : list) {
            if (gcVar != null && !TextUtils.isEmpty(gcVar.z()) && !TextUtils.isEmpty(gcVar.g()) && "download-tc21-1-15".equals(gcVar.z()) && "download-tc21-1-15".equals(gcVar.g())) {
                return true;
            }
        }
        return false;
    }
}
