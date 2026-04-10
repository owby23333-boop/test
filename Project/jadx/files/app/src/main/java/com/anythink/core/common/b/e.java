package com.anythink.core.common.b;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e implements Application.ActivityLifecycleCallbacks {
    public static final String a = "start_time";
    public static final String b = "end_time";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f6775c = "psid";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f6776d = "launch_mode";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f6777e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f6778f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f6779g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    JSONObject f6781i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f6784l = e.class.getName();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Handler f6782j = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Runnable f6783k = new Runnable() { // from class: com.anythink.core.common.b.e.1
        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.e.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.a();
                }
            });
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f6780h = 0;

    public e(long j2) {
        this.f6779g = j2;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.e.3
            @Override // java.lang.Runnable
            public final void run() {
                e.this.b();
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.e.2
            @Override // java.lang.Runnable
            public final void run() {
                e.this.a(jCurrentTimeMillis);
            }
        });
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

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strP = n.a().p();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(f6775c, n.a().r());
            jSONObject.put("start_time", this.f6779g);
            jSONObject.put("end_time", System.currentTimeMillis());
            jSONObject.put(f6776d, this.f6780h);
            this.f6781i = jSONObject;
            com.anythink.core.common.k.p.a(n.a().g(), g.f6799o, strP + "playRecord", jSONObject.toString());
            new StringBuilder("onActivityPaused: record leave time:").append(jSONObject.toString());
        } catch (Exception unused) {
        }
        if (com.anythink.core.c.b.a(n.a().g()).b(strP).D() == 1) {
            this.f6782j.postDelayed(this.f6783k, r2.B());
        }
        new StringBuilder("onActivityPaused: Method use time:").append(System.currentTimeMillis() - jCurrentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        if (this.f6781i != null) {
            com.anythink.core.common.k.p.a(n.a().g(), g.f6799o, n.a().p() + "playRecord", "");
            this.f6779g = 0L;
            JSONObject jSONObject = this.f6781i;
            long jOptLong = jSONObject.optLong("start_time");
            long jOptLong2 = jSONObject.optLong("end_time");
            String strOptString = jSONObject.optString(f6775c);
            int iOptInt = jSONObject.optInt(f6776d);
            this.f6781i = null;
            com.anythink.core.common.j.c.a(iOptInt == 1 ? 3 : 1, jOptLong, jOptLong2, strOptString);
            new StringBuilder("Time up to send application playTime, reset playStartTime and send agent, playtime:").append((jOptLong2 - jOptLong) / 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(long j2) {
        this.f6782j.removeCallbacks(this.f6783k);
        com.anythink.core.c.a aVarB = com.anythink.core.c.b.a(n.a().g()).b(n.a().p());
        if (this.f6781i != null) {
            JSONObject jSONObject = this.f6781i;
            long jOptLong = jSONObject.optLong("start_time");
            long jOptLong2 = jSONObject.optLong("end_time");
            String strOptString = jSONObject.optString(f6775c);
            int iOptInt = jSONObject.optInt(f6776d);
            if (System.currentTimeMillis() - jOptLong2 > aVarB.B()) {
                new StringBuilder("onActivityResumed : Time countdown is closed, time up to send agent and create new psid, playtime:").append((jOptLong2 - jOptLong) / 1000);
                com.anythink.core.common.k.p.a(n.a().g(), g.f6799o, n.a().p() + "playRecord", "");
                com.anythink.core.common.j.c.a(iOptInt == 1 ? 3 : 1, jOptLong, jOptLong2, strOptString);
                this.f6779g = 0L;
            }
        }
        this.f6781i = null;
        if (this.f6779g == 0) {
            this.f6780h = 1;
            try {
                this.f6779g = n.a().a(n.a().g(), n.a().p(), 1);
            } catch (Exception unused) {
            }
        } else {
            String strP = n.a().p();
            com.anythink.core.common.k.p.a(n.a().g(), g.f6799o, strP + "playRecord", "");
        }
        if (this.f6779g == 0) {
            this.f6779g = System.currentTimeMillis();
        }
        new StringBuilder("onActivityResumed: Method use time:").append(System.currentTimeMillis() - j2);
    }
}
