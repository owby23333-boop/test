package kotlin;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: LazyJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class f {
    @NotNull
    public static <T> d<T> a(@NotNull kotlin.jvm.b.a<? extends T> aVar) {
        kotlin.jvm.internal.f fVar = null;
        return new SynchronizedLazyImpl(aVar, fVar, 2, fVar);
    }
}
