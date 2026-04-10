package kotlin.internal.d;

import kotlin.internal.PlatformImplementations;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: JDK7PlatformImplementations.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a extends PlatformImplementations {
    @Override // kotlin.internal.PlatformImplementations
    public void a(@NotNull Throwable th, @NotNull Throwable th2) {
        th.addSuppressed(th2);
    }
}
