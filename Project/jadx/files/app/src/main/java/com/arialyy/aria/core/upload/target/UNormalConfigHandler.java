package com.arialyy.aria.core.upload.target;

import com.arialyy.aria.core.common.AbsEntity;
import com.arialyy.aria.core.common.AbsNormalTarget;
import com.arialyy.aria.core.event.ErrorEvent;
import com.arialyy.aria.core.inf.AbsTarget;
import com.arialyy.aria.core.inf.IConfigHandler;
import com.arialyy.aria.core.manager.TaskWrapperManager;
import com.arialyy.aria.core.queue.UTaskQueue;
import com.arialyy.aria.core.task.UploadTask;
import com.arialyy.aria.core.upload.UTaskWrapper;
import com.arialyy.aria.core.upload.UploadEntity;
import com.arialyy.aria.orm.DbEntity;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
class UNormalConfigHandler<TARGET extends AbsTarget> implements IConfigHandler {
    private UploadEntity mEntity;
    private TARGET mTarget;
    private UTaskWrapper mWrapper;

    UNormalConfigHandler(TARGET target, long j2) {
        this.mTarget = target;
        initTarget(j2);
    }

    private UTaskWrapper getTaskWrapper() {
        return this.mWrapper;
    }

    private void initTarget(long j2) {
        this.mWrapper = (UTaskWrapper) TaskWrapperManager.getInstance().getNormalTaskWrapper(UTaskWrapper.class, j2);
        if (this.mTarget instanceof AbsNormalTarget) {
            if (j2 < 0) {
                this.mWrapper.setErrorEvent(new ErrorEvent(j2, "任务id为空"));
            } else if (this.mWrapper.getEntity().getId() < 0) {
                this.mWrapper.setErrorEvent(new ErrorEvent(j2, "任务信息不存在"));
            }
        }
        this.mEntity = this.mWrapper.getEntity();
        this.mTarget.setTaskWrapper(this.mWrapper);
        getTaskWrapper().setTempUrl(this.mEntity.getUrl());
    }

    @Override // com.arialyy.aria.core.inf.IConfigHandler
    public AbsEntity getEntity() {
        return this.mEntity;
    }

    @Override // com.arialyy.aria.core.inf.IConfigHandler
    public boolean isRunning() {
        UploadTask task = UTaskQueue.getInstance().getTask(this.mEntity.getKey());
        return task != null && task.isRunning();
    }

    void setFilePath(String str) {
        File file = new File(str);
        this.mEntity.setFilePath(str);
        this.mEntity.setFileName(file.getName());
        this.mEntity.setFileSize(file.length());
    }

    void setTempUrl(String str) {
        getTaskWrapper().setTempUrl(str);
    }

    @Override // com.arialyy.aria.core.inf.IConfigHandler
    public boolean taskExists() {
        return DbEntity.checkDataExist(UploadEntity.class, "key=?", this.mEntity.getFilePath());
    }
}
