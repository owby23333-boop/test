package i0.a.b.c.a;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: IdentifierManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static Object a;
    private static Class<?> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f20853c;

    static {
        try {
            b = Class.forName("com.android.id.impl.IdProviderImpl");
            a = b.newInstance();
            b.getMethod("getUDID", Context.class);
            f20853c = b.getMethod("getOAID", Context.class);
            b.getMethod("getVAID", Context.class);
            b.getMethod("getAAID", Context.class);
        } catch (Exception unused) {
        }
    }

    public static boolean a() {
        return (b == null || a == null) ? false : true;
    }

    public static String a(Context context) {
        return a(context, f20853c);
    }

    private static String a(Context context, Method method) {
        Object obj = a;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(obj, context);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
