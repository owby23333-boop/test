package com.arialyy.aria.core.common;

import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.ThreadRecord;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.loader.ILoaderVisitor;
import com.arialyy.aria.core.loader.IRecordHandler;
import com.arialyy.aria.core.upload.UploadEntity;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.core.wrapper.RecordWrapper;
import com.arialyy.aria.orm.DbEntity;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import com.arialyy.aria.util.DbDataHelper;
import com.arialyy.aria.util.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RecordHandler implements IRecordHandler {
    protected final String TAG = CommonUtil.getClassName(this);

    @Deprecated
    private File mConfigFile;
    private AbsNormalEntity mEntity;
    protected String mFilePath;
    protected long mFileSize;
    private TaskRecord mTaskRecord;
    private AbsTaskWrapper mTaskWrapper;

    public RecordHandler(AbsTaskWrapper absTaskWrapper) {
        this.mTaskWrapper = absTaskWrapper;
        this.mEntity = (AbsNormalEntity) this.mTaskWrapper.getEntity();
    }

    private void convertDb() throws Throwable {
        List listFindRelationData = DbEntity.findRelationData(RecordWrapper.class, "TaskRecord.filePath=?", getFilePath());
        if (listFindRelationData == null || listFindRelationData.size() == 0) {
            Properties propertiesLoadConfig = FileUtil.loadConfig(this.mConfigFile);
            if (propertiesLoadConfig.isEmpty()) {
                ALog.d(this.TAG, "老版本的线程记录为空，任务为新任务");
                initRecord(true);
                return;
            }
            Set setKeySet = propertiesLoadConfig.keySet();
            HashSet hashSet = new HashSet();
            Iterator it = setKeySet.iterator();
            while (it.hasNext()) {
                String strValueOf = String.valueOf(it.next());
                hashSet.add(Integer.valueOf(Integer.parseInt(strValueOf.substring(strValueOf.length() - 1))));
            }
            int size = hashSet.size();
            if (size == 0) {
                ALog.d(this.TAG, "线程数为空，任务为新任务");
                initRecord(true);
                return;
            }
            this.mTaskWrapper.setNewTask(false);
            this.mTaskRecord = createTaskRecord(size);
            this.mTaskRecord.isBlock = false;
            File file = new File(getFilePath());
            for (int i2 = 0; i2 < size; i2++) {
                ThreadRecord threadRecord = new ThreadRecord();
                threadRecord.taskKey = this.mTaskRecord.filePath;
                String property = propertiesLoadConfig.getProperty(file.getName() + IRecordHandler.STATE + i2);
                String property2 = propertiesLoadConfig.getProperty(file.getName() + IRecordHandler.RECORD + i2);
                if (property == null || Integer.parseInt(String.valueOf(property)) != 1) {
                    if (property2 != null) {
                        long j2 = Long.parseLong(String.valueOf(property2));
                        if (j2 <= 0) {
                            j2 = 0;
                        }
                        threadRecord.startLocation = j2;
                    } else {
                        threadRecord.startLocation = 0L;
                    }
                    this.mTaskRecord.threadRecords.add(threadRecord);
                } else {
                    threadRecord.isComplete = true;
                }
            }
            FileUtil.deleteFile(this.mConfigFile);
        }
    }

    private String getFilePath() {
        return this.mEntity instanceof DownloadEntity ? ((DownloadEntity) this.mTaskWrapper.getEntity()).getFilePath() : ((UploadEntity) this.mTaskWrapper.getEntity()).getFilePath();
    }

    private void initRecord(boolean z2) {
        if (z2) {
            this.mTaskRecord = createTaskRecord(initTaskThreadNum());
        }
        this.mTaskWrapper.setNewTask(true);
        if (this.mTaskWrapper.getRequestType() == 8) {
            return;
        }
        long fileSize = getFileSize() / ((long) this.mTaskRecord.threadNum);
        int i2 = 0;
        while (true) {
            TaskRecord taskRecord = this.mTaskRecord;
            if (i2 >= taskRecord.threadNum) {
                return;
            }
            int i3 = i2 + 1;
            this.mTaskRecord.threadRecords.add(createThreadRecord(taskRecord, i2, ((long) i2) * fileSize, ((long) i3) * fileSize));
            i2 = i3;
        }
    }

    private void saveRecord() {
        TaskRecord taskRecord = this.mTaskRecord;
        taskRecord.threadNum = taskRecord.threadRecords.size();
        this.mTaskRecord.save();
        List<ThreadRecord> list = this.mTaskRecord.threadRecords;
        if (list != null && !list.isEmpty()) {
            DbEntity.saveAll(this.mTaskRecord.threadRecords);
        }
        ALog.d(this.TAG, String.format("保存记录，线程记录数：%s", Integer.valueOf(this.mTaskRecord.threadRecords.size())));
    }

    @Override // com.arialyy.aria.core.loader.ILoaderComponent
    public void accept(ILoaderVisitor iLoaderVisitor) {
        iLoaderVisitor.addComponent(this);
    }

    @Override // com.arialyy.aria.core.loader.IRecordHandler
    public boolean checkTaskCompleted() {
        List<ThreadRecord> list;
        TaskRecord taskRecord = this.mTaskRecord;
        if (taskRecord == null || (list = taskRecord.threadRecords) == null || list.isEmpty()) {
            return false;
        }
        Iterator<ThreadRecord> it = this.mTaskRecord.threadRecords.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (it.next().isComplete) {
                i2++;
            }
        }
        return i2 != 0 && i2 == this.mTaskRecord.threadNum;
    }

    public AbsNormalEntity getEntity() {
        return this.mEntity;
    }

    protected long getFileSize() {
        return this.mFileSize;
    }

    @Override // com.arialyy.aria.core.loader.IRecordHandler
    public TaskRecord getRecord(long j2) throws Throwable {
        this.mFileSize = j2;
        this.mConfigFile = new File(CommonUtil.getFileConfigPath(false, this.mEntity.getFileName()));
        if (this.mConfigFile.exists()) {
            convertDb();
        } else {
            onPre();
            this.mTaskRecord = DbDataHelper.getTaskRecord(getFilePath(), this.mEntity.getTaskType());
            TaskRecord taskRecord = this.mTaskRecord;
            if (taskRecord == null) {
                initRecord(true);
            } else {
                List<ThreadRecord> list = taskRecord.threadRecords;
                if (list == null || list.size() == 0) {
                    TaskRecord taskRecord2 = this.mTaskRecord;
                    if (taskRecord2.threadRecords == null) {
                        taskRecord2.threadRecords = new ArrayList();
                    }
                    initRecord(false);
                }
            }
            handlerTaskRecord(this.mTaskRecord);
        }
        saveRecord();
        return this.mTaskRecord;
    }

    public AbsTaskWrapper getWrapper() {
        return this.mTaskWrapper;
    }

    @Override // com.arialyy.aria.core.loader.IRecordHandler
    public void onPre() {
    }
}
