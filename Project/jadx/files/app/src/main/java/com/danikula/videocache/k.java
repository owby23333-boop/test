package com.danikula.videocache;

/* JADX INFO: compiled from: Preconditions.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k {
    public static <T> T a(T t2) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException();
    }

    public static void a(Object... objArr) {
        for (Object obj : objArr) {
            if (obj == null) {
                throw new NullPointerException();
            }
        }
    }

    public static <T> T a(T t2, String str) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(str);
    }

    static void a(boolean z2, String str) {
        if (!z2) {
            throw new IllegalArgumentException(str);
        }
    }
}
