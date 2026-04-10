package com.bytedance.z.g.gz;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Field f1521a;
    private static Field dl;
    private static Class<?> g;
    private static boolean gc;
    private static String z;

    public static boolean dl(Context context) {
        return false;
    }

    private static long z(int i) {
        if (i < 0) {
            return 0L;
        }
        return ((long) i) * 1024;
    }

    public static boolean z(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ComponentName componentName;
        if (context == null) {
            return false;
        }
        String packageName = context.getPackageName();
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && !runningTasks.isEmpty() && (componentName = runningTasks.get(0).topActivity) != null) {
                if (packageName.equals(componentName.getPackageName())) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static ActivityManager.ProcessErrorStateInfo z(Context context, int i) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager == null) {
            return null;
        }
        for (int i2 = 0; i2 < i; i2++) {
            SystemClock.sleep(200L);
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                    if (processErrorStateInfo.condition == 2) {
                        return processErrorStateInfo;
                    }
                }
            }
        }
        return null;
    }

    public static boolean g(Context context) {
        String strA = a(context);
        if (strA != null && strA.contains(":")) {
            return false;
        }
        if (strA == null || !strA.equals(context.getPackageName())) {
            return strA != null && strA.equals(context.getApplicationInfo().processName);
        }
        return true;
    }

    public static String a(Context context) {
        String str = z;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            z = wp.z(context);
        } catch (Throwable unused) {
        }
        String str2 = z;
        return str2 == null ? "" : str2;
    }

    public static void z(Context context, JSONObject jSONObject) {
        try {
            z(jSONObject);
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager != null) {
                g(jSONObject, activityManager);
            }
            z(jSONObject, activityManager);
        } catch (Throwable unused) {
        }
    }

    private static void z(JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("native_heap_size", Debug.getNativeHeapSize());
        jSONObject2.put("native_heap_alloc_size", Debug.getNativeHeapAllocatedSize());
        jSONObject2.put("native_heap_free_size", Debug.getNativeHeapFreeSize());
        Runtime runtime = Runtime.getRuntime();
        jSONObject2.put("max_memory", runtime.maxMemory());
        jSONObject2.put("free_memory", runtime.freeMemory());
        jSONObject2.put("total_memory", runtime.totalMemory());
        if (activityManager != null) {
            jSONObject2.put("memory_class", activityManager.getMemoryClass());
            jSONObject2.put("large_memory_class", activityManager.getLargeMemoryClass());
        }
        jSONObject.put("app_memory_info", jSONObject2);
    }

    private static void g(JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        jSONObject2.put("availMem", memoryInfo.availMem);
        jSONObject2.put("lowMemory", memoryInfo.lowMemory);
        jSONObject2.put("threshold", memoryInfo.threshold);
        jSONObject2.put("totalMem", e.z(memoryInfo));
        jSONObject.put("sys_memory_info", jSONObject2);
    }

    private static void z(JSONObject jSONObject) throws JSONException {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("dalvikPrivateDirty", z(memoryInfo.dalvikPrivateDirty));
        jSONObject2.put("dalvikPss", z(memoryInfo.dalvikPss));
        jSONObject2.put("dalvikSharedDirty", z(memoryInfo.dalvikSharedDirty));
        jSONObject2.put("nativePrivateDirty", z(memoryInfo.nativePrivateDirty));
        jSONObject2.put("nativePss", z(memoryInfo.nativePss));
        jSONObject2.put("nativeSharedDirty", z(memoryInfo.nativeSharedDirty));
        jSONObject2.put("otherPrivateDirty", z(memoryInfo.otherPrivateDirty));
        jSONObject2.put("otherPss", z(memoryInfo.otherPss));
        jSONObject2.put("otherSharedDirty", memoryInfo.otherSharedDirty);
        jSONObject2.put("totalPrivateClean", g.z(memoryInfo));
        jSONObject2.put("totalPrivateDirty", memoryInfo.getTotalPrivateDirty());
        jSONObject2.put("totalPss", z(memoryInfo.getTotalPss()));
        jSONObject2.put("totalSharedClean", g.g(memoryInfo));
        jSONObject2.put("totalSharedDirty", z(memoryInfo.getTotalSharedDirty()));
        jSONObject2.put("totalSwappablePss", z(g.dl(memoryInfo)));
        jSONObject.put("memory_info", jSONObject2);
    }

    public static String gc(Context context) {
        Class<?> clsE = e(context);
        if (dl == null && clsE != null) {
            try {
                dl = clsE.getDeclaredField("VERSION_NAME");
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = dl;
        if (field == null) {
            return "";
        }
        try {
            return (String) field.get(null);
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static int m(Context context) {
        Class<?> clsE = e(context);
        if (f1521a == null && clsE != null) {
            try {
                f1521a = clsE.getDeclaredField("VERSION_CODE");
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = f1521a;
        if (field == null) {
            return -1;
        }
        try {
            return ((Integer) field.get(null)).intValue();
        } catch (Throwable unused2) {
            return -1;
        }
    }

    private static Class<?> e(Context context) {
        if (g == null && !gc) {
            try {
                g = Class.forName(context.getPackageName() + ".BuildConfig");
            } catch (ClassNotFoundException unused) {
            }
            gc = true;
        }
        return g;
    }
}
