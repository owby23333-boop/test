package v;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: C0002b.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static Context a;

    public static Context a() {
        Context context;
        Context context2;
        synchronized (b.class) {
            if (a == null) {
                try {
                    context2 = (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
                } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException e2) {
                    e2.printStackTrace();
                    context2 = null;
                }
                a = context2;
            }
            context = a;
        }
        return context;
    }
}
