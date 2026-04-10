package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: _Arrays.kt */
/* JADX INFO: loaded from: classes3.dex */
public class g extends f {
    public static final <T> boolean a(@NotNull T[] tArr, T t2) {
        return b(tArr, t2) >= 0;
    }

    public static final <T> int b(@NotNull T[] tArr, T t2) {
        int i2 = 0;
        if (t2 == null) {
            int length = tArr.length;
            while (i2 < length) {
                if (tArr[i2] == null) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i2 < length2) {
            if (kotlin.jvm.internal.i.a(t2, tArr[i2])) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    @NotNull
    public static <T> IntRange c(@NotNull T[] tArr) {
        return new IntRange(0, d(tArr));
    }

    public static <T> int d(@NotNull T[] tArr) {
        return tArr.length - 1;
    }

    @Nullable
    public static <T> T e(@NotNull T[] tArr) {
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    @NotNull
    public static <T> List<T> f(@NotNull T[] tArr) {
        int length = tArr.length;
        return length != 0 ? length != 1 ? g(tArr) : j.a(tArr[0]) : k.a();
    }

    @NotNull
    public static <T> List<T> g(@NotNull T[] tArr) {
        return new ArrayList(k.a((Object[]) tArr));
    }

    public static char a(@NotNull char[] cArr) {
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @NotNull
    public static final <T> List<T> b(@NotNull T[] tArr) {
        ArrayList arrayList = new ArrayList();
        a((Object[]) tArr, arrayList);
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super T>, T> C a(@NotNull T[] tArr, @NotNull C c2) {
        for (T t2 : tArr) {
            if (t2 != null) {
                c2.add(t2);
            }
        }
        return c2;
    }
}
