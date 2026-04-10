package androidx.core.util;

import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    public static int checkArgumentInRange(int i2, int i3, int i4, @NonNull String str) {
        if (i2 < i3) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", str, Integer.valueOf(i3), Integer.valueOf(i4)));
        }
        if (i2 <= i4) {
            return i2;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", str, Integer.valueOf(i3), Integer.valueOf(i4)));
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int i2, @Nullable String str) {
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalArgumentException(str);
    }

    public static int checkFlagsArgument(int i2, int i3) {
        if ((i2 & i3) == i2) {
            return i2;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i2) + ", but only 0x" + Integer.toHexString(i3) + " are allowed");
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t2) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException();
    }

    public static void checkState(boolean z2, @Nullable String str) {
        if (!z2) {
            throw new IllegalStateException(str);
        }
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t2) {
        if (TextUtils.isEmpty(t2)) {
            throw new IllegalArgumentException();
        }
        return t2;
    }

    public static void checkArgument(boolean z2, @NonNull Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int i2) {
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalArgumentException();
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t2, @NonNull Object obj) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void checkState(boolean z2) {
        checkState(z2, null);
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t2, @NonNull Object obj) {
        if (TextUtils.isEmpty(t2)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return t2;
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t2, @NonNull String str, @NonNull Object... objArr) {
        if (TextUtils.isEmpty(t2)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
        return t2;
    }
}
