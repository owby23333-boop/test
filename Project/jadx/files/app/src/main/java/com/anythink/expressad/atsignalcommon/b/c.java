package com.anythink.expressad.atsignalcommon.b;

import com.anythink.expressad.atsignalcommon.b.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private static a a;

    public interface a {
        boolean a();
    }

    public static abstract class b {

        public static class a extends Throwable {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private static final long f8260d = 1;
            private Class<?> a;
            private String b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private String f8261c;

            public a(String str) {
                super(str);
            }

            public final Class<?> a() {
                return this.a;
            }

            public final String b() {
                return this.f8261c;
            }

            public final String c() {
                return this.b;
            }

            @Override // java.lang.Throwable
            public final String toString() {
                if (getCause() == null) {
                    return super.toString();
                }
                return a.class.getName() + ": " + getCause();
            }

            public a(Exception exc) {
                super(exc);
            }

            public final void a(Class<?> cls) {
                this.a = cls;
            }

            public final void b(String str) {
                this.b = str;
            }

            public final void a(String str) {
                this.f8261c = str;
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.atsignalcommon.b.c$c, reason: collision with other inner class name */
    public static class C0177c<C> {
        protected Class<C> a;

        public C0177c(Class<C> cls) {
            this.a = cls;
        }

        private e<C, Object> a(String str) {
            return new e<>(this.a, str, 8);
        }

        private e<C, Object> b(String str) {
            return new e<>(this.a, str, 0);
        }

        private f b(String str, Class<?>... clsArr) {
            return new f(this.a, str, clsArr, 8);
        }

        public final f a(String str, Class<?>... clsArr) {
            return new f(this.a, str, clsArr, 0);
        }

        private d a(Class<?>... clsArr) {
            return new d(this.a, clsArr);
        }

        private Class<C> a() {
            return this.a;
        }
    }

    public static class d {
        protected Constructor<?> a;

        d(Class<?> cls, Class<?>[] clsArr) throws b.a {
            if (cls == null) {
                return;
            }
            try {
                this.a = cls.getDeclaredConstructor(clsArr);
            } catch (NoSuchMethodException e2) {
                b.a aVar = new b.a(e2);
                aVar.a(cls);
                c.b(aVar);
            }
        }

        private Object a(Object... objArr) {
            this.a.setAccessible(true);
            try {
                return this.a.newInstance(objArr);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(b.a aVar) throws b.a {
        a aVar2 = a;
        if (aVar2 == null || !aVar2.a()) {
            throw aVar;
        }
    }

    public static class e<C, T> {
        private Object a;
        private final Field b;

        e(Class<C> cls, String str, int i2) {
            Field declaredField = null;
            if (cls == null) {
                return;
            }
            try {
                this.a = null;
                declaredField = cls.getDeclaredField(str);
                if (i2 > 0 && (declaredField.getModifiers() & i2) != i2) {
                    c.b(new b.a(declaredField + " does not match modifiers: " + i2));
                }
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                b.a aVar = new b.a(e2);
                aVar.a((Class<?>) cls);
                aVar.b(str);
                c.b(aVar);
            } finally {
                this.b = declaredField;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private <T2> e<C, T2> a(Class<?> cls) throws b.a {
            Field field = this.b;
            if (field != null && !cls.isAssignableFrom(field.getType())) {
                c.b(new b.a(new ClassCastException(this.b + " is not of type " + cls)));
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private <T2> e<C, T2> b(Class<T2> cls) throws b.a {
            Field field = this.b;
            if (field != null && !cls.isAssignableFrom(field.getType())) {
                c.b(new b.a(new ClassCastException(this.b + " is not of type " + cls)));
            }
            return this;
        }

        private e<C, T> a(String str) throws b.a {
            try {
                Class<?> cls = Class.forName(str);
                if (this.b != null && !cls.isAssignableFrom(this.b.getType())) {
                    c.b(new b.a(new ClassCastException(this.b + " is not of type " + cls)));
                }
                return this;
            } catch (ClassNotFoundException e2) {
                c.b(new b.a(e2));
                return this;
            }
        }

        private e<C, T> b(C c2) {
            this.a = c2;
            return this;
        }

        private Field b() {
            return this.b;
        }

        private T a() {
            try {
                return (T) this.b.get(this.a);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        private void a(Object obj) {
            try {
                this.b.set(this.a, obj);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }

        private void a(b.AbstractC0176b<?> abstractC0176b) {
            T tA = a();
            if (tA != null) {
                try {
                    this.b.set(this.a, com.anythink.expressad.atsignalcommon.b.b.a(tA, abstractC0176b, tA.getClass().getInterfaces()));
                    return;
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            throw new IllegalStateException("Cannot mapping null");
        }
    }

    public static class f {
        protected final Method a;

        f(Class<?> cls, String str, Class<?>[] clsArr, int i2) {
            Method declaredMethod = null;
            if (cls == null) {
                return;
            }
            try {
                declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (i2 > 0 && (declaredMethod.getModifiers() & i2) != i2) {
                    c.b(new b.a(declaredMethod + " does not match modifiers: " + i2));
                }
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                b.a aVar = new b.a(e2);
                aVar.a(cls);
                aVar.a(str);
                c.b(aVar);
            } finally {
                this.a = declaredMethod;
            }
        }

        public final Object a(Object obj, Object... objArr) {
            try {
                return this.a.invoke(obj, objArr);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public final Method a() {
            return this.a;
        }
    }

    private static <T> C0177c<T> a(Class<T> cls) {
        return new C0177c<>(cls);
    }

    private static <T> C0177c<T> a(String str) throws b.a {
        try {
            return new C0177c<>(Class.forName(str));
        } catch (ClassNotFoundException e2) {
            b(new b.a(e2));
            return new C0177c<>(null);
        }
    }

    public static <T> C0177c<T> a(ClassLoader classLoader, String str) throws b.a {
        try {
            return new C0177c<>(classLoader.loadClass(str));
        } catch (Exception e2) {
            b(new b.a(e2));
            return new C0177c<>(null);
        }
    }

    private static void a(a aVar) {
        a = aVar;
    }
}
