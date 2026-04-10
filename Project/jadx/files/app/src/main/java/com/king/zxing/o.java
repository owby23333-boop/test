package com.king.zxing;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import java.lang.ref.WeakReference;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: InactivityTimer.java */
/* JADX INFO: loaded from: classes2.dex */
final class o {
    private final Activity a;
    private final BroadcastReceiver b = new b(this);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f16523c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AsyncTask<Object, Object, Object> f16524d;

    /* JADX INFO: compiled from: InactivityTimer.java */
    private static class a extends AsyncTask<Object, Object, Object> {
        private WeakReference<Activity> a;

        public a(Activity activity) {
            this.a = new WeakReference<>(activity);
        }

        @Override // android.os.AsyncTask
        protected Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(300000L);
                com.king.zxing.r.b.b("Finishing activity due to inactivity");
                Activity activity = this.a.get();
                if (activity == null) {
                    return null;
                }
                activity.finish();
                return null;
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: InactivityTimer.java */
    private static class b extends BroadcastReceiver {
        private WeakReference<o> a;

        public b(o oVar) {
            this.a = new WeakReference<>(oVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            o oVar;
            if (!"android.intent.action.BATTERY_CHANGED".equals(intent.getAction()) || (oVar = this.a.get()) == null) {
                return;
            }
            if (intent.getIntExtra("plugged", -1) <= 0) {
                oVar.a();
            } else {
                oVar.e();
            }
        }
    }

    o(Activity activity) {
        this.a = activity;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        AsyncTask<Object, Object, Object> asyncTask = this.f16524d;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.f16524d = null;
        }
    }

    void b() {
        e();
        if (!this.f16523c) {
            com.king.zxing.r.b.c("PowerStatusReceiver was never registered?");
        } else {
            this.a.unregisterReceiver(this.b);
            this.f16523c = false;
        }
    }

    void c() {
        if (this.f16523c) {
            com.king.zxing.r.b.c("PowerStatusReceiver was already registered?");
        } else {
            this.a.registerReceiver(this.b, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            this.f16523c = true;
        }
        a();
    }

    void d() {
        e();
    }

    void a() {
        e();
        this.f16524d = new a(this.a);
        try {
            this.f16524d.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        } catch (RejectedExecutionException unused) {
            com.king.zxing.r.b.c("Couldn't schedule inactivity task; ignoring");
        }
    }
}
