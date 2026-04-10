package kotlin.collections;

import java.util.Collection;
import kotlin.PublishedApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Iterables.kt */
/* JADX INFO: loaded from: classes3.dex */
public class l extends k {
    @PublishedApi
    public static <T> int a(@NotNull Iterable<? extends T> iterable, int i2) {
        return iterable instanceof Collection ? ((Collection) iterable).size() : i2;
    }
}
