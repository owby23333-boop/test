package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.xiaomi.push.fi;

/* JADX INFO: loaded from: classes8.dex */
class fj implements fi.a {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected Context f387a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private PendingIntent f386a = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile long f7967a = 0;

    public fj(Context context) {
        this.f387a = null;
        this.f387a = context;
    }

    public void a(Intent intent, long j) {
        AlarmManager alarmManager = (AlarmManager) this.f387a.getSystemService(NotificationCompat.CATEGORY_ALARM);
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            this.f386a = PendingIntent.getBroadcast(this.f387a, 0, intent, 33554432);
        } else {
            this.f386a = PendingIntent.getBroadcast(this.f387a, 0, intent, 0);
        }
        if (i < 31 || j.m612a(this.f387a)) {
            bj.a((Object) alarmManager, "setExactAndAllowWhileIdle", 2, Long.valueOf(j), this.f386a);
        } else {
            alarmManager.set(2, j, this.f386a);
        }
        com.xiaomi.channel.commonutils.logger.b.c("[Alarm] register timer " + j);
    }

    private void a(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        try {
            AlarmManager.class.getMethod("setExact", Integer.TYPE, Long.TYPE, PendingIntent.class).invoke(alarmManager, 2, Long.valueOf(j), pendingIntent);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("[Alarm] invoke setExact method meet error. " + e);
        }
    }

    @Override // com.xiaomi.push.fi.a
    public void a(boolean z) {
        long jM793a = com.xiaomi.push.service.q.a(this.f387a).m793a();
        if (z || this.f7967a != 0) {
            if (z) {
                a();
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (z || this.f7967a == 0) {
                this.f7967a = jElapsedRealtime + (jM793a - (jElapsedRealtime % jM793a));
            } else if (this.f7967a <= jElapsedRealtime) {
                this.f7967a += jM793a;
                if (this.f7967a < jElapsedRealtime) {
                    this.f7967a = jElapsedRealtime + jM793a;
                }
            }
            Intent intent = new Intent(com.xiaomi.push.service.bk.q);
            intent.setPackage(this.f387a.getPackageName());
            a(intent, this.f7967a);
        }
    }

    @Override // com.xiaomi.push.fi.a
    public void a() {
        if (this.f386a != null) {
            try {
                ((AlarmManager) this.f387a.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.f386a);
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f386a = null;
                com.xiaomi.channel.commonutils.logger.b.c("[Alarm] unregister timer");
                this.f7967a = 0L;
                throw th;
            }
            this.f386a = null;
            com.xiaomi.channel.commonutils.logger.b.c("[Alarm] unregister timer");
            this.f7967a = 0L;
        }
        this.f7967a = 0L;
    }

    @Override // com.xiaomi.push.fi.a
    /* JADX INFO: renamed from: a */
    public boolean mo430a() {
        return this.f7967a != 0;
    }
}
