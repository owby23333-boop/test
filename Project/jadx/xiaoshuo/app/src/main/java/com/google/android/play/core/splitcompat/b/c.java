package com.google.android.play.core.splitcompat.b;

import android.util.Log;
import com.google.android.play.core.a.k;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
final class c implements a {
    public static Object a(ClassLoader classLoader) {
        return com.google.android.play.core.splitcompat.c.b.b(classLoader, "pathList", Object.class).a();
    }

    public static void b(ClassLoader classLoader, Set<File> set) {
        if (set.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (File file : set) {
            String strValueOf = String.valueOf(file.getParentFile().getAbsolutePath());
            Log.d("Splitcompat", strValueOf.length() != 0 ? "Adding native library parent directory: ".concat(strValueOf) : new String("Adding native library parent directory: "));
            hashSet.add(file.getParentFile());
        }
        com.google.android.play.core.splitcompat.c.a aVarC = com.google.android.play.core.splitcompat.c.b.c(a(classLoader), "nativeLibraryDirectories", File.class);
        hashSet.removeAll(Arrays.asList((File[]) aVarC.a()));
        int size = hashSet.size();
        StringBuilder sb = new StringBuilder(30);
        sb.append("Adding directories ");
        sb.append(size);
        Log.d("Splitcompat", sb.toString());
        aVarC.a(hashSet);
    }

    @Override // com.google.android.play.core.splitcompat.b.a
    public final void a(ClassLoader classLoader, Set<File> set) {
        b(classLoader, set);
    }

    @Override // com.google.android.play.core.splitcompat.b.a
    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return a(classLoader, file, file2, z, new d());
    }

    public static boolean a(ClassLoader classLoader, File file, File file2, boolean z, e eVar) {
        ArrayList<IOException> arrayList = new ArrayList<>();
        Object objA = a(classLoader);
        com.google.android.play.core.splitcompat.c.a aVarC = com.google.android.play.core.splitcompat.c.b.c(objA, "dexElements", Object.class);
        List listAsList = Arrays.asList((Object[]) aVarC.a());
        ArrayList arrayList2 = new ArrayList();
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            arrayList2.add((File) com.google.android.play.core.splitcompat.c.b.b(it.next(), "zip", File.class).a());
        }
        if (arrayList2.contains(file2)) {
            return true;
        }
        int i = 0;
        if (!z && !new File((String) com.google.android.play.core.splitcompat.c.b.a(objA.getClass(), "optimizedPathFor", String.class, File.class, file2, File.class, file)).exists()) {
            return false;
        }
        aVarC.a(eVar.a(objA, new ArrayList<>(Collections.singleton(file2)), file, arrayList));
        if (arrayList.isEmpty()) {
            return true;
        }
        k kVar = new k("DexPathList.makeDexElement failed");
        int size = arrayList.size();
        while (i < size) {
            IOException iOException = arrayList.get(i);
            i++;
            IOException iOException2 = iOException;
            Log.e("SplitCompat", "DexPathList.makeDexElement failed", iOException2);
            com.google.a.a.a.a.a.a.a(kVar, iOException2);
        }
        com.google.android.play.core.splitcompat.c.b.c(objA, "dexElementsSuppressedExceptions", IOException.class).a(arrayList);
        throw kVar;
    }
}
