package kotlin.k;

import java.util.Comparator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static <T extends Comparable<?>> int a(@Nullable T t2, @Nullable T t3) {
        if (t2 == t3) {
            return 0;
        }
        if (t2 == null) {
            return -1;
        }
        if (t3 == null) {
            return 1;
        }
        return t2.compareTo(t3);
    }

    @NotNull
    public static <T extends Comparable<? super T>> Comparator<T> a() {
        e eVar = e.f20966s;
        if (eVar != null) {
            return eVar;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
    }
}
