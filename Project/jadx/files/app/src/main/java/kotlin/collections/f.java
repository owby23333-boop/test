package kotlin.collections;

import java.util.Arrays;
import java.util.List;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: _ArraysJvm.kt */
/* JADX INFO: loaded from: classes3.dex */
public class f extends e {
    @NotNull
    public static <T> List<T> a(@NotNull T[] tArr) {
        return h.a(tArr);
    }

    public static /* synthetic */ byte[] a(byte[] bArr, byte[] bArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = bArr.length;
        }
        c.a(bArr, bArr2, i2, i3, i4);
        return bArr2;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static byte[] a(@NotNull byte[] bArr, @NotNull byte[] bArr2, int i2, int i3, int i4) {
        System.arraycopy(bArr, i3, bArr2, i2, i4 - i3);
        return bArr2;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @NotNull
    @PublishedApi
    public static <T> T[] a(@NotNull T[] tArr, int i2, int i3) {
        d.a(i3, tArr.length);
        return (T[]) Arrays.copyOfRange(tArr, i2, i3);
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @NotNull
    @PublishedApi
    public static byte[] a(@NotNull byte[] bArr, int i2, int i3) {
        d.a(i3, bArr.length);
        return Arrays.copyOfRange(bArr, i2, i3);
    }

    public static /* synthetic */ void a(Object[] objArr, Object obj, int i2, int i3, int i4, Object obj2) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = objArr.length;
        }
        a(objArr, obj, i2, i3);
    }

    public static <T> void a(@NotNull T[] tArr, T t2, int i2, int i3) {
        Arrays.fill(tArr, i2, i3, t2);
    }

    public static /* synthetic */ void a(int[] iArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = iArr.length;
        }
        a(iArr, i2, i3, i4);
    }

    public static final void a(@NotNull int[] iArr, int i2, int i3, int i4) {
        Arrays.fill(iArr, i3, i4, i2);
    }
}
