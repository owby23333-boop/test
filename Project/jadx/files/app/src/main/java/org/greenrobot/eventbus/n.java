package org.greenrobot.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SubscriberMethodFinder.java */
/* JADX INFO: loaded from: classes3.dex */
class n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<Class<?>, List<m>> f21344d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final a[] f21345e = new a[4];
    private List<org.greenrobot.eventbus.p.b> a;
    private final boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f21346c;

    n(List<org.greenrobot.eventbus.p.b> list, boolean z2, boolean z3) {
        this.a = list;
        this.b = z2;
        this.f21346c = z3;
    }

    private List<m> b(Class<?> cls) {
        a aVarA = a();
        aVarA.a(cls);
        while (aVarA.f21349e != null) {
            aVarA.f21351g = c(aVarA);
            org.greenrobot.eventbus.p.a aVar = aVarA.f21351g;
            if (aVar != null) {
                for (m mVar : aVar.a()) {
                    if (aVarA.a(mVar.a, mVar.f21340c)) {
                        aVarA.a.add(mVar);
                    }
                }
            } else {
                a(aVarA);
            }
            aVarA.a();
        }
        return b(aVarA);
    }

    private org.greenrobot.eventbus.p.a c(a aVar) {
        org.greenrobot.eventbus.p.a aVar2 = aVar.f21351g;
        if (aVar2 != null && aVar2.c() != null) {
            org.greenrobot.eventbus.p.a aVarC = aVar.f21351g.c();
            if (aVar.f21349e == aVarC.b()) {
                return aVarC;
            }
        }
        List<org.greenrobot.eventbus.p.b> list = this.a;
        if (list == null) {
            return null;
        }
        Iterator<org.greenrobot.eventbus.p.b> it = list.iterator();
        while (it.hasNext()) {
            org.greenrobot.eventbus.p.a aVarA = it.next().a(aVar.f21349e);
            if (aVarA != null) {
                return aVarA;
            }
        }
        return null;
    }

    List<m> a(Class<?> cls) {
        List<m> list = f21344d.get(cls);
        if (list != null) {
            return list;
        }
        List<m> listC = this.f21346c ? c(cls) : b(cls);
        if (!listC.isEmpty()) {
            f21344d.put(cls, listC);
            return listC;
        }
        throw new EventBusException("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }

    /* JADX INFO: compiled from: SubscriberMethodFinder.java */
    static class a {
        final List<m> a = new ArrayList();
        final Map<Class, Object> b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Map<String, Class> f21347c = new HashMap();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final StringBuilder f21348d = new StringBuilder(128);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Class<?> f21349e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f21350f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        org.greenrobot.eventbus.p.a f21351g;

        a() {
        }

        void a(Class<?> cls) {
            this.f21349e = cls;
            this.f21350f = false;
            this.f21351g = null;
        }

        void b() {
            this.a.clear();
            this.b.clear();
            this.f21347c.clear();
            this.f21348d.setLength(0);
            this.f21349e = null;
            this.f21350f = false;
            this.f21351g = null;
        }

        boolean a(Method method, Class<?> cls) {
            Object objPut = this.b.put(cls, method);
            if (objPut == null) {
                return true;
            }
            if (objPut instanceof Method) {
                if (b((Method) objPut, cls)) {
                    this.b.put(cls, this);
                } else {
                    throw new IllegalStateException();
                }
            }
            return b(method, cls);
        }

        private boolean b(Method method, Class<?> cls) {
            this.f21348d.setLength(0);
            this.f21348d.append(method.getName());
            StringBuilder sb = this.f21348d;
            sb.append('>');
            sb.append(cls.getName());
            String string = this.f21348d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class clsPut = this.f21347c.put(string, declaringClass);
            if (clsPut == null || clsPut.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.f21347c.put(string, clsPut);
            return false;
        }

        void a() {
            if (this.f21350f) {
                this.f21349e = null;
                return;
            }
            this.f21349e = this.f21349e.getSuperclass();
            String name = this.f21349e.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                this.f21349e = null;
            }
        }
    }

    private List<m> c(Class<?> cls) {
        a aVarA = a();
        aVarA.a(cls);
        while (aVarA.f21349e != null) {
            a(aVarA);
            aVarA.a();
        }
        return b(aVarA);
    }

    private a a() {
        synchronized (f21345e) {
            for (int i2 = 0; i2 < 4; i2++) {
                a aVar = f21345e[i2];
                if (aVar != null) {
                    f21345e[i2] = null;
                    return aVar;
                }
            }
            return new a();
        }
    }

    private List<m> b(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.a);
        aVar.b();
        synchronized (f21345e) {
            int i2 = 0;
            while (true) {
                if (i2 >= 4) {
                    break;
                }
                if (f21345e[i2] == null) {
                    f21345e[i2] = aVar;
                    break;
                }
                i2++;
            }
        }
        return arrayList;
    }

    private void a(a aVar) {
        Method[] methods;
        try {
            methods = aVar.f21349e.getDeclaredMethods();
        } catch (Throwable unused) {
            methods = aVar.f21349e.getMethods();
            aVar.f21350f = true;
        }
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    Subscribe subscribe = (Subscribe) method.getAnnotation(Subscribe.class);
                    if (subscribe != null) {
                        Class<?> cls = parameterTypes[0];
                        if (aVar.a(method, cls)) {
                            aVar.a.add(new m(method, cls, subscribe.threadMode(), subscribe.priority(), subscribe.sticky()));
                        }
                    }
                } else if (this.b && method.isAnnotationPresent(Subscribe.class)) {
                    throw new EventBusException("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                }
            } else if (this.b && method.isAnnotationPresent(Subscribe.class)) {
                throw new EventBusException((method.getDeclaringClass().getName() + "." + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
            }
        }
    }
}
