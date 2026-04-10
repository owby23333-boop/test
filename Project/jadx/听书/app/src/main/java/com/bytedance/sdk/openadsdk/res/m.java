package com.bytedance.sdk.openadsdk.res;

import android.graphics.drawable.Drawable;
import android.widget.ProgressBar;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    public static void z(ProgressBar progressBar, Drawable drawable) {
        z(progressBar, "mIndeterminateOnly", Boolean.FALSE);
        progressBar.setIndeterminate(false);
        progressBar.setProgressDrawable(drawable);
        progressBar.setIndeterminateDrawable(null);
    }

    private static void z(Object obj, String str, Object obj2) {
        try {
            Field fieldZ = z(obj, str);
            if (fieldZ == null) {
                throw new IllegalArgumentException("Could not find field [" + str + "] on target [" + obj + "]");
            }
            z(fieldZ);
            fieldZ.set(obj, obj2);
        } catch (Throwable unused) {
        }
    }

    private static Field z(Object obj, String str) {
        return z((Class) obj.getClass(), str);
    }

    private static Field z(Class cls, String str) {
        while (cls != Object.class) {
            try {
                return cls.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    private static void z(Field field) {
        if (Modifier.isPublic(field.getModifiers()) && Modifier.isPublic(field.getDeclaringClass().getModifiers())) {
            return;
        }
        field.setAccessible(true);
    }
}
