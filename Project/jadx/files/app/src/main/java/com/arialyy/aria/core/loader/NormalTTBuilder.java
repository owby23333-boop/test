package com.arialyy.aria.core.loader;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.ThreadRecord;
import com.arialyy.aria.core.common.AbsNormalEntity;
import com.arialyy.aria.core.common.SubThreadConfig;
import com.arialyy.aria.core.download.DGTaskWrapper;
import com.arialyy.aria.core.inf.IThreadStateManager;
import com.arialyy.aria.core.task.IThreadTask;
import com.arialyy.aria.core.task.ThreadTask;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class NormalTTBuilder implements IThreadTaskBuilder {
    protected String TAG = CommonUtil.getClassName(this);
    private AbsNormalTTBuilderAdapter mAdapter;
    private TaskRecord mRecord;
    private int mStartThreadNum;
    private Handler mStateHandler;
    private int mTotalThreadNum;
    private AbsTaskWrapper mWrapper;

    public NormalTTBuilder(AbsTaskWrapper absTaskWrapper, AbsNormalTTBuilderAdapter absNormalTTBuilderAdapter) {
        if (absTaskWrapper instanceof DGTaskWrapper) {
            throw new AssertionError("NormalTTBuilder 不适用于组合任务");
        }
        this.mWrapper = absTaskWrapper;
        this.mAdapter = absNormalTTBuilderAdapter;
        this.mAdapter.setWrapper(absTaskWrapper);
    }

    private IThreadTask createSingThreadTask(ThreadRecord threadRecord, int i2) {
        return createThreadTask(this.mAdapter.getSubThreadConfig(this.mStateHandler, threadRecord, this.mRecord.isBlock, i2));
    }

    private IThreadTask createThreadTask(SubThreadConfig subThreadConfig) {
        ThreadTask threadTask = new ThreadTask(subThreadConfig);
        threadTask.setAdapter(this.mAdapter.getAdapter(subThreadConfig));
        return threadTask;
    }

    private List<IThreadTask> handleBreakpoint() {
        long j2;
        Object obj;
        long fileSize = getEntity().getFileSize();
        int i2 = this.mTotalThreadNum;
        long j3 = fileSize / ((long) i2);
        ArrayList arrayList = new ArrayList(i2);
        this.mRecord.fileLength = fileSize;
        if (this.mWrapper.isNewTask() && !this.mAdapter.handleNewTask(this.mRecord, this.mTotalThreadNum)) {
            ALog.e(this.TAG, "初始化线程任务失败");
            return null;
        }
        Iterator<ThreadRecord> it = this.mRecord.threadRecords.iterator();
        while (it.hasNext()) {
            if (!it.next().isComplete) {
                this.mStartThreadNum++;
            }
        }
        char c2 = 0;
        long j4 = 0;
        int i3 = 0;
        while (i3 < this.mTotalThreadNum) {
            long j5 = ((long) i3) * j3;
            int i4 = i3 + 1;
            long j6 = j4;
            long j7 = ((long) i4) * j3;
            ThreadRecord threadRecord = this.mRecord.threadRecords.get(i3);
            if (threadRecord.isComplete) {
                long j8 = j6 + (j7 - j5);
                String str = this.TAG;
                Object[] objArr = new Object[2];
                objArr[c2] = this.mWrapper.getKey();
                objArr[1] = Integer.valueOf(i3);
                ALog.d(str, String.format("任务【%s】线程__%s__已完成", objArr));
                Message messageObtainMessage = this.mStateHandler.obtainMessage();
                messageObtainMessage.what = 4;
                Bundle data = messageObtainMessage.getData();
                if (data == null) {
                    data = new Bundle();
                }
                data.putString(IThreadStateManager.DATA_THREAD_NAME, CommonUtil.getThreadName(getEntity().getKey(), threadRecord.threadId));
                messageObtainMessage.setData(data);
                messageObtainMessage.sendToTarget();
                j2 = j3;
                j4 = j8;
                obj = null;
            } else {
                j2 = j3;
                long j9 = threadRecord.startLocation;
                if (j5 < j9) {
                    if (i3 == this.mTotalThreadNum - 1) {
                        j7 = fileSize;
                    }
                    if (j9 <= j7) {
                        j6 += j9 - j5;
                    }
                }
                ALog.d(this.TAG, String.format("任务【%s】线程__%s__恢复任务", getEntity().getFileName(), Integer.valueOf(i3)));
                IThreadTask iThreadTaskCreateSingThreadTask = createSingThreadTask(threadRecord, this.mStartThreadNum);
                if (iThreadTaskCreateSingThreadTask == null) {
                    ALog.e(this.TAG, "创建线程任务失败");
                    return null;
                }
                obj = null;
                arrayList.add(iThreadTaskCreateSingThreadTask);
                j4 = j6;
            }
            i3 = i4;
            j3 = j2;
            c2 = 0;
        }
        long j10 = j4;
        if (j10 != getEntity().getCurrentProgress()) {
            ALog.d(this.TAG, String.format("进度修正，当前进度：%s", Long.valueOf(j10)));
            getEntity().setCurrentProgress(j10);
        }
        return arrayList;
    }

    private List<IThreadTask> handleNoSupportBP() {
        ArrayList arrayList = new ArrayList();
        this.mStartThreadNum = 1;
        TaskRecord taskRecord = this.mRecord;
        taskRecord.isBlock = false;
        taskRecord.update();
        arrayList.add(createSingThreadTask(this.mRecord.threadRecords.get(0), 1));
        return arrayList;
    }

    private List<IThreadTask> handleTask() {
        return this.mWrapper.isSupportBP() ? handleBreakpoint() : handleNoSupportBP();
    }

    @Override // com.arialyy.aria.core.loader.ILoaderComponent
    public void accept(ILoaderVisitor iLoaderVisitor) {
        iLoaderVisitor.addComponent(this);
    }

    @Override // com.arialyy.aria.core.loader.IThreadTaskBuilder
    public List<IThreadTask> buildThreadTask(TaskRecord taskRecord, Handler handler) {
        this.mRecord = taskRecord;
        this.mStateHandler = handler;
        this.mTotalThreadNum = this.mRecord.threadNum;
        return handleTask();
    }

    public AbsNormalTTBuilderAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // com.arialyy.aria.core.loader.IThreadTaskBuilder
    public int getCreatedThreadNum() {
        return this.mStartThreadNum;
    }

    protected AbsNormalEntity getEntity() {
        return (AbsNormalEntity) this.mWrapper.getEntity();
    }
}
