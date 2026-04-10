package com.bytedance.embedapplog;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class fv implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f286a = null;
    private static long dl = 0;
    private static int e = -1;
    private static final HashSet<Integer> fo = new HashSet<>(8);
    private static lk g;
    private static long gc;
    private static String m;
    private static int z;
    private final m gz;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public fv(m mVar) {
        this.gz = mVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        lk lkVarZ = z(activity.getClass().getName(), "", System.currentTimeMillis(), f286a);
        g = lkVarZ;
        lkVarZ.js = !fo.remove(Integer.valueOf(activity.hashCode())) ? 1 : 0;
        if (activity.isChild()) {
            return;
        }
        try {
            e = activity.getWindow().getDecorView().hashCode();
        } catch (Exception e2) {
            cb.g(e2);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        lk lkVar = g;
        if (lkVar != null) {
            f286a = lkVar.v;
            long jCurrentTimeMillis = System.currentTimeMillis();
            dl = jCurrentTimeMillis;
            z(g, jCurrentTimeMillis);
            g = null;
            if (activity.isChild()) {
                return;
            }
            e = -1;
        }
    }

    public static lk z(String str, String str2, long j, String str3) {
        lk lkVar = new lk();
        if (!TextUtils.isEmpty(str2)) {
            lkVar.v = str + ":" + str2;
        } else {
            lkVar.v = str;
        }
        lkVar.g = j;
        lkVar.wp = -1L;
        if (str3 == null) {
            str3 = "";
        }
        lkVar.i = str3;
        ti.z(lkVar);
        return lkVar;
    }

    public static lk z(lk lkVar, long j) {
        lk lkVar2 = (lk) lkVar.clone();
        lkVar2.g = j;
        long j2 = j - lkVar.g;
        if (j2 >= 0) {
            lkVar2.wp = j2;
        } else {
            cb.g((Throwable) null);
        }
        ti.z(lkVar2);
        return lkVar2;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        z++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (f286a != null) {
            int i = z - 1;
            z = i;
            if (i <= 0) {
                f286a = null;
                m = null;
                gc = 0L;
                dl = 0L;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        fo.remove(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        fo.add(Integer.valueOf(activity.hashCode()));
    }
}
