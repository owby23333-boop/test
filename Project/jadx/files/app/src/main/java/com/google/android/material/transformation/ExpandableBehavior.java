package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.g.b;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {
    private int a;

    class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ View f16063s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ int f16064t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        final /* synthetic */ b f16065u;

        a(View view, int i2, b bVar) {
            this.f16063s = view;
            this.f16064t = i2;
            this.f16065u = bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f16063s.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.a == this.f16064t) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                b bVar = this.f16065u;
                expandableBehavior.a((View) bVar, this.f16063s, bVar.a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.a = 0;
    }

    protected abstract boolean a(View view, View view2, boolean z2, boolean z3);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        b bVar = (b) view2;
        if (!a(bVar.a())) {
            return false;
        }
        this.a = bVar.a() ? 1 : 2;
        return a((View) bVar, view, bVar.a(), true);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2) {
        b bVarA;
        if (ViewCompat.isLaidOut(view) || (bVarA = a(coordinatorLayout, view)) == null || !a(bVarA.a())) {
            return false;
        }
        this.a = bVarA.a() ? 1 : 2;
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, this.a, bVarA));
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    protected b a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view) {
        List<View> dependencies = coordinatorLayout.getDependencies(view);
        int size = dependencies.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = dependencies.get(i2);
            if (layoutDependsOn(coordinatorLayout, view, view2)) {
                return (b) view2;
            }
        }
        return null;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
    }

    private boolean a(boolean z2) {
        if (!z2) {
            return this.a == 1;
        }
        int i2 = this.a;
        return i2 == 0 || i2 == 2;
    }
}
