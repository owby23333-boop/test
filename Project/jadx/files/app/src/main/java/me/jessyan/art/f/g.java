package me.jessyan.art.f;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: Preconditions.java */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static void a(boolean z2, @Nullable String str, @Nullable Object... objArr) {
        if (!z2) {
            throw new IllegalStateException(a(str, objArr));
        }
    }

    public static <T> T a(T t2) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException();
    }

    public static <T> T a(T t2, @Nullable Object obj) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static <T> T a(T t2, @Nullable String str, @Nullable Object... objArr) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(a(str, objArr));
    }

    static String a(String str, @Nullable Object... objArr) {
        int iIndexOf;
        String strValueOf = String.valueOf(str);
        StringBuilder sb = new StringBuilder(strValueOf.length() + (objArr.length * 16));
        int i2 = 0;
        int i3 = 0;
        while (i2 < objArr.length && (iIndexOf = strValueOf.indexOf("%s", i3)) != -1) {
            sb.append(strValueOf.substring(i3, iIndexOf));
            sb.append(objArr[i2]);
            i3 = iIndexOf + 2;
            i2++;
        }
        sb.append(strValueOf.substring(i3));
        if (i2 < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i2]);
            for (int i4 = i2 + 1; i4 < objArr.length; i4++) {
                sb.append(", ");
                sb.append(objArr[i4]);
            }
            sb.append(']');
        }
        return sb.toString();
    }
}
