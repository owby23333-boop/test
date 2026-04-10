package kotlin.text;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: _Strings.kt */
/* JADX INFO: loaded from: classes3.dex */
public class p extends o {
    @NotNull
    public static String b(@NotNull String str, int i2) {
        if (i2 >= 0) {
            return str.substring(0, kotlin.ranges.g.b(i2, str.length()));
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }
}
