package me.imid.swipebacklayout.lib;

import android.app.Activity;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes8.dex */
public class Utils {
    private Utils() {
    }

    public static void convertActivityFromTranslucent(Activity activity) {
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, new Object[0]);
        } catch (Throwable unused) {
        }
    }

    public static void convertActivityToTranslucent(Activity activity) {
        try {
            Class<?> cls = null;
            for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
                if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                    cls = cls2;
                }
            }
            Method declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", cls);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, null);
        } catch (Throwable unused) {
        }
    }
}
