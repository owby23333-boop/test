package com.baidu.tts.statistics;

import android.content.Context;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes2.dex */
public class StatisticsClient {
    private static final String TAG = "StatisticsClient";
    private FutureTask<Integer> futureTask;
    private Context mContext;
    private UploadStatistics mUploadStatistics;

    public StatisticsClient(Context context) {
        this.mContext = context;
        this.mUploadStatistics = new UploadStatistics(context);
    }

    public void start() {
        int iIntValue;
        this.futureTask = this.mUploadStatistics.uplaoadStatisticsInfo();
        try {
            iIntValue = this.futureTask.get().intValue();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            iIntValue = -1;
        } catch (ExecutionException e3) {
            e3.printStackTrace();
            iIntValue = -1;
        }
        LoggerProxy.d(TAG, "Statistics uploade result=" + iIntValue);
    }

    public void stop() {
        if (this.futureTask != null) {
            this.mUploadStatistics.stop();
        }
    }
}
