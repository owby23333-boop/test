package okhttp3.internal.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import kotlin.Metadata;
import kotlin.collections.s;
import kotlin.j;
import kotlin.jvm.b.a;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u00013B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010!\u001a\u00020\"J\r\u0010#\u001a\u00020\u000eH\u0000¢\u0006\u0002\b$J8\u0010%\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u000e2\u000e\b\u0004\u0010)\u001a\b\u0012\u0004\u0012\u00020\"0*H\u0086\bø\u0001\u0000J\u0006\u0010+\u001a\u00020,J.\u0010-\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020'2\u000e\b\u0004\u0010)\u001a\b\u0012\u0004\u0012\u00020'0*H\u0086\bø\u0001\u0000J\u0018\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020'J%\u0010/\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\b2\u0006\u0010&\u001a\u00020'2\u0006\u00100\u001a\u00020\u000eH\u0000¢\u0006\u0002\b1J\u0006\u0010\u001c\u001a\u00020\"J\b\u00102\u001a\u00020\u0005H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016R\u001a\u0010\u001c\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00064"}, d2 = {"Lokhttp3/internal/concurrent/TaskQueue;", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "name", "", "(Lokhttp3/internal/concurrent/TaskRunner;Ljava/lang/String;)V", "activeTask", "Lokhttp3/internal/concurrent/Task;", "getActiveTask$okhttp", "()Lokhttp3/internal/concurrent/Task;", "setActiveTask$okhttp", "(Lokhttp3/internal/concurrent/Task;)V", "cancelActiveTask", "", "getCancelActiveTask$okhttp", "()Z", "setCancelActiveTask$okhttp", "(Z)V", "futureTasks", "", "getFutureTasks$okhttp", "()Ljava/util/List;", "getName$okhttp", "()Ljava/lang/String;", "scheduledTasks", "", "getScheduledTasks", "shutdown", "getShutdown$okhttp", "setShutdown$okhttp", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "cancelAll", "", "cancelAllAndDecide", "cancelAllAndDecide$okhttp", "execute", "delayNanos", "", "cancelable", "block", "Lkotlin/Function0;", "idleLatch", "Ljava/util/concurrent/CountDownLatch;", "schedule", "task", "scheduleAndDecide", "recurrence", "scheduleAndDecide$okhttp", "toString", "AwaitIdleTask", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class TaskQueue {

    @Nullable
    private Task activeTask;
    private boolean cancelActiveTask;

    @NotNull
    private final List<Task> futureTasks = new ArrayList();

    @NotNull
    private final String name;
    private boolean shutdown;

    @NotNull
    private final TaskRunner taskRunner;

    /* JADX INFO: compiled from: TaskQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lokhttp3/internal/concurrent/TaskQueue$AwaitIdleTask;", "Lokhttp3/internal/concurrent/Task;", "()V", "latch", "Ljava/util/concurrent/CountDownLatch;", "getLatch", "()Ljava/util/concurrent/CountDownLatch;", "runOnce", "", "okhttp"}, k = 1, mv = {1, 4, 0})
    private static final class AwaitIdleTask extends Task {

        @NotNull
        private final CountDownLatch latch;

        public AwaitIdleTask() {
            super(Util.okHttpName + " awaitIdle", false);
            this.latch = new CountDownLatch(1);
        }

        @NotNull
        public final CountDownLatch getLatch() {
            return this.latch;
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            this.latch.countDown();
            return -1L;
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.concurrent.TaskQueue$execute$1, reason: invalid class name */
    /* JADX INFO: compiled from: TaskQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"okhttp3/internal/concurrent/TaskQueue$execute$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class AnonymousClass1 extends Task {
        final /* synthetic */ a $block;
        final /* synthetic */ boolean $cancelable;
        final /* synthetic */ String $name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(a aVar, String str, boolean z2, String str2, boolean z3) {
            super(str2, z3);
            this.$block = aVar;
            this.$name = str;
            this.$cancelable = z2;
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            this.$block.invoke();
            return -1L;
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.concurrent.TaskQueue$schedule$2, reason: invalid class name */
    /* JADX INFO: compiled from: TaskQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"okhttp3/internal/concurrent/TaskQueue$schedule$2", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class AnonymousClass2 extends Task {
        final /* synthetic */ a $block;
        final /* synthetic */ String $name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(a aVar, String str, String str2) {
            super(str2, false, 2, null);
            this.$block = aVar;
            this.$name = str;
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            return ((Number) this.$block.invoke()).longValue();
        }
    }

    public TaskQueue(@NotNull TaskRunner taskRunner, @NotNull String str) {
        this.taskRunner = taskRunner;
        this.name = str;
    }

    public static /* synthetic */ void execute$default(TaskQueue taskQueue, String str, long j2, boolean z2, a aVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        boolean z3 = (i2 & 4) != 0 ? true : z2;
        taskQueue.schedule(new AnonymousClass1(aVar, str, z3, str, z3), j2);
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, Task task, long j2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        taskQueue.schedule(task, j2);
    }

    public final void cancelAll() {
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this.taskRunner) {
            if (cancelAllAndDecide$okhttp()) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
            j jVar = j.a;
        }
    }

    public final boolean cancelAllAndDecide$okhttp() {
        Task task = this.activeTask;
        if (task != null && task.getCancelable()) {
            this.cancelActiveTask = true;
        }
        boolean z2 = false;
        for (int size = this.futureTasks.size() - 1; size >= 0; size--) {
            if (this.futureTasks.get(size).getCancelable()) {
                Task task2 = this.futureTasks.get(size);
                if (TaskRunner.INSTANCE.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(task2, this, "canceled");
                }
                this.futureTasks.remove(size);
                z2 = true;
            }
        }
        return z2;
    }

    public final void execute(@NotNull String str, long j2, boolean z2, @NotNull a<j> aVar) {
        schedule(new AnonymousClass1(aVar, str, z2, str, z2), j2);
    }

    @Nullable
    /* JADX INFO: renamed from: getActiveTask$okhttp, reason: from getter */
    public final Task getActiveTask() {
        return this.activeTask;
    }

    /* JADX INFO: renamed from: getCancelActiveTask$okhttp, reason: from getter */
    public final boolean getCancelActiveTask() {
        return this.cancelActiveTask;
    }

    @NotNull
    public final List<Task> getFutureTasks$okhttp() {
        return this.futureTasks;
    }

    @NotNull
    /* JADX INFO: renamed from: getName$okhttp, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final List<Task> getScheduledTasks() {
        List<Task> listD;
        synchronized (this.taskRunner) {
            listD = s.d((Iterable) this.futureTasks);
        }
        return listD;
    }

    /* JADX INFO: renamed from: getShutdown$okhttp, reason: from getter */
    public final boolean getShutdown() {
        return this.shutdown;
    }

    @NotNull
    /* JADX INFO: renamed from: getTaskRunner$okhttp, reason: from getter */
    public final TaskRunner getTaskRunner() {
        return this.taskRunner;
    }

    @NotNull
    public final CountDownLatch idleLatch() {
        synchronized (this.taskRunner) {
            if (this.activeTask == null && this.futureTasks.isEmpty()) {
                return new CountDownLatch(0);
            }
            Task task = this.activeTask;
            if (task instanceof AwaitIdleTask) {
                return ((AwaitIdleTask) task).getLatch();
            }
            for (Task task2 : this.futureTasks) {
                if (task2 instanceof AwaitIdleTask) {
                    return ((AwaitIdleTask) task2).getLatch();
                }
            }
            AwaitIdleTask awaitIdleTask = new AwaitIdleTask();
            if (scheduleAndDecide$okhttp(awaitIdleTask, 0L, false)) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
            return awaitIdleTask.getLatch();
        }
    }

    public final void schedule(@NotNull Task task, long delayNanos) {
        synchronized (this.taskRunner) {
            if (!this.shutdown) {
                if (scheduleAndDecide$okhttp(task, delayNanos, false)) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
                j jVar = j.a;
            } else if (task.getCancelable()) {
                if (TaskRunner.INSTANCE.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(task, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                if (TaskRunner.INSTANCE.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    public final boolean scheduleAndDecide$okhttp(@NotNull Task task, long delayNanos, boolean recurrence) {
        String str;
        task.initQueue$okhttp(this);
        long jNanoTime = this.taskRunner.getBackend().nanoTime();
        long j2 = jNanoTime + delayNanos;
        int iIndexOf = this.futureTasks.indexOf(task);
        if (iIndexOf != -1) {
            if (task.getNextExecuteNanoTime() <= j2) {
                if (TaskRunner.INSTANCE.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(task, this, "already scheduled");
                }
                return false;
            }
            this.futureTasks.remove(iIndexOf);
        }
        task.setNextExecuteNanoTime$okhttp(j2);
        if (TaskRunner.INSTANCE.getLogger().isLoggable(Level.FINE)) {
            if (recurrence) {
                str = "run again after " + TaskLoggerKt.formatDuration(j2 - jNanoTime);
            } else {
                str = "scheduled after " + TaskLoggerKt.formatDuration(j2 - jNanoTime);
            }
            TaskLoggerKt.log(task, this, str);
        }
        Iterator<Task> it = this.futureTasks.iterator();
        int size = 0;
        while (true) {
            if (!it.hasNext()) {
                size = -1;
                break;
            }
            if (it.next().getNextExecuteNanoTime() - jNanoTime > delayNanos) {
                break;
            }
            size++;
        }
        if (size == -1) {
            size = this.futureTasks.size();
        }
        this.futureTasks.add(size, task);
        return size == 0;
    }

    public final void setActiveTask$okhttp(@Nullable Task task) {
        this.activeTask = task;
    }

    public final void setCancelActiveTask$okhttp(boolean z2) {
        this.cancelActiveTask = z2;
    }

    public final void setShutdown$okhttp(boolean z2) {
        this.shutdown = z2;
    }

    public final void shutdown() {
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this.taskRunner) {
            this.shutdown = true;
            if (cancelAllAndDecide$okhttp()) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
            j jVar = j.a;
        }
    }

    @NotNull
    public String toString() {
        return this.name;
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, String str, long j2, a aVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        taskQueue.schedule(new AnonymousClass2(aVar, str, str), j2);
    }

    public final void schedule(@NotNull String str, long j2, @NotNull a<Long> aVar) {
        schedule(new AnonymousClass2(aVar, str, str), j2);
    }
}
