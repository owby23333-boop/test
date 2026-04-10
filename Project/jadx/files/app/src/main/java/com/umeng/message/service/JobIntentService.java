package com.umeng.message.service;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class JobIntentService extends Service {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final Object f20569h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final HashMap<ComponentName, f> f20570i = new HashMap<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f20571j = "JobIntentService";
    CompatJobEngine a;
    f b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    a f20572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f20573d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f20574e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f20575f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final ArrayList<c> f20576g;

    interface CompatJobEngine {
        IBinder compatGetBinder();

        GenericWorkItem dequeueWork();
    }

    interface GenericWorkItem {
        void complete();

        Intent getIntent();
    }

    final class c implements GenericWorkItem {
        final Intent a;
        final int b;

        c(Intent intent, int i2) {
            this.a = intent;
            this.b = i2;
        }

        @Override // com.umeng.message.service.JobIntentService.GenericWorkItem
        public void complete() {
            try {
                JobIntentService.this.stopSelf(this.b);
            } catch (Throwable unused) {
            }
        }

        @Override // com.umeng.message.service.JobIntentService.GenericWorkItem
        public Intent getIntent() {
            return this.a;
        }
    }

    @TargetApi(26)
    static final class d extends JobServiceEngine implements CompatJobEngine {
        final JobIntentService a;
        final Object b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        JobParameters f20581c;

        final class a implements GenericWorkItem {
            final JobWorkItem a;

            a(JobWorkItem jobWorkItem) {
                this.a = jobWorkItem;
            }

            @Override // com.umeng.message.service.JobIntentService.GenericWorkItem
            public void complete() {
                try {
                    synchronized (d.this.b) {
                        if (d.this.f20581c != null) {
                            try {
                                d.this.f20581c.completeWork(this.a);
                            } catch (Throwable unused) {
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
            }

            @Override // com.umeng.message.service.JobIntentService.GenericWorkItem
            public Intent getIntent() {
                return this.a.getIntent();
            }
        }

        d(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.b = new Object();
            this.a = jobIntentService;
        }

        @Override // com.umeng.message.service.JobIntentService.CompatJobEngine
        public IBinder compatGetBinder() {
            return getBinder();
        }

        @Override // com.umeng.message.service.JobIntentService.CompatJobEngine
        public GenericWorkItem dequeueWork() {
            try {
                synchronized (this.b) {
                    if (this.f20581c == null) {
                        return null;
                    }
                    JobWorkItem jobWorkItemDequeueWork = this.f20581c.dequeueWork();
                    if (jobWorkItemDequeueWork == null) {
                        return null;
                    }
                    jobWorkItemDequeueWork.getIntent().setExtrasClassLoader(this.a.getClassLoader());
                    return new a(jobWorkItemDequeueWork);
                }
            } catch (Throwable unused) {
                return null;
            }
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters jobParameters) {
            this.f20581c = jobParameters;
            this.a.a(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters jobParameters) {
            boolean zA = this.a.a();
            synchronized (this.b) {
                this.f20581c = null;
            }
            return zA;
        }
    }

    @TargetApi(21)
    static final class e extends f {
        private final JobInfo a;
        private JobScheduler b;

        e(Context context, ComponentName componentName, int i2) {
            super(context, componentName);
            a(i2);
            this.a = new JobInfo.Builder(i2, this.f20582c).setOverrideDeadline(0L).build();
            try {
                this.b = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
            } catch (Throwable unused) {
            }
        }

        @Override // com.umeng.message.service.JobIntentService.f
        void a(Intent intent) {
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    this.b.enqueue(this.a, new JobWorkItem(intent));
                }
            } catch (Throwable unused) {
            }
        }
    }

    static abstract class f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ComponentName f20582c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f20583d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f20584e;

        f(Context context, ComponentName componentName) {
            this.f20582c = componentName;
        }

        public void a() {
        }

        void a(int i2) {
            if (!this.f20583d) {
                this.f20583d = true;
                this.f20584e = i2;
            } else {
                if (this.f20584e == i2) {
                    return;
                }
                throw new IllegalArgumentException("Given job ID " + i2 + " is different than previous " + this.f20584e);
            }
        }

        abstract void a(Intent intent);

        public void b() {
        }

        public void c() {
        }
    }

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f20576g = null;
        } else {
            this.f20576g = new ArrayList<>();
        }
    }

    static f a(Context context, ComponentName componentName, boolean z2, int i2) {
        f bVar;
        f fVar = f20570i.get(componentName);
        if (fVar != null) {
            return fVar;
        }
        if (Build.VERSION.SDK_INT < 26) {
            bVar = new b(context, componentName);
        } else {
            if (!z2) {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
            bVar = new e(context, componentName, i2);
        }
        f fVar2 = bVar;
        f20570i.put(componentName, fVar2);
        return fVar2;
    }

    private void d() {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                this.a = new d(this);
                this.b = null;
            } else {
                this.a = null;
                this.b = a(this, new ComponentName(this, getClass()), false, 0);
            }
        } catch (Throwable unused) {
        }
    }

    public static void enqueueWork(Context context, Class<?> cls, int i2, Intent intent) {
        if (context == null || cls == null || intent == null) {
            return;
        }
        try {
            enqueueWork(context, new ComponentName(context, cls), i2, intent);
        } catch (Throwable unused) {
        }
    }

    protected abstract void a(Intent intent);

    void b() {
        try {
            if (this.f20576g != null) {
                synchronized (this.f20576g) {
                    this.f20572c = null;
                    if (this.f20576g.size() > 0) {
                        a(false);
                    } else if (!this.f20575f) {
                        this.b.c();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    GenericWorkItem c() {
        c cVarRemove;
        CompatJobEngine compatJobEngine = this.a;
        if (compatJobEngine != null) {
            return compatJobEngine.dequeueWork();
        }
        ArrayList<c> arrayList = this.f20576g;
        if (arrayList == null) {
            return null;
        }
        synchronized (arrayList) {
            cVarRemove = this.f20576g.size() > 0 ? this.f20576g.remove(0) : null;
        }
        return cVarRemove;
    }

    public boolean isStopped() {
        return this.f20574e;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent != null) {
            try {
                if (this.a != null) {
                    return this.a.compatGetBinder();
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        d();
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            super.onDestroy();
            if (this.f20576g != null) {
                synchronized (this.f20576g) {
                    this.f20575f = true;
                    this.b.c();
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Service
    @SuppressLint({"WrongConstant"})
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (intent != null) {
            try {
                if (this.f20576g != null) {
                    if (this.b == null) {
                        d();
                    }
                    this.b.a();
                    synchronized (this.f20576g) {
                        ArrayList<c> arrayList = this.f20576g;
                        if (intent == null) {
                            intent = new Intent();
                        }
                        arrayList.add(new c(intent, i3));
                        a(true);
                    }
                    return 3;
                }
            } catch (Throwable unused) {
            }
        }
        return 2;
    }

    public boolean onStopCurrentWork() {
        return true;
    }

    public void setInterruptIfStopped(boolean z2) {
        this.f20573d = z2;
    }

    public static void enqueueWork(Context context, ComponentName componentName, int i2, Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        if (context == null || componentName == null) {
            return;
        }
        try {
            synchronized (f20569h) {
                f fVarA = a(context, componentName, true, i2);
                fVarA.a(i2);
                fVarA.a(intent);
            }
        } catch (Throwable unused) {
        }
    }

    static final class a extends AsyncTask<JobIntentService, Void, JobIntentService> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public JobIntentService doInBackground(JobIntentService... jobIntentServiceArr) {
            if (jobIntentServiceArr == null || jobIntentServiceArr.length < 1) {
                return null;
            }
            JobIntentService jobIntentService = jobIntentServiceArr[0];
            while (true) {
                try {
                    GenericWorkItem genericWorkItemC = jobIntentService.c();
                    if (genericWorkItemC == null) {
                        break;
                    }
                    jobIntentService.a(genericWorkItemC.getIntent());
                    genericWorkItemC.complete();
                } catch (Throwable unused) {
                }
            }
            return jobIntentService;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(JobIntentService jobIntentService) {
            if (jobIntentService != null) {
                try {
                    jobIntentService.b();
                } catch (Throwable unused) {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onCancelled(JobIntentService jobIntentService) {
            if (jobIntentService != null) {
                try {
                    jobIntentService.b();
                } catch (Throwable unused) {
                }
            }
        }
    }

    boolean a() {
        a aVar = this.f20572c;
        if (aVar != null) {
            aVar.cancel(this.f20573d);
        }
        this.f20574e = true;
        return onStopCurrentWork();
    }

    static final class b extends f {
        boolean a;
        boolean b;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Context f20577f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final PowerManager.WakeLock f20578g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final PowerManager.WakeLock f20579h;

        b(Context context, ComponentName componentName) {
            super(context, componentName);
            this.f20577f = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            this.f20578g = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f20578g.setReferenceCounted(false);
            this.f20579h = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f20579h.setReferenceCounted(false);
        }

        @Override // com.umeng.message.service.JobIntentService.f
        void a(Intent intent) {
            try {
                Intent intent2 = new Intent(intent);
                intent2.setComponent(this.f20582c);
                if (this.f20577f.startService(intent2) != null) {
                    synchronized (this) {
                        if (!this.a) {
                            this.a = true;
                            if (!this.b) {
                                this.f20578g.acquire(60000L);
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }

        @Override // com.umeng.message.service.JobIntentService.f
        public void b() {
            try {
                synchronized (this) {
                    if (!this.b) {
                        this.b = true;
                        this.f20579h.acquire(TTAdConstant.AD_MAX_EVENT_TIME);
                        this.f20578g.release();
                    }
                }
            } catch (Throwable unused) {
            }
        }

        @Override // com.umeng.message.service.JobIntentService.f
        public void c() {
            try {
                synchronized (this) {
                    if (this.b) {
                        if (this.a) {
                            this.f20578g.acquire(60000L);
                        }
                        this.b = false;
                        this.f20579h.release();
                    }
                }
            } catch (Throwable unused) {
            }
        }

        @Override // com.umeng.message.service.JobIntentService.f
        public void a() {
            synchronized (this) {
                this.a = false;
            }
        }
    }

    @SuppressLint({"ObsoleteSdkInt"})
    void a(boolean z2) {
        try {
            if (this.f20572c == null) {
                this.f20572c = new a();
                if (this.b != null && z2) {
                    this.b.b();
                }
                if (Build.VERSION.SDK_INT >= 11) {
                    com.umeng.message.proguard.c.a(this.f20572c, this);
                } else {
                    this.f20572c.execute(new JobIntentService[0]);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
