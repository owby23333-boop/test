package com.yuewen;

import androidx.annotation.NonNull;
import java.util.Collection;

/* JADX INFO: loaded from: classes5.dex */
public class er1 {
    public static <T> boolean a(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }

    @NonNull
    public static <T> T b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}
