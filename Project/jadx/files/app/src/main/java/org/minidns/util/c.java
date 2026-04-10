package org.minidns.util;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/* JADX INFO: compiled from: CollectionsUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static <T> T a(Set<T> set, Random random) {
        int iNextInt = random.nextInt(set.size());
        Iterator<T> it = set.iterator();
        for (int i2 = 0; i2 < iNextInt && it.hasNext(); i2++) {
            it.next();
        }
        return it.next();
    }
}
