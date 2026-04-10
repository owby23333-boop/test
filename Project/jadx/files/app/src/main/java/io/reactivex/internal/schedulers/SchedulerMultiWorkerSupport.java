package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public interface SchedulerMultiWorkerSupport {

    public interface WorkerCallback {
        void onWorker(int i2, @NonNull Scheduler.Worker worker);
    }

    void createWorkers(int i2, @NonNull WorkerCallback workerCallback);
}
