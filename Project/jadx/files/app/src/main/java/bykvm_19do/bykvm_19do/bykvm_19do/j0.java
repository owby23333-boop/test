package bykvm_19do.bykvm_19do.bykvm_19do;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class j0 implements Application.ActivityLifecycleCallbacks {
    private static int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static b0 f707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static b0 f708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f710f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Object f711g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final HashSet<Integer> f712h = new HashSet<>(8);
    private final f a;

    public j0(f fVar) {
        this.a = fVar;
    }

    public static b0 a(b0 b0Var, long j2) {
        b0 b0Var2 = (b0) b0Var.clone();
        b0Var2.a = j2;
        long j3 = j2 - b0Var.a;
        if (j3 >= 0) {
            b0Var2.f641i = j3;
        } else {
            l0.a(null);
        }
        v1.a(b0Var2);
        return b0Var2;
    }

    public static b0 a(String str, String str2, long j2, String str3) {
        b0 b0Var = new b0();
        if (!TextUtils.isEmpty(str2)) {
            str = str + ":" + str2;
        }
        b0Var.f643k = str;
        b0Var.a = j2;
        b0Var.f641i = -1L;
        if (str3 == null) {
            str3 = "";
        }
        b0Var.f642j = str3;
        v1.a(b0Var);
        return b0Var;
    }

    public static void a(Object obj) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        f712h.add(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        f712h.remove(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (f708d != null) {
            a(f711g);
        }
        b0 b0Var = f707c;
        if (b0Var != null) {
            f710f = b0Var.f643k;
            f709e = System.currentTimeMillis();
            a(f707c, f709e);
            f707c = null;
            activity.isChild();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        f707c = a(activity.getClass().getName(), "", System.currentTimeMillis(), f710f);
        f707c.f644l = !f712h.remove(Integer.valueOf(activity.hashCode())) ? 1 : 0;
        if (activity.isChild()) {
            return;
        }
        try {
            activity.getWindow().getDecorView().hashCode();
        } catch (Exception e2) {
            l0.a(e2);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        f fVar;
        b++;
        if (b != 1 || (fVar = this.a) == null) {
            return;
        }
        fVar.a(true);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (f710f != null) {
            b--;
            if (b <= 0) {
                f710f = null;
                f709e = 0L;
                f fVar = this.a;
                if (fVar != null) {
                    fVar.a(false);
                }
            }
        }
    }
}
