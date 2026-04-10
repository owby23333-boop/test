package com.mi.mibridge;

import android.content.Context;
import android.util.Log;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes7.dex */
public class MiBridge {
    private static final String PERFORMANCE_CLASS = "com.miui.performance.MiuiBooster";
    private static final String PERFORMANCE_JAR = "/system/framework/MiuiBooster.jar";
    private static final String TAG = "MiBridge";
    private static Method mCancelCpuHighFunc;
    private static Method mCancelThreadPriorityFunc;
    private static Method mCheckDebugPermissionFunc;
    private static Method mCheckPermissionFunc;
    private static Constructor<Class> mConstructor;
    private static Object mPerf;
    private static Method mRequestCpuHighFunc;
    private static Method mRequestThreadPriorityFunc;
    private static Class perfClass;
    private static PathClassLoader perfClassLoader;

    static {
        try {
            PathClassLoader pathClassLoader = new PathClassLoader(PERFORMANCE_JAR, ClassLoader.getSystemClassLoader());
            perfClassLoader = pathClassLoader;
            Class<?> clsLoadClass = pathClassLoader.loadClass(PERFORMANCE_CLASS);
            perfClass = clsLoadClass;
            mConstructor = clsLoadClass.getConstructor(new Class[0]);
            Class<?> cls = Integer.TYPE;
            mCheckPermissionFunc = perfClass.getDeclaredMethod("checkPermission", String.class, cls);
            mCheckDebugPermissionFunc = perfClass.getDeclaredMethod("checkPermission", Context.class, String.class, cls, String.class);
            mRequestCpuHighFunc = perfClass.getDeclaredMethod("requestCpuHighFreq", cls, cls, cls);
            mCancelCpuHighFunc = perfClass.getDeclaredMethod("cancelCpuHighFreq", cls);
            mRequestThreadPriorityFunc = perfClass.getDeclaredMethod("requestThreadPriority", cls, cls, cls);
            mCancelThreadPriorityFunc = perfClass.getDeclaredMethod("cancelThreadPriority", cls, cls);
        } catch (Exception e) {
            Log.e(TAG, "MiBridge() : Load Class Exception: " + e);
        }
        try {
            Constructor<Class> constructor = mConstructor;
            if (constructor != null) {
                mPerf = constructor.newInstance(new Object[0]);
            }
        } catch (Exception e2) {
            Log.e(TAG, "MiBridge() : newInstance Exception:" + e2);
        }
    }

    public static int cancelCpuHighFreq(int i) {
        try {
            return ((Integer) mCancelCpuHighFunc.invoke(mPerf, Integer.valueOf(i))).intValue();
        } catch (Exception e) {
            Log.e(TAG, "cancel cpu high failed, e:" + e.toString());
            return -1;
        }
    }

    public static int cancelThreadPriority(int i, int i2) {
        try {
            return ((Integer) mCancelThreadPriorityFunc.invoke(mPerf, Integer.valueOf(i), Integer.valueOf(i2))).intValue();
        } catch (Exception e) {
            Log.e(TAG, "cancel thread priority failed, e:" + e.toString());
            return -1;
        }
    }

    public static boolean checkDebugPermission(Context context, String str, int i, String str2) {
        try {
            return ((Boolean) mCheckDebugPermissionFunc.invoke(mPerf, context, str, Integer.valueOf(i), str2)).booleanValue();
        } catch (Exception e) {
            Log.e(TAG, "check debug permission failed , e:" + e.toString());
            return false;
        }
    }

    public static boolean checkPermission(String str, int i) {
        try {
            return ((Boolean) mCheckPermissionFunc.invoke(mPerf, str, Integer.valueOf(i))).booleanValue();
        } catch (Exception e) {
            Log.e(TAG, "check permission failed , e:" + e.toString());
            return false;
        }
    }

    public static int requestCpuHighFreq(int i, int i2, int i3) {
        try {
            return ((Integer) mRequestCpuHighFunc.invoke(mPerf, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3))).intValue();
        } catch (Exception e) {
            Log.e(TAG, "request cpu high failed , e:" + e.toString());
            return -1;
        }
    }

    public static int requestThreadPriority(int i, int i2, int i3) {
        try {
            return ((Integer) mRequestThreadPriorityFunc.invoke(mPerf, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3))).intValue();
        } catch (Exception e) {
            Log.e(TAG, "request thread priority failed , e:" + e.toString());
            return -1;
        }
    }
}
