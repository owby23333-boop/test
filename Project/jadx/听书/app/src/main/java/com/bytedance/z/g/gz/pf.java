package com.bytedance.z.g.gz;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class pf {
    public static JSONObject z(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("inner_app_used", g(context));
            jSONObject.put("inner_free", g());
            jSONObject.put("inner_total", dl());
            jSONObject.put("sdcard_app_used", dl(context));
            jSONObject.put("sdcard_free", a());
            jSONObject.put("sdcard_total", gc());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static long g(Context context) {
        try {
            return dl(com.bytedance.sdk.openadsdk.api.plugin.g.z(context).getParentFile());
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long g() {
        try {
            return g(Environment.getRootDirectory());
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long dl() {
        try {
            return z(Environment.getRootDirectory());
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long dl(Context context) {
        File fileZ;
        try {
            if (!z() || (fileZ = com.bytedance.sdk.openadsdk.api.plugin.g.z(context, null)) == null) {
                return 0L;
            }
            return dl(fileZ.getParentFile());
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long a() {
        try {
            if (z()) {
                return Environment.getExternalStorageDirectory().getFreeSpace();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long gc() {
        try {
            if (z()) {
                return Environment.getExternalStorageDirectory().getTotalSpace();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static boolean z() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static long z(File file) {
        try {
            return new StatFs(file.getPath()).getTotalBytes();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long g(File file) {
        try {
            return new StatFs(file.getPath()).getFreeBytes();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long dl(File file) {
        long length;
        File[] fileArrListFiles = file.listFiles();
        long j = 0;
        if (fileArrListFiles == null) {
            return 0L;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                length = dl(file2);
            } else {
                length = file2.length();
            }
            j += length;
        }
        return j;
    }
}
