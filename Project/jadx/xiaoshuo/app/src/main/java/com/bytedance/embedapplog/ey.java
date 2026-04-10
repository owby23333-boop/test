package com.bytedance.embedapplog;

import android.content.Context;
import com.bytedance.embedapplog.rk;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
final class ey implements rk {
    private static Class<?> bf;
    private static Method d;
    private static Object e;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            bf = cls;
            e = cls.newInstance();
            d = bf.getMethod("getOAID", Context.class);
        } catch (Exception e2) {
            tx.e("Api#static reflect exception! " + e2.getMessage());
        }
    }

    public static boolean e() {
        return (bf == null || e == null || d == null) ? false : true;
    }

    @Override // com.bytedance.embedapplog.rk
    public boolean bf(Context context) {
        return e();
    }

    @Override // com.bytedance.embedapplog.rk
    public rk.e d(Context context) {
        try {
            rk.e eVar = new rk.e();
            eVar.bf = e(context, d);
            return eVar;
        } catch (Exception e2) {
            tx.e(e2);
            return null;
        }
    }

    private static String e(Context context, Method method) {
        Object obj = e;
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
