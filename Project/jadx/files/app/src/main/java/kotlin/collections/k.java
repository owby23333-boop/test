package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Collections.kt */
/* JADX INFO: loaded from: classes3.dex */
public class k extends j {
    @NotNull
    public static final <T> Collection<T> a(@NotNull T[] tArr) {
        return new b(tArr, false);
    }

    @NotNull
    public static <T> List<T> b(@NotNull T... tArr) {
        return tArr.length > 0 ? f.a(tArr) : a();
    }

    @NotNull
    public static <T> List<T> c(@NotNull T... tArr) {
        return g.b(tArr);
    }

    @NotNull
    public static <T> List<T> d(@NotNull T... tArr) {
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new b(tArr, true));
    }

    @NotNull
    public static <T> List<T> a() {
        return EmptyList.f20941s;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <T> List<T> b(@NotNull List<? extends T> list) {
        int size = list.size();
        return size != 0 ? size != 1 ? list : j.a(list.get(0)) : a();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static void c() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static <T> int a(@NotNull List<? extends T> list) {
        return list.size() - 1;
    }

    public static /* synthetic */ int a(List list, Comparable comparable, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = list.size();
        }
        return a(list, comparable, i2, i3);
    }

    public static final <T extends Comparable<? super T>> int a(@NotNull List<? extends T> list, @Nullable T t2, int i2, int i3) {
        a(list.size(), i2, i3);
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int iA = kotlin.k.b.a(list.get(i5), t2);
            if (iA < 0) {
                i2 = i5 + 1;
            } else {
                if (iA <= 0) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static void b() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    private static final void a(int i2, int i3, int i4) {
        if (i3 > i4) {
            throw new IllegalArgumentException("fromIndex (" + i3 + ") is greater than toIndex (" + i4 + ").");
        }
        if (i3 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i3 + ") is less than zero.");
        }
        if (i4 <= i2) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i4 + ") is greater than size (" + i2 + ").");
    }
}
