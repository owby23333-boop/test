package com.mi.mibridge;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes7.dex */
public class DeviceLevel {
    public static int CPU = 0;
    public static final int DEV_STANDARD_VER = 1;
    public static int GPU = 0;
    public static int HIGH = 0;
    public static int LOW = 0;
    public static int MIDDLE = 0;
    private static final String PERFORMANCE_CLASS = "com.miui.performance.DeviceLevelUtils";
    private static final String PERFORMANCE_JAR = "/system/framework/MiuiBooster.jar";
    public static int RAM = 0;
    private static final String TAG = "DeviceLevel";
    public static int UNKNOWN;
    private static Application application;
    private static Context applicationContext;
    private static Constructor<Class> mConstructor;
    private static Method mGetDeviceLevel;
    private static Method mGetDeviceLevelForWhole;
    private static Method mInitDeviceLevel;
    private static Method mIsSupportPrune;
    private static Object mPerf;
    private static Class perfClass;
    private static PathClassLoader perfClassLoader;

    static {
        try {
            PathClassLoader pathClassLoader = new PathClassLoader(PERFORMANCE_JAR, ClassLoader.getSystemClassLoader());
            perfClassLoader = pathClassLoader;
            Class<?> clsLoadClass = pathClassLoader.loadClass(PERFORMANCE_CLASS);
            perfClass = clsLoadClass;
            mConstructor = clsLoadClass.getConstructor(Context.class);
            mInitDeviceLevel = perfClass.getDeclaredMethod("initDeviceLevel", new Class[0]);
            Class<?> cls = Integer.TYPE;
            mGetDeviceLevel = perfClass.getDeclaredMethod("getDeviceLevel", cls, cls);
            mGetDeviceLevelForWhole = perfClass.getDeclaredMethod("getDeviceLevel", cls);
            mIsSupportPrune = perfClass.getDeclaredMethod("isSupportPrune", new Class[0]);
            RAM = ((Integer) getStaticObjectField(perfClass, "DEVICE_LEVEL_FOR_RAM", cls)).intValue();
            CPU = ((Integer) getStaticObjectField(perfClass, "DEVICE_LEVEL_FOR_CPU", cls)).intValue();
            GPU = ((Integer) getStaticObjectField(perfClass, "DEVICE_LEVEL_FOR_GPU", cls)).intValue();
            LOW = ((Integer) getStaticObjectField(perfClass, "LOW_DEVICE", cls)).intValue();
            MIDDLE = ((Integer) getStaticObjectField(perfClass, "MIDDLE_DEVICE", cls)).intValue();
            HIGH = ((Integer) getStaticObjectField(perfClass, "HIGH_DEVICE", cls)).intValue();
            UNKNOWN = ((Integer) getStaticObjectField(perfClass, "DEVICE_LEVEL_UNKNOWN", cls)).intValue();
        } catch (Exception e) {
            Log.e(TAG, "MiDeviceLevelBridge(): Load Class Exception:" + e);
        }
        if (applicationContext == null) {
            try {
                Application application2 = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
                application = application2;
                if (application2 != null) {
                    applicationContext = application2.getApplicationContext();
                }
            } catch (Exception e2) {
                Log.e(TAG, "android.app.ActivityThread Exception:" + e2);
            }
        }
        if (applicationContext == null) {
            try {
                Application application3 = (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new Class[0]).invoke(null, null);
                application = application3;
                if (application3 != null) {
                    applicationContext = application3.getApplicationContext();
                }
            } catch (Exception e3) {
                Log.e(TAG, "android.app.AppGlobals Exception:" + e3);
            }
        }
        try {
            Constructor<Class> constructor = mConstructor;
            if (constructor != null) {
                mPerf = constructor.newInstance(applicationContext);
            }
        } catch (Exception e4) {
            Log.e(TAG, "DeviceLevelUtils(): newInstance Exception:" + e4);
            e4.printStackTrace();
        }
    }

    public static int getDeviceLevel(int i, int i2) {
        try {
            return ((Integer) mGetDeviceLevel.invoke(mPerf, Integer.valueOf(i), Integer.valueOf(i2))).intValue();
        } catch (Exception e) {
            Log.e(TAG, "getDeviceLevel failed , e:" + e.toString());
            return -1;
        }
    }

    private static <T> T getStaticObjectField(Class<?> cls, String str, Class<T> cls2) throws Exception {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return (T) declaredField.get(null);
    }

    public static void initDeviceLevel() {
        try {
            mInitDeviceLevel.invoke(mPerf, new Object[0]);
        } catch (Exception e) {
            Log.e(TAG, "initDeviceLevel failed , e:" + e.toString());
        }
    }

    public static boolean isSupportPrune() {
        try {
            return ((Boolean) mIsSupportPrune.invoke(mPerf, new Object[0])).booleanValue();
        } catch (Exception e) {
            Log.e(TAG, "isSupportPrune failed , e:" + e.toString());
            return false;
        }
    }

    public static int getDeviceLevel(int i) {
        try {
            return ((Integer) mGetDeviceLevelForWhole.invoke(mPerf, Integer.valueOf(i))).intValue();
        } catch (Exception e) {
            Log.e(TAG, "getDeviceLevel failed , e:" + e.toString());
            return -1;
        }
    }
}
