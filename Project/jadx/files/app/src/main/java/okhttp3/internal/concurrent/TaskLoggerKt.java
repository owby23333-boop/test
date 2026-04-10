package okhttp3.internal.concurrent;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.m;
import okhttp3.internal.http2.Http2Connection;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TaskLogger.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001H\u0002\u001a5\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000eH\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a*\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0080\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"formatDuration", "", "ns", "", "log", "", "task", "Lokhttp3/internal/concurrent/Task;", "queue", "Lokhttp3/internal/concurrent/TaskQueue;", "message", "logElapsed", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lokhttp3/internal/concurrent/Task;Lokhttp3/internal/concurrent/TaskQueue;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "taskLog", "messageBlock", "okhttp"}, k = 2, mv = {1, 4, 0})
public final class TaskLoggerKt {
    @NotNull
    public static final String formatDuration(long j2) {
        String str;
        if (j2 <= -999500000) {
            str = ((j2 - ((long) 500000000)) / ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS)) + " s ";
        } else if (j2 <= -999500) {
            str = ((j2 - ((long) 500000)) / ((long) 1000000)) + " ms";
        } else if (j2 <= 0) {
            str = ((j2 - ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j2 < 999500) {
            str = ((j2 + ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j2 < 999500000) {
            str = ((j2 + ((long) 500000)) / ((long) 1000000)) + " ms";
        } else {
            str = ((j2 + ((long) 500000000)) / ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS)) + " s ";
        }
        m mVar = m.a;
        Object[] objArr = {str};
        return String.format("%6s", Arrays.copyOf(objArr, objArr.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void log(Task task, TaskQueue taskQueue, String str) {
        Logger logger = TaskRunner.INSTANCE.getLogger();
        StringBuilder sb = new StringBuilder();
        sb.append(taskQueue.getName());
        sb.append(' ');
        m mVar = m.a;
        Object[] objArr = {str};
        sb.append(String.format("%-22s", Arrays.copyOf(objArr, objArr.length)));
        sb.append(": ");
        sb.append(task.getName());
        logger.fine(sb.toString());
    }

    public static final <T> T logElapsed(@NotNull Task task, @NotNull TaskQueue taskQueue, @NotNull a<? extends T> aVar) {
        long jNanoTime;
        boolean zIsLoggable = TaskRunner.INSTANCE.getLogger().isLoggable(Level.FINE);
        if (zIsLoggable) {
            jNanoTime = taskQueue.getTaskRunner().getBackend().nanoTime();
            log(task, taskQueue, "starting");
        } else {
            jNanoTime = -1;
        }
        try {
            T tInvoke = aVar.invoke();
            h.b(1);
            if (zIsLoggable) {
                log(task, taskQueue, "finished run in " + formatDuration(taskQueue.getTaskRunner().getBackend().nanoTime() - jNanoTime));
            }
            h.a(1);
            return tInvoke;
        } catch (Throwable th) {
            h.b(1);
            if (zIsLoggable) {
                log(task, taskQueue, "failed a run in " + formatDuration(taskQueue.getTaskRunner().getBackend().nanoTime() - jNanoTime));
            }
            h.a(1);
            throw th;
        }
    }

    public static final void taskLog(@NotNull Task task, @NotNull TaskQueue taskQueue, @NotNull a<String> aVar) {
        if (TaskRunner.INSTANCE.getLogger().isLoggable(Level.FINE)) {
            log(task, taskQueue, aVar.invoke());
        }
    }
}
