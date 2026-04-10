package com.ss.android.socialbase.appdownloader;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.bytedance.sdk.component.utils.wp;
import com.ss.android.socialbase.downloader.downloader.js;
import com.ss.android.socialbase.downloader.impls.fv;

/* JADX INFO: loaded from: classes4.dex */
public class RetryJobSchedulerService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.ss.android.socialbase.downloader.downloader.dl.z(this);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (jobParameters == null) {
            return false;
        }
        int jobId = jobParameters.getJobId();
        com.ss.android.socialbase.downloader.m.z.dl("RetrySchedulerService", "onStartJob, id = ".concat(String.valueOf(jobId)));
        fv.z().z(jobId);
        return false;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int iOnStartCommand = super.onStartCommand(intent, i, i2);
        if (com.ss.android.socialbase.downloader.downloader.dl.fo()) {
            return 2;
        }
        return iOnStartCommand;
    }

    static void z(com.ss.android.socialbase.downloader.e.dl dlVar, long j, boolean z, int i) {
        Context contextXl;
        long j2;
        js jsVarG;
        js jsVarG2;
        if (dlVar == null || j <= 0 || (contextXl = com.ss.android.socialbase.downloader.downloader.dl.xl()) == null) {
            return;
        }
        int i2 = 2;
        if (dlVar.jq() && (jsVarG2 = com.ss.android.socialbase.downloader.downloader.e.g(com.ss.android.socialbase.downloader.downloader.dl.xl()).g()) != null) {
            jsVarG2.z(dlVar, 2, 3);
        }
        try {
            JobScheduler jobScheduler = (JobScheduler) contextXl.getSystemService("jobscheduler");
            if (jobScheduler == null) {
                return;
            }
            try {
                jobScheduler.cancel(dlVar.e());
            } catch (Throwable th) {
                wp.z(th);
            }
            if (i == 0 || (z && i != 2)) {
                j = 1000;
                j2 = 0;
            } else {
                j2 = 60000 + j;
            }
            JobInfo.Builder minimumLatency = new JobInfo.Builder(dlVar.e(), new ComponentName(contextXl.getPackageName(), RetryJobSchedulerService.class.getName())).setMinimumLatency(j);
            if (!z) {
                i2 = 1;
            }
            JobInfo.Builder requiresDeviceIdle = minimumLatency.setRequiredNetworkType(i2).setRequiresCharging(false).setRequiresDeviceIdle(false);
            if (j2 > 0) {
                requiresDeviceIdle.setOverrideDeadline(j2);
            }
            int iSchedule = jobScheduler.schedule(requiresDeviceIdle.build());
            if (iSchedule > 0 && dlVar.jq() && (jsVarG = com.ss.android.socialbase.downloader.downloader.e.g(com.ss.android.socialbase.downloader.downloader.dl.xl()).g()) != null) {
                jsVarG.z(dlVar, 3, 3);
            }
            if (iSchedule <= 0) {
                com.ss.android.socialbase.downloader.m.z.a("RetrySchedulerService", "schedule err errCode = ".concat(String.valueOf(iSchedule)));
            }
        } catch (Throwable th2) {
            wp.z(th2);
        }
    }
}
