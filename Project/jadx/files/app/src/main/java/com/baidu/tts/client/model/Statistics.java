package com.baidu.tts.client.model;

import android.content.Context;
import com.baidu.tts.statistics.StatisticsClient;

/* JADX INFO: loaded from: classes2.dex */
public class Statistics {
    private static final String TAG = "Statistics";
    public static boolean isStatistics = true;
    private StatisticsClient mStatisticsClient;

    public Statistics(Context context) {
        this.mStatisticsClient = new StatisticsClient(context);
    }

    public static void setEnable(boolean z2) {
        isStatistics = z2;
    }

    protected boolean getEnable() {
        return isStatistics;
    }

    public int start() {
        this.mStatisticsClient.start();
        return 0;
    }

    public int stop() {
        this.mStatisticsClient.stop();
        return 0;
    }
}
