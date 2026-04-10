package com.yuewen;

import androidx.annotation.ColorInt;
import com.duokan.core.app.ManagedContext;
import com.duokan.core.ui.TopWindow;

/* JADX INFO: loaded from: classes12.dex */
public class cw3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @ColorInt
    public Integer f10010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10011b;
    public Boolean c;
    public boolean d;
    public boolean e = true;
    public jd0 f;

    public void a(TopWindow topWindow) {
        b(ManagedContext.h(topWindow.A()));
        e(topWindow);
    }

    public void b(xv1 xv1Var) {
        jd0 jd0Var = (jd0) xv1Var.queryFeature(jd0.class);
        this.f = jd0Var;
        if (jd0Var != null) {
            jd0Var.b4(this);
        }
    }

    public boolean c() {
        return this.f10010a != null || this.f10011b;
    }

    public void d() {
        jd0 jd0Var = this.f;
        if (jd0Var != null) {
            jd0Var.u6(this);
        }
    }

    public void e(TopWindow topWindow) {
        Boolean bool = this.c;
        if (bool != null) {
            topWindow.d0(new rd2<>(bool));
        } else {
            topWindow.d0(new rd2<>());
        }
    }
}
