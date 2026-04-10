package com.google.android.play.core.splitcompat.b;

import com.google.android.play.core.a.k;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
final class g implements a {
    /* JADX INFO: Access modifiers changed from: private */
    public static Object[] b(Object obj, List<File> list, File file, List<IOException> list2) {
        return (Object[]) com.google.android.play.core.splitcompat.c.b.a(obj, "makePathElements", Object[].class, List.class, list, File.class, file, List.class, list2);
    }

    @Override // com.google.android.play.core.splitcompat.b.a
    public final void a(ClassLoader classLoader, Set<File> set) {
        if (set.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<File> it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getParentFile());
        }
        Object objA = c.a(classLoader);
        List list = (List) com.google.android.play.core.splitcompat.c.b.a(objA, "getNativeLibraryDirectories", List.class);
        hashSet.removeAll(list);
        list.addAll(hashSet);
        ArrayList arrayList = new ArrayList();
        Object[] objArrB = b(objA, new ArrayList(hashSet), null, arrayList);
        if (arrayList.isEmpty()) {
            com.google.android.play.core.splitcompat.c.b.c(objA, "nativeLibraryPathElements", Object.class).a(objArrB);
            return;
        }
        k kVar = new k("Error in makePathElements");
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            com.google.a.a.a.a.a.a.a(kVar, (IOException) obj);
        }
        throw kVar;
    }

    @Override // com.google.android.play.core.splitcompat.b.a
    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return c.a(classLoader, file, file2, z, new h());
    }
}
