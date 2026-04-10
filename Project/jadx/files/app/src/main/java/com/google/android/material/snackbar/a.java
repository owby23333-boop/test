package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.f;

/* JADX INFO: compiled from: BaseTransientBottomBar.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {
    private f.b a;

    public a(@NonNull SwipeDismissBehavior<?> swipeDismissBehavior) {
        swipeDismissBehavior.b(0.1f);
        swipeDismissBehavior.a(0.6f);
        swipeDismissBehavior.a(0);
    }

    public boolean a(View view) {
        return view instanceof d;
    }

    public void a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                f.a().a(this.a);
            }
        } else if (actionMasked == 1 || actionMasked == 3) {
            f.a().b(this.a);
        }
    }
}
