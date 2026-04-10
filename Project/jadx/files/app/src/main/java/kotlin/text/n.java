package kotlin.text;

import java.util.Comparator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: StringsJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class n extends m {
    public static /* synthetic */ String a(String str, char c2, char c3, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return a(str, c2, c3, z2);
    }

    public static boolean b(@Nullable String str, @Nullable String str2, boolean z2) {
        return str == null ? str2 == null : !z2 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static boolean c(@NotNull String str, @NotNull String str2, boolean z2) {
        return !z2 ? str.startsWith(str2) : a(str, 0, str2, 0, str2.length(), z2);
    }

    @NotNull
    public static final String a(@NotNull String str, char c2, char c3, boolean z2) {
        return !z2 ? str.replace(c2, c3) : kotlin.sequences.i.a(StringsKt__StringsKt.b(str, new char[]{c2}, z2, 0, 4, (Object) null), String.valueOf(c3), null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ boolean b(String str, String str2, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return c(str, str2, z2);
    }

    public static /* synthetic */ String a(String str, String str2, String str3, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return a(str, str2, str3, z2);
    }

    @NotNull
    public static final String a(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z2) {
        return kotlin.sequences.i.a(StringsKt__StringsKt.a(str, new String[]{str2}, z2, 0, 4, (Object) null), str3, null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ boolean a(String str, String str2, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return a(str, str2, i2, z2);
    }

    public static boolean a(@NotNull String str, @NotNull String str2, int i2, boolean z2) {
        if (!z2) {
            return str.startsWith(str2, i2);
        }
        return a(str, i2, str2, 0, str2.length(), z2);
    }

    public static /* synthetic */ boolean a(String str, String str2, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return a(str, str2, z2);
    }

    public static final boolean a(@NotNull String str, @NotNull String str2, boolean z2) {
        if (!z2) {
            return str.endsWith(str2);
        }
        return a(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean a(@org.jetbrains.annotations.NotNull java.lang.CharSequence r4) {
        /*
            int r0 = r4.length()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L39
            kotlin.m.d r0 = kotlin.text.StringsKt__StringsKt.b(r4)
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L1b
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L1b
        L19:
            r4 = 1
            goto L37
        L1b:
            java.util.Iterator r0 = r0.iterator()
        L1f:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L19
            r3 = r0
            kotlin.collections.u r3 = (kotlin.collections.u) r3
            int r3 = r3.a()
            char r3 = r4.charAt(r3)
            boolean r3 = kotlin.text.b.a(r3)
            if (r3 != 0) goto L1f
            r4 = 0
        L37:
            if (r4 == 0) goto L3a
        L39:
            r1 = 1
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.n.a(java.lang.CharSequence):boolean");
    }

    public static final boolean a(@NotNull String str, int i2, @NotNull String str2, int i3, int i4, boolean z2) {
        if (!z2) {
            return str.regionMatches(i2, str2, i3, i4);
        }
        return str.regionMatches(z2, i2, str2, i3, i4);
    }

    @NotNull
    public static String a(@NotNull CharSequence charSequence, int i2) {
        int i3 = 1;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i2 + '.').toString());
        }
        if (i2 == 0) {
            return "";
        }
        if (i2 != 1) {
            int length = charSequence.length();
            if (length == 0) {
                return "";
            }
            if (length != 1) {
                StringBuilder sb = new StringBuilder(charSequence.length() * i2);
                if (1 <= i2) {
                    while (true) {
                        sb.append(charSequence);
                        if (i3 == i2) {
                            break;
                        }
                        i3++;
                    }
                }
                return sb.toString();
            }
            char cCharAt = charSequence.charAt(0);
            char[] cArr = new char[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                cArr[i4] = cCharAt;
            }
            return new String(cArr);
        }
        return charSequence.toString();
    }

    @NotNull
    public static Comparator<String> a(@NotNull kotlin.jvm.internal.m mVar) {
        return String.CASE_INSENSITIVE_ORDER;
    }
}
