package com.yuewen;

import android.view.View;
import androidx.annotation.IdRes;

/* JADX INFO: loaded from: classes3.dex */
public abstract class mw0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14688b;
    public boolean c;
    public View d;

    public mw0(@IdRes int i) {
        this.c = false;
        this.f14687a = i;
        this.f14688b = 0;
    }

    public View a(View view, @IdRes int i) {
        return view.findViewById(this.f14687a);
    }

    public final void b(View view) {
        this.d = view;
        d(view);
        int i = this.f14688b;
        if (i != 0) {
            view.findViewById(i).setOnClickListener(this);
        }
    }

    public void c(boolean z, View view) {
        if (this.c == z) {
            return;
        }
        this.c = z;
        if (!z) {
            View view2 = this.d;
            if (view2 != null) {
                view2.setVisibility(8);
                return;
            }
            return;
        }
        View view3 = this.d;
        if (view3 != null) {
            view3.setVisibility(0);
            return;
        }
        int i = this.f14687a;
        if (i != 0) {
            View viewA = a(view, i);
            this.d = viewA;
            if (viewA != null) {
                b(viewA);
                this.d.setVisibility(0);
            }
        }
    }

    public void d(View view) {
    }

    public mw0(@IdRes int i, @IdRes int i2) {
        this.c = false;
        this.f14687a = i;
        this.f14688b = i2;
    }
}
