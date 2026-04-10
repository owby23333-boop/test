package com.taobao.accs.net;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import com.taobao.accs.internal.AccsJobService;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class u extends f {
    public static final int DEAMON_JOB_ID = 2051;
    public static final int HB_JOB_ID = 2050;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JobScheduler f18239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f18240d;

    protected u(Context context) {
        super(context);
    }

    @Override // com.taobao.accs.net.f
    protected void a(int i2) {
        if (this.f18239c == null) {
            this.f18239c = (JobScheduler) this.a.getSystemService("jobscheduler");
        }
        long j2 = i2 * 1000;
        this.f18240d = this.f18239c.schedule(new JobInfo.Builder(2050, new ComponentName(this.a.getPackageName(), AccsJobService.class.getName())).setMinimumLatency(j2).setOverrideDeadline(j2).setRequiredNetworkType(1).build());
    }
}
