package com.king.zxing.camera;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import anet.channel.entity.ConnType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: AutoFocusManager.java */
/* JADX INFO: loaded from: classes2.dex */
final class a implements Camera.AutoFocusCallback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Collection<String> f16458f = new ArrayList(2);
    private boolean a;
    private boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f16459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Camera f16460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AsyncTask<?, ?, ?> f16461e;

    /* JADX INFO: renamed from: com.king.zxing.camera.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AutoFocusManager.java */
    private static class AsyncTaskC0336a extends AsyncTask<Object, Object, Object> {
        private WeakReference<a> a;

        public AsyncTaskC0336a(a aVar) {
            this.a = new WeakReference<>(aVar);
        }

        @Override // android.os.AsyncTask
        protected Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(1200L);
            } catch (InterruptedException unused) {
            }
            a aVar = this.a.get();
            if (aVar == null) {
                return null;
            }
            aVar.a();
            return null;
        }
    }

    static {
        f16458f.add(ConnType.PK_AUTO);
        f16458f.add("macro");
    }

    a(Context context, Camera camera) {
        this.f16460d = camera;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String focusMode = camera.getParameters().getFocusMode();
        this.f16459c = defaultSharedPreferences.getBoolean("preferences_auto_focus", true) && f16458f.contains(focusMode);
        com.king.zxing.r.b.b("Current focus mode '" + focusMode + "'; use auto focus? " + this.f16459c);
        a();
    }

    private synchronized void c() {
        if (!this.a && this.f16461e == null) {
            AsyncTaskC0336a asyncTaskC0336a = new AsyncTaskC0336a(this);
            try {
                asyncTaskC0336a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                this.f16461e = asyncTaskC0336a;
            } catch (RejectedExecutionException e2) {
                com.king.zxing.r.b.a("Could not request auto focus", e2);
            }
        }
    }

    private synchronized void d() {
        if (this.f16461e != null) {
            if (this.f16461e.getStatus() != AsyncTask.Status.FINISHED) {
                this.f16461e.cancel(true);
            }
            this.f16461e = null;
        }
    }

    synchronized void a() {
        if (this.f16459c) {
            this.f16461e = null;
            if (!this.a && !this.b) {
                try {
                    this.f16460d.autoFocus(this);
                    this.b = true;
                } catch (RuntimeException e2) {
                    com.king.zxing.r.b.a("Unexpected exception while focusing", e2);
                    c();
                }
            }
        }
    }

    synchronized void b() {
        this.a = true;
        if (this.f16459c) {
            d();
            try {
                this.f16460d.cancelAutoFocus();
            } catch (RuntimeException e2) {
                com.king.zxing.r.b.a("Unexpected exception while cancelling focusing", e2);
            }
        }
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public synchronized void onAutoFocus(boolean z2, Camera camera) {
        this.b = false;
        c();
    }
}
