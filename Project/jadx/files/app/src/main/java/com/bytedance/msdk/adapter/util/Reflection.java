package com.bytedance.msdk.adapter.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Reflection {

    public static class MethodBuilder {

        @Nullable
        private final Object a;

        @NonNull
        private final String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private Class<?> f14000c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NonNull
        private List<Class<?>> f14001d = new ArrayList();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NonNull
        private List<Object> f14002e = new ArrayList();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f14003f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f14004g;

        public MethodBuilder(@Nullable Object obj, @NonNull String str) {
            this.a = obj;
            this.b = str;
            this.f14000c = obj != null ? obj.getClass() : null;
        }

        @NonNull
        public <T> MethodBuilder addParam(@NonNull Class<T> cls, @Nullable T t2) {
            this.f14001d.add(cls);
            this.f14002e.add(t2);
            return this;
        }

        @NonNull
        public MethodBuilder addParam(@NonNull String str, @Nullable Object obj) throws ClassNotFoundException {
            this.f14001d.add(Class.forName(str));
            this.f14002e.add(obj);
            return this;
        }

        @Nullable
        public Object execute() throws Exception {
            Method declaredMethodWithTraversal = Reflection.getDeclaredMethodWithTraversal(this.f14000c, this.b, (Class[]) this.f14001d.toArray(new Class[this.f14001d.size()]));
            if (this.f14003f) {
                declaredMethodWithTraversal.setAccessible(true);
            }
            return declaredMethodWithTraversal.invoke(this.f14004g ? null : this.a, this.f14002e.toArray());
        }

        @NonNull
        public MethodBuilder setAccessible() {
            this.f14003f = true;
            return this;
        }

        @NonNull
        public MethodBuilder setStatic(@NonNull Class<?> cls) {
            this.f14004g = true;
            this.f14000c = cls;
            return this;
        }

        @NonNull
        public MethodBuilder setStatic(@NonNull String str) throws ClassNotFoundException {
            this.f14004g = true;
            this.f14000c = Class.forName(str);
            return this;
        }
    }

    public static boolean classFound(@NonNull String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Nullable
    public static Method getDeclaredMethodWithTraversal(@Nullable Class<?> cls, @NonNull String str, @NonNull Class<?>... clsArr) throws NoSuchMethodException {
        while (cls != null) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException();
    }

    public static Field getPrivateField(@NonNull Class cls, @NonNull String str) throws NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField;
    }

    @NonNull
    public static <T> T instantiateClassWithConstructor(@NonNull String str, @NonNull Class<? extends T> cls, @NonNull Class[] clsArr, @NonNull Object[] objArr) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        Constructor declaredConstructor = Class.forName(str).asSubclass(cls).getDeclaredConstructor(clsArr);
        declaredConstructor.setAccessible(true);
        return (T) declaredConstructor.newInstance(objArr);
    }

    @NonNull
    public static <T> T instantiateClassWithEmptyConstructor(@NonNull String str, @NonNull Class<? extends T> cls) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, NullPointerException, InvocationTargetException {
        Constructor declaredConstructor = Class.forName(str).asSubclass(cls).getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        return (T) declaredConstructor.newInstance(new Object[0]);
    }
}
