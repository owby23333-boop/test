package com.yuewen;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.util.Log;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes5.dex */
public final class in1 {
    public static final String e = "in1";
    public static final long f = 300000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f12527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BroadcastReceiver f12528b = new b();
    public boolean c = false;
    public AsyncTask<Object, Object, Object> d;

    public final class a extends AsyncTask<Object, Object, Object> {
        @Override // android.os.AsyncTask
        public Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(300000L);
                Log.i(in1.e, "Finishing activity due to inactivity");
                in1.this.f12527a.finish();
                return null;
            } catch (InterruptedException unused) {
                return null;
            }
        }

        public a() {
        }
    }

    public final class b extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                if (intent.getIntExtra("plugged", -1) <= 0) {
                    in1.this.e();
                } else {
                    in1.this.d();
                }
            }
        }

        public b() {
        }
    }

    public in1(Activity activity) {
        this.f12527a = activity;
        e();
    }

    public final synchronized void d() {
        AsyncTask<Object, Object, Object> asyncTask = this.d;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.d = null;
        }
    }

    public synchronized void e() {
        d();
        a aVar = new a();
        this.d = aVar;
        try {
            aVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        } catch (RejectedExecutionException unused) {
            Log.w(e, "Couldn't schedule inactivity task; ignoring");
        }
    }

    public synchronized void f() {
        d();
        if (this.c) {
            this.f12527a.unregisterReceiver(this.f12528b);
            this.c = false;
        } else {
            Log.w(e, "PowerStatusReceiver was never registered?");
        }
    }

    public synchronized void g() {
        if (this.c) {
            Log.w(e, "PowerStatusReceiver was already registered?");
        } else {
            this.f12527a.registerReceiver(this.f12528b, new IntentFilter("android.intent.action.BATTERY_CHANGED"), 2);
            this.c = true;
        }
        e();
    }

    public void h() {
        d();
    }
}
