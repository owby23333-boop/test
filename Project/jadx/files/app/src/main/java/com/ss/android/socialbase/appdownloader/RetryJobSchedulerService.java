package com.ss.android.socialbase.appdownloader;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
@TargetApi(21)
public class RetryJobSchedulerService extends JobService {
    static void mb(DownloadInfo downloadInfo, long j2, boolean z2, int i2) {
        Context appContext;
        long j3;
        IReserveWifiStatusListener reserveWifiStatusListener;
        IReserveWifiStatusListener reserveWifiStatusListener2;
        if (downloadInfo == null || j2 <= 0 || (appContext = DownloadComponentManager.getAppContext()) == null) {
            return;
        }
        int i3 = 2;
        if (downloadInfo.isPauseReserveOnWifi() && (reserveWifiStatusListener2 = Downloader.getInstance(DownloadComponentManager.getAppContext()).getReserveWifiStatusListener()) != null) {
            reserveWifiStatusListener2.onStatusChanged(downloadInfo, 2, 3);
        }
        try {
            JobScheduler jobScheduler = (JobScheduler) appContext.getSystemService("jobscheduler");
            if (jobScheduler == null) {
                return;
            }
            try {
                jobScheduler.cancel(downloadInfo.getId());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (i2 == 0 || (z2 && i2 != 2)) {
                j2 = 1000;
                j3 = 0;
            } else {
                j3 = 60000 + j2;
            }
            JobInfo.Builder minimumLatency = new JobInfo.Builder(downloadInfo.getId(), new ComponentName(appContext.getPackageName(), RetryJobSchedulerService.class.getName())).setMinimumLatency(j2);
            if (!z2) {
                i3 = 1;
            }
            JobInfo.Builder requiresDeviceIdle = minimumLatency.setRequiredNetworkType(i3).setRequiresCharging(false).setRequiresDeviceIdle(false);
            if (j3 > 0) {
                requiresDeviceIdle.setOverrideDeadline(j3);
            }
            int iSchedule = jobScheduler.schedule(requiresDeviceIdle.build());
            if (iSchedule > 0 && downloadInfo.isPauseReserveOnWifi() && (reserveWifiStatusListener = Downloader.getInstance(DownloadComponentManager.getAppContext()).getReserveWifiStatusListener()) != null) {
                reserveWifiStatusListener.onStatusChanged(downloadInfo, 3, 3);
            }
            if (iSchedule <= 0) {
                Logger.w("RetrySchedulerService", "schedule err errCode = " + iSchedule);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DownloadComponentManager.setAppContext(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        int iOnStartCommand = super.onStartCommand(intent, i2, i3);
        if (DownloadComponentManager.notAutoRebootService()) {
            return 2;
        }
        return iOnStartCommand;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (jobParameters == null) {
            return false;
        }
        int jobId = jobParameters.getJobId();
        Logger.i("RetrySchedulerService", "onStartJob, id = " + jobId);
        RetryScheduler.getInstance().doSchedulerRetry(jobId);
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    static void mb(int i2) {
        Context appContext = DownloadComponentManager.getAppContext();
        if (appContext == null) {
            return;
        }
        try {
            JobScheduler jobScheduler = (JobScheduler) appContext.getSystemService("jobscheduler");
            if (jobScheduler == null) {
                return;
            }
            jobScheduler.cancel(i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
