package i0.a.b.b.a.a;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private static Method a;

    public static String a(Context context) {
        f fVarA = f.a();
        return fVarA.a(context.getApplicationContext(), fVarA.b);
    }

    public static final boolean a() {
        Context context = null;
        try {
            if (a == null) {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
                a = method;
                method.setAccessible(true);
            }
            context = (Context) a.invoke(null, new Object[0]);
        } catch (Exception e2) {
            String str = "ActivityThread:currentApplication --> " + e2.toString();
        }
        if (context == null) {
            return false;
        }
        return f.a().a(context, false);
    }
}
