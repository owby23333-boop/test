package androidx.core.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ObjectsCompat {
    private ObjectsCompat() {
    }

    public static boolean equals(@Nullable Object a2, @Nullable Object b2) {
        return Objects.equals(a2, b2);
    }

    public static int hash(@Nullable Object... values) {
        return Objects.hash(values);
    }

    public static int hashCode(@Nullable Object o) {
        if (o != null) {
            return o.hashCode();
        }
        return 0;
    }

    @NonNull
    public static <T> T requireNonNull(@Nullable T obj) {
        obj.getClass();
        return obj;
    }

    @Nullable
    public static String toString(@Nullable Object o, @Nullable String nullDefault) {
        return o != null ? o.toString() : nullDefault;
    }

    @NonNull
    public static <T> T requireNonNull(@Nullable T obj, @NonNull String message) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(message);
    }
}
