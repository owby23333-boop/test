package kotlin.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: CollectionsJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class j {
    @NotNull
    public static <T> List<T> a(T t2) {
        return Collections.singletonList(t2);
    }

    @NotNull
    public static final <T> Object[] a(@NotNull T[] tArr, boolean z2) {
        return (z2 && kotlin.jvm.internal.i.a(tArr.getClass(), Object[].class)) ? tArr : Arrays.copyOf(tArr, tArr.length, Object[].class);
    }
}
