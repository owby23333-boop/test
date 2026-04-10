package kotlin.collections;

import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Sets.kt */
/* JADX INFO: loaded from: classes3.dex */
class c0 extends b0 {
    @NotNull
    public static <T> Set<T> a() {
        return EmptySet.f20943s;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Set<T> a(@NotNull Set<? extends T> set) {
        int size = set.size();
        return size != 0 ? size != 1 ? set : b0.a(set.iterator().next()) : a();
    }
}
