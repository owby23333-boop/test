package kotlin.collections;

import java.io.IOException;
import java.util.List;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends s {
    public static /* bridge */ /* synthetic */ Appendable a(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, kotlin.jvm.b.l lVar, int i3, Object obj) throws IOException {
        s.a(iterable, appendable, charSequence, charSequence2, charSequence3, i2, charSequence4, lVar, i3, obj);
        return appendable;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static /* bridge */ /* synthetic */ void b() {
        k.b();
        throw null;
    }

    public static /* bridge */ /* synthetic */ <T> T c(@NotNull Iterable<? extends T> iterable) {
        return (T) s.c(iterable);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static /* bridge */ /* synthetic */ void c() {
        k.c();
        throw null;
    }

    public static /* bridge */ /* synthetic */ <T> T d(@NotNull List<? extends T> list) {
        return (T) s.d((List) list);
    }

    @Nullable
    public static /* bridge */ /* synthetic */ <T> T e(@NotNull List<? extends T> list) {
        return (T) s.e((List) list);
    }

    public static /* bridge */ /* synthetic */ <T> T f(@NotNull List<? extends T> list) {
        return (T) s.f((List) list);
    }
}
