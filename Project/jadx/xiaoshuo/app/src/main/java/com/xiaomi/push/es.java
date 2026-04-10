package com.xiaomi.push;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.ag;

/* JADX INFO: loaded from: classes8.dex */
public class es {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile es f7927a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f295a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private a f296a;

    public interface a {
        void a();
    }

    private es(Context context) {
        this.f295a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        a aVar;
        ag agVarA = ag.a(this.f295a);
        com.xiaomi.push.service.ba baVarA = com.xiaomi.push.service.ba.a(this.f295a);
        SharedPreferences sharedPreferences = this.f295a.getSharedPreferences("mipush_extra", 0);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = sharedPreferences.getLong("first_try_ts", jCurrentTimeMillis);
        if (j == jCurrentTimeMillis) {
            sharedPreferences.edit().putLong("first_try_ts", jCurrentTimeMillis).commit();
        }
        if (Math.abs(jCurrentTimeMillis - j) < 172800000) {
            return;
        }
        a(baVarA, agVarA, false);
        if (baVarA.a(ig.StorageCollectionSwitch.a(), true)) {
            int iA = a(baVarA.a(ig.StorageCollectionFrequency.a(), 86400));
            agVarA.a(new ev(this.f295a, iA), iA, 0);
        }
        if (j.m612a(this.f295a) && (aVar = this.f296a) != null) {
            aVar.a();
        }
        if (baVarA.a(ig.ActivityTSSwitch.a(), false)) {
            a();
        }
        a(baVarA, agVarA, true);
    }

    public static es a(Context context) {
        if (f7927a == null) {
            synchronized (es.class) {
                if (f7927a == null) {
                    f7927a = new es(context);
                }
            }
        }
        return f7927a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m328a() {
        ag.a(this.f295a).a(new et(this));
    }

    private void a(com.xiaomi.push.service.ba baVar, ag agVar, boolean z) {
        if (baVar.a(ig.UploadSwitch.a(), true)) {
            ew ewVar = new ew(this.f295a);
            if (z) {
                agVar.a((ag.a) ewVar, a(baVar.a(ig.UploadFrequency.a(), 86400)));
            } else {
                agVar.m188a((ag.a) ewVar);
            }
        }
    }

    public static int a(int i) {
        return Math.max(60, i);
    }

    private boolean a() {
        Application application;
        try {
            Context context = this.f295a;
            if (context instanceof Application) {
                application = (Application) context;
            } else {
                application = (Application) context.getApplicationContext();
            }
            application.registerActivityLifecycleCallbacks(new em(this.f295a, String.valueOf(System.currentTimeMillis() / 1000)));
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }
}
