package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PackageReference.kt */
/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.1")
public final class j implements c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NotNull
    private final Class<?> f20965s;

    public j(@NotNull Class<?> cls, @NotNull String str) {
        this.f20965s = cls;
    }

    @Override // kotlin.jvm.internal.c
    @NotNull
    public Class<?> a() {
        return this.f20965s;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof j) && i.a(a(), ((j) obj).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    @NotNull
    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
