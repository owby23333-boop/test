package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsLogReport;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Enumeration;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"NewApi"})
public class FileUtil {
    public static String a = null;
    public static final a b = new a() { // from class: com.tencent.smtt.utils.FileUtil.2
        @Override // com.tencent.smtt.utils.FileUtil.a
        public boolean a(File file, File file2) {
            return file.length() == file2.length() && file.lastModified() == file2.lastModified();
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f19182c = 4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static RandomAccessFile f19183d;

    public interface a {
        boolean a(File file, File file2);
    }

    public interface b {
        boolean a(InputStream inputStream, ZipEntry zipEntry, String str) throws Exception;
    }

    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException, OutOfMemoryError {
        if (inputStream == null) {
            return -1L;
        }
        byte[] bArr = new byte[4096];
        long j2 = 0;
        while (true) {
            int i2 = inputStream.read(bArr);
            if (-1 == i2) {
                return j2;
            }
            outputStream.write(bArr, 0, i2);
            j2 += (long) i2;
        }
    }

    public static File a(Context context, String str) {
        String str2;
        File file = new File(context.getFilesDir(), "tbs");
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.canWrite()) {
            File file2 = new File(file, str);
            if (!file2.exists()) {
                try {
                    file2.createNewFile();
                } catch (IOException e2) {
                    str2 = "getPermanentTbsFile -- exception: " + e2;
                }
            }
            return file2;
        }
        str2 = "getPermanentTbsFile -- no permission!";
        TbsLog.e("FileHelper", str2);
        return null;
    }

    public static File a(Context context, boolean z2, String str) {
        String strC = c(context);
        if (strC == null) {
            return null;
        }
        File file = new File(strC);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!file.canWrite()) {
            return null;
        }
        File file2 = new File(file, str);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return file2;
    }

    public static String a(Context context, int i2) {
        return a(context, context.getApplicationInfo().packageName, i2, true);
    }

