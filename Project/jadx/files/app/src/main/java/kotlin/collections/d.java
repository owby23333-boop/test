package kotlin.collections;

import kotlin.SinceKotlin;

/* JADX INFO: compiled from: ArraysJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
class d {
    @SinceKotlin(version = "1.3")
    public static final void a(int i2, int i3) {
        if (i2 <= i3) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is greater than size (" + i3 + ").");
    }
}
