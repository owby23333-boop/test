package me.drakeet.multitype;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: Preconditions.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    @NonNull
    public static <T> T a(@NonNull T t2) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException();
    }
}
