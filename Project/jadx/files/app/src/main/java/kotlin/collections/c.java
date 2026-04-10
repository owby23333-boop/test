package kotlin.collections;

import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends g {
    @SinceKotlin(version = "1.3")
    @NotNull
    public static /* bridge */ /* synthetic */ byte[] a(@NotNull byte[] bArr, @NotNull byte[] bArr2, int i2, int i3, int i4) {
        f.a(bArr, bArr2, i2, i3, i4);
        return bArr2;
    }

    public static /* bridge */ /* synthetic */ byte[] a(byte[] bArr, byte[] bArr2, int i2, int i3, int i4, int i5, Object obj) {
        f.a(bArr, bArr2, i2, i3, i4, i5, obj);
        return bArr2;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @NotNull
    @PublishedApi
    public static /* bridge */ /* synthetic */ <T> T[] a(@NotNull T[] tArr, int i2, int i3) {
        return (T[]) f.a(tArr, i2, i3);
    }

    @Nullable
    public static /* bridge */ /* synthetic */ <T> T e(@NotNull T[] tArr) {
        return (T) g.e(tArr);
    }
}
