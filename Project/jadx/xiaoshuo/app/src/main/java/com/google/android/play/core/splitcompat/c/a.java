package com.google.android.play.core.splitcompat.c;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes7.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f6938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Field f6939b;
    private final Class<T> c;

    public a(Object obj, Field field, Class<T> cls) {
        this.f6938a = obj;
        this.f6939b = field;
        this.c = cls;
    }

    private static <T> Class<T[]> a(Class<T> cls) {
        return (Class<T[]>) Array.newInstance((Class<?>) cls, 0).getClass();
    }

    private Class<T> b() {
        return (Class<T>) this.f6939b.getType().getComponentType();
    }

    public a(Object obj, Field field, Class<T> cls, byte b2) {
        this(obj, field, a(cls));
    }

    public final T a() {
        try {
            return this.c.cast(this.f6939b.get(this.f6938a));
        } catch (Exception e) {
            throw new c(String.format("Failed to get value of field %s of type %s on object of type %s", this.f6939b.getName(), this.f6938a.getClass().getName(), this.c.getName()), e);
        }
    }

    public void a(Collection<T> collection) {
        Object[] objArr = (Object[]) a();
        int length = objArr == null ? 0 : objArr.length;
        Object[] objArr2 = (Object[]) Array.newInstance((Class<?>) b(), collection.size() + length);
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            objArr2[length] = it.next();
            length++;
        }
        try {
            this.f6939b.set(this.f6938a, objArr2);
        } catch (Exception e) {
            throw new c(String.format("Failed to set value of field %s of type %s on object of type %s", this.f6939b.getName(), this.f6938a.getClass().getName(), this.c.getName()), e);
        }
    }

    public void a(T[] tArr) {
        a(Arrays.asList(tArr));
    }
}
