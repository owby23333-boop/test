package com.amgcyo.cuttadon.soloader;

import android.annotation.TargetApi;
import android.os.Build;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: LoadLibraryUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static final String a = c.class.getSimpleName() + "-duqian";
    private static File b = null;

    /* JADX INFO: compiled from: LoadLibraryUtil.java */
    private static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) throws Throwable {
            d.a(d.a(classLoader, "pathList").get(classLoader), "nativeLibraryDirectories", new File[]{file});
        }
    }

    /* JADX INFO: compiled from: LoadLibraryUtil.java */
    private static final class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) throws Throwable {
            Object obj = d.a(classLoader, "pathList").get(classLoader);
            List arrayList = (List) d.a(obj, "nativeLibraryDirectories").get(obj);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (file.equals((File) it.next()) || file.equals(c.b)) {
                    it.remove();
                    String unused = c.a;
                    String str = "dq libDirIt.remove() " + file.getAbsolutePath();
                    break;
                }
            }
            arrayList.add(0, file);
            List arrayList2 = (List) d.a(obj, "systemNativeLibraryDirectories").get(obj);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList(2);
            }
            String unused2 = c.a;
            String str2 = "dq systemLibDirs,size=" + arrayList2.size();
            Method methodA = d.a(obj, "makePathElements", (Class<?>[]) new Class[]{List.class, File.class, List.class});
            ArrayList arrayList3 = new ArrayList();
            arrayList.addAll(arrayList2);
            Object[] objArr = (Object[]) methodA.invoke(obj, arrayList, null, arrayList3);
            Field fieldA = d.a(obj, "nativeLibraryPathElements");
            fieldA.setAccessible(true);
            fieldA.set(obj, objArr);
        }
    }

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.soloader.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LoadLibraryUtil.java */
    private static final class C0114c {
        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) throws Throwable {
            Object obj = d.a(classLoader, "pathList").get(classLoader);
            List arrayList = (List) d.a(obj, "nativeLibraryDirectories").get(obj);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (file.equals((File) it.next()) || file.equals(c.b)) {
                    it.remove();
                    String unused = c.a;
                    String str = "dq libDirIt.remove()" + file.getAbsolutePath();
                    break;
                }
            }
            arrayList.add(0, file);
            List arrayList2 = (List) d.a(obj, "systemNativeLibraryDirectories").get(obj);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList(2);
            }
            String unused2 = c.a;
            String str2 = "dq systemLibDirs,size=" + arrayList2.size();
            Method methodA = d.a(obj, "makePathElements", (Class<?>[]) new Class[]{List.class});
            arrayList.addAll(arrayList2);
            Object[] objArr = (Object[]) methodA.invoke(obj, arrayList);
            Field fieldA = d.a(obj, "nativeLibraryPathElements");
            fieldA.setAccessible(true);
            fieldA.set(obj, objArr);
        }
    }

    @TargetApi(23)
    private static int c() {
        try {
            return Build.VERSION.PREVIEW_SDK_INT;
        } catch (Throwable unused) {
            return 1;
        }
    }

    public static synchronized boolean a(ClassLoader classLoader, File file) throws Throwable {
        if (classLoader != null && file != null) {
            if (file.exists()) {
                int i2 = Build.VERSION.SDK_INT;
                if ((i2 == 25 && c() != 0) || i2 > 25) {
                    C0114c.b(classLoader, file);
                } else if (i2 >= 23) {
                    b.b(classLoader, file);
                } else if (i2 >= 14) {
                    a.b(classLoader, file);
                }
                b = file;
                return true;
            }
        }
        String str = "classLoader or folder is illegal " + file;
        return false;
    }
}
