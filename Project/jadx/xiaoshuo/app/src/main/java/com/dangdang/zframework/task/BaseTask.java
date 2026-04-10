package com.dangdang.zframework.task;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes10.dex */
public abstract class BaseTask<T> implements Callable<T> {
    private volatile Status mStatus = Status.PENDING;
    public String taskId;

    public enum Status {
        PENDING,
        WAITING,
        RUNNING,
        FINISHED
    }

    @Override // java.util.concurrent.Callable
    public final T call() throws Exception {
        return processTask();
    }

    public Status getStatus() {
        return this.mStatus;
    }

    public abstract void handleResult(T t);

    public abstract T processTask() throws Exception;

    public void setStatus(Status status) {
        this.mStatus = status;
    }
}
