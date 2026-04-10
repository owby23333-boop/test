package com.umeng.analytics.pro;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.ArrayList;

/* JADX INFO: compiled from: BackgroundMonitor.java */
/* JADX INFO: loaded from: classes3.dex */
public class m implements Application.ActivityLifecycleCallbacks {
    private static m a = new m();
    private final int b = 3000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f19737c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f19738d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f19739e = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<n> f19740f = new ArrayList<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f19741g = new a();

    /* JADX INFO: compiled from: BackgroundMonitor.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!m.this.f19737c || !m.this.f19738d) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> still foreground.");
                return;
            }
            m.this.f19737c = false;
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> went background.");
            for (int i2 = 0; i2 < m.this.f19740f.size(); i2++) {
                ((n) m.this.f19740f.get(i2)).n();
            }
        }
    }

    private m() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.f19738d = true;
        a aVar = this.f19741g;
        if (aVar != null) {
            this.f19739e.removeCallbacks(aVar);
            this.f19739e.postDelayed(this.f19741g, com.anythink.expressad.video.module.a.a.m.ag);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f19738d = false;
        this.f19737c = true;
        a aVar = this.f19741g;
        if (aVar != null) {
            this.f19739e.removeCallbacks(aVar);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public synchronized void b(n nVar) {
        if (nVar != null) {
            for (int i2 = 0; i2 < this.f19740f.size(); i2++) {
                if (this.f19740f.get(i2) == nVar) {
                    this.f19740f.remove(i2);
                }
            }
        }
    }

    public static void a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(a);
        }
    }

    public static m a() {
        return a;
    }

    public synchronized void a(n nVar) {
        if (nVar != null) {
            this.f19740f.add(nVar);
        }
    }
}
