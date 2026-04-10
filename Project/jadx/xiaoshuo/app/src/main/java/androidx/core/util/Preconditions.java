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

    public static void checkArgument(boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException();
        }
    }

    public static int checkArgumentInRange(int value, int lower, int upper, @NonNull String valueName) {
        if (value < lower) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", valueName, Integer.valueOf(lower), Integer.valueOf(upper)));
        }
        if (value <= upper) {
            return value;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", valueName, Integer.valueOf(lower), Integer.valueOf(upper)));
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(final int value, @Nullable String errorMessage) {
        if (value >= 0) {
            return value;
        }
        throw new IllegalArgumentException(errorMessage);
    }

    public static int checkFlagsArgument(final int requestedFlags, final int allowedFlags) {
        if ((requestedFlags & allowedFlags) == requestedFlags) {
            return requestedFlags;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(requestedFlags) + ", but only 0x" + Integer.toHexString(allowedFlags) + " are allowed");
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T reference) {
        reference.getClass();
        return reference;
    }

    public static void checkState(boolean expression, @Nullable String message) {
        if (!expression) {
            throw new IllegalStateException(message);
        }
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable final T string) {
        if (TextUtils.isEmpty(string)) {
            throw new IllegalArgumentException();
        }
        return string;
    }

    public static void checkArgument(boolean expression, @NonNull Object errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(final int value) {
        if (value >= 0) {
            return value;
        }
        throw new IllegalArgumentException();
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T reference, @NonNull Object errorMessage) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(String.valueOf(errorMessage));
    }

    public static void checkState(final boolean expression) {
        checkState(expression, null);
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable final T string, @NonNull final Object errorMessage) {
        if (TextUtils.isEmpty(string)) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
        return string;
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable final T string, @NonNull final String messageTemplate, @NonNull final Object... messageArgs) {
        if (TextUtils.isEmpty(string)) {
            throw new IllegalArgumentException(String.format(messageTemplate, messageArgs));
        }
        return string;
    }
}
