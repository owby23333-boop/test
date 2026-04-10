package com.amgcyo.cuttadon.utils.otherutils;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.bmob.v3.datatype.up.ParallelUploader;
import cn.bmob.v3.util.BmobDbOpenHelper;
import com.amgcyo.cuttadon.api.entity.comic.ComicChapter;
import com.amgcyo.cuttadon.api.entity.comic.ZymkChapter;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkCatalog;
import com.amgcyo.cuttadon.api.entity.other.MkConfigSource;
import com.amgcyo.cuttadon.api.entity.other.MkRegular;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.database.AppDatabase;
import com.anythink.expressad.foundation.d.c;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.fatcatfat.io.R;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.ss.android.downloadlib.constants.EventConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: MkFileUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class z {
    public static final String a = File.separator;
    public static String b = a(MkApplication.getAppContext());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f4415c = new File(b + "/books" + a).getAbsolutePath();

    /* JADX INFO: compiled from: MkFileUtils.java */
    class a extends TypeToken<ArrayList<MkCatalog>> {
        a() {
        }
    }

    /* JADX INFO: compiled from: MkFileUtils.java */
    class b extends TypeToken<ArrayList<ZymkChapter>> {
        b() {
        }
    }

    /* JADX INFO: compiled from: MkFileUtils.java */
    class c extends TypeToken<ArrayList<ComicChapter>> {
        c() {
        }
    }

    private static int a(int i2, int i3, int i4) {
        if (i2 >= i3) {
            i2 = i3;
        }
        return i2 < i4 ? i2 : i4;
    }

    private static String a(Context context) {
        File externalFilesDir;
        String path = (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && (externalFilesDir = context.getExternalFilesDir(null)) != null) ? externalFilesDir.getPath() : context.getFilesDir().getAbsolutePath();
        return path + a + "fatCatApp";
    }

    public static String b() {
        File file = new File(b + "/cache" + a);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.toString();
    }

    public static String c() {
        File file = new File(b + "/crash" + a);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.toString();
    }

    public static String d() {
        File file = new File(b + "/font" + a);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.toString();
    }

    public static float e(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0.0f;
        }
        return 1.0f - (b(str, str2) / Math.max(str.length(), str2.length()));
    }

    public static String f(String str) {
        int i2;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("md5");
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            byte[] bArr = new byte[1024];
            while (true) {
                int i3 = fileInputStream.read(bArr);
                if (i3 == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i3);
            }
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    sb.append("0");
                    sb.append(hexString);
                } else {
                    sb.append(hexString);
                }
            }
            return sb.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String g() {
        File file = new File(b + "/ad" + a);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.toString();
    }

    public static String h() {
        File file = new File(b + "/download" + a);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.toString();
    }

    public static File i() {
        MkApplication appContext = MkApplication.getAppContext();
        File[] fileArr = {new File(appContext.getCacheDir(), "/cache"), new File(appContext.getFilesDir(), "/cache"), new File(appContext.getExternalCacheDir(), "/cache"), new File(appContext.getExternalFilesDir(null), "/cache")};
        for (File file : fileArr) {
            if (file.exists()) {
                return file;
            }
        }
        for (File file2 : fileArr) {
            if (file2.exists() || file2.mkdirs()) {
                return file2;
            }
        }
        return null;
    }

    @NonNull
    public static String j() {
        return "\u3000";
    }

    public static synchronized ArrayList<ComicChapter> j(String str) {
        String strM = m(str);
        if (!TextUtils.isEmpty(strM)) {
            try {
                return (ArrayList) r.a(strM, new c().getType());
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static String k() {
        File file = new File(b + "/pictures" + a);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.toString();
    }

    public static String l(String str) {
        return c("章节缺失，请换源!\n如果本书只有一个书源;\n请反馈给客服。\n谢谢支持与理解！", f4415c, "/error_template.txt").getAbsolutePath();
    }

    public static String m(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        byte[] bArr;
        File file = new File(str);
        if (file.length() == 0) {
            return "";
        }
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Exception e2) {
                e = e2;
                byteArrayOutputStream = null;
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
            fileInputStream = null;
        }
        try {
            try {
                bArr = new byte[1024];
            } catch (Throwable th3) {
                th = th3;
            }
            while (true) {
                int i2 = fileInputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
                th = th3;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                if (byteArrayOutputStream == null) {
                    throw th;
                }
                try {
                    byteArrayOutputStream.close();
                    throw th;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    throw th;
                }
            }
            String str2 = new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
            try {
                fileInputStream.close();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            try {
                byteArrayOutputStream.close();
            } catch (Exception e7) {
                e7.printStackTrace();
            }
            return str2;
        } catch (Exception e8) {
            e = e8;
            e.printStackTrace();
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e9) {
                    e9.printStackTrace();
                }
            }
            if (byteArrayOutputStream == null) {
                return null;
            }
            try {
                byteArrayOutputStream.close();
                return null;
            } catch (Exception e10) {
                e10.printStackTrace();
                return null;
            }
        }
    }

    public static String n(String str) {
        try {
            return !TextUtils.isEmpty(str) ? str.replaceAll("\\s", "") : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String o(String str) {
        int i2 = 0;
        while (true) {
            String[] strArr = com.amgcyo.cuttadon.app.o.d.a;
            if (i2 >= strArr.length) {
                return str;
            }
            str = str.replaceAll(strArr[i2], "");
            i2++;
        }
    }

    public static List<String> p(String str) {
        int iO = h.o();
        int i2 = iO / 2;
        if (i2 <= 0) {
            i2 = com.amgcyo.cuttadon.f.n.R / 2;
        }
        String[] strArrSplit = str.split("[、，。；？！,!\\?]");
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayList = new ArrayList();
        int length = 0;
        for (String str2 : strArrSplit) {
            if (sb.length() + str2.length() + 1 > i2) {
                String string = sb.toString();
                if (!TextUtils.isEmpty(string)) {
                    arrayList.add(string);
                    sb.delete(0, sb.length());
                }
            }
            sb.append(str2);
            length += str2.length();
            if (length < str.length()) {
                sb.append(str.charAt(length));
                length++;
            }
        }
        if (sb.length() > 0) {
            String string2 = sb.toString();
            if (g.o(String.valueOf(string2.charAt(string2.length() - 1)))) {
                arrayList.add(string2 + "。");
            } else {
                arrayList.add(string2);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str3 : arrayList) {
            if (i(str3) > iO) {
                String[] strArrA = a((CharSequence) str3, i2);
                if (strArrA == null || strArrA.length <= 0) {
                    arrayList2.add(str3);
                } else {
                    arrayList2.addAll(Arrays.asList(strArrA));
                }
            } else {
                arrayList2.add(str3);
            }
        }
        return arrayList2;
    }

    public static String l() {
        return c("请求章节内容失败，\n请先检查网络设置！！！\n网络设置成功后，\n点击下方“点击重试”按钮。\n如果网络通畅还是请求失败，\n请反馈给客服。\n谢谢支持与理解！", f4415c, "/net_error_template.txt").getAbsolutePath();
    }

    public static String e(String str) {
        File file = new File(b + "/comic" + a + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.toString();
    }

    private static long b(File file) throws Exception {
        if (file.exists()) {
            return new FileInputStream(file).available();
        }
        file.createNewFile();
        return 0L;
    }

    private static long c(File file) throws Exception {
        long jB;
        File[] fileArrListFiles = file.listFiles();
        long j2 = 0;
        for (int i2 = 0; i2 < fileArrListFiles.length; i2++) {
            if (fileArrListFiles[i2].isDirectory()) {
                jB = c(fileArrListFiles[i2]);
            } else {
                jB = b(fileArrListFiles[i2]);
            }
            j2 += jB;
        }
        return j2;
    }

    public static boolean d(String str) {
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static String g(String str) {
        int iLastIndexOf;
        return (TextUtils.isEmpty(str) || (iLastIndexOf = str.lastIndexOf("/")) == -1) ? "" : str.substring(iLastIndexOf + 1);
    }

    public static List<String> h(String str) {
        File[] fileArrListFiles = new File(str).listFiles();
        if (fileArrListFiles == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file : fileArrListFiles) {
            arrayList.add(file.getAbsolutePath());
        }
        return arrayList;
    }

    public static String k(String str) {
        char[] charArray = str.toCharArray();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            if (charArray[i2] == ' ') {
                charArray[i2] = 12288;
            } else if (charArray[i2] > ' ' && charArray[i2] < 127) {
                charArray[i2] = (char) (charArray[i2] + 65248);
            }
        }
        return new String(charArray);
    }

    public static double a(String str, int i2) {
        long jB;
        File file = new File(str);
        try {
            if (file.isDirectory()) {
                jB = c(file);
            } else {
                jB = b(file);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            jB = 0;
        }
        return a(jB, i2);
    }

    public static boolean d(String str, String str2) {
        File file = new File(d(), str);
        if (file.exists()) {
            String strF = f(file.getAbsolutePath());
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(strF)) {
                return str2.equals(strF);
            }
        }
        return false;
    }

    public static String e() {
        return MkApplication.getAppContext().getDir(h.t(), 0).getPath();
    }

    public static synchronized ArrayList<MkCatalog> b(MkBook mkBook) {
        String strM = m(a(mkBook.getBook_id(), mkBook.getReading_site_id()) + a + "catalog_32767.data");
        if (!TextUtils.isEmpty(strM)) {
            try {
                return (ArrayList) r.a(strM, new a().getType());
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static File c(String str, String str2, String str3) throws Throwable {
        File file = new File(str2);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(str2 + a + str3);
                try {
                    file2.createNewFile();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2, false);
                    try {
                        fileOutputStream2.write(str.getBytes());
                        try {
                            fileOutputStream2.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        return file2;
                    } catch (Exception unused) {
                        fileOutputStream = fileOutputStream2;
                        file = file2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        return file;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static int i(String str) {
        try {
            return str.getBytes("GBK").length;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static double a(long j2, int i2) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (i2 == 1) {
            return Double.valueOf(decimalFormat.format(j2)).doubleValue();
        }
        if (i2 == 2) {
            double d2 = j2;
            Double.isNaN(d2);
            return Double.valueOf(decimalFormat.format(d2 / 1024.0d)).doubleValue();
        }
        if (i2 == 3) {
            double d3 = j2;
            Double.isNaN(d3);
            return Double.valueOf(decimalFormat.format(d3 / 1048576.0d)).doubleValue();
        }
        if (i2 != 4) {
            return PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        }
        double d4 = j2;
        Double.isNaN(d4);
        return Double.valueOf(decimalFormat.format(d4 / 1.073741824E9d)).doubleValue();
    }

    public static boolean f(String str, String str2) {
        File file = new File(str);
        try {
            File file2 = new File(str2);
            if (file2.exists() && !file2.delete()) {
                return false;
            }
            boolean zRenameTo = file.renameTo(file2);
            if (file.exists()) {
                file.delete();
            }
            return zRenameTo;
        } finally {
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static String b(int i2) {
        File file = new File(b + "/books" + a + i2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.toString();
    }

    public static synchronized boolean a(int i2, String str, ArrayList<MkCatalog> arrayList, String[] strArr) {
        if (!g.a(arrayList) && i2 != 0 && !TextUtils.isEmpty(str)) {
            return b(new GsonBuilder().setExclusionStrategies(new l0(strArr)).create().toJson(arrayList), a(i2, str), "catalog_32767.data");
        }
        return false;
    }

    public static boolean b(String str, String str2, String str3) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(str2 + a + str3);
            file2.createNewFile();
            fileOutputStream = new FileOutputStream(file2, false);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(str.getBytes());
            try {
                fileOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return true;
        } catch (Exception unused2) {
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 == null) {
                return false;
            }
            try {
                fileOutputStream2.close();
                return false;
            } catch (Exception e3) {
                e3.printStackTrace();
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static String a(int i2, String str) {
        File file = new File(b + "/books" + a + i2, str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.toString();
    }

    public static boolean c(String str) {
        boolean zC;
        if (!str.endsWith(File.separator)) {
            str = str + File.separator;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            zC = true;
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    zC = d(file2.getAbsolutePath());
                    if (!zC) {
                        break;
                    }
                } else {
                    if (!file2.exists() || !"Glide".equals(file2.getName())) {
                        zC = c(file2.getAbsolutePath());
                        if (!zC) {
                            break;
                        }
                    } else {
                        zC = true;
                    }
                }
            }
        } else {
            zC = true;
        }
        if (zC) {
            return file.delete();
        }
        return false;
    }

    public static String f() {
        return com.amgcyo.cuttadon.f.o.d(R.string.app_name) + "备份数据_" + g0.a().a("back_up_count", 1);
    }

    public static boolean a(String str, File file) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file, false);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(str.getBytes());
            try {
                fileOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return true;
        } catch (Exception unused2) {
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 == null) {
                return false;
            }
            try {
                fileOutputStream2.close();
                return false;
            } catch (Exception e3) {
                e3.printStackTrace();
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean b(String str) {
        return a(new File(str));
    }

    private static boolean c(String str, String str2) {
        boolean zC;
        if (!str.endsWith(File.separator)) {
            str = str + File.separator;
        }
        File file = new File(str);
        boolean z2 = false;
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            zC = true;
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    zC = d(file2.getAbsolutePath());
                    if (!zC) {
                        break;
                    }
                } else {
                    if ((!file2.exists() || !str2.equals(file2.getName())) && !(zC = c(file2.getAbsolutePath(), str2))) {
                        break;
                    }
                }
            }
        } else {
            zC = true;
        }
        String str3 = "flag: " + zC + "  dirFile:  " + file.getName();
        if (!zC) {
            return false;
        }
        if (file.exists()) {
            if (str2.equals(file.getName() + "dirFile: " + file.getName())) {
                z2 = true;
            }
        }
        Boolean.valueOf(z2);
        if (TextUtils.isEmpty(str2)) {
            return file.delete();
        }
        return true;
    }

    private static int b(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        if (length == 0) {
            return length2;
        }
        if (length2 == 0) {
            return length;
        }
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, length + 1, length2 + 1);
        for (int i2 = 0; i2 <= length; i2++) {
            iArr[i2][0] = i2;
        }
        for (int i3 = 0; i3 <= length2; i3++) {
            iArr[0][i3] = i3;
        }
        for (int i4 = 1; i4 <= length; i4++) {
            int i5 = i4 - 1;
            char cCharAt = str.charAt(i5);
            for (int i6 = 1; i6 <= length2; i6++) {
                int i7 = i6 - 1;
                char cCharAt2 = str2.charAt(i7);
                iArr[i4][i6] = a(iArr[i5][i6] + 1, iArr[i4][i7] + 1, iArr[i5][i7] + ((cCharAt == cCharAt2 || cCharAt == cCharAt2 + ' ' || cCharAt + ' ' == cCharAt2) ? 0 : 1));
            }
        }
        return iArr[length][length2];
    }

    public static File a(String str, String str2, String str3) {
        return new File(b + "/books" + a + str + a + str2, str3);
    }

    public static synchronized File a(int i2, String str, String str2, int i3, String str3) {
        if (i3 % 3 == 0) {
            str3 = str3 + "\n" + com.amgcyo.cuttadon.app.o.d.a(com.amgcyo.cuttadon.f.o.d(R.string.app_name));
        }
        try {
            str3 = a(AppDatabase.i().c().a(str), str3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return c(str3, a(i2, str), str2);
    }

    private static String a(MkConfigSource mkConfigSource, String str) {
        int i2 = 0;
        while (true) {
            String[] strArr = com.amgcyo.cuttadon.app.o.d.a;
            if (i2 >= strArr.length) {
                break;
            }
            str = str.replaceAll(strArr[i2], "");
            i2++;
        }
        if (mkConfigSource != null && !TextUtils.isEmpty(mkConfigSource.getSite_id())) {
            try {
                ArrayList<MkRegular> regular = mkConfigSource.getRegular();
                if (!g.a(regular)) {
                    for (MkRegular mkRegular : regular) {
                        str = str.replaceAll(mkRegular.getRegular_key(), mkRegular.getRegular_value());
                    }
                }
                return str;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return str;
    }

    public static String b(Context context, Uri uri) {
        if (BmobDbOpenHelper.FILE.equals(uri.getScheme())) {
            return uri.getPath();
        }
        Uri uri2 = null;
        if ("content".equals(uri.getScheme()) && Build.VERSION.SDK_INT >= 19 && DocumentsContract.isDocumentUri(context, uri)) {
            if (b(uri)) {
                String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                }
            } else {
                if (a(uri)) {
                    String documentId = DocumentsContract.getDocumentId(uri);
                    String strA = a(context, uri);
                    if (strA != null) {
                        return Environment.getExternalStorageDirectory().toString() + "/Download/" + strA;
                    }
                    if (documentId.startsWith("raw:")) {
                        documentId = documentId.replaceFirst("raw:", "");
                        if (new File(documentId).exists()) {
                            return documentId;
                        }
                    }
                    return a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), (String) null, (String[]) null);
                }
                if (c(uri)) {
                    String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                    String str = strArrSplit2[0];
                    if (c.C0205c.f10205e.equals(str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if (com.anythink.expressad.exoplayer.k.o.b.equals(str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return a(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                }
            }
        }
        return null;
    }

    public static synchronized ArrayList<ZymkChapter> c(int i2) {
        String strM = m(a(i2) + a + "comic_32767.comic");
        if (!TextUtils.isEmpty(strM)) {
            try {
                return (ArrayList) r.a(strM, new b().getType());
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static void a(Context context, int i2, String str, String str2) {
        InputStream inputStreamOpenRawResource = context.getResources().openRawResource(i2);
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        a(str2 + a + str, inputStreamOpenRawResource);
    }

    private static boolean c(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static void a(String str, InputStream inputStream) {
        File file = new File(str);
        try {
            if (file.exists()) {
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[inputStream.available()];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 != -1) {
                    fileOutputStream.write(bArr, 0, i2);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    inputStream.close();
                    return;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean a(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return d(str);
        }
        return c(str);
    }

    public static boolean a(String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return d(str);
        }
        return c(str, str2);
    }

    public static boolean a(File file) {
        if (file == null || !file.exists() || !file.isDirectory()) {
            return false;
        }
        boolean zDelete = false;
        for (File file2 : file.listFiles()) {
            if (file2.isFile()) {
                file2.delete();
            } else if (file2.isDirectory()) {
                a(file2);
            }
            zDelete = file.delete();
        }
        return zDelete;
    }

    private static boolean b(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static List<String> a(String str, MkConfigSource mkConfigSource) throws Throwable {
        ArrayList arrayList = new ArrayList();
        a(str, arrayList, mkConfigSource);
        return arrayList;
    }

    public static boolean a() {
        ArrayList<Integer> version_data = MkApplication.getAppContext().getVersion_data();
        return !g.a((List<?>) version_data) && g.a(version_data);
    }

    public static String[] a(CharSequence charSequence, int i2) {
        if (charSequence == null) {
            return null;
        }
        int length = charSequence.length();
        int i3 = 0;
        if (length < i2) {
            return new String[]{charSequence.toString()};
        }
        int iA = a(length, i2);
        String[] strArr = new String[iA];
        String string = charSequence.toString();
        while (i3 < iA) {
            int i4 = i3 * i2;
            strArr[i3] = string.substring(i4, i3 == iA + (-1) ? length : i2 + i4);
            i3++;
        }
        return strArr;
    }

    public static int a(int i2, int i3) {
        int i4 = i2 % i3;
        int i5 = i2 / i3;
        return i4 == 0 ? i5 : i5 + 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.lang.String r5, java.util.List<java.lang.String> r6, com.amgcyo.cuttadon.api.entity.other.MkConfigSource r7) throws java.lang.Throwable {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            long r1 = r0.length()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L17
            java.lang.String r5 = "章节缺失，请换源!\n如果本书只有一个书源;\n请反馈给客服。\n谢谢支持与理解！"
            r6.add(r5)
            goto La7
        L17:
            boolean r5 = r0.exists()
            if (r5 == 0) goto La7
            r5 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L9b
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L9b
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
            r2.<init>(r1, r3)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
            r5 = 0
        L30:
            java.lang.String r2 = r0.readLine()     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            if (r2 == 0) goto L7a
            java.lang.String r3 = "\\s"
            java.lang.String r4 = ""
            java.lang.String r2 = r2.replaceAll(r3, r4)     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            if (r7 == 0) goto L44
            java.lang.String r2 = a(r7, r2)     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
        L44:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            if (r3 != 0) goto L4f
            int r5 = r5 + 1
            r6.add(r2)     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
        L4f:
            r2 = 1
            if (r5 > r2) goto L30
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            r2.<init>()     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            java.util.Iterator r3 = r6.iterator()     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
        L5b:
            boolean r4 = r3.hasNext()     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            if (r4 == 0) goto L6b
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            r2.append(r4)     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            goto L5b
        L6b:
            r6.clear()     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            java.util.List r2 = p(r2)     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            r6.addAll(r2)     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            goto L30
        L7a:
            r1.close()     // Catch: java.lang.Exception -> L7d
        L7d:
            r0.close()     // Catch: java.io.IOException -> La7
            goto La7
        L81:
            r5 = move-exception
            goto L8e
        L83:
            goto L9d
        L85:
            r6 = move-exception
            r0 = r5
            goto L8d
        L88:
            r0 = r5
            goto L9d
        L8a:
            r6 = move-exception
            r0 = r5
            r1 = r0
        L8d:
            r5 = r6
        L8e:
            if (r1 == 0) goto L95
            r1.close()     // Catch: java.lang.Exception -> L94
            goto L95
        L94:
        L95:
            if (r0 == 0) goto L9a
            r0.close()     // Catch: java.io.IOException -> L9a
        L9a:
            throw r5
        L9b:
            r0 = r5
            r1 = r0
        L9d:
            if (r1 == 0) goto La4
            r1.close()     // Catch: java.lang.Exception -> La3
            goto La4
        La3:
        La4:
            if (r0 == 0) goto La7
            goto L7d
        La7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.utils.otherutils.z.a(java.lang.String, java.util.List, com.amgcyo.cuttadon.api.entity.other.MkConfigSource):void");
    }

    public static String a(int i2) {
        File file = new File(b + "/comic" + a + i2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.toString();
    }

    public static synchronized void a(int i2, List<ZymkChapter> list) {
        if (!g.a(list) && i2 != 0) {
            b(r.a(list), a(i2), "comic_32767.comic");
        }
    }

    public static void a(Context context, String str, String str2) {
        try {
            String[] list = context.getAssets().list(str);
            if (list != null && list.length > 0) {
                new File(str2).mkdirs();
                for (String str3 : list) {
                    a(context, str + "/" + str3, str2 + "/" + str3);
                }
                return;
            }
            InputStream inputStreamOpen = context.getAssets().open(str);
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str2));
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = inputStreamOpen.read(bArr);
                if (i2 != -1) {
                    fileOutputStream.write(bArr, 0, i2);
                } else {
                    fileOutputStream.flush();
                    inputStreamOpen.close();
                    fileOutputStream.close();
                    return;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String a(MkBook mkBook) {
        String strA;
        if (1 == mkBook.getForm()) {
            strA = b(mkBook.getBook_id());
        } else {
            strA = a(mkBook.getBook_id());
        }
        String str = "booksPath：" + strA;
        return strA;
    }

    public static boolean a(Context context, Bitmap bitmap, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str);
        contentValues.put(ParallelUploader.Params.DESCRIPTION, str);
        contentValues.put(EventConstants.ExtraJson.MIME_TYPE, str2);
        Uri uriInsert = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (uriInsert == null) {
            return true;
        }
        try {
            OutputStream outputStreamOpenOutputStream = context.getContentResolver().openOutputStream(uriInsert);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStreamOpenOutputStream);
            if (outputStreamOpenOutputStream == null) {
                return true;
            }
            outputStreamOpenOutputStream.close();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private static String a(Context context, Uri uri) {
        Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return string;
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (cursorQuery == null) {
            return null;
        }
        cursorQuery.close();
        return null;
    }

    private static String a(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return string;
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (cursorQuery == null) {
            return null;
        }
        cursorQuery.close();
        return null;
    }

    private static boolean a(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }
}
