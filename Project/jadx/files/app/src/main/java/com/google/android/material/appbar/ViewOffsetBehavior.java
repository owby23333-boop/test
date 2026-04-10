package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes2.dex */
class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private a a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f14975c;

    public ViewOffsetBehavior() {
        this.b = 0;
        this.f14975c = 0;
    }

    protected void a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, int i2) {
        coordinatorLayout.onLayoutChild(v2, i2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, int i2) {
        a(coordinatorLayout, v2, i2);
        if (this.a == null) {
            this.a = new a(v2);
        }
        this.a.d();
        this.a.a();
        int i3 = this.b;
        if (i3 != 0) {
            this.a.b(i3);
            this.b = 0;
        }
        int i4 = this.f14975c;
        if (i4 == 0) {
            return true;
        }
        this.a.a(i4);
        this.f14975c = 0;
        return true;
    }

    public boolean a(int i2) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.b(i2);
        }
        this.b = i2;
        return false;
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
        this.f14975c = 0;
    }

    public int a() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.c();
        }
        return 0;
    }
}
