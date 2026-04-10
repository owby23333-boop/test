package com.bytedance.e.e.v;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class t {
    private static long bf(Context context) {
        try {
            return d(context.getFilesDir().getParentFile());
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long d() {
        try {
            return e(Environment.getRootDirectory());
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static JSONObject e(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("inner_app_used", bf(context));
            jSONObject.put("inner_free", bf());
            jSONObject.put("inner_total", d());
            jSONObject.put("sdcard_app_used", d(context));
            jSONObject.put("sdcard_free", tg());
            jSONObject.put("sdcard_total", ga());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static long ga() {
        try {
            if (e()) {
                return Environment.getExternalStorageDirectory().getTotalSpace();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long tg() {
        try {
            if (e()) {
                return Environment.getExternalStorageDirectory().getFreeSpace();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long d(Context context) {
        File externalFilesDir;
        try {
            if (!e() || (externalFilesDir = context.getExternalFilesDir(null)) == null) {
                return 0L;
            }
            return d(externalFilesDir.getParentFile());
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long bf() {
        try {
            return bf(Environment.getRootDirectory());
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long bf(File file) {
        try {
            return new StatFs(file.getPath()).getFreeBytes();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long d(File file) {
        long length;
        File[] fileArrListFiles = file.listFiles();
        long j = 0;
        if (fileArrListFiles == null) {
            return 0L;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                length = d(file2);
            } else {
                length = file2.length();
            }
            j += length;
        }
        return j;
    }

    public static boolean e() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static long e(File file) {
        try {
            return new StatFs(file.getPath()).getTotalBytes();
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