    public static String a(Context context, String str, int i2, boolean z2) {
        String str2;
        if (context == null || !a(context)) {
            return "";
        }
        try {
            str2 = Environment.getExternalStorageDirectory() + File.separator;
        } catch (Exception e2) {
            TbsLog.i(e2);
            str2 = "";
        }
        switch (i2) {
            case 1:
                if (!str2.equals("")) {
                    break;
                }
                break;
            case 2:
                if (!str2.equals("")) {
                    break;
                }
                break;
            case 3:
                if (!str2.equals("")) {
                    break;
                }
                break;
            case 4:
                if (!str2.equals("")) {
                    String str3 = str2 + "tencent" + File.separator + "tbs" + File.separator + "stable" + File.separator + str;
                    if (z2) {
                        File file = new File(str3);
                        if (!file.exists() || !file.canWrite()) {
                            if (!file.exists()) {
                                try {
                                    file.mkdirs();
                                } catch (SecurityException e3) {
                                    TbsLog.i(e3);
                                }
                                if (!file.canWrite()) {
                                }
                                break;
                            }
                        }
                    }
                }
                break;
            case 5:
                if (!str2.equals("")) {
                    break;
                }
                break;
            case 6:
                String str4 = a;
                if (str4 == null) {
                    a = b(context, "tbslog");
                    break;
                }
                break;
            case 7:
                if (!str2.equals("")) {
                    break;
                }
                break;
        }
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0039 A[PHI: r4
  0x0039: PHI (r4v9 ??) = (r4v15 ??), (r4v16 ??), (r4v17 ??), (r4v18 ??) binds: [B:25:0x002e, B:30:0x0036, B:12:0x001a, B:11:0x0018] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.nio.channels.FileLock a(android.content.Context r3, java.io.FileOutputStream r4) throws java.lang.Throwable {
        /*
            r3 = 0
            if (r4 != 0) goto L4
            return r3
        L4:
            java.nio.channels.FileChannel r4 = r4.getChannel()     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L29 java.nio.channels.OverlappingFileLockException -> L31
            java.nio.channels.FileLock r0 = r4.tryLock()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20 java.nio.channels.OverlappingFileLockException -> L22
            boolean r1 = r0.isValid()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20 java.nio.channels.OverlappingFileLockException -> L22
            if (r1 == 0) goto L18
            if (r4 == 0) goto L17
            r4.close()     // Catch: java.lang.Throwable -> L17
        L17:
            return r0
        L18:
            if (r4 == 0) goto L39
        L1a:
            r4.close()     // Catch: java.lang.Throwable -> L39
            goto L39
        L1e:
            r3 = move-exception
            goto L3a
        L20:
            r0 = move-exception
            goto L2b
        L22:
            r0 = move-exception
            goto L33
        L24:
            r4 = move-exception
            r2 = r4
            r4 = r3
            r3 = r2
            goto L3a
        L29:
            r0 = move-exception
            r4 = r3
        L2b:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L1e
            if (r4 == 0) goto L39
            goto L1a
        L31:
            r0 = move-exception
            r4 = r3
        L33:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L1e
            if (r4 == 0) goto L39
            goto L1a
        L39:
            return r3
        L3a:
            if (r4 == 0) goto L3f
            r4.close()     // Catch: java.lang.Throwable -> L3f
        L3f:
            goto L41
        L40:
            throw r3
        L41:
            goto L40
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.FileUtil.a(android.content.Context, java.io.FileOutputStream):java.nio.channels.FileLock");
    }

    public static synchronized void a(Context context, FileLock fileLock) {
        TbsLog.i("FileHelper", "releaseTbsCoreRenameFileLock -- lock: " + fileLock);
        FileChannel fileChannelChannel = fileLock.channel();
        if (fileChannelChannel != null && fileChannelChannel.isOpen()) {
            try {
                fileLock.release();
                fileChannelChannel.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(File file, boolean z2) {
        a(file, z2, false);
    }

    public static void a(File file, boolean z2, String str) {
        TbsLog.i("FileUtils", "delete file,ignore=" + z2 + "except" + str + file + Log.getStackTraceString(new Throwable()));
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (!file2.getName().equals(str)) {
                a(file2, z2);
            }
        }
        if (z2) {
            return;
        }
        file.delete();
    }

    public static void a(File file, boolean z2, boolean z3) {
        TbsLog.i("FileUtils", "delete file,ignore=" + z2 + "isSoftLink=" + z3);
        if (file == null) {
            return;
        }
        if (z3 || file.exists()) {
            if ((z3 && !file.isDirectory()) || file.isFile()) {
                file.delete();
                return;
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            for (File file2 : fileArrListFiles) {
                a(file2, z2, z3);
            }
            if (z2) {
                return;
            }
            file.delete();
        }
    }

    public static void a(FileLock fileLock, FileOutputStream fileOutputStream) {
        if (fileLock != null) {
            try {
                FileChannel fileChannelChannel = fileLock.channel();
                if (fileChannelChannel != null && fileChannelChannel.isOpen()) {
                    fileLock.release();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        return context != null && context.getApplicationContext().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0 && context.getApplicationContext().checkSelfPermission(com.kuaishou.weapon.p0.g.f16729i) == 0;
    }

    public static boolean a(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        b(file);
        return file.mkdirs();
    }

    public static boolean a(File file, File file2) throws Exception {
        return a(file.getPath(), file2.getPath());
    }

    public static boolean a(File file, File file2, FileFilter fileFilter) throws Exception {
        return a(file, file2, fileFilter, b);
    }

    public static boolean a(File file, File file2, FileFilter fileFilter, a aVar) throws Exception {
        if (file == null || file2 == null) {
            return false;
        }
        TbsLog.e("FileHelper", "copyFiles src is " + file.getAbsolutePath() + " dst is " + file2.getAbsolutePath());
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return b(file, file2, fileFilter, aVar);
        }
        File[] fileArrListFiles = file.listFiles(fileFilter);
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z2 = true;
        for (File file3 : fileArrListFiles) {
            if (!a(file3, new File(file2, file3.getName()), fileFilter)) {
                z2 = false;
            }
        }
        return z2;
    }

    private static boolean a(String str, long j2, long j3, long j4) throws Exception {
        FileInputStream fileInputStream;
        File file = new File(str);
        if (file.length() != j2) {
            TbsLog.e("FileHelper", "file size doesn't match: " + file.length() + " vs " + j2);
            return true;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            CRC32 crc32 = new CRC32();
            byte[] bArr = new byte[8192];
            while (true) {
                int i2 = fileInputStream.read(bArr);
                if (i2 <= 0) {
                    break;
                }
                crc32.update(bArr, 0, i2);
            }
            long value = crc32.getValue();
            TbsLog.i("FileHelper", "" + file.getName() + ": crc = " + value + ", zipCrc = " + j4);
            fileInputStream.close();
            return value != j4;
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    @SuppressLint({"InlinedApi"})
    public static boolean a(String str, String str2) throws Exception {
        return a(str, str2, Build.CPU_ABI, Build.VERSION.SDK_INT >= 8 ? Build.CPU_ABI2 : null, PropertyUtils.getQuickly("ro.product.cpu.upgradeabi", "armeabi"));
    }

    private static boolean a(String str, String str2, String str3, String str4, b bVar) throws Exception {
        ZipFile zipFile;
        try {
            zipFile = new ZipFile(str);
        } catch (Throwable th) {
            th = th;
            zipFile = null;
        }
        try {
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            boolean z2 = false;
            boolean z3 = false;
            while (enumerationEntries.hasMoreElements()) {
                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                String name = zipEntryNextElement.getName();
                if (name != null && !name.contains("../") && (name.startsWith("lib/") || name.startsWith("assets/"))) {
                    String strSubstring = name.substring(name.lastIndexOf(47));
                    if (strSubstring.endsWith(".so")) {
                        if (name.regionMatches(f19182c, str2, 0, str2.length()) && name.charAt(f19182c + str2.length()) == '/') {
                            z2 = true;
                        } else if (str3 != null && name.regionMatches(f19182c, str3, 0, str3.length()) && name.charAt(f19182c + str3.length()) == '/') {
                            z3 = true;
                            if (z2) {
                            }
                        } else if (str4 != null && name.regionMatches(f19182c, str4, 0, str4.length()) && name.charAt(f19182c + str4.length()) == '/' && !z2 && !z3) {
                        }
                    }
                    InputStream inputStream = zipFile.getInputStream(zipEntryNextElement);
                    try {
                        if (!bVar.a(inputStream, zipEntryNextElement, strSubstring.substring(1))) {
                            zipFile.close();
                            return false;
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } finally {
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    }
                }
            }
            zipFile.close();
            return true;
        } catch (Throwable th2) {
            th = th2;
            if (zipFile != null) {
                zipFile.close();
            }
            throw th;
        }
    }

    private static boolean a(String str, final String str2, String str3, String str4, String str5) throws Exception {
        return a(str, str3, str4, str5, new b() { // from class: com.tencent.smtt.utils.FileUtil.1
            @Override // com.tencent.smtt.utils.FileUtil.b
            public boolean a(InputStream inputStream, ZipEntry zipEntry, String str6) throws Exception {
                try {
                    return FileUtil.b(inputStream, zipEntry, str2, str6);
                } catch (Exception e2) {
                    throw new Exception("copyFileIfChanged Exception", e2);
                }
            }
        });
    }

    public static FileOutputStream b(Context context, boolean z2, String str) {
        File fileA = a(context, z2, str);
        if (fileA == null) {
            return null;
        }
        try {
            return new FileOutputStream(fileA);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String b(Context context, String str) {
        if (context == null || !a(context)) {
            return "";
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        try {
            try {
                return context.getExternalFilesDir(str).getAbsolutePath();
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        } catch (Throwable unused) {
            return Environment.getExternalStorageDirectory() + File.separator + "Android" + File.separator + "data" + File.separator + context.getApplicationInfo().packageName + File.separator + "files" + File.separator + str;
        }
    }

    public static void b(File file) {
        a(file, false);
    }

    public static boolean b(Context context) {
        long jA = s.a();
        boolean z2 = jA >= TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace();
        if (!z2) {
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDwonloader.hasEnoughFreeSpace] freeSpace too small,  freeSpace = " + jA);
        }
        return z2;
    }

    public static boolean b(File file, File file2) throws Exception {
        return a(file, file2, (FileFilter) null);
    }

    private static boolean b(File file, File file2, FileFilter fileFilter, a aVar) throws Exception {
        FileChannel fileChannel;
        if (file == null || file2 == null) {
            return false;
        }
        if (fileFilter != null && !fileFilter.accept(file)) {
            return false;
        }
        FileChannel channel = null;
        try {
        } catch (Throwable th) {
            th = th;
            fileChannel = null;
        }
        if (file.exists() && file.isFile()) {
            if (file2.exists()) {
                if (aVar != null && aVar.a(file, file2)) {
                    return true;
                }
                b(file2);
            }
            File parentFile = file2.getParentFile();
            if (parentFile.isFile()) {
                b(parentFile);
            }
            if (!parentFile.exists() && !parentFile.mkdirs()) {
                return false;
            }
            FileChannel channel2 = new FileInputStream(file).getChannel();
            try {
                channel = new FileOutputStream(file2).getChannel();
                long size = channel2.size();
                if (channel.transferFrom(channel2, 0L, size) == size) {
                    if (channel2 != null) {
                        channel2.close();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    return true;
                }
                b(file2);
                if (channel2 != null) {
                    channel2.close();
                }
                if (channel != null) {
                    channel.close();
                }
                return false;
            } catch (Throwable th2) {
                FileChannel fileChannel2 = channel;
                channel = channel2;
                th = th2;
                fileChannel = fileChannel2;
            }
            if (channel != null) {
                channel.close();
            }
            if (fileChannel != null) {
                fileChannel.close();
            }
            throw th;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public static boolean b(InputStream inputStream, ZipEntry zipEntry, String str, String str2) throws Exception {
        a(new File(str));
        String str3 = str + File.separator + str2;
        File file = new File(str3);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i2 = inputStream.read(bArr);
                        if (i2 <= 0) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, i2);
                    }
                    fileOutputStream2.close();
                    if (a(str3, zipEntry.getSize(), zipEntry.getTime(), zipEntry.getCrc())) {
                        TbsLog.e("FileHelper", "file is different: " + str3);
                        return false;
                    }
                    if (file.setLastModified(zipEntry.getTime())) {
                        return true;
                    }
                    TbsLog.e("FileHelper", "Couldn't set time for dst file " + file);
                    return true;
                } catch (IOException e2) {
                    e = e2;
                    b(file);
                    throw new IOException("Couldn't write dst file " + file, e);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    static String c(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "core_private");
        if (file.isDirectory() || file.mkdir()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public static boolean c(File file) {
        return file != null && file.exists() && file.isFile() && file.length() > 0;
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException, OutOfMemoryError {
        long jA = a(inputStream, outputStream);
        if (jA > 2147483647L) {
            return -1;
        }
        return (int) jA;
    }

    public static FileOutputStream d(File file) throws IOException {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                throw new IOException("File '" + file + "' could not be created");
            }
        } else {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (!file.canWrite()) {
                throw new IOException("File '" + file + "' cannot be written to");
            }
        }
        return new FileOutputStream(file);
    }

    public static FileLock d(Context context) {
        FileLock fileLockF;
        StringBuilder sb;
        String str;
        TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #1");
        File fileA = a(context, "tbs_rename_lock");
        TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #4 " + fileA);
        try {
            f19183d = new RandomAccessFile(fileA.getAbsolutePath(), "r");
            fileLockF = f19183d.getChannel().tryLock(0L, Long.MAX_VALUE, true);
        } catch (Throwable th) {
            TbsLog.e("FileHelper", "getTbsCoreLoadFileLock -- exception: " + th);
            fileLockF = null;
        }
        if (fileLockF == null) {
            fileLockF = f(context);
        }
        if (fileLockF == null) {
            sb = new StringBuilder();
            str = "getTbsCoreLoadFileLock -- failed: ";
        } else {
            sb = new StringBuilder();
            str = "getTbsCoreLoadFileLock -- success: ";
        }
        sb.append(str);
        sb.append("tbs_rename_lock");
        TbsLog.i("FileHelper", sb.toString());
        return fileLockF;
    }

    public static FileLock e(Context context) {
        FileLock fileLockTryLock;
        StringBuilder sb;
        String str;
        File fileA = a(context, "tbs_rename_lock");
        TbsLog.i("FileHelper", "getTbsCoreRenameFileLock #1 " + fileA);
        try {
            f19183d = new RandomAccessFile(fileA.getAbsolutePath(), "rw");
            fileLockTryLock = f19183d.getChannel().tryLock(0L, Long.MAX_VALUE, false);
        } catch (Throwable unused) {
            TbsLog.e("FileHelper", "getTbsCoreRenameFileLock -- excpetion: tbs_rename_lock");
            fileLockTryLock = null;
        }
        if (fileLockTryLock == null) {
            sb = new StringBuilder();
            str = "getTbsCoreRenameFileLock -- failed: ";
        } else {
            sb = new StringBuilder();
            str = "getTbsCoreRenameFileLock -- success: ";
        }
        sb.append(str);
        sb.append("tbs_rename_lock");
        TbsLog.i("FileHelper", sb.toString());
        return fileLockTryLock;
    }

    private static FileLock f(Context context) {
        FileLock fileLock = null;
        try {
            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
            tbsLogInfo.setErrorCode(803);
            File fileA = a(context, "tbs_rename_lock");
            if (!TbsDownloadConfig.getInstance(context).getTbsCoreLoadRenameFileLockWaitEnable()) {
                return null;
            }
            FileLock fileLockTryLock = null;
            int i2 = 0;
            while (i2 < 20 && fileLockTryLock == null) {
                try {
                    try {
                        Thread.sleep(100L);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    f19183d = new RandomAccessFile(fileA.getAbsolutePath(), "r");
                    fileLockTryLock = f19183d.getChannel().tryLock(0L, Long.MAX_VALUE, true);
                } catch (Throwable unused) {
                }
                i2++;
            }
            try {
                if (fileLockTryLock != null) {
                    tbsLogInfo.setErrorCode(802);
                } else {
                    tbsLogInfo.setErrorCode(801);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("getTbsCoreLoadFileLock,retry num=");
                sb.append(i2);
                sb.append("success=");
                sb.append(fileLockTryLock == null);
                TbsLog.i("FileHelper", sb.toString());
                return fileLockTryLock;
            } catch (Exception e3) {
                e = e3;
                fileLock = fileLockTryLock;
                e.printStackTrace();
                return fileLock;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }
}
