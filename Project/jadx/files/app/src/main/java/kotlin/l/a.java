package kotlin.l;

import java.io.Closeable;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.b;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Closeable.kt */
/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "CloseableKt")
public final class a {
    @SinceKotlin(version = "1.1")
    @PublishedApi
    public static final void a(@Nullable Closeable closeable, @Nullable Throwable th) {
        if (closeable == null) {
            return;
        }
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            b.a(th, th2);
        }
    }
}
