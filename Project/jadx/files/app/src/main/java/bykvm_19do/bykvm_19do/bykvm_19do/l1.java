package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
final class l1 {
    static void a(Context context) throws IllegalAccessException, ClassNotFoundException, InvocationTargetException {
        Class<?> cls = Class.forName("com.bun.miitmdid.core.JLibrary");
        if (cls.getDeclaredField("context").get(cls) == null) {
            cls.getDeclaredMethod("InitEntry", Context.class).invoke(cls, context);
        }
    }
}
