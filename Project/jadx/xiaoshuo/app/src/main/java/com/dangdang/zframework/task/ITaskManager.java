package com.dangdang.zframework.task;

/* JADX INFO: loaded from: classes10.dex */
public interface ITaskManager {
    void clearTask();

    boolean isRunning();

    boolean putTask(BaseTask<?> baseTask);

    boolean putTaskToFirst(BaseTask<?> baseTask);

    void removeTask(BaseTask<?> baseTask);

    void startTask();

    void stopTask();
}
