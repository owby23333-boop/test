package com.yuewen;

import android.hardware.Camera;
import android.os.AsyncTask;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes5.dex */
public final class yg implements Camera.AutoFocusCallback {
    public static final String f = "yg";
    public static final long g = 2000;
    public static final Collection<String> h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f20342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f20343b;
    public final boolean c;
    public final Camera d;
    public AsyncTask<?, ?, ?> e;

    public final class a extends AsyncTask<Object, Object, Object> {
        @Override // android.os.AsyncTask
        public Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException unused) {
            }
            yg.this.c();
            return null;
        }

        public a() {
        }
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        h = arrayList;
        arrayList.add("auto");
        arrayList.add("macro");
    }

    public yg(Camera camera) {
        this.d = camera;
        String focusMode = camera.getParameters().getFocusMode();
        boolean zContains = h.contains(focusMode);
        this.c = zContains;
        Log.i(f, "Current focus mode '" + focusMode + "'; use auto focus? " + zContains);
        c();
    }

    public final synchronized void a() {
        if (!this.f20342a && this.e == null) {
            a aVar = new a();
            try {
                aVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                this.e = aVar;
            } catch (RejectedExecutionException e) {
                Log.w(f, "Could not request auto focus", e);
            }
        }
    }

    public final synchronized void b() {
        AsyncTask<?, ?, ?> asyncTask = this.e;
        if (asyncTask != null) {
            if (asyncTask.getStatus() != AsyncTask.Status.FINISHED) {
                this.e.cancel(true);
            }
            this.e = null;
        }
    }

    public synchronized void c() {
        if (this.c) {
            this.e = null;
            if (!this.f20342a && !this.f20343b) {
                try {
                    this.d.autoFocus(this);
                    this.f20343b = true;
                } catch (RuntimeException e) {
                    Log.w(f, "Unexpected exception while focusing", e);
                    a();
                }
            }
        }
    }

    public synchronized void d() {
        this.f20342a = true;
        if (this.c) {
            b();
            try {
                this.d.cancelAutoFocus();
            } catch (RuntimeException e) {
                Log.w(f, "Unexpected exception while cancelling focusing", e);
            }
        }
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public synchronized void onAutoFocus(boolean z, Camera camera) {
        this.f20343b = false;
        a();
    }
}
