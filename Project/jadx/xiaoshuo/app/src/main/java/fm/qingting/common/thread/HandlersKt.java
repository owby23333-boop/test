package fm.qingting.common.thread;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"mainThreadHandler", "Landroid/os/Handler;", "getMainThreadHandler", "()Landroid/os/Handler;", "commonutils_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class HandlersKt {

    @NotNull
    private static final Handler mainThreadHandler = new Handler(Looper.getMainLooper());

    @NotNull
    public static final Handler getMainThreadHandler() {
        return mainThreadHandler;
    }
}
