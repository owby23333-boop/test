package b0;

import android.content.Context;
import java.lang.reflect.Method;
import v.c;

/* JADX INFO: compiled from: C0044a.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static Object a;
    public static Class<?> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f606c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f607d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f608e;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            b = cls;
            a = cls.newInstance();
        } catch (Exception e2) {
            c.b("IdentifierManager", "reflect exception!", e2);
        }
        try {
            Class<?> cls2 = b;
            if (cls2 != null) {
                f606c = cls2.getMethod("getOAID", Context.class);
            }
        } catch (Exception e3) {
            c.b("IdentifierManager", "reflect exception!", e3);
        }
        try {
            Class<?> cls3 = b;
            if (cls3 != null) {
                f607d = cls3.getMethod("getVAID", Context.class);
            }
        } catch (Exception e4) {
            c.b("IdentifierManager", "reflect exception!", e4);
        }
        try {
            Class<?> cls4 = b;
            if (cls4 != null) {
                f608e = cls4.getMethod("getAAID", Context.class);
            }
        } catch (Exception e5) {
            c.b("IdentifierManager", "reflect exception!", e5);
        }
    }

    public static String a(Context context, Method method) {
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
        } catch (Exception e2) {
            c.b("IdentifierManager", "invoke exception!", e2);
            return null;
        }
    }
}
