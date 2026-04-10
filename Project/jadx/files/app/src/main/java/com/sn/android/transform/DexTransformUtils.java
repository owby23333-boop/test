package com.sn.android.transform;

import androidx.annotation.Keep;
import e0.i;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class DexTransformUtils {
    @Keep
    public static void addClassLoader(ClassLoader classLoader) {
        i.c("DexTransformUtils", "addClassLoader");
        try {
            Method declaredMethod = DexTransformUtils.class.getClassLoader().loadClass("com.sntech.proxylib.ProxyClassLoaders").getDeclaredMethod("addClassLoader", ClassLoader.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, classLoader);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }
}
