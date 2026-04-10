package kotlin.ranges;

import kotlin.ranges.IntProgression;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: _Ranges.kt */
/* JADX INFO: loaded from: classes3.dex */
public class g extends f {
    public static int a(int i2, int i3) {
        return i2 < i3 ? i3 : i2;
    }

    @NotNull
    public static IntProgression a(@NotNull IntProgression intProgression, int i2) {
        f.a(i2 > 0, Integer.valueOf(i2));
        IntProgression.a aVar = IntProgression.f20968v;
        int f20969s = intProgression.getF20969s();
        int f20970t = intProgression.getF20970t();
        if (intProgression.getF20971u() <= 0) {
            i2 = -i2;
        }
        return aVar.a(f20969s, f20970t, i2);
    }

    public static int b(int i2, int i3) {
        return i2 > i3 ? i3 : i2;
    }

    @NotNull
    public static IntProgression c(int i2, int i3) {
        return IntProgression.f20968v.a(i2, i3, -1);
    }

    @NotNull
    public static IntRange d(int i2, int i3) {
        return i3 <= Integer.MIN_VALUE ? IntRange.f20977x.a() : new IntRange(i2, i3 - 1);
    }

    public static int a(int i2, int i3, int i4) {
        if (i3 <= i4) {
            return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i4 + " is less than minimum " + i3 + '.');
    }
}
