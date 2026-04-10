package com.anythink.expressad.exoplayer.scheduler;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import com.anythink.expressad.exoplayer.k.af;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(21)
public final class PlatformScheduler implements c {
    private static final String b = "PlatformScheduler";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10040c = "service_action";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f10041d = "service_package";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f10042e = "requirements";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f10043f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ComponentName f10044g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final JobScheduler f10045h;

    public static final class PlatformSchedulerService extends JobService {
        @Override // android.app.job.JobService
        public final boolean onStartJob(JobParameters jobParameters) {
            PersistableBundle extras = jobParameters.getExtras();
            if (!new a(extras.getInt(PlatformScheduler.f10042e)).a(this)) {
                jobFinished(jobParameters, true);
                return false;
            }
            String string = extras.getString(PlatformScheduler.f10040c);
            String string2 = extras.getString(PlatformScheduler.f10041d);
            Intent intent = new Intent(string).setPackage(string2);
            StringBuilder sb = new StringBuilder("Starting service action: ");
            sb.append(string);
            sb.append(" package: ");
            sb.append(string2);
            af.a((Context) this, intent);
            return false;
        }

        @Override // android.app.job.JobService
        public final boolean onStopJob(JobParameters jobParameters) {
            return false;
        }
    }

    private PlatformScheduler(Context context, int i2) {
        this.f10043f = i2;
        this.f10044g = new ComponentName(context, (Class<?>) PlatformSchedulerService.class);
        this.f10045h = (JobScheduler) context.getSystemService("jobscheduler");
    }

    private static void b() {
    }

    private static /* synthetic */ void c() {
    }

    @Override // com.anythink.expressad.exoplayer.scheduler.c
    public final boolean a(a aVar, String str, String str2) {
        JobInfo.Builder builder = new JobInfo.Builder(this.f10043f, this.f10044g);
        int iA = aVar.a();
        int i2 = 4;
        if (iA == 0) {
            i2 = 0;
        } else if (iA == 1) {
            i2 = 1;
        } else if (iA == 2) {
            i2 = 2;
        } else if (iA != 3) {
            if (iA != 4) {
                throw new UnsupportedOperationException();
            }
            if (af.a < 26) {
                throw new UnsupportedOperationException();
            }
        } else {
            if (af.a < 24) {
                throw new UnsupportedOperationException();
            }
            i2 = 3;
        }
        builder.setRequiredNetworkType(i2);
        builder.setRequiresDeviceIdle(aVar.c());
        builder.setRequiresCharging(aVar.b());
        builder.setPersisted(true);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString(f10040c, str2);
        persistableBundle.putString(f10041d, str);
        persistableBundle.putInt(f10042e, aVar.d());
        builder.setExtras(persistableBundle);
        int iSchedule = this.f10045h.schedule(builder.build());
        StringBuilder sb = new StringBuilder("Scheduling job: ");
        sb.append(this.f10043f);
        sb.append(" result: ");
        sb.append(iSchedule);
        return iSchedule == 1;
    }

    @Override // com.anythink.expressad.exoplayer.scheduler.c
    public final boolean a() {
        new StringBuilder("Canceling job: ").append(this.f10043f);
        this.f10045h.cancel(this.f10043f);
        return true;
    }

    @SuppressLint({"WrongConstant"})
    private static JobInfo a(int i2, ComponentName componentName, a aVar, String str, String str2) {
        JobInfo.Builder builder = new JobInfo.Builder(i2, componentName);
        int iA = aVar.a();
        int i3 = 4;
        if (iA == 0) {
            i3 = 0;
        } else if (iA == 1) {
            i3 = 1;
        } else if (iA == 2) {
            i3 = 2;
        } else if (iA != 3) {
            if (iA == 4) {
                if (af.a < 26) {
                    throw new UnsupportedOperationException();
                }
            } else {
                throw new UnsupportedOperationException();
            }
        } else {
            if (af.a < 24) {
                throw new UnsupportedOperationException();
            }
            i3 = 3;
        }
        builder.setRequiredNetworkType(i3);
        builder.setRequiresDeviceIdle(aVar.c());
        builder.setRequiresCharging(aVar.b());
        builder.setPersisted(true);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString(f10040c, str);
        persistableBundle.putString(f10041d, str2);
        persistableBundle.putInt(f10042e, aVar.d());
        builder.setExtras(persistableBundle);
        return builder.build();
    }
}
