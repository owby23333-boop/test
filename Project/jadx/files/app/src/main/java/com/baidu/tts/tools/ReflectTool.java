package com.baidu.tts.tools;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class ReflectTool {
    public static Method getSupportedMethod(Class<?> cls, String str, Class<?>[] clsArr) throws NoSuchMethodException {
        if (cls == null) {
            throw new NoSuchMethodException();
        }
        try {
            return cls.getDeclaredMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            return getSupportedMethod(cls.getSuperclass(), str, clsArr);
        }
    }
}
