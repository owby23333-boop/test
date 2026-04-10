package com.sntech.proxylib;

import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public final class ProxyClassLoaders {
    private static List<ClassLoader> sProxyClassLoaders;

    private ProxyClassLoaders() {
    }

    @Keep
    public static synchronized void addClassLoader(ClassLoader classLoader) {
        if (contains(classLoader)) {
            return;
        }
        if (sProxyClassLoaders == null) {
            sProxyClassLoaders = new ArrayList(1);
        }
        sProxyClassLoaders.add(classLoader);
    }

    public static boolean contains(ClassLoader classLoader) {
        List<ClassLoader> list = sProxyClassLoaders;
        if (list == null) {
            return false;
        }
        return list.contains(classLoader);
    }

    public static Class loadClass(String str) throws ClassNotFoundException {
        List<ClassLoader> list = sProxyClassLoaders;
        if (list == null) {
            throw new ClassNotFoundException();
        }
        Class<?> clsLoadClass = null;
        Iterator<ClassLoader> it = list.iterator();
        while (it.hasNext()) {
            try {
                clsLoadClass = it.next().loadClass(str);
            } catch (ClassNotFoundException unused) {
            }
            if (clsLoadClass != null) {
                break;
            }
        }
        if (clsLoadClass != null) {
            return clsLoadClass;
        }
        throw new ClassNotFoundException();
    }
}
