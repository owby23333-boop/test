package kotlin.ranges;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Ranges.kt */
/* JADX INFO: loaded from: classes3.dex */
class f {
    public static final void a(boolean z2, @NotNull Number number) {
        if (z2) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + number + '.');
    }
}
