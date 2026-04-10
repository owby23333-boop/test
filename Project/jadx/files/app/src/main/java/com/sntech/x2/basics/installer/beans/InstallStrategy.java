package com.sntech.x2.basics.installer.beans;

import androidx.annotation.Keep;
import y.b;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class InstallStrategy {

    @Keep
    private TaskData taskData;

    @Keep
    private String taskType;

    @Keep
    private String taskUUID;

    public TaskData getTaskData() {
        return this.taskData;
    }

    public String getTaskType() {
        return this.taskType;
    }

    public String getTaskUUID() {
        return this.taskUUID;
    }

    public void setTaskData(TaskData taskData) {
        this.taskData = taskData;
    }

    public void setTaskType(String str) {
        this.taskType = str;
    }

    public void setTaskUUID(String str) {
        this.taskUUID = str;
    }

    public String toString() {
        StringBuilder sbA = b.a("InstallStrategy{taskUUID='");
        sbA.append(this.taskUUID);
        sbA.append('\'');
        sbA.append(", taskType='");
        sbA.append(this.taskType);
        sbA.append('\'');
        sbA.append(", taskData=");
        sbA.append(this.taskData.toString());
        sbA.append('}');
        return sbA.toString();
    }
}
