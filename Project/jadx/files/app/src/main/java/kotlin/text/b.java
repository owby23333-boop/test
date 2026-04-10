package kotlin.text;

import kotlin.PublishedApi;
import kotlin.ranges.IntRange;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: CharJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static final boolean a(char c2) {
        return Character.isWhitespace(c2) || Character.isSpaceChar(c2);
    }

    public static final int a(char c2, int i2) {
        return Character.digit((int) c2, i2);
    }

    @PublishedApi
    public static int a(int i2) {
        if (2 <= i2 && 36 >= i2) {
            return i2;
        }
        throw new IllegalArgumentException("radix " + i2 + " was not in valid range " + new IntRange(2, 36));
    }
}
