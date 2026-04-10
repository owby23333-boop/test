package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.widget.ViewDragHelper;

/* JADX INFO: loaded from: classes2.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    ViewDragHelper a;
    c b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f15003c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f15005e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f15004d = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f15006f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float f15007g = 0.5f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f15008h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f15009i = 0.5f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ViewDragHelper.Callback f15010j = new a();

    class a extends ViewDragHelper.Callback {
        private int a;
        private int b = -1;

        a() {
        }

        private boolean a(@NonNull View view, float f2) {
            if (f2 == 0.0f) {
                return Math.abs(view.getLeft() - this.a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f15007g);
            }
            boolean z2 = ViewCompat.getLayoutDirection(view) == 1;
            int i2 = SwipeDismissBehavior.this.f15006f;
            if (i2 == 2) {
                return true;
            }
            if (i2 == 0) {
                if (z2) {
                    if (f2 >= 0.0f) {
                        return false;
                    }
                } else if (f2 <= 0.0f) {
                    return false;
                }
                return true;
            }
            if (i2 != 1) {
                return false;
            }
            if (z2) {
                if (f2 <= 0.0f) {
                    return false;
                }
            } else if (f2 >= 0.0f) {
                return false;
            }
            return true;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(@NonNull View view, int i2, int i3) {
            int width;
            int width2;
            int width3;
            boolean z2 = ViewCompat.getLayoutDirection(view) == 1;
            int i4 = SwipeDismissBehavior.this.f15006f;
            if (i4 == 0) {
                if (z2) {
                    width = this.a - view.getWidth();
                    width2 = this.a;
                } else {
                    width = this.a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i4 != 1) {
                width = this.a - view.getWidth();
                width2 = view.getWidth() + this.a;
            } else if (z2) {
                width = this.a;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.a - view.getWidth();
                width2 = this.a;
            }
            return SwipeDismissBehavior.a(width, i2, width2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(@NonNull View view, int i2, int i3) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(@NonNull View view) {
            return view.getWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(@NonNull View view, int i2) {
            this.b = i2;
            this.a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i2) {
            c cVar = SwipeDismissBehavior.this.b;
            if (cVar != null) {
                cVar.a(i2);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@NonNull View view, int i2, int i3, int i4, int i5) {
            float width = this.a + (view.getWidth() * SwipeDismissBehavior.this.f15008h);
            float width2 = this.a + (view.getWidth() * SwipeDismissBehavior.this.f15009i);
            float f2 = i2;
            if (f2 <= width) {
                view.setAlpha(1.0f);
            } else if (f2 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.a(0.0f, 1.0f - SwipeDismissBehavior.b(width, width2, f2), 1.0f));
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(@NonNull View view, float f2, float f3) {
            int i2;
            boolean z2;
            c cVar;
            this.b = -1;
            int width = view.getWidth();
            if (a(view, f2)) {
                int left = view.getLeft();
                int i3 = this.a;
                i2 = left < i3 ? i3 - width : i3 + width;
                z2 = true;
            } else {
                i2 = this.a;
                z2 = false;
            }
            if (SwipeDismissBehavior.this.a.settleCapturedViewAt(i2, view.getTop())) {
                ViewCompat.postOnAnimation(view, new d(view, z2));
            } else {
                if (!z2 || (cVar = SwipeDismissBehavior.this.b) == null) {
                    return;
                }
                cVar.a(view);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i2) {
            int i3 = this.b;
            return (i3 == -1 || i3 == i2) && SwipeDismissBehavior.this.a(view);
        }
    }

    class b implements AccessibilityViewCommand {
        b() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
        public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
            boolean z2 = false;
            if (!SwipeDismissBehavior.this.a(view)) {
                return false;
            }
            boolean z3 = ViewCompat.getLayoutDirection(view) == 1;
            if ((SwipeDismissBehavior.this.f15006f == 0 && z3) || (SwipeDismissBehavior.this.f15006f == 1 && !z3)) {
                z2 = true;
            }
            int width = view.getWidth();
            if (z2) {
                width = -width;
            }
            ViewCompat.offsetLeftAndRight(view, width);
            view.setAlpha(0.0f);
            c cVar = SwipeDismissBehavior.this.b;
            if (cVar != null) {
                cVar.a(view);
            }
            return true;
        }
    }

    public interface c {
        void a(int i2);

        void a(View view);
    }

    private class d implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final View f15012s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final boolean f15013t;

        d(View view, boolean z2) {
            this.f15012s = view;
            this.f15013t = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar;
            ViewDragHelper viewDragHelper = SwipeDismissBehavior.this.a;
            if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.f15012s, this);
            } else {
                if (!this.f15013t || (cVar = SwipeDismissBehavior.this.b) == null) {
                    return;
                }
                cVar.a(this.f15012s);
            }
        }
    }

    static float b(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }

    public void a(int i2) {
        this.f15006f = i2;
    }

    public boolean a(@NonNull View view) {
        return true;
    }

    public void b(float f2) {
        this.f15008h = a(0.0f, f2, 1.0f);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull MotionEvent motionEvent) {
        boolean z2 = this.f15003c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f15003c = coordinatorLayout.isPointInChildBounds(v2, (int) motionEvent.getX(), (int) motionEvent.getY());
            z2 = this.f15003c;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f15003c = false;
        }
        if (!z2) {
            return false;
        }
        a((ViewGroup) coordinatorLayout);
        return this.a.shouldInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, int i2) {
        boolean zOnLayoutChild = super.onLayoutChild(coordinatorLayout, v2, i2);
        if (ViewCompat.getImportantForAccessibility(v2) == 0) {
            ViewCompat.setImportantForAccessibility(v2, 1);
            b(v2);
        }
        return zOnLayoutChild;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper = this.a;
        if (viewDragHelper == null) {
            return false;
        }
        viewDragHelper.processTouchEvent(motionEvent);
        return true;
    }

    private void b(View view) {
        ViewCompat.removeAccessibilityAction(view, 1048576);
        if (a(view)) {
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new b());
        }
    }

    public void a(float f2) {
        this.f15009i = a(0.0f, f2, 1.0f);
    }

    private void a(ViewGroup viewGroup) {
        ViewDragHelper viewDragHelperCreate;
        if (this.a == null) {
            if (this.f15005e) {
                viewDragHelperCreate = ViewDragHelper.create(viewGroup, this.f15004d, this.f15010j);
            } else {
                viewDragHelperCreate = ViewDragHelper.create(viewGroup, this.f15010j);
            }
            this.a = viewDragHelperCreate;
        }
    }

    static float a(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    static int a(int i2, int i3, int i4) {
        return Math.min(Math.max(i2, i3), i4);
    }
}
