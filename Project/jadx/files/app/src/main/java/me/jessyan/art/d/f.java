package me.jessyan.art.d;

import java.lang.reflect.Method;
import org.greenrobot.eventbus.Subscribe;
import org.simple.eventbus.EventBus;

/* JADX INFO: compiled from: EventBusManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    private static volatile f a;

    private f() {
    }

    public static f a() {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f();
                }
            }
        }
        return a;
    }

    private boolean c(Object obj) {
        Method[] methods;
        Class<?> superclass = obj.getClass();
        boolean z2 = false;
        while (superclass != null && !a(superclass.getName()) && !z2) {
            try {
                try {
                    methods = superclass.getDeclaredMethods();
                } catch (Throwable unused) {
                    z2 = true;
                }
            } catch (Throwable unused2) {
                methods = superclass.getMethods();
                z2 = true;
            }
            for (Method method : methods) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (method.isAnnotationPresent(Subscribe.class) && parameterTypes.length == 1) {
                    return true;
                }
            }
            superclass = superclass.getSuperclass();
        }
        return false;
    }

    public void b(Object obj) {
        if (me.jessyan.art.base.e.b) {
            EventBus.getDefault().unregister(obj);
        }
        if (me.jessyan.art.base.e.f21150c && c(obj)) {
            org.greenrobot.eventbus.c.c().c(obj);
        }
    }

    public void a(Object obj) {
        if (me.jessyan.art.base.e.b) {
            EventBus.getDefault().register(obj);
        }
        if (me.jessyan.art.base.e.f21150c && c(obj)) {
            org.greenrobot.eventbus.c.c().b(obj);
        }
    }

    public void a(Object obj, String str) {
        if (me.jessyan.art.base.e.b) {
            EventBus.getDefault().post(obj, str);
        } else if (me.jessyan.art.base.e.f21150c) {
            org.greenrobot.eventbus.c.c().a(obj);
        }
    }

    private boolean a(String str) {
        return str.startsWith("java.") || str.startsWith("javax.") || str.startsWith("android.");
    }
}
