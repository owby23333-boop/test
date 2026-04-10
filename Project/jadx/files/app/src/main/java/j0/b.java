package j0;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: OpenIdHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static final boolean a() throws Throwable {
        Context context;
        try {
            Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
            method.setAccessible(true);
            context = (Context) method.invoke(null, new Object[0]);
        } catch (Exception e2) {
            StringBuilder sbA = y.b.a("ActivityThread:currentApplication --> ");
            sbA.append(e2.toString());
            sbA.toString();
            context = null;
        }
        if (context == null) {
            return false;
        }
        return a.a().a(context, false);
    }
}
