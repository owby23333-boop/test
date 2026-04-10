package com.bytedance.dutexplorer;

import com.bytedance.component.sdk.annotation.Keep;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class tmapcloak {
    static int DexNum;

    static {
        try {
            if (DexNum > 0) {
                System.loadLibrary("maparmor");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static native byte bob_bytedance_call(int i, int i2, Object... objArr);

    public static native char cob_bytedance_call(int i, int i2, Object... objArr);

    public static native double dob_bytedance_call(int i, int i2, Object... objArr);

    public static native float fob_bytedance_call(int i, int i2, Object... objArr);

    public static native int iob_bytedance_call(int i, int i2, Object... objArr);

    public static native long job_bytedance_call(int i, int i2, Object... objArr);

    public static native Object obj_bytedance_call(int i, int i2, Object... objArr);

    public static void setaccessible(Constructor constructor) {
        constructor.setAccessible(true);
    }

    public static Object setaccessibleobj(Class cls) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        return declaredConstructor.newInstance(new Object[0]);
    }

    public static native short sob_bytedance_call(int i, int i2, Object... objArr);

    public static native void voi_bytedance_call(int i, int i2, Object... objArr);

    public static native boolean zob_bytedance_call(int i, int i2, Object... objArr);

    public static void setaccessible(Method method) {
        method.setAccessible(true);
    }

    public static void setaccessible(Field field) {
        field.setAccessible(true);
    }
}
