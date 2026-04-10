package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class n {
    private static long a() {
        try {
            return b(Environment.getRootDirectory());
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long a(Context context) {
        try {
            return a(context.getFilesDir().getParentFile());
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long a(File file) {
        File[] fileArrListFiles = file.listFiles();
        long jA = 0;
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                jA += file2.isDirectory() ? a(file2) : file2.length();
            }
        }
        return jA;
    }

    private static long b() {
        try {
            return c(Environment.getRootDirectory());
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long b(Context context) {
        File externalFilesDir;
        try {
            if (e() && (externalFilesDir = context.getExternalFilesDir(null)) != null) {
                return a(externalFilesDir.getParentFile());
            }
        } catch (Exception unused) {
        }
        return 0L;
    }

    public static long b(File file) {
        long availableBlocks;
        try {
            StatFs statFs = new StatFs(file.getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                availableBlocks = statFs.getFreeBytes();
            } else {
                availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            }
            return availableBlocks;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private static long c() {
        try {
            if (e()) {
                return Environment.getExternalStorageDirectory().getFreeSpace();
            }
        } catch (Exception unused) {
        }
        return 0L;
    }

    public static long c(File file) {
        long blockCount;
        try {
            StatFs statFs = new StatFs(file.getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                blockCount = statFs.getTotalBytes();
            } else {
                blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
            }
            return blockCount;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static JSONObject c(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("inner_app_used", a(context));
            jSONObject.put("inner_free", a());
            jSONObject.put("inner_total", b());
            jSONObject.put("sdcard_app_used", b(context));
            jSONObject.put("sdcard_free", c());
            jSONObject.put("sdcard_total", d());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static long d() {
        try {
            if (e()) {
                return Environment.getExternalStorageDirectory().getTotalSpace();
            }
        } catch (Exception unused) {
        }
        return 0L;
    }

    public static boolean e() {
        return "mounted".equals(Environment.getExternalStorageState());
    }
}
