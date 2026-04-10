package com.bytedance.notpluginpro;

import android.content.Context;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class tmapcloaknotplugin {
    static String ApkPath = null;
    static String Apkname = null;
    static String Apkname_full = null;
    static String CPUABI = null;
    static String DataPath = null;
    static int DexNum = 1;
    static String LibBasicPath = null;
    static String LibPath = null;
    static Context ctx = null;
    static final String libName = "libnotpluginpro.so";
    static long vmpctx;

    static {
        try {
            System.loadLibrary("notpluginpro");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static native byte bob_bytedance_call_notplugin(int i2, int i3, Object... objArr);

    public static native char cob_bytedance_call_notplugin(int i2, int i3, Object... objArr);

    public static native double dob_bytedance_call_notplugin(int i2, int i3, Object... objArr);

    public static native float fob_bytedance_call_notplugin(int i2, int i3, Object... objArr);

    public static native void init(int i2);

    public static native int iob_bytedance_call_notplugin(int i2, int i3, Object... objArr);

    public static native long job_bytedance_call_notplugin(int i2, int i3, Object... objArr);

    public static native Object obj_bytedance_call_notplugin(int i2, int i3, Object... objArr);

    public static void setaccessible(Constructor constructor) {
        constructor.setAccessible(true);
    }

    public static void setaccessible(Field field) {
        field.setAccessible(true);
    }

    public static void setaccessible(Method method) {
        method.setAccessible(true);
    }

    public static Object setaccessibleobj(Class cls) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        return declaredConstructor.newInstance(new Object[0]);
    }

    public static native short sob_bytedance_call_notplugin(int i2, int i3, Object... objArr);

    public static native void voi_bytedance_call_notplugin(int i2, int i3, Object... objArr);

    public static native boolean zob_bytedance_call_notplugin(int i2, int i3, Object... objArr);
}
