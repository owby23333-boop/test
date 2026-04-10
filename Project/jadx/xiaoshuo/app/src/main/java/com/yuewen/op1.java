package com.yuewen;

import android.app.Activity;
import com.duokan.adbridge.bean.CommonAdInfo;

/* JADX INFO: loaded from: classes12.dex */
public abstract class op1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public op1 f15701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Runnable f15702b;
    public Runnable c;

    public abstract boolean a(Activity activity, CommonAdInfo commonAdInfo);

    public final void b() {
        Runnable runnable = this.c;
        if (runnable != null) {
            runnable.run();
        }
    }

    public void c(CommonAdInfo commonAdInfo) {
    }

    public final void d() {
        Runnable runnable = this.f15702b;
        if (runnable != null) {
            runnable.run();
        }
    }

    public void e(CommonAdInfo commonAdInfo) {
    }

    public final void f(Runnable runnable) {
        this.c = runnable;
    }

    public void g(op1 op1Var) {
        this.f15701a = op1Var;
    }

    public final void h(Runnable runnable) {
        this.f15702b = runnable;
    }

    public final boolean i(Activity activity, CommonAdInfo commonAdInfo) {
        if (a(activity, commonAdInfo)) {
            e(commonAdInfo);
            return true;
        }
        op1 op1Var = this.f15701a;
        if (op1Var != null) {
            return op1Var.i(activity, commonAdInfo);
        }
        c(commonAdInfo);
        return false;
    }
}
