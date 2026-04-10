package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_19do.a1;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
final class m1 implements a1 {
    private static Object a;
    private static Class<?> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f734c;

    static {
        try {
            b = Class.forName("com.android.id.impl.IdProviderImpl");
            a = b.newInstance();
            f734c = b.getMethod("getOAID", Context.class);
        } catch (Exception unused) {
        }
    }

    m1() {
    }

    private static String a(Context context, Method method) {
        Object obj = a;
        if (obj != null && method != null) {
            try {
                Object objInvoke = method.invoke(obj, context);
                if (objInvoke != null) {
                    return (String) objInvoke;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    static boolean a() {
        return (b == null || a == null || f734c == null) ? false : true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.a1
    public boolean a(Context context) {
        return a();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.a1
    public a1.a b(Context context) {
        try {
            a1.a aVar = new a1.a();
            aVar.a = a(context, f734c);
            return aVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
