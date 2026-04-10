package com.google.android.material.g;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;

/* JADX INFO: compiled from: ExpandableWidgetHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    @NonNull
    private final View a;
    private boolean b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @IdRes
    private int f15422c = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public c(b bVar) {
        this.a = (View) bVar;
    }

    private void d() {
        ViewParent parent = this.a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).dispatchDependentViewsChanged(this.a);
        }
    }

    public void a(@NonNull Bundle bundle) {
        this.b = bundle.getBoolean(CallMraidJS.f8284g, false);
        this.f15422c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.b) {
            d();
        }
    }

    public boolean b() {
        return this.b;
    }

    @NonNull
    public Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(CallMraidJS.f8284g, this.b);
        bundle.putInt("expandedComponentIdHint", this.f15422c);
        return bundle;
    }

    public void a(@IdRes int i2) {
        this.f15422c = i2;
    }

    @IdRes
    public int a() {
        return this.f15422c;
    }
}
