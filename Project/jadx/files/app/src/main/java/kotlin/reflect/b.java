package kotlin.reflect;

import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KCallable.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface b<R> extends a {
    R call(@NotNull Object... objArr);

    R callBy(@NotNull Map<Object, ? extends Object> map);

    @NotNull
    List<Object> getParameters();

    @NotNull
    k getReturnType();

    @NotNull
    List<Object> getTypeParameters();

    @Nullable
    KVisibility getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
