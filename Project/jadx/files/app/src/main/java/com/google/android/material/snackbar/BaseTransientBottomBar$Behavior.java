package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;

/* JADX INFO: loaded from: classes2.dex */
public class BaseTransientBottomBar$Behavior extends SwipeDismissBehavior<View> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    private final a f15816k = new a(this);

    @Override // com.google.android.material.behavior.SwipeDismissBehavior
    public boolean a(View view) {
        return this.f15816k.a(view);
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
        this.f15816k.a(coordinatorLayout, view, motionEvent);
        return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
    }
}
