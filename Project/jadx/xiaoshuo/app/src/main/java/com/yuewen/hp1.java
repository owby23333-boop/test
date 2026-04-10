package com.yuewen;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import com.duokan.reader.domain.job.WorkJobService;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(api = 21)
public class hp1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f12076a = 30000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f12077b = "cls_name";

    public static void a(Context context, Class<? extends Runnable> cls, long j, int i) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        ArrayList arrayList = new ArrayList();
        arrayList.add(cls.getName());
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putStringArray(f12077b, (String[]) arrayList.toArray(new String[0]));
        jobScheduler.schedule(new JobInfo.Builder(i, new ComponentName(context, (Class<?>) WorkJobService.class)).setRequiredNetworkType(1).setMinimumLatency(j).setExtras(persistableBundle).build());
    }
}
