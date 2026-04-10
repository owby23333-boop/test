package com.kwai.sodler.lib.kwai.kwai;

import android.app.Activity;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends PathClassLoader {
    public static a aIJ;
    private static List<ClassLoader> aIK = new CopyOnWriteArrayList();
    private final BaseDexClassLoader aII;

    private a(BaseDexClassLoader baseDexClassLoader) {
        super("", baseDexClassLoader);
        this.aII = baseDexClassLoader;
    }

    public static void a(BaseDexClassLoader baseDexClassLoader) {
        if (aIJ == null) {
            aIJ = new a(baseDexClassLoader);
        }
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected final Class<?> findClass(String str) throws ClassNotFoundException {
        Class<?> clsLoadClass;
        Class<?> clsLoadClass2;
        Class<?> cls = null;
        try {
            clsLoadClass2 = this.aII.loadClass(str);
        } catch (Throwable th) {
            th = th;
        }
        if (Activity.class.isAssignableFrom(clsLoadClass2)) {
            return clsLoadClass2;
        }
        th = null;
        cls = clsLoadClass2;
        if (cls != null) {
            return cls;
        }
        Iterator<ClassLoader> it = aIK.iterator();
        while (it.hasNext()) {
            try {
                clsLoadClass = it.next().loadClass(str);
            } catch (Throwable unused) {
            }
            if (clsLoadClass != null) {
                return clsLoadClass;
            }
        }
        if (th instanceof ClassNotFoundException) {
            throw th;
        }
        throw new ClassNotFoundException(str, th);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final String findLibrary(String str) {
        return this.aII.findLibrary(str);
    }

    @Override // java.lang.ClassLoader
    public final URL getResource(String str) {
        return this.aII.getResource(str);
    }

    @Override // java.lang.ClassLoader
    public final InputStream getResourceAsStream(String str) {
        return this.aII.getResourceAsStream(str);
    }

    @Override // java.lang.ClassLoader
    public final Enumeration<URL> getResources(String str) {
        return this.aII.getResources(str);
    }

    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str) {
        return findClass(str);
    }

    @Override // dalvik.system.BaseDexClassLoader
    public final String toString() {
        return this.aII.toString();
    }
}
