package kotlin.collections;

import java.util.Collections;
import java.util.Map;
import kotlin.Pair;
import kotlin.PublishedApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MapsJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
class x extends w {
    @PublishedApi
    public static int a(int i2) {
        if (i2 < 0) {
            return i2;
        }
        if (i2 < 3) {
            return i2 + 1;
        }
        if (i2 < 1073741824) {
            return (int) ((i2 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    @NotNull
    public static final <K, V> Map<K, V> a(@NotNull Pair<? extends K, ? extends V> pair) {
        return Collections.singletonMap(pair.h(), pair.i());
    }

    @NotNull
    public static final <K, V> Map<K, V> a(@NotNull Map<? extends K, ? extends V> map) {
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        return Collections.singletonMap(next.getKey(), next.getValue());
    }
}
