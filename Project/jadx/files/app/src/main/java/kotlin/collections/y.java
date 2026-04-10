package kotlin.collections;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Maps.kt */
/* JADX INFO: loaded from: classes3.dex */
public class y extends x {
    @NotNull
    public static <K, V> Map<K, V> a() {
        EmptyMap emptyMap = EmptyMap.f20942s;
        if (emptyMap != null) {
            return emptyMap;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> b(@NotNull Map<K, ? extends V> map) {
        int size = map.size();
        return size != 0 ? size != 1 ? map : x.a(map) : a();
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static <K, V> Map<K, V> c(@NotNull Map<? extends K, ? extends V> map) {
        int size = map.size();
        return size != 0 ? size != 1 ? d(map) : x.a(map) : a();
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static <K, V> Map<K, V> d(@NotNull Map<? extends K, ? extends V> map) {
        return new LinkedHashMap(map);
    }

    public static final <K, V> void a(@NotNull Map<? super K, ? super V> map, @NotNull Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        for (Pair<? extends K, ? extends V> pair : iterable) {
            map.put(pair.f(), pair.g());
        }
    }

    @NotNull
    public static <K, V> Map<K, V> a(@NotNull Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return a();
            }
            if (size == 1) {
                return x.a(iterable instanceof List ? (Pair<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(x.a(collection.size()));
            a(iterable, linkedHashMap);
            return linkedHashMap;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        a(iterable, linkedHashMap2);
        return b(linkedHashMap2);
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M a(@NotNull Iterable<? extends Pair<? extends K, ? extends V>> iterable, @NotNull M m2) {
        a(m2, iterable);
        return m2;
    }
}
