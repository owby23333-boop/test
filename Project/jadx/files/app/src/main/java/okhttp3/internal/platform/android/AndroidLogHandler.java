package okhttp3.internal.platform.android;

import com.anythink.expressad.foundation.d.c;
import com.kuaishou.pushad.BuildConfig;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidLog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lokhttp3/internal/platform/android/AndroidLogHandler;", "Ljava/util/logging/Handler;", "()V", c.cf, "", "flush", BuildConfig.FLAVOR, "record", "Ljava/util/logging/LogRecord;", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class AndroidLogHandler extends Handler {
    public static final AndroidLogHandler INSTANCE = new AndroidLogHandler();

    private AndroidLogHandler() {
    }

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }

    @Override // java.util.logging.Handler
    public void publish(@NotNull LogRecord record) {
        AndroidLog.INSTANCE.androidLog$okhttp(record.getLoggerName(), AndroidLogKt.getAndroidLevel(record), record.getMessage(), record.getThrown());
    }
}
