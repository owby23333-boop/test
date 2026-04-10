package com.arialyy.aria.core.command;

import com.arialyy.aria.core.download.DGTaskWrapper;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.queue.DGroupTaskQueue;
import com.arialyy.aria.core.queue.DTaskQueue;
import com.arialyy.aria.core.queue.UTaskQueue;
import com.arialyy.aria.core.task.AbsTask;
import com.arialyy.aria.core.upload.UTaskWrapper;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsNormalCmd<T extends AbsTaskWrapper> extends AbsCmd<T> {
    boolean canExeCmd = true;
    int taskType;

    AbsNormalCmd(T t2, int i2) {
        boolean z2 = true;
        this.taskType = i2;
        this.mTaskWrapper = t2;
        this.TAG = CommonUtil.getClassName(this);
        if (i2 == 1) {
            if (!(t2 instanceof DTaskWrapper)) {
                ALog.e(this.TAG, "任务类型错误，任务类型应该为ICM.TASK_TYPE_DOWNLOAD");
                return;
            }
            this.mQueue = DTaskQueue.getInstance();
        } else if (i2 == 3) {
            if (!(t2 instanceof DGTaskWrapper)) {
                ALog.e(this.TAG, "任务类型错误，任务类型应该为ICM.TASK_TYPE_DOWNLOAD_GROUP");
                return;
            }
            this.mQueue = DGroupTaskQueue.getInstance();
        } else if (i2 != 2) {
            ALog.e(this.TAG, "任务类型错误，任务类型应该为ICM.TASK_TYPE_DOWNLOAD、TASK_TYPE_DOWNLOAD_GROUP、TASK_TYPE_UPLOAD");
            return;
        } else {
            if (!(t2 instanceof UTaskWrapper)) {
                ALog.e(this.TAG, "任务类型错误，任务类型应该为ICM.TASK_TYPE_UPLOAD");
                return;
            }
            this.mQueue = UTaskQueue.getInstance();
        }
        if (i2 != 1 && i2 != 3) {
            z2 = false;
        }
        this.isDownloadCmd = z2;
    }

    AbsTask createTask() {
        return this.mQueue.createTask(this.mTaskWrapper);
    }

    AbsTask getTask() {
        return this.mQueue.getTask(this.mTaskWrapper.getEntity().getKey());
    }

    void removeTask() {
        AbsTask task = getTask();
        if (task == null) {
            task = createTask();
        }
        this.mQueue.cancelTask(task);
    }

    void resumeTask() {
        AbsTask task = getTask();
        if (task == null) {
            task = createTask();
        }
        this.mQueue.resumeTask(task);
    }

    void sendWaitState() {
        AbsTask task = getTask();
        if (task == null) {
            task = createTask();
        }
        sendWaitState(task);
    }

    void startTask() {
        AbsTask task = getTask();
        if (task == null) {
            task = createTask();
        }
        this.mQueue.startTask(task);
    }

    void stopAll() {
        this.mQueue.stopAllTask();
    }

    void stopTask() {
        AbsTask task = getTask();
        if (task == null) {
            task = createTask();
        }
        this.mQueue.stopTask(task);
    }

    AbsTask createTask(AbsTaskWrapper absTaskWrapper) {
        return this.mQueue.createTask(absTaskWrapper);
    }

    AbsTask getTask(String str) {
        return this.mQueue.getTask(str);
    }

    void removeTask(AbsTaskWrapper absTaskWrapper) {
        AbsTask task = getTask(absTaskWrapper.getKey());
        if (task == null) {
            task = createTask(absTaskWrapper);
        }
        this.mQueue.cancelTask(task);
    }

    void sendWaitState(AbsTask absTask) {
        if (absTask != null) {
            absTask.getTaskWrapper().setState(3);
            absTask.getOutHandler().obtainMessage(10, absTask).sendToTarget();
        }
    }
}
