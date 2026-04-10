package com.yuewen;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.text.format.Formatter;
import androidx.webkit.ProxyConfig;
import com.alibaba.android.arouter.utils.Consts;
import com.duokan.core.app.AppWrapper;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.io.FileAlreadyExistsException;
import com.duokan.core.io.OutputException;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes12.dex */
public class q41 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16379a = "FileUtils";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f16380b = 1024;
    public static final long c = 1048576;
    public static final long d = 1073741824;
    public static final /* synthetic */ boolean e = false;

    public class a implements FileFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FileFilter[] f16381a;

        public a(FileFilter[] fileFilterArr) {
            this.f16381a = fileFilterArr;
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (file.isDirectory()) {
                return false;
            }
            for (FileFilter fileFilter : this.f16381a) {
                if (!fileFilter.accept(file)) {
                    return false;
                }
            }
            return true;
        }
    }

    public class b implements FileFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FileFilter[] f16382a;

        public b(FileFilter[] fileFilterArr) {
            this.f16382a = fileFilterArr;
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (!file.isDirectory()) {
                return false;
            }
            for (FileFilter fileFilter : this.f16382a) {
                if (!fileFilter.accept(file)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void A(File file) {
        if (file == null) {
            return;
        }
        try {
            if (file.isDirectory()) {
                for (String str : file.list()) {
                    if (!str.equals(Consts.DOT) && !str.equals("..")) {
                        A(new File(file, str));
                    }
                }
            }
            file.delete();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static File B(File file) {
        return C("", ".tmp!", file);
    }

    public static File C(String str, String str2, File file) {
        File file2;
        do {
            file2 = new File(file, Q(str, str2));
            if (file2.mkdir()) {
                break;
            }
        } while (file2.exists());
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    public static File D(File file) {
        return E("", ".tmp!", file);
    }

    public static File E(String str, String str2, File file) {
        try {
            return k(str, str2, file);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean F(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        File fileB = file.isDirectory() ? B(file.getParentFile()) : D(file.getParentFile());
        if (fileB != null && file.renameTo(fileB)) {
            return l(fileB);
        }
        if (fileB != null) {
            fileB.delete();
        }
        return l(file);
    }

    public static FileInputStream G(File file) {
        if (file != null && file.exists()) {
            try {
                return new FileInputStream(file);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static BufferedReader H(File file, String str) {
        FileInputStream fileInputStreamG = G(file);
        if (fileInputStreamG == null) {
            return null;
        }
        try {
            return new BufferedReader(new InputStreamReader(fileInputStreamG, str));
        } catch (Throwable unused) {
            yu3.b(fileInputStreamG);
            return null;
        }
    }

    public static boolean I(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i, File file) {
        try {
            K(bitmap, compressFormat, i, file);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean J(InputStream inputStream, File file) {
        try {
            L(inputStream, file);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void K(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i, File file) throws Throwable {
        File fileK;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileK = k(file.getName(), ".tmp!", file.getParentFile());
            try {
                fileOutputStream = new FileOutputStream(fileK);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileK = null;
        }
        try {
            bitmap.compress(compressFormat, i, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.getFD().sync();
            if (!fileK.renameTo(file)) {
                throw new FileAlreadyExistsException(String.format("the file(%s) already exists", file.getAbsolutePath()));
            }
            try {
                fileOutputStream.close();
            } catch (Exception unused) {
            }
            if (fileK.exists()) {
                fileK.delete();
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception unused2) {
                }
            }
            if (fileK == null || !fileK.exists()) {
                throw th;
            }
            fileK.delete();
            throw th;
        }
    }

    public static void L(InputStream inputStream, File file) throws Throwable {
        File fileK;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileK = k(file.getName(), ".tmp!", file.getParentFile());
            try {
                fileOutputStream = new FileOutputStream(fileK);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileK = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr, 0, 1024);
                if (i <= 0) {
                    break;
                } else {
                    fileOutputStream.write(bArr, 0, i);
                }
            }
            fileOutputStream.flush();
            fileOutputStream.getFD().sync();
            if (!fileK.renameTo(file)) {
                throw new FileAlreadyExistsException(String.format("the file(%s) already exists", file.getAbsolutePath()));
            }
            try {
                fileOutputStream.close();
            } catch (Exception unused) {
            }
            if (fileK.exists()) {
                fileK.delete();
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception unused2) {
                }
            }
            if (fileK == null || !fileK.exists()) {
                throw th;
            }
            fileK.delete();
            throw th;
        }
    }

    public static Collection<File> M(Context context) {
        LinkedList linkedList = new LinkedList();
        for (File parentFile : u(context)) {
            long totalSpace = parentFile.getTotalSpace();
            do {
                File file = parentFile;
                parentFile = parentFile.getParentFile();
                if (parentFile == null || !parentFile.canRead()) {
                    break;
                }
                linkedList.add(file);
            } while (parentFile.getTotalSpace() == totalSpace);
            linkedList.add(file);
        }
        return linkedList;
    }

    public static Collection<File> N(Context context) {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(u(context));
        return linkedList;
    }

    public static Collection<File> O() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(new File("/storage"));
        linkedList2.add(new File("/mnt"));
        while (!linkedList2.isEmpty()) {
            File file = (File) linkedList2.pop();
            if (file.canWrite() && file.canRead() && file.getTotalSpace() > 0) {
                linkedList.add(file);
            } else {
                linkedList2.addAll(v(file, new FileFilter[0]));
            }
        }
        return linkedList;
    }

    public static Collection<File> P(Collection<File> collection) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (File file : collection) {
            try {
                StatFs statFs = new StatFs(file.getAbsolutePath());
                String str = statFs.getBlockSizeLong() + ProxyConfig.MATCH_ALL_SCHEMES + statFs.getBlockCountLong();
                if (!linkedHashMap.containsKey(str)) {
                    linkedHashMap.put(str, file);
                }
            } catch (Throwable unused) {
            }
        }
        return linkedHashMap.values();
    }

    public static String Q(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "" + Process.myPid();
        }
        UUID uuidRandomUUID = UUID.randomUUID();
        return String.format("%s.%d.%d%s", str, Long.valueOf(uuidRandomUUID.getMostSignificantBits()), Long.valueOf(uuidRandomUUID.getLeastSignificantBits()), str2);
    }

    public static void R(InputStream inputStream, File file) throws Throwable {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i < 0) {
                    inputStream.close();
                    fileOutputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static String a(long j) {
        return b(j, "0.00K");
    }

    public static String b(long j, String str) {
        return c(j, str, "0.##");
    }

    public static String c(long j, String str, String str2) {
        if (j == 0) {
            return str;
        }
        DecimalFormat decimalFormat = new DecimalFormat(str2);
        float f = j / 1024.0f;
        if (f > 1048576.0f) {
            return decimalFormat.format(f / 1048576.0f).toString() + "G";
        }
        if (f > 1024.0f) {
            return decimalFormat.format(f / 1024.0f).toString() + "M";
        }
        return decimalFormat.format(f).toString() + "K";
    }

    public static File d(File file) {
        File parentFile = file.getParentFile();
        String name = file.getName();
        int i = 0;
        while (true) {
            int i2 = i + 1;
            File file2 = new File(parentFile, e(name, i));
            if (!file2.exists()) {
                return file2;
            }
            i = i2;
        }
    }

    public static String e(String str, int i) {
        ia0.w().f(LogLevel.INFO, "FileUtils", "changeFileName:" + i + "--" + str);
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i;
        }
        return str.substring(0, iLastIndexOf) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i + str.substring(iLastIndexOf);
    }

    public static boolean f(File file, File file2) {
        File fileB;
        if (!file.isDirectory() || !file2.exists() || (fileB = B(file2.getParentFile())) == null) {
            return false;
        }
        try {
            LinkedList linkedList = new LinkedList();
            linkedList.add(file);
            LinkedList linkedList2 = new LinkedList();
            linkedList2.add(fileB);
            for (int i = 0; i < linkedList.size(); i++) {
                File file3 = (File) linkedList.get(i);
                File file4 = (File) linkedList2.get(i);
                for (File file5 : w(file3, new FileFilter[0])) {
                    if (!h(file5, new File(file4, file5.getName()))) {
                        return false;
                    }
                }
                for (File file6 : v(file3, new FileFilter[0])) {
                    File file7 = new File(file4, file6.getName());
                    if (!file7.mkdir()) {
                        return false;
                    }
                    linkedList.add(file6);
                    linkedList2.add(file7);
                }
            }
            return fileB.renameTo(file2);
        } finally {
            F(fileB);
        }
    }

    public static File g(Context context, Uri uri) {
        return j(context, uri, new File(AppWrapper.v().getApplicationContext().getExternalFilesDir(null), "external_books"));
    }

    public static boolean h(File file, File file2) {
        RandomAccessFile randomAccessFile;
        Throwable th;
        long j;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, com.xiaomi.verificationsdk.internal.Constants.RANDOM_LONG);
            try {
                try {
                    RandomAccessFile randomAccessFile3 = new RandomAccessFile(file2, "rws");
                    try {
                        FileChannel channel = randomAccessFile2.getChannel();
                        FileChannel channel2 = randomAccessFile3.getChannel();
                        long size = channel.size();
                        channel.position(0L);
                        channel2.position(0L);
                        long j2 = 0;
                        while (true) {
                            if (j2 >= size) {
                                randomAccessFile = randomAccessFile2;
                                j = j2;
                                break;
                            }
                            randomAccessFile = randomAccessFile2;
                            j = j2;
                            try {
                                long jTransferFrom = channel2.transferFrom(channel, j2, size - j2);
                                if (jTransferFrom <= 0) {
                                    break;
                                }
                                j2 = j + jTransferFrom;
                                randomAccessFile2 = randomAccessFile;
                            } catch (Throwable th2) {
                                th = th2;
                                Throwable th3 = th;
                                try {
                                    randomAccessFile3.close();
                                    throw th3;
                                } catch (Throwable th4) {
                                    th3.addSuppressed(th4);
                                    throw th3;
                                }
                            }
                        }
                        if (j2 != size) {
                            randomAccessFile3.close();
                            randomAccessFile.close();
                            return false;
                        }
                        channel2.truncate(j);
                        channel2.force(true);
                        randomAccessFile3.close();
                        randomAccessFile.close();
                        return true;
                    } catch (Throwable th5) {
                        th = th5;
                        randomAccessFile = randomAccessFile2;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    th = th;
                    try {
                        randomAccessFile.close();
                        throw th;
                    } catch (Throwable th7) {
                        th.addSuppressed(th7);
                        throw th;
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                randomAccessFile = randomAccessFile2;
                th = th;
                randomAccessFile.close();
                throw th;
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean i(File file, File file2, boolean z) {
        if (!file.isDirectory()) {
            File parentFile = file2.getParentFile();
            if (parentFile == null || !((parentFile.exists() || parentFile.mkdirs()) && parentFile.canWrite())) {
                return false;
            }
            if (!file2.exists() || (file2.isFile() && z)) {
                return h(file, file2);
            }
            return true;
        }
        if ((!file2.exists() && !file2.mkdirs()) || !file2.canWrite() || !file2.isDirectory()) {
            return false;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file3 : fileArrListFiles) {
                if (!i(file3, new File(file2, file3.getName()), z)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002e A[Catch: all -> 0x0052, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0052, blocks: (B:5:0x001c, B:7:0x0022, B:13:0x002e), top: B:79:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File j(android.content.Context r12, android.net.Uri r13, java.io.File r14) {
        /*
            Method dump skipped, instruction units count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yuewen.q41.j(android.content.Context, android.net.Uri, java.io.File):java.io.File");
    }

    public static File k(String str, String str2, File file) throws OutputException {
        File file2;
        do {
            try {
                file2 = new File(file, Q(str, str2));
            } catch (IOException e2) {
                throw new OutputException(e2);
            }
        } while (!file2.createNewFile());
        return file2;
    }

    public static boolean l(File file) {
        boolean zL = true;
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        for (File file2 : fileArrListFiles) {
            zL &= l(file2);
        }
        return file.delete() & zL;
    }

    public static boolean m(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                m(file2);
            }
        }
        return file.delete();
    }

    public static boolean n(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.isDirectory() ? m(file) : file.delete();
    }

    public static boolean o(File file) throws Exception {
        return file.exists() ? file.isDirectory() : file.mkdirs();
    }

    public static boolean p(File file) throws Exception {
        return file.exists() ? file.isDirectory() || (file.delete() && file.mkdirs()) : file.mkdirs();
    }

    public static String q(String str) {
        StatFs statFs = new StatFs(str);
        return Formatter.formatFileSize(AppWrapper.v(), statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong());
    }

    public static String r(String str) {
        int iLastIndexOf = str.lastIndexOf(Consts.DOT);
        return (iLastIndexOf == -1 || iLastIndexOf >= str.length() + (-1)) ? "" : str.substring(iLastIndexOf + 1).toLowerCase();
    }

    public static String s(String str) {
        int iLastIndexOf = str.lastIndexOf("/");
        int iLastIndexOf2 = str.lastIndexOf(Consts.DOT);
        return (iLastIndexOf == -1 || iLastIndexOf2 == -1 || iLastIndexOf2 <= iLastIndexOf) ? str : str.substring(iLastIndexOf + 1, iLastIndexOf2);
    }

    public static String t(String str) {
        int iLastIndexOf = str.lastIndexOf(Consts.DOT);
        return (iLastIndexOf == -1 || iLastIndexOf >= str.length() + (-1)) ? str : str.substring(0, iLastIndexOf);
    }

    public static List<File> u(Context context) {
        LinkedList linkedList = new LinkedList();
        File[] externalFilesDirs = context.getExternalFilesDirs(null);
        if (externalFilesDirs == null) {
            return linkedList;
        }
        for (File file : externalFilesDirs) {
            if (file != null) {
                linkedList.add(file);
            }
        }
        return linkedList;
    }

    public static List<File> v(File file, FileFilter... fileFilterArr) {
        File[] fileArrListFiles = file.listFiles(new b(fileFilterArr));
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        return Arrays.asList(fileArrListFiles);
    }

    public static List<File> w(File file, FileFilter... fileFilterArr) {
        File[] fileArrListFiles = file.listFiles(new a(fileFilterArr));
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        return Arrays.asList(fileArrListFiles);
    }

    public static String x(File file) {
        return file == null ? "" : file.getName();
    }

    public static String y(File file) {
        String strX = x(file);
        int iLastIndexOf = strX.lastIndexOf(46);
        return iLastIndexOf < 0 ? strX : strX.substring(0, iLastIndexOf);
    }

    public static String z(File file) {
        String str = "";
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        str = str + line;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        try {
                            th.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return str;
                        } catch (Throwable th2) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable unused) {
                                }
                            }
                            throw th2;
                        }
                    }
                }
                bufferedReader2.close();
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable unused2) {
        }
        return str;
    }
}
