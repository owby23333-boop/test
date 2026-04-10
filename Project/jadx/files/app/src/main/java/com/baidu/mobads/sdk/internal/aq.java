package com.baidu.mobads.sdk.internal;

import android.content.Context;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class aq {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile Map<String, aq> f12865c = new HashMap();
    private Class<?> a;
    private Method[] b;

    private aq(Context context, String str) {
        this.b = null;
        try {
            this.a = Class.forName(str, true, bp.a(context));
            this.b = this.a.getMethods();
        } catch (Throwable th) {
            bq.a().a(th);
        }
    }

    public static aq a(Context context, String str) {
        if (!f12865c.containsKey(str) || f12865c.get(str).a == null) {
            synchronized (aq.class) {
                if (!f12865c.containsKey(str) || f12865c.get(str).a == null) {
                    f12865c.put(str, new aq(context, str));
                }
            }
        }
        return f12865c.get(str);
    }

    public Object b(Object obj, String str, Object... objArr) {
        try {
            Method methodA = a(str);
            if (methodA == null) {
                return null;
            }
            if (objArr != null && objArr.length != 0) {
                return methodA.invoke(obj, objArr);
            }
            return methodA.invoke(obj, new Object[0]);
        } catch (Throwable th) {
            bq.a().a(th);
            return null;
        }
    }

    public String c(Object obj, String str, Object... objArr) {
        try {
            Method methodA = a(str);
            if (methodA == null) {
                return null;
            }
            Object objInvoke = (objArr == null || objArr.length == 0) ? methodA.invoke(obj, new Object[0]) : methodA.invoke(obj, objArr);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (Throwable th) {
            bq.a().a(th);
            return null;
        }
    }

    public Object a(Class<?>[] clsArr, Object... objArr) {
        Constructor<?> constructor;
        if (objArr != null) {
            try {
                if (objArr.length != 0) {
                    constructor = this.a.getConstructor(clsArr);
                } else {
                    constructor = this.a.getConstructor(new Class[0]);
                }
            } catch (Throwable th) {
                bq.a().a(th);
                return null;
            }
        } else {
            constructor = this.a.getConstructor(new Class[0]);
        }
        return constructor.newInstance(objArr);
    }

    public void a(Object obj, String str, Object... objArr) {
        try {
            Method methodA = a(str);
            if (methodA != null) {
                if (objArr != null && objArr.length != 0) {
                    methodA.invoke(obj, objArr);
                } else {
                    methodA.invoke(obj, new Object[0]);
                }
            }
        } catch (Throwable th) {
            bq.a().a(th);
        }
    }

    private Method a(String str) {
        Method[] methodArr = this.b;
        if (methodArr == null) {
            return null;
        }
        for (Method method : methodArr) {
            if (method.getName().equals(str)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }
}
