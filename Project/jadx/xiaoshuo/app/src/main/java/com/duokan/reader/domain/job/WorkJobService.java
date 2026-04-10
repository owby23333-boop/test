package com.duokan.reader.domain.job;

import android.app.job.JobParameters;
import android.app.job.JobService;
import androidx.annotation.RequiresApi;
import com.duokan.core.diagnostic.LogLevel;
import com.yuewen.hp1;
import com.yuewen.ia0;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(api = 21)
public class WorkJobService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        String[] stringArray = jobParameters.getExtras().getStringArray(hp1.f12077b);
        if (stringArray != null) {
            try {
                if (stringArray.length > 0) {
                    for (String str : stringArray) {
                        ((Runnable) Class.forName(str).newInstance()).run();
                    }
                }
            } catch (Throwable th) {
                ia0.w().j(LogLevel.ERROR, "JobUtils", "runnable construct error..", th);
            }
        }
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
