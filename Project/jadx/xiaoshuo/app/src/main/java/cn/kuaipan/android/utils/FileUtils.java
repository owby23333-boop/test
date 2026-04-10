package cn.kuaipan.android.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.duokan.reader.domain.store.DkStoreBookInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileLock;
import org.apache.http.util.LangUtils;

/* JADX INFO: loaded from: classes.dex */
public class FileUtils {
    private static final String TAG = "FileUtils";
    private static File sExternalCacheDir;
    private static File sExternalDataDir;
    private static final File EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY = new File(new File(Environment.getExternalStorageDirectory(), DkStoreBookInfo.PLATFORM), "data");
    private static final Object mSync = new Object();

    /* JADX WARN: Code restructure failed: missing block: B:111:?, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:?, code lost:
    
        throw null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fe  */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean copy(java.io.File r15, java.io.File r16, long r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.kuaipan.android.utils.FileUtils.copy(java.io.File, java.io.File, long):boolean");
    }

    public static boolean copyFiles(File file, File file2) {
        if (!file.isDirectory()) {
            File parentFile = file2.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (parentFile.exists() && parentFile.canWrite() && (!file2.exists() || file2.isFile())) {
                return copy(file, file2, -1L);
            }
            return false;
        }
        if (!file2.exists()) {
            file2.mkdirs();
        }
        if (!file2.exists() || !file2.canWrite() || !file2.isDirectory()) {
            return false;
        }
        for (File file3 : file.listFiles()) {
            if (!copyFiles(file3, new File(file2, file3.getName()))) {
                return false;
            }
        }
        return true;
    }

    public static boolean deleteChildren(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return true;
        }
        boolean z = true;
        for (File file2 : fileArrListFiles) {
            z = deletes(file2) && z;
        }
        return z;
    }

    public static boolean deletes(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isDirectory()) {
            deleteChildren(file);
        }
        return file.delete();
    }

    public static File getCacheDir(Context context, String str, boolean z) {
        File cacheDir = getCacheDir(context, z);
        if (cacheDir == null) {
            return null;
        }
        File file = new File(cacheDir, str);
        if (!file.exists()) {
            file.mkdirs();
            if (!file.exists() || !file.isDirectory()) {
                Log.w("FileUtils", "Unable to create cache directory:" + file);
                return null;
            }
        }
        return file;
    }

    public static File getExternalCacheDir(Context context, boolean z) {
        synchronized (mSync) {
            if (sExternalCacheDir == null) {
                sExternalCacheDir = getExternalStorageAppCacheDirectory(context.getPackageName());
            }
            if (!sExternalCacheDir.exists()) {
                try {
                    new File(EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY, ".nomedia").createNewFile();
                } catch (IOException unused) {
                }
                sExternalCacheDir.mkdirs();
                if (z && (!sExternalCacheDir.exists() || !sExternalCacheDir.isDirectory())) {
                    Log.w("FileUtils", "Unable to create external cache directory");
                    return null;
                }
            }
            return sExternalCacheDir;
        }
    }

    public static File getExternalDataDir(Context context, boolean z) {
        synchronized (mSync) {
            if (sExternalDataDir == null) {
                sExternalDataDir = getExternalStorageAppDataDirectory(context.getPackageName());
            }
            if (!sExternalDataDir.exists()) {
                try {
                    new File(EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY, ".nomedia").createNewFile();
                } catch (IOException unused) {
                }
                if (!sExternalDataDir.mkdirs() && z) {
                    Log.w("FileUtils", "Unable to create external cache directory");
                    return null;
                }
            }
            return sExternalDataDir;
        }
    }

    public static File getExternalStorageAppCacheDirectory(String str) {
        return new File(new File(EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY, str), "cache");
    }

    public static File getExternalStorageAppDataDirectory(String str) {
        return new File(new File(EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY, str), "files");
    }

    public static long getSize(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists()) {
            return 0L;
        }
        long length = file.length();
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                length += getSize(file2);
            }
        }
        return length;
    }

    public static boolean isChildPath(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            File file = new File(str);
            for (File file2 = new File(str2); file2 != null; file2 = file2.getParentFile()) {
                if (file.equals(file2)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean move(File file, File file2) {
        if (LangUtils.equals(file, file2)) {
            return true;
        }
        boolean zRenameTo = false;
        if (file2.exists()) {
            return false;
        }
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (!parentFile.exists() || !parentFile.isDirectory() || !parentFile.canWrite()) {
            return false;
        }
        try {
            long jLastModified = file.lastModified();
            zRenameTo = file.renameTo(file2);
            if (zRenameTo) {
                file2.setLastModified(jLastModified);
            }
        } catch (Exception unused) {
        }
        if (zRenameTo) {
            return true;
        }
        return copyFiles(file, file2) ? deletes(file) : zRenameTo;
    }

    public static int setPermissions(String str, int i, int i2, int i3) {
        try {
            return ((Integer) JavaCalls.callStaticMethodOrThrow(Class.forName("android.os.FileUtils"), "setPermissions", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3))).intValue();
        } catch (Exception unused) {
            Log.e("FileUtils", "Failed set Permissions for file: " + str);
            return 0;
        }
    }

    public static void writeTo(InputStream inputStream, File file) throws Throwable {
        FileOutputStream fileOutputStream;
        FileLock fileLockLock = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            fileLockLock = fileOutputStream.getChannel().lock();
            byte[] bArr = new byte[8192];
            while (true) {
                int i = inputStream.read(bArr);
                if (i >= 0) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    try {
                        break;
                    } catch (Throwable unused) {
                    }
                }
            }
            fileLockLock.release();
            try {
                fileOutputStream.close();
            } catch (Throwable unused2) {
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                fileLockLock.release();
            } catch (Throwable unused3) {
            }
            try {
                fileOutputStream.close();
                throw th;
            } catch (Throwable unused4) {
                throw th;
            }
        }
    }

    public static File getCacheDir(Context context, boolean z) {
        return getCacheDir(context, z, true);
    }

    public static File getCacheDir(Context context, boolean z, boolean z2) {
        if (z) {
            return getExternalCacheDir(context, z2);
        }
        return context.getCacheDir();
    }
}
