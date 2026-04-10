package com.kwai.sodler.lib.kwai.kwai;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends BaseDexClassLoader {
    private ClassLoader aIL;
    private final List<String> aIM;
    private final List<String> aIN;
    private final ClassLoader aIO;

    public b(ClassLoader classLoader, String str, @Nullable File file, String str2, List<String> list, List<String> list2) {
        super(str, file, str2, classLoader);
        this.aIO = classLoader;
        this.aIM = list;
        this.aIN = list2;
        while (true) {
            this.aIL = classLoader;
            if (this.aIL.getParent() == null) {
                String str3 = "mParent is " + this.aIL.getClass().getName();
                return;
            }
            classLoader = this.aIL.getParent();
        }
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final String findLibrary(String str) {
        String strFindLibrary = super.findLibrary(str);
        if (!TextUtils.isEmpty(strFindLibrary) || !(this.aIO instanceof BaseDexClassLoader)) {
            return strFindLibrary;
        }
        StringBuilder sb = new StringBuilder("load so ");
        sb.append(str);
        sb.append(" from parent");
        return ((BaseDexClassLoader) this.aIO).findLibrary(str);
    }

    @Override // java.lang.ClassLoader
    protected final Class<?> loadClass(String str, boolean z2) throws ClassNotFoundException {
        List<String> list = this.aIM;
        if (list != null && list.contains(str)) {
            String str2 = "loadClass " + str + " from host by interface";
            return super.loadClass(str, z2);
        }
        List<String> list2 = this.aIN;
        if (list2 != null) {
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                if (str.startsWith(it.next() + ".")) {
                    return super.loadClass(str, z2);
                }
            }
        }
        Class<?> clsFindLoadedClass = findLoadedClass(str);
        if (clsFindLoadedClass != null) {
            return clsFindLoadedClass;
        }
        try {
            return findClass(str);
        } catch (ClassNotFoundException e2) {
            try {
                return getParent().loadClass(str);
            } catch (ClassNotFoundException e3) {
                if (Build.VERSION.SDK_INT >= 19) {
                    e3.addSuppressed(e2);
                }
                throw e3;
            }
        }
    }
}
