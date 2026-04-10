package com.kwai.sodler.lib.ext;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"LongLogTag"})
public final class d {

    static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) throws IllegalAccessException, NoSuchFieldException {
            Object obj = com.kwai.sodler.lib.ext.e.g(classLoader, "pathList").get(classLoader);
            Field fieldG = com.kwai.sodler.lib.ext.e.g(obj, "nativeLibraryDirectories");
            File[] fileArr = (File[]) fieldG.get(obj);
            ArrayList arrayList = new ArrayList();
            for (File file2 : fileArr) {
                if (!file.equals(file2)) {
                    arrayList.add(file2);
                }
            }
            arrayList.add(file);
            fieldG.set(obj, arrayList.toArray(new File[0]));
        }
    }

    static final class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) throws IllegalAccessException, NoSuchFieldException {
            Object obj = com.kwai.sodler.lib.ext.e.g(classLoader, "pathList").get(classLoader);
            Field fieldG = com.kwai.sodler.lib.ext.e.g(obj, "nativeLibraryDirectories");
            Collection arrayList = (List) fieldG.get(obj);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
            }
            ArrayList arrayList2 = new ArrayList(arrayList);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                if (file.equals((File) it.next())) {
                    return;
                }
            }
            arrayList2.add(file);
            fieldG.set(obj, arrayList2);
            if (fieldG.get(obj) != arrayList2) {
                com.kwai.sodler.lib.ext.e.h(obj, "nativeLibraryDirectories").set(obj, arrayList2);
            }
            List arrayList3 = (List) com.kwai.sodler.lib.ext.e.g(obj, "systemNativeLibraryDirectories").get(obj);
            if (arrayList3 == null) {
                arrayList3 = new ArrayList(2);
            }
            ArrayList arrayList4 = new ArrayList(arrayList2.size() + arrayList3.size() + 1);
            arrayList4.addAll(arrayList2);
            arrayList4.addAll(arrayList3);
            Object obj2 = (Object[]) com.kwai.sodler.lib.ext.e.b(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList4, null, new ArrayList());
            Field fieldG2 = com.kwai.sodler.lib.ext.e.g(obj, "nativeLibraryPathElements");
            fieldG2.set(obj, obj2);
            if (fieldG2.get(obj) != obj2) {
                com.kwai.sodler.lib.ext.e.h(obj, "nativeLibraryPathElements").set(obj, obj2);
            }
        }
    }

    static final class c {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) throws IllegalAccessException {
            Object obj = com.kwai.sodler.lib.ext.e.g(classLoader, "pathList").get(classLoader);
            List arrayList = (List) com.kwai.sodler.lib.ext.e.g(obj, "nativeLibraryDirectories").get(obj);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (file.equals((File) it.next())) {
                    return;
                }
            }
            arrayList.add(file);
            List arrayList2 = (List) com.kwai.sodler.lib.ext.e.g(obj, "systemNativeLibraryDirectories").get(obj);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList(2);
            }
            ArrayList arrayList3 = new ArrayList(arrayList.size() + arrayList2.size() + 1);
            arrayList3.addAll(arrayList);
            arrayList3.addAll(arrayList2);
            com.kwai.sodler.lib.ext.e.g(obj, "nativeLibraryPathElements").set(obj, (Object[]) com.kwai.sodler.lib.ext.e.b(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList3, null, new ArrayList()));
        }
    }

    /* JADX INFO: renamed from: com.kwai.sodler.lib.ext.d$d, reason: collision with other inner class name */
    static final class C0474d {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) throws IllegalAccessException {
            Object obj = com.kwai.sodler.lib.ext.e.g(classLoader, "pathList").get(classLoader);
            List arrayList = (List) com.kwai.sodler.lib.ext.e.g(obj, "nativeLibraryDirectories").get(obj);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (file.equals((File) it.next())) {
                    return;
                }
            }
            arrayList.add(file);
            List arrayList2 = (List) com.kwai.sodler.lib.ext.e.g(obj, "systemNativeLibraryDirectories").get(obj);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList(2);
            }
            ArrayList arrayList3 = new ArrayList(arrayList.size() + arrayList2.size() + 1);
            arrayList3.addAll(arrayList);
            arrayList3.addAll(arrayList2);
            com.kwai.sodler.lib.ext.e.g(obj, "nativeLibraryPathElements").set(obj, (Object[]) com.kwai.sodler.lib.ext.e.b(obj, "makePathElements", List.class).invoke(obj, arrayList3));
        }
    }

    static final class e {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) throws IllegalAccessException, NoSuchFieldException {
            String str;
            String path = file.getPath();
            Field fieldG = com.kwai.sodler.lib.ext.e.g(classLoader, "libPath");
            String strValueOf = String.valueOf(fieldG.get(classLoader));
            if (TextUtils.isEmpty(strValueOf)) {
                str = path;
            } else {
                str = strValueOf + ":" + path;
            }
            fieldG.set(classLoader, str);
            Field fieldG2 = com.kwai.sodler.lib.ext.e.g(classLoader, "libraryPathElements");
            List list = (List) fieldG2.get(classLoader);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (path.equals((String) it.next())) {
                    return;
                }
            }
            list.add(path);
            fieldG2.set(classLoader, list);
        }
    }

    public static synchronized void c(ClassLoader classLoader, File file) {
        if (file != null) {
            if (file.exists()) {
                if ((Build.VERSION.SDK_INT == 25 && Build.VERSION.PREVIEW_SDK_INT != 0) || Build.VERSION.SDK_INT > 25) {
                    try {
                        C0474d.d(classLoader, file);
                        return;
                    } catch (Throwable th) {
                        com.kwai.sodler.lib.a.e("Sodler.ShareLibraryLoader", String.format("installNativeLibraryPath, v25 fail, sdk: %d, error: %s, try to fallback to V23", Integer.valueOf(Build.VERSION.SDK_INT), th.getMessage()));
                        b.d(classLoader, file);
                        return;
                    }
                }
                if (Build.VERSION.SDK_INT == 24) {
                    try {
                        c.d(classLoader, file);
                        return;
                    } finally {
                        a.d(classLoader, file);
                        return;
                    }
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        b.d(classLoader, file);
                        return;
                    } finally {
                        a.d(classLoader, file);
                        return;
                    }
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    a.d(classLoader, file);
                    return;
                }
                e.d(classLoader, file);
                return;
            }
        }
        com.kwai.sodler.lib.a.e("Sodler.ShareLibraryLoader", String.format("installNativeLibraryPath, folder %s is illegal", file));
    }
}
