package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: MutableCollections.kt */
/* JADX INFO: loaded from: classes3.dex */
public class p extends o {
    public static <T> boolean a(@NotNull Collection<? super T> collection, @NotNull Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z2 = false;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z2 = true;
            }
        }
        return z2;
    }

    public static <T> boolean a(@NotNull Collection<? super T> collection, @NotNull T[] tArr) {
        return collection.addAll(f.a(tArr));
    }
}
