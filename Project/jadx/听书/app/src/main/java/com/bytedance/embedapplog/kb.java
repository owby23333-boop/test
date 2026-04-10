package com.bytedance.embedapplog;

import android.content.Context;
import com.bytedance.embedapplog.gm;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
final class kb implements gm {
    private static Method dl;
    private static Class<?> g;
    private static Object z;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            g = cls;
            z = cls.newInstance();
            dl = g.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            cb.z("Api#static reflect exception! " + e.getMessage());
        }
    }

    kb() {
    }

    static boolean z() {
        return (g == null || z == null || dl == null) ? false : true;
    }

    @Override // com.bytedance.embedapplog.gm
    public boolean z(Context context) {
        return z();
    }

    @Override // com.bytedance.embedapplog.gm
    public gm.z g(Context context) {
        try {
            gm.z zVar = new gm.z();
            zVar.g = z(context, dl);
            return zVar;
        } catch (Exception e) {
            cb.z(e);
            return null;
        }
    }

    private static String z(Context context, Method method) {
        Object obj = z;
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
