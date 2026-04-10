package com.bytedance.e.e.v;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    private static Class<?> bf = null;
    private static Field d = null;
    private static String e = null;
    private static boolean ga = false;
    private static Field tg;

    public static boolean bf(Context context) {
        String strTg = tg(context);
        if (strTg != null && strTg.contains(":")) {
            return false;
        }
        if (strTg == null || !strTg.equals(context.getPackageName())) {
            return strTg != null && strTg.equals(context.getApplicationInfo().processName);
        }
        return true;
    }

    public static boolean d(Context context) {
        return false;
    }

    private static long e(int i) {
        if (i < 0) {
            return 0L;
        }
        return ((long) i) * 1024;
    }

    @NonNull
    public static String ga(Context context) {
        Class<?> clsP = p(context);
        if (d == null && clsP != null) {
            try {
                d = clsP.getDeclaredField("VERSION_NAME");
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = d;
        if (field == null) {
            return "";
        }
        try {
            return (String) field.get(null);
        } catch (Throwable unused2) {
            return "";
        }
    }

    @Nullable
    private static Class<?> p(Context context) {
        if (bf == null && !ga) {
            try {
                bf = Class.forName(context.getPackageName() + ".BuildConfig");
            } catch (ClassNotFoundException unused) {
            }
            ga = true;
        }
        return bf;
    }

    @Nullable
    public static String tg(Context context) {
        String str = e;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            int iMyPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == iMyPid) {
                        String str2 = runningAppProcessInfo.processName;
                        e = str2;
                        return str2;
                    }
                }
            }
        } catch (Throwable th) {
            m.bf(th);
        }
        String strE = e();
        e = strE;
        return strE == null ? "" : strE;
    }

    public static int vn(Context context) {
        Class<?> clsP = p(context);
        if (tg == null && clsP != null) {
            try {
                tg = clsP.getDeclaredField("VERSION_CODE");
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = tg;
        if (field == null) {
            return -1;
        }
        try {
            return ((Integer) field.get(null)).intValue();
        } catch (Throwable unused2) {
            return -1;
        }
    }

    public static boolean e(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return false;
        }
        String packageName = context.getPackageName();
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.importance == 100) {
                        return packageName.equals(runningAppProcessInfo.pkgList[0]);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static void bf(@NonNull JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        jSONObject2.put("availMem", memoryInfo.availMem);
        jSONObject2.put("lowMemory", memoryInfo.lowMemory);
        jSONObject2.put("threshold", memoryInfo.threshold);
        jSONObject2.put("totalMem", p.e(memoryInfo));
        jSONObject.put("sys_memory_info", jSONObject2);
    }

    @Nullable
    public static ActivityManager.ProcessErrorStateInfo e(Context context, int i) {
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

    @Nullable
    private static String e() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i = bufferedReader.read();
                    if (i > 0) {
                        sb.append((char) i);
                    } else {
                        String string = sb.toString();
                        vn.e(bufferedReader);
                        return string;
                    }
                }
            } catch (Throwable unused) {
                vn.e(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static void e(@NonNull Context context, @NonNull JSONObject jSONObject) {
        try {
            e(jSONObject);
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager != null) {
                bf(jSONObject, activityManager);
            }
            e(jSONObject, activityManager);
        } catch (Throwable unused) {
        }
    }

    private static void e(@NonNull JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
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

    private static void e(@NonNull JSONObject jSONObject) throws JSONException {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("dalvikPrivateDirty", e(memoryInfo.dalvikPrivateDirty));
        jSONObject2.put("dalvikPss", e(memoryInfo.dalvikPss));
        jSONObject2.put("dalvikSharedDirty", e(memoryInfo.dalvikSharedDirty));
        jSONObject2.put("nativePrivateDirty", e(memoryInfo.nativePrivateDirty));
        jSONObject2.put("nativePss", e(memoryInfo.nativePss));
        jSONObject2.put("nativeSharedDirty", e(memoryInfo.nativeSharedDirty));
        jSONObject2.put("otherPrivateDirty", e(memoryInfo.otherPrivateDirty));
        jSONObject2.put("otherPss", e(memoryInfo.otherPss));
        jSONObject2.put("otherSharedDirty", memoryInfo.otherSharedDirty);
        jSONObject2.put("totalPrivateClean", bf.e(memoryInfo));
        jSONObject2.put("totalPrivateDirty", memoryInfo.getTotalPrivateDirty());
        jSONObject2.put("totalPss", e(memoryInfo.getTotalPss()));
        jSONObject2.put("totalSharedClean", bf.bf(memoryInfo));
        jSONObject2.put("totalSharedDirty", e(memoryInfo.getTotalSharedDirty()));
        jSONObject2.put("totalSwappablePss", e(bf.d(memoryInfo)));
        jSONObject.put("memory_info", jSONObject2);
    }
}
