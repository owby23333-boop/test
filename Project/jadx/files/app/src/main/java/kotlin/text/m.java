package kotlin.text;

import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: StringNumberConversions.kt */
/* JADX INFO: loaded from: classes3.dex */
public class m extends l {
    @SinceKotlin(version = "1.1")
    @Nullable
    public static Integer a(@NotNull String str) {
        return a(str, 10);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Integer a(@NotNull String str, int i2) {
        boolean z2;
        int i3;
        a.a(i2);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i4 = 0;
        char cCharAt = str.charAt(0);
        int i5 = -2147483647;
        int i6 = 1;
        if (kotlin.jvm.internal.i.a(cCharAt, 48) >= 0) {
            z2 = false;
            i6 = 0;
        } else {
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                i5 = Integer.MIN_VALUE;
                z2 = true;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z2 = false;
            }
        }
        int i7 = -59652323;
        while (i6 < length) {
            int iA = b.a(str.charAt(i6), i2);
            if (iA < 0) {
                return null;
            }
            if ((i4 < i7 && (i7 != -59652323 || i4 < (i7 = i5 / i2))) || (i3 = i4 * i2) < i5 + iA) {
                return null;
            }
            i4 = i3 - iA;
            i6++;
        }
        if (!z2) {
            i4 = -i4;
        }
        return Integer.valueOf(i4);
    }
}
