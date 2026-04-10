package com.yuewen;

import android.content.Context;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.domain.job.JobInfo;

/* JADX INFO: loaded from: classes3.dex */
public class bz3 extends gp1 {
    @Override // com.yuewen.gp1
    public void a(Context context, JobInfo jobInfo) {
        ia0.w().g(LogLevel.EVENT, com.xiaomi.onetrack.api.at.e, "exec a Test Job!(name: %s, params: %s)", jobInfo.getJobName(), jobInfo.getParams());
    }
}
