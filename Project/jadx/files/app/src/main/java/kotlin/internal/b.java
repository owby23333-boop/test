package kotlin.internal;

import kotlin.jvm.JvmField;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PlatformImplementations.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    @JvmField
    @NotNull
    public static final PlatformImplementations a;

    /* JADX WARN: Removed duplicated region for block: B:27:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0124  */
    static {
        /*
            Method dump skipped, instruction units count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.internal.b.<clinit>():void");
    }

    private static final int a() {
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return 65542;
        }
        int iA = StringsKt__StringsKt.a((CharSequence) property, '.', 0, false, 6, (Object) null);
        if (iA < 0) {
            try {
                return Integer.parseInt(property) * 65536;
            } catch (NumberFormatException unused) {
                return 65542;
            }
        }
        int i2 = iA + 1;
        int iA2 = StringsKt__StringsKt.a((CharSequence) property, '.', i2, false, 4, (Object) null);
        if (iA2 < 0) {
            iA2 = property.length();
        }
        if (property == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = property.substring(0, iA);
        if (property == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        try {
            return (Integer.parseInt(strSubstring) * 65536) + Integer.parseInt(property.substring(i2, iA2));
        } catch (NumberFormatException unused2) {
            return 65542;
        }
    }
}
