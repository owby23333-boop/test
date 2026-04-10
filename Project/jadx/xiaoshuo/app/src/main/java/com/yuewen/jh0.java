package com.yuewen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class jh0 {
    public static <T> boolean a(Iterable<T> iterable, t41<T> t41Var) {
        return c(iterable, t41Var) != null;
    }

    public static <T> T b(Iterable<T> iterable, t41<T> t41Var) {
        if (iterable == null || t41Var == null) {
            return null;
        }
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (t41Var.a(next)) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    public static <T> T c(Iterable<T> iterable, t41<T> t41Var) {
        if (iterable == null || t41Var == null) {
            return null;
        }
        for (T t : iterable) {
            if (t41Var.a(t)) {
                return t;
            }
        }
        return null;
    }

    public static <T> List<T> d(Iterable<T> iterable, t41<T> t41Var) {
        ArrayList arrayList = new ArrayList();
        if (iterable == null || t41Var == null) {
            return arrayList;
        }
        for (T t : iterable) {
            if (t41Var.a(t)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }
}
